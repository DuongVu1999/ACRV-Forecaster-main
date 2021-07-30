package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.file.*;

/*
 * Reference(s):
 * JUnit [Computer software]. (2021). Retrieved from https://junit.org/junit5/
 */

class HistoricalPrecipitationDataOrganizerTests {
	
	@Test
	void historicalPrecipitationDataOrganizerTestsForCountOfThreeKeys() throws Exception {
		/*
		 * Tests if organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
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
		 * This is because its output should contain the following three keys that each have three values:
		 * 02-26
		 * 02-27
		 * 02-28
		 */
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").size());
	}
	
	@Test
	void historicalPrecipitationDataOrganizerTestsForCountOfThreeValuesPerKey() throws Exception {
		/*
		 * Tests if organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
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
		 * This is because its output should contain the following three keys that each have three values
		 * 02-26
		 * 02-27
		 * 02-28
		 */
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").size());
		assertEquals(3, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").size());
	}
	
	@Test
	void historicalPrecipitationDataOrganizerTestsForCountOfTotalOfNineValues() throws Exception {
		/*
		 * Tests if organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
		 * will return 9 as the size of its output when given a .csv file of precipitation data with rows for the following dates:
		 * 2019-02-26
		 * 2019-02-27
		 * 2019-02-28
		 * 2020-02-26
		 * 2020-02-27
		 * 2020-02-28
		 * 2021-02-26
		 * 2021-02-27
		 * 2021-02-28
		 * This is because its output should contain the following three keys that each have three values:
		 * 02-26
		 * 02-27
		 * 02-28
		 */
		assertEquals(9, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-26").size() + main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-27").size() + main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 1.csv").get("02-28").size());
		assertEquals(9, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-26").size() + main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-27").size() + main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example Station 2.csv").get("02-28").size());
	}
	
	@Test
	void historicalPrecipitationDataOrganizerTestsForNumberOfEntries() throws Exception {
		// Tests if organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
		// will return 366 (366 is the number of days in a leap year) as the size of its output when given a .csv file of historical precipitation data as input
		assertEquals(366, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/input/station/USC00080845.csv").size());
		assertEquals(366, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/input/station/USC00085895.csv").size());
		assertEquals(366, main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/input/station/USC00089795.csv").size());
	}
	
	@Test
	void historicalPrecipitationDataOrganizerTestsForNonExistentFiles() {
		/*
		 * Tests if organizeHistoricalPrecipitationData(String unorganizedHistoricalPrecipitationDataFilePath)
		 * will return the expected exception when given one of the following .csv files that does not exist as input
		 * Example CSV File 3.csv
		 * Example CSV File 4.csv
		 * Example CSV File 5.csv
		 */
		Exception e1 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example CSV File 3.csv"));
		assertEquals("src\\example\\Example CSV File 3.csv", e1.getMessage());
		Exception e2 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example CSV File 4.csv"));
		assertEquals("src\\example\\Example CSV File 4.csv", e2.getMessage());
		Exception e3 = assertThrows(NoSuchFileException.class, () -> main.HistoricalPrecipitationDataOrganizer.organizeHistoricalPrecipitationData("src/example/Example CSV File 5.csv"));
		assertEquals("src\\example\\Example CSV File 5.csv", e3.getMessage());
	}
}