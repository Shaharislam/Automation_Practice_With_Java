// package mystore.automation.webpages;


// import com.opencsv.CSVReader;
// import com.opencsv.exceptions.CsvValidationException;
// import mystore.automation.helpers.DriverHelper;
// import org.apache.commons.csv.CSVFormat;

// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVRecord;
// import org.testng.annotations.DataProvider;

// import java.io.FileNotFoundException;
// import java.io.FileReader;
// import java.io.IOException;
// import java.io.Reader;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.List;
// import java.util.stream.IntStream;

// import static org.apache.commons.csv.CSVFormat.DEFAULT;


// public class CsvFileTest extends DriverHelper {
//     String email;
//     String password;
//     public void CsvFileReadMethod() throws IOException, CsvValidationException {

//         CSVReader reader=new CSVReader(new FileReader("src/test/ExcelSheet/CSVData.csv"));
//         StringBuffer buffer = new StringBuffer();
//         String data[];
//         while ((data=reader.readNext()) !=null)
//         {
//             for (int i = 0; i < data.length ; i++) {

//                 if(i==0)
//                 {
//                 email=data[i];
//                    System.out.println("Data["+i+"]= "+email);
//                 }
//                 else {
//                       password=data[i];
//                       System.out.println("PasswordData["+i+"]= "+password);
//                 }
//             }
//             System.out.println(" ");
//         }

//     }



//     public static Object[][] readCsvData(String fileName) {
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
