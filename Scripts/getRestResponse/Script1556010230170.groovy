import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import groovy.json.JsonSlurper as JsonSlurper

import java.net.HttpURLConnection as HttpUrlConnection

response = WS.sendRequestAndVerify(findTestObject('Rest Objects/get'))

JsonSlurper slurper = new JsonSlurper()

Map parsedJson = slurper.parseText(response.getResponseBodyContent())

GlobalVariable.URL = parsedJson.get('_links').get('scanRedirect').get('href')

println(GlobalVariable.URL)


HttpUrlConnection getRequest = (HttpUrlConnection) new URL('https://httpstat.us/301').openConnection();
getRequest.setInstanceFollowRedirects(false)
def getRC = getRequest.getResponseCode();

println(getRC)
