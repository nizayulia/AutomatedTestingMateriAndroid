import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('D:\\# sevima\\automation\\KuisWebsite\\AndroidApp\\app-staging.apk', true)

Mobile.waitForElementPresent(findTestObject('Android/PrivacyPolicy/buttonAgree'), 0)
Mobile.tap(findTestObject('Android/PrivacyPolicy/buttonAgree'), 0)

Mobile.waitForElementPresent(findTestObject('Android/LoginPage/buttonLoginBySiakad'), 0)
Mobile.tap(findTestObject('Android/LoginPage/buttonLoginBySiakad'), 0)

Mobile.waitForElementPresent(findTestObject('Android/LoginSiakadPage/fieldUniversity'), 0)
Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUniversity'), "Universitas Lancang Kunin", 0)
Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUniversity'), "Universitas Lancang Kuning", 0)
Mobile.tap(findTestObject('Android/LoginSiakadPage/listLancangKuning'), 0)

	Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldUserId'), '1008078602', 0)
	Mobile.setText(findTestObject('Android/LoginSiakadPage/fieldPassword'), '123456', 0)

Mobile.tap(findTestObject('Android/LoginSiakadPage/buttonLogin'), 0)

if(Mobile.verifyElementNotExist(findTestObject('Android/Beranda/textHome'), 0)) {
			Mobile.waitForElementPresent(findTestObject('Android/Beranda/textCampusNews'), 0)
			Mobile.tap(findTestObject('Android/Beranda/buttonCloseCampusNews'), 0)
		}
else
	Mobile.waitForElementPresent(findTestObject('Android/Beranda/textHome'), 0)
//Mobile.delay(4)	
//Mobile.
Mobile.waitForElementPresent(findTestObject('null'), 0)
Mobile.tap(findTestObject('Android/MainMenu/buttonClasslama'), 0)
