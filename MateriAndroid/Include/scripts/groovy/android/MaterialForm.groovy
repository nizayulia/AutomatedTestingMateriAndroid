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



class MaterialForm {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Dosen input judul material (.*) di ANDROID")
	def inputJudulMaterial(String judul) {
		Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldJudulMaterial'), 0)
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldJudulMaterial'), judul, 0)
	}

	@And("Dosen input catatan material (.*) di ANDROID")
	def inputNotesMaterial(String notes) {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldNotesMaterial'), 0)
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldAddNotesMaterial'), notes , 0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAddNotesMaterial'), 0)
	}

	@And("Dosen choose file material (.*) dengan (.*) di ANDROID")
	def ChooseMaterial( String jenisFile, String namaFile) {
		if (jenisFile.equalsIgnoreCase("doc") ) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAttachFile'), 0)
			Mobile.scrollToText(namaFile)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ChooseFileDoc'), 0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ButtonAttachment'), 0)
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldAttachmentExist'), 0)
		}
		else if (jenisFile.equalsIgnoreCase("mp4")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAttachFile'), 0)
			Mobile.scrollToText(namaFile)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ChooseFileMp4'), 0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ButtonAttachment'), 0)
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldAttachmentExist'), 0)
		}
		else if (jenisFile.equalsIgnoreCase("jpg")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAttachFile'), 0)
			Mobile.scrollToText(namaFile)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ChooseFileJpg'), 0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Attachment/ButtonAttachment'), 0)
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/FieldAttachmentExist'), 0)
		}
		else
			Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonNextStep'), 0)
	}

	@When("Dosen tap next step material di ANDROID")
	def nextStepMaterial () {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonNextStep'), 0)
	}

	@And("Dosen tap share (.*) material di ANDROID")
	def shareMaterial (String optionShare) {
		if (optionShare.equalsIgnoreCase("now"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonShareNow'),  0)
		else if (optionShare.equalsIgnoreCase("later")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ButtonSwitchOptionShare'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ButtonEditTimeShare'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ChooseShareDate20Feb2022'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ButtonDateOk'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ChooseShareClock12'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ChooseMinutes'),0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/Share Later/ButtonDateOk'),0)			
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonShareLater'),  0)
		}
	}

	@Then("Dosen telah membagikan material di ANDROID")
	def materialShared () {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonMaterialShared'), 0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonMaterialShared'), 0)
	}
}