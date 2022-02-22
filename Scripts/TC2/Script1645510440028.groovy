import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path html = projectDir.resolve("target.html")
String targetURL = html.toUri().toURL().toExternalForm()

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(targetURL)
WebUI.delay(1)

// I want to click all links to the movi
int numberOfAnchors = WebUI.findWebElements(byXPath("//a[text()='Click']"), 10).size()
for (int i = 1; i <= numberOfAnchors; i++) {
	TestObject anchor = byXPath("(//a[text()='Click'])[${i}]")
	WebUI.click(anchor)
	WebUI.delay(1)
	WebUI.back()
}

WebUI.closeBrowser()


/**
 * make a TestObject with XPath
 */
TestObject byXPath(String expr) {
	TestObject tObj = new TestObject(expr)
	tObj.addProperty("xpath", ConditionType.EQUALS, expr)
	return tObj
}

