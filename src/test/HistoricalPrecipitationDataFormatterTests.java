package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.file.*;

/*
 * Reference(s):
 * JUnit [Computer software]. (2021). Retrieved from https://junit.org/junit5/
 */

class HistoricalPrecipitationDataFormatterTests {

	@Test
	void historicalPrecipitationDataFormatterTestsForCountOfFourteenKeys() throws Exception {
		/*
		 * Tested on 4/23/2021
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 14 as the size of its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(14, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").size());
		assertEquals(14, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").size());
		assertEquals(14, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").size());
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForCountOfLengthPerValue() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 48 as the size of its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(48, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").size());
		assertEquals(48, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").size());
		assertEquals(48, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").size());
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForValueOfKeys() throws Exception {
		/*
		 * Tested on 4/23/2021
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 14 keys of dates as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals("[03-06, 03-07, 03-08, 03-09, 03-10, 03-11, 03-12, 03-13, 03-14, 03-15, 03-16, 03-17, 03-18, 03-19]", main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").keySet().toString());
		assertEquals("[12-31, 01-01, 01-02, 01-03, 01-04, 01-05, 01-06, 01-07, 01-08, 01-09, 01-10, 01-11, 01-12, 01-13]", main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").keySet().toString());
		assertEquals("[02-28, 02-29, 03-01, 03-02, 03-03, 03-04, 03-05, 03-06, 03-07, 03-08, 03-09, 03-10, 03-11, 03-12]", main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").keySet().toString());
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR00Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR00Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR00Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(0));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(0));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(0));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(0));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR00Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR00Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR00Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(1));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(1));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(1));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(1));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR01Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR01Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR01Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(2));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(2));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(2));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(2));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR01Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR01Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR01Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(3));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(3));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(3));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(3));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR02Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR02Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR02Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(4));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(4));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(4));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(4));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR02Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR02Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR02Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(5));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(5));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(5));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(5));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR03Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR03Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR03Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(6));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(6));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(6));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(6));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR03Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR03Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR03Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(7));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(7));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(7));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(7));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR04Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR04Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR04Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(8));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(8));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(8));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(8));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR04Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR04Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR04Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(9));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(9));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(9));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(9));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR05Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR05Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR05Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(10));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(10));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(10));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(10));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR05Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR05Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR05Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(11));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(11));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(11));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(11));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR06Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR06Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR06Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(12));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(12));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(12));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(12));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR06Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR06Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR06Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(13));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(13));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(13));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(13));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR07Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR07Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR07Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(14));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(14));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(14));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(14));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR07Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR07Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR07Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(15));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(15));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(15));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(15));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR08Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR08Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR08Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(16));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(16));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(16));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(16));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR08Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR08Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR08Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(17));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(17));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(17));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(17));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR09Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR09Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR09Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(18));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(18));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(18));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(18));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR09Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR09Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR09Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(19));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(19));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(19));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(19));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR10Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR10Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR10Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(20));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(20));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(20));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(20));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR10Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR10Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR10Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(21));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(21));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(21));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(21));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR11Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR11Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR11Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(22));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(22));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(22));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(22));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR11Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR11Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR11Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(23));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(23));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(23));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(23));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR12Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR12Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR12Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(24));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(24));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(24));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(24));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR12Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR12Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR12Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(25));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(25));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(25));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(25));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR13Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR13Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR13Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(26));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(26));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(26));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(26));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR13Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR13Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR13Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(27));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(27));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(27));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(27));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR14Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR14Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR14Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(28));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(28));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(28));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(28));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR14Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR14Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR14Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(29));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(29));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(29));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(29));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR15Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR15Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR15Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(30));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(30));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(30));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(30));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR15Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR15Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR15Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(31));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(31));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(31));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(31));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR16Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR16Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR16Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(32));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(32));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(32));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(32));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR16Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR16Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR16Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(33));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(33));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(33));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(33));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR17Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR17Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR17Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(34));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(34));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(34));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(34));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR17Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR17Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR17Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(35));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(35));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(35));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(35));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR18Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR18Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR18Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(36));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(36));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(36));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(36));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR18Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR18Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR18Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(37));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(37));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(37));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(37));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR19Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR19Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR19Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(38));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(38));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(38));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(38));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR19Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR19Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR19Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(39));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(39));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(39));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(39));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR20Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR20Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR20Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(40));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(40));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(40));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(40));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR20Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR20Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR20Val for a given value as its output when given one of the following .csv files and dates
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(41));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(41));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(41));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(41));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR21Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR21Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR21Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(42));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(42));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(42));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(42));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR21Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR21Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR21Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(43));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(43));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(43));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(43));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR22Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR22Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR22Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(44));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(44));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(44));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(44));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR22Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR22Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR22Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(45));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(45));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(45));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(45));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForAverageOfSummarizedHR23Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, averageOfSummarizedHR23Val = (0 + 4 + 6) / 3 = 10 / 3 = 3.33... which rounds to 3.3
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 3.3 as averageOfSummarizedHR23Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(46));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(46));
		
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(46));
		assertEquals(3.3, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(46));
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForConfidenceOfSummarizedHR23Val() throws Exception {
		/*
		 * Tested on 3/23/2021
		 * For each date, confidenceOfSummarizedHR23Val = 2 / 3 * 100.00 = 66.66...% which rounds to 66.7%
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return 66.7 as rounded confidenceOfSummarizedHR23Val for a given value as its output when given one of the following .csv files and dates
		 * Example Station 6.csv, 03-06-2017
		 * Example Station 7.csv, 12-31-2017
		 * Example Station 8.csv, 02-28-2012
		 */
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-06").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-07").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-08").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-09").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-10").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-11").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 6.csv", "03", "06", "2017").get("03-12").get(47));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("12-31").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-01").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-02").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-03").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-04").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-05").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 7.csv", "12", "31", "2017").get("01-06").get(47));
		
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-28").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("02-29").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-01").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-02").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-03").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-04").get(47));
		assertEquals(66.7, main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example Station 8.csv", "02", "28", "2012").get("03-05").get(47));
	}

	@Test
	void historicalPrecipitationDataFormatterTestsForNonExistentFiles() {
		/*
		 * Tested on 3/23/2021
		 * Tests if formatHistoricalPrecipitationData(String formatHistoricalPrecipitationData(String filteredHistoricalPrecipitationDataFilePath, String givenMonth, String givenDay, String givenYear)
		 * will return the expected exception when given one of the following .csv files that does not exist as input
		 * Example CSV File 3.csv
		 * Example CSV File 4.csv
		 * Example CSV File 5.csv
		 */
		Exception e1 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example CSV File 3.csv", "03", "06", "2017"));
		assertEquals("src\\example\\Example CSV File 3.csv", e1.getMessage());
		Exception e2 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example CSV File 4.csv", "12", "31", "2017"));
		assertEquals("src\\example\\Example CSV File 4.csv", e2.getMessage());
		Exception e3 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataFormatter.formatHistoricalPrecipitationData("src/example/Example CSV File 5.csv", "02", "28", "2012"));
		assertEquals("src\\example\\Example CSV File 5.csv", e3.getMessage());
	}
	
	@Test
	void historicalPrecipitationDataFormatterTestsForRoundingNumbersToOneDecimalPlace() throws Exception {
		/*
		 * Tested on 3/24/2021
		 * Tests if roundNumberToOneDecimalPlace(Double firstNumber)
		 * will round a Double to one decimal place
		 */
		assertEquals(0.0, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.0));
		assertEquals(0.1, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.1));
		assertEquals(0.2, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.2));
		
		assertEquals(0.0, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.04));
		assertEquals(0.1, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.05));
		assertEquals(0.1, main.HistoricalPrecipitationDataFormatter.roundNumberToOneDecimalPlace(0.06));
		}
}