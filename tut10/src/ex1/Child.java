package ex1;
public class Child extends  Person{
    public Child(String name, int age){
        super(name, age);
    }
    @Override
    protected void setAge(int age) throws IllegalArgumentException {
        if (age > 15) {
            throw new IllegalArgumentException("Age of child must be < 15 !");
        }
        super.setAge(age);
    }
}
