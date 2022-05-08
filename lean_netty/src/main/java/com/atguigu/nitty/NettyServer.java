package com.atguigu.nitty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {




    public static void main(String[] args) throws InterruptedException {


        //创建BossGroup和workGroup
        //1、创建两个线程，bossGroup workerGroup
        //2、bossGroup 只是处理链接请求，真正的和客户端业务处理，会交给wirkerGroup完成
        //3、bossGroup 和 workGroup 含有子线程
        //只处理链接请求
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        //真正处理客户端业务处理
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        //创建服务端的启动对象，配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 使用链式编程进行设置
        bootstrap.group(bossGroup,workerGroup) // 设置两个线程组
                .channel(NioServerSocketChannel.class) //使用NioSocketChannel 作为服务器的通道实现
                .option(ChannelOption.SO_BACKLOG,128) // 设置线程队列得到链接的个数
                .childOption(ChannelOption.SO_KEEPALIVE,true) // 设置保持活动链接状态
                .childHandler(new ChannelInitializer<SocketChannel>() { // 创建一个通道测试对象

                    //给pipeline 设置处理器
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                        ch.pipeline().addLast(new NettyServerHandler());

                    }
                });
        System.out.println("服务器准备好了，开始准备端口");
        ChannelFuture cf = bootstrap.bind(6668).sync();

        //对关闭通道进行监听
        cf.channel().closeFuture().sync();


    }
}
