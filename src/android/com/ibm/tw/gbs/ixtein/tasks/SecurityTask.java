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
import android.util.Log;
import android.content.SharedPreferences;

import com.ibm.tw.gbs.ixtein.utils.RsaUtils;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Map;

public class SecurityTask extends BaseTask {

    private final static String TAG = "Logger:" + SecurityTask.class.getName();
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
