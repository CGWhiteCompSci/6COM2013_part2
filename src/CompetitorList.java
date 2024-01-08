
package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CompetitorList {

    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();

    public CompetitorList() {
        loadData();
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


    public void loadData() {
        String filePath = "src/RunCompetitor.csv";
        int tempID = 0;
        String tempName, tempDoB, tempLevel, tempCountry, tempEmail;
        tempName = tempDoB = tempLevel = tempCountry = tempEmail = "";



        try {

            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                Boolean errorFlag = Boolean.FALSE;
                String data = myReader.nextLine();
                String[] lineofdata = data.split(",");

                if ((lineofdata.length >= 5)) {
                    ArrayList<Integer> tempScores = new ArrayList<Integer>();
                    for (int i = 0; i < lineofdata.length; i++) {

                        if (i == 0) {
                            if (lineofdata[i] != null){
                                tempID = Integer.parseInt(lineofdata[i]);
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("ID is Invalid");

                            }
                        }
                        if (i == 1) {
                            if (lineofdata[i] != null) {
                                tempName = lineofdata[i];
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("Name is Invalid");

                            }
                        }
                        if (i == 2) {
                            if (lineofdata[i] != null) {
                                tempDoB = lineofdata[i];
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("Date of birth is Invalid");

                            }
                        }

                        if (i == 3) {
                            if (lineofdata[i] != null) {
                                tempLevel = lineofdata[i];
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("level is Invalid");
                            }
                        }

                        if (i == 4) {
                            if (lineofdata[i] != null) {
                                tempCountry = lineofdata[i];
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("country is Invalid");
                            }
                        }

                        if (i == 5) {
                            if (lineofdata[i] != null) {
                                tempEmail = lineofdata[i];
                            }
                            else{
                                errorFlag = Boolean.TRUE;
                                System.out.println("Email is Invalid");
                            }
                        }
                        if (i > 6) {
                            try {
                                tempScores.add(Integer.valueOf(lineofdata[i]));
                            } catch (NumberFormatException e) {
                                errorFlag = Boolean.TRUE;
                                System.out.println("Score is Invalid");
                            }


                        }

                    }
                    if (errorFlag == Boolean.FALSE) {
                        int[] scoresConvert = new int[tempScores.size()];
                        for (int i = 0; i < tempScores.size(); i++){
                            scoresConvert[i] = tempScores.get(i);

                        }


                        Driver tempDriver = new Driver(scoresConvert);
                        Competitor tempCompetitor = new Competitor(tempID,new Name(tempName),tempDoB,tempLevel,tempCountry,tempEmail,tempDriver);
                        competitors.add(tempCompetitor);


                    }
                    else{
                        System.out.println("Driver can't not be added check data");


                    }


                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        CompetitorList test1 = new CompetitorList();



    }
}

