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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
//import com.website.edlink.login.login as login

class LoginSteps {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("(.*) masuk ke website Edlink")
	def openWebsiteEdlink(String nama) {
		WebUI.openBrowser('https://staging.edlink.id')
		WebUI.maximizeWindow()
		//		CustomKeywords.'com.website.edlink.login.login.loginDosen'()
	}

	@When("(.*) tap Siakad button")
	def tabSiakadButton(String nama) {
		WebUI.waitForElementVisible(findTestObject('Website/loginEdlink/SiakadButton'), 0)
		WebUI.click(findTestObject('Website/loginEdlink/SiakadButton'))
	}

	@When("(.*) input perguruan tinggi (.*) di login Siakad")
	def inputUniversitas(String name, String univ) {
		WebUI.setText(findTestObject('Website/loginEdlink/UniversitasField'), univ)
		WebUI.waitForElementClickable(findTestObject('Website/loginEdlink/UniversitasDropdown'), 0)
		WebUI.enhancedClick(findTestObject('Website/loginEdlink/UniversitasDropdown'))
	}

	@When("(.*) input username (.*) di login Siakad")
	def inputUsernameSiakad(String name, String user) {
		WebUI.setText(findTestObject('Website/loginEdlink/UsernameField'), user)
	}

	@When("(.*) input password (.*) di login Siakad")
	def inputPasswordSiakad(String name, String password) {
		WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), password)
	}

	@When("(.*) input email (.*) di login Email")
	def inputEmail(String name, String user) {
		WebUI.setText(findTestObject('Website/loginEdlink/FieldEmail'), user)
	}

	@When("(.*) input password (.*) di login Email")
	def inputPasswordEmail(String name, String password) {
		WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), password)
	}

	@When("(.*) input universitas, username, dan password")
	def inputLoginSiakadForm(String nama) {
		WebUI.setText(findTestObject('Website/loginEdlink/UniversitasField'), 'Universitas Lancang Kuning')
		WebUI.waitForElementClickable(findTestObject('Website/loginEdlink/UniversitasDropdown'), 0)
		WebUI.enhancedClick(findTestObject('Website/loginEdlink/UniversitasDropdown'))
		if(nama.equals("Dosen")) {
			WebUI.setText(findTestObject('Website/loginEdlink/UsernameField'), '1008078602')
			WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), '123456')
		}

		else if(nama.equals("Mahasiswa")) {
			WebUI.setText(findTestObject('Website/loginEdlink/UsernameField'), '1988203004')
			WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), '123456')
		}

		else {
			WebUI.setText(findTestObject('Website/loginEdlink/UsernameField'), '1008078602')
			WebUI.setText(findTestObject('Website/loginEdlink/KataSandiField'), '123456')
		}
	}

	@When("Click login button")
	def tabLoginButton() {
		WebUI.enhancedClick(findTestObject('Website/loginEdlink/MasukButton'))
	}

	@Then("(.*) masuk ke beranda Edlink")
	def verifyBeranda(String nama) {
		WebUI.verifyElementVisible(findTestObject('Website/loginEdlink/homepageCheck'))
		WebUI.getText(findTestObject('Website/loginEdlink/TextName'))
	}

	@Then("(.*) masuk ke beranda Edlink dengan nama (.*) dan role (.*)")
	def verifyBeranda(String user, String nama, String role) {
		//		WebUI.verifyElementVisible(findTestObject('Website/loginEdlink/homepageCheck'))
		WebUI.verifyElementText(findTestObject('Website/loginEdlink/TextName'), nama)
		WebUI.verifyElementText(findTestObject('Website/loginEdlink/TextRole'), role)
	}
}