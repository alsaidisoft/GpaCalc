package com.gpa.SoharCollege;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import java.util.Locale;

public class GeneralFunctions {
 
	protected double round2d(double n){
		
		return(.01* Math.round(100*n));
		
	}
	
	protected double SemesterGpa(double gpa){
		
		return gpa;
	}
	
	protected double Sum(double first,double second,double third,double forth,
			double five,double sixth,double seven){
		
        double sum=0;
		sum=first+second+third+forth+five+sixth+seven;
		return sum;
	}

	public void setLocale(String lang, Context context) {
		Locale myLocale = new Locale(lang);
		Resources res = context.getResources();
		DisplayMetrics dm = res.getDisplayMetrics();
		Configuration conf = res.getConfiguration();
		conf.locale = myLocale;
		res.updateConfiguration(conf, dm);

	}

	public void SetFontTypeFace(TextView txt, String face, Context mContext) {

		Typeface face1 = Typeface.createFromAsset(mContext.getAssets(), "fonts/HACEEN.ttf");
		Typeface face2 = Typeface.createFromAsset(mContext.getAssets(), "fonts/GESSTOO.otf");
		Typeface face3 = Typeface.createFromAsset(mContext.getAssets(), "fonts/Amaranth-Bold.otf");

		switch (face) {
			case "face1":
				txt.setTypeface(face1);
				break;
			case "face2":
				txt.setTypeface(face2);
				break;
			default:
				txt.setTypeface(face3);
				break;

		}

	}
	public  androidx.appcompat.app.ActionBar setCustomActionBar(Activity activity, ActionBar actionBar) {
		if (actionBar != null) {
			ViewGroup actionBarLayout = (ViewGroup) activity.getLayoutInflater().inflate(R.layout.action_bar_layout, null);

			actionBar.setDisplayShowHomeEnabled(false);
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setDisplayShowCustomEnabled(true);
			actionBar.setCustomView(actionBarLayout);
			actionBar.setBackgroundDrawable(new ColorDrawable(activity.getResources().getColor(R.color.brown)));
			TextView actionBarTitle = (TextView) actionBarLayout.findViewById(R.id.text_actionbar_title);
			if (Locale.getDefault().getLanguage() == "ar") {
				Typeface face4 = Typeface.createFromAsset(activity.getAssets(), "fonts/GESSTOO.otf");
				//actionBarTitle.setText(title);
				actionBarTitle.setTypeface(face4);
			}
			else{
				Typeface face4 = Typeface.createFromAsset(activity.getAssets(), "fonts/Amaranth-Bold.otf");
				//actionBarTitle.setText(title);
				actionBarTitle.setTypeface(face4);
			}



		}
		return actionBar;
	}

	
	
}
