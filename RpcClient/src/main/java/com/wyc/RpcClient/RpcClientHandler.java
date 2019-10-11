package com.wyc.RpcClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @projectName: javaStudy
 * @className: RpcClientHandler
 * @author: WenYichong
 * @date: 2019/9/19-22:28
 * @description: 自定义 客户端处理器......
 */
public class RpcClientHandler  extends SimpleChannelInboundHandler<Object> {

    private Object result;

    public Object getResult() {
        return result;
    }
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        this.result=msg;

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
