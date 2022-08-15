package android
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.ConcurrentHashMap.KeySetView

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

import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
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



class FormQuiz {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Dosen input judul quiz (.*) di ANDROID")
	def inputJudulQuiz(String judul) {
		Mobile.verifyElementExist(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJudulQuiz'), 0)
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJudulQuiz'), judul, 0)
	}

	@When("Dosen tap indikator penilaian quiz (.*) di ANDROID")
	def tapIndikatorPenilaian(String indikator) {
		if(indikator.equalsIgnoreCase("otomatis"))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/RadioBobotOtomatis'), 0)
		else
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/RadioBobotPerSoal'), 0)
	}

	@And("Dosen input durasi quiz (.*) di ANDROID")
	def inputDurasi(String durasi) {
		Mobile.sendKeys(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldDurasi'), durasi)
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldDurasi'), durasi, 0)
	}

	@And("Dosen tap non aktif batas nilai quiz di ANDROID")
	def nonAktifBatasNilai() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0
		int endY = device_Height * 0.9
		Mobile.swipe(startX, endY, endX, startY)

		if(Mobile.getAttribute(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxBatasLulus'), 'checked', 0).equalsIgnoreCase('True'))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxBatasLulus'), 0)
	}

	@And("Dosen tap non aktif Deadline quiz di ANDROID")
	def nonAktifDeadline() {
		if(Mobile.getAttribute(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxDeadline'), 'checked', 0).equalsIgnoreCase('True'))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxDeadline'), 0)
	}

	@And("Dosen tap non aktif Laporan ke Peserta quiz di ANDROID")
	def nonAktifLaporan() {
		if(Mobile.getAttribute(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxLaporan'), 'checked', 0).equalsIgnoreCase('False'))
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxLaporan'), 0)
		else
			Mobile.getAttribute(findTestObject('Android/ClassSubMenu/ZFormQuiz/CheckboxLaporan'), 'checked', 0)
	}

	@And("Dosen tap button (.*) settings quiz di ANDROID")
	def buttonPengaturan(String btn) {
		if(btn.equalsIgnoreCase("Simpan")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonSimpan'), 0)
		}
		else if(btn.equalsIgnoreCase("Kembali")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonKembali'), 0)
		}
	}

	@Then("Dosen masuk halaman form pertanyaan quiz (.*) di ANDROID")
	def masukFormPertanyaanQuiz(String judul) {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZFormQuiz/TextJudulQuiz'), 0)
		//		Mobile.verifyElementAttributeValue(findTestObject('Android/ClassSubMenu/ZFormQuiz/TextJudulQuiz'), 'text', judul, 0)
		Mobile.getAttribute(findTestObject('Android/ClassSubMenu/ZFormQuiz/TextJudulQuiz'), 'text', 0)
	}

	@When("Dosen tap tambah pertanyaan quiz di ANDROID")
	def tapBtnTambahPertanyaan() {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonTambahPertanyaan'), 0)
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonTambahPertanyaan'), 0)
	}

	@And("Dosen input pertanyaan quiz (.*) di ANDROID")
	def inputPertanyaan(String pertanyaan) {
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldPertanyaan'), pertanyaan, 0)
		Mobile.scrollToText("Pilihan Jawaban")
	}

	@And("Dosen input jawaban (.*) quiz (.*) di ANDROID")
	def inputJawaban(String pilihan, String jawaban) {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0
		int endY = device_Height * 0.9
		Mobile.swipe(startX, endY, endX, startY)

		if(pilihan.equalsIgnoreCase("A")) {
			//			Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZFormQuiz/jawaban1(1)'), 0)
			Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJawaban1'), jawaban, 0)
		}
		else if (pilihan.equalsIgnoreCase("B"))
			Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJawaban2'), jawaban, 0)
		else if (pilihan.equalsIgnoreCase("C"))
			Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldJawaban3'), jawaban, 0)
		else
			println(pilihan)
	}

	@And("Dosen tap Selesai pertanyaan quiz di ANDROID")
	def tapSelesaiPertanyaan() {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0.2
		int endY = device_Height * 0.8
		Mobile.swipe(startX, startY, endX, endY)

		Mobile.scrollToText("Selesai")
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/LinkSelesai'), 0)
		Mobile.delay(5)
	}

	@Then("Pertanyaan quiz (.*) berhasil disimpan di ANDROID")
	def pertanyaanTersimpan(String pertanyaan) {
		//		Mobile.scrollToText(pertanyaan)
		Mobile.verifyElementAttributeValue(findTestObject('Android/ClassSubMenu/ZFormQuiz/TextPertanyaanTersimpan'), 'text', pertanyaan, 0, FailureHandling.STOP_ON_FAILURE)
	}

	@When("Dosen tap button bagikan quiz di ANDROID")
	def bagikanQuiz() {
		Mobile.scrollToText("Bagikan Quiz")

		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonBagikanQuiz'), 0)
	}

	@When("Dosen input catatan quiz (.*) di ANDROID")
	def inputCatatan(String catatan) {
		Mobile.waitForElementPresent(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldCatatan'), 0)
		Mobile.setText(findTestObject('Android/ClassSubMenu/ZFormQuiz/FieldCatatan'), catatan, 0)
	}

	@And("Dosen tap button bagikan quiz (.*) di ANDROID")
	def bagikanKapan(String bagikan) {
		int device_Height = Mobile.getDeviceHeight()
		int device_Width = Mobile.getDeviceWidth()
		int startX = device_Width / 2
		int endX = startX
		int startY = device_Height * 0
		int endY = device_Height * 0.9
		Mobile.swipe(startX, endY, endX, startY)

		if(bagikan.equalsIgnoreCase("Sekarang")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonBagikanSekarang'), 0)
		}
		else if(bagikan.equalsIgnoreCase("Nanti")) {
			Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonBagikanNanti'), 0)
		}
	}

	@And("Dosen tap button submit bagikan di ANDROID")
	def submitQuiz() {
		Mobile.tap(findTestObject('Android/ClassSubMenu/ZFormQuiz/ButtonSubmitBagikan'), 0)
	}

	@Then("Quiz (.*) berhasil disimpan")
	def quizTersimpan(String judul) {
		Mobile.waitForElementPresent(findTestObject('Android/DetailQuiz/TextDetailQuiz'), 0)
		Mobile.waitForElementPresent(findTestObject('Android/DetailQuiz/TextJudulQuiz'), 0)
		Mobile.verifyElementAttributeValue(findTestObject('Android/DetailQuiz/TextJudulQuiz'), 'text', judul, 0)
	}

	@And("Dosen tap soal nomor (.*) di Android")
	def tapnomorSoal(String judul) {
	}
}