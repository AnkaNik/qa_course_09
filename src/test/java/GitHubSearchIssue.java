import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GitHubIssueTest  extends TestConfiguration{

    private static final String BASE_URL = "http://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "AnkaNik/qa_courses_07";
    private static final String ISSUE_NUMBER = "#1";
    private static final String ISSUE_TITLE = "Test Issue HW05";
    private static final String NEW_ISSUE= "AnkaNik/qa_courses_07/issues/new/choose";

    @Test
    public void testIssueSearch() {
        open(BASE_URL);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES)).click();
        $(withText(ISSUE_NUMBER)).should(Condition.exist);
        $(withText(ISSUE_TITLE)).should(Condition.exist);


    }
}