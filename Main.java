import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Main {

	static String fileName;
	static BufferedWriter w;
	static int block = 0;
	static int fileNum = 1;
	static boolean newFile = true;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		fileName = JOptionPane.showInputDialog("Please put filename");
		w = new BufferedWriter(new FileWriter("file" +fileNum + ".mgf"));
		try {
			Scanner s = new Scanner(new File(fileName));
			for (int i = 0 ; i < 26; i++) {
				String temp = s.nextLine();
				System.out.println(temp);
			}

			while(s.hasNextLine()) {
				String temp = s.nextLine();
				if(temp.equals("BEGIN IONS")) {
					block++;
				}
				if (block >= 1200) {
					w.close();
					fileNum++;
					w = new BufferedWriter(new FileWriter("file" +fileNum + ".mgf"));
					block = 0;
				} else {
					w.write(temp + "\n");
				}

			}
		}

		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File canot be found");
			System.exit(1);
		}
			w.close();
	}

}
