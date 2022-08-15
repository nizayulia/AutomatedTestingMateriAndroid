package website
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.RenderingHints.Key

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
import io.cucumber.datatable.DataTable

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



class QuizBuilderLama {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("Dosen input judul quiz (.*) di builder lama")
	def inputJudul(String judul) {
		WebUI.sendKeys(findTestObject('Website/formQuizBuilderLama/JudulField'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/JudulField'), judul)
	}

	@When("Dosen tap bagikan quiz sekarang di builder lama")
	def tapBagikanSekarang() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/BagikanSekarangButton'))
	}

	@When("Dosen tap bagikan quiz nanti di builder lama")
	def tapBagikanNanti() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/BagikanNantiButton'))
		WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/TanggalWaktuBagikanField'), 0)
	}

	@And("Dosen tap tanggal bagikan quiz di builder lama")
	def tapTanggalBagikan() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/PickTanggalBagikan'))
	}

	@When("Dosen tap indikator penilaian quiz per soal di builder lama")
	def tapIndikatorSoal() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/IndikatorPenilaianperSoalRadio'))
	}

	@When("Dosen tap indikator penilaian quiz otomatis di builder lama")
	def tapIndikatorOtomatis() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/IndikatorPenilaianOtomatisRadio'))
	}

	@When("Dosen tap non aktif batas nilai quiz builder lama")
	def nonAktifBatasNilai() {
		if(WebUI.getText(findTestObject('Website/formQuizBuilderLama/LabelBatasNilai')).equalsIgnoreCase("Ya")) {
			WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/LabelBatasNilai'))
		}
	}

	@When("Dosen tap aktifkan batas nilai quiz builder lama")
	def aktifkanBatasNilai() {
		if(WebUI.getText(findTestObject('Website/formQuizBuilderLama/LabelBatasNilai')).equalsIgnoreCase("Tidak")) {
			WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/LabelBatasNilai'))
		}
	}

	@When("Dosen input Batas Nilai Minimum Lulus quiz (.*) di builder lama")
	def inputBatasNilaiMinimumLulus(String batas) {
		WebUI.waitForElementPresent(findTestObject('Website/formQuizBuilderLama/BatasNilaiMinimalField'), 0)
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/BatasNilaiMinimalField'), batas)
	}

	@When("Dosen input durasi quiz (.*) di builder lama")
	def inputDurasi(String durasi) {
		WebUI.sendKeys(findTestObject('Website/formQuizBuilderLama/DurasiPengerjaanField'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/DurasiPengerjaanField'), durasi)
	}

	@When("Dosen non aktif batas waktu di builder lama")
	def nonAktifBatasWaktu() {
		if(WebUI.getText(findTestObject('Website/formQuizBuilderLama/LabelBatasWaktu')).equalsIgnoreCase("Ya")) {
			WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/LabelBatasWaktu'))
		}
	}

	@When("Dosen tap laporan kepada peserta quiz (.*) di builder lama")
	def tapLaporan(String laporan) {
		if(!WebUI.getText(findTestObject('Website/formQuizBuilderLama/LabelTampilkanLaporan')).equalsIgnoreCase(laporan)) {
			WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/LabelTampilkanLaporan'))
		}
	}

	@When("Dosen tap edit pertanyaan pertama di builder lama")
	def editPertanyaanKe1() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/EditSoalKe1'))
	}

	@When("Dosen tap tambah pertanyaan quiz di builder lama")
	def tapTambahPertanyaan() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/TambahPertanyaanButton'))
	}

	@When("Dosen input pertanyaan quiz (.*) di builder lama")
	def inputPertanyaan(String pertanyaan) {
		WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/PertanyaanTextArea'), 0)
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/PertanyaanTextArea'), pertanyaan)
	}

	@When("Dosen input jawaban (.*) quiz (.*) di builder lama")
	def inputJawaban(String pilihan, String jawaban) {
		String FieldJawaban1 = "//*/label[contains(text(), 'Jawaban')]/../..//*//div[@class='control']["
		String FieldJawaban2 = "]//*/div[@class='textarea height-body-auto']/div"
		String FieldJawaban
		TestObject to = new TestObject("objectName")
		
		if(pilihan.equalsIgnoreCase("A")) {
			FieldJawaban = FieldJawaban1 + '1' + FieldJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, FieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else if (pilihan.equalsIgnoreCase("B")) {
			FieldJawaban = FieldJawaban1 + '2' + FieldJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, FieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else if (pilihan.equalsIgnoreCase("C")) {
			FieldJawaban = FieldJawaban1 + '3' + FieldJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, FieldJawaban)
			WebUI.setText(to, jawaban)
		}
		else
			println(pilihan)
	}
	
	@And("Dosen tap jawaban (.*) sebagai kunci jawaban di builder lama")
	def tapKunciJawaban(String pilihan) {
		String btnJawaban1 = "//*/a[@data-tooltip= 'Pilih "
		String btnJawaban2 = " sebagai Jawaban Benar']"
		String btnJawaban
		TestObject to = new TestObject("objectName")
		
		if(pilihan.equalsIgnoreCase("A")){
			btnJawaban = btnJawaban1 + 'A' + btnJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, btnJawaban)
			WebUI.enhancedClick(to)
		}
		else if (pilihan.equalsIgnoreCase("B")) {
			btnJawaban = btnJawaban1 + 'B' + btnJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, btnJawaban)
			WebUI.enhancedClick(to)
		}			
		else if (pilihan.equalsIgnoreCase("C")) {
			btnJawaban = btnJawaban1 + 'C' + btnJawaban2
			to.addProperty("xpath", ConditionType.EQUALS, btnJawaban)
			WebUI.enhancedClick(to)
		}		
		else
			println(pilihan)
	}

	@When("Dosen input bobot pertanyaan (.*) di builder lama")
	def inputBobotSoal(String bobot) {
		WebUI.verifyElementVisible(findTestObject('Website/formQuizBuilderLama/BobotSoalField'))
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/BobotSoalField'), bobot)
	}

	@When("Dosen tap Simpan pertanyaan quiz di builder lama")
	def tapSimpanPertanyaan() {
		WebUI.waitForElementClickable(findTestObject('Website/formQuizBuilderLama/SimpanPertanyaanButton'), 2)
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/SimpanPertanyaanButton'))
	}

	@When("Pertanyaan quiz (.*) berhasil disimpan di builder lama")
	def pertanyaanTersimpan(String pertanyaan) {
		WebUI.waitForElementVisible(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), 0)
		String[] words = pertanyaan.split("")

		if(words.length <= 200)
			WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), pertanyaan)

		else {
			pertanyaan = words[0]
			for (int i = 1; i < 200; i++)
				pertanyaan += words[i]
			pertanyaan = pertanyaan + "..."
			WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelPertanyaanTersimpan'), pertanyaan)
		}
	}

	@Then("Dosen melihat bobot pertanyaan ke (\\d+) (.*) di builder lama")
	def hasilBobotPertanyaan(int nomorSoal, String bobot) {
		if(nomorSoal == 1)
			WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelBobotSoal1'), bobot)
		else
			WebUI.verifyElementText(findTestObject('Website/formQuizBuilderLama/LabelBobotSoal2'), bobot)
	}

	@When("Dosen input catatan quiz (.*) di builder lama")
	def inputCatatan(String catatan) {
		WebUI.setText(findTestObject('Website/formQuizBuilderLama/CatatanField'), catatan)
	}

	@When("Dosen menyimpan quiz di builder lama")
	def tapSimpanQuiz() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/SimpanQuiz'))
	}

	@Given("Dosen tap coba buat quiz tampilan baru")
	def tapBuilderBaru() {
		WebUI.enhancedClick(findTestObject('Website/formQuizBuilderLama/ButtonBuilderBaru'))
	}
}