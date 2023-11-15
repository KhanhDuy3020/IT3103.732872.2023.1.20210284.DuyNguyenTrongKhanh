// Example 5: ShowTwoNumbers.java
package hust;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {

    public static void main(String[] args) {
        String strNuml, strNum2;
        String strNotification = "You've just entered: ";
        strNuml = JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284 - Please input the first number: ",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNuml + " and ";

        strNum2 = JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284 - Please input the second number: ",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}