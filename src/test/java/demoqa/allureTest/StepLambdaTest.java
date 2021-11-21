package demoqa.allureTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
    private static final String REPOSITORY = "b-kod/qa-web";

    @Test
    public void githubTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Открываем страницу репозитория", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Проверяем, есть ли на странице репозитория Issues", () -> {
            $(partialLinkText("Issues")).should(Condition.exist);
        });
    }
}
