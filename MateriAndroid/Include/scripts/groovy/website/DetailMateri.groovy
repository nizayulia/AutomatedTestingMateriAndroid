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



class DetailMateri {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Judul materi (.*) berhasil disimpan")
	def veifyJudul(String judul) {
		WebUI.verifyElementNotClickable(findTestObject('Website/DetailMateriDosen/LabelJudulMateri'))
	}
	
	@And("Bagikan materi (.*) berhasil disimpan")
	def verifyBagikan(String bagikan) {
		WebUI.verifyElementText(findTestObject('Website/DetailMateriDosen/LabelDibagikanSekarang'), bagikan)
	}

	@And("Dokumen materi format doc berhasil disimpan")
	def verifyFormatDoc() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailMateriDosen/LabelDokumenDoc'), 0)
	}
	
	@And("Dokumen materi format jpg berhasil disimpan")
	def verifyFormatJpg() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailMateriDosen/LabelDokumenJpg'), 0)
	}
	
	@And("Dokumen materi format mp4 berhasil disimpan")
	def verifyFormatMp4() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailMateriDosen/LabelDokumenMp4'), 0)
	}
	
	@When("Materi (.*) dihapus")
	def hapusMateri(String judul) {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelHapus'))
		WebUI.waitForElementVisible(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'), 0)
		WebUI.click(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'))
		WebUI.delay(3)
	}
}