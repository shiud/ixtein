/*
 * ===========================================================================
 * IBM Confidential
 * AIS Source Materials
 *
 * (C) Copyright IBM Corp. 2019.
 *
 * ===========================================================================
 */
package com.ibm.tw.gbs.ixtein.tasks;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public abstract class BaseTask {

    // *********************************************
    // Local Variable
    // *********************************************
    private CordovaInterface cordova;
    private CordovaWebView webView;
    private CordovaPreferences preferences;

    // *********************************************
    // Getter & Setter
    // *********************************************
    public CordovaInterface getCordova(){
        return this.cordova;
    }
    public void setCordova(CordovaInterface cordova){
        this.cordova = cordova;
    }

    public void setWebView(CordovaWebView webView) {
        this.webView = webView;
    }
    public CordovaWebView getWebView() {
        return webView;
    }

    public void setPreferences(CordovaPreferences preferences){
        this.preferences = preferences;
    }
    public CordovaPreferences getPreferences(){
        return this.preferences;
    }
    // *********************************************
    // Public Method
    // *********************************************

    // *********************************************
    // abstract Method
    // *********************************************
    // 主要執行的Class
    public abstract boolean execute(JSONArray args, CallbackContext callbackContext) throws JSONException;

}
