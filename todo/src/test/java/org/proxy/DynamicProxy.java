package org.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 *
 * @author 大兵
 * @date 2018-08-27 22:31
 **/
public class DynamicProxy implements InvocationHandler {
    private ProxyInterface proxyInterface;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前：方法：" + method.getName());

        method.invoke(proxyInterface, args);
        System.out.println("调用后");
        return null;
    }

    /**
     * 获取代理后的实例
     *
     * @param target 代理对象
     * @return 新生产的代理对象
     */
    public Object getInstance(ProxyInterface target) {
        this.proxyInterface = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
}
