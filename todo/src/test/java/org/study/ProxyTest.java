package org.study;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author 大兵
 * @date 2018-07-01 16:41
 **/
public class ProxyTest {

    @Test
    public void proxy() {
        ProxyImpl proxyImpl = new ProxyImpl();
        Proxy1 proxy1 = (Proxy1) Proxy.newProxyInstance(Proxy1.class.getClassLoader(), new Class[]{Proxy1.class}, (proxy, method, args) -> {
            System.out.println("前置");
            try {
                method.invoke(proxyImpl, args);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
                System.out.println("异常");
            }
            System.out.println("后置");
            return null;
        });
        proxy1.sout();
    }

    interface Proxy1 {
        void sout();
    }

    class ProxyImpl implements Proxy1 {
        @Override
        public void sout() {
            System.out.println("***************");
        }
    }
}
