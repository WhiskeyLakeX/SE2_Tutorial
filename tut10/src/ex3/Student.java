package ex3;


import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class Student extends Human{
    private long faculty;
    public Student(String lastname, String firstname, long facultynumber) {
        super(lastname, firstname);
        this.setFacultynumber(facultynumber);
    }

    private boolean checkNum(long n)
    {
        int m = 0;
        boolean f = true;
        while (n != 0) {
             m = (int) (n%10);
             if(m<5){
                 f = false;
             }
            n = n / 10;
        }

        return f;
    }

    public void setFacultynumber(long facultynumber) {
        if (!checkNum(facultynumber)){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.faculty = facultynumber;
    }

    @Override
    public String toString() {
        return "Student{" +"lastname='" + getLastname() + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                "faculty=" + faculty +
                '}';
    }
}
