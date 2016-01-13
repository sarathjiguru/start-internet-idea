package android.applist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class Hello extends CordovaPlugin {
    private static final String APP_ID = "appid";
    private static final String APP_NAME = "appname";
    /*public static final java.lang.String FETCH_APP_LIST = "greet";



        Context applicationContext = this.cordova.getActivity().getApplicationContext();
        final PackageManager pm = applicationContext.getPackageManager();
    */
    final String TAG="HelloPlugin";
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "before context");
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        Context ctx = this.cordova.getActivity().getApplicationContext();
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List appList = ctx.getPackageManager().queryIntentActivities(i, 0);
        JSONArray info = new JSONArray();
        for (Object appInfo : appList) {
            ResolveInfo appInfo1 = (ResolveInfo) appInfo;
            String appId = appInfo1.activityInfo.applicationInfo.packageName;
            String appName = appInfo1.activityInfo.applicationInfo.loadLabel(ctx.getPackageManager()).toString();

            Log.d(TAG, appId);

            JSONObject app = new JSONObject();
            app.put(APP_ID, appId);
            app.put(APP_NAME, appName);

            info.put(app);
        }

        Log.d(TAG,"app=list: "+ "");

        if (action.equals("greet")) {
            String name = data.getString(0);
            String message = info +"," + name;
            Log.d(TAG,message);
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }
}

