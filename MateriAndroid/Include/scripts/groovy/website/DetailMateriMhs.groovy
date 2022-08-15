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



class DetailMateriMhs {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Mahasiswa dapat melihat judul materi (.*) di detail materi")
	def verifyMateri(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailMateriMhs/LabelJudulMateri'), judul)
	}

	@Then("Mahasiswa dapat melihat dokumen (.*) di detail materi")
	def verifyDoc(String format) {
		if(format.equalsIgnoreCase("doc"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailMateriMhs/LabelMateriDoc'), 0)
		else if(format.equalsIgnoreCase("jpg"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailMateriMhs/LabelMateriJpg'), 0)
		else if(format.equalsIgnoreCase("mp4"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailMateriMhs/LabelMateriMp4'), 0)
	}

	@And("Mahasiswa dapat melihat catatan (.*) di detail materi")
	def verifyCatatan(String catatan) {
		WebUI.verifyElementText(findTestObject('Website/DetailMateriMhs/LabelCatatan'), catatan)
	}
}