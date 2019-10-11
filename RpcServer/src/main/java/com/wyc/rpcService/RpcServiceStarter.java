package com.wyc.rpcService;

/**
 * @projectName: javaStudy
 * @className: RpcServiceStarter
 * @author: WenYichong
 * @date: 2019/9/19-22:00
 * @description: 连我自己都不知道在写什么......
 */
public class RpcServiceStarter {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, InterruptedException, IllegalAccessException {
        new RpcServer().publish("com.wyc.api");
    }
//com.wyc.api
}
