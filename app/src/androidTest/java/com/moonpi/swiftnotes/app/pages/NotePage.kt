package com.moonpi.swiftnotes.app.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.R
import org.hamcrest.Matchers.allOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class NotePage {
    fun checkTitleHint() {
        step("Проверить хинт заголовка \"Title\"") {
            onView(allOf(withId(R.id.titleEdit), isDisplayed())).check(matches(withHint("Title")))
            deviceScreenshot("note_page_title_hint")
        }
    }

    fun checkNoteHint() {
        step("Проверить хинт текста \"Note\"") {
            onView(allOf(withId(R.id.bodyEdit), isDisplayed())).check(matches(withHint("Note")))
            deviceScreenshot("note_page_note_hint")
        }
    }

    fun inputTitleText(title: String) {
        step("Ввести текст в поле \"Title\"") {
            onView(allOf(withId(R.id.titleEdit), isDisplayed())).perform(typeText(title))
            deviceScreenshot("input_title_text_new_note")
        }
    }

    fun inputNoteText(noteText: String) {
        step("Ввести текст в поле \"Note\"") {
            onView(allOf(withId(R.id.bodyEdit), isDisplayed())).perform(typeText(noteText))
            deviceScreenshot("input_note_text_new_note")
        }
    }

    fun checkTitleText(title: String) {
        step("Проверить текст заголовка") {
            onView(allOf(withId(R.id.titleEdit), isDisplayed())).check(matches(withText(title)))
            deviceScreenshot("check_title_text_page_note")
        }
    }

    fun checkNoteText(noteText: String) {
        step("Проверить текст заметки") {
            onView(allOf(withId(R.id.bodyEdit), isDisplayed())).check(matches(withText(noteText)))
            deviceScreenshot("check_note_text_page_note")
        }
    }
}