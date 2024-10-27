package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.page.PageAboutPrivacyPolicy;
import ru.iteco.fmhandroid.ui.page.PageObjectBefore;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AboutPrivacyPolicyAndTermsUseTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    PageAboutPrivacyPolicy pageAboutPrivacyPolicy = new PageAboutPrivacyPolicy();
    PageObjectBefore pageObjectBefore = new PageObjectBefore();

    @Before
    public void startPage() {
        pageObjectBefore.loginIn();
    }

    @Test
    public void pageAboutPrivacyPolicyClickable() {

        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.checkAboutIsDisplayed();
        pageAboutPrivacyPolicy.checkPrivacyPolicyLinkIsClickable();
    }

    @Test
    public void pageAboutTermsOfUseClickable() {

        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.checkAboutIsDisplayed();
        pageAboutPrivacyPolicy.checkTermsOfUseLinkIsClickable();
    }
}