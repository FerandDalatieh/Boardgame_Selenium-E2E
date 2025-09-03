package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ReviewsListPage extends BasePage {


    private By addReview = By.xpath("//a[contains(@href,\"addReview\")]");
    private By reviewElement = By.xpath("//tbody//tr");

    public final String getTextNthReview(int n){
        String xpathExpression = "//tbody//tr[" + n + "]//td[1]";
        By locator = By.xpath(xpathExpression);
        return getText(locator);
    }

    public final ReviewPage clickOnEditNthReview(int n){
        String xpathExpression = "//tbody//tr[" + n + "]//td[2]";
        By locator = By.xpath(xpathExpression);
        click(locator);
        return new ReviewPage();
    }

    public final void clickOnDeletethReview(int n){
        String xpathExpression = "//tbody//tr[" + n + "]//td[3]";
        By locator = By.xpath(xpathExpression);
        click(locator);
    }

    public final ReviewPage addRevview(){
        click(addReview);
        return new ReviewPage();
    }

    public final int getNumberOfReviews(){
        return findElements(reviewElement).size();
    }



}
