##在线
*   用MySQL数据库安装存储库(数据库另装)
    *   rpm -i http://repo.zabbix.com/zabbix/3.4/rhel/7/x86_64/zabbix-release-3.4-2.el7.noarch.rpm
*   安装ZabBix服务器，前端，代理
    *   yum install zabbix-server-mysql zabbix-web-mysql zabbix-agent
*   创建初始数据库
    *   mysql -uroot -p
    *   password
    *   mysql> create database zabbix character set utf8 collate utf8_bin;
    *   mysql> grant all privileges on zabbix.* to zabbix@localhost identified by 'password';
    *   mysql> quit;
*   导入初始模式和数据。将提示您输入新创建的密码。
    *   zcat /usr/share/doc/zabbix-server-mysql*/create.sql.gz | mysql -uzabbix -p zabbix
*   为ZabBIX服务器配置数据库
    *   编辑文件 /etc/zabbix/zabbix_server.conf
        *   DBPassword=password
*   为ZabBIX前端配置PHP
    *   编辑文件 /etc/httpd/conf.d/zabbix.conf
        *   php_value date.timezone Asia/Shanghai
*   启动ZabBIX服务器和代理进程
    *   systemctl restart zabbix-server zabbix-agent httpd
    *   systemctl enable zabbix-server zabbix-agent httpd
*   然后就可以访问了ip/zabbix
    *   默认帐号密码Admin/zabbix
    
###修改为中文
*   打开Zabbix界面，Administrator-Users 选择语言-Chinese(zh_CN)-update 
*   解决乱码
    *   从Window服务器找到相应的字休复制到zabbix Server服务器上：
    
         控制面板-->字体-->选择一种中文字库例如“楷体”（simkai.ttf）
    *   将我们选择的字体文件上传到zabbix web服务，/usr/share/zabbix/fonts目录下（rpm安装目录）
    *   修改此/usr/share/zabbix/include/defines.inc.php文件中字体的配置，
        将里面关于字体设置从graphfont替换成simkai
        *   define('ZBX_GRAPH_FONT_NAME',           'simkai'); // font file name
