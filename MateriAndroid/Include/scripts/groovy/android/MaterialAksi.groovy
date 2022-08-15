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



class MaterialAksi {
	@Given ("(.*) tap materi (.*) yang akan dilakukan aksi di menu (.*) ANDROID")
	def chooseMaterial(String nama, String cases, String menu) {
		/*ubah text pada JudulMateri1 sesuai dengan cases*/
		if (menu.equalsIgnoreCase("class")) {
			Mobile.scrollToText(cases)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/JudulMateri1'), 0)
		}
		else if (menu.equalsIgnoreCase("sesi")) {
			Mobile.scrollToText(cases)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/JudulMateriSesi'), 0)
		}
	}

	@When ("Dosen tap icon aksi di detail materi di ANDROID")
	def aksiMaterial () {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/ButtonOptionAksi'),  0)
	}

	@And ("Dosen tap opsi (.*) di detail materi di ANDROID")
	def chooseAksi (String aksi) {
		if (aksi.equalsIgnoreCase("edit")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/ButtonEdit'), 0)
		}
		else if (aksi.equalsIgnoreCase("delete")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/ButtonDelete'),  0)
			Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZAksiMaterial/popUpDelete'), 0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/ButtonDeleteYes'), 0)
		}
	}

	@Given("Dosen edit (.*) material (.*) di ANDROID")
	def editMaterial(String opsiEdit, String detailEdit) {
		if(opsiEdit.equalsIgnoreCase("judul")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/fieldJudul'), 0)
			Mobile.setText(findTestObject('Android/ClassSubMenu/ZAksiMaterial/fieldEditJudul'), detailEdit , 0)
//			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAddNotesMaterial'), 0)
		}
		else if(opsiEdit.equalsIgnoreCase("notes")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZAksiMaterial/TapEditNotes'), 0)
			Mobile.setText(findTestObject('Android/ClassSubMenu/ZAksiMaterial/FieldEditNotes'), detailEdit , 0)
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormMaterial/ButtonAddNotesMaterial'), 0)
		}
	}
}