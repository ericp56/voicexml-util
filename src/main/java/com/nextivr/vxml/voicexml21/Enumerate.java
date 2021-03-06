//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.14 at 08:28:06 AM EDT 
//


package com.nextivr.vxml.voicexml21;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;choice maxOccurs="unbounded" minOccurs="0"&amp;gt;
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}allowed-within-sentence"/&amp;gt;
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}structure"/&amp;gt;
 *         &amp;lt;element name="foreach" type="{http://www.w3.org/2001/vxml}foreach-in-prompt.type"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
public class Enumerate {

    @XmlElementRefs({
        @XmlElementRef(name = "aws", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "struct", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "foreach", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<Serializable> content;

    /**
     * Gets the value of the content property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the content property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SayAs }{@code >}
     * {@link JAXBElement }{@code <}{@link Sub }{@code >}
     * {@link JAXBElement }{@code <}{@link Emphasis }{@code >}
     * {@link JAXBElement }{@code <}{@link Phoneme }{@code >}
     * {@link JAXBElement }{@code <}{@link Value }{@code >}
     * {@link JAXBElement }{@code <}{@link Voice }{@code >}
     * {@link JAXBElement }{@code <}{@link Prosody }{@code >}
     * {@link JAXBElement }{@code <}{@link Mark }{@code >}
     * {@link JAXBElement }{@code <}{@link Audio }{@code >}
     * {@link JAXBElement }{@code <}{@link Enumerate }{@code >}
     * {@link JAXBElement }{@code <}{@link Break }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Sentence }{@code >}
     * {@link JAXBElement }{@code <}{@link Paragraph }{@code >}
     * {@link JAXBElement }{@code <}{@link java.lang.Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ForeachInPromptType }{@code >}
     * {@link String }
     * 
     * 
     */
    public List<Serializable> getContent() {
        if (content == null) {
            content = new ArrayList<Serializable>();
        }
        return this.content;
    }

}
