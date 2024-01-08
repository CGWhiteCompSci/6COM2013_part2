package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompetitorListGUI extends JFrame implements ActionListener
    {

    // The staff list to be searched.
    private CompetitorList racerList;

    //GUI components
    JTextField result;
    JTextField searchField;
    JButton search;
    JScrollPane scrollList;
    JButton showListById, showListByName, close;
    JTextArea displayList;


    /**
     * Create the frame with its panels.
     * @param list	The staff list to be searched.
     */
    public CompetitorListGUI(CompetitorList list)
    {
        this.racerList = list;

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
        search = new JButton("Search");
        searchPanel.add(search);
        //specify action when button is pressed
        search.addActionListener(this) ;

        //Set up the area where the results will be displayed.
        result= new JTextField(25);
        result.setEditable(false);

        //set up south panel containing 2 previous areas
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(searchPanel);
        southPanel.add(result);

        //add south panel to the content pane
        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void setupNorthPanel() {
        //add north panel containing some buttons
        JPanel northPanel = new JPanel();
        showListById = new JButton("List By ID");
        showListById.addActionListener(this);

        showListByName = new JButton("List By Name");
        showListByName.addActionListener(this);

        close = new JButton("Close");
        close.addActionListener(this);

        northPanel.add (showListById);
        northPanel.add(showListByName);
        northPanel.add(close);
        this.add(northPanel, BorderLayout.NORTH);
    }

    //come here when button is clicked
    //find which button and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == search) {
            search();
        }
        else if (e.getSource() == showListById) {
            displayList.setText(racerList.tableFormat());
        }
        else if (e.getSource() == showListByName ) {
            displayList.setText(racerList.toString());
        }
        else if (e.getSource() == close) {
            JOptionPane.showMessageDialog(this,
                    "Closing down ..");
            System.exit(0);
        }
    }

    private void search() {
        //get search text and search staff list
        //setting result text
        String searchString = searchField.getText().trim();
        if(searchString.length() > 0) {

            if (racerList.findDriver(Integer.parseInt(searchString)) != null ) {
                result.setText(racerList.findDriver(Integer.parseInt(searchString)));

            }
            else
                result.setText("not found");
        }
        else
            result.setText("no text entered");
    }

}