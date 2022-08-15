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



class DetailQuizMhs {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Mahasiswa dapat melihat catatan quiz (.*) di detail quiz")
	def cekCatatanQuiz(String catatan) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelCatatan'), catatan)
	}

	@Then("Mahasiswa dapat melihat judul quiz (.*) di detail quiz")
	def cekJudulQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelJudulQuiz'), judul)
	}

	//	@Then("Mahasiswa dapat melihat durasi quiz (\\d+) Menit di detail quiz")
	//	def cekDurasiQuiz(int durasi) {
	//		String durasiAll
	//		if(durasi < 60) {
	//			durasiAll = "Durasi: " + String.valueOf(durasi) + " Menit"
	//		}
	//		else {
	//			int durasiJam = durasi / 60
	//			durasi = durasi % 60
	//
	//			if(durasi == 0)
	//				durasiAll = "Durasi: " + String.valueOf(durasiJam) + ' Jam'
	//			else
	//				durasiAll = "Durasi: " + String.valueOf(durasiJam) + ' Jam ' + Integer.toString(durasi) + ' Menit'
	//		}
	//
	//		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelDurasi'), durasiAll)
	//	}

	@Then("Mahasiswa dapat melihat total pertanyaan quiz (\\d+) di detail quiz")
	def cekTotalPertanyaan(int pertanyaan) {
		String totalPertanyaan = String.valueOf(pertanyaan) + " Soal"
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelTotalPertanyaan'), String.valueOf(pertanyaan))
	}

	@Then("Mahasiswa dapat melihat total pertanyaan quiz (.*) dan durasi quiz (\\d+) Menit di detail quiz")
	def cekTotalPertanyaanDanDurasi(String pertanyaan, int durasi) {
		String totalPertanyaan = "Jumlah Soal: " + pertanyaan + " Soal · "
		String durasiAll
		if(durasi < 60) {
			durasiAll = "Durasi Pengerjaan: " + String.valueOf(durasi) + " Menit"
		}
		else {
			int durasiJam = durasi / 60
			durasi = durasi % 60

			if(durasi == 0)
				durasiAll = "Durasi Pengerjaan: " + String.valueOf(durasiJam) + ' Jam'
			else
				durasiAll = "Durasi Pengerjaan: " + String.valueOf(durasiJam) + ' Jam ' + Integer.toString(durasi) + ' Menit'
		}

		totalPertanyaan = totalPertanyaan + durasiAll

		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelDurasi'), totalPertanyaan)
	}

	@When("Mahasiswa tap mulai quiz")
	def tapMulaiQuiz() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizMhs/MulaiQuizButton'))
	}

	@And("Mahasiswa dapat melihat nilai quiz di detail quiz")
	def nilaiQuiz() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizMhs/LabelNilaiQuiz'), 0)
	}

	@And("Mahasiswa dapat melihat jumlah pertanyaan (.*) di detail quiz")
	def jumlahPertanyaan(String jml) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelJumlahPertanyaan'), jml)
	}

	@And("Mahasiswa dapat melihat jawaban benar (.*) di detail quiz")
	def jawabanBenar(String jml) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelBenar'), jml)
	}

	@And("Mahasiswa dapat melihat jawaban salah (.*) di detail quiz")
	def jawabanSalah(String jml) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizMhs/LabelSalah'), jml)
	}

	@And("Mahasiswa dapat melihat Durasi Pengerjaan")
	def durasiPengerjaan() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizMhs/LabelDurasiPengerjaan'), 0)
	}

	@When("Mahasiswa tap kembali dari detail quiz")
	def kembaliDariDetailQuiz() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizMhs/Kembali'))
	}
}