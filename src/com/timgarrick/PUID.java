package com.timgarrick;

import java.util.Date;
import java.util.Random;

public class PUID {
    private long puid;
    private String puidname;
    private String surname;
    private String firstname;
    private Date createdDate;
    private Date modifiedDate;

    public PUID(String surname, String firstname) {
        this.puid = 2000000000;
        this.puidname = generatePuidName(surname, firstname);
        this.surname = surname;
        this.firstname = firstname;
        this.createdDate = new Date();
    }

    private String generatePuidName(String surname, String firstname) {
        StringBuilder puidname = new StringBuilder();

        puidname.append(surname.toLowerCase());
        puidname.append(firstname.toLowerCase().charAt(0));
        puidname.append(getRandomDigits());

        return puidname.toString();
    }

    private int getRandomDigits() {
        Random random = new Random();
        return random.nextInt(899) + 100;
    }

    public long getPuid() {
        return puid;
    }

    public void setPuid(long puid) {
        this.puid = puid;
    }

    public String getPuidname() {
        return puidname;
    }

    public void setPuidname(String puidname) {
        this.puidname = puidname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "PUID{" +
                "puid=" + puid +
                ", puidname='" + puidname + '\'' +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
