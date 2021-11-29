package demoqa.filesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesTest {
    @Test
    void uploadFileWithAbsolutePathTest() {
        open("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/test.jpg");
        $("input[type='file']").uploadFile(file);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("test.jpg"));
    }

    @Test
    void uploadFileWithRelativePathTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("test.jpg");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("test.jpg"));
    }

    @Test
    @DisplayName("Download file test")
    void downloadFileTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File download = $("#raw-url").download();
        String fileContent = IOUtils.toString(new FileReader(download));
        assertTrue(fileContent.contains("This repository is the home of the next generation of JUnit"));
    }

    @Test
    @DisplayName("Download pdf file test")
    void downloadPdfTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdf = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(pdf);
        Assertions.assertEquals(166, parsedPdf.numberOfPages);
    }

    @Test
    @DisplayName("Download Excel file test")
    void downloadExcelTest() throws IOException {
        open("http://romashka2008.ru/price");
        File xls = $$("a[href*='prajs']").find(text("Скачать Прайс-лист Excel")).download();
        XLS parsedXls = new XLS(xls);
        boolean checkPassed = parsedXls.excel.
                getSheetAt(0).
                getRow(11).
                getCell(1).
                getStringCellValue().contains("Сахалинская обл");
        assertTrue(checkPassed);
    }

    @Test
    @DisplayName("Parsing csv file test")
    void parseCsvTest() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream input = classLoader.getResourceAsStream("example.csv");
             Reader reader = new InputStreamReader(input)) {
            CSVReader parser = new CSVReader(reader);

            List<String[]> strings = parser.readAll();
            assertTrue(strings.size() == 2);
        }
    }

    @Test
    @DisplayName("Parsing zip file test")
    void parseZipFileTest() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream input = classLoader.getResourceAsStream("example.zip");
             ZipInputStream zipFile = new ZipInputStream(input)) {
            ZipEntry entry;
            while ((entry = zipFile.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }
}
