package com.moonpi.swiftnotes.app.menu

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.R
import org.hamcrest.core.AllOf.allOf
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class SwiftnotesMenu {
    fun checkMenuItem(itemName: String) {
        step("Проверка пункта меню $itemName") {
            onView(allOf(withId(R.id.title), withText(itemName))).check(matches(isDisplayed()))
            deviceScreenshot("menu_item_$itemName")
        }
    }

}