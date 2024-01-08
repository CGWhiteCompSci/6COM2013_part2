package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Modified extends Competitor{
    private int engineSize;
    public Modified(int iDNumber, Name name, String doB, String level, String country, String email, Driver driver, int engineSize) {
        super(iDNumber, name, doB, level, country, email, driver);
        this.engineSize = engineSize;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public double getOverallScore() {
        double overallscore = 0.0;

        for (int i = 0; i < this.getDriver().getPoints().length; i++){
            switch(i){
                case 0:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.11;
                    break;
                case 1:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.22;
                    break;
                case 2:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.33;
                    break;
                case 3:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.44;
                    break;
                case 4:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.55;
                    break;
            }
        }
        overallscore = overallscore/ this.getDriver().getPoints().length;



        return overallscore;
    }

    public static ArrayList<Competitor> loadData(String driverListLocation) {
        ArrayList<Competitor> tempCompetitors= new ArrayList<Competitor>();
        String filePath = driverListLocation;
        int tempID = 0;
        int tempEngineSize = 0;
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
                        if (i == 6) {
                            if (lineofdata[i] != null) {
                                tempEngineSize = Integer.parseInt(lineofdata[i]);
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
                        Modified tempModified = new Modified(tempID,new Name(tempName),tempDoB,tempLevel,tempCountry,tempEmail,tempDriver,tempEngineSize);
                        tempCompetitors.add(tempModified);


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

        return tempCompetitors;
    }

}


