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



class DiskusiKelas {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("Quiz (.*) berhasil disimpan di kelas")
	def quizTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'), judul)
	}

	@Then("Materi (.*) berhasil tersimpan di kelas")
	def materiTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DiskusiKelas/LabelJudulMateri'), judul)
	}
	
	@Then("Tugas (.*) berhasil tersimpan di kelas")
	def tugasTersimpan(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DiskusiKelas/LabelJudulTugas'), judul)
	}

	@Given("Dosen melihat quiz (.*) pada diskusi kelas")
	def quizDiskusi(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'), judul)
	}

	@And("Quiz (.*) tidak ditemukan di kelas")
	def judulTidakDitemukan (String judul) {
		WebUI.verifyElementNotVisible(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'), FailureHandling.OPTIONAL)
	}

	@Given("Dosen tap icon quiz di diskusi kelas")
	def iconQuiz() {
		WebUI.enhancedClick(findTestObject('Website/DiskusiKelas/ImageQuiz'))
	}

	@When("Dosen tap icon materi di diskusi kelas")
	def iconMateri() {
		WebUI.enhancedClick(findTestObject('Website/DiskusiKelas/ImageMateri'))
	}
	
	@When("Dosen tap icon tugas di diskusi kelas")
	def iconTugas() {
		WebUI.enhancedClick(findTestObject('Website/DiskusiKelas/ImageTugas'))
	}

	@When("Dosen tap judul quiz (.*) di diskusi kelas")
	def tapJudulQuiz(String judul) {
		WebUI.enhancedClick(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'))
	}

	//	Mahasiswa
	@When("Mahasiswa dapat melihat judul quiz (.*) di diskusi kelas")
	def lihatQuiz(String judul) {
		WebUI.verifyElementText(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'), judul)
	}
	
	@When("Mahasiswa dapat melihat materi (.*) di diskusi kelas")
	def liatMateri(String judul) {
		WebUI.verifyElementText(findTestObject('Website/dashboard/LabelJudulMateri'), judul)
	}

	@When("Mahasiswa tap judul quiz (.*) di diskusi kelas")
	def MhsJudulQuiz(String judul) {
		WebUI.enhancedClick(findTestObject('Website/DiskusiKelas/LabelJudulQuiz'))
	}
	
	@When("Mahasiswa tap materi di diskusi kelas")
	def MhsJudulMateri() {
		WebUI.enhancedClick(findTestObject('Website/dashboard/LabelJudulMateri'))
	}

	@And("Mahasiswa melihat nilai quiz tersimpam di sistem diskusi kelas")
	def MhsLihatNilaiQuiz() {
		WebUI.verifyElementPresent(findTestObject('Website/DiskusiKelas/NilaiQuiz'), 0)
	}
}