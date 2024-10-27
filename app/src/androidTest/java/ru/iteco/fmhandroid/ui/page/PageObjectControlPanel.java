package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;

import static ru.iteco.fmhandroid.ui.data.Expectation.waitDisplayed;

import ru.iteco.fmhandroid.ui.elements.ControlPanelElement;
import ru.iteco.fmhandroid.R;

import static androidx.test.espresso.assertion.ViewAssertions.matches;

public class PageObjectControlPanel {

    ControlPanelElement controlPanelElement = new ControlPanelElement();


    //"Проверка отображения экрана Панель управления новостей"
    public void checkControlPanelIsDisplayed() {
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 3000));
        controlPanelElement.getControlPanel().check(matches(isDisplayed()));
    }

}
