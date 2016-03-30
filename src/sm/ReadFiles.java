package sm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFiles {
	private Scanner inFile;
	public ReadFiles(String fileName){
		try {
			File yourFile = new File(fileName);
			if(!yourFile.exists()) {
			    yourFile.createNewFile();
			} 
			inFile = new Scanner(new File(fileName));

		} catch (FileNotFoundException e) {
			System.out.println("Filen gick inte att finna");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int[] readIntoIntArray(int elementsInFile){
		int[] temp = new int[elementsInFile];
		int i = 0;
		while(inFile.hasNextInt()){
		   temp[i++] = inFile.nextInt();
		}
		inFile.close();
		return temp;
	}

	
}
