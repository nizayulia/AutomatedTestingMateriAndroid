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



class BuatTugas {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Dosen tap icon tugas di beranda Edlink")
	def tapIconTugas() {
		WebUI.waitForElementVisible(findTestObject('Website/dashboard/ImageTugas'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ImageTugas'))
	}

	@Then("Dosen melihat form atur tugas")
	def verifyAturTugas() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Atur Tugas")
	}

	@Given("Dosen input judul tugas (.*) di pop up atur tugas")
	def inputJudul(String judul) {
		WebUI.setText(findTestObject('Website/dashboard/ZBuatTugas/FieldJudul'), judul)
	}

	@When("Dosen tap tambah berkas di pop up atur tugas")
	def tapTambahBerkas() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonTambahBerkas'))
	}

	@Then("Dosen melihat media (.*) telah terpilih di pop up atur tugas")
	def mediaTerpilih(String format) {
		if(format.equalsIgnoreCase("doc"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasDoc'))
		else if(format.equalsIgnoreCase("jpg"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasJpg'))
		else if(format.equalsIgnoreCase("mp4"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasMp4'))
	}

	@Given("Dosen tap langkah berikutnya di pop up atur tugas")
	def BerikutnyaTugas() {
		WebUI.waitForElementPresent(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaAturMateri'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaAturMateri'))
	}

	@Then("Dosen melihat pop up bagikan tugas")
	def verifyBagikanTugas() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Bagikan Tugas")
	}

	@Given("Dosen input catatan (.*) di pop up bagikan tugas")
	def inputCatatan(String catatan) {
		WebUI.setText(findTestObject('Website/dashboard/ZBuatMateri/FieldCatatan'), catatan)
	}

	@When("Dosen tap bagikan tugas sekarang di pop up bagikan tugas")
	def tapBagikanSekarang() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBagikanSekarang'))
	}

	@When("Dosen tap bagikan di pop up bagikan tugas")
	def tapSubmitBagikan() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonSubmitBagikan'))
	}

	@Then("Tugas (.*) berhasil tersimpan di sistem dashboard")
	def tugasTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulTugas'), judul)
	}

	@Then("Dosen tap tugas di dashboard")
	def tapTugas() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LabelJudulTugas'))
	}
	
	@Then("Dosen masuk halaman form buat tugas")
	def FormBuatTugas() {
		WebUI.verifyElementPresent(findTestObject('Website/FormTugas/FormTugas'), 0)
	}
	
	@Given("Dosen input judul tugas (.*) di form buat tugas")
	def inputJudulForm(String judul) {
		WebUI.sendKeys(findTestObject('Website/FormTugas/FieldJudul'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/FormTugas/FieldJudul'), judul)
	}

	@When("Dosen tap bagikan tugas sekarang di form buat tugas")
	def tapBagikanSekarangForm() {
		WebUI.enhancedClick(findTestObject('Website/FormTugas/ButtonBagikanSekarang'))
	}
	
	@When("Dosen tap aktifkan batas waktu penyerahan di form buat tugas")
	def aktifkanBatasWaktu() {
		String aktivasi = WebUI.getText(findTestObject('Website/FormTugas/LabelBatasWaktu'))
		
		if(aktivasi.equalsIgnoreCase('Tidak'))
			WebUI.enhancedClick(findTestObject('Website/FormTugas/LabelBatasWaktu'))
	}

	@And("Dosen tap tambah dokumen di form buat tugas")
	def tapTambahDokumen() {
		WebUI.enhancedClick(findTestObject('Website/FormTugas/LinkTambahDokumen'))
	}

	@And("Dosen tap tambah gambar di form buat tugas")
	def tapTambahGambar() {
		WebUI.enhancedClick(findTestObject('Website/FormTugas/LinkTambahGambar'))
	}

	@And("Dosen tap tambah video di form buat tugas")
	def tapTambahVideo() {
		WebUI.enhancedClick(findTestObject('Website/FormTugas/LinkTambahVideo'))
	}

	@Then("Dosen melihat media doc telah terpilih di form buat tugas")
	def verifyDocForm() {
		WebUI.verifyElementPresent(findTestObject('Website/FormTugas/LabelMediaDoc'), 0)
	}

	@Then("Dosen melihat media jpg telah terpilih di form buat tugas")
	def verifyJpgForm() {
		WebUI.verifyElementPresent(findTestObject('Website/FormTugas/LabelMediaJpg'), 0)
	}

	@Then("Dosen melihat media mp4 telah terpilih di form buat tugas")
	def verifyMp4Form() {
		WebUI.verifyElementPresent(findTestObject('Website/FormTugas/LabelMediaMp4'), 0)
	}

	@When("Dosen input catatan (.*) di form buat tugas")
	def inputCatatanForm(String catatan) {
		WebUI.setText(findTestObject('Website/FormTugas/FieldCatatan'), catatan)
	}

	@When("Dosen tap simpan di form buat tugas")
	def tapSimpan() {
		WebUI.enhancedClick(findTestObject('Website/FormTugas/ButtonSimpan'))
	}
	
	@And("Dosen dapat melihat batas & waktu pengumpulan di beranda Edlink")
	def dosenVerifyBatasWaktu() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelBatasPengumpulanTugas'), 0)
	}
	
	@And("Dosen dapat melihat countdown pengumpulan di beranda Edlink")
	def dosenVerifyCountdown() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelCountdownTugas'), 0)
	}
	
	
	// Mahasiswa
	@Given("Mahasiswa dapat melihat tugas (.*) di beranda Edlink")
	def verifyTugasMhs(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulTugas'), judul)
	}
	
	@Then("Mahasiswa dapat melihat nilai tugas (.*) di beranda Edlink")
	def verifyNilaiTugas(String nilai) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelNilaiTugasMhs'), nilai)
	}

	@When("Mahasiswa tap tugas di beranda Edlink")
	def tapMateriMhs() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LabelJudulTugas'))
	}
	
	@And("Mahasiswa dapat melihat batas & waktu pengumpulan di beranda Edlink")
	def verifyBatasWaktu() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelBatasPengumpulanTugas'), 0)
	}
	
	@And("Mahasiswa dapat melihat countdown pengumpulan di beranda Edlink")
	def verifyCountdown() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelCountdownTugas'), 0)
	}
}