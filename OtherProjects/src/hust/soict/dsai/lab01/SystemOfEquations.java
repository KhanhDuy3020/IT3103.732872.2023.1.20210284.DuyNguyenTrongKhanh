// Example 6.2: SystemOfEquations.java
package hust;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SystemOfEquations {
    public static void main(String[] args) {
        double a11, a12, a21, a22, b1, b2, x1, x2, D, D1, D2;
        String strNotification = "";

        a11 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input a11: (a11.x1 + a12.x2 = b1)",
                "Input the a11",
                JOptionPane.INFORMATION_MESSAGE));

        a12 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input a12: ("+formatDecimal(a11)+".x1 + a12.x2 = b1)",
                "Input the a12",
                JOptionPane.INFORMATION_MESSAGE));

        b1 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input b1: ("+formatDecimal(a11)+".x1 + "+formatDecimal(a12)+".x2 = b1)",
                "Input the b1",
                JOptionPane.INFORMATION_MESSAGE));

        a21 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input a21: (a21.x1 + a22.x2 = b2)",
                "Input the a21",
                JOptionPane.INFORMATION_MESSAGE));

        a22 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input a22: ("+formatDecimal(a21)+".x1 + a22.x2 = b2)",
                "Input the a22",
                JOptionPane.INFORMATION_MESSAGE));

        b2 = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input b2: ("+formatDecimal(a21)+".x1 + "+formatDecimal(a22)+".x2 = b2)",
                "Input the b2",
                JOptionPane.INFORMATION_MESSAGE));

        D = a11 * a22 - a21 * a12;
        D1 = b1 * a22 - b2 * a12;
        D2 = a11 * b2 - a21 * b1;

        strNotification += "Solution of the equation :\n"; 
        strNotification += formatDecimal(a11)+".x1 + "+formatDecimal(a12)+".x2 = "+formatDecimal(b1)+"\n"; 
        strNotification += formatDecimal(a21)+".x1 + "+formatDecimal(a22)+".x2 = "+formatDecimal(b2)+"\n"; 
        strNotification += "Solution:\n"; 

        if (D == 0 ) {
            if (D1 == D2) {
                // Nếu D = 0, D1 = D2 phương trình vô số nghiệm
                strNotification += "Infinite solutions";
            } else  {
                // Nếu D = 0, D1 != D2 phương trình vô nghiệm
                strNotification += "No solution";
            }
        } else {
            // Nếu D != 0 hệ phương trình có nghiệm duy nhất x1 = D1/D, x2 = D2/D
            x1 = D1 / D;
            x2 = D2 / D;
            strNotification += "x1 = " + formatDecimal(x1) + "\n";
            strNotification += "x2 = " + formatDecimal(x2) + "\n";
        }
        JOptionPane.showMessageDialog(null, strNotification, "Show solution", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    // Chỉnh lại hiển thị số. Nếu phần thập phân có số 0 thì không hiển thị
    public static String formatDecimal(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.########");
        return decimalFormat.format(number);
    }
}