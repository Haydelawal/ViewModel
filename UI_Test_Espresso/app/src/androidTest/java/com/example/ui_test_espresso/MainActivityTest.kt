package com.example.ui_test_espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    // @get:Rule lateinit var activityScenarioRule = ActivityScenarioRule<MainActivity>()
//
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // testing/checking activity visibility
    @Test
    fun checkActivityVisibility() {
        onView(withId(R.id.layout_main)).check(matches(isDisplayed()))
    }

    // testing/checking text visibility
    @Test
    fun checkTextVisibility() {
        onView(withId(R.id.textView)).check(matches(isDisplayed()))

        // checking button visibility
        onView(withId(R.id.button)).check(matches(isDisplayed()))
    }

    // checking testTextIsFromTheRightActivity

    @Test
    fun testTextIsFromTheRightActivity() {
        onView(withId(R.id.textView)).check(matches
        (withText(R.string.main_activity)))


    }

    // checking if button navigates to second activity

    @Test
    fun navigateToSecondActivity() {
        onView(withId(R.id.button)).perform(
                click()
        )

        // checking if second activity is visible after button clicked
        onView(withId(R.id.layout_second)).check(matches(isDisplayed()))


    }

    @Test
    fun navigateToMainFromSecondActivity() {
        onView(withId(R.id.button)).perform(
                click()
        )

        // checking if main activity is visible after button clicked
        onView(withId(R.id.layout_second)).check(matches(isDisplayed()))


        //checking android device onBackPressed
        Espresso.pressBack()

        // checking if main activity is visible after back pressed
        onView(withId(R.id.layout_main)).check(matches(isDisplayed()))

    }

}