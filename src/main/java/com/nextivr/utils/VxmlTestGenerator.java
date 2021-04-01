package com.nextivr.utils;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.nextivr.model.Step;
import com.nextivr.model.Test;
import com.nextivr.voicexml21.Audio;
import com.nextivr.voicexml21.Block;
import com.nextivr.voicexml21.Catch;
import com.nextivr.voicexml21.Field;
import com.nextivr.voicexml21.Filled;
import com.nextivr.voicexml21.Form;
import com.nextivr.voicexml21.Goto;
import com.nextivr.voicexml21.Grammar;
import com.nextivr.voicexml21.Item;
import com.nextivr.voicexml21.Log;
import com.nextivr.voicexml21.ModeDatatype;
import com.nextivr.voicexml21.ObjectFactory;
import com.nextivr.voicexml21.Property;
import com.nextivr.voicexml21.Rule;
import com.nextivr.voicexml21.Ruleref;
import com.nextivr.voicexml21.ScopeDatatype;
import com.nextivr.voicexml21.SpecialDatatype;
import com.nextivr.voicexml21.Vxml;
import com.nextivr.voicexml21.VxmlSpeak;

/**
 * With this utility, you can generate a vxml testing document.
 */
public class VxmlTestGenerator {

    /**
     * Generate the vxml document using the list of steps.
     * 
     * @param test A Test object which contains the test steps, as well as other
     *             properties.
     * @return
     */
    public Vxml generateVxml(Test test) {
        ObjectFactory of = new ObjectFactory();
        Vxml vxml = of.createVxml();
        vxml.setLang(test.getLanguage());
        vxml.setVersion("2.1");
        Form f = of.createForm();
        f.setId(test.getTestName());
        List<Object> formItems = f.getCatchOrHelpOrNoinput();
        List<Step> listItems = test.getSteps();
        for (int i = 0; i < listItems.size(); i++) {
            Step listItem = listItems.get(i);
            Field field = of.createField();
            field.setName(listItem.getName());
            if (null != listItem.getRecoTimeout() && listItem.getRecoTimeout().length() != 0) {
                Property prop = of.createProperty();
                prop.setName("timeout");
                prop.setValue(listItem.getRecoTimeout());
                field.getContent().add(prop);
            }
            if (null != listItem.getCompleteTimeout() && listItem.getCompleteTimeout().length() != 0) {
                Property prop = of.createProperty();
                prop.setName("completetimeout");
                prop.setValue(listItem.getCompleteTimeout());
                field.getContent().add(prop);
            }
            if (null != listItem.getListenForVoice() && listItem.getListenForVoice().length() != 0) {
                Grammar gr = of.createGrammar();
                gr.setLang("en-US");
                gr.setMode(ModeDatatype.VOICE);
                gr.setVersion("1.0");
                gr.setTagFormat("semantics/1.0");
                Rule rule = of.createRule();
                rule.setId("ROOT" + i);
                rule.setScope(ScopeDatatype.PRIVATE);
                List<Serializable> ruleList = rule.getContent();
                String listenFor[] = listItem.getListenForVoice().replaceAll("[^a-zA-Z 0-9{}:*]", " ").split("\\{|\\}");
                for (int k = 0; k < listenFor.length; k++) {
                    String listenForSegment = listenFor[k];
                    if (listenForSegment.equals("*")) {
                        Ruleref ruleRef = of.createRuleref();
                        ruleRef.setSpecial(SpecialDatatype.GARBAGE);
                        JAXBElement<Ruleref> ruleRefElement = new JAXBElement<>(
                                new QName("http://www.w3.org/2001/vxml", "ruleref"), Ruleref.class, null, ruleRef);
                        ruleList.add(ruleRefElement);
                    } else {
                        Item speechItem = of.createItem();
                        speechItem.getContent().add(listenForSegment);
                        JAXBElement<Item> speechItemElement = new JAXBElement<>(
                                new QName("http://www.w3.org/2001/vxml", "item"), Item.class, null, speechItem);
                        ruleList.add(speechItemElement);
                    }
                }

                gr.getRule().add(rule);
                gr.setRoot(rule);
                field.getContent().add(gr);
            }

            Filled filled = of.createFilled();

            if (null != listItem.getRespondWithVoice() && listItem.getRespondWithVoice().length() != 0) {
                VxmlSpeak speak = of.createVxmlSpeak();
                speak.getContent().add(listItem.getRespondWithVoice());
                filled.getContent().add(of.createPrompt(speak));
            }

            if (null != listItem.getRespondWithDtmf() && listItem.getRespondWithDtmf().trim().length() != 0) {
                VxmlSpeak speak = of.createVxmlSpeak();
                speak.getBargein().add("false");
                String dtmfs[] = listItem.getRespondWithDtmf().trim().split("");
                for (int j = 0; j < dtmfs.length; j++) {
                    Audio audio = of.createAudio();
                    audio.setSrc(dtmfs[j] + ".wav");
                    JAXBElement<Audio> element = new JAXBElement<>(new QName("http://www.w3.org/2001/vxml", "audio"),
                            Audio.class, null, audio);
                    speak.getContent().add(element);
                }

                filled.getContent().add(of.createPrompt(speak));
            }

            Goto gt = of.createGoto();
            gt.setNextitem(listItem.getNext().length() == 0 ? "AllDoneSuccess" : listItem.getNext());
            filled.getContent().add(gt);
            field.getContent().add(filled);

            Catch errors = of.createCatch();
            errors.setCount(BigInteger.valueOf(1L));
            errors.getEvent().add("noinput");
            errors.getEvent().add("nomatch");
            errors.getEvent().add("error");
            Goto gtError = of.createGoto();
            gtError.setNextitem("AllDoneFailure");
            errors.getContent().add(gtError);
            field.getContent().add(errors);

            formItems.add(field);
        }

        Block wrapupSuccess = of.createBlock();
        wrapupSuccess.setName("AllDoneSuccess");
        Log successLog = of.createLog();
        successLog.setLabel("DEBUG");
        successLog.setExpr("'VxmlTestStatus=Complete;Form=" + test.getTestName() + ";Result=SUCCESS'");
        wrapupSuccess.getContent().add(successLog);
        wrapupSuccess.getContent().add(of.createExit());
        formItems.add(wrapupSuccess);

        Block wrapupFail = of.createBlock();
        wrapupFail.setName("AllDoneFailure");
        Log failLog = of.createLog();
        failLog.setLabel("DEBUG");
        failLog.setExpr("'VxmlTestStatus=Complete;Form=" + test.getTestName() + ";Result=FAIL'");
        wrapupFail.getContent().add(failLog);
        wrapupFail.getContent().add(of.createExit());
        formItems.add(wrapupFail);

        vxml.getDataOrCatchOrHelp().add(f);
        return vxml;
    }
}
