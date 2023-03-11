// package mystore.automation.webpages;

// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVRecord;

// import java.io.IOException;
// import java.io.Reader;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.List;
// import java.util.stream.IntStream;

// import static org.apache.commons.csv.CSVFormat.DEFAULT;

// public class DataStore {
//     public static Object[][] receiveCsvData(String fileName) {
//         try {
//             Reader reader = Files.newBufferedReader(Paths.get(fileName));
//             CSVParser csvParser = new CSVParser(reader,DEFAULT.withFirstRecordAsHeader().withTrim());

//             List<CSVRecord> records = csvParser.getRecords();
//             String[] headers = csvParser.getHeaderMap().keySet().toArray(new String[0]);
//             Object[][] data = new Object[records.size()][headers.length];
//             records.forEach((CSVRecord record) -> {
//                 int i = (int) record.getRecordNumber() - 1;
//                 IntStream.range(0, headers.length).forEach(j -> data[i][j] = record.get(headers[j]));
//             });
//             return data;
//         } catch (IOException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

// }
