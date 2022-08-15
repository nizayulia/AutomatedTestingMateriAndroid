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



class MhsDetailQuiz {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Mahasiswa dapat melihat catatan quiz (.*) di detail quiz ANDROID")
	def cekCatatan(String catatan) {
		Mobile.waitForElementPresent(findTestObject('Android/DetailQuizMhs/TextJudulQuiz'), 0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/DetailQuizMhs/TextCatatan'), 'text', catatan, 0)
	}

	@When("Mahasiswa dapat melihat judul quiz (.*) di detail quiz ANDROID")
	def cekJudul(String judul) {
		Mobile.verifyElementAttributeValue(findTestObject('Android/DetailQuizMhs/TextJudulQuiz'), 'text', judul, 0)
	}

	@Then("Mahasiswa dapat melihat total pertanyaan quiz (.*) di detail quiz ANDROID")
	def cekTotalQuestion(String jumlah) {
		String total
		if (jumlah.equalsIgnoreCase("1"))
			total = jumlah + " Question"
		else
			total = jumlah + " Questions"
		Mobile.verifyElementAttributeValue(findTestObject('Android/DetailQuizMhs/Text2Question'), 'text', total, 0)
	}

	@Given("Mahasiswa tap Start Quiz di detail quiz ANDROID")
	def tapStartQuiz() {
		Mobile.tap(findTestObject('Android/DetailQuizMhs/ButtonStartQuiz'), 0)
	}
}