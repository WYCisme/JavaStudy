package com.wyc.rpcService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

/**
 * @projectName: javaStudy
 * @className: RpcServerHandler
 * @author: WenYichong
 * @date: 2019/9/17-21:47
 * @description: 连我自己都不知道在写什么......
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<InvokMessage> {

    private Map<String,Object> registerMap;
    public RpcServerHandler(Map<String,Object> registerMap){
        this.registerMap=registerMap;
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx,
                                InvokMessage msg) throws Exception {
        Object result="提供者没有该方法";
        if (registerMap.containsKey(msg.getClassName())){
            Object provider = registerMap.get(msg.getClassName());
            result=provider.getClass()
                    .getMethod(msg.getClassName(),
                            msg.getParamTypes())
                    .invoke(provider,msg.getParamValues());
        }
        ctx.writeAndFlush(result);
        ctx.close();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
