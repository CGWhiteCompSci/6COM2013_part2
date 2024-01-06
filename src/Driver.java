package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    private int[] points = new int[5];
    private Competitor driverDetails;



    public Driver(int[] points, Competitor details) {
        this.points = points;
        this.driverDetails = details;

    }


    @Override
    public String toString() {
        return "Driver{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    public int[] getPoints() {
        return points;
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public Competitor getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(Competitor driverDetails) {
        this.driverDetails = driverDetails;
    }

    public String pointsToString(){
        String pointsString = "";

        for (int i = 0; i < this.points.length; i++){
            pointsString = pointsString + points[i]+",";
        }
        pointsString = pointsString.substring(0,pointsString.length() - 1);

        return pointsString;
    }



    public double getOverallScore() {
        double overallscore = 0.0;

        for (int i = 0; i < this.points.length; i++){
            switch(i){
                case 0:
                    overallscore = overallscore + this.points[i] * 1.1;
                    break;
                case 1:
                    overallscore = overallscore + this.points[i] * 1.2;
                    break;
                case 2:
                    overallscore = overallscore + this.points[i] * 1.3;
                    break;
                case 3:
                    overallscore = overallscore + this.points[i] * 1.4;
                    break;
                case 4:
                    overallscore = overallscore + this.points[i] * 1.5;
                    break;
            }
        }
        overallscore = overallscore/this.points.length;



        return overallscore;
    }

    public String getFullDetails() {
        String fullDetails = "competitor number: " + this.driverDetails.getiDNumber() + " is " + this.driverDetails.getName().getFullName()
                + " from " + this.driverDetails.getCountry() + "\n"+ this.driverDetails.getName().getFirstName() + " was born "+this.driverDetails.getDoB()+ "\n"
                + "competing in the " + this.driverDetails.getCatagory() + " with current points " + this.pointsToString()+"\n"
                + "this gives them an overall score of " + getOverallScore();

        return fullDetails;
    }


    public static void main(String[] args) {
        //Driver test_driver1 = new Driver(new int[]{5, 3, 2, 1, 1},new Competitor(100,new Name("Super Mario"), "15/10/2001","Pro","100cc","itialy","mario@superbros.com"));
        //Driver test_driver2 = new Driver(new int[]{2, 1, 3, 4, 4});
        //Driver test_driver3 = new Driver(new int[]{3, 3, 4, 2, 5});
        //test_driver1.getOverallScore();
        //test_driver1.getFullDetails();

        CompetitorList testlist1 = new CompetitorList();
        Manager testman = new Manager();
        testman.genReport(testlist1);

    }

}
