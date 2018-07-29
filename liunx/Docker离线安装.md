#rpm离线安装docker17.12
*   rpm离线安装docker17.12
    *   在https://download.docker.com/linux/centos/7/x86_64/stable/Packages/下载docker-ce-17.12.0.ce-1.el7.centos.x86_64.rpm
*   下载9个依赖
    *   在http://mirrors.163.com/centos/7/os/x86_64/Packages/下载8个依赖
    *   audit-libs-python-2.7.6-3.el7.x86_64.rpm
    *   checkpolicy-2.5-4.el7.x86_64.rpm
    *   libcgroup-0.41-13.el7.x86_64.rpm
    *   libseccomp-2.3.1-3.el7.x86_64.rpm
    *   libsemanage-python-2.5-8.el7.x86_64.rpm
    *   policycoreutils-python-2.5-17.1.el7.x86_64.rpm
    *   python-IPy-0.75-6.el7.noarch.rpm
    *   setools-libs-3.3.8-1.1.el7.x86_64.rpm
    *   在http://rpm.pbone.net/index.php3?stat=3&limit=1&srodzaj=1&dl=40&search=container-selinux&field[]=1&field[]=2下载container-selinux-2.9-4.el7.noarch.rpm
    *   下载链接：ftp://mirror.switch.ch/pool/4/mirror/scientificlinux/7x/external_products/extras/x86_64/container-selinux-2.9-4.el7.noarch.rpm
*   安装
    *   将8个依赖复制到服务器上如：/root/docker/
    *   将docker-ce-17.12.0.ce-1.el7.centos.x86_64.rpm和container-selinux-2.9-4.el7.noarch.rpm复制到/root/docker/rpm/
    *   rpm -ivh /root/docker/*.rpm  --force --nodeps
    *   rpm -ivh /root/docker/rpm/container-selinux-2.9-4.el7.noarch.rpm  --force --nodeps
    *   rpm -ivh /root/docker/rpm/docker-ce-17.12.0.ce-1.el7.centos.x86_64.rpm  --force --nodeps
*   启动
    *   service docker start
        
    *   docker -v
    
#无网络环境下使用docker加载镜像
*   先从一个有网络的电脑下载docker镜像
    *   docker pull centos
*   保存镜像到本地文件
    *   docker save -o centos_image.docker centos
*   把镜像拷贝到无网络的电脑，然后通过docker加载镜像即可。
    *   docker load -i centos_image.docker
    


####docker在线安装
*   Docker 要求 CentOS 系统的内核版本高于 3.10 ，查看本页面的前提条件来验证你的
    CentOS 版本是否支持 Docker 。
    通过 uname -r 命令查看你当前的内核版本
    *   $ uname -r
*   使用 root 权限登录 Centos。确保 yum 包更新到最新。
    *   yum -y update
*   卸载旧版本(如果安装过旧版本的话)
    *   yum remove docker docker-common docker-selinux docker-engine
*   安装需要的软件包， yum-util 提供yum-config-manager功能，另外两个是
        devicemapper驱动依赖的
    *   yum install -y yum-utils device-mapper-persistent-data lvm2
*   设置yum源
    *   yum-config-manager --add-repo
         https://download.docker.com/linux/centos/docker-ce.repo
*   可以查看所有仓库中所有docker版本，并选择特定版本安装
    *   yum list docker-ce --showduplicates | sort -r
*   安装docker
    *   sudo yum install docker-ce #由于repo中默认只开启stable仓库，故这里安装的是最
        新稳定版18.03.1
    *   sudo yum install <FQPN> # 例如：sudo yum install docker-ce-18.03.1.ce
*   启动并加入开机启动
    ```
    systemctl start docker
    systemctl enable docker
    ```
*   验证安装是否成功(有client和service两部分表示docker安装启动都成功了)
    *    docker version
*   卸载docker
    *   yum -y remove docker-engine
*   注意：需要配置镜像加速器
    我们可以借助阿里云的镜像加速器，登录阿里云
    (https://cr.console.aliyun.com/#/accelerator)
    可以看到镜像加速地址如下图：
cd /etc/docker
查看有没有 daemon.json。这是docker默认的配置文件。
如果没有新建，如果有，则修改。
vim daemon.json
{
"registry-mirrors": ["https://m9r2r2uj.mirror.aliyuncs.com"]
}
保存退出。
*   重启docker服务
    *   service docker restart
    
