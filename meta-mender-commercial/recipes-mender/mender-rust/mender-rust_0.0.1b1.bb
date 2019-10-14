LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

SRC_URI = "file:///home/olepor/misc/rust/Mender-Rust/target/x86_64-unknown-linux-gnu/debug/mender-rust"

# SYSTEMD_SERVICE_${PN} = "mender-rust.service"

# "lsb" is needed because Yocto by default does not provide a cross platform
# dynamic linker. On x86_64 this manifests as a missing
# `/lib64/ld-linux-x86-64.so.2`
RDEPENDS_${PN} = "lsb xz openssl10"

FILES_${PN} = " \
    ${sysconfdir}/mender/mender-rust \
    ${bindir}/mender-rust \
"

INSANE_SKIP_${PN} = "already-stripped"

do_install() {
    # install -d -m 755 ${D}${datadir}/mender/modules/v3
    # install -m 755 ${WORKDIR}/mender-binary-delta ${D}${datadir}/mender/modules/v3/mender-binary-delta

    cp ${WORKDIR}/home/olepor/misc/rust/Mender-Rust/target/x86_64-unknown-linux-gnu/debug/mender-rust ${WORKDIR}/

    install -d -m 755 ${D}${sysconfdir}/mender
    install -m 755 ${WORKDIR}/mender-rust ${D}${sysconfdir}/mender/mender-rust

    install -d -m 755 ${D}${bindir}
    install -m 755 ${WORKDIR}/mender-rust ${D}${bindir}
}
