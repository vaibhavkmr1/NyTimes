package com.example.nytimesdemo;

import android.content.Context;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.nytimesdemo.view.ui.ArticleActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ArticleTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.nytimesdemo", appContext.getPackageName());
    }
    @Rule
    public ActivityTestRule<ArticleActivity> activityRule =
            new ActivityTestRule<>(ArticleActivity.class);

    @Before
    public void setup() {
        activityRule.getActivity()
                .getSupportFragmentManager().beginTransaction();    }

     @Test
     public void checkRecylerVisibility(){
         onView(withId(R.id.recylerview)).check(matches(isDisplayed()));
     }

     @Test
    public void checkRecylerClick(){
         onView(withId(R.id.recylerview))
                 .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
     }
}
