package edu.hanu.myfriend_t5.models;

public class Friend {
    private String name;
    private String emails;
    private String phoneNumber;
    public Friend(String name, String emails, String phoneNumber) {
        this.name = name;
        this.emails = emails;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", emails='" + emails + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
