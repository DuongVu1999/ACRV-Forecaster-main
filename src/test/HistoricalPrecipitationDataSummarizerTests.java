package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.file.*;

/*
 * Reference(s):
 * JUnit [Computer software]. (2021). Retrieved from https://junit.org/junit5/
 */

class HistoricalPrecipitationDataSummarizerTests {

	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfThreeKeys() throws Exception {
		/*
		 * Tests if summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath)
		 * will return 3 as the size of its output when given a .csv file of precipitation data with rows for the following dates:
		 * 2019-02-26
		 * 2019-02-27
		 * 2019-02-28
		 * 2020-02-26
		 * 2020-02-27
		 * 2020-02-28
		 * 2021-02-26
		 * 2021-02-27
		 * 2021-02-28
		 * This is because its output should contain the following three keys that each have one value
		 * 02-26
		 * 02-27
		 * 02-28
		 */
		assertEquals(3, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").size());
		assertEquals(3, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").size());
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfLengthPerValue() throws Exception {
		/*
		 * Tests if summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath)
		 * will return 144 as the size of its output when given a .csv file of precipitation data with rows for the following dates:
		 * 2019-02-26
		 * 2019-02-27
		 * 2019-02-28
		 * 2020-02-26
		 * 2020-02-27
		 * 2020-02-28
		 * 2021-02-26
		 * 2021-02-27
		 * 2021-02-28
		 * This is because its output should contain the following three keys that each have one value that should have 24 * 6 or 144 elements
		 * 02-26
		 * 02-27
		 * 02-28
		 */
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").size());
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").size());
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").size());
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").size());
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").size());
		assertEquals(144, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").size());
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForNumberOfEntries() throws Exception {
		// Tests if summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath)
		// will return 366 (366 is the number of days in a leap year) as the size of its output when given a .csv file of historical precipitation data as input
		assertEquals(366, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/input/station/USC00080845.csv").size());
		assertEquals(366, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/input/station/USC00085895.csv").size());
		assertEquals(366, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/input/station/USC00089795.csv").size());
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR00Val() throws Exception {
		// For each date, averageOfSummarizedHR00Val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 0));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 0));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 0));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 0));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 0));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 0));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR00Val() throws Exception {
		// For each date, summarizedHR00Val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 0));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 0));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 0));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 0));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 0));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 0));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR00Val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR00Val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 0));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 0));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 0));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 0));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 0));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 0));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR00Val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR00Val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 0));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 0));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 0));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 0));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 0));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 0));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR00Val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR00Val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 0));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 0));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 0));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 0));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 0));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 0));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR00Val() throws Exception {
		// For each date, confidenceOfSummarizedHR00Val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 0)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 0)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 0)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 0)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 0)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 0)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR01val() throws Exception {
		// For each date, averageOfSummarizedHR01val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 1));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 1));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 1));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 1));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 1));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 1));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR01val() throws Exception {
		// For each date, summarizedHR01val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 1));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 1));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 1));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 1));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 1));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 1));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR01val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR01val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 1));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 1));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 1));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 1));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 1));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 1));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR01val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR01val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 1));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 1));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 1));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 1));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 1));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 1));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR01val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR01val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 1));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 1));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 1));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 1));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 1));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 1));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR01val() throws Exception {
		// For each date, confidenceOfSummarizedHR01val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 1)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 1)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 1)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 1)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 1)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 1)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR02val() throws Exception {
		// For each date, averageOfSummarizedHR02val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 2));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 2));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 2));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 2));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 2));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 2));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR02val() throws Exception {
		// For each date, summarizedHR02val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 2));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 2));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 2));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 2));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 2));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 2));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR02val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR02val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 2));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 2));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 2));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 2));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 2));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 2));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR02val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR02val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 2));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 2));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 2));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 2));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 2));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 2));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR02val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR02val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 2));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 2));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 2));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 2));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 2));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 2));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR02val() throws Exception {
		// For each date, confidenceOfSummarizedHR02val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 2)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 2)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 2)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 2)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 2)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 2)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR03val() throws Exception {
		// For each date, averageOfSummarizedHR03val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 3));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 3));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 3));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 3));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 3));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 3));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR03val() throws Exception {
		// For each date, summarizedHR03val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 3));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 3));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 3));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 3));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 3));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 3));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR03val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR03val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 3));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 3));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 3));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 3));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 3));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 3));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR03val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR03val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 3));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 3));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 3));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 3));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 3));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 3));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR03val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR03val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 3));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 3));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 3));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 3));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 3));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 3));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR03val() throws Exception {
		// For each date, confidenceOfSummarizedHR03val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 3)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 3)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 3)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 3)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 3)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 3)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR04val() throws Exception {
		// For each date, averageOfSummarizedHR04val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 4));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 4));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 4));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 4));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 4));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 4));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR04val() throws Exception {
		// For each date, summarizedHR04val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 4));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 4));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 4));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 4));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 4));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 4));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR04val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR04val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 4));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 4));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 4));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 4));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 4));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 4));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR04val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR04val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 4));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 4));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 4));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 4));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 4));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 4));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR04val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR04val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 4));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 4));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 4));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 4));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 4));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 4));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR04val() throws Exception {
		// For each date, confidenceOfSummarizedHR04val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 4)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 4)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 4)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 4)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 4)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 4)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR05val() throws Exception {
		// For each date, averageOfSummarizedHR05val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 5));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 5));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 5));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 5));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 5));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 5));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR05val() throws Exception {
		// For each date, summarizedHR05val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 5));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 5));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 5));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 5));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 5));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 5));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR05val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR05val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 5));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 5));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 5));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 5));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 5));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 5));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR05val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR05val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 5));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 5));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 5));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 5));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 5));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 5));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR05val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR05val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 5));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 5));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 5));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 5));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 5));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 5));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR05val() throws Exception {
		// For each date, confidenceOfSummarizedHR05val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 5)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 5)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 5)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 5)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 5)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 5)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR06val() throws Exception {
		// For each date, averageOfSummarizedHR06val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 6));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 6));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 6));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 6));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 6));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 6));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR06val() throws Exception {
		// For each date, summarizedHR06val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 6));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 6));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 6));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 6));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 6));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 6));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR06val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR06val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 6));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 6));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 6));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 6));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 6));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 6));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR06val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR06val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 6));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 6));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 6));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 6));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 6));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 6));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR06val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR06val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 6));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 6));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 6));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 6));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 6));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 6));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR06val() throws Exception {
		// For each date, confidenceOfSummarizedHR06val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 6)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 6)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 6)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 6)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 6)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 6)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR07val() throws Exception {
		// For each date, averageOfSummarizedHR07val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 7));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 7));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 7));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 7));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 7));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 7));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR07val() throws Exception {
		// For each date, summarizedHR07val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 7));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 7));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 7));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 7));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 7));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 7));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR07val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR07val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 7));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 7));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 7));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 7));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 7));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 7));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR07val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR07val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 7));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 7));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 7));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 7));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 7));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 7));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR07val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR07val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 7));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 7));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 7));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 7));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 7));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 7));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR07val() throws Exception {
		// For each date, confidenceOfSummarizedHR07val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 7)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 7)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 7)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 7)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 7)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 7)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR08val() throws Exception {
		// For each date, averageOfSummarizedHR08val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 8));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 8));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 8));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 8));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 8));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 8));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR08val() throws Exception {
		// For each date, summarizedHR08val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 8));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 8));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 8));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 8));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 8));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 8));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR08val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR08val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 8));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 8));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 8));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 8));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 8));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 8));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR08val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR08val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 8));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 8));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 8));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 8));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 8));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 8));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR08val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR08val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 8));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 8));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 8));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 8));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 8));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 8));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR08val() throws Exception {
		// For each date, confidenceOfSummarizedHR08val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 8)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 8)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 8)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 8)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 8)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 8)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR09val() throws Exception {
		// For each date, averageOfSummarizedHR09val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 9));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 9));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 9));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 9));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 9));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 9));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR09val() throws Exception {
		// For each date, summarizedHR09val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 9));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 9));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 9));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 9));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 9));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 9));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR09val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR09val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 9));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 9));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 9));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 9));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 9));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 9));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR09val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR09val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 9));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 9));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 9));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 9));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 9));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 9));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR09val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR09val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 9));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 9));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 9));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 9));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 9));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 9));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR09val() throws Exception {
		// For each date, confidenceOfSummarizedHR09val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 9)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 9)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 9)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 9)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 9)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 9)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR10val() throws Exception {
		// For each date, averageOfSummarizedHR10val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 10));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 10));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 10));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 10));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 10));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 10));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR10val() throws Exception {
		// For each date, summarizedHR10val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 10));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 10));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 10));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 10));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 10));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 10));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR10val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR10val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 10));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 10));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 10));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 10));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 10));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 10));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR10val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR10val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 10));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 10));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 10));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 10));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 10));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 10));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR10val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR10val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 10));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 10));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 10));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 10));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 10));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 10));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR10val() throws Exception {
		// For each date, confidenceOfSummarizedHR10val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 10)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 10)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 10)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 10)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 10)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 10)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR11val() throws Exception {
		// For each date, averageOfSummarizedHR11val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 11));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 11));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 11));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 11));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 11));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 11));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR11val() throws Exception {
		// For each date, summarizedHR11val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 11));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 11));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 11));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 11));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 11));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 11));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR11val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR11val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 11));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 11));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 11));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 11));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 11));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 11));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR11val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR11val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 11));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 11));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 11));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 11));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 11));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 11));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR11val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR11val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 11));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 11));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 11));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 11));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 11));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 11));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR11val() throws Exception {
		// For each date, confidenceOfSummarizedHR11val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 11)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 11)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 11)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 11)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 11)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 11)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR12val() throws Exception {
		// For each date, averageOfSummarizedHR12val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 12));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 12));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 12));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 12));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 12));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 12));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR12val() throws Exception {
		// For each date, summarizedHR12val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 12));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 12));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 12));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 12));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 12));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 12));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR12val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR12val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 12));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 12));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 12));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 12));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 12));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 12));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR12val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR12val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 12));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 12));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 12));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 12));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 12));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 12));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR12val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR12val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 12));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 12));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 12));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 12));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 12));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 12));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR12val() throws Exception {
		// For each date, confidenceOfSummarizedHR12val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 12)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 12)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 12)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 12)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 12)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 12)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR13val() throws Exception {
		// For each date, averageOfSummarizedHR13val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 13));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 13));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 13));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 13));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 13));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 13));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR13val() throws Exception {
		// For each date, summarizedHR13val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 13));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 13));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 13));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 13));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 13));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 13));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR13val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR13val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 13));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 13));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 13));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 13));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 13));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 13));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR13val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR13val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 13));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 13));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 13));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 13));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 13));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 13));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR13val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR13val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 13));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 13));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 13));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 13));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 13));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 13));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR13val() throws Exception {
		// For each date, confidenceOfSummarizedHR13val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 13)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 13)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 13)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 13)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 13)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 13)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR14val() throws Exception {
		// For each date, averageOfSummarizedHR14val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 14));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 14));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 14));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 14));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 14));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 14));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR14val() throws Exception {
		// For each date, summarizedHR14val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 14));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 14));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 14));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 14));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 14));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 14));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR14val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR14val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 14));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 14));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 14));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 14));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 14));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 14));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR14val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR14val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 14));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 14));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 14));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 14));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 14));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 14));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR14val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR14val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 14));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 14));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 14));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 14));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 14));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 14));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR14val() throws Exception {
		// For each date, confidenceOfSummarizedHR14val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 14)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 14)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 14)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 14)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 14)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 14)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR15val() throws Exception {
		// For each date, averageOfSummarizedHR15val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 15));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 15));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 15));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 15));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 15));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 15));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR15val() throws Exception {
		// For each date, summarizedHR15val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 15));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 15));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 15));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 15));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 15));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 15));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR15val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR15val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 15));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 15));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 15));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 15));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 15));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 15));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR15val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR15val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 15));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 15));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 15));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 15));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 15));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 15));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR15val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR15val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 15));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 15));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 15));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 15));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 15));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 15));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR15val() throws Exception {
		// For each date, confidenceOfSummarizedHR15val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 15)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 15)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 15)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 15)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 15)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 15)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR16val() throws Exception {
		// For each date, averageOfSummarizedHR16val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 16));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 16));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 16));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 16));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 16));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 16));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR16val() throws Exception {
		// For each date, summarizedHR16val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 16));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 16));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 16));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 16));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 16));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 16));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR16val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR16val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 16));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 16));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 16));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 16));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 16));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 16));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR16val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR16val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 16));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 16));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 16));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 16));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 16));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 16));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR16val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR16val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 16));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 16));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 16));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 16));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 16));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 16));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR16val() throws Exception {
		// For each date, confidenceOfSummarizedHR16val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 16)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 16)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 16)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 16)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 16)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 16)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR17val() throws Exception {
		// For each date, averageOfSummarizedHR17val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 17));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 17));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 17));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 17));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 17));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 17));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR17val() throws Exception {
		// For each date, summarizedHR17val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 17));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 17));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 17));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 17));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 17));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 17));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR17val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR17val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 17));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 17));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 17));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 17));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 17));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 17));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR17val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR17val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 17));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 17));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 17));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 17));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 17));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 17));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR17val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR17val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 17));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 17));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 17));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 17));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 17));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 17));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR17val() throws Exception {
		// For each date, confidenceOfSummarizedHR17val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 17)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 17)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 17)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 17)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 17)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 17)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR18val() throws Exception {
		// For each date, averageOfSummarizedHR18val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 18));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 18));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 18));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 18));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 18));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 18));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR18val() throws Exception {
		// For each date, summarizedHR18val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 18));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 18));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 18));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 18));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 18));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 18));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR18val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR18val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 18));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 18));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 18));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 18));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 18));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 18));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR18val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR18val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 18));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 18));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 18));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 18));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 18));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 18));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR18val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR18val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 18));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 18));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 18));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 18));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 18));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 18));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR18val() throws Exception {
		// For each date, confidenceOfSummarizedHR18val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 18)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 18)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 18)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 18)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 18)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 18)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR19val() throws Exception {
		// For each date, averageOfSummarizedHR19val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 19));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 19));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 19));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 19));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 19));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 19));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR19val() throws Exception {
		// For each date, summarizedHR19val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 19));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 19));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 19));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 19));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 19));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 19));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR19val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR19val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 19));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 19));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 19));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 19));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 19));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 19));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR19val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR19val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 19));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 19));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 19));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 19));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 19));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 19));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR19val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR19val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 19));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 19));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 19));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 19));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 19));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 19));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR19val() throws Exception {
		// For each date, confidenceOfSummarizedHR19val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 19)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 19)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 19)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 19)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 19)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 19)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR20val() throws Exception {
		// For each date, averageOfSummarizedHR20val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 20));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 20));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 20));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 20));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 20));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 20));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR20val() throws Exception {
		// For each date, summarizedHR20val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 20));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 20));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 20));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 20));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 20));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 20));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR20val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR20val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 20));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 20));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 20));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 20));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 20));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 20));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR20val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR20val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 20));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 20));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 20));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 20));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 20));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 20));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR20val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR20val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 20));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 20));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 20));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 20));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 20));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 20));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR20val() throws Exception {
		// For each date, confidenceOfSummarizedHR20val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 20)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 20)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 20)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 20)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 20)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 20)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR21val() throws Exception {
		// For each date, averageOfSummarizedHR21val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 21));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 21));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 21));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 21));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 21));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 21));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR21val() throws Exception {
		// For each date, summarizedHR21val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 21));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 21));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 21));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 21));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 21));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 21));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR21val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR21val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 21));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 21));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 21));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 21));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 21));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 21));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR21val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR21val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 21));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 21));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 21));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 21));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 21));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 21));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR21val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR21val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 21));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 21));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 21));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 21));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 21));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 21));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR21val() throws Exception {
		// For each date, confidenceOfSummarizedHR21val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 21)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 21)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 21)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 21)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 21)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 21)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR22val() throws Exception {
		// For each date, averageOfSummarizedHR22val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 22));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 22));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 22));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 22));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 22));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 22));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR22val() throws Exception {
		// For each date, summarizedHR22val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 22));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 22));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 22));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 22));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 22));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 22));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR22val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR22val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 22));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 22));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 22));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 22));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 22));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 22));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR22val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR22val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 22));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 22));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 22));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 22));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 22));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 22));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR22val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR22val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 22));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 22));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 22));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 22));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 22));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 22));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR22val() throws Exception {
		// For each date, confidenceOfSummarizedHR22val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 22)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 22)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 22)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 22)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 22)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 22)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForAverageOfSummarizedHR23val() throws Exception {
		// For each date, averageOfSummarizedHR23val = (0 + 4 + 8) / 3 = 12 / 3 = 4
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(0 + 6 * 23));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(0 + 6 * 23));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(0 + 6 * 23));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(0 + 6 * 23));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(0 + 6 * 23));
		assertEquals(4.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(0 + 6 * 23));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForSummarizedHR23val() throws Exception {
		// For each date, summarizedHR23val = (0 + 4 + 8) = 12
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(1 + 6 * 23));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(1 + 6 * 23));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(1 + 6 * 23));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(1 + 6 * 23));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(1 + 6 * 23));
		assertEquals(12.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(1 + 6 * 23));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfZeroValuesInSummarizedHR23val() throws Exception {
		// For each date, countOfZeroValuesInSummarizedHR23val = 1
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(2 + 6 * 23));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(2 + 6 * 23));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(2 + 6 * 23));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(2 + 6 * 23));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(2 + 6 * 23));
		assertEquals(1.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(2 + 6 * 23));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForCountOfNonZeroValuesInSummarizedHR23val() throws Exception {
		// For each date, countOfNonZeroValuesInSummarizedHR23val = 2
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(3 + 6 * 23));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(3 + 6 * 23));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(3 + 6 * 23));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(3 + 6 * 23));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(3 + 6 * 23));
		assertEquals(2.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(3 + 6 * 23));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForTotalCountOfValuesInSummarizedHR23val() throws Exception {
		// For each date, totalCountOfValuesInSummarizedHR23val = 3
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(4 + 6 * 23));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(4 + 6 * 23));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(4 + 6 * 23));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(4 + 6 * 23));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(4 + 6 * 23));
		assertEquals(3.0, main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(4 + 6 * 23));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForConfidenceOfSummarizedHR23val() throws Exception {
		// For each date, confidenceOfSummarizedHR23val = 2 / 3 * 100.00 = 66.66...% which rounds to 67.0%
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").get(5 + 6 * 23)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").get(5 + 6 * 23)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").get(5 + 6 * 23)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").get(5 + 6 * 23)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").get(5 + 6 * 23)));
		assertEquals(67.0, Math.ceil(main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").get(5 + 6 * 23)));
	}
	
	@Test
	void historicalPrecipitationDataSummarizerTestsForNonExistentFiles() {
		/*
		 * Tests if summarizeHistoricalPrecipitationData(String organizedHistoricalPrecipitationDataFilePath)
		 * will return the expected exception when given one of the following .csv files that does not exist as input
		 * Example CSV File 3.csv
		 * Example CSV File 4.csv
		 * Example CSV File 5.csv
		 */
		Exception e1 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example CSV File 3.csv"));
		assertEquals("src\\example\\Example CSV File 3.csv", e1.getMessage());
		Exception e2 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example CSV File 4.csv"));
		assertEquals("src\\example\\Example CSV File 4.csv", e2.getMessage());
		Exception e3 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataSummarizer.summarizeHistoricalPrecipitationData("src/example/Example CSV File 5.csv"));
		assertEquals("src\\example\\Example CSV File 5.csv", e3.getMessage());
	}
}