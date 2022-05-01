package ex3;

public class Worker extends Human {
    private  double salary;
    private int hours;
    public Worker(String lastname, String firstname, double salary, int hours) {
        super(lastname, firstname);

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if( salary < 10){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary" );
        }
        this.salary = salary;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if( hours >12 || hours < 1){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay" );
        }
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Worker{" +"lastname='" + getLastname() + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                "salary=" + salary +
                ", hours=" + hours +
                '}';
    }
}
