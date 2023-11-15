// Example 6.3: SecondDegreeEq.java
package hust;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SecondDegreeEq {
    public static void main(String[] args) {
        double a, b, c, x, x1, x2, D;
        String strNotification = "";

        a = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input a: (a.x^2 + b.x + c = 0)",
                "Input the a",
                JOptionPane.INFORMATION_MESSAGE));

        b = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input b: ("+formatDecimal(a)+".x^2 + b.x + c = 0)",
                "Input the b",
                JOptionPane.INFORMATION_MESSAGE));

        c = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"
                + "Please input c: ("+formatDecimal(a)+".x^2 + "+formatDecimal(b)+".x + c = 0)",
                "Input the c",
                JOptionPane.INFORMATION_MESSAGE));

        D = b * b - 4 * a * c;

        strNotification += "Solution of the equation :\n"; 
        strNotification += formatDecimal(a)+".x^2 + "+formatDecimal(b)+".x + "+formatDecimal(c)+" = 0\n"; 
        strNotification += "Solution:\n"; 

        if (a == 0) {
            if (b == 0 ) {
                if (c == 0) {
                    // Nếu a = 0, b = 0, c = 0 phương trình vô số nghiệm
                    strNotification += "Infinite solutions";
                } else  {
                    // Nếu a = 0, b = 0, c != 0 phương trình vô nghiệm
                    strNotification += "No solution";
                }
            } else {
                // Nếu a = 0, b != 0, c != 0 phương trình có 1 nghiệm duy nhất x = -c/b
                x = -c / b;
                strNotification += "x = " + formatDecimal(x);
            }
        } else {
            if (D < 0 ) {
                // Nếu delta(D) < 0 phương trình vô nghiệm
                strNotification += "No solution";
            } else if (D == 0) {
                // Nếu D == 0 phương trình có nghiệm duy nhất x = -b/2a;
                x = -b / (2 * a);
                strNotification += "x = " + formatDecimal(x) + "\n";
            } else {
                // Nếu D > 0 phương trình có 2 nghiệm phân biệt
                // x1 = (b + sqrt(D)) / (2 * a)
                // x2 = (b - sqrt(D)) / (2 * a)
                x1 = (b + Math.sqrt(D)) / (2 * a);
                x2 = (b - Math.sqrt(D)) / (2 * a);
                strNotification += "x1 = " + formatDecimal(x1) + "\n";
                strNotification += "x2 = " + formatDecimal(x2) + "\n";
            }
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