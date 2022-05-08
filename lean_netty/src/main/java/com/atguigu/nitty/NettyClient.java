package com.atguigu.nitty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        //客户端需要一个事件循环组

        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();

        //后才能关键客户端启动对象
        //注意客户端使用的不是ServerBootStrap而是BootStrap

        Bootstrap bootstrap = new Bootstrap();

        //设置相关参数
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(null); // 客户端加入处理器
                    }
                });

        //客户端链接服务器
        ChannelFuture sync = bootstrap.connect("127.0.0.1", 6668).sync();
        // 给关闭通道进行监听
        ChannelFuture sync1 = sync.channel().closeFuture().sync();


    }
}
