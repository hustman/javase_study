package com.zeus.io;

import java.nio.ByteBuffer;

/**
 * @author xuxingbo
 * @Date 2018/1/7
 */
public class GetAndSetData {
    public static final int BUFF_SIZE = 1024;
    
    public static void main(String[] args){
        ByteBuffer buffer = ByteBuffer.allocate(BUFF_SIZE);
        
        int i = 0;
        //check the buffer allocate is all zero
        while(i++ < buffer.limit()){
            if(buffer.get() != 0){
                System.out.println("no zero");
            }
        }
        System.out.println("i= " + i);
        buffer.rewind();
        buffer.asCharBuffer().put("Hello world");
        char c;
        while((c = buffer.getChar()) != 0){
            System.out.print(c + " ");
        }
        System.out.println("");
        buffer.rewind();
        
        buffer.asShortBuffer().put((short) 32767);
        System.out.println(buffer.getShort());
        
        buffer.rewind();
        buffer.asIntBuffer().put(1234567);
        System.out.println(buffer.getInt());
        
        buffer.rewind();
        buffer.asLongBuffer().put(123456789L);
        System.out.println(buffer.getLong());
        
        buffer.rewind();
        buffer.asFloatBuffer().put(1234567);
        System.out.println(buffer.getFloat());
        
        buffer.rewind();
        buffer.asDoubleBuffer().put(1234567);
        System.out.println(buffer.getDouble());
        
        buffer.rewind();
    }
}
