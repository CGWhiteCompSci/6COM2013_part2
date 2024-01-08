
package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CompetitorList {

    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();

    public CompetitorList() {
        competitors.addAll(Rally.loadData("src/ModifiedDrivers.csv"));
        competitors.addAll(Rally.loadData("src/RallyDrivers.csv"));


    }

    public String tableFormat(){
        String bigString = "";
        for (int i = 0; i < this.competitors.size(); i++){
            bigString = bigString + this.competitors.get(i).toString() + " " + this.competitors.get(i).getDriver().pointsToString() + "\n";


        }
        return bigString;
    }
    public String highestScorer(){
        String bigString = "";
        double  highestScore = -1.0;
        double currentScore;

        for (int i = 0; i < this.competitors.size(); i++) {
            currentScore = competitors.get(i).getOverallScore();
            if (currentScore > highestScore) {
                highestScore = currentScore;
                bigString = competitors.get(i).getName().getFirstName() + " is the highest scorer with " + highestScore;
            }
        }
        return bigString;
    }
    public String numofFirsts() {
        String bigString = "";
        int firsts = 0;
        for (int i = 0; i < competitors.size(); i++) {
            for (int i2 = 0; i2 < competitors.get(i).getDriver().getPoints().length; i2++){
                if (competitors.get(i).getDriver().getPoints()[i2] == 5){
                    firsts++;
                }
            }
        }


        bigString = "number of firsts " +String.valueOf(firsts);
        return bigString;
    }

    public String findDriver(int iDNum){
        for (int i = 0; i < competitors.size(); i++) {
            if (competitors.get(i).getiDNumber() == iDNum){
                return competitors.get(i).getShortDetails();
            }
        }
        return "not found";
    }



    public static void main(String[] args) {
        CompetitorList test1 = new CompetitorList();



    }
}

