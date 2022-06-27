package models;

public class Solution {



    public static void main(String[] args ){


    }




    public static int div(int a, int b){

       int c = a/b;
        return  c;
    }

    public static double div1(double a, double b) {
        double c = 0;
        try {

            c = a / b;
            System.out.println(c);


        } catch (Exception ex) {
            System.out.println(ex.getClass()+"error occured");
        }


       return c;
    }}











