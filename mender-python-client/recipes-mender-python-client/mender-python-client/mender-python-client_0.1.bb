SUMMARY = "A Python implementation of the Mender client interface"
HOMEPAGE = "https://github.com/mendersoftware/mender-python-client"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
FILES_${PN}_append = " ${bindir}mender-sub-updater \
         /var/lib/mender/install \
         ${systemd_unitdir}/system/mender-sub-updater.service"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f45908b2c92866a1973f8fba5318cd70"

SRC_URI = "gitsm://git@github.com/oleorhagen/mender-python-client.git;protocol=ssh;branch=master \
           file://mender-sub-updater \
           file://mender-sub-updater.service"

PV = "0.0.1+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

SYSTEMD_SERVICE_${PN} = "mender-sub-updater.service"
SYSTEMD_AUTO_ENABLE = "enable"

DEPENDS += " mender-client"

RDEPENDS_${PN} += "python3-core bash"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/mender-sub-updater ${D}${bindir}/mender-sub-updater
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/mender-sub-updater.service ${D}${systemd_unitdir}/system
}
