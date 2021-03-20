package com.nextivr.utils;

import java.io.Serializable;
import java.util.List;

import com.nextivr.voicexml21.Field;
import com.nextivr.voicexml21.Form;
import com.nextivr.voicexml21.Vxml;
import com.nextivr.voicexml21.VxmlSpeak;

public class VxmlValidator {

    private Vxml vxml;

    public VxmlValidator(Vxml vxml) {
        this.vxml = vxml;
    }

    public VxmlValidator hasPromptWithText(String text) throws Exception {
        for (Object obj1 : vxml.getDataOrCatchOrHelp()) {
            if (obj1 instanceof Form) {
                Form form = (Form) obj1;
                for (Object obj2 : form.getCatchOrHelpOrNoinput()) {
                    if (obj2 instanceof Field) {
                        Field field = (Field) obj2;
                        for (Object obj3 : field.getContent()) {
                            if (obj3 instanceof VxmlSpeak) {
                                VxmlSpeak prompt = (VxmlSpeak) obj3;
                                List<Serializable> list1 = prompt.getContent();
                                while (list1.iterator().hasNext()) {
                                    Serializable s = list1.iterator().next();
                                }
                            }
                        }
                    }
                }
            }
        }

        return this;
    }

}
