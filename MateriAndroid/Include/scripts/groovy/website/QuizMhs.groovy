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



class QuizMhs {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Mahasiswa dapat melihat durasi berjalan di quiz")
	def durasiJalan() {
		WebUI.verifyElementVisible(findTestObject('Website/QuizMhs/LabelDurasiTersisa'))
	}

	@And("Mahasiswa dapat melihat judul (.*) di quiz")
	def cekJudulQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/QuizMhs/JudulQuiz'), judul)
	}

	@And("Mahasiswa dapat melihat total pertanyaan (.*) di quiz")
	def cekTotalPertanyaan(String jumlah) {
		String jumlahTxt = "dari " + jumlah
		WebUI.verifyElementText(findTestObject('Website/QuizMhs/TotalSoal'), jumlahTxt)
	}

	@And("Mahasiswa tidak dapat melihat bobot soal di quiz")
	def cekBobotSoal() {
		WebUI.verifyElementNotPresent(findTestObject('Website/QuizMhs/LabelBobotSoal'), 0, FailureHandling.OPTIONAL)
	}

	@And("Mahasiswa dapat melihat bobot (.*) soal di quiz")
	def cekBobotSoalAda(String bobot) {
		bobot = "Bobot: " + bobot
		WebUI.verifyElementText(findTestObject('Website/QuizMhs/LabelBobotSoal'), bobot)
	}

	@And("Mahasiswa tap jawaban (.*) di quiz")
	def tapJawaban(String jawaban) {
		if (jawaban.equalsIgnoreCase("A"))
			WebUI.enhancedClick(findTestObject('Website/QuizMhs/JawabanA'))
		else if (jawaban.equalsIgnoreCase("B"))
			WebUI.enhancedClick(findTestObject('Website/QuizMhs/JawabanB'))
		else if (jawaban.equalsIgnoreCase("C"))
			WebUI.enhancedClick(findTestObject('Website/QuizMhs/JawabanC'))
	}

	@And("Mahasiswa tap pertanyaan (.*) di quiz")
	def tabButtonQuiz(String kondisi) {
		if (kondisi.equalsIgnoreCase("Berikutnya"))
			WebUI.enhancedClick(findTestObject('Website/QuizMhs/BerikutnyaButton'))
		else if (kondisi.equalsIgnoreCase("Sebelumnya"))
			WebUI.enhancedClick(findTestObject('Website/QuizMhs/SebelumnyaButton'))
	}

	@Then("Mahasiswa dapat melihat pertanyaan (.*) di quiz")
	def pertanyaanQuiz(String pertanyaan) {
		WebUI.verifyElementText(findTestObject('Website/QuizMhs/Pertanyaan'), pertanyaan)
	}

	@And("Mahasiswa dapat melihat jawaban (.*) (.*) di quiz")
	def jawabanQuiz(String pilihan, String jawaban) {
		if (pilihan.equalsIgnoreCase("A"))
			WebUI.verifyElementText(findTestObject('Website/QuizMhs/JawabanA'), jawaban)
		else if (pilihan.equalsIgnoreCase("B"))
			WebUI.verifyElementText(findTestObject('Website/QuizMhs/JawabanB'), jawaban)
		else if (pilihan.equalsIgnoreCase("C"))
			WebUI.verifyElementText(findTestObject('Website/QuizMhs/JawabanC'), jawaban)
	}

	@And("Mahasiswa tap Selesaikan quiz")
	def selesaikanQuiz() {
		WebUI.enhancedClick(findTestObject('Website/QuizMhs/SelesaikanButton'))
	}

	@And("Mahasiswa tap konfirmasi Selesaikan quiz")
	def konfirmasiSelesaikan() {
		WebUI.enhancedClick(findTestObject('Website/QuizMhs/KonfirmasiSelesaikanButton'))
	}

	@Then("Mahasiswa dapat melihat nilai di hasil quiz")
	def hasilNilai() {
		WebUI.verifyElementVisible(findTestObject('Website/QuizMhs/NilaiQuiz'))
	}

	@And("Mahasiswa dapat melihat judul (.*) di hasil quiz")
	def JudulHasilQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/QuizMhs/JudulDiHasilQuiz'), judul)
	}

	@And("Mahasiswa tap Lihat detail hasil")
	def lihatDetailHasil() {
		WebUI.enhancedClick(findTestObject('Website/QuizMhs/DetailHasilButton'))
	}

	@And("Laporan (.*) di detail hasil quiz")
	def laporanDetailHasil(String laporan) {
		if(laporan.equalsIgnoreCase("Tidak Ditampilkan"))
			WebUI.verifyElementText(findTestObject('Website/QuizMhs/LabelTidakBagikanLaporan'), "Dosen tidak membagikan laporan kuis ini")
		else
			WebUI.verifyElementPresent(findTestObject('Website/QuizMhs/IconLaporanTampil'), 0)
	}

	@When("Mahasiswa tap tutup detail hasil")
	def tutupDetailHasil() {
		WebUI.enhancedClick(findTestObject('Website/QuizMhs/TutupDetailHasilButton'))
	}

	@When("Mahasiswa tap kembali dari hasil quiz")
	def tapKembali() {
		WebUI.enhancedClick(findTestObject('Website/QuizMhs/KembaliDariHasilQuiz'))
	}
}