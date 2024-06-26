package com.gpa.SoharCollege;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.LinearLayout;

public class AppRatter {
    private final static String APP_PNAME = "com.gpa.SoharCollege";
    
    private final static int DAYS_UNTIL_PROMPT = 2;
    private final static int LAUNCHES_UNTIL_PROMPT = 2;
    
    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) { return ; }
        
        SharedPreferences.Editor editor = prefs.edit();
        
        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }
        
        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch + 
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
            }
        }
        
        editor.commit();
    }   
    
    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        String title = mContext.getResources().getString(R.string.rate_app) + " "+mContext.getResources().getString(R.string.app_name);
        dialog.setTitle(title);
        LinearLayout ll = new LinearLayout(mContext);
        ll.setOrientation(LinearLayout.VERTICAL);

        String masg = mContext.getResources().getString(R.string.like_app);

        dialog.setMessage(masg);
            dialog.setPositiveButton(mContext.getResources().getString(R.string.rate_app), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                    dialog.dismiss();
                }
            });
            dialog.setNeutralButton(mContext.getResources().getString(R.string.remaind_me_later), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            dialog.setNegativeButton(mContext.getResources().getString(R.string.no_thanks), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (editor != null) {
                        editor.putBoolean("dontshowagain", true);
                        editor.commit();
                    }
                    dialog.dismiss();

                }
            });



        dialog.create();
        dialog.show();
             
    }
}
