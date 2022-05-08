package com.atguigu.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class Demo {



    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.addResource("hbase-site.xml");
//        conf.addResource("hdfs-site.xml");
//        conf.addResource("yarn-site.xml");
//        conf.addResource("mapred-site.xml");

        try {
            FileSystem fileSystem = FileSystem.get(conf);
            for (FileStatus fileStatus : fileSystem.listStatus(new Path("/"))) {
                System.out.println(fileStatus.getPath().toString());
                System.out.println(fileStatus.getPath().toUri());
            }
        } catch (IOException e) {

            System.out.println("get file system error"+e);
        }

    }

}
