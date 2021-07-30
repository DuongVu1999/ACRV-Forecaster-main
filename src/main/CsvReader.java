package main;

import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

/*
 * Contains readCsvFile(String csvFilePath)
 * Reads a .csv file
 * Input is a file path of a .csv file
 * Output is a ArrayList<String> where each element of this ArrayList<String> is a row of a .csv file as a string
 * [Column Header A,Column Header B,Column Header C, 0,1,2, 3,4,5, 6,7,8]
 */

public class CsvReader {

	public static void main(String[] args) throws Exception {
	}

	public static ArrayList<String> readCsvFile(String csvFilePath) throws Exception {
		try {
			ArrayList<String> csvFileRows = (ArrayList<String>) Files.readAllLines(Paths.get(csvFilePath), StandardCharsets.UTF_8);
			// ArrayList<String> csvFileRows will contain every row from the given .csv file, including the header row
			
			return csvFileRows;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}