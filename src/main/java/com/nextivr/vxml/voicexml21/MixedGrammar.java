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
import javax.xml.bind.annotation.XmlType;


/**
 * extends grammar type - add VoiceXML grammar attributes 
 * 
 * &lt;p&gt;Java class for mixed-grammar complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="mixed-grammar"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.w3.org/2001/vxml}mixed-grammar"&amp;gt;
 *       &amp;lt;redefine&amp;gt;
 *         &amp;lt;complexType name="mixed-grammar"&amp;gt;
 *           &amp;lt;complexContent&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *               &amp;lt;group ref="{http://www.w3.org/2001/vxml}grammar.class"/&amp;gt;
 *               &amp;lt;attGroup ref="{http://www.w3.org/2001/vxml}Grammar.attribs"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/complexContent&amp;gt;
 *         &amp;lt;/complexType&amp;gt;
 *       &amp;lt;/redefine&amp;gt;
 *       &amp;lt;attGroup ref="{http://www.w3.org/2001/vxml}VXMLGrammar.attribs"/&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mixed-grammar")
public class MixedGrammar
    extends OriginalMixedGrammar
{

    @XmlAttribute(name = "scope")
    protected GrammarScopeDatatype scope;
    @XmlAttribute(name = "weight")
    protected String weight;
    @XmlAttribute(name = "src")
    protected String src;
    @XmlAttribute(name = "srcexpr")
    protected String srcexpr;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "fetchhint")
    protected FetchhintDatatype fetchhint;
    @XmlAttribute(name = "maxage")
    protected BigInteger maxage;
    @XmlAttribute(name = "maxstale")
    protected BigInteger maxstale;
    @XmlAttribute(name = "fetchtimeout")
    protected String fetchtimeout;

    /**
     * Gets the value of the scope property.
     * 
     * @return
     *     possible object is
     *     {@link GrammarScopeDatatype }
     *     
     */
    public GrammarScopeDatatype getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrammarScopeDatatype }
     *     
     */
    public void setScope(GrammarScopeDatatype value) {
        this.scope = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeight(String value) {
        this.weight = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
