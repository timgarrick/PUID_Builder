package com.timgarrick;
import java.util.Date;

public class PUID {
    private long puid;
    private String puidname;
    private String partialPuidname;
    private String surname;
    private String firstname;
    private Date createdDate;
    private Date modifiedDate;
    private Boolean obsolete;

    public PUID(String surname, String firstname) {
        String name = surname.toLowerCase() + firstname.toLowerCase().charAt(0);

        this.puid = FieldIncrementData.getInstance().getNewPuid();
        this.puidname = generatePuidName(name);
        this.partialPuidname = name;
        this.surname = surname;
        this.firstname = firstname;
        this.createdDate = new Date();
        this.obsolete = false;
    }

    public String generatePuidName(String s) {
        return s + FieldIncrementData.getInstance().getNewPuidDigits(s);
    }

    public String getPartialPuidname() {
        return partialPuidname;
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

    public Boolean getObsolete() {
        return obsolete;
    }

    public void setObsolete(Boolean obsolete) {
        this.obsolete = obsolete;
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
