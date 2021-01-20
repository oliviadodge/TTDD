package com.willbeing.ttdd

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.willbeing.ttdd.friends.Friend
import org.hamcrest.Matchers.*

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.EnumSet.allOf

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FriendsListActivityTest {

    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test.
     */
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(FriendsListActivity::class.java)

    @Test
    fun friendsListActivity_onCreate() {
        onData(allOf(
                `is`(instanceOf(List::class.java)),
                contains(Friend("Sammie"),
                        Friend("Joseph"),
                        Friend("Mara"))))
                .check(matches(isDisplayed()))
    }
}