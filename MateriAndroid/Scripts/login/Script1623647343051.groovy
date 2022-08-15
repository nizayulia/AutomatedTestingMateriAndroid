import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://staging.edlink.id/login')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Website/loginEdlink/SiakadButton'))

WebUI.setText(findTestObject('Website/loginEdlink/UniversitasField'), 'Universitas Lancang Kuning')

WebUI.waitForElementClickable(findTestObject('Website/loginEdlink/UniversitasDropdown'), 0)

WebUI.enhancedClick(findTestObject('Website/loginEdlink/UniversitasDropdown'))

WebUI.setText(findTestObject('Website/loginEdlink/UsernameField'), '1008078602')

WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), '123456')

WebUI.enhancedClick(findTestObject('Website/loginEdlink/MasukButton'))

WebUI.verifyElementVisible(findTestObject('Website/loginEdlink/homepageCheck'))

WebUI.waitForElementVisible(findTestObject('Website/dashboard/ImageQuiz'), 0)

WebUI.enhancedClick(findTestObject('Website/dashboard/ImageQuiz'))

WebUI.waitForElementVisible(findTestObject('Website/dashboard/MunculKelasQuiz'), 0)

WebUI.setMaskedText(findTestObject('Website/dashboard/MunculKelasQuiz'), 'Bahasa Indonesia')

WebUI.waitForElementClickable(findTestObject('Website/dashboard/PilihKelasQuiz'), 0)

WebUI.enhancedClick(findTestObject('Website/dashboard/PilihKelasQuiz'))

WebUI.waitForElementClickable(findTestObject('Website/dashboard/MunculSesiKelasQuiz'), 0)

WebUI.click(findTestObject('Website/dashboard/MunculSesiKelasQuiz'))

WebUI.waitForElementClickable(findTestObject('Website/dashboard/MunculSesiKelasQuiz'), 0)

WebUI.click(findTestObject('Website/dashboard/PilihSesiKelasQuiz'))

WebUI.waitForElementClickable(findTestObject('Website/dashboard/BuatQuizButton'), 0)

WebUI.click(findTestObject('Website/dashboard/BuatQuizButton'))

WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/FormQuiz'), 0)

WebUI.sendKeys(findTestObject('Website/formQuizBuilderLama/JudulField'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))

WebUI.setText(findTestObject('Website/formQuizBuilderLama/JudulField'), Judul)

WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/TambahPertanyaanButton'))

WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/PertanyaanTextArea'), 0)

WebUI.setText(findTestObject('Website/formQuizBuilderLama/PertanyaanTextArea'), pertanyaan)

WebUI.setText(findTestObject('Website/JawabanQuizBuilderLama/JawabanATextArea'), 'b')

WebUI.setText(findTestObject('Website/JawabanQuizBuilderLama/JawabanBTextArea'), 's')

WebUI.setText(findTestObject('Website/JawabanQuizBuilderLama/JawabanCTextArea'), 's')

WebUI.waitForElementClickable(findTestObject('Website/formQuizBuilderLama/SimpanPertanyaanButton'), 2)

WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/SimpanPertanyaanButton'))

WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), 0)

String[] words = pertanyaan.split('')

if (words.length <= 36) {
    WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), pertanyaan)
} else {
    pertanyaan = (words[0])

    for (int i = 1; i < 36; i++) {
        pertanyaan += (words[i])
    }
    
    pertanyaan = (pertanyaan + '...')

    WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), pertanyaan)
}

//WebUI.getText(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan')).equalsIgnoreCase('a')
WebUI.setText(findTestObject('Website/formQuizBuilderLama/CatatanField'), 'aaa')

WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/SimpanQuiz'))

WebUI.delay(15)

//WebUI.sendKeys(findTestObject('Website/formQuizBuilderLama/JudulField'), Keys.chord(Keys.F5, Keys.ENTER))
WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/FormQuiz'), 0)

////WebUI.verifyElementNotClickable(findTestObject('Website/formQuizBuilderLama/JudulField'))
//WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelKembali'))
//
//WebUI.verifyElementText(findTestObject('Website/DetailSesi/JudulQuiz'), Judul)

