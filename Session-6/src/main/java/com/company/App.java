package com.company;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number");
        try{
            int a=sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println( "Hello World!" );

    }
}
