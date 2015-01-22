/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author luca
 */
@XmlRootElement(name="error")
@XmlType(propOrder = {"code","message"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorRaise {
    
    public final static int GOOD_REQ = 200;
    public final static int BAD_REQ = 1;
    
    public final static String GOOD_MESSAGE = "Valid Request";
    public final static String BAD_MESSAGE = "User not authenticated";
    
    private int code;
    private String message;

    public ErrorRaise() {
    }

    public ErrorRaise(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
