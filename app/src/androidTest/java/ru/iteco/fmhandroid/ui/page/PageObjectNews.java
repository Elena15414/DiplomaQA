package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.Expectation.waitDisplayed;

import org.hamcrest.core.IsNot;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.NewsElement;

public class PageObjectNews {

    PageObjectPage pageObjectPage = new PageObjectPage();
    NewsElement newsElement = new NewsElement();
    PageCreateNews pageCreateNews = new PageCreateNews();

    public void entranceNews() {
        pageObjectPage.menuPage("News");

    }

    public void checkNewsEntrance() {
        onView(withText("News"))
                .check(matches(isDisplayed()));
        onView(withId(R.id.all_news_text_view)).check(matches(IsNot.not(isDisplayed())));
    }

    public void checkNewsPageMain() {
        onView(withText("News"))
                .check(matches(isDisplayed()));
        onView(withId(R.id.all_news_text_view)).check(matches(isDisplayed()));
    }

    public void checkNewsIsDisplayed() {
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_recycler_view, 3000));
        newsElement.getNewsSectionTitle().check(matches(isDisplayed()));
    }

    public void formCreating() {
        pageObjectPage.menuPage("News");
        onView(withId(R.id.edit_news_material_button)).perform(click());
        onView(withId(R.id.add_news_image_view)).perform(click());
    }

    public void createNewsPositive() {
        formCreating();
        pageCreateNews.choiceCategory();
        pageCreateNews.choiceTitle();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withHint("Description")).perform(typeText("test"), closeSoftKeyboard());

        onView(withId(R.id.save_button)).perform(scrollTo(), click());

    }
    public void createNewsCanceled() {
        formCreating();
        pageCreateNews.entranceCategoryTest();
        pageCreateNews.readTitle();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withHint("Description")).perform(typeText("test"), closeSoftKeyboard());

        clickOnCancelButton();
        clickOnOkExitButton();

    }

    public void createNewsNegative(String nameField) {
        formCreating();
        pageCreateNews.choiceCategory();
        pageCreateNews.choiceTitle();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        pageCreateNews.readDescription();

        onView(withHint(nameField)).perform(clearText());
        onView(withId(R.id.save_button)).perform(scrollTo(), click());
    }

    public void createNewsEmptyCategory() {
        formCreating();
        pageCreateNews.emptyCategoryTest();
        pageCreateNews.readTitle();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        pageCreateNews.readDescription();

        onView(withId(R.id.save_button)).perform(scrollTo(), click());

    }
    public void createNewsEmptyTitle() {
        formCreating();
        pageCreateNews.entranceCategoryTest();
        pageCreateNews.emptyTitleTest();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        pageCreateNews.readDescription();

        onView(withId(R.id.save_button)).perform(scrollTo(), click());

    }

    public void createNewsEmptyDescription() {
        formCreating();
        pageCreateNews.entranceCategoryTest();
        pageCreateNews.readTitle();

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        pageCreateNews.readDescriptionEmpty();

        onView(withId(R.id.save_button)).perform(scrollTo(), click());

    }

    public void createNewsAnyCategory(String data) {
        formCreating();
        onView(withHint("Category")).perform(typeText(data), closeSoftKeyboard());
        onView(withHint("Title")).perform(typeText(data), closeSoftKeyboard());

        onView(withId(R.id.news_item_publish_date_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.news_item_publish_time_text_input_edit_text)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withHint("Description")).perform(typeText("test"), closeSoftKeyboard());

        onView(withId(R.id.save_button)).perform(scrollTo(), click());
    }

    //"Нажатие на кнопку Сохранить"
    public void clickOnSaveButton() {
        newsElement.getSaveButton().perform(click());
    }

    //"Нажатие на кнопку Отмена"
    public void clickOnCancelButton() {
        newsElement.getCancelButton().perform(click());
    }

    //"Нажатие на кнопку ОК для подтверждения отмены создания новости"
    public void clickOnOkExitButton() {
        newsElement.getOkExitButton().perform(click());
    }

}