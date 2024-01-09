
package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CompetitorList {

    private ArrayList<Competitor> competitors = new ArrayList<Competitor>();

    public CompetitorList() {
        this.competitors.addAll(Modified.loadData("src/ModifiedDrivers.csv"));
        this.competitors.addAll(Rally.loadData("src/RallyDrivers.csv"));


    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(ArrayList<Competitor> competitors) {
        this.competitors = competitors;
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
            currentScore = this.competitors.get(i).getOverallScore();
            if (currentScore > highestScore) {
                highestScore = currentScore;
                bigString = this.competitors.get(i).getName().getFirstName() + " is the highest scorer with " + highestScore;
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

    public Competitor findDriver(int iDNum){
        for (int i = 0; i < this.competitors.size(); i++) {
            if (this.competitors.get(i).getiDNumber() == iDNum){
                return this.competitors.get(i);
            }
        }
    return null;
    }

    public String sortedByID(ArrayList<Competitor> racers){
        ArrayList<Integer> IDs = new ArrayList<Integer>();
        String sortedByID = "";
        for (int i = 0; i < racers.size(); i++) {
            IDs.add(racers.get(i).getiDNumber());
        }
        Collections.sort(IDs);
        for (int i2 = 0; i2 < IDs.size(); i2++) {
            sortedByID = sortedByID + findDriver(IDs.get(i2)).tableFormat() + "\n";

        }
        return sortedByID;
    }

    public String sortedByScore (ArrayList<Competitor> racers){
        Map<Double, Integer> linkedScores = new TreeMap<Double,Integer>();
        String sortedByScore = "";
        for (int i = 0; i < racers.size(); i++) {
            linkedScores.put(racers.get(i).getOverallScore(),racers.get(i).getiDNumber());
        }
        Map<Double, Integer> sortedMap = sortByKey(linkedScores);
        for (Double key : sortedMap.keySet()) {
            sortedByScore = sortedByScore + findDriver(sortedMap.get(key)).tableFormat() + "\n";

        }
        return sortedByScore;
    }

    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        List<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());

        // Sorting the entryList based on keys
        Collections.sort(entryList, Map.Entry.comparingByKey(Comparator.reverseOrder()));

        // Creating a LinkedHashMap to preserve the order of elements
        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}

