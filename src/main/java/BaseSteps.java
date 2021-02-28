

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "http://github.com";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search for repository ${repository}")
    public void searchForRepository(final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to repository ${repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Go to Issues")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Create Issue с ${title}")
    public void createIssueWithTitle(final String title) {
       $(byXpath("//a[href='/AnkaNik/qa_courses_07/issues/new/choose']")).click();
       $("#issue_title").sendKeys(title);
       $(byText("Submit new issue")).click();

    }

    @Step("Check that Issue with title ${number} present")
    public void shouldSeeIssueWithTitle(final String title) {
        $(withText(title)).should(Condition.exist);
    }

    @Step("Check that Issue with  number ${number} present")
    public void shouldSeeIssueWithNumber(final String number) {
        $(withText(number)).should(Condition.exist);
    }
}
