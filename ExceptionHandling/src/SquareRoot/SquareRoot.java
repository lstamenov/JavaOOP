package SquareRoot;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            int number = Integer.parseInt(reader.readLine());
            System.out.println(Math.sqrt(number));
        } catch (Exception e) {
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }
    }
}
