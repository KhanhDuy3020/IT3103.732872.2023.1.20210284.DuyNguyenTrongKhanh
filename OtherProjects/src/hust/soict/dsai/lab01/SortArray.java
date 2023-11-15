// Exercises: 6.5 SortArray.java
// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.lab01;

import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0; // Khởi tạo tổng = 0
		
		// Nhập số phần tử của mảng
		System.out.print("Size of array: ");
		int size = scanner.nextInt();
		
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			// Nhập các giá trị của mảng
			System.out.print("Enter array[" + i + "]: ");
			array[i] = scanner.nextInt();
			sum += array[i]; // Tính tổng
		}
		
		System.out.print("Array: ");
		for (int i = 0; i < size; i++) {
			// In ra các phần tử mảng
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		bubbleSort(array);
		
		System.out.print("Sorted: ");
		for (int i = 0; i < size; i++) {
			// In ra các phần tử mảng
			System.out.print(array[i] + " ");
		}
		
		double average = (double)sum / size;
		
		System.out.println();
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
		
		scanner.close();
	}	
	// Thuật toán sắp xếp nổi bọt	
	public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = (n-1); i >= 0; i--) {
            for (int j = 1; j <= i; j++){
                if (array[j-1] > array[j]) {
                	int temp = array[j-1];
                	array[j-1] = array[j];
                	array[j] = temp;
                }
            }
        }
    }
}
