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



class DetailSesi {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Quiz (.*) berhasil disimpan di sesi kelas")
	def judulQuizTersimpan(String judul) {
		//		WebUI.waitForElementPresent(findTestObject('DetailSesi/JudulQuiz'), 0)
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/JudulQuiz'), judul)
	}
	
	@Then("Materi (.*) berhasil tersimpan di sesi kelas")
	def materiTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/LabelJudulMateri'), judul)
	}
	
	@Then("Tugas (.*) berhasil tersimpan di sesi kelas")
	def tugasTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/LabelJudulTugas'), judul)
	}

	@And("Quiz (.*) Belum Dibagikan di sesi kelas")
	def labelBagikan (String judul) {
		String label = "Belum Dibagikan"
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/LabelBagikan'), label)
	}

	@And("Dosen tap judul quiz (.*) di detail sesi")
	def tapJudulQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/JudulQuiz'), judul)
		WebUI.enhancedClick(findTestObject('Website/DetailSesi/JudulQuiz'))
	}

	@And("Dosen tap button buat bahan di detail session")
	def tapBuatBahan() {
		WebUI.enhancedClick(findTestObject('Website/DetailSesi/LinkBuatBahan'))
	}

	@And("Dosen melihat pop up pilihan buat bahan")
	def popUpBuatBahan() {
		WebUI.verifyElementPresent(findTestObject('Website/DetailSesi/PopUpBuatBahan'), 0)
	}

	@And("Dosen tap buat bahan (.*) di pop up buat bahan")
	def buatBahanBelajar(String belajar) {
		if(belajar.equalsIgnoreCase("materi")) {
			WebUI.enhancedClick(findTestObject('Website/DetailSesi/LabelBuatBahanMateri'))
		} else if(belajar.equalsIgnoreCase("quiz")) {
			WebUI.enhancedClick(findTestObject('Website/DetailSesi/LabelBuatBahanQuiz'))
		} else if(belajar.equalsIgnoreCase("tugas")) {
			WebUI.enhancedClick(findTestObject('Website/DetailSesi/LabelBuatBahanTugas'))
		} else if(belajar.equalsIgnoreCase("video conference")) {
			WebUI.enhancedClick(findTestObject('Website/DetailSesi/LabelBuatBahanConf'))
		}
	}

	@And("Dosen tap button Tambahkan di pop up buat bahan")
	def tapBtnTambahkan() {
		WebUI.enhancedClick(findTestObject('Website/DetailSesi/ButtonTambahkan'))
	}

	@And("Dosen melihat quiz (.*) pada detail sesi")
	def DosenLihatQuiz(String judul) {
		WebUI.verifyElementVisible(findTestObject('Website/DetailSesi/JudulQuiz'))
	}

	@And("Mahasiswa melihat quiz (.*) pada detail sesi")
	def lihatQuiz(String judul) {
		WebUI.verifyElementVisible(findTestObject('Website/DetailSesi/JudulQuiz'))
	}

	@And("Mahasiswa tidak melihat quiz (.*) pada detail sesi")
	def tidakLihatQuiz() {
		WebUI.verifyElementNotVisible(findTestObject('Website/DetailSesi/JudulQuiz'), FailureHandling.OPTIONAL)
	}

	@And("Mahasiswa tap judul quiz (.*) di detail sesi")
	def mhsTapJudulQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DetailSesi/JudulQuiz'), judul)
		WebUI.enhancedClick(findTestObject('Website/DetailSesi/JudulQuiz'))
	}
}