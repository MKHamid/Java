package kaucher;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.print("Type the section : ");
        String section = in.nextLine();

	    Info info = new Info();
	    Hobby hobby = new Hobby();

        System.out.println("Section : "+section);
        System.out.println("Neme    : "+info.name);
        System.out.println("ID      : "+info.id);
        System.out.println("Hobby   : "+hobby.hobbyName);
    }
}
/*
MD Kaucher Hamid Chowdhury
2012020118
C
cse_2012020118@lus.ac.bd
16 July 2021
**/