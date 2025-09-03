package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class ReviewPage extends BasePage {

    private final By textArea = By.xpath("//textarea[@id=\"text\"]");
    private final By submitButton = By.xpath("//input[contains(@value, 'Submit')]");

    public final String getReviewText(){
        return getText(textArea);
    }

    private void clearReviewText(){
        clearText(textArea);
    }

    public final void composeReviewText(String text){
        clearReviewText();
        enterText(textArea, text);
    }

    public final void appendReviewText(String text){
        enterText(textArea, text);
    }

    public final ReviewsListPage submitReviewText(){
        click(submitButton);
        return new ReviewsListPage();
    }



}
