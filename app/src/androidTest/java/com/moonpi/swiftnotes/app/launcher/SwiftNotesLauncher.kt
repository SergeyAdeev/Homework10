package com.moonpi.swiftnotes.app.launcher

import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.rule.SwiftnotesRule
import org.junit.Rule
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.step

class SwiftNotesLauncher {
    @get:Rule
    val rule = SwiftnotesRule(MainActivity::class.java, false)

    fun launchApp() {
        step("Зайти в приложение") {
            rule.launchActivity()
            deviceScreenshot("main_page")
        }
    }
}