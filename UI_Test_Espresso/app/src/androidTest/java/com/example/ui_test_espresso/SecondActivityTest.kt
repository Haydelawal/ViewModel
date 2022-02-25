package com.example.ui_test_espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(SecondActivity::class.java)

    // testing/checking activity visibility
    @Test
    fun checkActivityVisibility() {
        Espresso.onView(ViewMatchers.withId(R.id.layout_second))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}