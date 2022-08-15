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



class BuatMateri {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Dosen tap icon materi di beranda Edlink")
	def quizDashboard() {
		WebUI.waitForElementVisible(findTestObject('Website/dashboard/ImageMateri'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ImageMateri'))
	}

	@Then("Dosen melihat pop up pilih kelas & sesi")
	def verifyPopUp() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Pilih Kelas & Sesi")
	}

	@Then("Dosen melihat pop up pilih sesi")
	def verifyPopUpSesi() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Pilih Sesi")
	}

	@When("Dosen tap langkah berikutnya di pop up pilih kelas & sesi")
	def tapBerikutnya() {
		WebUI.waitForElementPresent(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaSesi'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaSesi'))
	}

	@When("Dosen tap langkah berikutnya di pop up pilih sesi")
	def tapBerikutnyaSesi() {
		WebUI.waitForElementPresent(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaSesi'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaSesi'))
	}

	@Then("Dosen melihat form atur materi")
	def verifyAturMateri() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Atur Materi")
	}

	@Given("Dosen input judul materi (.*) di pop up atur materi")
	def inputJudul(String judul) {
		WebUI.setText(findTestObject('Website/dashboard/ZBuatMateri/FieldJudul'), judul)
	}

	@When("Dosen tap tambah berkas di pop up atur materi")
	def tapTambahBerkas() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonTambahBerkas'))
	}

	@Then("Dosen melihat media (.*) telah terpilih di pop up atur materi")
	def mediaTerpilih(String format) {
		if(format.equalsIgnoreCase("doc"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasDoc'))
		else if(format.equalsIgnoreCase("jpg"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasJpg'))
		else if(format.equalsIgnoreCase("mp4"))
			WebUI.verifyElementVisible(findTestObject('Website/dashboard/ZBuatMateri/LabelBerkasMp4'))
	}

	@Given("Dosen tap langkah berikutnya di pop up atur materi")
	def BerikutnyaMateri() {
		WebUI.waitForElementPresent(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaAturMateri'), 0)
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBerikutnyaAturMateri'))
	}

	@Then("Dosen melihat pop up bagikan materi")
	def verifyBagikanMateri() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), 0)
		WebUI.verifyElementText(findTestObject('Website/dashboard/ZBuatMateri/LabelPopUpAktif'), "Bagikan Materi")
	}

	@Given("Dosen input catatan (.*) di pop up bagikan materi")
	def inputCatatan(String catatan) {
		WebUI.setText(findTestObject('Website/dashboard/ZBuatMateri/FieldCatatan'), catatan)
	}

	@When("Dosen tap bagikan materi sekarang di pop up bagikan materi")
	def tapBagikanSekarang() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonBagikanSekarang'))
	}

	@When("Dosen tap bagikan di pop up bagikan materi")
	def tapSubmitBagikan() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/ZBuatMateri/ButtonSubmitBagikan'))
	}

	@Then("Dosen masuk halaman form buat materi")
	def formMateri() {
		WebUI.verifyElementPresent(findTestObject('Website/FormMateri/FormMateri'), 0)
	}

	@Given("Dosen input judul materi (.*) di form buat materi")
	def inputJudulForm(String judul) {
		WebUI.sendKeys(findTestObject('Website/FormMateri/FieldJudul'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/FormMateri/FieldJudul'), judul)
	}

	@When("Dosen tap bagikan materi sekarang di form buat materi")
	def tapBagikanSekarangForm() {
		WebUI.enhancedClick(findTestObject('Website/FormMateri/ButtonBagikanSekarang'))
	}

	@And("Dosen tap tambah dokumen di form buat materi")
	def tapTambahDokumen() {
		WebUI.enhancedClick(findTestObject('Website/FormMateri/LinkTambahDokumen'))
	}

	@And("Dosen tap tambah gambar di form buat materi")
	def tapTambahGambar() {
		WebUI.enhancedClick(findTestObject('Website/FormMateri/LinkTambahGambar'))
	}

	@And("Dosen tap tambah video di form buat materi")
	def tapTambahVideo() {
		WebUI.enhancedClick(findTestObject('Website/FormMateri/LinkTambahVideo'))
	}

	@Then("Dosen melihat media doc telah terpilih di form buat materi")
	def verifyDocForm() {
		WebUI.verifyElementPresent(findTestObject('Website/FormMateri/LabelMediaDoc'), 0)
	}

	@Then("Dosen melihat media jpg telah terpilih di form buat materi")
	def verifyJpgForm() {
		WebUI.verifyElementPresent(findTestObject('Website/FormMateri/LabelMediaJpg'), 0)
	}

	@Then("Dosen melihat media mp4 telah terpilih di form buat materi")
	def verifyMp4Form() {
		WebUI.verifyElementPresent(findTestObject('Website/FormMateri/LabelMediaMp4'), 0)
	}

	@When("Dosen input catatan (.*) di form buat materi")
	def inputCatatanForm(String catatan) {
		WebUI.setText(findTestObject('Website/FormMateri/FieldCatatan'), catatan)
	}

	@When("Dosen tap simpan di form buat materi")
	def tapSimpan() {
		WebUI.enhancedClick(findTestObject('Website/FormMateri/ButtonSimpan'))
	}

	@Then("Materi (.*) berhasil tersimpan di sistem dashboard")
	def materiTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulMateri'), judul)
	}

	@And("Dokumen materi format gambar berhasil tersimpan di sistem dashboard")
	def gambarTersimpan() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelGambarMateri'), 0)
	}

	@And("Dokumen materi format video berhasil tersimpan di sistem dashboard")
	def videoTersimpan() {
		WebUI.verifyElementPresent(findTestObject('Website/dashboard/LabelVideoMateri'), 0)
	}

	@Given("Dosen tap materi di dashboard")
	def tapMateri() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LabelJudulMateri'))
	}

	//	Mahasiswa
	@Given("Mahasiswa dapat melihat materi (.*) di beranda Edlink")
	def verifyMateriMhs(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulMateri'), judul)
	}

	@When("Mahasiswa tap materi di beranda Edlink")
	def tapMateriMhs() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LabelJudulMateri'))
	}
}