//cw22aba@herts.ac.uk
//20040033

package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Competitor {


    private int iDNumber;
    private Name name;
    private String DoB;

    private String level;
    private String country;
    private String email;

    private Driver driver;


    public Competitor(int iDNumber, Name name, String doB, String level, String country, String email, Driver driver) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.DoB = doB;
        this.level = level;
        this.country = country;
        this.email = email;
        this.driver = driver;

    }

    @Override
    public String toString() {
        return "Competitor{" +
                "iDNumber=" + iDNumber +
                ", name=" + name.getFullName() +
                ", DoB='" + DoB + '\'' +
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getOverallScore() {
        double overallscore = 0.0;

        for (int i = 0; i < this.driver.getPoints().length; i++){
            switch(i){
                case 0:
                    overallscore = overallscore + this.driver.getPoints()[i] * 1.1;
                    break;
                case 1:
                    overallscore = overallscore + this.driver.getPoints()[i] * 1.2;
                    break;
                case 2:
                    overallscore = overallscore + this.driver.getPoints()[i] * 1.3;
                    break;
                case 3:
                    overallscore = overallscore + this.driver.getPoints()[i] * 1.4;
                    break;
                case 4:
                    overallscore = overallscore + this.driver.getPoints()[i] * 1.5;
                    break;
            }
        }
        overallscore = overallscore/this.driver.getPoints().length;



        return overallscore;
    }

    public String getFullDetails() {
        String fullDetails = "competitor number: " + this.getiDNumber() + " is " + this.getName().getFullName()
                + " from " + this.getCountry() + "\n"+ this.getName().getFirstName() + " was born "+this.getDoB()+ "\n"
                + " with current points " + this.driver.pointsToString()+"\n"
                + "this gives them an overall score of " + getOverallScore();

        return fullDetails;
    }

    public String getShortDetails() {
        String shortDetails = "CN " + this.iDNumber + " (" +this.name.genIntials() +") has overall score " + this.getOverallScore();
        return shortDetails;
    }

    public static void main(String[] args) {
        //Competitor comp1 = new Competitor(100,new Name("Super Mario"), "15/10/2001","Pro","100cc","itialy","mario@superbros.com",new int[]{2, 4, 2, 4, 1});
        //System.out.println(comp1.name.getFirstName());

    }
}


