package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class CompetitorListGUI extends JFrame implements ActionListener
    {

    // The staff list to be searched.
    private CompetitorList racerList;

    private CompetitorListController model ;

    //GUI components
    JTextField result;
    JTextField searchField,racerName;
    JButton racerViewShort, racerViewFull, racerDelete, racerUpdateScores, racerEdit,submitButton;
    JScrollPane scrollList;
    JButton close;
    JTextArea displayList;

    JComboBox selectMetric, selectClass;

    Manager bossman = new Manager();


    /**
     * Create the frame with its panels.
     * @param list	The staff list to be searched.
     */



    public CompetitorListGUI(CompetitorList list)
    {
        this.racerList = list;
        this.model = new CompetitorListController(racerList,this);

        //set up window title
        setTitle("Manage Racers");
        //disable standard close button
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        setupSouthPanel();
        setupNorthPanel();
        setupCenterPanel();


        //pack and set visible
        pack();
        setVisible(true);
        displayList.setText(racerList.sortedByID(model.getCompetitorList()));

    }

        public CompetitorList getRacerList() {
            return racerList;
        }

        private void setupCenterPanel() {
        displayList = new JTextArea(15,5);
        displayList.setFont(new Font(Font.MONOSPACED, Font.PLAIN,14));
        displayList.setEditable(false);
        scrollList = new JScrollPane(displayList);
        this.add(scrollList,BorderLayout.CENTER);
        this.add(scrollList,BorderLayout.CENTER);
        this.add(scrollList,BorderLayout.CENTER);
    }

    private void setupSouthPanel() {
        //search panel contains label, text field and button
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,3));
        searchPanel.add(new JLabel("Enter ID"));
        searchField = new JTextField(5);
        searchPanel.add(searchField);

        racerViewShort = new JButton("View Short Details");
        searchPanel.add(racerViewShort);
        racerViewShort.addActionListener(this) ;

        racerViewFull = new JButton("View Full Details");
        searchPanel.add(racerViewFull);
        racerViewFull.addActionListener(this) ;

        racerEdit = new JButton("Edit Details");
        searchPanel.add(racerEdit);
        racerEdit.addActionListener(this) ;

        racerUpdateScores = new JButton("Update Scores");
        searchPanel.add(racerUpdateScores);
        racerUpdateScores.addActionListener(this) ;

        racerDelete = new JButton("Delete");
        searchPanel.add(racerDelete);
        racerDelete.addActionListener(this) ;


        //Set up the area where the results will be displayed.
        result= new JTextField(25);
        result.setEditable(false);

        //set up south panel containing 2 previous areas
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,5));
        southPanel.add(searchPanel);
        southPanel.add(result);

        //add south panel to the content pane
        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void setupNorthPanel() {
        //add north panel containing some buttons
        JPanel northPanel = new JPanel();

        String metrics[] = { "ID number","Total Score"};
        selectMetric = new JComboBox(metrics);
        selectMetric.addActionListener(this);

        String typesOfRacer[] = { "all","Modified", "Rally"};
        selectClass = new JComboBox(typesOfRacer);
        selectClass.addActionListener(this);

        close = new JButton("Close");
        close.addActionListener(this);

        northPanel.add (selectMetric);
        northPanel.add(selectClass);
        northPanel.add(close);
        this.add(northPanel, BorderLayout.NORTH);
    }

        private void setupEditorWindow(Competitor oldDetails) {
            JFrame newWindow = new JFrame();
            newWindow.setTitle("New Window");
            newWindow.setSize(400, 300);
            newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1.0;

            JLabel label1 = new JLabel("Input 1:");
            JTextField textField1 = new JTextField(20);
            textField1.setText(oldDetails.getName().getFullName());

            JLabel label2 = new JLabel("Input 2:");
            JTextField textField2 = new JTextField(20);
            textField2.setText(oldDetails.getDoB());


            JLabel label3 = new JLabel("Input 3:");
            JTextField textField3 = new JTextField(20);
            textField3.setText(oldDetails.getLevel());

            JLabel label4 = new JLabel("Input 4:");
            JTextField textField4 = new JTextField(20);
            textField4.setText(oldDetails.getCountry());

            JLabel label5 = new JLabel("Input 5:");
            JTextField textField5 = new JTextField(20);
            textField5.setText(oldDetails.getEmail());

            panel.add(label1, gbc);
            panel.add(textField1, gbc);
            panel.add(label2, gbc);
            panel.add(textField2, gbc);
            panel.add(label3, gbc);
            panel.add(textField3, gbc);
            panel.add(label4, gbc);
            panel.add(textField4, gbc);
            panel.add(label5, gbc);
            panel.add(textField5, gbc);

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == submitButton) {
                        // Retrieve the values from text fields if needed
                        model.setName(oldDetails.getiDNumber(), textField1.getText());
                        model.setDoB(oldDetails.getiDNumber(), textField2.getText());
                        model.setLevel(oldDetails.getiDNumber(), textField3.getText());
                        model.setCountry(oldDetails.getiDNumber(), textField4.getText());
                        model.setEmail(oldDetails.getiDNumber(), textField5.getText());
                        newWindow.dispose();
                        displayList.setText(racerList.sortedByID(racerList.getCompetitors()));
                    }

                }
            }
            );

            panel.add(submitButton, gbc);

            newWindow.add(panel);
            newWindow.setVisible(true);
        }


    public ArrayList<Competitor> getSelectClass(String type){
        ArrayList<Competitor> selectedRacers = new ArrayList<Competitor>();
        if (Objects.equals(type, "Rally")){
            for (int i = 0; i < this.model.getCompetitorList().size(); i++){
                System.out.println(this.model.getCompetitorList().get(i) instanceof Modified);
                if (this.model.getCompetitorList().get(i) instanceof Rally){
                    selectedRacers.add(this.model.getCompetitorList().get(i));
                }

        }

        }
        if (Objects.equals(type, "Modified")){
            for (int i2 = 0; i2 < this.model.getCompetitorList().size(); i2++){
                System.out.println(this.model.getCompetitorList().get(i2) instanceof Modified);
                if (this.model.getCompetitorList().get(i2) instanceof Modified){
                    selectedRacers.add(this.model.getCompetitorList().get(i2));
                }

            }

        }
        return selectedRacers;
    }
        public void actionPerformed(ActionEvent e) {
            ArrayList<Competitor> selectClassRacers = new ArrayList<Competitor>();
            if (selectClass.getSelectedItem() == "Rally") {
                selectClassRacers = getSelectClass("Rally");
            } else if (selectClass.getSelectedItem() == "Modified") {
                selectClassRacers = getSelectClass("Modified");
            } else {
                selectClassRacers = this.model.getCompetitorList();
            }

            if (e.getSource() == selectMetric) {
                if (selectMetric.getSelectedItem() == "ID number") {
                    displayList.setText(racerList.sortedByID(selectClassRacers));
                } else if (selectMetric.getSelectedItem() == "Total Score") {
                    displayList.setText(racerList.sortedByScore(selectClassRacers));
                }
            }
            if (e.getSource() == selectClass) {
                displayList.setText(racerList.sortedByID(selectClassRacers));

            }

            try {
                Integer searchINT = Integer.valueOf(searchField.getText().trim());
                if (e.getSource() == racerViewShort) {
                    JOptionPane.showMessageDialog(this, model.racerShortString(racerList.findDriver(searchINT)));

                }
                if (e.getSource() == racerViewFull) {
                    JOptionPane.showMessageDialog(this, model.racerFullString(racerList.findDriver(searchINT)));

                }

                if (e.getSource() == racerEdit) {
                    setupEditorWindow(racerList.findDriver(searchINT));

                }


                if (e.getSource() == racerUpdateScores) {
                    int score1 = Integer.parseInt(JOptionPane.showInputDialog("Please input score for race 1: "));
                    int score2 = Integer.parseInt(JOptionPane.showInputDialog("Please input score for race 2: "));
                    int score3 = Integer.parseInt(JOptionPane.showInputDialog("Please input score for race 3: "));
                    int score4 = Integer.parseInt(JOptionPane.showInputDialog("Please input score for race 4: "));
                    int score5 = Integer.parseInt(JOptionPane.showInputDialog("Please input score for race 5: "));

                    int[] newScores = {score1,score2,score3,score4,score5};

                    model.setScores(racerList.findDriver(searchINT),newScores);
                    displayList.setText(racerList.sortedByID(selectClassRacers));

                }

                if (e.getSource() == racerDelete) {

                    for (int i = 0; i < this.racerList.getCompetitors().size(); i++){
                        if (this.racerList.getCompetitors().get(i).getiDNumber() == searchINT){
                            int index = this.racerList.getCompetitors().indexOf(this.racerList.getCompetitors().get(i));
                            this.racerList.getCompetitors().remove(index);
                        }
                    }
                    JOptionPane.showMessageDialog(this, searchINT +": has been deleted");
                    displayList.setText(racerList.sortedByID(this.model.getCompetitorList()));


                }
            } catch (Exception e2) {
            }






            if (e.getSource() == close) {
                        JOptionPane.showMessageDialog(this,"Thank you and bye");
                        bossman.genReport(racerList);
                        System.exit(0);
                    }
                }

    }


