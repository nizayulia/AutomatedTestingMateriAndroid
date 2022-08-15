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



class MaterialSession {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given ("Dosen tap submenu Session di Class ANDROID")
	def tapSession() {
		Mobile.tap(findTestObject('Android/ClassSubMenu/MenuSessions'), 0)
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZSessionClass/ContentSession'), 0)
	}
	@When ("Dosen tap session (.*) di menu Session di Class ANDROID")
	def chooseSession(String sesi) {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZSessionClass/ButtonChooseSession1'), 0)
	}

	@And ("Dosen tap button Create di halaman topik sesi di Class ANDROID")
	def buttonCreateTask() {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZSessionClass/ContentSession1'), 0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZSessionClass/ButtonCreateTask'), 0)
	}

	@And ("Dosen tap button Material di list menu Create di Class ANDROID")
	def buttonMaterial() {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZSessionClass/PopUpListCreateTask'), 0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZSessionClass/ButtonCreateMaterial'), 0)
	}
}