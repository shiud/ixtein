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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.app.ProgressDialog;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.res.AssetManager;

import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;

import com.ibm.tw.gbs.ixtein.utils.FileUtils;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 *  自動更新
 */
public class DirectUpdateTask extends BaseTask {

    // *********************************************
    // Local Variable
    // *********************************************
    private final static String TAG = "Logger:" + DirectUpdateTask.class.getName();
	
    /**
     *
     * @param args
     * @param callbackContext
     * @return
     * @throws JSONException
     */
    @Override
    public boolean execute(JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            String method = args.get(0).toString();
            final Context ctx = this.getCordova().getActivity();
			
			final PluginResult result = new PluginResult(PluginResult.Status.OK, "");
            callbackContext.sendPluginResult(result);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
            final PluginResult result = new PluginResult(PluginResult.Status.OK, ex.getMessage());
            callbackContext.sendPluginResult(result);
        }

        return true;
    }
}
