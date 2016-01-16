require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "beaglebone-rt"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_beaglebone-rt = " \
    am335x-boneblack.dtb \
    bbb-hdmi.dtb \
    bbb-nohdmi.dtb \
    bbb-4dcape70t.dtb \
    bbb-nh5cape.dtb \
 "

SRC_URI[md5sum] = "f766ab67c10f32aa4129efa0a1815095"
SRC_URI[sha256sum] = "100e0491d058358b22c101f7e2a87693423598461c908294ce69c4aaf351ab9d"

LINUX_VERSION = "4.4"
LINUX_VERSION_EXTENSION = "-rt"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.4:"

S = "${WORKDIR}/git"

#https://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=master

PR = "r2"
# v4.4.0-rc6

SRCREV = "4ef7675344d687a0ef5b0d7c0cee12da005870c0"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=master;protocol=https \
    file://defconfig \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://0002-dts-Revoke-Beaglebone-i2c2-definitions.patch \
    file://0003-Add-ft5x06_ts-touchscreen-driver.patch  \
    file://0004-dts-Add-custom-bbb-dts-files.patch \
    file://patch-4.4-rc6-rt1.patch \
 "

