package com.zeus.io;

import java.io.*;
import java.util.Date;

/**
 * @author xuxingbo
 * @Date 2018/1/13
 * 测试序列化和反序列化过程中transient关键字的作用
 */
public class Logon implements Serializable {
    private Date date = new Date();
    
    private String username;
    
    private transient String passwd;
    
    public Logon(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }
    
    /**
     * 实现这两个方法，就可以自定义序列化和反序列化的字段
     * @param out
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
        System.out.println("writeObject invoke");
        out.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        System.out.println("readObject invoke");
        in.defaultReadObject();
    }
 

    
    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittlePony");
        System.out.println(a);
    
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        out.writeObject(a);
        out.close();
    
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        Logon b = (Logon) in.readObject();
        in.close();
        System.out.println(b);
    }
}
