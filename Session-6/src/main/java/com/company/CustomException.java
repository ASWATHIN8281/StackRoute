package com.company;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}
public class CustomException {
    public void validAge(int age)throws InvalidAgeException{
        if(age<18)
            throw new InvalidAgeException("Invalid age");
        else
            System.out.println("thanks for casting vote");
    }

    public static void main(String[] args) {
        CustomException exception=new CustomException();
        try {
            exception.validAge(12);
        }
        catch (InvalidAgeException e)
        {
            System.out.println(e);
        }
    }
}
