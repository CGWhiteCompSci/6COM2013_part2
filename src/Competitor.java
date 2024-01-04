//cw22aba@herts.ac.uk
//20040033

package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Competitor {
    private int iDNumber;
    private String name;
    private String DoB;
    private String level;
    private String country;
    private String email;

    private ArrayList<Integer> scores = new ArrayList<Integer>();




    public Competitor (int newiDNumber, String newName, String newDoB, String newLevel, String newCountry, String newEmail, ArrayList<Integer> newScores){
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

    public String scoresToString(ArrayList<Integer> scores)
        {
            String line = String.valueOf(scores.get(0));
            for (int i = 1; i < scores.size(); i++) {
                line = line + ", "+ scores.get(i);
                }
            return line;
        }



    public double getOverallScore(ArrayList<Integer> driverScores) {
        int score = 0;

        for (int i = 0; i < driverScores.size(); i++) {
            score += driverScores.get(i);
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


