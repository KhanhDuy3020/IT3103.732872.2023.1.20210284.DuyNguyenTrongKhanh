// Example 5: Calculate.java
package hust;

import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
        double num1, num2, sum, difference, product, quotient;
        String strNotification = "";

        num1 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284 - Please input the first number: ",
                "Input the first number",
                JOptionPane.INFORMATION_MESSAGE));

        num2 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284 - Please input the second number: ",
                "Input the second number",
                JOptionPane.INFORMATION_MESSAGE));

        sum = num1 + num2; // Tính tổng 2 số
        difference = num1 - num2; // Tính hiệu 2 số
        product = num1 * num2; // Tính tích 2 số
        quotient = num1 / num2; // Tính thương 2 số

        strNotification += "Sum = " + sum + "\n";
        strNotification += "Difference = " + difference + "\n";
        strNotification += "Product = " + product + "\n";
        strNotification += "Quotient = " + quotient + "\n";

        JOptionPane.showMessageDialog(null, strNotification, "Show calculate", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}