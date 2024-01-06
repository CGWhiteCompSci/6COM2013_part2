//cw22aba@herts.ac.uk
//20040033

package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Competitor {


    private int iDNumber;
    private Name name;
    private String DoB;

    private String catagory;
    private String level;
    private String country;
    private String email;


    public Competitor(int iDNumber, Name name, String doB, String category, String level, String country, String email) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.DoB = doB;
        this.catagory = category;
        this.level = level;
        this.country = country;
        this.email = email;

    }

    @Override
    public String toString() {
        return "Competitor{" +
                "iDNumber=" + iDNumber +
                ", name=" + name.getFullName() +
                ", DoB='" + DoB + '\'' +
                ", catagory='" + catagory + '\'' +
                ", level='" + level + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getOverallScore() {
        return 5;
    }

    public String getFullDetails() {
        String fullDetails = "competitor number: " + this.iDNumber + " is " + this.name.getFullName()
                + " from " + this.country + "\n"+ this.name.getFirstName() + " was born "+this.DoB + "\n"
                + "competing in the " + this.catagory + " with an overall score of " + this.getOverallScore();
        return fullDetails;
    }

    public String getShortDetails() {
        String shortDetails = "CN " + this.iDNumber + "(" +this.name.genIntials() +" has overall score " + this.getOverallScore();
        return shortDetails;
    }

    public static void main(String[] args) {
        //Competitor comp1 = new Competitor(100,new Name("Super Mario"), "15/10/2001","Pro","100cc","itialy","mario@superbros.com",new int[]{2, 4, 2, 4, 1});
        //System.out.println(comp1.name.getFirstName());

    }
}


