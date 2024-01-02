//cw22aba@herts.ac.uk
//20040033

package src;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Competitor {
    private int iDNumber;
    private String name;
    private String DoB;
    private String level;
    private String country;
    private String email;

    private int[] scores;




    public Competitor (int newiDNumber, String newName, String newDoB, String newLevel, String newCountry, String newEmail, int[] newScores){
        this.iDNumber = newiDNumber;
        this.name = newName;
        this.DoB = newDoB;
        this.level = newLevel;
        this.country = newCountry;
        this.email = newEmail;
        this.scores = newScores;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public String getName() {
        return name;
    }

    public String getDoB() {
        return DoB;
    }

    public String getLevel() {
        return level;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public void setiDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String scoresToString(int[] scores)
        {
            return Arrays.toString(scores);
        }



    public double getOverallScore(int[] driverScores) {
        int score = 0;

        for (int i = 0; i < driverScores.length; i++) {
            score += driverScores[i];
        }

        return score;
    }

    public String getFullDetails() {
        String fullDetails = "competitor number: " + this.iDNumber + " is " + this.level + ", " + this.name+ ". Born " + this.DoB + " from " + this.country + "\ntheir email is: " + this.email + ". their scores are " + scoresToString(this.scores) + "\nThis gives him an overall score of" + getOverallScore(this.scores);
        return fullDetails;
    }

    public String getShortDetails() {
        String shortDetails = "CN " + this.iDNumber + "(" +this.name+ ") has overall score" + getOverallScore(this.scores);
        return shortDetails;
    }

    public static void main(String[] args) {
        //Competitor comp1 = new Competitor(1,"Mario", "15/10/2001","Pro","itialy","mario@superbros.com");
        //System.out.println(comp1.getFullDetails());

    }
}


