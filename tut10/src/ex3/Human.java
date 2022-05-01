package ex3;

public class Human {
    private String lastname;
    private  String  firstname;

    public Human(String lastname, String firstname) {
        this.setLastname(lastname);
        this.setFirstname(firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (!Character.isUpperCase(lastname.charAt(0))){
throw new  IllegalArgumentException("Expected upper case letter!Argument:" +
        "lastName");
        }
        if (lastname.length()<3){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: lastName" );
        }
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (!Character.isUpperCase(firstname.charAt(0))){
            throw new  IllegalArgumentException("Expected upper case letter!Argument:" +
                    "firstName");
        }
        if (firstname.length()<4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName" );
        }
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Human{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
