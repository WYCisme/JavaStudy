package com.wyc.RpcClient;

import io.netty.channel.nio.NioEventLoopGroup;
import jdk.nashorn.internal.runtime.linker.Bootstrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @projectName: javaStudy
 * @className: RpcProxy
 * @author: WenYichong
 * @date: 2019/9/19-22:18
 * @description: 连我自己都不知道在写什么......
 */
public class RpcProxy {
    public static <T> T create(final Class<?> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (Object.class.equals(method.getDeclaringClass())) {
                            return method.invoke(this, args);
                        }
                        return rpcInvoke(clazz, method, args);
                    }
                }
        );
    }

    private static Object rpcInvoke(Class<?> clazz, Method method, Object[] args)
        throws InterruptedException{
        RpcClientHandler handler = new RpcClientHandler();
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();


        return null;
    }
}
