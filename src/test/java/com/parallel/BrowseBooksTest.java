package com.parallel;

import com.framework.pages.BrowseBooksPage;
import org.junit.Test;

public class BrowseBooksTest extends BaseTest {

    @Test
    public void goWithoutFilters() {
        BrowseBooksPage browseBooksPage = new BrowseBooksPage(wd);
        browseBooksPage.clickGo();
    }
}


