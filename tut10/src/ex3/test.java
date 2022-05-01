package ex3;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String firstname = scanner.nextLine();
            String lastname = scanner.nextLine();
            long facultinumber = Long.parseLong(scanner.nextLine());
            Student student = new Student(firstname, lastname,facultinumber);
            Human human = new Human(firstname, lastname);
            System.out.println(human.toString());
            System.out.println(student.toString());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

     try {
        Scanner scanner = new Scanner(System.in);
        String firstname = scanner.nextLine();
        String lastname = scanner.nextLine();
        double salary = Double.valueOf(scanner.nextLine());
        int hours = Integer.valueOf(scanner.nextLine()) ;
        Worker worker = new Worker(firstname, lastname,salary,hours);
        Human human = new Human(firstname, lastname);
        System.out.println(human.toString());
        System.out.println(worker.toString());
    } catch (IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}
}
