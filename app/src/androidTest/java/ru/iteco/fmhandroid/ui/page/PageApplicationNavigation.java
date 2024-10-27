package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import ru.iteco.fmhandroid.ui.elements.ApplicationNavigation;

public class PageApplicationNavigation {

    ApplicationNavigation applicationNavigation = new ApplicationNavigation();
    PageObjectNews pageObjectNews = new PageObjectNews();

    public void entranceInQuote() {
        applicationNavigation.getMissionButton().perform(click());
    }

    //проверка
    public void checkQuoteText() {
        applicationNavigation.getMissionText().check(matches(isDisplayed()));
    }

}
