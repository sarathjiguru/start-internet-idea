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
        StringBuilder apps = new StringBuilder();
        JSONObject info = new JSONObject();
        for (Object appInfo : appList) {
            ResolveInfo appInfo1 = (ResolveInfo) appInfo;
            Log.d(TAG, appInfo1.activityInfo.applicationInfo.packageName);
            apps.append(appInfo1.activityInfo.applicationInfo.loadLabel(ctx.getPackageManager()).toString()).append(",");
        }

        //return new PluginResult(PluginResult.Status.OK, apps.toString().replace("'", "\\'"));


        /*Context applicationContext = this.cordova.getActivity().getApplicationContext();
        Log.d(TAG,"package=name"+applicationContext.getPackageName());
        final PackageManager pm = applicationContext.getPackageManager();
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        StringBuilder installedApps = new StringBuilder();
        for (ApplicationInfo packageInfo : packages) {
            installedApps.append(packageInfo.packageName).append(", ");
        }*/
        Log.d(TAG,"app=list: "+apps.toString());

         /*if (action.equals(FETCH_APP_LIST)) {
            String name = data.getString(0);
            String message = installedApps.toString() +"for " + name;
            Log.d(TAG,"in if");
            System.out.println("in if");
            callbackContext.success(message);
            return true;
        } else {
            Log.d(TAG,"in else");
            System.out.println("in else");
            return false;

        }
        */

        if (action.equals("greet")) {
            String name = data.getString(0);
            String message = "Hello, " + name;
            Log.d(TAG,message);
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }
}

