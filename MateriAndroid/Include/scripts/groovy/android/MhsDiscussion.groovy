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



class MhsDiscussion {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("(.*) melihat quiz pada discussion Class ANDROID")
	def cekQuiz(String user) {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZDiscussionClass/TextJudulQuiz (1)'), 0)
	}

	@Then("(.*) dapat melihat judul quiz (.*) di discussion Class ANDROID")
	def cekJudul(String user, String judul) {
		Mobile.verifyElementText(findTestObject('Android/ClassSubMenu/ZDiscussionClass/TextJudulQuiz (1)'), judul)
	}

	@And("(.*) dapat melihat catatan quiz (.*) di discussion Class ANDROID")
	def cekCatatan(String user, String catatan) {
		Mobile.verifyElementText(findTestObject('Android/ClassSubMenu/ZDiscussionClass/TextCatatanQuiz'), catatan)
	}
	
	@And("(.*) dapat melihat total pertanyaan quiz (.*) di discussion Class ANDROID")
	def cekTotalPertanyaan(String user, String jumlah) {
		String total = jumlah + " Question"
		
		Mobile.verifyElementText(findTestObject('Android/ClassSubMenu/ZDiscussionClass/Text2Question'), total)
	}
	
	@Given("Mahasiswa tap See Detail Quiz di discussion Class ANDROID")
	def tapSeeDetailQuiz() {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZDiscussionClass/ButtonOpenQuizDetail'), 0)
	}
	
}