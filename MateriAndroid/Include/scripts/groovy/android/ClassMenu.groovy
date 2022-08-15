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



class ClassMenu {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("(.*) tap Menu (.*) di menu Class ANDROID")
	def tapClassType(String nama, String type) {
		if(type.equalsIgnoreCase("Academic")) {
			Mobile.tap(findTestObject('Android/ClassesMenu/MenuAcademic'), 0)
		}
		else if(type.equalsIgnoreCase("General")) {
			Mobile.tap(findTestObject('Android/ClassesMenu/MenuGeneral'), 0)
		}
	}

	@And("(.*) tap periode di menu Class ANDROID")
	def tapPeriode(String nama) {
		Mobile.tap(findTestObject('Android/ClassesMenu/ChoosePeriod'), 0)
		Mobile.waitForElementPresent(findTestObject('Android/ClassesMenu/ListPeriod'),0)
	}

	@And("(.*) tap periode (.*) di menu Class ANDROID")
	def pilihPeriode(String nama, String periode) {
		Mobile.tap(findTestObject('Android/ClassesMenu/List2020-2021Ganjil'), 0)
	}

	@And("(.*) tap List Class (.*) di menu Class ANDROID")
	def pilihClassList(String nama, String kelas) {
		Mobile.tap(findTestObject('Android/ClassesMenu/ListClassBahasaA'), 0)
	}

	@Then("(.*) masuk halaman Class ANDROID")
	def cekClass(String nama) {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/MenuDiscussion'),0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/MenuDiscussion'),0)
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZDiscussionClass/contentDiscussion'), 0)
	}
}