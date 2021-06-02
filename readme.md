# VoiceXML Utilities

For IVR programmers, testing IVR applications.

## Features

- Simple VXML Script generator, for calling (or receiving calls) and testing IVR applications.
- VXML Browser and Validator, so you can test a deployed IVR application

## Authors

- [@ericp56](https://www.github.com/ericp56)


## Demo

### AOD Browser Integration Test

I'm setting up a continuous integration suite for monitoring an AAOD app repo, and building + testing it for every code push.  The following is an example of how to test your AOD app session without a real phone call.  

``` Java
AodBrowser browser = new AodBrowser();

//Fetch a new session of the AOD app
HttpResponse fetchDocument = browser.initApp("localhost", "8080", "Weatherline2", "");

VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());

//Start the session with an ANI and DNIS
validator = browser.start("919411234", "1234")
//Validate that the initial page has certain text and elements
.xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
.xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
.xpVerifyElementCount(VXML_AUDIO, 1);

//Choose option 1 from the initial page's menu options...
validator = browser.chooseMenuOption(validator, 1, "1", "1", "dtmf")
//...and validate that the next page has certain text and elements
.xpElementContainsText(VXML_AUDIO, "Please enter your zip code.")
.xpElementAttrContainsText(VXML_AUDIO, SRC, "EnterZip.wav")
.xpVerifyElementCount(VXML_AUDIO, 2);

// etc...
validator = browser.choosePromptCollect(validator, "12345", "12345", "dtmf")
.xpElementContainsText(VXML_AUDIO, "Your forecast")
.xpElementAttrContainsText(VXML_AUDIO, SRC, "Forecast2.wav")
.xpVerifyElementCount(VXML_AUDIO, 3);


validator = browser.getDefaultNext(validator)
.xpElementContainsText(VXML_AUDIO, "To test the rest API, press 1.")
.xpElementAttrContainsText(VXML_AUDIO, SRC, "MainMenu.wav")
.xpVerifyElementCount(VXML_AUDIO, 1);

//Simulate a browser error, and verify that the app has gracefully ended
validator = browser.error(validator)
.xpVerifyElementCount("vxml:form[@id='end']", 1);
```

- See AodBrowserTest.java for testing a deployed AOD application.


### Generate an IVR unit test in static VoiceXML

I have a customer that doesn't have any tools like Hammer or Cyara.  Using this tool, I can generate vxml scripts that will validate functionality of an IVR.  I can set it up to work for inbound and outbound calls.  In the end, I just search the logs for "VxmlTestStatus" and review the results.

Take a simple spreadsheet like this:

|name| next| listenForVoice| respondWithDtmf| respondWithVoice| recoTimeout| completeTimeout|
---|---|---|---|---|---|---
|greeting| lang| Hello {*}, thank you for calling.| | | 5000ms| 1500ms|
|lang| mainmenu| Press 1 for English 2 for Spanish| | one| 5000ms| 1500ms|
|mainmenu| | For billing, press 1.  For customer service, press 2.| 05251900| | 5000ms| 1500ms|

And turn it into a static VoiceXML document with content like this:

``` xml
<vxml xml:lang="en-US" version="2.1" xmlns="http://www.w3.org/2001/vxml">
    <form id="genericTest">
        <field name="greeting">
            <property name="timeout" value="5000ms"/>
            <property name="completetimeout" value="1500ms"/>
            <grammar xml:lang="en-US" mode="voice" tag-format="semantics/1.0" version="1.0" root="ROOT0">
                <rule scope="private" id="ROOT0">
                    <item>Hello  </item>
                    <ruleref special="GARBAGE"/>
                    <item> thank you for calling </item>
                </rule>
            </grammar>
            <filled>
                <goto nextitem="lang"/>
            </filled>
            <catch event="noinput nomatch error" count="1">
                <goto nextitem="AllDoneFailure"/>
            </catch>
        </field>
        <field name="lang">
            <property name="timeout" value="5000ms"/>
            <property name="completetimeout" value="1500ms"/>
            <grammar xml:lang="en-US" mode="voice" tag-format="semantics/1.0" version="1.0" root="ROOT1">
                <rule scope="private" id="ROOT1">
                    <item>Press 1 for English  2 for Spanish</item>
                </rule>
            </grammar>
            <filled>
                <prompt>one</prompt>
                <goto nextitem="mainmenu"/>
            </filled>
            <catch event="noinput nomatch error" count="1">
                <goto nextitem="AllDoneFailure"/>
            </catch>
        </field>
        <field name="mainmenu">
            <property name="timeout" value="5000ms"/>
            <property name="completetimeout" value="1500ms"/>
            <grammar xml:lang="en-US" mode="voice" tag-format="semantics/1.0" version="1.0" root="ROOT2">
                <rule scope="private" id="ROOT2">
                    <item>For billing  press 1   For customer service  press 2 </item>
                </rule>
            </grammar>
            <filled>
                <prompt bargein="false">
                    <audio src="0.wav"/>
                    <audio src="5.wav"/>
                    <audio src="2.wav"/>
                    <audio src="5.wav"/>
                    <audio src="1.wav"/>
                    <audio src="9.wav"/>
                    <audio src="0.wav"/>
                </prompt>
                <goto nextitem="AllDoneSuccess"/>
            </filled>
            <catch event="noinput nomatch error" count="1">
                <goto nextitem="AllDoneFailure"/>
            </catch>
        </field>
        <block name="AllDoneSuccess">
            <log label="DEBUG" expr="'VxmlTestStatus=Complete;Form=genericTest;Result=SUCCESS'"/>
            <exit/>
        </block>
        <block name="AllDoneFailure">
            <log label="DEBUG" expr="'VxmlTestStatus=Complete;Form=genericTest;Result=FAIL'"/>
            <exit/>
        </block>
    </form>
</vxml>
```
- See VxmlTestGeneratorTest.java for generating VoiceXML.
- Use ProcessCsvToVxml.class to transform a test spreadsheet into a VoiceXML script.

## Contact 

For support and feedback, email ericp@nextivr.com



