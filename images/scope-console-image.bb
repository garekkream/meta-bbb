SUMMARY = "A console development image with some C/C++ dev tools"
HOMEPAGE = "http://www.jumpnowtek.com"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    psplash \
    term-prompt \
    tzdata \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
    load-modules \
 "

WIFI_SUPPORT = " \
    iw \
    linux-firmware-ath9k \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    wireless-tools \
    wpa-supplicant \
 "

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-modules \
    glibc \
 "

DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
    serialecho \
    spiloop \
    zeromq \
    zeromq-dev \
 "

EXTRA_TOOLS_INSTALL = " \
    bc \
    bzip2 \
    cursor-blink \
    devmem2 \
    dosfstools \
    emmc-installer \
    ethtool \
    findutils \
    i2c-tools \
    iftop \
    iperf \
    htop \
    less \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    vim-tiny \
    wget \
    zip \
    scopeserver \
 "

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${WIFI_SUPPORT} \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
 "

export IMAGE_BASENAME = "scope-console-image"

