package com.qa.selenium.page.google;

import com.qa.selenium.configurations.annotation.Page;
import com.qa.selenium.page.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends BasePage {

    @Autowired
    private SearchComponent searchComponent;
    @Autowired
    private SearchResult searchResult;

    @Value("${application.url}")
    private String url;

    public void goTo(){
        this.webDriver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }





    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
