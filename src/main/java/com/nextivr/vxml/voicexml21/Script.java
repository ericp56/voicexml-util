//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.14 at 08:28:06 AM EDT 
//


package com.nextivr.vxml.voicexml21;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attGroup ref="{http://www.w3.org/2001/vxml}Cache.attribs"/&amp;gt;
 *       &amp;lt;attribute name="src" type="{http://www.w3.org/2001/vxml}URI.datatype" /&amp;gt;
 *       &amp;lt;attribute name="srcexpr" type="{http://www.w3.org/2001/vxml}Script.datatype" /&amp;gt;
 *       &amp;lt;attribute name="charset" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
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
@XmlRootElement(name = "script")
public class Script {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "src")
    protected String src;
    @XmlAttribute(name = "srcexpr")
    protected String srcexpr;
    @XmlAttribute(name = "charset")
    protected String charset;
    @XmlAttribute(name = "fetchhint")
    protected FetchhintDatatype fetchhint;
    @XmlAttribute(name = "maxage")
    protected BigInteger maxage;
    @XmlAttribute(name = "maxstale")
    protected BigInteger maxstale;
    @XmlAttribute(name = "fetchtimeout")
    protected String fetchtimeout;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the src property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrc() {
        return src;
    }

    /**
     * Sets the value of the src property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrc(String value) {
        this.src = value;
    }

    /**
     * Gets the value of the srcexpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcexpr() {
        return srcexpr;
    }

    /**
     * Sets the value of the srcexpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcexpr(String value) {
        this.srcexpr = value;
    }

    /**
     * Gets the value of the charset property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Sets the value of the charset property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharset(String value) {
        this.charset = value;
    }

    /**
     * Gets the value of the fetchhint property.
     * 
     * @return
     *     possible object is
     *     {@link FetchhintDatatype }
     *     
     */
    public FetchhintDatatype getFetchhint() {
        return fetchhint;
    }

    /**
     * Sets the value of the fetchhint property.
     * 
     * @param value
     *     allowed object is
     *     {@link FetchhintDatatype }
     *     
     */
    public void setFetchhint(FetchhintDatatype value) {
        this.fetchhint = value;
    }

    /**
     * Gets the value of the maxage property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxage() {
        return maxage;
    }

    /**
     * Sets the value of the maxage property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxage(BigInteger value) {
        this.maxage = value;
    }

    /**
     * Gets the value of the maxstale property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxstale() {
        return maxstale;
    }

    /**
     * Sets the value of the maxstale property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxstale(BigInteger value) {
        this.maxstale = value;
    }

    /**
     * Gets the value of the fetchtimeout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFetchtimeout() {
        return fetchtimeout;
    }

    /**
     * Sets the value of the fetchtimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFetchtimeout(String value) {
        this.fetchtimeout = value;
    }

}