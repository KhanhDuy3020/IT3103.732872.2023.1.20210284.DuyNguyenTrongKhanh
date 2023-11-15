// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreateor {
	public static void main(String[] args) throws IOException {
		String filename = "D:/Nam3/OOP/IT3103.732872.2023.1.20210284.DuyNguyenTrongKhanh"
				+ "/OtherProjects/src/hust/soict/globalict/garbage/data.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		System.out.println("Nguyen Trong Khanh Duy - 20210284");
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char)b;
		}
		endTime = System.currentTimeMillis();
		System.out.println("String : " + (endTime - startTime) + "ms");
		
	}
}
