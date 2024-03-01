package org.example.fuctionalInterfaceExample.staticAndNonStatic;

public class Test {
    private int code;

      void setCode(int code) {
        this.code = code;
    }

     void display(){
        System.out.println("code:" + code);
    }

    static void show(String s){
        System.out.println("test class: " + s);
    }


}
