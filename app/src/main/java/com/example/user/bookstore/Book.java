package com.example.user.bookstore;

class Book {
    private String name, status, key;
    Book(){
        name = null;
        status = null;
        key = null;
    }

    Book(String n, String st, String k){
        name = n;
        status = st;
        key = k;
    }

    void setStatus(String st){
        status = st;
    }

    String getName(){
        return name;
    }

    String getStatus(){return status;}

    String getKey(){return key;}

    void setKey(String k){key = k;}
}