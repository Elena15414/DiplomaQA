package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.invalidLoginAndPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.invalidPassword;

import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.elements.AuthorizationElement;

public class PageObjectAuthorization {

    AuthorizationElement authorizationElement = new AuthorizationElement();

    public void checkAuthorizationIsDisplayed() {
        authorizationElement.getAuthorizationHeader().check(matches(isDisplayed()));
    }

    public void validLoginAndPasswordAuthorization(DataHelper.AuthInfo info) {
        authorizationElement.getLoginField().perform(typeText(info.getLogin()));
        authorizationElement.getPasswordField().perform(typeText(info.getPassword())).perform(closeSoftKeyboard());
        authorizationElement.getLoginButton().perform(click());
    }

    public void invalidLoginAuthorization() {
        authorizationElement.getLoginField().perform(typeText(invalidLogin().getLogin()));
        authorizationElement.getPasswordField().perform(typeText(invalidLogin().getPassword())).perform(closeSoftKeyboard());
        authorizationElement.getLoginButton().perform(click());
    }

    public void invalidPasswordAuthorization() {
        authorizationElement.getLoginField().perform(typeText(invalidPassword().getLogin()));
        authorizationElement.getPasswordField().perform(typeText(invalidPassword().getPassword())).perform(closeSoftKeyboard());
        authorizationElement.getLoginButton().perform(click());
    }

    public void securityInvalidLoginAndPasswordAuthorization() {
        authorizationElement.getLoginField().perform(typeText(invalidLoginAndPassword().getLogin()));
        authorizationElement.getPasswordField().perform(typeText(invalidLoginAndPassword().getPassword())).perform(closeSoftKeyboard());
        authorizationElement.getLoginButton().perform(click());
    }

    public void emptyLoginFieldAuthorization() {
        authorizationElement.getLoginField().perform(typeText(emptyLogin().getLogin()));
        authorizationElement.getPasswordField().perform(typeText(emptyLogin().getPassword())).perform(closeSoftKeyboard());
        authorizationElement.getLoginButton().perform(click());
    }

    public void checkLoginAndPasswordFieldsAreDisplayed() {
        authorizationElement.getLoginField().check(matches(isDisplayed()));
        authorizationElement.getPasswordField().check(matches(isDisplayed()));
    }
}