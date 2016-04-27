SUMMARY = "ScopeServer"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

DEPENDS = "protobuf-c"

inherit cmake

SRCREV = "${AUTOREV}"
SRC_URI = "gitsm://github.com/garekkream/scopeserver.git;protocol=http "
SRC_URI += "file://cmake.patch"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 scope_server ${D}${bindir}
}
