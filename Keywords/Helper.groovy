import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable as GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

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
import javax.swing.JOptionPane as JOptionPane
import javax.swing.JFrame as JFrame
import java.awt.Color
import javax.swing.JPanel as JPanel
import javax.swing.UIManager as UIManager
import java.awt.Dimension as Dimention

public class Helper {
	def static navigateToLoginPage() {
		WebUI.openBrowser('')

		WebUI.navigateToUrl(GlobalVariable.URL)

		WebUI.click(findTestObject('Squarespace Home Page/a_Log In'))
	}

	def static enterCredentials(String login, String password) {
		WebUI.setText(findTestObject('Squarespace LoginPage/input_login'), login)

		WebUI.setText(findTestObject('Squarespace LoginPage/input_password'), password)

		WebUI.click(findTestObject('Squarespace LoginPage/span_Log In'))
	}

	def static enterPrompt() {
		//InputDialogInFrame frame = new InputDialogInFrame();
		//String m = JOptionPane.showInputDialog(frame, "Anyone there?");
		JFrame f = new JFrame("user input")
		//f.getContentPane().setBackground(Color.RED)
		//f.setSize(300, 200)
		//	f.requestFocus()

		String input = JOptionPane.showInputDialog(f, "Enter the website you would like to visit!", GlobalVariable.username)
		return input == null ? "": input
	}

	def static enterPrompt2(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setSize(new Dimention(250, 32));
		panel.setLayout(null);

		//		JLabel label = new JLabel("It's your choice! :)");
		//		label.setForeground(new Color(255, 255, 0));
		//		label.setHorizontalAlignment(SwingConstants.CENTER);
		//		label.setFont(new Font("Arial", Font.BOLD, 11));
		//		label.setBounds(0, 0, 250, 32);
		//		panel.add(label);
		//
		UIManager.put("OptionPane.minimumSize",new Dimention(270, 120));
		//
		Object[] options = [2, "No", 5.6, true]
		Object l = JOptionPane.showInputDialog(null, panel,				"Mix & Match", JOptionPane.PLAIN_MESSAGE, null, options, options[3])
		//
		return l
	}
}
