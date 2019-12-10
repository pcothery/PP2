package mergeSort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class CreateRandomFile {
	public static void main(String[] args) {
		File f = new File("..\\input.txt");
		Random r = new Random();
		int fileSize = Integer.parseInt(args[0]);

		try {
			PrintWriter fwrite = new PrintWriter(f);
			for (int i = 0; i < fileSize; i++) {
				fwrite.print(r.nextInt());
				fwrite.print(" ");

			}
			fwrite.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
