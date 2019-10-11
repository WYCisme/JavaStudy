package com.wyc.rpcService;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: javaStudy
 * @className: RpcServer
 * @author: WenYichong
 * @date: 2019/9/17-21:03
 * @description: 连我自己都不知道在写什么......
 */
public class RpcServer {
    //存放指定包中所有实现类的类名
    private List<String> classCache = new ArrayList<String>();
    //服务注册表
    private Map<String,Object>registerMap =new HashMap<String, Object>();

    //将指定包下的实现类(提供者)发布出去
    public void publish(String providerPackage) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        //将指定包下的提供者名称写入到calssCache中
        getProviderClass(providerPackage);
        //将接口(服务名称) 与提供者实例之间的映射关系写入registerMap中
        doRegister();
        //完成对客户端调用请求的处理(调用提供者对应的方法)
        EventLoopGroup parentGroup=new NioEventLoopGroup();
        EventLoopGroup childGroup=new NioEventLoopGroup();
        try{
        ServerBootstrap bootstrap=new ServerBootstrap();
        bootstrap.group(parentGroup,childGroup)
        //指定用户存放客户端请求的队列的长度
                .option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .channel(NioSctpServerChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline =ch.pipeline();
                        pipeline.addLast(new ObjectEncoder());
                        pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE,ClassResolvers.cacheDisabled(null)));
                        pipeline.addLast(new RpcServerHandler(registerMap));
                    }
                });
                ChannelFuture future = bootstrap.bind(8888);
                System.out.println("微服务已注册成功，端口号8888");
                future.channel().closeFuture().sync();
            }finally{
                parentGroup.shutdownGracefully();
                childGroup.shutdownGracefully();
        }

    }

    private void getProviderClass(String providerPackage) {
        URL resource = this.getClass().getClassLoader().getResource(providerPackage.replaceAll("\\.","/"));
        File dir = new File(resource.getFile());
        for (File file : dir.listFiles()){
            if (file.isDirectory()){//如果当前遍历到目录,则继续递归
                getProviderClass(providerPackage + "." + file.getName());
            }else if (file.getName().endsWith(".class")){
                //获取去掉。class的扩展的简单类名
                String fileName = file.getName().replace(".class","").trim();
                classCache.add(providerPackage + "." + fileName);
            }
        }
    }

    private void doRegister() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(classCache.size()==0)return;
        //registerMapi的key为接口名,value为该接口对应的实现类的实例
        for (String className : classCache){
            Class<?> clazz= Class.forName(className);
            Class<?> interfaces[]=clazz.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                String interfaceName=anInterface.getName();
                registerMap.put(interfaceName,clazz.getInterfaces());
            }
        }
    }

}
