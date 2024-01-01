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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Authentication/Login/menu_Login'))

WebUI.waitForElementVisible(findTestObject('Authentication/Login/modal_Login'), 2)

WebUI.setText(findTestObject('Authentication/Login/field_UsernameLogin'), GlobalVariable.username)

WebUI.setText(findTestObject('Authentication/Login/field_PasswordLogin'), GlobalVariable.password)

WebUI.click(findTestObject('Authentication/Login/btn_Login'))

WebUI.delay(2)

WebUI.click(findTestObject('Home/select_Categories', [('category') : categories]))

WebUI.click(findTestObject('Home/select_Item', [('item') : item_product]))

WebUI.waitForElementPresent(findTestObject('Home/btn_AddToCart'), 2)

WebUI.click(findTestObject('Home/btn_AddToCart'))

WebUI.waitForAlert(10)

String alertText = WebUI.getAlertText()

WebUI.verifyEqual(alertText, 'Product added.')

WebUI.acceptAlert()

WebUI.click(findTestObject('Cart/menu_Cart'))

WebUI.delay(2)

WebUI.click(findTestObject('Cart/btn_PlaceOrder'))

WebUI.waitForElementVisible(findTestObject('Cart/modal_Order'), 2)

WebUI.setText(findTestObject('Cart/Place Order/field_Name'), name)

WebUI.setText(findTestObject('Cart/Place Order/field_Country'), country)

WebUI.setText(findTestObject('Cart/Place Order/field_City'), city)

WebUI.setText(findTestObject('Cart/Place Order/field_CreditCard'), credit_card)

WebUI.setText(findTestObject('Cart/Place Order/field_Month'), month)

WebUI.setText(findTestObject('Cart/Place Order/field_Year'), year)

WebUI.click(findTestObject('Cart/Place Order/btn_Purchase'))

String expectedText = 'Thank you for your purchase!'

String actualText = WebUI.getText(findTestObject('Cart/Place Order/txt_ThankYouPurchase'))

WebUI.waitForElementPresent(findTestObject('Cart/Place Order/txt_ThankYouPurchase'), 2)

WebUI.verifyElementPresent(findTestObject('Cart/Place Order/txt_ThankYouPurchase'), 2)

WebUI.verifyEqual(actualText, expectedText)

WebUI.closeBrowser()

