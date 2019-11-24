package com.moonpi.swiftnotes.app.pages

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.longClick
import android.support.test.espresso.assertion.ViewAssertions.doesNotExist
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.view.View
import com.moonpi.swiftnotes.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class MainPage {

    fun clickNewNoteButton() {
        step("Нажать \"+\"") {
            onView(withId(R.id.newNote)).perform(ViewActions.click())
            deviceScreenshot("note_page")
        }
    }

    fun checkNote(title: String, noteText: String) {
        step("Проверка появления записи (обе текстовки)") {
            checkNoteElement(R.id.titleView, title)
            checkNoteElement(R.id.bodyView, noteText)
            deviceScreenshot("check_note_main_page")
        }
    }

    private fun checkNoteElement(id: Int, text: String) {
        onView(searchNoteElement(id, text)).check(matches(isDisplayed()))
    }

    private fun searchNoteElement(id: Int, text: String): Matcher<View> {
        return allOf(withId(id), withText(text))
    }

    fun longTapByNote(id: Int, title: String) {
        step("Лонг Тап на заметку") {
            onView(allOf(withChild(searchNoteElement(id, title)), isDisplayed())).perform(longClick())
            deviceScreenshot("long_tap_by_note")
        }
    }

    fun checkMissingNote(id: Int, title: String) {
        step("Проверка отсутствия заметки на главном экране") {
            onView(searchNoteElement(id, title)).check(doesNotExist())
            deviceScreenshot("main_page_missing_deleted_note")
        }
    }
}