package com.moonpi.swiftnotes.app.dialog

import android.R
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class SwiftnitesAlertDialog {

    fun checkDialog(title: String, textPositiveButton: String, textNegativeButton: String) {
        step("Проверить текст \"$title\". " +
                "Проверить наличие двух кнопок \"$textNegativeButton\", \"$textPositiveButton\"") {
            checkTitle(title)
            checkNegativeButtonDialog(textNegativeButton)
            checkPositiveButtonDialog(textPositiveButton)
            deviceScreenshot("dialog_$title")
        }
    }

    private fun checkTitle(title: String) {
        onView(allOf(withId(R.id.message))).check(matches(withText(title)))
    }

    private fun checkPositiveButtonDialog(textPositiveButton: String) {
        onView(allOf(withId(R.id.button1))).check(matches(withText(textPositiveButton)))
    }

    private fun checkNegativeButtonDialog(textNegativeButton: String) {
        onView(allOf(withId(R.id.button2))).check(matches(withText(textNegativeButton)))
    }

    fun clickPositiveButton(textPositiveButton: String) {
        step("Нажать \"$textPositiveButton\"") {
            onView(allOf(withId(R.id.button1))).perform(click())
            deviceScreenshot("click_$textPositiveButton")
        }
    }

    fun clickNegativeButton(textNegativeButton: String) {
        step("Нажать \"$textNegativeButton\"") {
            onView(allOf(withId(R.id.button2))).perform(click())
            deviceScreenshot("click_$textNegativeButton")
        }
    }
}