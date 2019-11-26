package com.moonpi.swiftnotes.app.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import com.moonpi.swiftnotes.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class NotePage {
    fun checkTitleHint(hintTitle: String) {
        step("Проверить хинт заголовка \"$hintTitle\"") {
            onView(searchElement(R.id.titleEdit)).check(matches(withHint(hintTitle)))
            deviceScreenshot("note_page_title_hint")
        }
    }

    fun checkNoteHint(hintNote: String) {
        step("Проверить хинт текста \"$hintNote\"") {
            onView(searchElement(R.id.bodyEdit)).check(matches(withHint(hintNote)))
            deviceScreenshot("note_page_note_hint")
        }
    }

    fun inputTitleText(title: String) {
        step("Ввести текст в поле \"Title\"") {
            onView(searchElement(R.id.titleEdit)).perform(typeText(title))
            deviceScreenshot("input_title_text_new_note")
        }
    }

    fun inputNoteText(noteText: String) {
        step("Ввести текст в поле \"Note\"") {
            onView(searchElement(R.id.bodyEdit)).perform(typeText(noteText))
            deviceScreenshot("input_note_text_new_note")
        }
    }

    fun checkTitleText(title: String) {
        step("Проверить текст заголовка") {
            onView(searchElement(R.id.titleEdit)).check(matches(withText(title)))
            deviceScreenshot("check_title_text_page_note")
        }
    }

    fun checkNoteText(noteText: String) {
        step("Проверить текст заметки") {
            onView(searchElement(R.id.bodyEdit)).check(matches(withText(noteText)))
            deviceScreenshot("check_note_text_page_note")
        }
    }

    private fun searchElement(elementId: Int): Matcher<View> {
        return allOf(withId(elementId), isDisplayed())
    }
}