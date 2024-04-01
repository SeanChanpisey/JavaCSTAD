package CSTAD;

import java.util.Scanner;

public class Java_Method {
    static final String[] names ={"Chan","Pisey","Sean"};

    public static void findByname(String name){
        for(String n:names){
            if(n.equalsIgnoreCase(n)){ 
                System.out.println(n+" has found");
                break;
            }else {
                System.out.println(n+" not found");
            }
        }
    }
    public static void main(String[] args) {
        findByname("abc");

    }
}
