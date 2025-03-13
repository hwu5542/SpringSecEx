package com.wuho.SpringSecEx.service;

import com.wuho.SpringSecEx.model.StudentSerial;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SerDeser {
    public void serDeser() {
        StudentSerial student = new StudentSerial("John", 22, "33 E CA");
        student.setBirthDay("010234");

        // Serialize
        String filename = "data/output.txt";
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            fileOut = new FileOutputStream(filename);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(student);
            objOut.close();
            fileOut.close();
            System.out.println("Object has been serialized: \n" + student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserialize
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
            fileIn = new FileInputStream(filename);
            objIn = new ObjectInputStream(fileIn);
            student = (StudentSerial) objIn.readObject();
            objOut.close();
            fileOut.close();
            System.out.println("Object has been deserialized: \n" + student);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
