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
import ru.iteco.fmhandroid.ui.page.PageApplicationNavigation;
import ru.iteco.fmhandroid.ui.page.PageObjectBefore;
import ru.iteco.fmhandroid.ui.page.PageObjectMain;
import ru.iteco.fmhandroid.ui.page.PageObjectNews;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class ApplicationNavigationTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    PageObjectNews pageObjectNews = new PageObjectNews();
    PageObjectBefore pageObjectBefore = new PageObjectBefore();
    PageAboutPrivacyPolicy pageAboutPrivacyPolicy = new PageAboutPrivacyPolicy();
    PageApplicationNavigation pageApplicationNavigation = new PageApplicationNavigation();
    PageObjectMain pageObjectMain = new PageObjectMain();

    @Before
    public void startPage() {
        pageObjectBefore.loginIn();
    }

    @Test
    public void pageQuoteTopic() {

        pageApplicationNavigation.entranceInQuote();
        pageApplicationNavigation.checkQuoteText();
    }

    @Test
    public void pageNews() {

        pageObjectNews.entranceNews();
        pageObjectNews.checkNewsEntrance();
    }

    @Test
    public void pageNewsPageMain() {

        pageObjectNews.entranceNews();
        pageObjectMain.entranceMain();
        pageObjectNews.checkNewsPageMain();
    }

    @Test
    public void pageQuoteTopicPageMain() {

        pageApplicationNavigation.entranceInQuote();
        pageObjectMain.entranceMain();
        pageObjectNews.checkNewsPageMain();
    }

    @Test
    public void pageQuoteTopicPageNews() {

        pageApplicationNavigation.entranceInQuote();
        pageObjectNews.entranceNews();
        pageObjectNews.checkNewsEntrance();
    }

    @Test
    public void pageQuoteTopicPageAboutOption1() {

        pageApplicationNavigation.entranceInQuote();
        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.checkAboutPrivatePolice();
    }

    @Test
    public void pageQuoteTopicPageAboutOption2() {

        pageApplicationNavigation.entranceInQuote();
        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.checkAboutTermsOfUse();
    }

    @Test
    public void exitPageAbout() {

        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.clickOnBackButton();
        pageObjectNews.checkNewsPageMain();
    }

    @Test
    public void pageAboutPageNews() {

        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.clickOnBackButton();
        pageObjectNews.entranceNews();
        pageObjectNews.checkNewsEntrance();
    }
    @Test
    public void pageNewsAbout() {

        pageObjectNews.entranceNews();
        pageAboutPrivacyPolicy.entranceInAbout();
        pageAboutPrivacyPolicy.checkAboutPrivatePolice();
    }

}