
package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class CompetitorList {

    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();
    public CompetitorList() {
        ArrayList<Integer> testScore1 = new ArrayList<Integer>();
        Collections.addAll(testScore1, 1, 3, 4, 5, 6);
        Competitor comp1 = new Competitor(101, "dave", "03011154", "champ", "UK", "Dave@dave.com", testScore1);
        competitors.add(comp1);
        loadData();
        System.out.println(competitors.get(3).getFullDetails());

    }

    private void loadData() {
        String filePath = "src/RunCompetitor.csv";
        String tempName, tempGender, tempAge,tempCountry;
        tempName = tempGender = tempCountry = tempAge = "";
        int tempID;
        tempID = 0;
        ArrayList<Integer> tempScores = new ArrayList<Integer>();


        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tempScores.clear();
                String data = myReader.nextLine();
                String[] lineofdata = data.split(",");
                for (int i = 0; i < lineofdata.length; i++) {

                    if (i == 0){
                        tempID = Integer.parseInt(lineofdata[i]);
                        String compUIname = "comp" + String.valueOf(tempID);
                    }
                    if (i == 1){
                        tempName = lineofdata[i];
                    }
                    if (i == 2){
                        tempAge = lineofdata[i];
                    }
                    if (i == 3){
                        tempGender = lineofdata[i];
                    }
                    if (i == 4){
                        tempCountry = lineofdata[i];
                    }
                    if (i > 4){
                        tempScores.add(Integer.parseInt(lineofdata[i]));
                    }
                }
                Competitor compUIname = new Competitor(tempID,tempName,tempAge,"test",tempCountry,"test@test.com",tempScores);
                competitors.add(compUIname);

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

