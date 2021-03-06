//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.14 at 08:28:06 AM EDT 
//


package com.nextivr.vxml.voicexml21;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}executable.content" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;sequence maxOccurs="unbounded" minOccurs="0"&amp;gt;
 *           &amp;lt;element ref="{http://www.w3.org/2001/vxml}elseif"/&amp;gt;
 *           &amp;lt;group ref="{http://www.w3.org/2001/vxml}executable.content" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;/sequence&amp;gt;
 *         &amp;lt;sequence minOccurs="0"&amp;gt;
 *           &amp;lt;element ref="{http://www.w3.org/2001/vxml}else"/&amp;gt;
 *           &amp;lt;group ref="{http://www.w3.org/2001/vxml}executable.content" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;/sequence&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attGroup ref="{http://www.w3.org/2001/vxml}If.attribs"/&amp;gt;
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
@XmlRootElement(name = "if")
public class If {

    @XmlElementRefs({
        @XmlElementRef(name = "enumerate", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "value", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "assign", namespace = "http://www.w3.org/2001/vxml", type = Assign.class, required = false),
        @XmlElementRef(name = "clear", namespace = "http://www.w3.org/2001/vxml", type = Clear.class, required = false),
        @XmlElementRef(name = "data", namespace = "http://www.w3.org/2001/vxml", type = Data.class, required = false),
        @XmlElementRef(name = "disconnect", namespace = "http://www.w3.org/2001/vxml", type = Disconnect.class, required = false),
        @XmlElementRef(name = "exit", namespace = "http://www.w3.org/2001/vxml", type = Exit.class, required = false),
        @XmlElementRef(name = "foreach", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "goto", namespace = "http://www.w3.org/2001/vxml", type = Goto.class, required = false),
        @XmlElementRef(name = "if", namespace = "http://www.w3.org/2001/vxml", type = If.class, required = false),
        @XmlElementRef(name = "log", namespace = "http://www.w3.org/2001/vxml", type = Log.class, required = false),
        @XmlElementRef(name = "reprompt", namespace = "http://www.w3.org/2001/vxml", type = Reprompt.class, required = false),
        @XmlElementRef(name = "return", namespace = "http://www.w3.org/2001/vxml", type = Return.class, required = false),
        @XmlElementRef(name = "script", namespace = "http://www.w3.org/2001/vxml", type = Script.class, required = false),
        @XmlElementRef(name = "submit", namespace = "http://www.w3.org/2001/vxml", type = Submit.class, required = false),
        @XmlElementRef(name = "throw", namespace = "http://www.w3.org/2001/vxml", type = Throw.class, required = false),
        @XmlElementRef(name = "var", namespace = "http://www.w3.org/2001/vxml", type = Var.class, required = false),
        @XmlElementRef(name = "prompt", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "elseif", namespace = "http://www.w3.org/2001/vxml", type = Elseif.class, required = false),
        @XmlElementRef(name = "else", namespace = "http://www.w3.org/2001/vxml", type = Else.class, required = false)
    })
    @XmlMixed
    protected List<java.lang.Object> content;
    @XmlAttribute(name = "cond", required = true)
    protected String cond;

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
     * {@link JAXBElement }{@code <}{@link Enumerate }{@code >}
     * {@link JAXBElement }{@code <}{@link Value }{@code >}
     * {@link JAXBElement }{@code <}{@link Audio }{@code >}
     * {@link Assign }
     * {@link Clear }
     * {@link Data }
     * {@link Disconnect }
     * {@link Exit }
     * {@link JAXBElement }{@code <}{@link ForeachNotInPromptType }{@code >}
     * {@link Goto }
     * {@link If }
     * {@link Log }
     * {@link Reprompt }
     * {@link Return }
     * {@link Script }
     * {@link Submit }
     * {@link Throw }
     * {@link Var }
     * {@link JAXBElement }{@code <}{@link VxmlSpeak }{@code >}
     * {@link Elseif }
     * {@link Else }
     * {@link String }
     * 
     * 
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the cond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCond() {
        return cond;
    }

    /**
     * Sets the value of the cond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCond(String value) {
        this.cond = value;
    }

}
