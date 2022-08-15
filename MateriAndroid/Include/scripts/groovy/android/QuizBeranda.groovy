package android
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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class QuizBeranda {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Mahasiswa melihat quiz pada beranda Edlink ANDROID")
	def quizBeranda() {
		Mobile.waitForElementPresent(findTestObject('Android/Beranda/TextJudulQuiz'), 0)
	}

	@Then("Mahasiswa dapat melihat catatan quiz (.*) di beranda Edlink ANDROID")
	def cekCatatan(String catatan) {
		Mobile.verifyElementAttributeValue(findTestObject('Android/Beranda/TextCatatan'), 'text', catatan, 0)
	}

	@And("Mahasiswa dapat melihat judul quiz (.*) di beranda Edlink ANDROID")
	def cekJudul(String judul) {
		Mobile.verifyElementAttributeValue(findTestObject('Android/Beranda/TextJudulQuiz'), 'text', judul, 0)
	}
	
	@And("Mahasiswa dapat melihat total pertanyaan quiz (.*) di beranda Edlink ANDROID")
	def cekTotalPertanyaan(String jumlah) {
		String total = jumlah + " Question"
		Mobile.verifyElementAttributeValue(findTestObject('Android/Beranda/Text2Question'), 'text', total, 0)
	}
	
	@Given("Mahasiswa tap See Detail Quiz pada beranda Edlink ANDROID")
	def tapSeeDetailQuiz() {
		Mobile.tap(findTestObject('Android/Beranda/ButtonOpenQuizDetail'), 0)
	}
}