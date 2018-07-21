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
    
##docker mysql操作
*   配置
    *   -p 3306:3306：
        *   将容器的 3306 端口映射到主机的 3306 端口。
    *   -v -v $PWD/conf:/etc/mysql/conf.d：
        *   将主机当前目录下的 conf/my.cnf 挂载到容器的 /etc/mysql/my.cnf。
    *   -v $PWD/logs:/logs：
        *   将主机当前目录下的 logs 目录挂载到容器的 /logs。
    *   -v $PWD/data:/var/lib/mysql ：
        *   将主机当前目录下的data目录挂载到容器的 /var/lib/mysql 。
    *   -e MYSQL_ROOT_PASSWORD=123456：
        *   初始化 root 用户的密码。
        
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.6.35



####Docker容器开机自动启动
   --restart具体参数值详细信息：
       no -  容器退出时，不重启容器；

       on-failure - 只有在非0状态退出时才从新启动容器；

       always - 无论退出状态是如何，都重启容器；




如果创建时未指定 --restart=always ,可通过update 命令设置

docker update --restart=always xxx 