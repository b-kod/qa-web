package demoqa.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class JUnitTestExample {
    static Stream<Arguments> uploadFileWithRelativePathTest() {
        return Stream.of(
                Arguments.of("example.csv", "example.csv"),
                Arguments.of("example.txt", "example.txt"),
                Arguments.of("example.zip", "example.zip"),
                Arguments.of("test.jpg", "test.jpg")
        );
    }

//    @ValueSource(strings = {"example.csv", "example.txt", "example.zip", "test.jpg"})
//    @CsvSource({
//            "example.csv, example.csv",
//            "example.txt, example.txt",
//            "example.zip, example.zip",
//            "test.jpg, test.jpg"
//    })

    @MethodSource
    @Tag("blocker")
    @ParameterizedTest(name = "Тесты на загрузку файла {0}")
    void uploadFileWithRelativePathTest(String fileName, String expectedFileName) {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath(fileName);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text(expectedFileName));
    }
}
