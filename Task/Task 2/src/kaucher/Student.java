package kaucher;

public class Student {
    String name;
    int id;
    static String universityName;

    Student() {
    }

    Student(int id) {
        this.id = id;
    }

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void display() {
        System.out.println(universityName);
    }
}

/*
        Name   : MD Kaucher Hamid Chowhury
        ID     : 2012020118
        Section: C
        Email  : cse_2012020118@lus.ac.bd
        Date   : 7th August, 2021
    */