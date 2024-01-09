package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CompetitorListController{
    private CompetitorList model;
    private CompetitorListGUI view;

    public CompetitorListController(CompetitorList model, CompetitorListGUI view) {
        this.model = model;
        this.view = view;
    }

    public ArrayList<Competitor> getCompetitorList(){
        return this.model.getCompetitors();
    }

    public String racerShortString(Competitor racer){
        return racer.getShortDetails();
    }

    public String racerFullString(Competitor racer){
        return racer.getFullDetails();
    }

    public void setScores(Competitor racer, int[] scores) {
        racer.getDriver().setPoints(scores);
    }


    public void setName(int ID, String newName){
        model.findDriver(ID).setName(new Name(newName));

    }

    public void setDoB(int ID, String newDob){
        model.findDriver(ID).setDoB(newDob);

    }

    public void setLevel(int ID, String newlevel){
        model.findDriver(ID).setLevel(newlevel);

    }

    public void setCountry(int ID, String newcountry){
        model.findDriver(ID).setCountry(newcountry);

    }
    public void setEmail(int ID, String newEmail){
        model.findDriver(ID).setEmail(newEmail);

    }
    public String racerListToString() {
        return null;
    }







}


