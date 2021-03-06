##docker命令 
####run
```docker run [OPTIONS] IMAGE [COMMAND] [ARG...]```
*   OPTIONS说明：
    *   -a stdin: 指定标准输入输出内容类型，可选 STDIN/STDOUT/STDERR 三项；
    *   -d: 后台运行容器，并返回容器ID；
    *   -i: 以交互模式运行容器，通常与 -t 同时使用；
    *   -p: 端口映射，格式为：主机(宿主)端口:容器端口
    *   -t: 为容器重新分配一个伪输入终端，通常与 -i 同时使用；
    *   --name="nginx-lb": 为容器指定一个名称；
    *   --dns 8.8.8.8: 指定容器使用的DNS服务器，默认和宿主一致；
    *   --dns-search example.com: 指定容器DNS搜索域名，默认和宿主一致；
    *   -h "mars": 指定容器的hostname；
    *   -e username="ritchie": 设置环境变量；
    *   --env-file=[]: 从指定文件读入环境变量；
    *   --cpuset="0-2" or --cpuset="0,1,2": 绑定容器到指定CPU运行；
    *   -m :设置容器使用内存最大值；
    *   --net="bridge": 指定容器的网络连接类型，支持 bridge/host/none/container: 四种类型；
    *   --link=[]: 添加链接到另一个容器；
    *   --expose=[]: 开放一个端口或一组端口；
####rm 删除一个或多少容器
```docker rm [OPTIONS] CONTAINER [CONTAINER...]```
*   OPTIONS说明：
    
    -f :通过SIGKILL信号强制删除一个运行中的容器
    
    -l :移除容器间的网络连接，而非容器本身
    
    -v :-v 删除与容器关联的卷
####exec ：在运行的容器中执行命令
```docker exec [OPTIONS] CONTAINER COMMAND [ARG...]```
*   OPTIONS说明：
    
    -d :分离模式: 在后台运行
    
    -i :即使没有附加也保持STDIN 打开
    
    -t :分配一个伪终端
####ps : 列出容器
```docker ps [OPTIONS]```
*   OPTIONS说明：
    
    -a :显示所有的容器，包括未运行的。
    
    -f :根据条件过滤显示的内容。
    
    --format :指定返回值的模板文件。
    
    -l :显示最近创建的容器。
    
    -n :列出最近创建的n个容器。
    
    --no-trunc :不截断输出。
    
    -q :静默模式，只显示容器编号。
    
    -s :显示总的文件大小。
####cp :用于容器与主机之间的数据拷贝。
    ```docker cp [OPTIONS] CONTAINER:SRC_PATH DEST_PATH|-```
    ```docker cp [OPTIONS] SRC_PATH|- CONTAINER:DEST_PATH ```

####images : 列出本地镜像。
    ```docker images [OPTIONS] [REPOSITORY[:TAG]]```
*   OPTIONS说明：
    
    -a :列出本地所有的镜像（含中间映像层，默认情况下，过滤掉中间映像层）；
    
    --digests :显示镜像的摘要信息；
    
    -f :显示满足条件的镜像；
    
    --format :指定返回值的模板文件；
    
    --no-trunc :显示完整的镜像信息；
    
    -q :只显示镜像ID。

#### rmi : 删除本地一个或多少镜像。
*   ```docker rmi [OPTIONS] IMAGE [IMAGE...]```
*   OPTIONS说明：
    
    -f :强制删除；
    
    --no-prune :不移除该镜像的过程镜像，默认移除；
    
#### build 命令用于使用 Dockerfile 创建镜像。
*   ```docker build [OPTIONS] PATH | URL | -```
*   OPTIONS说明：
    
    --build-arg=[] :设置镜像创建时的变量；
    
    --cpu-shares :设置 cpu 使用权重；
    
    --cpu-period :限制 CPU CFS周期；
    
    --cpu-quota :限制 CPU CFS配额；
    
    --cpuset-cpus :指定使用的CPU id；
    
    --cpuset-mems :指定使用的内存 id；
    
    --disable-content-trust :忽略校验，默认开启；
    
    -f :指定要使用的Dockerfile路径；
    
    --force-rm :设置镜像过程中删除中间容器；
    
    --isolation :使用容器隔离技术；
    
    --label=[] :设置镜像使用的元数据；
    
    -m :设置内存最大值；
    
    --memory-swap :设置Swap的最大值为内存+swap，"-1"表示不限swap；
    
    --no-cache :创建镜像的过程不使用缓存；
    
    --pull :尝试去更新镜像的新版本；
    
    --quiet, -q :安静模式，成功后只输出镜像 ID；
    
    --rm :设置镜像成功后删除中间容器；
    
    --shm-size :设置/dev/shm的大小，默认值是64M；
    
    --ulimit :Ulimit配置。
    
    --tag, -t: 镜像的名字及标签，通常 name:tag 或者 name 格式；可以在一次构建中为一个镜像设置多个标签。
    
    --network: 默认 default。在构建期间设置RUN指令的网络模式

####进入容器
```docker container exec -it f0b1c8ab3633 /bin/bash```

####docker mysql操作
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
        

```docker run -p 3307:3306 --name mymysql -v $PWD/conf:/etc/mysql/conf.d -v $PWD/logs:/logs -v $PWD/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7``` 

####Docker容器开机自动启动
   --restart具体参数值详细信息：
       no -  容器退出时，不重启容器；

       on-failure - 只有在非0状态退出时才从新启动容器；

       always - 无论退出状态是如何，都重启容器；




如果创建时未指定 --restart=always ,可通过update 命令设置

docker update --restart=always xxx

