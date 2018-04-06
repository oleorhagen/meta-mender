FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

MENDER_DEMO_WIFI_SSID ?= "ssid"
MENDER_DEMO_WIFI_PASSKEY ?= "password"

FILES_${PN} += "${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf"

do_install_append() {

             # Create the needed directory on the device if not existent.
             install -d ${D}${sysconfdir}/wpa_supplicant

             # Create the supplicant.conf file.
             wpa_passphrase ${MENDER_DEMO_WIFI_SSID } ${MENDER_DEMO_WIFI_PASSKEY } > ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-nl80211-wlan0.conf

             # Make sure the system directory for systemd exists.
             install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/

             # Link the service file for autostart.
             ln -s ${systemd_unitdir}/system/wpa_supplicant-nl80211@wlan0.service \
             ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant-nl80211@wlan0.service

}
