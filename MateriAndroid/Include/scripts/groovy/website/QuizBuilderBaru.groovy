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
import org.openqa.selenium.Keys

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



class QuizBuilderBaru {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Dosen melihat pop up pengaturan quiz di builder baru")
	def popUpPengaturan() {
		WebUI.waitForElementVisible(findTestObject('Website/FormQuizBuilderBaru/PopUpPengaturanQuiz'), 1)
		WebUI.verifyElementVisible(findTestObject('Website/FormQuizBuilderBaru/PopUpPengaturanQuiz'))
		WebUI.verifyElementText(findTestObject('Website/FormQuizBuilderBaru/LabelPengaturanQuiz'), "Pengaturan Quiz")
	}

	@Given("Dosen input judul quiz (.*) di builder baru")
	def inputJudul(String judul) {
		WebUI.sendKeys(findTestObject('Website/FormQuizBuilderBaru/FieldJudulQuiz'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/FormQuizBuilderBaru/FieldJudulQuiz'), judul)
	}

	@When("Dosen tap indikator penilaian quiz otomatis di builder baru")
	def tapIndikatorOtomatis() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/RadioBobotOtomatis'))
	}

	@When("Dosen tap indikator penilaian quiz per soal di builder baru")
	def tapIndikatorManual() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/RadioBobotPerSoal'))
	}

	@And("Dosen input durasi quiz (\\d+) di builder baru")
	def inputDurasi(int durasi) {
		WebUI.sendKeys(findTestObject('Website/FormQuizBuilderBaru/FieldDurasi'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/FormQuizBuilderBaru/FieldDurasi'), String.valueOf(durasi))
	}

	@And("Dosen tap non aktif batas nilai quiz builder baru")
	def nonAktifBatasNilai() {
	}

	@And("Dosen tap laporan kepada peserta quiz (.*) di builder baru")
	def tapLaporanPeserta(String laporan) {
	}

	@And("Dosen tap simpan pengaturan quiz di builder baru")
	def tapSimpanPengaturan() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonSimpan'))
	}

	@Then("Dosen melihat judul quiz (.*) di form quiz builder baru")
	def verifyJudul(String judul) {
		WebUI.verifyElementText(findTestObject('Website/FormQuizBuilderBaru/LabelJudulQuiz'), judul)
	}

	@When("Dosen tap tambah pertanyaan quiz di builder baru")
	def tapTambahPertanyaan() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonTambahPertanyaan'))
	}

	@When("Dosen input pertanyaan quiz (.*) di builder baru")
	def inputPertanyaan(String soal) {
		WebUI.setText(findTestObject('Website/FormQuizBuilderBaru/FieldPertanyaan'), soal)
	}

	@And("Dosen input jawaban (.*) quiz (.*) di builder baru")
	def inputJawaban(String pilihan, String jawaban) {
		String fieldJawaban = '(//*/div[@class=\'box has-background-white-bis\']//*/div[@class=\'textarea height-body-auto\']/*//p)'
		TestObject to = new TestObject("objectName")
		
		if(pilihan.equalsIgnoreCase("A")) {
			fieldJawaban = fieldJawaban + '[1]'
			to.addProperty("xpath", ConditionType.EQUALS, fieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else if (pilihan.equalsIgnoreCase("B")) {
			fieldJawaban = fieldJawaban + '[2]'
			to.addProperty("xpath", ConditionType.EQUALS, fieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else if (pilihan.equalsIgnoreCase("C")) {
			fieldJawaban = fieldJawaban + '[3]'
			to.addProperty("xpath", ConditionType.EQUALS, fieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else
			println(pilihan)
	}

	@And("Dosen input bobot pertanyaan (\\d+) di builder baru")
	def inputBobot(int bobot) {
		WebUI.setText(findTestObject('Website/FormQuizBuilderBaru/FieldBobotPertanyaan'), String.valueOf(bobot))
		WebUI.delay(2)
	}
	
	@And("Dosen tap jawaban (.*) sebagai kunci jawaban di builder baru")
	def tapJawaban(String pilihan) {
		String dynamicId = '(//*/span[@data-label=\'Pilih jawaban ini sebagai Jawaban Benar\'])'
		String xpath
		TestObject to = new TestObject("objectName")
		
		if(pilihan.equalsIgnoreCase('A')) {
			xpath = dynamicId + '[1]'
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
			WebUI.enhancedClick(to)
		}
		 
		else if(pilihan.equalsIgnoreCase('B')) {
			xpath = dynamicId + '[2]'
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
			WebUI.enhancedClick(to)
		}
		
		else if(pilihan.equalsIgnoreCase('C')) {
			xpath = dynamicId + '[3]'
			to.addProperty("xpath", ConditionType.EQUALS, xpath)
			WebUI.enhancedClick(to)
		}
	}

	@Then("Pertanyaan quiz (.*) berhasil disimpan di builder baru")
	def pertanyaanTersimpan(String judul) {
	}

	@Given("Dosen tap button Bagikan di builder baru")
	def tapMenuBagikan() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonMenuBagikanQuiz'))
	}

	@Then("Dosen melihat pop up pengaturan bagikan quiz di builder baru")
	def verifyAturanBagikan() {
		WebUI.verifyElementVisible(findTestObject('Website/FormQuizBuilderBaru/PopUpPengaturanBagikan'))
		WebUI.verifyElementText(findTestObject('Website/FormQuizBuilderBaru/LabelPengaturanBagikan'), "Bagikan Quiz")
	}

	@Given("Dosen input catatan quiz (.*) di builder baru")
	def inputCatatan(String catatan) {
		WebUI.setText(findTestObject('Website/FormQuizBuilderBaru/FieldCatatan'), catatan)
	}

	@When("Dosen non aktif batas waktu di builder baru")
	def nonAktifBatasWkt() {
	}

	@And("Dosen tap bagikan quiz sekarang di builder baru")
	def tapBagikanSekarang() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonBagikanSekarang'))
	}

	@And("Dosen tap bagikan quiz nanti di builder baru")
	def tapBagikanNanti() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonBagikanNanti'))
	}

	@And("Dosen tap button Bagikan di pop up builder baru")
	def tapBtnBagikan() {
		WebUI.enhancedClick(findTestObject('Website/FormQuizBuilderBaru/ButtonBagikan'))
	}
}