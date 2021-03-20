//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.14 at 08:28:06 AM EDT 
//


package com.nextivr.voicexml21;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for TransferType.datatype.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="TransferType.datatype"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="bridge"/&amp;gt;
 *     &amp;lt;enumeration value="blind"/&amp;gt;
 *     &amp;lt;enumeration value="consultation"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "TransferType.datatype")
@XmlEnum
public enum TransferTypeDatatype {

    @XmlEnumValue("bridge")
    BRIDGE("bridge"),
    @XmlEnumValue("blind")
    BLIND("blind"),
    @XmlEnumValue("consultation")
    CONSULTATION("consultation");
    private final String value;

    TransferTypeDatatype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TransferTypeDatatype fromValue(String v) {
        for (TransferTypeDatatype c: TransferTypeDatatype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
