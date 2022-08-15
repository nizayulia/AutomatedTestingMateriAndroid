package website
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class QuizBeranda {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("Dosen tap icon quiz di beranda Edlink")
	def quizDashboard() {
		WebUI.waitForElementVisible(findTestObject('Website/dashboard/ImageQuiz'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ImageQuiz'))
	}

	@When("Dosen tap kelas yang akan dibagikan")
	def tapKelasFormQuiz() {
		WebUI.waitForElementVisible(findTestObject('Website/dashboard/MunculKelasQuiz'), 0)
		WebUI.setMaskedText(findTestObject('Website/dashboard/MunculKelasQuiz'), 'Bahasa Indonesia')
		WebUI.waitForElementClickable(findTestObject('Website/dashboard/PilihKelasQuiz'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/PilihKelasQuiz'))
	}

	@And("Dosen tap sesi dari kelas")
	def tapSesiFormQuiz() {
		WebUI.waitForElementClickable(findTestObject('Website/dashboard/MunculSesiKelasQuiz'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/MunculSesiKelasQuiz'))
		WebUI.waitForElementClickable(findTestObject('Website/dashboard/PilihSesiKelasQuiz'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/PilihSesiKelasQuiz'))
	}

	@And("Dosen tap button Buat Quiz")
	def buatQuizFormQuiz() {
		WebUI.waitForElementClickable(findTestObject('Website/dashboard/BuatQuizButton'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/BuatQuizButton'))
	}

	@Then("Dosen masuk halaman form quiz")
	def formBuilder() {
		WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/FormQuiz'), 0)
	}

	@Given("Quiz (.*) berhasil tersimpan di sistem dashboard")
	def quizTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulQuiz'), judul)
	}

	@And("Quiz (.*) tidak ditemukan di sistem dashboard")
	def quiztidakDitemukan(String judul) {
		WebUI.verifyElementNotVisible(findTestObject('Website/dashboard/LabelJudulQuiz'), FailureHandling.OPTIONAL)
	}

	@Then("Quiz (.*) dihapus")
	def quizDihapus(String judul) {
		//		WebUI.click(findTestObject('dashboard/LabelJudulQuiz'))
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelHapus'))
		WebUI.waitForElementVisible(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'), 0)
		WebUI.click(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'))
		WebUI.delay(3)
	}

	@Given("Mahasiswa tap quiz pada beranda Edlink")
	def MhsTapQuiz() {
		WebUI.click(findTestObject('Website/dashboard/LabelJudulQuiz'))
	}

	@Then("Mahasiswa dapat melihat judul quiz (.*) di beranda")
	def MhsLihatQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulQuiz'), judul)
	}

	@And("Mahasiswa melihat nilai quiz tersimpan di sistem dashboard")
	def MhsLihatNilaiQuiz() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/NilaiQuiz'), 0)
	}

	@And("Dosen melihat Papan Peringkat Quiz")
	def PapanPeringkatQuiz() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/PeringkatNilaiQuiz'), 0)
	}

	@And("Dosen tap Lihat Hasil di beranda")
	def tapLihatHasil() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LihatHasilButton'))
	}

	@And("Mahasiswa tidak melihat quiz (.*) pada beranda Edlink")
	def mhsTidakLihatQuiz(String judul) {
		WebUI.verifyElementNotVisible(findTestObject('Website/dashboard/LabelJudulQuiz'), FailureHandling.OPTIONAL)
	}

	@And("Mahasiswa melihat quiz (.*) pada beranda Edlink")
	def mhsLihatQuiz(String judul) {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelJudulQuiz'), 0)
	}
}