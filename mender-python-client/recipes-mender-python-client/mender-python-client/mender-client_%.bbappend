SYSTEMD_AUTO_ENABLE = "disable"

FILES_${PN} += "${datadir}/mender/install"

do_install_append() {
    if ${@bb.utils.contains('MENDER_FEATURES', 'mender-image', 'true', 'false', d)}; then
        ln -s ${bindir}/mender-sub-updater ${D}${datadir}/mender/install
    fi
}