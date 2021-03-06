//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.14 at 08:28:06 AM EDT 
//


package com.nextivr.vxml.voicexml21;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for speed.scale.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="speed.scale"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="x-fast"/&amp;gt;
 *     &amp;lt;enumeration value="fast"/&amp;gt;
 *     &amp;lt;enumeration value="medium"/&amp;gt;
 *     &amp;lt;enumeration value="slow"/&amp;gt;
 *     &amp;lt;enumeration value="x-slow"/&amp;gt;
 *     &amp;lt;enumeration value="default"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "speed.scale")
@XmlEnum
public enum SpeedScale {

    @XmlEnumValue("x-fast")
    X_FAST("x-fast"),
    @XmlEnumValue("fast")
    FAST("fast"),
    @XmlEnumValue("medium")
    MEDIUM("medium"),
    @XmlEnumValue("slow")
    SLOW("slow"),
    @XmlEnumValue("x-slow")
    X_SLOW("x-slow"),
    @XmlEnumValue("default")
    DEFAULT("default");
    private final String value;

    SpeedScale(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SpeedScale fromValue(String v) {
        for (SpeedScale c: SpeedScale.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
