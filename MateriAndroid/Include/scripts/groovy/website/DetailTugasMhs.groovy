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



class DetailTugasMhs {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Mahasiswa dapat melihat judul tugas (.*) di detail tugas")
	def verifyMateri(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasMhs/LabelJudulMateri'), judul)
	}
	
	@Then("Mahasiswa dapat melihat sisa waktu pengumpulan di detail tugas")
	def verifySisaWaktu() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailTugasMhs/LabelSisaWaktu'), 0)
	}

	@Then("Mahasiswa dapat melihat dokumen (.*) di detail tugas")
	def verifyDoc(String format) {
		if(format.equalsIgnoreCase("doc"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasMhs/LabelMateriDoc'), 0)
		else if(format.equalsIgnoreCase("jpg"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasMhs/LabelMateriJpg'), 0)
		else if(format.equalsIgnoreCase("mp4"))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasMhs/LabelMateriMp4'), 0)
	}

	@And("Mahasiswa dapat melihat catatan (.*) di detail tugas")
	def verifyCatatan(String catatan) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasMhs/LabelCatatan'), catatan)
	}

	@And("Mahasiswa mengisi jawaban tugas (.*) di detail tugas")
	def setJawaban(String jawaban) {
		WebUI.setText(findTestObject('Website/DetailTugasMhs/FieldJawaban'), jawaban)
	}

	@When("Mahasiswa tap menambahkan berkas di detail tugas")
	def tapTambahBerkas() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasMhs/ButtonTambahBerkas'))
	}

	@Then("Mahasiswa melihat media (.*) telah terpilih di detail tugas")
	def verifyMediaMhs(String format) {
		if(format.equalsIgnoreCase("doc"))
			WebUI.verifyElementVisible(findTestObject('Website/DetailTugasMhs/LabelBerkasDoc'))
		else if(format.equalsIgnoreCase("jpg"))
			WebUI.verifyElementVisible(findTestObject('Website/DetailTugasMhs/LabelBerkasJpg'))
		//else if(format.equalsIgnoreCase("mp4"))
		//WebUI.verifyElementVisible(findTestObject('Website/DetailTugasMhs/LabelBerkasMp4'))
		//perlu input ke media library mp4
	}

	@And("Mahasiswa tap simpan jawaban di detail tugas")
	def tapSimpanJawaban() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasMhs/ButtonSimpan'))
	}

	@And("Mahasiswa tap Ya di pop up detail tugas")
	def tapYaPopUp() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasMhs/ButtonYaPopUp'))
	}

	@Then("Mahasiswa dapat melihat jawaban (.*) tersimpan di detail tugas")
	def verifyJawaban(String jawaban) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasMhs/LabelJawaban'), jawaban)
	}

	@And("Mahasiswa dapat melihat daftar anggota yang telah mengumpulkan dengan nama (.*) di detail tugas")
	def verifyPengumpulan(String nama) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasMhs/LabelTelahMengumpulkan'), nama)
	}

	@And("Mahasiswa dapat melihat nilai tugas (.*) di detail tugas")
	def verifyNilai(String nilai) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasMhs/LabelNilaiTugas'), nilai)
	}
}