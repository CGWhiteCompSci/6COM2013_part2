package src;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private ArrayList<Integer> scores = new ArrayList<Integer>();

    public Driver(ArrayList<Integer> newScores) {
        this.scores = newScores;
    }


    public ArrayList<Integer> getScoreArray() {
        return this.scores;


    }

    public static void main(String[] args) {
        ArrayList<Integer> testscores1 = new ArrayList<>(List.of(5,2,3,56,7));
        Driver d1 = new Driver(testscores1);
        Competitor comp1 = new Competitor(1,"Mario", "15/10/2001","Pro","itialy","mario@superbros.com",d1.getScoreArray());
        System.out.println(comp1.getFullDetails());



    }
}
