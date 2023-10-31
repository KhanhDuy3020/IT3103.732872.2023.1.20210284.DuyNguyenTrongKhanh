// Exercises: 6.3 StarTriangle.java
// Nguyễn Trọng Khánh Duy - 20210284
package lab01;

import java.util.Scanner;

public class StarTriangle {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();
        
        for (int i = 0; i <= n; i++) {
        	for (int j = 0; j < n - i; j++ ) {
        		System.out.print(" ");
        	}
        	for (int j = 0; j < i*2+1 ; j ++) {
        		System.out.print("*");
        	}
        	System.out.println("");
        }
        
        scanner.close();
	}
}

