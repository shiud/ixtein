/**
 */
package com.ibm.tw.gbs.ixtein;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.xmlpull.v1.XmlPullParserException;

import com.ibm.tw.gbs.ixtein.tasks.BaseTask;
import com.ibm.tw.gbs.ixtein.tasks.DeviceTask;
import com.ibm.tw.gbs.ixtein.tasks.DirectUpdateTask;
import com.ibm.tw.gbs.ixtein.tasks.MainTask;
import com.ibm.tw.gbs.ixtein.tasks.SecurityTask;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainPlugin extends CordovaPlugin {
  private static final String TAG = "MainPlugin";

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing MainPlugin");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    BaseTask task = null;

    if(action.equals("echo")) {
      Log.d(TAG, "enter echo");
      String phrase = args.getString(0);
      Log.d(TAG, phrase);
      final PluginResult result = new PluginResult(PluginResult.Status.OK, "echo " + phrase);
      callbackContext.sendPluginResult(result);
      return true;
    } else if(action.equals("getDate")) {
      // An example of returning data back to the web layer
      final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
      return true;
    }
    else if(action.equals("main")) {
      Log.d(TAG, "enter main task");
      task = new MainTask();
    }
    else if(action.equals("device")) {
      Log.d(TAG, "enter device task");
      task = new DeviceTask();
    }
    else if(action.equals("directupdate")) {
      Log.d(TAG, "enter directupdate task");
      task = new DirectUpdateTask();
    }
    else if(action.equals("security")) {
      Log.d(TAG, "enter security task");
      task = new SecurityTask();
    }

    Context context = this.cordova.getContext();
    int id = context.getResources().getIdentifier("config", "xml", context.getPackageName());
    Map<String,String> maps = loadConfigsFromXml(context.getResources(), id);

    task.setConfigMaps(maps);
    task.setCordova(this.cordova);
    task.setWebView(this.webView);
    task.setPreferences(this.preferences);
    return task.execute(args, callbackContext);
  }

  /**
   *
   * @param res
   * @param configXmlResourceId
   * @return
   */
  private Map<String,String> loadConfigsFromXml(Resources res, int configXmlResourceId){
    //
    // Resources is the same thing from above that can be obtained
    // by context.getResources()
    // configXmlResourceId is the resource id integer obtained in step 1
    XmlResourceParser xrp = res.getXml(configXmlResourceId);

    Map<String,String> configs = new HashMap<String,String>();

    //
    // walk the config.xml tree and save all <preference> tags we want
    //
    try{
      xrp.next();
      while(xrp.getEventType() != XmlResourceParser.END_DOCUMENT){
        String name = xrp.getAttributeValue(null, "name");
        if(name != null) {
//          Log.d(TAG,"############################## name = " + xrp.getAttributeValue(null, "name"));
//          Log.d(TAG,"############################## value = " + xrp.getAttributeValue(null, "value"));
          configs.put(name, xrp.getAttributeValue(null, "value"));
        }

        xrp.next();
      }
    } catch(XmlPullParserException ex){
      Log.e("XML", ex.toString());
    }  catch(Exception ex){
      Log.e("XML", ex.toString());
    }

    return configs;
  }

}
