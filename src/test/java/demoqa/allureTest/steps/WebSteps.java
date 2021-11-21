package demoqa.allureTest.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Открываем страницу репозитория")
    public void openRepositoryPage(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Проверяем, есть ли на странице репозитория Issues")
    public void shouldBeIssuesOnThePage() {
        $(partialLinkText("Issues")).should(Condition.exist);
    }
}
