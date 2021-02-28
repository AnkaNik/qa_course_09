
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

 class LambdaStepTest extends TestConfiguration{

    private static final String BASE_URL = "http://github.com";

    private static final String ISSUES = "Issues";

    private static final String REPOSITORY = "AnkaNik/qa_courses_07";
    private static final String ISSUE_TITLE = "Test Issue HW05";

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open(BASE_URL);
        });
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Go to " + ISSUES, () -> {
            $(withText(ISSUES)).click();
        });
        step("Check that issue with " + ISSUE_TITLE + " present", () -> {
            $(withText(ISSUE_TITLE)).should(Condition.exist);
        });
    }

}