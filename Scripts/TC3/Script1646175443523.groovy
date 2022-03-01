import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Path
import java.nio.file.Paths

import com.kms.katalon.core.configuration.RunConfiguration
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
int numberOfAnchors = WebUI.findWebElements(findTestObject("anchors_Click"), 10).size()
for (int i = 1; i <= numberOfAnchors; i++) {
	TestObject anchor = findTestObject("anchor_Click_to_each_movie", ["i":i])
	WebUI.click(anchor)
	WebUI.delay(1)
	WebUI.back()
}

WebUI.closeBrowser()