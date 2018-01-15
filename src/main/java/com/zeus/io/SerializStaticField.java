package com.zeus.io;

import java.io.*;

/**
 * @author xuxingbo
 * @Date 2018/1/13
 */
public class SerializStaticField implements Serializable {
    private static int field = 0;
    
    private String name;
    
    public SerializStaticField(String name) {
        this.name = name;
    }
    
    public static int getField() {
        return field;
    }
    
    public static void setField(int field) {
        SerializStaticField.field = field;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public static void serializeStaticState(ObjectOutputStream out) throws IOException {
        out.writeInt(field);
    }
    
    public static void deserializeStaticState(ObjectInputStream ins) throws IOException{
        field = ins.readInt();
    }
    
    
    @Override
    public String toString() {
        return "SerializStaticField{" +
                "name='" + name + '\'' +"," +
                "field=" + field +
                '}';
    }
    
    public static void main(String[] args) throws Exception {
        String fileName = "static_field.dat";
        SerializStaticField object = new SerializStaticField("static-test");
        SerializStaticField.setField(2);
        System.out.println(object);
        serialized(object, fileName);
    
//        SerializStaticField deserialized = deserialized(fileName);
//        System.out.println(deserialized);
    }
    
    private static void serialized(SerializStaticField object, String fileName) throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(object);
        SerializStaticField.serializeStaticState(out);
        System.out.println(String.format("write object to %s success", fileName));
        out.close();
    }
    
    private static SerializStaticField deserialized(String fileName) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        SerializStaticField object = (SerializStaticField) in.readObject();
        SerializStaticField.deserializeStaticState(in);
        in.close();
        System.out.println(String.format("read object from %s success", fileName));
        return object;
    }
}
