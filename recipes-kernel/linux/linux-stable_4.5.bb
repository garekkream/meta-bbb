require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "beaglebone"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE_beaglebone = " \
    am335x-boneblack.dtb \
 "

LINUX_VERSION = "4.5"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.5:"

S = "${WORKDIR}/git"

PR = "r2"

# v4.5
SRCREV = "b562e44f507e863c6792946e4e1b1449fbbac85d"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.5.y;protocol=https \
    file://defconfig \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://0001-BBB-MPU9255-node-added-to-i2c-2.patch \
 "
