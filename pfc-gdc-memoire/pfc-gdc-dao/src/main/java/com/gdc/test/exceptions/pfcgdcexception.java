package com.gdc.test.exceptions;

import java.io.Serializable;

/**
 *
 * @author a618092
 */
public class pfcgdcexception extends RuntimeException implements Serializable{
  // champs privés
 private int code = 0;

 // constructeurs
 public pfcgdcexception() {
 super();
 }

 public pfcgdcexception(String message) {
 super(message);
 }

 public pfcgdcexception(String message, Throwable cause) {
 super(message, cause);
 }

 public pfcgdcexception(Throwable cause) {
 super(cause);
 }

 public pfcgdcexception(String message, int code) {
 super(message);
 setCode(code);
 }

 public pfcgdcexception(Throwable cause, int code) {
 super(cause);
 setCode(code);
 }

 public pfcgdcexception(String message, Throwable cause, int code) {
 super(message, cause);
 setCode(code);
 }

 // getters - setters
 public int getCode() {
 return code;
 }

 public void setCode(int code) {
 this.code = code;
 }  
}
