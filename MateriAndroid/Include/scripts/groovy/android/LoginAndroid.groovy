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



class LoginAndroid {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("(.*) masuk ke android Edlink ANDROID")
	def openAndroid(String nama) {
		Mobile.startApplication('C:\\Users\\yulia\\OneDrive - Institut Teknologi Sepuluh Nopember\\Dokumen\\KESIBUKAN\\QA Sevima\\KuisWebsite\\KuisWebsite\\AndroidApp\\app-staging.apk', true)
	}

	@When("(.*) tap terms condition ANDROID")
	def tapTermsCondition(String nama) {
		Mobile.waitForElementPresent(findTestObject('Android/PrivacyPolicy/TextPrivacyPolicy'), 0)
		Mobile.tap(findTestObject('Android/PrivacyPolicy/buttonAgree'), 0)
	}

	@When("(.*) tap Siakad button ANDROID")
	def tapSiakadButton(String nama) {
		Mobile.waitForElementPresent(findTestObject('Android/LoginPage/buttonLoginBySiakad'), 0)
		Mobile.tap(findTestObject('Android/LoginPage/buttonLoginBySiakad'), 0)
	}

	@When("(.*) input universitas, username, dan password ANDROID")
	def inputDataAndroid(String nama) {
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/fieldNewUniversity'), 0)
		Mobile.tap(findTestObject('Android/LoginSiakadPage/fieldNewUniversity'), 0)
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/fieldSearchUniversity'), 0)
		Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldSearchUniversity'),"Lancang", 0)
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/selectTextLancang'), 0)
		Mobile.tap(findTestObject('Android/LoginSiakadPage/selectTextLancang'), 0)
		if(nama.equalsIgnoreCase("Dosen")) {
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUserId'), '1008078602', 0)
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldPassword'), '123456', 0)
		}
		else if(nama.equals("Mahasiswa")) {
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUserId'), '1988203004', 0)
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldPassword'), '123456', 0)
		}

		else {
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUserId'), '1008078602', 0)
			Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldPassword'), '123456', 0)
		}
	}

	@When("User input universitas, (.*), dan (.*) login ANDROID")
	def inputDataLoginAndroid(String username, String password) {
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/fieldNewUniversity'), 0)
		Mobile.tap(findTestObject('Android/LoginSiakadPage/fieldNewUniversity'),0)
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/fieldSearchUniversity'), 0)
		Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldSearchUniversity'),"Lancang", 0)
		Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/selectTextLancang'), 0)
		Mobile.tap(findTestObject('Android/LoginSiakadPage/selectTextLancang'), 0)
		Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUserId'), username, 0)
		Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldPassword'), password, 0)
	}

	@When("Click login button ANDROID")
	def tapButtonLogin() {
		Mobile.tap(findTestObject('Android/LoginSiakadPage/buttonLogin'), 0)
	}

	@Then("(.*) masuk ke beranda Edlink ANDROID")
	def verifyBeranda(String nama) {
		Mobile.waitForElementPresent(findTestObject('Android/Beranda/TextHome'), 0)
	}
}