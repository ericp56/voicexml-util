package com.nextivr.vxml.validator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class VxmlValidatorTest 
    extends TestCase
{
    public VxmlValidatorTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( VxmlValidatorTest.class );
    }

    public void testVxmlLookups() throws Exception
    {
        VxmlValidator vt = new VxmlValidator("<vxml xml:lang=\"en-US\" version=\"2.1\" xmlns=\"http://www.w3.org/2001/vxml\">;        <form id=\"genericTest\">            <field name=\"greeting\">                <property name=\"timeout\" value=\"5000ms\"/>                <property name=\"completetimeout\" value=\"1500ms\"/>                <grammar xml:lang=\"en-US\" mode=\"voice\" tag-format=\"semantics/1.0\" version=\"1.0\" root=\"ROOT0\">                    <rule scope=\"private\" id=\"ROOT0\">                        <item>Hello  </item>                        <ruleref special=\"GARBAGE\"/>                        <item> thank you for calling </item>                    </rule>                </grammar>                <filled>                    <goto nextitem=\"lang\"/>                </filled>                <catch event=\"noinput nomatch error\" count=\"1\">                    <goto nextitem=\"AllDoneFailure\"/>                </catch>            </field>            <field name=\"lang\">                <property name=\"timeout\" value=\"5000ms\"/>                <property name=\"completetimeout\" value=\"1500ms\"/>                <grammar xml:lang=\"en-US\" mode=\"voice\" tag-format=\"semantics/1.0\" version=\"1.0\" root=\"ROOT1\">                    <rule scope=\"private\" id=\"ROOT1\">                        <item>Press 1 for English  2 for Spanish</item>                    </rule>                </grammar>                <filled>                    <prompt>one</prompt>                    <goto nextitem=\"mainmenu\"/>                </filled>                <catch event=\"noinput nomatch error\" count=\"1\">                    <goto nextitem=\"AllDoneFailure\"/>                </catch>            </field>            <field name=\"mainmenu\">                <property name=\"timeout\" value=\"5000ms\"/>                <property name=\"completetimeout\" value=\"1500ms\"/>                <grammar xml:lang=\"en-US\" mode=\"voice\" tag-format=\"semantics/1.0\" version=\"1.0\" root=\"ROOT2\">                    <rule scope=\"private\" id=\"ROOT2\">                        <item>For billing  press 1   For customer service  press 2 </item>                    </rule>                </grammar>                <filled>                    <prompt bargein=\"false\">                        <audio src=\"0.wav\"/> balloon <audio src=\"5.wav\">fiver</audio>                        <audio src=\"2.wav\"/>                        <audio src=\"5.wav\"/>                        <audio src=\"1.wav\"/>                        <audio src=\"9.wav\"/>                        <audio src=\"0.wav\"/>                        <audio src=\"0.wav\"/>                    </prompt>                    <goto nextitem=\"AllDoneSuccess\"/>                </filled>                <catch event=\"noinput nomatch error\" count=\"1\">                    <goto nextitem=\"AllDoneFailure\"/>                </catch>            </field>            <block name=\"AllDoneSuccess\">                <log label=\"DEBUG\" expr=\"'VxmlTestStatus=Complete;Form=genericTest;Result=SUCCESS'\"/>                <exit/>            </block>            <block name=\"AllDoneFailure\">                <log label=\"DEBUG\" expr=\"'VxmlTestStatus=Complete;Form=genericTest;Result=FAIL'\"/>                <exit/>            </block>        </form>    </vxml>");
        vt
        .xpElementContainsText("vxml", "one")
        .xpElementContainsText("prompt", "balloon")
        .xpElementAttrContainsText("form", "id", "eric");
    }
}
