package com.zeus.io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author xuxingbo
 * @Date 2018/1/7
 */
public class GZIPCompress {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("please input the source file name");
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream("test.gz")));
        System.out.println("write file start");
        int c;
        while( (c = in.read()) != -1){
            out.write(c);
        }
        System.out.println("write file finish");
        in.close();
        out.close();
        
        BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(
                                new FileInputStream("test.gz")
                        )));
        String s;
        while((s = input.readLine()) != null){
            System.out.println(s);
        }
    }
}
