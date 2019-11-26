Задание к проекту Swiftnotes
==

Автоматизировать приведенные ниже тест-кейсы для приложения Swiftnotes с использованием Espresso на языке Kotlin.

Список тест-кейсов:
--

1. Проверка экрана создания заметки
* Зайти в приложение
* Нажать "+"
* Проверить хинт заголовка "Title"
* Проверить хинт текста "Note"
* Нажать в тулбаре "Назад"
* Появляется диалог. Проверить текст "Save changes?". Проверить наличие двух кнопок "No", "Yes".
* Нажать "No"
* Открылся главный экран (проверяем по текстовке в тулбаре)
2. Проверка сохранения заметки
* Зайти в приложение
* Нажать "+"
* В поля "Title" и "Note" ввести текст
* Проверить, что текст введен корректно
* Нажать в тулбаре "Назад"
* В диалоге нажать "Yes"
* Открылся главный экран. Проверяем, что запись появилась (обе текстовки)
3. Проверка пунктов меню в тулбаре
* Зайти в приложение
* Нажать "Меню"
* Проверить отображение пунктов меню: "Backup notes", "Restore notes", "Rate app"
* Нажать "+"
* Нажать "Меню"
* Проверить отображение пунктов меню: "Note font size", "Hide note body in list"
4. Проверка удаления заметки
* Зайти в приложение
* Нажать "+"
* В поля "Title" и "Note" ввести текст
* Нажать в тулбаре "Назад"
* В диалоге нажать "Yes"
* Лонг тап на заметку на главном экране
* В тулбаре нажать "Удалить"
* Проверяем отсутствие заметки на главном экране

Необходимо описывать страницы и общие элементы приложения в отдельных классах (паттерн PageObject). На каждое действие/проверку должен быть шаг и скриншот для allure.

Итог
==
Тесты написаны, находятся в SwiftnotesTests, зеленые.

Отчеты в Allure генерируются с помощью adb pull и allure serve.
Скриншоты делаются на каждый шаг.

Страницы описаны в раздельных классах. Также в отдельные классы были вынесены некоторые элементы.

# Swiftnotes

**This project is no longer maintained.**

Swiftnotes is a note taking app that takes simplicity and speed to a whole new level. 

It offers you a quick and easy way to stay organised, capture your thoughts, reminders or anything that's on your mind, any time, anywhere. No extra unnecessary features, just notes.

### Build

Steps on how to build Swiftnotes:
- Make sure you have the latest version of Android Studio with Gradle v2.3.1 and the required Android SDK Tools installed (25.0.3 Build tools)
- Clone this repository
- Open Android Studio -> File -> Import Project
- Select build.gradle in Swiftnotes
- Go to Project Structure and make sure Android SDK and JDK paths are set
- Build -> Rebuild Project and Sync Gradle
- Good to go!

### License

Copyright &copy; 2018 Adrian Chifor

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
