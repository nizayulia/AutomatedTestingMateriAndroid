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



class DetailTugas {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Then("Judul tugas (.*) berhasil disimpan")
	def veifyJudul(String judul) {
		WebUI.verifyElementNotClickable(findTestObject('Website/DetailTugasDosen/LabelJudulMateri'))
	}

	@And("Bagikan tugas (.*) berhasil disimpan")
	def verifyBagikan(String bagikan) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasDosen/LabelDibagikanSekarang'), bagikan)
	}
	
//	@And("Tanggal & Waktu Selesai tugas berhasil disimpan")
//	def verify

	@And("Dokumen tugas format doc berhasil disimpan")
	def verifyFormatDoc() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelDokumenDoc'), 0)
	}

	@And("Dokumen tugas format jpg berhasil disimpan")
	def verifyFormatJpg() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelDokumenJpg'), 0)
	}

	@And("Dokumen tugas format mp4 berhasil disimpan")
	def verifyFormatMp4() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelDokumenMp4'), 0)
	}

	@When("Dosen melihat mahasiswa telah mengumpulkan tugas di detail tugas")
	def verifyKumpulkanTugas() {
		WebUI.waitForElementPresent(findTestObject('Website/DetailTugasDosen/LabelTugasMhs'), 0)
		WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelTugasMhs'), 0)
	}

	@And("Dosen tap lihat tugas mahasiswa di detail tugas")
	def tapLihatTugas() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasDosen/ButtonLihat'))
	}

	@When("Tugas (.*) dihapus")
	def hapusTugas(String judul) {
		WebUI.enhancedClick(findTestObject('Website/DetailQuizBuilderLama/LabelHapus'))
		WebUI.waitForElementVisible(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'), 0)
		WebUI.click(findTestObject('Website/DetailQuizBuilderLama/YaPopUpButton'))
		WebUI.delay(3)
	}

	/////////// Detail Jawaban Tugas Mahasiswa
	@Then("Dosen melihat jawaban tugas mahasiswa (.*) di detail jawaban mahasiswa")
	def verifyJawabanMhs(String jwb) {
		WebUI.waitForElementVisible(findTestObject('Website/DetailTugasDosen/LabelJawabanMhs'), 0)
		WebUI.verifyElementText(findTestObject('Website/DetailTugasDosen/LabelJawabanMhs'), jwb)
	}
	
	@And("Dosen melihat berkas (.*) tugas mahasiswa di detail jawaban mahasiswa")
	def verifyBerkasMhs(String tipe) {
		if(tipe.equalsIgnoreCase('doc'))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelBerkasDocMhs'), 0)
		else if(tipe.equalsIgnoreCase('jpg'))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelBerkasJpgMhs'), 0)
		else if(tipe.equalsIgnoreCase('mp4'))
			WebUI.verifyElementPresent(findTestObject('Website/DetailTugasDosen/LabelBerkasMp4Mhs'), 0)
	}	

	@Given("Dosen input nilai tugas mahasiswa (.*) di detail jawaban mahasiswa")
	def inputNilai(String nilai) {
		WebUI.setText(findTestObject('Website/DetailTugasDosen/FieldNilai'), nilai)
	}

	@When("Dosen input feedback tugas mahasiswa (.*) di detail jawaban mahasiswa")
	def inputFeedback(String feedback) {
		WebUI.setText(findTestObject('Website/DetailTugasDosen/FieldFeedback'), feedback)
	}

	@And("Dosen tap Simpan & Lanjut di detail jawaban mahasiswa")
	def tapSimpanNLanjut() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasDosen/ButtonSimpan'))
	}

	@And("Dosen close detail jawaban mahasiswa")
	def tapCloseDetailJwb() {
		WebUI.enhancedClick(findTestObject('Website/DetailTugasDosen/ButtonCloseJawaban'))
	}

	@And("Dosen melihat tugas mahasiswa telah dinilai (.*) di detail tugas")
	def verifyPenilaianTugas(String nilai) {
		WebUI.verifyElementText(findTestObject('Website/DetailTugasDosen/LabelNilaiMhs'), nilai)
	}
}