package com.qa.selenium.page.google;

import com.qa.selenium.configurations.annotation.PageFragment;
import com.qa.selenium.page.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class SearchResult extends BasePage {

    @FindBy(css = "div.rc")
    private List<WebElement> results;



    public int getCount(){
        return this.results.size();
    }





    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.results.isEmpty());
    }
}
