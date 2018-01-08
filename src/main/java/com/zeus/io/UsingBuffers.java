package com.zeus.io;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author xuxingbo
 * @Date 2018/1/7
 * 展示Buffer中指针位置的变化
 */
public class UsingBuffers {
    /**
     * 将每两个字节的位置进行交换
     * @param buffer
     */
    private static void symmetricScramble(CharBuffer buffer){
        while (buffer.hasRemaining()) {
            printPointer(buffer);
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }
    
    private static void printPointer(Buffer buffer){
        String name = buffer.getClass().getSimpleName();
        System.out.println("[" + name + "]   " +
                "pos=" + buffer.position() + ","
                +"limit=" + buffer.limit() +","
                + "cap=" + buffer.capacity());
    }
    
    public static void main(String[] args) {
        char[] datas = "UsingBuffers".toCharArray();
        // char occupy 2 byte
        ByteBuffer buffer = ByteBuffer.allocate(datas.length * 2);
        CharBuffer charBuffer = buffer.asCharBuffer();
        charBuffer.put(datas);
        
        printPointer(buffer);
        printPointer(charBuffer);
        System.out.println(charBuffer.rewind());
        
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
        
        symmetricScramble(charBuffer);
        System.out.println(charBuffer.rewind());
    }
}
