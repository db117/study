package org.proxy;

import org.junit.Test;

/**
 * @author 大兵
 * @date 2018-08-27 22:35
 **/
public class ProxyTest {
    @Test
    public void proxy() {
        ProxyInterface proxyInterface = new ProxyInterfaceImpl();

        proxyInterface = (ProxyInterface) new DynamicProxy().getInstance(proxyInterface);

        proxyInterface.sayHello();

        proxyInterface.sayBey();
    }
}
