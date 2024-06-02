package com.gpa.SoharCollege;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {
	

    ImageView img1, img2,img3,img4,img5,img6;
    TextView txt1, txt2,txt3,txt4,txt5,txt6;
    GeneralFunctions gn = new GeneralFunctions();

    private ShareActionProvider mShareActionProvider;

    @SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
        try {

            gn.setCustomActionBar(this, this.getSupportActionBar());

        } catch (Exception e) {
            System.out.println("_______" + e.getMessage() + "___________________");
        }

        AppRatter.app_launched(this);
        txt1 = (TextView) findViewById(R.id.calculate);
        txt2 = (TextView) findViewById(R.id.about);
        txt3 = (TextView) findViewById(R.id.rate_us);
        txt4 = (TextView) findViewById(R.id.share);
        txt5 = (TextView) findViewById(R.id.contact_us);
        txt6 = (TextView) findViewById(R.id.developers);
        if(Locale.getDefault().getLanguage() == "ar"){
            gn.setLocale("ar",getApplicationContext());
            gn.SetFontTypeFace(txt1, "face2", getApplicationContext());
            gn.SetFontTypeFace(txt2, "face2", getApplicationContext());
            gn.SetFontTypeFace(txt3, "face2", getApplicationContext());
            gn.SetFontTypeFace(txt4, "face2", getApplicationContext());
            gn.SetFontTypeFace(txt5, "face2", getApplicationContext());
            gn.SetFontTypeFace(txt6, "face2", getApplicationContext());
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        }
        else{
            gn.SetFontTypeFace(txt1, "face3", getApplicationContext());
            gn.SetFontTypeFace(txt2, "face3", getApplicationContext());
            gn.SetFontTypeFace(txt3, "face3", getApplicationContext());
            gn.SetFontTypeFace(txt4, "face3", getApplicationContext());
            gn.SetFontTypeFace(txt5, "face3", getApplicationContext());
            gn.SetFontTypeFace(txt6, "face3", getApplicationContext());
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }


        img1 =(ImageView) findViewById(R.id.img1);
        img2 =(ImageView) findViewById(R.id.img2);
        img3 =(ImageView) findViewById(R.id.img3);
        img4 =(ImageView) findViewById(R.id.img4);
        img5 =(ImageView) findViewById(R.id.img5);
        img6 =(ImageView) findViewById(R.id.img6);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle(R.string.choose_num_of_course);
                String[] types = {"1", "2","3","4","5","6","7","8","9","10",getResources().getString(R.string.repeated)};
                b.setItems(types, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        dialog.dismiss();
                        Intent open;
                        if(which == 10){
                            AlertDialog.Builder r = new AlertDialog.Builder(MainActivity.this);
                            r.setTitle(R.string.how_many_courses_repeated);
                            String[] rtypes = {"1", "2","3","4","5","6","7"};
                            r.setItems(rtypes, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int rwhich) {

                                    int rcourse = 1+rwhich;
                                    Intent ropen = new Intent(MainActivity.this, RepeatedCourses.class);
                                    ropen.setFlags(FLAG_ACTIVITY_NEW_TASK);
                                    ropen.putExtra("Courses", rcourse + "");
                                    startActivity(ropen);
                                    dialog.dismiss();



                                }

                            });

                            r.show();

                        }
                        else {
                            open = new Intent(MainActivity.this, Gpa.class);
                            open.setFlags(FLAG_ACTIVITY_NEW_TASK);
                            int course = which + 1;
                            open.putExtra("Courses", course + "");
                            startActivity(open);

                        }


                    }

                });

                b.show();

            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);// set title
                alertDialogBuilder.setTitle(R.string.developer);
                // set dialog message
                int mImage = R.mipmap.ic_action_developers;
                alertDialogBuilder.setIcon(mImage);
                alertDialogBuilder.setMessage(getResources().getString(R.string.app_dev))
                        .setCancelable(false)
                        .setNegativeButton(R.string.ok,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int id){
                                // if this button is clicked, close
                                // current activity
                                dialog.cancel();

                            }
                        });

                // create alert dialog
                AlertDialog alertDialog=alertDialogBuilder.create();

                // show it
                alertDialog.show();



            }
        });
		img3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
                //provide user information before start
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle(R.string.info);
                String message = getResources().getString(R.string.calc_info);
                alert.setMessage(message);
                alert.setButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dd, final int which) {
                        dd.cancel();
                    }
                });


                alert.show();
            }
		});
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                String msg = getResources().getString(R.string.download)+
                        "\n" +
                        "https://play.google.com/store/apps/details?id="+"com.gpa.SoharCollege";
                share.putExtra(Intent.EXTRA_TEXT, msg);
                share.setType("text/plain");
                startActivity(Intent.createChooser(share, getResources().getText(R.string.send_to)));
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + "com.gpa.SoharCollege"));
                startActivity(intent);
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "saeed.alsaidi.developer@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject: GPA calculator com.gpa.SoharCollege");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body:");
                    startActivity(Intent.createChooser(emailIntent, getResources().getString(R.string.contact_us)));
                } catch (Exception email) {
                    email.printStackTrace();
                }
            }
        });
		
	}







}
