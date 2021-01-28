package com.company;

import java.io.*;

public class HandelData {



    public static void writeData(Object object,String filename){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename,false);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static Object readObject(String filename){
        Object object = null;
        try {
            FileInputStream streamIn = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(streamIn);
            object = objectInputStream.readObject();
            objectInputStream.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return object;
    }
}
