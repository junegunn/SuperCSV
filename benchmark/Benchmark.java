import org.supercsv.io.*;
import org.supercsv.prefs.*;
import java.io.*;
import java.util.*;

public class Benchmark {
	public static void main(String[] argv) throws Exception {
		final String FILENAME = "benchmark.csv";
		final int COUNT = 100000;
		final CsvPreference pref = CsvPreference.STANDARD_PREFERENCE;

		final String[] header = {
			// 16
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"
		};
		final String[] data = {
			"______________________",
			"\"____________\r__________\"",
			"____________\n__________",
			"______________________",
			"______________________",
			"______________________",
			"",
			null,
			"______________________",
			"_________\"\"_____________",
			"______________________",
			"_____________\"\"________________\"\"_______________",
			"____________________________________________________",
			"_______________________________________________________________________________________________",
			"_______________________________________________________________________________________________",
			"\"_______________________________________________________________________________________________\""
		};
		List<String> dataList = Arrays.asList(data);

		ICsvListWriter writer = new CsvListWriter(new BufferedWriter(new FileWriter(FILENAME)), pref);
		long st = System.currentTimeMillis();
		writer.write(header);
		for (int i = 0; i < COUNT; ++i)
			writer.write(dataList);
		writer.close();
		long elapsed = System.currentTimeMillis() - st;
		System.out.println("Write (rows/second): " + COUNT * 1000 / elapsed);

		// --------------------------------------------

		ICsvListReader reader = new CsvListReader(new BufferedReader(new FileReader(FILENAME)), pref);
		List<String> readDataList;
		st = System.currentTimeMillis();
		while ( (readDataList = reader.read()) != null);
		elapsed = System.currentTimeMillis() - st;
		System.out.println("Read (rows/second): " + COUNT * 1000 / elapsed);
	}
}
