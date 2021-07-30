package util;

import java.io.*;
import javafx.collections.*;
import javafx.scene.image.Image;
import main.HelpInstructions;

public class InstructionAdapter {

	// Read the file "HelpInstructions.csv"
	public static ObservableList<HelpInstructions> CSVReader() {
		String line = "";

		ObservableList<HelpInstructions> helpInstructionList = FXCollections.observableArrayList();

		try {

			// Create a file object
			File f = new File("");

			// Get the absolute path of file f
			String absolute = f.getAbsolutePath();

			// String to correct the path
			String fileDir = "src\\util\\HelpInstructions.csv";

			// Correct the path
			String dir = absolute + "\\" + fileDir;

			// Parse a CSV file into the constructor for the class BufferedReader
			BufferedReader csvreader = new BufferedReader(new FileReader(dir));

			// Skip the first line of a CSV file
			csvreader.readLine();

			while ((line = csvreader.readLine()) != null) {
				// Return a Boolean value

				// Create a temporary list
				String[] temp;

				// Read line and split it by commas
				temp = line.split(",", 4);

				// Store values from temp into different variables
				int instructionID = Integer.parseInt(temp[0]);
				String instructions = temp[1];
				String description = temp[2];
				String imageName = temp[3];

				// Get the image corresponding to imageName and store it in Image instructionImage
				Image instructionImage = new Image(getImageURL(imageName));

				// Creates HelpInstructions instructionObject with the information from temp
				HelpInstructions instructionObject = new HelpInstructions(instructionID, instructions, description, instructionImage);

				// Add instructionObject to helpInstructionList
				helpInstructionList.add(instructionObject);
			}
			csvreader.close();
			return helpInstructionList;
		} catch (IOException e) {
			e.printStackTrace();
			return helpInstructionList;
		}
	}
	
	public static String getImageURL(String imageFile) {

		// Create a file object
		File f = new File("");

		// Get the absolute path of file f
		String absolute = f.getAbsolutePath();

		// String to correct the path
		String fileDir = "src\\media\\instruction\\" + imageFile;

		String protocol  = "file:///";

		// Correct the path
		String dir = protocol + absolute + "\\" + fileDir;

		return dir;
	}
}