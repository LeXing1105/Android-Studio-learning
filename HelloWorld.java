package com.example;


import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String[] args){
        /*
        System.out.println("Hello World!");

        int favouriteNumber = 1105;
        System.out.println(favouriteNumber);

        double goodNumber = 11.05;
        System.out.println(goodNumber);


        char goodLetter = 'a';
        System.out.println(goodLetter);

        boolean Pizza = true;
        System.out.println(Pizza);

        String myName = "Mark";
        System.out.println(("My name is: "+ myName+"and my favourite number is:"+goodNumber));

        double a=10;
        double b=2.386;
        System.out.println(a*b);

        String myString = "mynameisxingle";
        System.out.println(myString.length());

        System.out.println(a*myString.length());

        String myFirstName="Le";
        String myLastName="Xing";
        int numberOfCharacter = myFirstName.length()+myLastName.length();
        System.out.println(numberOfCharacter);

        */





        /*
        int[] primeNumbers = {2, 3, 4, 6, 14};
        System.out.println(primeNumbers[0]);
        System.out.println(primeNumbers.length);



        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);

        list.remove(1);

        System.out.println(list.get(1));
        System.out.println(list.toString());  /* print the whole array */



        /*
        List countries = new ArrayList();
        countries.add("China");
        countries.add("America");
        countries.add("India");
        countries.add("UK");

        System.out.println(countries.toString());

        countries.remove(2);
        System.out.println(countries.toString());


        Map map =new HashMap();
        map.put("Tesco","Eggs");
        map.put("Sainbury","Meats");
        map.put("Wilko","Kitchen");

        System.out.println(map.toString());
        System.out.println(map.get("Tesco"));

        map.remove("Wilko");
        System.out.println((map.toString()));

        System.out.println(map.size());


         int age = 26;
         if (age==18){
             System.out.println("age is 18!");
         }
         else if(age<18){
             System.out.println("age is under 18!");
         }
         else if(age>18 & age<30){
             System.out.println("age is over 18 but under 30");
         }
         else{
             System.out.println("age is over 30!");
         }

         if (age!=20){
             System.out.println("error!");
         }


         int[] numbers={23,56,34,49};
         if (numbers[0]>=numbers[3]){
             System.out.println("first number is greater or equal to the last number!");
         }
         else{
             System.out.println("the first number is smaller than last one!");
         }

         */



        /*
        int x =1;
        while (x<=10){
            if (x%2==0){
                System.out.println(x);
            }
            x+=1;
        }

        for (int y=1; y<=10; y++){
            System.out.println(y);
        }

        for (int y=10; y>=2; y--){
            if (y%2!=0){
                System.out.println(y);
            }
        }


        for (int n=1; n<=10; n++){
            System.out.println(n*(n+1)/2);

        }

        int i=1;
        while(i<=10){
            System.out.println(i*5);
            i++;
        }

         */


        /*
        List<String> familyMembers = new ArrayList();
        familyMembers.add("Xingle");
        familyMembers.add("Zhangxiuping");
        familyMembers.add("Xingyongdong");
        familyMembers.add("Zhaoyang");

        System.out.println(familyMembers.toString());
        for (int i =0; i<familyMembers.size(); i++){
            System.out.println(familyMembers.get(i));
        }

         */


        /*
        class User {
            int score;

            public boolean hasWon(){
                if (score>=100) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }


        User Mark = new User();
        Mark.score = 125;

        System.out.println(Mark.score);
        System.out.println((Mark.hasWon()));





        class Number {

            int inputNumber;
            public boolean posOrNeg() {
                if (inputNumber>0){
                    return true;
                }
                else{
                    return false;
                }
            }

        }

        Number input = new Number();
        input.inputNumber = 25;
        System.out.println(input.inputNumber);
        System.out.println(input.posOrNeg());

         */




        /*

        class Number{
            int number;
            public boolean isTriangular(){
                int n=1;
                int triangular=1;
                while(number>triangular){
                    triangular=n*(n+1)/2;
                    n++;
                }
                if (number==triangular){
                    return true;
                }
                else{
                    return false;
                }
            }

            public boolean isSquare(){
                double squareRoot= Math.sqrt(number);

                if (squareRoot == Math.floor(squareRoot)){
                    return true;
                }
                else{
                    return false;
                }

            }

        }
        Number myNumber = new Number();
        myNumber.number = 25;
        System.out.println(myNumber.isTriangular());
        System.out.println((myNumber.isSquare()));


        if (myNumber.isSquare() & myNumber.isTriangular()){
            System.out.println(myNumber.number + " is both a triangular and rectangular number");
        }
        else if(myNumber.isSquare()){
            System.out.println((myNumber.number+" is a rectangular number"));
        }
        else if(myNumber.isTriangular()){
            System.out.println(myNumber.number+" is a triangular number");
        }
        else{
            System.out.println((myNumber.number+" is neither a triangular or rectangular number "));
        }


         */





        /*
        ArrayList arrayList = new ArrayList();
        Random rand = new Random();
        for (int i=0; i<3; i++){
            arrayList.add(rand.nextInt(50));
        }

         */



        /*
        int[] array = new int[3];
        try {
            for (int i = 0; i < 5; i++) {
                array[i] = i;
            }
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("out of bound!");
        } catch(Exception e){
            System.out.println("e");
        }
        System.out.println(Arrays.toString(array));

         */



        //////advanced manipulation to Strings


        String myString = "Nick x Mark x John x Bob";
        String[] splitString = myString.split(" x ");
        System.out.println(Arrays.toString(splitString));


        String river = "MississippiMississippiMississippi";
        String[] riverSpilt = river.split("s");
        System.out.println(Arrays.toString(riverSpilt));
        String riverPart = river.substring(1,8);   //the index of a string start from 0, the range of index includes the start index, and excludes the end index
        System.out.println(riverPart);




        String number1 = "<img class=\"lozad\" data-src=\"https://imgix.ranker.com/user_node_img/3103/62056554/original/ed-sheeran-photo-u15?fit=crop&amp;fm=pjpg&amp;q=60&amp;w=144&amp;h=144&amp;dpr=2\" alt=\"Ed Sheeran\" src=\"https://imgix.ranker.com/user_node_img/3103/62056554/original/ed-sheeran-photo-u15?fit=crop&amp;fm=pjpg&amp;q=60&amp;w=144&amp;h=144&amp;dpr=2\" data-loaded=\"true\">";

        Pattern p = Pattern.compile("data-src=\"(.*?)\"");    //find the content from"Mi" to "Pi"
        Matcher m = p.matcher(number1);
        while(m.find()){
            System.out.println(m.group(1));
        }

        p = Pattern.compile("alt=\"(.*?)\"");    //find the content from"Mi" to "Pi"
        m = p.matcher(number1);
        while(m.find()){
            System.out.println(m.group(1));
        }
    }

}
