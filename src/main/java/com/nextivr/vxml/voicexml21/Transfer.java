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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}audio"/&amp;gt;
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}event.handler"/&amp;gt;
 *         &amp;lt;element ref="{http://www.w3.org/2001/vxml}filled"/&amp;gt;
 *         &amp;lt;element ref="{http://www.w3.org/2001/vxml}property"/&amp;gt;
 *         &amp;lt;group ref="{http://www.w3.org/2001/vxml}input"/&amp;gt;
 *         &amp;lt;element ref="{http://www.w3.org/2001/vxml}prompt"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *       &amp;lt;attGroup ref="{http://www.w3.org/2001/vxml}Form-item.attribs"/&amp;gt;
 *       &amp;lt;attribute name="dest" type="{http://www.w3.org/2001/vxml}URI.datatype" /&amp;gt;
 *       &amp;lt;attribute name="destexpr" type="{http://www.w3.org/2001/vxml}Script.datatype" /&amp;gt;
 *       &amp;lt;attribute name="bridge" type="{http://www.w3.org/2001/vxml}Boolean.datatype" /&amp;gt;
 *       &amp;lt;attribute name="connecttimeout" type="{http://www.w3.org/2001/vxml}Duration.datatype" /&amp;gt;
 *       &amp;lt;attribute name="maxtime" type="{http://www.w3.org/2001/vxml}Duration.datatype" /&amp;gt;
 *       &amp;lt;attribute name="transferaudio" type="{http://www.w3.org/2001/vxml}URI.datatype" /&amp;gt;
 *       &amp;lt;attribute name="type" type="{http://www.w3.org/2001/vxml}TransferType.datatype" /&amp;gt;
 *       &amp;lt;attribute name="aai" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="aaiexpr" type="{http://www.w3.org/2001/vxml}Script.datatype" /&amp;gt;
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
@XmlRootElement(name = "transfer")
public class Transfer {

    @XmlElementRefs({
        @XmlElementRef(name = "enumerate", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "value", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "audio", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "catch", namespace = "http://www.w3.org/2001/vxml", type = Catch.class, required = false),
        @XmlElementRef(name = "help", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "noinput", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "nomatch", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "error", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "filled", namespace = "http://www.w3.org/2001/vxml", type = Filled.class, required = false),
        @XmlElementRef(name = "property", namespace = "http://www.w3.org/2001/vxml", type = Property.class, required = false),
        @XmlElementRef(name = "grammar", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "prompt", namespace = "http://www.w3.org/2001/vxml", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    protected List<java.lang.Object> content;
    @XmlAttribute(name = "dest")
    protected String dest;
    @XmlAttribute(name = "destexpr")
    protected String destexpr;
    @XmlAttribute(name = "bridge")
    protected List<String> bridge;
    @XmlAttribute(name = "connecttimeout")
    protected String connecttimeout;
    @XmlAttribute(name = "maxtime")
    protected String maxtime;
    @XmlAttribute(name = "transferaudio")
    protected String transferaudio;
    @XmlAttribute(name = "type")
    protected TransferTypeDatatype type;
    @XmlAttribute(name = "aai")
    protected String aai;
    @XmlAttribute(name = "aaiexpr")
    protected String aaiexpr;
    @XmlAttribute(name = "name")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlAttribute(name = "expr")
    protected String expr;
    @XmlAttribute(name = "cond")
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
     * {@link Catch }
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link JAXBElement }{@code <}{@link BasicEventHandler }{@code >}
     * {@link Filled }
     * {@link Property }
     * {@link JAXBElement }{@code <}{@link MixedGrammar }{@code >}
     * {@link JAXBElement }{@code <}{@link VxmlSpeak }{@code >}
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
     * Gets the value of the dest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDest() {
        return dest;
    }

    /**
     * Sets the value of the dest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDest(String value) {
        this.dest = value;
    }

    /**
     * Gets the value of the destexpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestexpr() {
        return destexpr;
    }

    /**
     * Sets the value of the destexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestexpr(String value) {
        this.destexpr = value;
    }

    /**
     * Gets the value of the bridge property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the bridge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getBridge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBridge() {
        if (bridge == null) {
            bridge = new ArrayList<String>();
        }
        return this.bridge;
    }

    /**
     * Gets the value of the connecttimeout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnecttimeout() {
        return connecttimeout;
    }

    /**
     * Sets the value of the connecttimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnecttimeout(String value) {
        this.connecttimeout = value;
    }

    /**
     * Gets the value of the maxtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxtime() {
        return maxtime;
    }

    /**
     * Sets the value of the maxtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxtime(String value) {
        this.maxtime = value;
    }

    /**
     * Gets the value of the transferaudio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferaudio() {
        return transferaudio;
    }

    /**
     * Sets the value of the transferaudio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferaudio(String value) {
        this.transferaudio = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link TransferTypeDatatype }
     *     
     */
    public TransferTypeDatatype getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransferTypeDatatype }
     *     
     */
    public void setType(TransferTypeDatatype value) {
        this.type = value;
    }

    /**
     * Gets the value of the aai property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAai() {
        return aai;
    }

    /**
     * Sets the value of the aai property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAai(String value) {
        this.aai = value;
    }

    /**
     * Gets the value of the aaiexpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAaiexpr() {
        return aaiexpr;
    }

    /**
     * Sets the value of the aaiexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAaiexpr(String value) {
        this.aaiexpr = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the expr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpr() {
        return expr;
    }

    /**
     * Sets the value of the expr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpr(String value) {
        this.expr = value;
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
