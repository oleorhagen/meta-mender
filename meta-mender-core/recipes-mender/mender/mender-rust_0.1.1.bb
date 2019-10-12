inherit cargo

LICENSE = "CLOSED"
LICENSE_FLAGS = "commercial"

RDEPENDS_mender-rust = "openssl libssl"

DEPENDS_mender-rust = "libssl openssl libssl-dev"

SRC_URI = "git:///home/olepor/misc/rust/Mender-Rust;protocol=file;branch=master"
SRC_URI[md5sum] = "e9335536da6a611bd1ef58e64d3b9b88"
SRC_URI[sha256sum] = "b56b4b60ceaaa39440b59d32877f550601d2f4d5a437c1367aa3fe51aa9b1c13"

S = "${WORKDIR}/git"

SRCREV = "1b50628f2afea7916fb98440820838823a2166ae"