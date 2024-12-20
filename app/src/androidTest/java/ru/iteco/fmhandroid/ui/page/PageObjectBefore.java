package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.Expectation.waitDisplayed;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class PageObjectBefore {
    PageObjectAuthorization pageObjectAuthorization = new PageObjectAuthorization();
    public void loginOut() {

        try {
            onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
            onView(withId(R.id.authorization_image_button)).perform(click());
            onView(withId(android.R.id.title)).perform(click());
        } catch (Exception e){
        }
    }
    public void loginIn() {

        try {
            onView(isRoot()).perform(waitDisplayed(R.id.enter_button, 5000));
            pageObjectAuthorization.validLoginAndPasswordAuthorization(DataHelper.validLoginAndPassword());
            onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 1000));
        } catch (Exception e){
        }
    }

}