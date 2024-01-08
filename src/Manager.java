package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {


    public Manager() {



    }
    public void genReport(CompetitorList currentDriverTable){
        String outputString = currentDriverTable.tableFormat() + "\n" +
                currentDriverTable.highestScorer() + "\n" +
                currentDriverTable.numofFirsts();

        System.out.println(outputString);

        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(outputString);
            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }




    }




}
