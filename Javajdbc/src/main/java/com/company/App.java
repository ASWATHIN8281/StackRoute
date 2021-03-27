package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
            char result;
            int input,id;
            String query;
            Scanner sc=new Scanner(System.in);
            do{
                System.out.println("Press 1 for add or press 2 for searching option");
                input=sc.nextInt();
                switch (input){
                    case 1:
                        String name;
                        System.out.println("enter student id ");
                        id=sc.nextInt();
                        System.out.println("Enter student name ");
                        name=sc.next();
                        query="insert into studentRecord(std_id,std_name) values(?,?)";
                        PreparedStatement statement=con.prepareStatement(query);
                        statement.setInt(1,id);
                        statement.setString(2,name);
                        int i=statement.executeUpdate();
                        System.out.println(" row inserted "+i);
                        break;
                    case 2:
                        System.out.println("enter student id to be searched ");
                        id=sc.nextInt();
                        query="select * from studentRecord where std_id=?";
                        PreparedStatement statement1=con.prepareStatement(query);
                        statement1.setInt(1,id);
                        ResultSet rs=statement1.executeQuery();
                        if (rs.next()){
                            System.out.println("Stuent ID: "+rs.getInt("std_id")+" student Name: "+rs.getString("std_name"));
                        }
                        else{
                            System.out.println("not found");
                        }
                        break;
                    default:
                        System.out.println("invalid input");

                }
                System.out.println("Do U want to continue(y/n)");
                result=sc.next().charAt(0);

            }while(result=='y'||result=='Y');

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
