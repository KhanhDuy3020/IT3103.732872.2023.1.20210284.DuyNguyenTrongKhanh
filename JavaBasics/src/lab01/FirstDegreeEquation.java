// Example 6.1: FirstDegreeEquation.java
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        double a, b, x;
        String strNotification = "";

        a = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"+"Please input a: ",
                "Input the a",
                JOptionPane.INFORMATION_MESSAGE));

        b = Double.parseDouble(JOptionPane.showInputDialog(null, 
                "Nguyen Trong Khanh Duy 20210284\n"+"Please input b: ",
                "Input the b",
                JOptionPane.INFORMATION_MESSAGE));

        strNotification += "Solution of the equation : "+formatDecimal(a)+"x + "+formatDecimal(b)+" = 0\n"; 
        strNotification += "Solution:\n"; 

        if (a == 0 ) {
            if (b == 0) {
                // Nếu a = 0, b = 0 phương trình vô số nghiệm
                strNotification += "Infinite solutions";
            } else  {
                // Nếu a = 0, b != 0 phương trình vô nghiệm
                strNotification += "No solution";
            }
        } else {
            // Nếu a != 0, b != 0 phương trình có 1 nghiệm duy nhất x = -b/a
            x = -b / a;
            strNotification += "x = " + formatDecimal(x);
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