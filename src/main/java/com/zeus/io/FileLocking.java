package com.zeus.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author xuxingbo
 * @Date 2018/1/7
 * 文件Channel上加锁
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null){
            System.out.println("Locking file");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println("Release Lock");
        }
        fos.close();
    }
}
