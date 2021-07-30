package main;

import java.math.*;
import java.util.*;

/*
 * Contains:
 * roundNumberToOneDecimalPlace(Double firstNumber)
 * formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
 */

public class HistoricalPrecipitationDataFormatter {

	public static void main(String[] args) throws Exception {
	}

	public static Double roundNumberToOneDecimalPlace(Double firstNumber) throws Exception {
		/*
		 * Rounds a Double to one decimal place
		 * Input is a Double
		 * Output is a Double rounded to one decimal place
		 * For example, 66.66666666666666 will be rounded to 66.7
		 */
		try {
			BigDecimal secondNumber = new BigDecimal(firstNumber);
			// Converts Double firstNumber to BigDecimal secondNumber
			
			BigDecimal thirdNumber = secondNumber.setScale(1, RoundingMode.HALF_UP);
			// BigDecimal thirdNumber is rounded from BigDecimal secondNumber
			
			Double fourthNumber = thirdNumber.doubleValue();
			// Converts BigDecimal thirdNumber to Double fourthNumber
			
			return fourthNumber;
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e;
		}
	}
	
	public static LinkedHashMap<String, ArrayList<Double>> formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear) throws Exception {
		/*
		 * Input is a file path of a .csv file, a month in mm format, a day in dd format, and a year in yyyy format
		 * Output is a LinkedHashMap<String, ArrayList<Double>> containing precipitation data for 14 days including the day of the input date
		 * The keys of this LinkedHashMap<String, ArrayList<Double>> will be dates in month-day format such as 03-07
		 * The values of this LinkedHashMap<String, ArrayList<Double>> will be a list of 24 pairs of numbers with each pair containing an average value of precipitation for an hourly range and a percent value representing the confidence for that average value of precipitation for an hourly range such as
		 * [4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7, 4.0, 66.7]
		 * Each Double in this LinkedHashMap<String, ArrayList<Double>> will be rounded to one decimal place
		 * For example, 66.66666666666666 will be rounded to 66.7
		 * Therefore, this LinkedHashMap<String, ArrayList<Double>> will contain 14 keys that are dates in month-day format and 14 values that are lists of 48 numbers
		 * 
		 * Reference(s):
		 * Hourly Precipitation Data (HPD) Network, Version 2. [2.0], NOAA National Centers for Environmental Information. [February 25, 2021].
		 */
		try {
			LinkedHashMap<String, ArrayList<Double>> filteredHistoricalPrecipitationData = main.HistoricalPrecipitationDataFilter.filterHistoricalPrecipitationData(filteredHistoricalPrecipitationDataFilePath, givenMonth, givenDay, givenYear);
			
			LinkedHashMap<String, ArrayList<Double>> formattedHistoricalPrecipitationData = new LinkedHashMap<String, ArrayList<Double>>();
									
			for (String key : filteredHistoricalPrecipitationData.keySet()) {
				formattedHistoricalPrecipitationData.put(key, new ArrayList<Double>(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0)));
				// Adds a new entry to formattedHistoricalPrecipitationData where its key is a date in month-day format such as 03-07 and its value is ArrayList<Double> containing 48 elements where each of these elements is 0.0
				
				for (int i = 0; i < 48; i++) {
					if (i % 2 == 0) {
						// Each even index corresponds to an average of a summarized value for an hourly range
						
						Double averageOfSummarizedValueForAnHourlyRange = filteredHistoricalPrecipitationData.get(key).get(i);
												
						formattedHistoricalPrecipitationData.get(key).set(i, roundNumberToOneDecimalPlace(averageOfSummarizedValueForAnHourlyRange));
						// Rounds an average of a summarized value for an hourly range to one decimal place
					} else {
						// Each odd index corresponds to a confidence of a summarized value for an hourly range
						
						Double confidenceOfSummarizedValueForAnHourlyRange = filteredHistoricalPrecipitationData.get(key).get(i);

						formattedHistoricalPrecipitationData.get(key).set(i, roundNumberToOneDecimalPlace(confidenceOfSummarizedValueForAnHourlyRange));
						// Rounds a confidence of a summarized value for an hourly range to one decimal place
					}
				}
			}
			return formattedHistoricalPrecipitationData;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}