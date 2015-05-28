package android.applist;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Hello extends CordovaPlugin {
    private static final String APP_ID = "appid";
    private static final String APP_NAME = "appname";
    final String dummy_url = "http://cdn1.iconfinder.com/data/icons/anchor/128/stack.png";
    /*public static final java.lang.String FETCH_APP_LIST = "greet";



        Context applicationContext = this.cordova.getActivity().getApplicationContext();
        final PackageManager pm = applicationContext.getPackageManager();
    */
    final String TAG = "HelloPlugin";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "before context");
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        Context ctx = this.cordova.getActivity().getApplicationContext();
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager packageManager = ctx.getPackageManager();
        List appList = packageManager.queryIntentActivities(i, 0);
        JSONArray info = new JSONArray();
        int id = 0;
        for (Object appInfo : appList) {
            ResolveInfo appInfo1 = (ResolveInfo) appInfo;
            ApplicationInfo applicationInfo = appInfo1.activityInfo.applicationInfo;
            String appId = applicationInfo.packageName;
            String appName = applicationInfo.loadLabel(packageManager).toString();
            Uri path = getIconFrom(ctx, packageManager, applicationInfo, appId);

            JSONObject app = new JSONObject();
            app.put("name", appId);
            app.put("lastText", appName);
            app.put("id", id);
            app.put("face", path.getPath());
            info.put(app);
            id++;
        }


        Log.d(TAG, "app=list: " + "");

        if (action.equals("greet")) {
            String name = data.getString(0);
            String message = info.toString();
            Log.d(TAG, message);
            callbackContext.success(message);

            return true;

        } else {

            return false;

        }
    }

    private Uri getIconFrom(Context ctx, PackageManager packageManager, ApplicationInfo applicationInfo, String appId) {
        Uri path = Uri.parse(ctx.getFilesDir() + "/" + appId + ".icon.png");

        FileOutputStream out = null;
        try {
            Bitmap icon = BitmapFactory.decodeResource(
                    packageManager.getResourcesForApplication(applicationInfo), applicationInfo.icon);
            out = new FileOutputStream(path.getPath());
            icon.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }
}

