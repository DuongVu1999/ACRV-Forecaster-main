package util;

import java.io.*;
import java.util.List;
import javafx.collections.*;
import main.City;

public class StoreUserCity {

	public static void main(String[] args) {
		List<City> CityList = CSVReader();
	}

	public static ObservableList<City> CSVReader() {
		String line = "";

		ObservableList<City> citiesList = FXCollections.observableArrayList();

		try {

			// Create a file object
			File f = new File("");

			// Get the absolute path of file f
			String absolute = f.getAbsolutePath();

			// String to correct the path
			String fileDir = "src\\util\\UserFavorites.csv";

			// Correct the path
			String dir = absolute + "\\" + fileDir;

			// Get the file from the corrected path
			File userFavorites = new File(dir);

			// Parse a CSV file into the constructor for the class BufferedReader
			BufferedReader csvreader = new BufferedReader(new FileReader(dir));

			// Skip the first line of a CSV file
			csvreader.readLine();

			while ((line = csvreader.readLine()) != null) {
				// Returns a Boolean value

				// Creates temporary list
				String[] temp;

				// Reads the entire line and split the line with the first 4 commas
				temp = line.split(",", 5);

				// Stores values from temp in different variables
				String cityName = temp[0];
				String favoriteCityFlag = temp[1];
				String forecastFlag = temp[2];
				String cityFilepath = temp[3];
				String cityURL = temp[4];

				// Creates an object with the information from that line
				City city = new City(cityName, Boolean.parseBoolean(favoriteCityFlag), Boolean.parseBoolean(forecastFlag), cityFilepath, cityURL);

				// Add a city to citiesList
				citiesList.add(city);
			}
			csvreader.close();
			return citiesList;
		}

		catch (IOException e) {
			e.printStackTrace();
			return citiesList;
		}
	}

	/*
	 * UserCSVreader reads only and only specific cities that is tagged favorites
	 */
	public static ObservableList<City> UserCSVReader() {
		String line = "";

		ObservableList<City> citiesList = FXCollections.observableArrayList();

		try {

			// Create a file object
			File f = new File("");

			// Get the absolute path of file f
			String absolute = f.getAbsolutePath();

			// Do the same thing mentioned above in function CSVReader
			String fileDir = "src\\util\\UserFavorites.csv";

			String dir = absolute + "\\" + fileDir;

			File userFavorites = new File(dir);

			// Parse a CSV file into the constructor for the class BufferedReader
			BufferedReader csvreader = new BufferedReader(new FileReader(dir));

			csvreader.readLine();

			while ((line = csvreader.readLine()) != null) {
				// Returns a Boolean value

				String[] temp;

				temp = line.split(",", 5);

				// Stores values from temp in different variables
				String cityName = temp[0];
				String favoriteCityFlag = temp[1];
				String forecastFlag = temp[2];
				String cityFilepath = temp[3];
				String cityURL = temp[4];

				if (favoriteCityFlag.toLowerCase().compareTo("true") == 0) {
					// Creates an object with the information from that line
					City city = new City(cityName, Boolean.parseBoolean(favoriteCityFlag), Boolean.parseBoolean(forecastFlag), cityFilepath, cityURL);
					// Add a city to citiesList
					citiesList.add(city);
				}
			}
			csvreader.close();

			return citiesList;
		} catch (IOException e) {
			e.printStackTrace();
			return citiesList;
		}
	}

	/*
	 * CSVUpdate updates specific row or column in a CSV file
	 * For example, switch the value of false to true in a row or true to false
	 */
	public static void CSVUpdate(String city, Boolean isFavorite) throws IOException {
		try {
			String line = "";

			// Create a file object
			File f = new File("");

			// Create a temporary file object
			File tempF = new File("");

			// Get the absolute path of file f
			String absolute = f.getAbsolutePath();

			// Get the absolute path of the temp file
			String tempAbsolute = tempF.getAbsolutePath();

			// Reformat the directory for correct navigation
			String fileDir = "src\\util\\UserFavorites.csv";

			String tempFileDir = "src\\util\\TempUserFavorites.csv";

			// Replace the incorrect path with the correct path
			String dir = absolute + "\\" + fileDir;

			String tempDir = tempAbsolute + "\\" + tempFileDir;

			// Parse a CSV file into the constructor for the class BufferedReader
			BufferedReader csvreader = new BufferedReader(new FileReader(dir));
			FileWriter tempCsvWriter = new FileWriter(tempDir, true);

			// Skip the first line
			csvreader.readLine();

			// Add the header to the temporary CSV file
			tempCsvWriter.write("CityName");
			tempCsvWriter.write(",");
			tempCsvWriter.write("FavoriteCityFlag");
			tempCsvWriter.write(",");
			tempCsvWriter.write("ForecastFlag");
			tempCsvWriter.write(",");
			tempCsvWriter.write("CityFilepath");
			tempCsvWriter.write(",");
			tempCsvWriter.write("CityURL");
			tempCsvWriter.write("\n");

			while ((line = csvreader.readLine()) != null) {
				// Returns a Boolean value

				// Reading the csv files and stores them in variables similar to the methods above
				String[] temp;

				temp = line.split(",",5);

				// Stores values from temp in different variables
				String cityName = temp[0];
				String favoriteCityFlag = temp[1];
				String forecastFlag = temp[2];
				String cityFilepath = temp[3];
				String cityURL = temp[4];

				// If the name is the same and the flag is the same, then rewrite without changes
				if (cityName.toLowerCase().compareTo(city.toLowerCase()) == 0 && Boolean.compare(Boolean.parseBoolean(favoriteCityFlag), isFavorite) == 0) {

					// Format to write appropriately into the CSV files
					tempCsvWriter.write(cityName);
					tempCsvWriter.write(",");
					tempCsvWriter.write(favoriteCityFlag);
					tempCsvWriter.write(",");
					tempCsvWriter.write(forecastFlag);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityFilepath);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityURL);
					tempCsvWriter.write("\n");

				} else if (cityName.toLowerCase().compareTo(city.toLowerCase()) == 0 && Boolean.compare(Boolean.parseBoolean(favoriteCityFlag), isFavorite) != 0) {
					// This is the case where name is the same but flag is different, then rewrite with changes

					tempCsvWriter.write(cityName);
					tempCsvWriter.write(",");
					tempCsvWriter.write(isFavorite.toString());
					tempCsvWriter.write(",");
					tempCsvWriter.write(forecastFlag);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityFilepath);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityURL);
					tempCsvWriter.write("\n");

				} else {
					tempCsvWriter.write(cityName);
					tempCsvWriter.write(",");
					tempCsvWriter.write(favoriteCityFlag);
					tempCsvWriter.write(",");
					tempCsvWriter.write(forecastFlag);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityFilepath);
					tempCsvWriter.write(",");
					tempCsvWriter.write(cityURL);
					tempCsvWriter.write("\n");
				}
			}

			// Close and flush into a temporary files
			csvreader.close();
			tempCsvWriter.flush();
			tempCsvWriter.close();

			// Read these two files, delete one file, and rename the other files
			File oldUserFavorites = new File(dir);

			File newUserFavorites = new File(tempDir);

			oldUserFavorites.delete();

			newUserFavorites.renameTo(oldUserFavorites);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}