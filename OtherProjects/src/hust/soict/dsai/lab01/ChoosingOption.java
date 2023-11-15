// Exercises: 6.1 ChoosingOption.java
// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args){
        Object[] availableOptions = {"Done",
                "Not yet"};
        int option = JOptionPane.showOptionDialog(null,
                "Do you finish homework", //message in dialog
                "Done yet question", //title of dialog
                JOptionPane.YES_NO_OPTION, //type of set of options
                JOptionPane.QUESTION_MESSAGE, // type of message
                null, // not use icon
                availableOptions, // set of options be displayed
                availableOptions[0]); //default value
        // take user input to option variable
        JOptionPane.showMessageDialog(null,
                "You 've chosen: " + (option==JOptionPane.YES_OPTION?"Done" : "Not yet")); 
        		// show message based on value of option
    }
}