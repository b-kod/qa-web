package demoqa.filesTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Condition;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilesTest {
    @Test
    void uploadFileTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFromClasspath("test.jpg");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(Condition.text("test.jpg"));
    }

    @Test
    void downloadFileTest() throws IOException {
        open("https://github.com/SeleniumHQ/selenium/blob/trunk/README.md");
        File downloadFile = $("#raw-url").download();
        String fileContent = IOUtils.toString(new FileReader(downloadFile));
        assertTrue(fileContent.contains("Selenium is an umbrella project"));
    }

    @Test
    void downloadPdfTest() throws IOException {
        open("https://litportal.ru/avtory/ayzek-azimov/kniga-ya-robot-1027754.html");
        File pdf = $(byText("Скачать pdf")).download();
        PDF parsedPdf = new PDF(pdf);
        String parsedPdfText = parsedPdf.text;
        assertTrue(parsedPdfText.contains("Я, робот"));
    }

    @Test
    void downloadZipTest() throws FileNotFoundException {
        open("https://litportal.ru/avtory/ayzek-azimov/kniga-ya-robot-1027754.html");
        File zipToDownload = $(byText("Скачать txt.zip")).download();
        assertTrue(zipToDownload.getName().contains("zip"));
    }
}

