import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path html = projectDir.resolve("target.html")
String targetURL = html.toUri().toURL().toExternalForm()

TestObject hp  = byXPath("(//a[text()='Click'])[1]")
TestObject w07 = byXPath("(//a[text()='Click'])[2]")   // Mind the pair of paren ( ) before [2] 
TestObject sw  = byXPath("(//a[text()='Click'])[3]")

TestObject w07_css = byCssSelector("Russ knows everything")

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(targetURL)
WebUI.delay(1)

// I want to see the 2nd one (007)
WebUI.click(w07)
WebUI.delay(1)
WebUI.back()

// I also want to see the ultimate movie!
WebUI.click(sw)
WebUI.delay(1)
WebUI.back()

WebUI.closeBrowser()


/**
 * make a TestObject with XPath
 */
TestObject byXPath(String expr) {
	TestObject tObj = new TestObject(expr)
	tObj.addProperty("xpath", ConditionType.EQUALS, expr)
	return tObj
}

TestObject byCssSelector(String selector) {
	TestObject tObj = new TestObject(selector)
	tObj.addProperty("css", ConditionType.EQUALS, selector)
	return tObj
}