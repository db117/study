package org.proxy;

/**
 * 接口实现类
 *
 * @author 大兵
 * @date 2018-08-27 22:30
 **/
public class ProxyInterfaceImpl implements ProxyInterface {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayBey() {
        System.out.println("bey");
    }
}
