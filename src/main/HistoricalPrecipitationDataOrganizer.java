package main;

import java.lang.reflect.*;
import java.util.*;

/*
 * Contains organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
 * Organizes a .csv file of historical precipitation data
 * Input is a file path of a .csv file
 * Output is a HashMap<String, ArrayList<String>> where
 * the keys of this HashMap<String, ArrayList<String>> are dates in the format MM-DD such as 02-25 and
 * the values of this HashMap<String, ArrayList<String>> are rows of historical precipitation data
 * 
 * Reference(s):
 * Hourly Precipitation Data (HPD) Network, Version 2. [2.0], NOAA National Centers for Environmental Information. [February 25, 2021].
 */

public class HistoricalPrecipitationDataOrganizer {

	public static void main(String[] args) throws Exception {
	}

	public static HashMap<String, ArrayList<String>> organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath) throws Exception {

		HashMap<String, ArrayList<String>> organizedHistoricalPrecipitationData = new HashMap<String, ArrayList<String>>();
		
		try {
			ArrayList<String> unorganizedHistoricalPrecipitationData = main.CsvReader.readCsvFile(unorganizedHistoricalPrecipitationDataFilePath);
			
			for (int i = 1; i < unorganizedHistoricalPrecipitationData.size(); i++) {
				// Skips the header of a .csv file
				
				String unorganizedHistoricalPrecipitationDataRow = unorganizedHistoricalPrecipitationData.get(i);
				// Please reference the file 'readme.csv.txt' to understand the value of each element of unorganizedHistoricalPrecipitationDataRow such as "givenDate"
				
				String givenDate = String.valueOf(Array.get(unorganizedHistoricalPrecipitationDataRow.split(","), 4));
				// Example value for givenDate
				// 2021-02-25
				
				String monthAndDayDate = givenDate.substring(givenDate.length()-5,givenDate.length());
				// Example value for monthAndDayDate
				// 02-25

				ArrayList<String> initialValueOfListOfListsOfStrings = new ArrayList<String>(Arrays.asList(unorganizedHistoricalPrecipitationDataRow));

				if (organizedHistoricalPrecipitationData.containsKey(monthAndDayDate) == true){
					organizedHistoricalPrecipitationData.get(monthAndDayDate).add(unorganizedHistoricalPrecipitationDataRow);
				} else {
					organizedHistoricalPrecipitationData.put(monthAndDayDate, initialValueOfListOfListsOfStrings);
				}
			}
			return organizedHistoricalPrecipitationData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}