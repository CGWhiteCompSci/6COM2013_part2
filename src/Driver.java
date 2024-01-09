package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    private int[] points = new int[5];




    public Driver(int[] points) {
        this.points = points;

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






}
