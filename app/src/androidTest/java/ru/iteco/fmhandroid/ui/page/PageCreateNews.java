package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.DataHelper.toastMessageCategoryCreateNews;
import static ru.iteco.fmhandroid.ui.data.DataHelper.toastMessageCreateNews;

import ru.iteco.fmhandroid.ui.elements.ControlPanelElement;
import ru.iteco.fmhandroid.ui.elements.NewsElement;
import ru.iteco.fmhandroid.ui.matchers.ToastMatcher;

public class PageCreateNews {
    NewsElement newsElement = new NewsElement();
    ControlPanelElement controlPanelElement = new ControlPanelElement();

    public void entranceCategoryTest() {
        newsElement.getCategory().perform(typeText("test"), closeSoftKeyboard());
    }

    public void choiceCategory() {
        newsElement.getCategory().perform(click());
    }

    public void readTitle() {
        newsElement.getHeader().perform(typeText("test"), closeSoftKeyboard());
    }

    public void choiceTitle() {
        newsElement.getHeader().perform(click());
    }

    public void readDescription() {
        onView(withHint("Description")).perform(typeText("test"), closeSoftKeyboard());
    }

    public void readDescriptionEmpty() {
        onView(withHint("Description")).perform(typeText(" "), closeSoftKeyboard());
    }

    public void checkControlPanel() {
        controlPanelElement.getControlPanel().check(matches(isDisplayed()));
    }

    public void emptyCategoryTest() {
        newsElement.getCategory().perform(typeText(" "), closeSoftKeyboard());

    }

    public void emptyPublicationDate() {
        newsElement.getPublicationDate().perform(typeText(" "), closeSoftKeyboard());
    }

    public void emptyTitleTest() {
        newsElement.getHeader().perform(typeText(" "), closeSoftKeyboard());

    }

    //проверка на сообщение об ошибке
    public void checkToastMessageCreateNews() {
        onView(withText(toastMessageCreateNews)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    //проверка на сообщение об ошибке
    public void checkToastMessageCategoryCreateNews() {
        onView(withText(toastMessageCategoryCreateNews)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

}
