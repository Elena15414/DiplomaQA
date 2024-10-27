package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.DataHelper.toastMessage;
import static ru.iteco.fmhandroid.ui.data.DataHelper.toastMessageEmpty;
import static ru.iteco.fmhandroid.ui.data.DataHelper.validLoginAndPassword;
import static ru.iteco.fmhandroid.ui.data.Expectation.waitDisplayed;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import ru.iteco.fmhandroid.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.PageObjectAuthorization;
import ru.iteco.fmhandroid.ui.page.PageObjectBefore;
import ru.iteco.fmhandroid.ui.matchers.ToastMatcher;
import ru.iteco.fmhandroid.ui.page.PageObjectMain;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    PageObjectBefore pageObjectBefore = new PageObjectBefore();
    PageObjectAuthorization pageObjectAuthorization = new PageObjectAuthorization();
    PageObjectMain pageObjectMain = new PageObjectMain();

    @Before
    public void startPage() {
        onView(isRoot()).perform(waitDisplayed(R.id.container_custom_app_bar_include_on_fragment_main, 8000));
        try {
            pageObjectAuthorization.checkAuthorizationIsDisplayed();
            pageObjectAuthorization.checkLoginAndPasswordFieldsAreDisplayed();
        } catch (NoMatchingViewException e) {
            pageObjectBefore.loginOut();
        }
    }

    @Test
    public void validLoginValidPassword() {

        pageObjectAuthorization.validLoginAndPasswordAuthorization(validLoginAndPassword());
        pageObjectMain.checkMainIsDisplayed();
    }

    @Test
    public void validLoginInvalidPassword() {

        pageObjectAuthorization.invalidPasswordAuthorization();
        onView(withText(toastMessage)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void invalidLoginValidPassword() {

        pageObjectAuthorization.invalidLoginAuthorization();
        onView(withText(toastMessage)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void emptyLoginEmptyPassword() {

        pageObjectAuthorization.emptyLoginFieldAuthorization();
        onView(withText(toastMessageEmpty)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void invalidLoginInvalidPassword() {

        pageObjectAuthorization.invalidLoginAuthorization();
        pageObjectAuthorization.invalidPasswordAuthorization();
        onView(withText(toastMessage)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void securityInvalidLoginInvalidPassword() {

        pageObjectAuthorization.securityInvalidLoginAndPasswordAuthorization();
        onView(withText(toastMessage)).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

}