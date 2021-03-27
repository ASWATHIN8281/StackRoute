package com.company;

import java.util.Scanner;

public class Sorting {
    private int arr[]=new int[20];
    private int num;
    public void read(){
        Scanner sc=new Scanner(System.in);
        while(true){
           System.out.println("Enter size");
           num=sc.nextInt();
           if(num>0 && num<=20){
               break;
           }
           if (num<0){
               System.out.println("pls enter positive number only");
           }
           if(num>20)
               System.out.println("size exceed pls enter number within 20");
        }
        System.out.println("------------------------------");
        System.out.println("enter elements");
        for(int i=0;i<num;i++){
            System.out.println("<"+(i+1)+">");
            arr[i]=sc.nextInt();
        }

    }
    public void display(){
        System.out.println("sorted elements");
        for (int i=0;i<num;i++){
            System.out.print(arr[i]);
            System.out.println(",");
        }
    }
    public void bubbleSort(){
        System.out.println("sorting...");
        for(int i=1;i<num;i++){
            for(int j=0;j<num-i;j++){
                if(arr[j]>arr[j+1]){
                int temp;
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
                }
            }
        }
    }
    public void insertionSort(){
        int j;
        for (int i=1;i<=num-1;i++){
            int temp=arr[i];
            j=i-1;
            while (j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }
    public void swap(int i,int j){
        int temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void quickSort(int low,int high){
        int i=low+1;
        int j=high;
        int com_count=0;
        int mov_count=0;
        int pivot=arr[low];
        if(low>high)
            return;
        while(i<=j) {

            //finding greater element than pivot
            while (arr[i] <= pivot && i <= high) {
                com_count++;
                i++;
            }
            mov_count++;
            //finding lesser element
            while (arr[j] > pivot && j >= low) {
                com_count++;
                j--;
            }
            mov_count++;
            if (i < j) {
                swap(i, j);
                mov_count++;
            }
            if (low < j) {
                swap(low, j);
                mov_count++;
            }
        }
            quickSort(low,j-1);
            quickSort(j+1,high);

    }
    public int sizeArray(){
        return num;
    }
    public static void main(String[] args) {
        Sorting sorting=new Sorting();
        sorting.read();
        //sorting.bubbleSort();
        //sorting.insertionSort();
        sorting.quickSort(0,sorting.sizeArray()-1);
        sorting.display();
    }
}
