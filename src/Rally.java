package src;

public class Rally extends Competitor{
    private String driveTrain;
    public Rally(int iDNumber, Name name, String doB, String level, String country, String email, Driver driver, String driveTrain) {
        super(iDNumber, name, doB, level, country, email, driver);
        this.driveTrain = driveTrain;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public double getOverallScore() {
        double overallscore = 0.0;

        for (int i = 0; i < this.getDriver().getPoints().length; i++){
            switch(i){
                case 0:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.01;
                    break;
                case 1:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.02;
                    break;
                case 2:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.03;
                    break;
                case 3:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.04;
                    break;
                case 4:
                    overallscore = overallscore + this.getDriver().getPoints()[i] * 1.5;
                    break;
            }
        }
        overallscore = overallscore/ this.getDriver().getPoints().length;



        return overallscore;
    }

}
