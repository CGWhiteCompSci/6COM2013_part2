package src;

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

}
