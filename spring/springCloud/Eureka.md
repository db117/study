####Eureka Server相关配置
*   在默认配置下，Eureka Server会将自己也作为客户端来尝试注册自己，我们需要禁用它的客户端禁用行为。
    下面是一个Eureka Server的application.properites的相关配置：

*   服务注册中心端口号
    *   server.port=1110

*   服务注册中心实例的主机名
    *   eureka.instance.hostname=localhost

*   是否向服务注册中心注册自己
    *   eureka.client.register-with-eureka=false

*   是否检索服务
    *   eureka.client.fetch-registry=false

*   服务注册中心的配置内容，指定服务注册中心的位置
    *   eureka.client.serviceUrl.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/