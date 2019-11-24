package com.moonpi.swiftnotes.test

import android.support.test.espresso.Espresso.pressBack
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.app.dialog.SwiftnitesAlertDialog
import com.moonpi.swiftnotes.app.launcher.SwiftNotesLauncher
import com.moonpi.swiftnotes.app.menu.SwiftnotesMenu
import com.moonpi.swiftnotes.app.pages.MainPage
import com.moonpi.swiftnotes.app.pages.NotePage
import com.moonpi.swiftnotes.app.toolbar.SwiftnotesToolbar
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.annotations.DisplayName

@RunWith(AndroidJUnit4::class)
@DisplayName("Создание заметки")
class SwiftnoteTests : AbstractSwiftnotesTest() {

    private val alertDialog = SwiftnitesAlertDialog()
    private val toolbar = SwiftnotesToolbar()
    private val mainPage = MainPage()
    private val notePage = NotePage()
    private val launcher = SwiftNotesLauncher()
    private val menu = SwiftnotesMenu()

    //TODO strings
    private val titleText = "New note"
    private val noteText = "Note text for new note"
    private val textNo = "No"
    private val textYes = "Yes"
    private val textOk = "Ok"
    private val textMenu = "Меню"
    private val textDelete = "Удалить"
    private val textSaveChanges = "Save changes?"
    private val appName = "Swiftnotes"

    @Test
    @DisplayName("Проверка экрана создания заметки")
    fun testNewNoteScreen() {
        launcher.launchApp()
        mainPage.clickNewNoteButton()
        notePage.checkTitleHint()
        notePage.checkNoteHint()
        toolbar.clickBack()
        alertDialog.checkDialog(textSaveChanges, textYes, textNo)
        alertDialog.clickNegativeButton(textNo)
        toolbar.checkToolbarText(appName)
    }

    @Test
    @DisplayName("Проверка сохранения заметки")
    fun testSaveNote() {
        launcher.launchApp()
        mainPage.clickNewNoteButton()
        notePage.inputTitleText(titleText)
        notePage.inputNoteText(noteText)
        notePage.checkTitleText(titleText)
        notePage.checkNoteText(noteText)
        toolbar.clickBack()
        alertDialog.clickPositiveButton(textYes)
        mainPage.checkNote(titleText, noteText)
    }

    @Test
    @DisplayName("Проверка удаления заметки")
    fun testDeleteNote() {
        launcher.launchApp()
        mainPage.clickNewNoteButton()
        notePage.inputTitleText(titleText)
        notePage.inputNoteText(noteText)
        toolbar.clickBack()
        alertDialog.clickPositiveButton(textYes)
        mainPage.longTapByNote(R.id.titleView, titleText)
        toolbar.clickMore(R.id.action_search, textDelete)
        alertDialog.clickPositiveButton(textOk)
        mainPage.checkMissingNote(R.id.titleView, titleText)
    }

    @Test
    @DisplayName("Проверка пунктов меню в тулбаре")
    fun testToolbarItems() {
        launcher.launchApp()
        toolbar.clickMore(R.id.action_search, textMenu)
        menu.checkMenuItem("Backup notes")
        menu.checkMenuItem("Restore notes")
        menu.checkMenuItem("Rate app")
        pressBack()
        mainPage.clickNewNoteButton()
        toolbar.clickMore(R.id.action_note_colour, textMenu)
        menu.checkMenuItem("Note font size")
        menu.checkMenuItem("Hide note body in list")
    }
}