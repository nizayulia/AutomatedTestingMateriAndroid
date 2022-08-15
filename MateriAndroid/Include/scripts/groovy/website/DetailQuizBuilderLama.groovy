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
import com.kms.katalon.core.webui.keyword.builtin.VerifyTextPresentKeyword

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver

import static org.junit.Assert.assertTrue

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



class DetailQuizBuilderLama {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Then("Judul quiz (.*) berhasil disimpan")
	def judulQuizTersimpan(String judul) {
		WebUI.delay(15)
		//WebUI.sendKeys(findTestObject('formQuizBuilderLama/JudulField'), Keys.chord(Keys.F5, Keys.ENTER))
		WebUI.waitForElementVisible(findTestObject('Website/DetailQuizBuilderLama/FormQuiz'), 0)
		WebUI.verifyElementNotClickable(findTestObject('Website/DetailQuizBuilderLama/JudulField'))
		//		WebUI.verifyElementText(findTestObject('DetailQuizBuilderLama/JudulField'), judul)
	}

	@Then("Bagikan quiz (.*) berhasil disimpan")
	def bagikanQuizTersimpan(String bagikanQuiz) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelDibagikanSekarang'), bagikanQuiz)
	}

	@Then("Indikator Penilaian quiz bobot otomatis berhasil disimpan")
	def indikatorBobotOtomatisTersimpan() {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelBobotOtomatis'), "Bobot otomatis: Sistem otomatis membagi nilai bobot per soal")
	}

	@Then("Indikator Penilaian quiz bobot per soal berhasil disimpan")
	def indikatorBobotPerSoalTersimpan() {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelBobotOtomatis'), "Bobot per soal: Nilai bobot per soal ditentukan secara manual")
	}

	@And("Batas nilai minimal lulus quiz (.*) berhasil disimpan")
	def batasNilaiTersimpan(String batas) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelBatasNilai'), batas)
	}

	@Then("Durasi pengerjaan quiz (\\d+) (.*) berhasil disimpan")
	def durasiPengerjaanTersimpan(int durasi, String menit) {
		String txtDurasi
		if(durasi < 60)
			txtDurasi = String.valueOf(durasi) + ' ' + menit
		else {
			int durasiJam = durasi / 60
			durasi = durasi % 60

			if(durasi == 0)
				txtDurasi = String.valueOf(durasiJam) + ' Jam'
			else
				txtDurasi = String.valueOf(durasiJam) + ' Jam ' + String.valueOf(durasi) + ' ' + menit
		}
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelDurasiPengerjaan'), txtDurasi)
	}

	@Then("Batas waktu quiz (.*) berhasil disimpan")
	def batasWaktuTersimpan(String batasWaktu) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelBatasWaktu'), batasWaktu)
	}

	@Then("Laporan kepada peserta quiz (.*) berhasil disimpan")
	def laporanPadaPesertaTersimpan(String laporan) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelTampilkanLaporan'), laporan)
	}

	@Then("Catatan quiz (.*) berhasil disimpan")
	def catatanTersimpan(String catatan) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/LabelCatatan'), catatan)
	}

	@When ("Dosen tap kembali ke detail sesi kelas")
	def KembaliDetailSesi() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelKembali'))
	}

	@Then ("Dosen dapat melihat laporan quiz mahasiswa di detail quiz")
	def laporanQuiz() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizBuilderLama/LaporanQuiz'), 0)
	}

	@And ("Dosen dapat melihat nilai peserta quiz (\\d+) di detail quiz")
	def nilaiPeserta(int nilai) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/NilaiPeserta'), String.valueOf(nilai+nilai))
	}

	@And ("Dosen dapat melihat nilai peserta quiz bobot otomatis (\\d+) di detail quiz")
	def nilaiPesertaOtomatis(int nilai) {
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/NilaiPeserta'), String.valueOf(nilai))
	}

	@And ("Dosen tap detail hasil pengerjaan quiz di detail quiz")
	def btnDetailHasil() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/ButtonDetailPengerjaan'))
	}

	@And ("Dosen dapat melihat soal benar mahasiswa dari (.*) soal di detail quiz")
	def hasilLaporanBenar(String soal) {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizBuilderLama/BenarPeserta'), 0)
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/TotalSoalBenarPeserta'), soal)
	}

	@And ("Dosen dapat melihat soal salah mahasiswa dari (.*) soal di detail quiz")
	def hasilLaporanSalah(String soal) {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizBuilderLama/SalahPeserta'), 0)
		WebUI.verifyElementText(findTestObject('Website/DetailQuizBuilderLama/TotalSoalSalahPeserta'), soal)
	}

	@When ("Dosen tap detail laporan quiz di detail quiz")
	def tapDetailLaporan() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/DetailLaporanButton'))
	}

	@Then ("Dosen dapat melihat jawaban mahasiswa")
	def jawabanMhs() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailQuizBuilderLama/LabelJawabanPeserta'), 0)
	}

	@When("Dosen tap kembali dari detail hasil pengerjaan quiz")
	def kembaliDariDetailLaporan() {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelKembali'))
	}
}