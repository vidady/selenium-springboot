package com.qa.selenium.page.google;

import com.qa.selenium.configurations.annotation.PageFragment;
import com.qa.selenium.page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchComponent extends BasePage {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchBtn;


    public void search(final String keyword){
        propertyReadingService.getProperty("name");
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.TAB);
        this.searchBtn.stream().filter(e->e.isDisplayed() && e.isEnabled()).findFirst().ifPresent(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.searchBox.isDisplayed());
    }
}
