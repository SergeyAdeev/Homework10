package com.moonpi.swiftnotes.app.toolbar

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.widget.ImageButton
import android.widget.ImageView
import com.moonpi.swiftnotes.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class SwiftnotesToolbar {
    fun checkToolbarText(title: String) {
        step("Проверка текстовки в тулбаре") {
            onView(allOf(withId(R.id.toolbarMain), isDisplayed()))
                    .check(matches(hasDescendant(withText(title))))
            deviceScreenshot("toolbar_title")
        }
    }

    fun clickBack() {
        step("Нажать в тулбаре \"Назад\"") {
            onView(allOf(withParent(withId(R.id.toolbarEdit)),
                    instanceOf(ImageButton::class.java))).perform(click())
            deviceScreenshot("note_page_click_back")
        }
    }

    fun clickMore(siblingId: Int, menuName: String) {
        step("Нажать в тулбаре \"$menuName\"") {
            onView(allOf(instanceOf(ImageView::class.java),
                    hasSibling(withId(siblingId)),
                    isDisplayed()))
                    .perform(click())
            deviceScreenshot("click_$menuName")
        }
    }
}