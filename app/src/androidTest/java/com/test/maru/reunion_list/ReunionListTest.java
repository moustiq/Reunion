package com.test.maru.reunion_list;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.test.maru.R;
import com.test.maru.reunion_list.MainActivity;
import com.test.maru.utils.DeleteViewAction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//import androidx.test.espresso.contrib;
//import androidx.test.espresso.contrib.RecyclerViewActions;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.test.maru.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class ReunionListTest {

    private static int ITEMS_COUNT = 5;

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ReunionExist() {

        onView(Matchers.allOf(ViewMatchers.withId(R.id.reunion_sujet), withText("OC - 15:20 - Paris"),
                withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))), isDisplayed())).check(matches(withText("OC - 15:20 - Paris")));
    }

    /*@Test
    public void deleteReunion() {

        onView(allOf(withId(R.id.reunion_delete),childAtPosition(childAtPosition(withId(R.id.reu_recycler), 0), 3))).perform(click());
        onView(ViewMatchers.withId(R.id.reu_recycler)).check(withItemCount(ITEMS_COUNT));
        onView(ViewMatchers.withId(R.id.reu_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(1, new DeleteViewAction()));
    }*/

    @Test
    public void filtreSalle() {

        onView(allOf(withId(R.id.toolbar_recherche))).perform(click());
        onView(withId(R.id.search_edit)).perform(click()).perform(replaceText("salle 2"), closeSoftKeyboard());
        onView(withId(R.id.search_edit)).perform(click());
        onView(allOf(withId(R.id.reunion_sujet), withText("OC - 15:30 - salle 2"))).check(matches(withText("OC - 15:30 - salle 2")));

    }


    @Test
    public void ajoutReunion() {

        onView(withId(R.id.floating_button)).perform(click());
        onView(withId(R.id.heure)).perform(replaceText("12:12"),closeSoftKeyboard());
        onView(withId(R.id.spinner_lieu)).perform(click());
        onData(anything()).atPosition(4).perform(click());
        onView(withId(R.id.sujet)).perform(replaceText("OC"),closeSoftKeyboard());
        onView(withId(R.id.mail)).perform(replaceText("nouveau@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.creer)).perform(click());
        onView(withId(R.id.toolbar_back)).perform(click());
        onView(allOf(withId(R.id.reunion_sujet), withText("OC - 12:12 - salle 5"), withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class))), isDisplayed())).check(matches(isDisplayed()));
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

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
}
