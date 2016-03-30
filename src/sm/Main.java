package sm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	private Scanner inFile;
	private StableMatching sm;

	public Main(String[] fileName) {
		try {
			inFile = new Scanner(new File(fileName[0]));

			String line = inFile.nextLine();
			while (line.startsWith("#")) {
				line = inFile.nextLine();
			}
			if (line.startsWith("n")) {
				int pairs = Integer.parseInt(line.substring(2));
				sm = new StableMatching(pairs);
				line = inFile.nextLine();
				int stringIndex = 2;
				for (int i = 0; i < (pairs * 2); i++) {
					String name = line.substring(stringIndex);
					sm.setName(i+1, name);
					line = inFile.nextLine();
					if(i == 8 || i == 98 || i == 998){
						stringIndex++;
					}
				}
				stringIndex = 3;
				int endIndex = 1;
				for (int i = 0; i < pairs * 2;i++){
					
					line = inFile.nextLine();
					int person = Integer.parseInt(line.substring(0, endIndex));
					if(i == 8 || i == 98 || i == 998){
						endIndex++;
					}
					String prefArray = line.substring(stringIndex);
					String[] stringArray = prefArray.split(" ");
					sm.setPreference(person, stringArray);
					if(i == 8 || i == 98 || i == 998){
						stringIndex++;
					}
				
				}
				sm.match();
				System.out.println(sm.matchToString());
			}

			//System.out.println(s);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Main(args);

	}

}
