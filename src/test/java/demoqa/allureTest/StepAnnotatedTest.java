package demoqa.allureTest;

import demoqa.allureTest.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class StepAnnotatedTest {
    private WebSteps steps = new WebSteps();
    private static final String REPOSITORY = "b-kod/qa-web";

    @Test
    public void githubTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.shouldBeIssuesOnThePage();
    }
}
