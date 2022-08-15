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



class PopUpCreateTask {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("Dosen tap button (.*) di list Create di Class ANDROID")
	def buttonCreate(String buat) {
		if(buat.equalsIgnoreCase("Create Quiz") || buat.equalsIgnoreCase("Quiz"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateQuiz/buttonCreateQuiz'), 0)
		else if(buat.equalsIgnoreCase("Create Material") || buat.equalsIgnoreCase("Material") )
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateMaterial/buttonCreateMaterial'), 0)
	}

	@Then("Dosen masuk pop up Create (.*) di Class ANDROID")
	def masukPopUp(String task) {
		if(task.equalsIgnoreCase("Quiz"))
			Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZPopUpCreateQuiz/TextSessionDetail'), 0)
		else if(task.equalsIgnoreCase("Material"))
			Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZPopUpCreateMaterial/TextSessionDetail'), 0)
	}

	@When("Dosen tap list Session di pop up Create (.*) di Class ANDROID")
	def tapListSeesion(String sesi) {
		if(sesi.equalsIgnoreCase("Quiz"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateQuiz/ListChooseSession'), 0)
		else if(sesi.equalsIgnoreCase("Material"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateMaterial/ListChooseSession'), 0)
	}

	@And("Dosen tap Session (.*) di list Session (.*) di Class ANDROID")
	def chooseSession(String sesi, String task) {
		if(sesi.equalsIgnoreCase("1") && task.equalsIgnoreCase("Quiz"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateQuiz/ListChooseSession1'), 0)
		else if(sesi.equalsIgnoreCase("1") && task.equalsIgnoreCase("Material"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateMaterial/ListChooseSession1'), 0)
	}

	@And("Dosen tap button next di pop up Create (.*) di Class ANDROID")
	def tapButtonNext(String task) {
		if(task.equalsIgnoreCase("Quiz"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateQuiz/ButtonNext'), 0)
		else if(task.equalsIgnoreCase("Material"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZPopUpCreateMaterial/ButtonNext'), 0)
	}

	@Then("Dosen masuk halaman form (.*) ANDROID")
	def masukForm(String task) {
		if(task.equalsIgnoreCase("Quiz"))
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJudulQuiz'), 0)
		else if(task.equalsIgnoreCase("Material"))
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldJudulMaterial'), 0)
	}
}