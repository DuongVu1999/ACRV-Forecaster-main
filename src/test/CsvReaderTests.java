package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.file.*;

/*
 * Reference(s):
 * JUnit [Computer software]. (2021). Retrieved from https://junit.org/junit5/
 */

class CsvReaderTests {

	@Test
	void csvReaderTestsForCsvFileWithEqualNumberOfColumnsAndRows() throws Exception {
		// Tests if readCsvFile(String csvFilePath)
		// will return the expected output for a .csv file with an equal number of columns and rows as input
		assertEquals("Column Header 1,Column Header 2,Column Header 3,Column Header 4,Column Header 5", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(0));
		assertEquals("a,b,c,d,e", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(1));
		assertEquals("f,g,h,i,j", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(2));
		assertEquals("k,l,m,n,o", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(3));
		assertEquals("p,q,r,s,t", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(4));
		assertEquals("u,v,w,x,y", main.CsvReader.readCsvFile("src/example/Example CSV File 1.csv").get(5));
	}

	@Test
	void csvReaderTestsForCsvFileWithUnequalNumberOfColumnsAndRows() throws Exception {
		// Tests if readCsvFile(String csvFilePath)
		// will return the expected output for a .csv file with an unequal number of columns and rows as input
		assertEquals("Column Header A,Column Header B,Column Header C", main.CsvReader.readCsvFile("src/example/Example CSV File 2.csv").get(0));
		assertEquals("0,1,2", main.CsvReader.readCsvFile("src/example/Example CSV File 2.csv").get(1));
		assertEquals("3,4,5", main.CsvReader.readCsvFile("src/example/Example CSV File 2.csv").get(2));
		assertEquals("6,7,8", main.CsvReader.readCsvFile("src/example/Example CSV File 2.csv").get(3));
	}

	@Test
	void csvReaderTestsForNonexistentFiles() {
		/*
		 * Tests if readCsvFile(String csvFilePath)
		 * will return the expected exception when given one of the following .csv files that does not exist as input
		 * Example CSV File 3.csv
		 * Example CSV File 4.csv
		 * Example CSV File 5.csv
		 */
		Exception e1 = assertThrows(NoSuchFileException.class, () -> main.CsvReader.readCsvFile("src/example/Example CSV File 3.csv"));
		assertEquals("src\\example\\Example CSV File 3.csv", e1.getMessage());
		Exception e2 = assertThrows(NoSuchFileException.class, () -> main.CsvReader.readCsvFile("src/example/Example CSV File 4.csv"));
		assertEquals("src\\example\\Example CSV File 4.csv", e2.getMessage());
		Exception e3 = assertThrows(NoSuchFileException.class, () -> main.CsvReader.readCsvFile("src/example/Example CSV File 5.csv"));
		assertEquals("src\\example\\Example CSV File 5.csv", e3.getMessage());
	}
}