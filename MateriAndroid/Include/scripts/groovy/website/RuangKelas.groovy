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



class RuangKelas {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@When("Dosen tap Akademik di Ruang Kelas")
	def tapTabel() {
		WebUI.enhancedClick(findTestObject('Website/RuangKelas/AkademikMenu'))
	}

	@And("Dosen tap periode pada Akademik")
	def tapPeriode() {
		WebUI.click(findTestObject('Website/RuangKelas/Periode'))
	}

	@And("Dosen tap periode (.*) pada periode")
	def pilihPeride(String periode) {
		WebUI.click(findTestObject('Website/RuangKelas/PilihPeriode'))
	}

	@And("Dosen tap Terapkan pada Akademik")
	def tapTerapkan() {
		WebUI.click(findTestObject('Website/RuangKelas/TerapkanButton'))
	}

	@Then("Dosen melihat kelas pada Ruang Kelas")
	def kelasRuangKelas() {
		WebUI.verifyElementVisible(findTestObject('Website/RuangKelas/TabelDaftarKelas'))
	}

	@When("Dosen tap kelas di Ruang Kelas")
	def tapKelas() {
		WebUI.verifyElementPresent(findTestObject('Website/RuangKelas/KelasBahasaIndonesia'), 0)
		WebUI.enhancedClick(findTestObject('Website/RuangKelas/KelasBahasaIndonesia'))
	}

	@Then("Dosen masuk ke kelas Edlink")
	def masukKelas() {
		WebUI.verifyElementVisible(findTestObject('Website/DiskusiKelas/JudulKelas'))
	}
	
//	Mahasiswa
	@When("Mahasiswa tap Akademik di Ruang Kelas")
	def MhsTapTabel() {
		WebUI.enhancedClick(findTestObject('Website/RuangKelas/AkademikMenu'))
	}

	@And("Mahasiswa tap periode pada Akademik")
	def MhsTapPeriode() {
		WebUI.click(findTestObject('Website/RuangKelas/Periode'))
	}

	@And("Mahasiswa tap periode (.*) pada periode")
	def MhsPilihPeride(String periode) {
		WebUI.click(findTestObject('Website/RuangKelas/PilihPeriode'))
	}

	@And("Mahasiswa tap Terapkan pada Akademik")
	def MhsTapTerapkan() {
		WebUI.click(findTestObject('Website/RuangKelas/TerapkanButton'))
	}

	@Then("Mahasiswa melihat kelas pada Ruang Kelas")
	def MhsKelasRuangKelas() {
		WebUI.verifyElementVisible(findTestObject('Website/RuangKelas/TabelDaftarKelas'))
	}

	@When("Mahasiswa tap kelas di Ruang Kelas")
	def MhsTapKelas() {
		WebUI.enhancedClick(findTestObject('Website/RuangKelas/KelasBahasaIndonesia'))
	}

	@Then("Mahasiswa masuk ke kelas Edlink")
	def MhsMasukKelas() {
		WebUI.verifyElementVisible(findTestObject('Website/DiskusiKelas/JudulKelas'))
	}
}