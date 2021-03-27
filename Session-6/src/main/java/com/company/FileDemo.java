package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name;
        try {
            FileOutputStream stream = new FileOutputStream("/home/ubuntu/Documents/Session-6/src/abc.txt");
            System.out.println("enter name");
            name = sc.nextLine();
            byte[] ar = name.getBytes();
            stream.write(ar);
            stream.flush();
            stream.close();
            FileInputStream s=new FileInputStream("/home/ubuntu/Documents/Session-6/src/abc.txt");
            int data=0;
            while((data=s.read())!=-1){
                System.out.println((char) data);
            }
            s.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
