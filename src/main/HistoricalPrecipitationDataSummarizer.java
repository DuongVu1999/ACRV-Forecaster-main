package main;

import java.lang.reflect.*;
import java.util.*;

/*
 * Contains summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath)
 * Summarizes a .csv file of historical precipitation data
 * Input is a file path of a .csv file
 * Output is a HashMap<String, ArrayList<Double>> where
 * the keys of this HashMap<String, ArrayList<Double>> are dates in the format MM-DD such as 02-25 and
 * the values of this HashMap<String, ArrayList<Double>> are rows of historical precipitation data such as
 * [4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666, 4.0, 12.0, 1.0, 2.0, 3.0, 66.66666666666666]
 * 
 * Reference(s):
 * Hourly Precipitation Data (HPD) Network, Version 2. [2.0], NOAA National Centers for Environmental Information. [February 25, 2021].
 */

public class HistoricalPrecipitationDataSummarizer {

	public static void main(String[] args) throws Exception {
	}

	public static HashMap<String, ArrayList<Double>> summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath) throws Exception {
		HashMap<String, ArrayList<String>> organizedHistoricalPrecipitationData = main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData(organizedHistoricalPrecipitationDataFilePath);
		HashMap<String, ArrayList<Double>> summarizedHistoricalPrecipitationData = new HashMap<String, ArrayList<Double>>();
		
		try {			
			for (Map.Entry<String, ArrayList<String>> kvpair : organizedHistoricalPrecipitationData.entrySet()) {
				String k = kvpair.getKey();
				ArrayList<String> v = kvpair.getValue();
							
				for (String vrow : v) {
	
					/*
					 * Please reference the file 'readme.csv.txt' to understand the value of each element of unorganizedHistoricalPrecipitationDataRow such as "HR00Val"
					 * "
					 * HR00Val    is the value on the first hour of the day (i.e., the precipitation
					 * total during the time of day 00:00-01:00; missing = -9999).
					 * The units are hundredths of inch.
					 * "
					 * -'readme.csv.txt'
					 */
					
					String HR00Val = String.valueOf(Array.get(vrow.split(","), 6));
					String HR01Val = String.valueOf(Array.get(vrow.split(","), 11));
					String HR02Val = String.valueOf(Array.get(vrow.split(","), 16));
					String HR03Val = String.valueOf(Array.get(vrow.split(","), 21));
					String HR04Val = String.valueOf(Array.get(vrow.split(","), 26));
					String HR05Val = String.valueOf(Array.get(vrow.split(","), 31));
					String HR06Val = String.valueOf(Array.get(vrow.split(","), 36));
					String HR07Val = String.valueOf(Array.get(vrow.split(","), 41));
					String HR08Val = String.valueOf(Array.get(vrow.split(","), 46));
					String HR09Val = String.valueOf(Array.get(vrow.split(","), 51));
					String HR10Val = String.valueOf(Array.get(vrow.split(","), 56));
					String HR11Val = String.valueOf(Array.get(vrow.split(","), 61));
					String HR12Val = String.valueOf(Array.get(vrow.split(","), 66));
					String HR13Val = String.valueOf(Array.get(vrow.split(","), 71));
					String HR14Val = String.valueOf(Array.get(vrow.split(","), 76));
					String HR15Val = String.valueOf(Array.get(vrow.split(","), 81));
					String HR16Val = String.valueOf(Array.get(vrow.split(","), 86));
					String HR17Val = String.valueOf(Array.get(vrow.split(","), 91));
					String HR18Val = String.valueOf(Array.get(vrow.split(","), 96));
					String HR19Val = String.valueOf(Array.get(vrow.split(","), 101));
					String HR20Val = String.valueOf(Array.get(vrow.split(","), 106));
					String HR21Val = String.valueOf(Array.get(vrow.split(","), 111));
					String HR22Val = String.valueOf(Array.get(vrow.split(","), 116));
					String HR23Val = String.valueOf(Array.get(vrow.split(","), 121));
					
					if (HR00Val.equals(" ") || HR00Val.isEmpty() || HR00Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR00Val = "0";
					}
					if (HR01Val.equals(" ") || HR01Val.isEmpty() || HR01Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR01Val = "0";
					}
					if (HR02Val.equals(" ") || HR02Val.isEmpty() || HR02Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR02Val = "0";
					}
					if (HR03Val.equals(" ") || HR03Val.isEmpty() || HR03Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR03Val = "0";
					}
					if (HR04Val.equals(" ") || HR04Val.isEmpty() || HR04Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR04Val = "0";
					}
					if (HR05Val.equals(" ") || HR05Val.isEmpty() || HR05Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR05Val = "0";
					}
					if (HR06Val.equals(" ") || HR06Val.isEmpty() || HR06Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR06Val = "0";
					}
					if (HR07Val.equals(" ") || HR07Val.isEmpty() || HR07Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR07Val = "0";
					}
					if (HR08Val.equals(" ") || HR08Val.isEmpty() || HR08Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR08Val = "0";
					}
					if (HR09Val.equals(" ") || HR09Val.isEmpty() || HR09Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR09Val = "0";
					}
					if (HR10Val.equals(" ") || HR10Val.isEmpty() || HR10Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR10Val = "0";
					}
					if (HR11Val.equals(" ") || HR11Val.isEmpty() || HR11Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR11Val = "0";
					}
					if (HR12Val.equals(" ") || HR12Val.isEmpty() || HR12Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR12Val = "0";
					}
					if (HR13Val.equals(" ") || HR13Val.isEmpty() || HR13Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR13Val = "0";
					}
					if (HR14Val.equals(" ") || HR14Val.isEmpty() || HR14Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR14Val = "0";
					}
					if (HR15Val.equals(" ") || HR15Val.isEmpty() || HR15Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR15Val = "0";
					}
					if (HR16Val.equals(" ") || HR16Val.isEmpty() || HR16Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR16Val = "0";
					}
					if (HR17Val.equals(" ") || HR17Val.isEmpty() || HR17Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR17Val = "0";
					}
					if (HR18Val.equals(" ") || HR18Val.isEmpty() || HR18Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR18Val = "0";
					}
					if (HR19Val.equals(" ") || HR19Val.isEmpty() || HR19Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR19Val = "0";
					}
					if (HR20Val.equals(" ") || HR20Val.isEmpty() || HR20Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR20Val = "0";
					}
					if (HR21Val.equals(" ") || HR21Val.isEmpty() || HR21Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR21Val = "0";
					}
					if (HR22Val.equals(" ") || HR22Val.isEmpty() || HR22Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR22Val = "0";
					}
					if (HR23Val.equals(" ") || HR23Val.isEmpty() || HR23Val.contains("-")) {
						// Blank, empty, or negative precipitation values will be set to 0
						HR23Val = "0";
					}
										
					// Format for values in summarizedHistoricalPrecipitationData
					// index: value
					// 0: averageOfSummarizedHR00Val
					// 1: summarizedHR00Val
					// 2: countOfZeroValuesInSummarizedHR00Val
					// 3: countOfNonZeroValuesInSummarizedHR00Val
					// 4: totalCountOfValuesInSummarizedHR00Val
					// 5: confidenceOfSummarizedHR00Val
					// 6: averageOfSummarizedHR01Val
					// 7: ...
					
					if (summarizedHistoricalPrecipitationData.containsKey(k) == true) {
						// HR00Val

						// averageOfSummarizedHR00Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 0) + Double.parseDouble(HR00Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 0) + 1));
						// summarizedHR00Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 0) + Double.parseDouble(HR00Val)));
						// countOfZeroValuesInSummarizedHR00Val
						if (Double.parseDouble(HR00Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 0) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR00Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 0) + 1));
						}
						// totalCountOfValuesInSummarizedHR00Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 0) + 1));
						// confidenceOfSummarizedHR00Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 0, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 0) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 0) * 100.0));
						
						// HR01Val

						// averageOfSummarizedHR01Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 1) + Double.parseDouble(HR01Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 1) + 1));
						// summarizedHR01Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 1) + Double.parseDouble(HR01Val)));
						// countOfZeroValuesInSummarizedHR01Val
						if (Double.parseDouble(HR01Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 1) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR01Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 1) + 1));
						}
						// totalCountOfValuesInSummarizedHR01Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 1) + 1));
						// confidenceOfSummarizedHR01Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 1, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 1) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 1) * 100.0));
						
						// HR02Val

						// averageOfSummarizedHR02Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 2) + Double.parseDouble(HR02Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 2) + 1));
						// summarizedHR02Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 2) + Double.parseDouble(HR02Val)));
						// countOfZeroValuesInSummarizedHR02Val
						if (Double.parseDouble(HR02Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 2) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR02Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 2) + 1));
						}
						// totalCountOfValuesInSummarizedHR02Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 2) + 1));
						// confidenceOfSummarizedHR02Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 2, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 2) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 2) * 100.0));
					
						// HR03Val

						// averageOfSummarizedHR03Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 3) + Double.parseDouble(HR03Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 3) + 1));
						// summarizedHR03Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 3) + Double.parseDouble(HR03Val)));
						// countOfZeroValuesInSummarizedHR03Val
						if (Double.parseDouble(HR03Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 3) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR03Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 3) + 1));
						}
						// totalCountOfValuesInSummarizedHR03Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 3) + 1));
						// confidenceOfSummarizedHR03Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 3, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 3) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 3) * 100.0));
						
						// HR04Val

						// averageOfSummarizedHR04Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 4) + Double.parseDouble(HR04Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 4) + 1));
						// summarizedHR04Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 4) + Double.parseDouble(HR04Val)));
						// countOfZeroValuesInSummarizedHR04Val
						if (Double.parseDouble(HR04Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 4) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR04Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 4) + 1));
						}
						// totalCountOfValuesInSummarizedHR04Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 4) + 1));
						// confidenceOfSummarizedHR04Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 4, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 4) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 4) * 100.0));
						
						// HR05Val

						// averageOfSummarizedHR05Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 5) + Double.parseDouble(HR05Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 5) + 1));
						// summarizedHR05Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 5) + Double.parseDouble(HR05Val)));
						// countOfZeroValuesInSummarizedHR05Val
						if (Double.parseDouble(HR05Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 5) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR05Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 5) + 1));
						}
						// totalCountOfValuesInSummarizedHR05Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 5) + 1));
						// confidenceOfSummarizedHR05Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 5, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 5) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 5) * 100.0));
						
						// HR06Val

						// averageOfSummarizedHR06Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 6) + Double.parseDouble(HR06Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 6) + 1));
						// summarizedHR06Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 6) + Double.parseDouble(HR06Val)));
						// countOfZeroValuesInSummarizedHR06Val
						if (Double.parseDouble(HR06Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 6) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR06Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 6) + 1));
						}
						// totalCountOfValuesInSummarizedHR06Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 6) + 1));
						// confidenceOfSummarizedHR06Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 6, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 6) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 6) * 100.0));
						
						// HR07Val

						// averageOfSummarizedHR07Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 7) + Double.parseDouble(HR07Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 7) + 1));
						// summarizedHR07Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 7) + Double.parseDouble(HR07Val)));
						// countOfZeroValuesInSummarizedHR07Val
						if (Double.parseDouble(HR07Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 7) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR07Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 7) + 1));
						}
						// totalCountOfValuesInSummarizedHR07Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 7) + 1));
						// confidenceOfSummarizedHR07Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 7, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 7) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 7) * 100.0));
						
						// HR08Val

						// averageOfSummarizedHR08Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 8) + Double.parseDouble(HR08Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 8) + 1));
						// summarizedHR08Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 8) + Double.parseDouble(HR08Val)));
						// countOfZeroValuesInSummarizedHR08Val
						if (Double.parseDouble(HR08Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 8) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR08Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 8) + 1));
						}
						// totalCountOfValuesInSummarizedHR08Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 8) + 1));
						// confidenceOfSummarizedHR08Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 8, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 8) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 8) * 100.0));
						
						// HR09Val

						// averageOfSummarizedHR09Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 9) + Double.parseDouble(HR09Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 9) + 1));
						// summarizedHR09Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 9) + Double.parseDouble(HR09Val)));
						// countOfZeroValuesInSummarizedHR09Val
						if (Double.parseDouble(HR09Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 9) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR09Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 9) + 1));
						}
						// totalCountOfValuesInSummarizedHR09Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 9) + 1));
						// confidenceOfSummarizedHR09Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 9, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 9) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 9) * 100.0));
						
						// HR10Val

						// averageOfSummarizedHR10Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 10) + Double.parseDouble(HR10Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 10) + 1));
						// summarizedHR10Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 10) + Double.parseDouble(HR10Val)));
						// countOfZeroValuesInSummarizedHR10Val
						if (Double.parseDouble(HR10Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 10) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR10Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 10) + 1));
						}
						// totalCountOfValuesInSummarizedHR10Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 10) + 1));
						// confidenceOfSummarizedHR10Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 10, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 10) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 10) * 100.0));
						
						// HR11Val

						// averageOfSummarizedHR11Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 11) + Double.parseDouble(HR11Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 11) + 1));
						// summarizedHR11Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 11) + Double.parseDouble(HR11Val)));
						// countOfZeroValuesInSummarizedHR11Val
						if (Double.parseDouble(HR11Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 11) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR11Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 11) + 1));
						}
						// totalCountOfValuesInSummarizedHR11Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 11) + 1));
						// confidenceOfSummarizedHR11Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 11, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 11) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 11) * 100.0));
						
						// HR12Val

						// averageOfSummarizedHR12Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 12) + Double.parseDouble(HR12Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 12) + 1));
						// summarizedHR12Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 12) + Double.parseDouble(HR12Val)));
						// countOfZeroValuesInSummarizedHR12Val
						if (Double.parseDouble(HR12Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 12) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR12Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 12) + 1));
						}
						// totalCountOfValuesInSummarizedHR12Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 12) + 1));
						// confidenceOfSummarizedHR12Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 12, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 12) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 12) * 100.0));
						
						// HR13Val

						// averageOfSummarizedHR13Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 13) + Double.parseDouble(HR13Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 13) + 1));
						// summarizedHR13Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 13) + Double.parseDouble(HR13Val)));
						// countOfZeroValuesInSummarizedHR13Val
						if (Double.parseDouble(HR13Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 13) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR13Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 13) + 1));
						}
						// totalCountOfValuesInSummarizedHR13Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 13) + 1));
						// confidenceOfSummarizedHR13Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 13, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 13) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 13) * 100.0));
						
						// HR14Val

						// averageOfSummarizedHR14Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 14) + Double.parseDouble(HR14Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 14) + 1));
						// summarizedHR14Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 14) + Double.parseDouble(HR14Val)));
						// countOfZeroValuesInSummarizedHR14Val
						if (Double.parseDouble(HR14Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 14) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR14Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 14) + 1));
						}
						// totalCountOfValuesInSummarizedHR14Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 14) + 1));
						// confidenceOfSummarizedHR14Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 14, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 14) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 14) * 100.0));
						
						// HR15Val

						// averageOfSummarizedHR15Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 15) + Double.parseDouble(HR15Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 15) + 1));
						// summarizedHR15Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 15) + Double.parseDouble(HR15Val)));
						// countOfZeroValuesInSummarizedHR15Val
						if (Double.parseDouble(HR15Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 15) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR15Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 15) + 1));
						}
						// totalCountOfValuesInSummarizedHR15Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 15) + 1));
						// confidenceOfSummarizedHR15Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 15, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 15) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 15) * 100.0));
						
						// HR16Val

						// averageOfSummarizedHR16Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 16) + Double.parseDouble(HR16Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 16) + 1));
						// summarizedHR16Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 16) + Double.parseDouble(HR16Val)));
						// countOfZeroValuesInSummarizedHR16Val
						if (Double.parseDouble(HR16Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 16) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR16Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 16) + 1));
						}
						// totalCountOfValuesInSummarizedHR16Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 16) + 1));
						// confidenceOfSummarizedHR16Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 16, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 16) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 16) * 100.0));
						
						// HR17Val

						// averageOfSummarizedHR17Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 17) + Double.parseDouble(HR17Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 17) + 1));
						// summarizedHR17Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 17) + Double.parseDouble(HR17Val)));
						// countOfZeroValuesInSummarizedHR17Val
						if (Double.parseDouble(HR17Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 17) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR17Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 17) + 1));
						}
						// totalCountOfValuesInSummarizedHR17Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 17) + 1));
						// confidenceOfSummarizedHR17Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 17, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 17) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 17) * 100.0));
						
						// HR18Val

						// averageOfSummarizedHR18Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 18) + Double.parseDouble(HR18Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 18) + 1));
						// summarizedHR18Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 18) + Double.parseDouble(HR18Val)));
						// countOfZeroValuesInSummarizedHR18Val
						if (Double.parseDouble(HR18Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 18) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR18Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 18) + 1));
						}
						// totalCountOfValuesInSummarizedHR18Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 18) + 1));
						// confidenceOfSummarizedHR18Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 18, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 18) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 18) * 100.0));
						
						// HR19Val

						// averageOfSummarizedHR19Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 19) + Double.parseDouble(HR19Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 19) + 1));
						// summarizedHR19Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 19) + Double.parseDouble(HR19Val)));
						// countOfZeroValuesInSummarizedHR19Val
						if (Double.parseDouble(HR19Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 19) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR19Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 19) + 1));
						}
						// totalCountOfValuesInSummarizedHR19Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 19) + 1));
						// confidenceOfSummarizedHR19Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 19, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 19) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 19) * 100.0));
						
						// HR20Val

						// averageOfSummarizedHR20Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 20) + Double.parseDouble(HR20Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 20) + 1));
						// summarizedHR20Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 20) + Double.parseDouble(HR20Val)));
						// countOfZeroValuesInSummarizedHR20Val
						if (Double.parseDouble(HR20Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 20) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR20Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 20) + 1));
						}
						// totalCountOfValuesInSummarizedHR20Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 20) + 1));
						// confidenceOfSummarizedHR20Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 20, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 20) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 20) * 100.0));
						
						// HR21Val

						// averageOfSummarizedHR21Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 21) + Double.parseDouble(HR21Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 21) + 1));
						// summarizedHR21Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 21) + Double.parseDouble(HR21Val)));
						// countOfZeroValuesInSummarizedHR21Val
						if (Double.parseDouble(HR21Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 21) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR21Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 21) + 1));
						}
						// totalCountOfValuesInSummarizedHR21Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 21) + 1));
						// confidenceOfSummarizedHR21Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 21, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 21) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 21) * 100.0));
						
						// HR22Val

						// averageOfSummarizedHR22Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 22) + Double.parseDouble(HR22Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 22) + 1));
						// summarizedHR22Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 22) + Double.parseDouble(HR22Val)));
						// countOfZeroValuesInSummarizedHR22Val
						if (Double.parseDouble(HR22Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 22) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR22Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 22) + 1));
						}
						// totalCountOfValuesInSummarizedHR22Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 22) + 1));
						// confidenceOfSummarizedHR22Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 22, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 22) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 22) * 100.0));
						
						// HR23Val

						// averageOfSummarizedHR23Val
						summarizedHistoricalPrecipitationData.get(k).set(0 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 23) + Double.parseDouble(HR23Val)) / (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 23) + 1));
						// summarizedHR23Val
						summarizedHistoricalPrecipitationData.get(k).set(1 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(1 + 6 * 23) + Double.parseDouble(HR23Val)));
						// countOfZeroValuesInSummarizedHR23Val
						if (Double.parseDouble(HR23Val) == 0) {
							summarizedHistoricalPrecipitationData.get(k).set(2 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(2 + 6 * 23) + 1));
						}
						// countOfNonZeroValuesInSummarizedHR23Val
						else {
							summarizedHistoricalPrecipitationData.get(k).set(3 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 23) + 1));
						}
						// totalCountOfValuesInSummarizedHR23Val
						summarizedHistoricalPrecipitationData.get(k).set(4 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 23) + 1));
						// confidenceOfSummarizedHR23Val
						summarizedHistoricalPrecipitationData.get(k).set(5 + 6 * 23, (summarizedHistoricalPrecipitationData.get(k).get(3 + 6 * 23) / summarizedHistoricalPrecipitationData.get(k).get(4 + 6 * 23) * 100.0));
						
					}
					
					else if (summarizedHistoricalPrecipitationData.containsKey(k) == false) {
						
						// HR00Val
						double averageOfSummarizedHR00Val = Double.parseDouble(HR00Val);
						double summarizedHR00Val = Double.parseDouble(HR00Val);
						double countOfZeroValuesInSummarizedHR00Val = 0;
						double countOfNonZeroValuesInSummarizedHR00Val = 0;
						if (Double.parseDouble(HR00Val) == 0) {
							countOfZeroValuesInSummarizedHR00Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR00Val += 1;
						}
						double totalCountOfValuesInSummarizedHR00Val = countOfZeroValuesInSummarizedHR00Val + countOfNonZeroValuesInSummarizedHR00Val;
						double confidenceOfSummarizedHR00Val = (countOfNonZeroValuesInSummarizedHR00Val / totalCountOfValuesInSummarizedHR00Val * 100.0);
						
						// HR01Val
						double averageOfSummarizedHR01Val = Double.parseDouble(HR01Val);
						double summarizedHR01Val = Double.parseDouble(HR01Val);
						double countOfZeroValuesInSummarizedHR01Val = 0;
						double countOfNonZeroValuesInSummarizedHR01Val = 0;
						if (Double.parseDouble(HR01Val) == 0) {
							countOfZeroValuesInSummarizedHR01Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR01Val += 1;
						}
						double totalCountOfValuesInSummarizedHR01Val = countOfZeroValuesInSummarizedHR01Val + countOfNonZeroValuesInSummarizedHR01Val;
						double confidenceOfSummarizedHR01Val = (countOfNonZeroValuesInSummarizedHR01Val / totalCountOfValuesInSummarizedHR01Val * 100.0);
						
						// HR02Val
						double averageOfSummarizedHR02Val = Double.parseDouble(HR02Val);
						double summarizedHR02Val = Double.parseDouble(HR02Val);
						double countOfZeroValuesInSummarizedHR02Val = 0;
						double countOfNonZeroValuesInSummarizedHR02Val = 0;
						if (Double.parseDouble(HR02Val) == 0) {
							countOfZeroValuesInSummarizedHR02Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR02Val += 1;
						}
						double totalCountOfValuesInSummarizedHR02Val = countOfZeroValuesInSummarizedHR02Val + countOfNonZeroValuesInSummarizedHR02Val;
						double confidenceOfSummarizedHR02Val = (countOfNonZeroValuesInSummarizedHR02Val / totalCountOfValuesInSummarizedHR02Val * 100.0);
						
						// HR03Val
						double averageOfSummarizedHR03Val = Double.parseDouble(HR03Val);
						double summarizedHR03Val = Double.parseDouble(HR03Val);
						double countOfZeroValuesInSummarizedHR03Val = 0;
						double countOfNonZeroValuesInSummarizedHR03Val = 0;
						if (Double.parseDouble(HR03Val) == 0) {
							countOfZeroValuesInSummarizedHR03Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR03Val += 1;
						}
						double totalCountOfValuesInSummarizedHR03Val = countOfZeroValuesInSummarizedHR03Val + countOfNonZeroValuesInSummarizedHR03Val;
						double confidenceOfSummarizedHR03Val = (countOfNonZeroValuesInSummarizedHR03Val / totalCountOfValuesInSummarizedHR03Val * 100.0);
						
						// HR04Val
						double averageOfSummarizedHR04Val = Double.parseDouble(HR04Val);
						double summarizedHR04Val = Double.parseDouble(HR04Val);
						double countOfZeroValuesInSummarizedHR04Val = 0;
						double countOfNonZeroValuesInSummarizedHR04Val = 0;
						if (Double.parseDouble(HR04Val) == 0) {
							countOfZeroValuesInSummarizedHR04Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR04Val += 1;
						}
						double totalCountOfValuesInSummarizedHR04Val = countOfZeroValuesInSummarizedHR04Val + countOfNonZeroValuesInSummarizedHR04Val;
						double confidenceOfSummarizedHR04Val = (countOfNonZeroValuesInSummarizedHR04Val / totalCountOfValuesInSummarizedHR04Val * 100.0);
						
						// HR05Val
						double averageOfSummarizedHR05Val = Double.parseDouble(HR05Val);
						double summarizedHR05Val = Double.parseDouble(HR05Val);
						double countOfZeroValuesInSummarizedHR05Val = 0;
						double countOfNonZeroValuesInSummarizedHR05Val = 0;
						if (Double.parseDouble(HR05Val) == 0) {
							countOfZeroValuesInSummarizedHR05Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR05Val += 1;
						}
						double totalCountOfValuesInSummarizedHR05Val = countOfZeroValuesInSummarizedHR05Val + countOfNonZeroValuesInSummarizedHR05Val;
						double confidenceOfSummarizedHR05Val = (countOfNonZeroValuesInSummarizedHR05Val / totalCountOfValuesInSummarizedHR05Val * 100.0);
						
						// HR06Val
						double averageOfSummarizedHR06Val = Double.parseDouble(HR06Val);
						double summarizedHR06Val = Double.parseDouble(HR06Val);
						double countOfZeroValuesInSummarizedHR06Val = 0;
						double countOfNonZeroValuesInSummarizedHR06Val = 0;
						if (Double.parseDouble(HR06Val) == 0) {
							countOfZeroValuesInSummarizedHR06Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR06Val += 1;
						}
						double totalCountOfValuesInSummarizedHR06Val = countOfZeroValuesInSummarizedHR06Val + countOfNonZeroValuesInSummarizedHR06Val;
						double confidenceOfSummarizedHR06Val = (countOfNonZeroValuesInSummarizedHR06Val / totalCountOfValuesInSummarizedHR06Val * 100.0);
						
						// HR07Val
						double averageOfSummarizedHR07Val = Double.parseDouble(HR07Val);
						double summarizedHR07Val = Double.parseDouble(HR07Val);
						double countOfZeroValuesInSummarizedHR07Val = 0;
						double countOfNonZeroValuesInSummarizedHR07Val = 0;
						if (Double.parseDouble(HR07Val) == 0) {
							countOfZeroValuesInSummarizedHR07Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR07Val += 1;
						}
						double totalCountOfValuesInSummarizedHR07Val = countOfZeroValuesInSummarizedHR07Val + countOfNonZeroValuesInSummarizedHR07Val;
						double confidenceOfSummarizedHR07Val = (countOfNonZeroValuesInSummarizedHR07Val / totalCountOfValuesInSummarizedHR07Val * 100.0);
						
						// HR08Val
						double averageOfSummarizedHR08Val = Double.parseDouble(HR08Val);
						double summarizedHR08Val = Double.parseDouble(HR08Val);
						double countOfZeroValuesInSummarizedHR08Val = 0;
						double countOfNonZeroValuesInSummarizedHR08Val = 0;
						if (Double.parseDouble(HR08Val) == 0) {
							countOfZeroValuesInSummarizedHR08Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR08Val += 1;
						}
						double totalCountOfValuesInSummarizedHR08Val = countOfZeroValuesInSummarizedHR08Val + countOfNonZeroValuesInSummarizedHR08Val;
						double confidenceOfSummarizedHR08Val = (countOfNonZeroValuesInSummarizedHR08Val / totalCountOfValuesInSummarizedHR08Val * 100.0);
						
						// HR09Val
						double averageOfSummarizedHR09Val = Double.parseDouble(HR09Val);
						double summarizedHR09Val = Double.parseDouble(HR09Val);
						double countOfZeroValuesInSummarizedHR09Val = 0;
						double countOfNonZeroValuesInSummarizedHR09Val = 0;
						if (Double.parseDouble(HR09Val) == 0) {
							countOfZeroValuesInSummarizedHR09Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR09Val += 1;
						}
						double totalCountOfValuesInSummarizedHR09Val = countOfZeroValuesInSummarizedHR09Val + countOfNonZeroValuesInSummarizedHR09Val;
						double confidenceOfSummarizedHR09Val = (countOfNonZeroValuesInSummarizedHR09Val / totalCountOfValuesInSummarizedHR09Val * 100.0);
						
						// HR10Val
						double averageOfSummarizedHR10Val = Double.parseDouble(HR10Val);
						double summarizedHR10Val = Double.parseDouble(HR10Val);
						double countOfZeroValuesInSummarizedHR10Val = 0;
						double countOfNonZeroValuesInSummarizedHR10Val = 0;
						if (Double.parseDouble(HR10Val) == 0) {
							countOfZeroValuesInSummarizedHR10Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR10Val += 1;
						}
						double totalCountOfValuesInSummarizedHR10Val = countOfZeroValuesInSummarizedHR10Val + countOfNonZeroValuesInSummarizedHR10Val;
						double confidenceOfSummarizedHR10Val = (countOfNonZeroValuesInSummarizedHR10Val / totalCountOfValuesInSummarizedHR10Val * 100.0);
						
						// HR11Val
						double averageOfSummarizedHR11Val = Double.parseDouble(HR11Val);
						double summarizedHR11Val = Double.parseDouble(HR11Val);
						double countOfZeroValuesInSummarizedHR11Val = 0;
						double countOfNonZeroValuesInSummarizedHR11Val = 0;
						if (Double.parseDouble(HR11Val) == 0) {
							countOfZeroValuesInSummarizedHR11Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR11Val += 1;
						}
						double totalCountOfValuesInSummarizedHR11Val = countOfZeroValuesInSummarizedHR11Val + countOfNonZeroValuesInSummarizedHR11Val;
						double confidenceOfSummarizedHR11Val = (countOfNonZeroValuesInSummarizedHR11Val / totalCountOfValuesInSummarizedHR11Val * 100.0);
						
						// HR12Val
						double averageOfSummarizedHR12Val = Double.parseDouble(HR12Val);
						double summarizedHR12Val = Double.parseDouble(HR12Val);
						double countOfZeroValuesInSummarizedHR12Val = 0;
						double countOfNonZeroValuesInSummarizedHR12Val = 0;
						if (Double.parseDouble(HR12Val) == 0) {
							countOfZeroValuesInSummarizedHR12Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR12Val += 1;
						}
						double totalCountOfValuesInSummarizedHR12Val = countOfZeroValuesInSummarizedHR12Val + countOfNonZeroValuesInSummarizedHR12Val;
						double confidenceOfSummarizedHR12Val = (countOfNonZeroValuesInSummarizedHR12Val / totalCountOfValuesInSummarizedHR12Val * 100.0);
						
						// HR13Val
						double averageOfSummarizedHR13Val = Double.parseDouble(HR13Val);
						double summarizedHR13Val = Double.parseDouble(HR13Val);
						double countOfZeroValuesInSummarizedHR13Val = 0;
						double countOfNonZeroValuesInSummarizedHR13Val = 0;
						if (Double.parseDouble(HR13Val) == 0) {
							countOfZeroValuesInSummarizedHR13Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR13Val += 1;
						}
						double totalCountOfValuesInSummarizedHR13Val = countOfZeroValuesInSummarizedHR13Val + countOfNonZeroValuesInSummarizedHR13Val;
						double confidenceOfSummarizedHR13Val = (countOfNonZeroValuesInSummarizedHR13Val / totalCountOfValuesInSummarizedHR13Val * 100.0);
						
						// HR14Val
						double averageOfSummarizedHR14Val = Double.parseDouble(HR14Val);
						double summarizedHR14Val = Double.parseDouble(HR14Val);
						double countOfZeroValuesInSummarizedHR14Val = 0;
						double countOfNonZeroValuesInSummarizedHR14Val = 0;
						if (Double.parseDouble(HR14Val) == 0) {
							countOfZeroValuesInSummarizedHR14Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR14Val += 1;
						}
						double totalCountOfValuesInSummarizedHR14Val = countOfZeroValuesInSummarizedHR14Val + countOfNonZeroValuesInSummarizedHR14Val;
						double confidenceOfSummarizedHR14Val = (countOfNonZeroValuesInSummarizedHR14Val / totalCountOfValuesInSummarizedHR14Val * 100.0);
						
						// HR15Val
						double averageOfSummarizedHR15Val = Double.parseDouble(HR15Val);
						double summarizedHR15Val = Double.parseDouble(HR15Val);
						double countOfZeroValuesInSummarizedHR15Val = 0;
						double countOfNonZeroValuesInSummarizedHR15Val = 0;
						if (Double.parseDouble(HR15Val) == 0) {
							countOfZeroValuesInSummarizedHR15Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR15Val += 1;
						}
						double totalCountOfValuesInSummarizedHR15Val = countOfZeroValuesInSummarizedHR15Val + countOfNonZeroValuesInSummarizedHR15Val;
						double confidenceOfSummarizedHR15Val = (countOfNonZeroValuesInSummarizedHR15Val / totalCountOfValuesInSummarizedHR15Val * 100.0);
						
						// HR16Val
						double averageOfSummarizedHR16Val = Double.parseDouble(HR16Val);
						double summarizedHR16Val = Double.parseDouble(HR16Val);
						double countOfZeroValuesInSummarizedHR16Val = 0;
						double countOfNonZeroValuesInSummarizedHR16Val = 0;
						if (Double.parseDouble(HR16Val) == 0) {
							countOfZeroValuesInSummarizedHR16Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR16Val += 1;
						}
						double totalCountOfValuesInSummarizedHR16Val = countOfZeroValuesInSummarizedHR16Val + countOfNonZeroValuesInSummarizedHR16Val;
						double confidenceOfSummarizedHR16Val = (countOfNonZeroValuesInSummarizedHR16Val / totalCountOfValuesInSummarizedHR16Val * 100.0);
						
						// HR17Val
						double averageOfSummarizedHR17Val = Double.parseDouble(HR17Val);
						double summarizedHR17Val = Double.parseDouble(HR17Val);
						double countOfZeroValuesInSummarizedHR17Val = 0;
						double countOfNonZeroValuesInSummarizedHR17Val = 0;
						if (Double.parseDouble(HR17Val) == 0) {
							countOfZeroValuesInSummarizedHR17Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR17Val += 1;
						}
						double totalCountOfValuesInSummarizedHR17Val = countOfZeroValuesInSummarizedHR17Val + countOfNonZeroValuesInSummarizedHR17Val;
						double confidenceOfSummarizedHR17Val = (countOfNonZeroValuesInSummarizedHR17Val / totalCountOfValuesInSummarizedHR17Val * 100.0);
						
						// HR18Val
						double averageOfSummarizedHR18Val = Double.parseDouble(HR18Val);
						double summarizedHR18Val = Double.parseDouble(HR18Val);
						double countOfZeroValuesInSummarizedHR18Val = 0;
						double countOfNonZeroValuesInSummarizedHR18Val = 0;
						if (Double.parseDouble(HR18Val) == 0) {
							countOfZeroValuesInSummarizedHR18Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR18Val += 1;
						}
						double totalCountOfValuesInSummarizedHR18Val = countOfZeroValuesInSummarizedHR18Val + countOfNonZeroValuesInSummarizedHR18Val;
						double confidenceOfSummarizedHR18Val = (countOfNonZeroValuesInSummarizedHR18Val / totalCountOfValuesInSummarizedHR18Val * 100.0);
						
						// HR19Val
						double averageOfSummarizedHR19Val = Double.parseDouble(HR19Val);
						double summarizedHR19Val = Double.parseDouble(HR19Val);
						double countOfZeroValuesInSummarizedHR19Val = 0;
						double countOfNonZeroValuesInSummarizedHR19Val = 0;
						if (Double.parseDouble(HR19Val) == 0) {
							countOfZeroValuesInSummarizedHR19Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR19Val += 1;
						}
						double totalCountOfValuesInSummarizedHR19Val = countOfZeroValuesInSummarizedHR19Val + countOfNonZeroValuesInSummarizedHR19Val;
						double confidenceOfSummarizedHR19Val = (countOfNonZeroValuesInSummarizedHR19Val / totalCountOfValuesInSummarizedHR19Val * 100.0);
						
						// HR20Val
						double averageOfSummarizedHR20Val = Double.parseDouble(HR20Val);
						double summarizedHR20Val = Double.parseDouble(HR20Val);
						double countOfZeroValuesInSummarizedHR20Val = 0;
						double countOfNonZeroValuesInSummarizedHR20Val = 0;
						if (Double.parseDouble(HR20Val) == 0) {
							countOfZeroValuesInSummarizedHR20Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR20Val += 1;
						}
						double totalCountOfValuesInSummarizedHR20Val = countOfZeroValuesInSummarizedHR20Val + countOfNonZeroValuesInSummarizedHR20Val;
						double confidenceOfSummarizedHR20Val = (countOfNonZeroValuesInSummarizedHR20Val / totalCountOfValuesInSummarizedHR20Val * 100.0);
						
						// HR21Val
						double averageOfSummarizedHR21Val = Double.parseDouble(HR21Val);
						double summarizedHR21Val = Double.parseDouble(HR21Val);
						double countOfZeroValuesInSummarizedHR21Val = 0;
						double countOfNonZeroValuesInSummarizedHR21Val = 0;
						if (Double.parseDouble(HR21Val) == 0) {
							countOfZeroValuesInSummarizedHR21Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR21Val += 1;
						}
						double totalCountOfValuesInSummarizedHR21Val = countOfZeroValuesInSummarizedHR21Val + countOfNonZeroValuesInSummarizedHR21Val;
						double confidenceOfSummarizedHR21Val = (countOfNonZeroValuesInSummarizedHR21Val / totalCountOfValuesInSummarizedHR21Val * 100.0);
						
						// HR22Val
						double averageOfSummarizedHR22Val = Double.parseDouble(HR22Val);
						double summarizedHR22Val = Double.parseDouble(HR22Val);
						double countOfZeroValuesInSummarizedHR22Val = 0;
						double countOfNonZeroValuesInSummarizedHR22Val = 0;
						if (Double.parseDouble(HR22Val) == 0) {
							countOfZeroValuesInSummarizedHR22Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR22Val += 1;
						}
						double totalCountOfValuesInSummarizedHR22Val = countOfZeroValuesInSummarizedHR22Val + countOfNonZeroValuesInSummarizedHR22Val;
						double confidenceOfSummarizedHR22Val = (countOfNonZeroValuesInSummarizedHR22Val / totalCountOfValuesInSummarizedHR22Val * 100.0);
						
						// HR23Val
						double averageOfSummarizedHR23Val = Double.parseDouble(HR23Val);
						double summarizedHR23Val = Double.parseDouble(HR23Val);
						double countOfZeroValuesInSummarizedHR23Val = 0;
						double countOfNonZeroValuesInSummarizedHR23Val = 0;
						if (Double.parseDouble(HR23Val) == 0) {
							countOfZeroValuesInSummarizedHR23Val += 1;
						} else {
							countOfNonZeroValuesInSummarizedHR23Val += 1;
						}
						double totalCountOfValuesInSummarizedHR23Val = countOfZeroValuesInSummarizedHR23Val + countOfNonZeroValuesInSummarizedHR23Val;
						double confidenceOfSummarizedHR23Val = (countOfNonZeroValuesInSummarizedHR23Val / totalCountOfValuesInSummarizedHR23Val * 100.0);
						
						ArrayList<Double> initialSummarizedHistoricalPrecipitationDataRow = new ArrayList<Double>(Arrays.asList(averageOfSummarizedHR00Val, summarizedHR00Val, countOfZeroValuesInSummarizedHR00Val, countOfNonZeroValuesInSummarizedHR00Val, totalCountOfValuesInSummarizedHR00Val, confidenceOfSummarizedHR00Val, averageOfSummarizedHR01Val, summarizedHR01Val, countOfZeroValuesInSummarizedHR01Val, countOfNonZeroValuesInSummarizedHR01Val, totalCountOfValuesInSummarizedHR01Val, confidenceOfSummarizedHR01Val, averageOfSummarizedHR02Val, summarizedHR02Val, countOfZeroValuesInSummarizedHR02Val, countOfNonZeroValuesInSummarizedHR02Val, totalCountOfValuesInSummarizedHR02Val, confidenceOfSummarizedHR02Val, averageOfSummarizedHR03Val, summarizedHR03Val, countOfZeroValuesInSummarizedHR03Val, countOfNonZeroValuesInSummarizedHR03Val, totalCountOfValuesInSummarizedHR03Val, confidenceOfSummarizedHR03Val, averageOfSummarizedHR04Val, summarizedHR04Val, countOfZeroValuesInSummarizedHR04Val, countOfNonZeroValuesInSummarizedHR04Val, totalCountOfValuesInSummarizedHR04Val, confidenceOfSummarizedHR04Val, averageOfSummarizedHR05Val, summarizedHR05Val, countOfZeroValuesInSummarizedHR05Val, countOfNonZeroValuesInSummarizedHR05Val, totalCountOfValuesInSummarizedHR05Val, confidenceOfSummarizedHR05Val, averageOfSummarizedHR06Val, summarizedHR06Val, countOfZeroValuesInSummarizedHR06Val, countOfNonZeroValuesInSummarizedHR06Val, totalCountOfValuesInSummarizedHR06Val, confidenceOfSummarizedHR06Val, averageOfSummarizedHR07Val, summarizedHR07Val, countOfZeroValuesInSummarizedHR07Val, countOfNonZeroValuesInSummarizedHR07Val, totalCountOfValuesInSummarizedHR07Val, confidenceOfSummarizedHR07Val, averageOfSummarizedHR08Val, summarizedHR08Val, countOfZeroValuesInSummarizedHR08Val, countOfNonZeroValuesInSummarizedHR08Val, totalCountOfValuesInSummarizedHR08Val, confidenceOfSummarizedHR08Val, averageOfSummarizedHR09Val, summarizedHR09Val, countOfZeroValuesInSummarizedHR09Val, countOfNonZeroValuesInSummarizedHR09Val, totalCountOfValuesInSummarizedHR09Val, confidenceOfSummarizedHR09Val, averageOfSummarizedHR10Val, summarizedHR10Val, countOfZeroValuesInSummarizedHR10Val, countOfNonZeroValuesInSummarizedHR10Val, totalCountOfValuesInSummarizedHR10Val, confidenceOfSummarizedHR10Val, averageOfSummarizedHR11Val, summarizedHR11Val, countOfZeroValuesInSummarizedHR11Val, countOfNonZeroValuesInSummarizedHR11Val, totalCountOfValuesInSummarizedHR11Val, confidenceOfSummarizedHR11Val, averageOfSummarizedHR12Val, summarizedHR12Val, countOfZeroValuesInSummarizedHR12Val, countOfNonZeroValuesInSummarizedHR12Val, totalCountOfValuesInSummarizedHR12Val, confidenceOfSummarizedHR12Val, averageOfSummarizedHR13Val, summarizedHR13Val, countOfZeroValuesInSummarizedHR13Val, countOfNonZeroValuesInSummarizedHR13Val, totalCountOfValuesInSummarizedHR13Val, confidenceOfSummarizedHR13Val, averageOfSummarizedHR14Val, summarizedHR14Val, countOfZeroValuesInSummarizedHR14Val, countOfNonZeroValuesInSummarizedHR14Val, totalCountOfValuesInSummarizedHR14Val, confidenceOfSummarizedHR14Val, averageOfSummarizedHR15Val, summarizedHR15Val, countOfZeroValuesInSummarizedHR15Val, countOfNonZeroValuesInSummarizedHR15Val, totalCountOfValuesInSummarizedHR15Val, confidenceOfSummarizedHR15Val, averageOfSummarizedHR16Val, summarizedHR16Val, countOfZeroValuesInSummarizedHR16Val, countOfNonZeroValuesInSummarizedHR16Val, totalCountOfValuesInSummarizedHR16Val, confidenceOfSummarizedHR16Val, averageOfSummarizedHR17Val, summarizedHR17Val, countOfZeroValuesInSummarizedHR17Val, countOfNonZeroValuesInSummarizedHR17Val, totalCountOfValuesInSummarizedHR17Val, confidenceOfSummarizedHR17Val, averageOfSummarizedHR18Val, summarizedHR18Val, countOfZeroValuesInSummarizedHR18Val, countOfNonZeroValuesInSummarizedHR18Val, totalCountOfValuesInSummarizedHR18Val, confidenceOfSummarizedHR18Val, averageOfSummarizedHR19Val, summarizedHR19Val, countOfZeroValuesInSummarizedHR19Val, countOfNonZeroValuesInSummarizedHR19Val, totalCountOfValuesInSummarizedHR19Val, confidenceOfSummarizedHR19Val, averageOfSummarizedHR20Val, summarizedHR20Val, countOfZeroValuesInSummarizedHR20Val, countOfNonZeroValuesInSummarizedHR20Val, totalCountOfValuesInSummarizedHR20Val, confidenceOfSummarizedHR20Val, averageOfSummarizedHR21Val, summarizedHR21Val, countOfZeroValuesInSummarizedHR21Val, countOfNonZeroValuesInSummarizedHR21Val, totalCountOfValuesInSummarizedHR21Val, confidenceOfSummarizedHR21Val, averageOfSummarizedHR22Val, summarizedHR22Val, countOfZeroValuesInSummarizedHR22Val, countOfNonZeroValuesInSummarizedHR22Val, totalCountOfValuesInSummarizedHR22Val, confidenceOfSummarizedHR22Val, averageOfSummarizedHR23Val, summarizedHR23Val, countOfZeroValuesInSummarizedHR23Val, countOfNonZeroValuesInSummarizedHR23Val, totalCountOfValuesInSummarizedHR23Val, confidenceOfSummarizedHR23Val));
						
						summarizedHistoricalPrecipitationData.put(k, initialSummarizedHistoricalPrecipitationDataRow);
					}
				}
			}
			return summarizedHistoricalPrecipitationData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}