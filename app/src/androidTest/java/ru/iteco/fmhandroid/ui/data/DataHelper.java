package ru.iteco.fmhandroid.ui.data;

import android.view.View;

import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.allOf;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.test.espresso.NoMatchingRootException;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.Description;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import ru.iteco.fmhandroid.R;

public class DataHelper {
    private DataHelper() {
    }

    public static class AuthInfo {
        private final String login;
        private final String password;

        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo validLoginAndPassword() {
        String login = "login2";
        String password = "password2";
        return new AuthInfo(login, password);
    }
    public static AuthInfo invalidLogin() {
        String login = "login3";
        String password = "password2";
        return new AuthInfo(login, password);
    }

    public static AuthInfo invalidPassword() {
        String login = "login2";
        String password = "password3";
        return new AuthInfo(login, password);
    }
    public static AuthInfo invalidLoginAndPassword() {
        String login = "login4";
        String password = "password4";
        return new AuthInfo(login, password);
    }

    public static AuthInfo loginWithSpace() {
        String login = "login2 ";
        String password = "password2";
        return new AuthInfo(login, password);
    }

    public static AuthInfo passwordWithSpace() {
        String login = "login2";
        String password = "password2 ";
        return new AuthInfo(login, password);
    }

    public static AuthInfo emptyLogin() {
        String login = "";
        String password = "password2";
        return new AuthInfo(login, password);
    }

    public static AuthInfo emptyPassword() {
        String login = "login2";
        String password = "";
        return new AuthInfo(login, password);
    }

    public static String toastMessage = "Something went wrong. Try again later.";
    public static String toastMessageEmpty = "Login and password cannot be empty";
    public static String toastMessageAuthorization = "Authorization";
    public static String toastMessageCreateNews = "Fill empty fields";
    public static String toastMessageCategoryCreateNews = "Saving failed. Try again later.";


    public static Matcher<View> childAtPosition(Matcher<View> matcher, final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    public static class Rand {

        private static final Random rand = new Random();

        public static String randomExecutor() {
            String[] executor = {
                    "Ivanov Ivan Ivanovich",
            };
            return executor[rand.nextInt(executor.length)];
        }

        public static String randomInvalidHour() {
            int min = 24;
            int max = 99;
            max -= min;
            int hour = (int) ((Math.random() * ++max) + min);
            return String.valueOf(hour);
        }

        public static String randomInvalidMinute() {
            int min = 60;
            int max = 99;
            max -= min;
            int minute = (int) ((Math.random() * ++max) + min);
            return String.valueOf(minute);
        }

        public static String randomNewsCategory() {
            String[] category = {
                    "Объявление",
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            return category[rand.nextInt(category.length)];
        }

        public static String randomNewsCategoryExceptAnnouncement() {
            String[] category = {
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            return category[rand.nextInt(category.length)];
        }
    }


    public static class DateTime {

        public static String localDate() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static void settingDate(int year, int month, int day) {
            onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month, day)).perform(click());
        }

        public static int currentYear() {
            return LocalDate.now().getYear();
        }

        public static int currentYearPlusOneYear() {
            return LocalDate.now().plusYears(1).getYear();
        }

        public static int currentYearMinusOneYear() {
            return LocalDate.now().plusYears(-1).getYear();
        }

        public static int currentMonth() {
            return LocalDate.now().getMonthValue();
        }

        public static int currentMonthPlusOneMonth() {
            return LocalDate.now().plusMonths(1).getMonthValue();
        }

        public static int todayDay() {
            return LocalDate.now().getDayOfMonth();
        }

        public static int tomorrowDay() {
            return LocalDate.now().plusDays(1).getDayOfMonth();
        }

        public static int yesterdayDay() {
            return LocalDate.now().plusDays(-1).getDayOfMonth();
        }

        public static String currentHour() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            return String.valueOf(hour);
        }

        public static String currentMinute() {
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);

            return String.valueOf(minute);
        }

        public static String currentTimePlusOneHour() {
            Calendar calendar = Calendar.getInstance();
            int hourPlusOneHour;
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour == 23) {
                hourPlusOneHour = 00;
            } else {
                hourPlusOneHour = hour + 1;
            }

            return String.valueOf(hourPlusOneHour);
        }

        public static String currentTimeMinusOneHour() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int hourMinusOneHour = hour - 1;

            return String.valueOf(hourMinusOneHour);
        }

        public static String dateTomorrow() {
            LocalDate date = LocalDate.now().plusDays(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateYesterday() {
            LocalDate date = LocalDate.now().plusDays(-1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneWeek() {
            LocalDate date = LocalDate.now().plusWeeks(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneMonth() {
            LocalDate date = LocalDate.now().plusMonths(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateAYearAgo() {
            LocalDate date = LocalDate.now().plusYears(-1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneYear() {
            LocalDate date = LocalDate.now().plusYears(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public static ViewAction waitUntilShown(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> is shown during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child) && child.isShown()) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }


}