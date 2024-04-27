package com.gpa.SoharCollege;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RepeatedCourses extends AppCompatActivity implements OnItemSelectedListener {

	double dg1;
	double dg2;
	double dg3;
	double dg4;
	double dg5;
	double dg6;
	double dg7;

	double af1;
	double af2;
	double af3;
	double af4;
	double af5;
	double af6;
	double af7;


	boolean dgr1 = true;
	boolean dgr2 = true;
	boolean dgr3 = true;
	boolean dgr4 = true;
	boolean dgr5 = true;
	boolean dgr6 = true;
	boolean dgr7 = true;

	boolean aft1 = true;
	boolean aft2 = true;
	boolean aft3 = true;
	boolean aft4 = true;
	boolean aft5 = true;
	boolean aft6 = true;
	boolean aft7 = true;

	double affirst = 0;
	double afsecond = 0;
	double afthird = 0;
	double afforth = 0;
	double affifth = 0;
	double afsixth = 0;
	double afseven = 0;


	int hu1;
	int hu2;
	int hu3;
	int hu4;
	int hu5;
	int hu6;
	int hu7;

	boolean huo1 = true;
	boolean huo2 = true;
	boolean huo3 = true;
	boolean huo4 = true;
	boolean huo5 = true;
	boolean huo6 = true;
	boolean huo7 = true;


	double first = 0;
	double second = 0;
	double third = 0;
	double forth = 0;
	double fivee = 0;
	double sixth = 0;
	double seven = 0;

	int hsum;

	double sum;
	double gpa;
	double credits;
	double points;
	double totalsum;

	int totalHourses;
	double genralNewGpa;
	GeneralFunctions gn = new GeneralFunctions();
	TextView txt1, txt2, txt3, txt4, txt5,txt6;
	Button btn1;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repeat_courses);
		ActionBar actionBar = getActionBar();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		try {

			gn.setCustomActionBar(this, this.getSupportActionBar());

		} catch (Exception e) {
			System.out.println("_______" + e.getMessage() + "___________________");
		}


		txt1 = (TextView) findViewById(R.id.textView1);
		txt2 = (TextView) findViewById(R.id.textView2);
		txt3 = (TextView) findViewById(R.id.textView3);
		txt4 = (TextView) findViewById(R.id.textView4);
		txt5 = (TextView) findViewById(R.id.textView5);
		txt6 = (TextView) findViewById(R.id.textView6);
		btn1 = (Button) findViewById(R.id.button1);

		if(Locale.getDefault().getLanguage() == "ar"){
			gn.setLocale("ar",getApplicationContext());
			gn.SetFontTypeFace(txt1, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt2, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt3, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt4, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt5, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt6, "face2", getApplicationContext());
			gn.SetFontTypeFace(btn1, "face2", getApplicationContext());
			getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

		}
		else{
			gn.SetFontTypeFace(txt1, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt2, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt3, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt4, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt5, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt6, "face3", getApplicationContext());
			gn.SetFontTypeFace(btn1, "face3", getApplicationContext());
			getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
		}

		final Spinner hours1 = (Spinner) findViewById(R.id.spinner1);
		final Spinner hours2 = (Spinner) findViewById(R.id.spinner4);
		final Spinner hours3 = (Spinner) findViewById(R.id.spinner7);
		final Spinner hours4 = (Spinner) findViewById(R.id.spinner10);
		final Spinner hours5 = (Spinner) findViewById(R.id.spinner13);
		final Spinner hours6 = (Spinner) findViewById(R.id.spinner16);
		final Spinner hours7 = (Spinner) findViewById(R.id.spinner19);

		final Spinner degree1 = (Spinner) findViewById(R.id.spinner2);
		final Spinner degree2 = (Spinner) findViewById(R.id.spinner5);
		final Spinner degree3 = (Spinner) findViewById(R.id.spinner8);
		final Spinner degree4 = (Spinner) findViewById(R.id.spinner11);
		final Spinner degree5 = (Spinner) findViewById(R.id.spinner14);
		final Spinner degree6 = (Spinner) findViewById(R.id.spinner17);
		final Spinner degree7 = (Spinner) findViewById(R.id.spinner20);

		final Spinner after1 = (Spinner) findViewById(R.id.spinner3);
		final Spinner after2 = (Spinner) findViewById(R.id.spinner6);
		final Spinner after3 = (Spinner) findViewById(R.id.spinner9);
		final Spinner after4 = (Spinner) findViewById(R.id.spinner12);
		final Spinner after5 = (Spinner) findViewById(R.id.spinner15);
		final Spinner after6 = (Spinner) findViewById(R.id.spinner18);
		final Spinner after7 = (Spinner) findViewById(R.id.spinner21);

		hours1.setOnItemSelectedListener(this);
		hours2.setOnItemSelectedListener(this);
		hours3.setOnItemSelectedListener(this);
		hours4.setOnItemSelectedListener(this);
		hours5.setOnItemSelectedListener(this);
		hours6.setOnItemSelectedListener(this);
		hours7.setOnItemSelectedListener(this);

		degree1.setOnItemSelectedListener(this);
		degree2.setOnItemSelectedListener(this);
		degree3.setOnItemSelectedListener(this);
		degree4.setOnItemSelectedListener(this);
		degree5.setOnItemSelectedListener(this);
		degree6.setOnItemSelectedListener(this);
		degree7.setOnItemSelectedListener(this);

		after1.setOnItemSelectedListener(this);
		after2.setOnItemSelectedListener(this);
		after3.setOnItemSelectedListener(this);
		after4.setOnItemSelectedListener(this);
		after5.setOnItemSelectedListener(this);
		after6.setOnItemSelectedListener(this);
		after7.setOnItemSelectedListener(this);

		//create List for hourses

		final List<String> hourses = new ArrayList<String>();

		hourses.add("0");
		hourses.add("2");
		hourses.add("3");
		hourses.add("4");
		hourses.add("5");


		//creating adapter for spinner
		final ArrayAdapter<String> hoursAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, hourses);
		//list view
		hoursAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//attaching hours to spinner
		hours1.setAdapter(hoursAdapter);
		hours2.setAdapter(hoursAdapter);
		hours3.setAdapter(hoursAdapter);
		hours4.setAdapter(hoursAdapter);
		hours5.setAdapter(hoursAdapter);
		hours6.setAdapter(hoursAdapter);
		hours7.setAdapter(hoursAdapter);

		//create list for degrees before repeated
		final List<String> degrees = new ArrayList<String>();
		degrees.add("0");
		degrees.add("A");
		degrees.add("A-");
		degrees.add("B+");
		degrees.add("B");
		degrees.add("B-");
		degrees.add("C+");
		degrees.add("C");
		degrees.add("C-");
		degrees.add("D+");
		degrees.add("D");
		degrees.add("F");

		//create adapter for spinner degrees

		final ArrayAdapter<String> degreeAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, degrees);
		degreeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//attach degrees to adapter
		degree1.setAdapter(degreeAdapter);
		degree2.setAdapter(degreeAdapter);
		degree3.setAdapter(degreeAdapter);
		degree4.setAdapter(degreeAdapter);
		degree5.setAdapter(degreeAdapter);
		degree6.setAdapter(degreeAdapter);
		degree7.setAdapter(degreeAdapter);

		//create list for repeated courses

		final List<String> repeated = new ArrayList<String>();
		repeated.add("0");
		repeated.add("A");
		repeated.add("A-");
		repeated.add("B+");
		repeated.add("B");
		repeated.add("B-");
		repeated.add("C+");
		repeated.add("C");
		repeated.add("C-");
		repeated.add("D+");
		repeated.add("D");
		repeated.add("F");

		//create adapter for repeated courses
		final ArrayAdapter<String> repeatAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, repeated);
		repeatAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//Attach repeated courses to adapter
		after1.setAdapter(repeatAdapter);
		after2.setAdapter(repeatAdapter);
		after3.setAdapter(repeatAdapter);
		after4.setAdapter(repeatAdapter);
		after5.setAdapter(repeatAdapter);
		after6.setAdapter(repeatAdapter);
		after7.setAdapter(repeatAdapter);

		Button mainbutton = (Button) findViewById(R.id.button1);
		//implement GPA calculation
		mainbutton.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {

				first = dg1 * hu1;

				second = dg2 * hu2;

				third = dg3 * hu3;

				forth = dg4 * hu4;

				fivee = dg5 * hu5;

				sixth = dg6 * hu6;

				seven = dg7 * hu7;


				hsum = hu1 + hu2 + hu3 + hu4 + hu5 + hu6 + hu7;
				sum = gn.Sum(first, second, third, forth, fivee, sixth, seven);

				gpa = sum / hsum;


				try {

					final EditText totalHours = (EditText) findViewById(R.id.editText1);
					final EditText totalGpa = (EditText) findViewById(R.id.editText2);
					String totalGpaint = totalGpa.getText().toString();
					double totalG = Double.parseDouble(totalGpaint);
					String totalHoursint = totalHours.getText().toString();
					double totalH = Double.parseDouble(totalHoursint);
					if (totalG <= 4.0) {
						affirst = first - (af1 * hu1);
						afsecond = second - (af2 * hu2);
						afthird = third - (af3 * hu3);
						afforth = forth - (af4 * hu4);
						affifth = fivee - (af5 * hu5);
						afsixth = sixth - (af6 * hu6);
						afseven = seven - (af7 * hu7);

						totalsum =
								gn.Sum(affirst, afsecond, afthird, afforth, affifth, afsixth, afseven);

						points = totalG * totalH;
						points += totalsum;
						totalH += totalHourses;
						credits = totalH + hsum;

						genralNewGpa = gn.round2d(points / credits);

						String msg = "";


						if (genralNewGpa > 3.50) msg = getResources().getString(R.string.excellent);
						else if (genralNewGpa > 3.00 && genralNewGpa < 3.49)
							msg = getResources().getString(R.string.very_good);
						else if (genralNewGpa > 2.50 && genralNewGpa < 2.99)
							msg = getResources().getString(R.string.good);
						else if (genralNewGpa > 2.00 && genralNewGpa < 2.49)
							msg = getResources().getString(R.string.acceptable);
						else if (genralNewGpa > 1.00 && genralNewGpa < 1.99)
							msg = getResources().getString(R.string.under_observation);
						else if (genralNewGpa > 0.00 && genralNewGpa < 0.99)
							msg = getResources().getString(R.string.under_observation);

						final DecimalFormatSymbols decimalSymbol = new DecimalFormatSymbols(Locale.US);
						DecimalFormat d = new DecimalFormat();
						d.setDecimalFormatSymbols(decimalSymbol);
						AlertDialog totgpa = new AlertDialog.Builder(RepeatedCourses.this).create();

						totgpa.setTitle(R.string.general_gpa);
						d.setMaximumFractionDigits(2);
						int cr = (int) (credits);
						totgpa.setMessage(getResources().getString(R.string.your_semester_gpa) + d.format(gpa) + "\n"+getResources().getString(R.string.total_hours) + hsum + "\n"+getResources().getString(R.string.general_gpa) + d.format(genralNewGpa) + msg + "\n"+getResources().getString(R.string.total_hours) + cr);

						totgpa.setButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {

							@Override
							public void onClick(final DialogInterface ok, final int which) {
								totalHourses = 0;
								gpa = 0;
								genralNewGpa = 0;
								points = 0;
								credits = 0;
								sum = 0;
								hsum = 0;


								degree1.setSelection(0);
								degree2.setSelection(0);
								degree3.setSelection(0);
								degree4.setSelection(0);
								degree5.setSelection(0);
								degree6.setSelection(0);
								degree7.setSelection(0);

								hours1.setSelection(0);
								hours2.setSelection(0);
								hours3.setSelection(0);
								hours4.setSelection(0);
								hours5.setSelection(0);
								hours6.setSelection(0);
								hours7.setSelection(0);

								after1.setSelection(0);
								after2.setSelection(0);
								after3.setSelection(0);
								after4.setSelection(0);
								after5.setSelection(0);
								after6.setSelection(0);
								after7.setSelection(0);

								af1 = 0;
								af2 = 0;
								af3 = 0;
								af4 = 0;
								af5 = 0;
								af6 = 0;
								af7 = 0;

								dg1 = 0;
								dg2 = 0;
								dg3 = 0;
								dg4 = 0;
								dg5 = 0;
								dg6 = 0;
								dg7 = 0;

								hu1 = 0;
								hu2 = 0;
								hu3 = 0;
								hu4 = 0;
								hu5 = 0;
								hu6 = 0;
								hu7 = 0;

								totalHours.setText("");
								totalGpa.setText("");

								ok.cancel();
							}
						});
						totgpa.show();
					} else {
						Toast.makeText(getBaseContext(), getResources().getString(R.string.big_gpa), Toast.LENGTH_LONG).show();
					}
				} catch (Exception e) {
					Toast.makeText(getBaseContext(), getResources().getString(R.string.fill_blanks), Toast.LENGTH_LONG).show();
				}

			}

		});


	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
							   long id) {

		switch (parent.getId()) {

			case R.id.spinner1:
				String h1 = parent.getItemAtPosition(position).toString();
				if (h1.equals("0")) huo1 = false;
				else if (h1.equals("2")) hu1 = 2;
				else if (h1.equals("3")) hu1 = 3;
				else if (h1.equals("4")) hu1 = 4;
				else if (h1.equals("5")) hu1 = 5;
				break;

			case R.id.spinner4:
				String h2 = parent.getItemAtPosition(position).toString();
				if (h2.equals("0")) huo2 = false;
				else if (h2.equals("2")) hu2 = 2;
				else if (h2.equals("3")) hu2 = 3;
				else if (h2.equals("4")) hu2 = 4;
				else if (h2.equals("5")) hu2 = 5;
				break;

			case R.id.spinner7:
				String h3 = parent.getItemAtPosition(position).toString();
				if (h3.equals("0")) huo3 = false;
				else if (h3.equals("2")) hu3 = 2;
				else if (h3.equals("3")) hu3 = 3;
				else if (h3.equals("4")) hu3 = 4;
				else if (h3.equals("5")) hu3 = 5;
				break;

			case R.id.spinner10:
				String h4 = parent.getItemAtPosition(position).toString();
				if (h4.equals("0")) huo4 = false;
				else if (h4.equals("2")) hu4 = 2;
				else if (h4.equals("3")) hu4 = 3;
				else if (h4.equals("4")) hu4 = 4;
				else if (h4.equals("5")) hu4 = 5;
				break;

			case R.id.spinner13:
				String h5 = parent.getItemAtPosition(position).toString();
				if (h5.equals("0")) huo5 = false;
				else if (h5.equals("2")) hu5 = 2;
				else if (h5.equals("3")) hu5 = 3;
				else if (h5.equals("4")) hu5 = 4;
				else if (h5.equals("5")) hu5 = 5;
				break;

			case R.id.spinner16:
				String h6 = parent.getItemAtPosition(position).toString();
				if (h6.equals("0")) huo6 = false;
				else if (h6.equals("2")) hu6 = 2;
				else if (h6.equals("3")) hu6 = 3;
				else if (h6.equals("4")) hu6 = 4;
				else if (h6.equals("5")) hu6 = 5;
				break;
			case R.id.spinner19:
				String h7 = parent.getItemAtPosition(position).toString();
				if (h7.equals("0")) huo1 = false;
				else if (h7.equals("2")) hu7 = 2;
				else if (h7.equals("3")) hu7 = 3;
				else if (h7.equals("4")) hu7 = 4;
				else if (h7.equals("5")) hu7 = 5;
				break;

			case R.id.spinner2:
				String d1 = parent.getItemAtPosition(position).toString();
				if (d1.equals("0")) dgr1 = false;
				else if (d1.equals("A")) dg1 = 4;
				else if (d1.equals("A-")) dg1 = 3.7;
				else if (d1.equals("B+")) dg1 = 3.3;
				else if (d1.equals("B")) dg1 = 3;
				else if (d1.equals("B-")) dg1 = 2.7;
				else if (d1.equals("C+")) dg1 = 2.3;
				else if (d1.equals("C")) dg1 = 2;
				else if (d1.equals("C-")) dg1 = 1.7;
				else if (d1.equals("D+")) dg1 = 1.3;
				else if (d1.equals("D")) dg1 = 1;
				else if (d1.equals("F")) dg1 = 0;
				break;

			case R.id.spinner5:
				String d2 = parent.getItemAtPosition(position).toString();
				if (d2.equals("0")) dgr2 = false;
				else if (d2.equals("A")) dg2 = 4;
				else if (d2.equals("A-")) dg2 = 3.7;
				else if (d2.equals("B+")) dg2 = 3.3;
				else if (d2.equals("B")) dg2 = 3;
				else if (d2.equals("B-")) dg2 = 2.7;
				else if (d2.equals("C+")) dg2 = 2.3;
				else if (d2.equals("C")) dg2 = 2;
				else if (d2.equals("C-")) dg2 = 1.7;
				else if (d2.equals("D+")) dg2 = 1.3;
				else if (d2.equals("D")) dg2 = 1;
				else if (d2.equals("F")) dg2 = 0;
				break;

			case R.id.spinner8:
				String d3 = parent.getItemAtPosition(position).toString();
				if (d3.equals("0")) dgr3 = false;
				else if (d3.equals("A")) dg3 = 4;
				else if (d3.equals("A-")) dg3 = 3.7;
				else if (d3.equals("B+")) dg3 = 3.3;
				else if (d3.equals("B")) dg3 = 3;
				else if (d3.equals("B-")) dg3 = 2.7;
				else if (d3.equals("C+")) dg3 = 2.3;
				else if (d3.equals("C")) dg3 = 2;
				else if (d3.equals("C-")) dg3 = 1.7;
				else if (d3.equals("D+")) dg3 = 1.3;
				else if (d3.equals("D")) dg3 = 1;
				else if (d3.equals("F")) dg3 = 0;
				break;
			case R.id.spinner11:
				String d4 = parent.getItemAtPosition(position).toString();
				if (d4.equals("0")) dgr4 = false;
				else if (d4.equals("A")) dg4 = 4;
				else if (d4.equals("A-")) dg4 = 3.7;
				else if (d4.equals("B+")) dg4 = 3.3;
				else if (d4.equals("B")) dg4 = 3;
				else if (d4.equals("B-")) dg4 = 2.7;
				else if (d4.equals("C+")) dg4 = 2.3;
				else if (d4.equals("C")) dg4 = 2;
				else if (d4.equals("C-")) dg4 = 1.7;
				else if (d4.equals("D+")) dg4 = 1.3;
				else if (d4.equals("D")) dg4 = 1;
				else if (d4.equals("F")) dg4 = 0;
				break;
			case R.id.spinner14:
				String d5 = parent.getItemAtPosition(position).toString();
				if (d5.equals("0")) dgr5 = false;
				else if (d5.equals("A")) dg5 = 4;
				else if (d5.equals("A-")) dg5 = 3.7;
				else if (d5.equals("B+")) dg5 = 3.3;
				else if (d5.equals("B")) dg5 = 3;
				else if (d5.equals("B-")) dg5 = 2.7;
				else if (d5.equals("C+")) dg5 = 2.3;
				else if (d5.equals("C")) dg5 = 2;
				else if (d5.equals("C-")) dg5 = 1.7;
				else if (d5.equals("D+")) dg5 = 1.3;
				else if (d5.equals("D")) dg5 = 1;
				else if (d5.equals("F")) dg5 = 0;
				break;

			case R.id.spinner17:
				String d6 = parent.getItemAtPosition(position).toString();
				if (d6.equals("0")) dgr6 = false;
				else if (d6.equals("A")) dg6 = 4;
				else if (d6.equals("A-")) dg6 = 3.7;
				else if (d6.equals("B+")) dg6 = 3.3;
				else if (d6.equals("B")) dg6 = 3;
				else if (d6.equals("B-")) dg6 = 2.7;
				else if (d6.equals("C+")) dg6 = 2.3;
				else if (d6.equals("C")) dg6 = 2;
				else if (d6.equals("C-")) dg6 = 1.7;
				else if (d6.equals("D+")) dg6 = 1.3;
				else if (d6.equals("D")) dg6 = 1;
				else if (d6.equals("F")) dg6 = 0;
				break;

			case R.id.spinner20:
				String d7 = parent.getItemAtPosition(position).toString();
				if (d7.equals("0")) dgr7 = false;
				else if (d7.equals("A")) dg7 = 4;
				else if (d7.equals("A-")) dg7 = 3.7;
				else if (d7.equals("B+")) dg7 = 3.3;
				else if (d7.equals("B")) dg7 = 3;
				else if (d7.equals("B-")) dg7 = 2.7;
				else if (d7.equals("C+")) dg7 = 2.3;
				else if (d7.equals("C")) dg7 = 2;
				else if (d7.equals("C-")) dg7 = 1.7;
				else if (d7.equals("D+")) dg7 = 1.3;
				else if (d7.equals("D")) dg7 = 1;
				else if (d7.equals("F")) dg7 = 0;
				break;

			case R.id.spinner3:
				String a1 = parent.getItemAtPosition(position).toString();

				if (a1.equals("0")) {
					aft1 = false;
				} else {
					totalHourses -= hu1;
				}

				if (a1.equals("A")) af1 = 4;
				else if (a1.equals("A-")) af1 = 3.7;
				else if (a1.equals("B+")) af1 = 3.3;
				else if (a1.equals("B")) af1 = 3;
				else if (a1.equals("B-")) af1 = 2.7;
				else if (a1.equals("C+")) af1 = 2.3;
				else if (a1.equals("C")) af1 = 2;
				else if (a1.equals("C-")) af1 = 1.7;
				else if (a1.equals("D+")) af1 = 1.3;
				else if (a1.equals("D")) af1 = 1;
				else if (a1.equals("F")) af1 = 0;
				break;
			case R.id.spinner6:
				String a2 = parent.getItemAtPosition(position).toString();

				if (a2.equals("0")) {
					aft2 = false;
				} else {
					totalHourses -= hu2;
				}
				if (a2.equals("A")) af2 = 4;
				else if (a2.equals("A-")) af2 = 3.7;
				else if (a2.equals("B+")) af2 = 3.3;
				else if (a2.equals("B")) af2 = 3;
				else if (a2.equals("B-")) af2 = 2.7;
				else if (a2.equals("C+")) af2 = 2.3;
				else if (a2.equals("C")) af2 = 2;
				else if (a2.equals("C-")) af2 = 1.7;
				else if (a2.equals("D+")) af2 = 1.3;
				else if (a2.equals("D")) af2 = 1;
				else if (a2.equals("F")) af2 = 0;
				break;
			case R.id.spinner9:
				String a3 = parent.getItemAtPosition(position).toString();

				if (a3.equals("0")) {
					aft3 = false;
				} else {
					totalHourses -= hu3;
				}
				if (a3.equals("A")) af3 = 4;
				else if (a3.equals("A-")) af3 = 3.7;
				else if (a3.equals("B+")) af3 = 3.3;
				else if (a3.equals("B")) af3 = 3;
				else if (a3.equals("B-")) af3 = 2.7;
				else if (a3.equals("C+")) af3 = 2.3;
				else if (a3.equals("C")) af3 = 2;
				else if (a3.equals("C-")) af3 = 1.7;
				else if (a3.equals("D+")) af3 = 1.3;
				else if (a3.equals("D")) af3 = 1;
				else if (a3.equals("F")) af3 = 0;
				break;
			case R.id.spinner12:

				String a4 = parent.getItemAtPosition(position).toString();
				if (a4.equals("0")) {
					aft4 = false;
				} else {
					totalHourses -= hu4;
				}

				if (a4.equals("A")) af4 = 4;
				else if (a4.equals("A-")) af4 = 3.7;
				else if (a4.equals("B+")) af4 = 3.3;
				else if (a4.equals("B")) af4 = 3;
				else if (a4.equals("B-")) af4 = 2.7;
				else if (a4.equals("C+")) af4 = 2.3;
				else if (a4.equals("C")) af4 = 2;
				else if (a4.equals("C-")) af4 = 1.7;
				else if (a4.equals("D+")) af4 = 1.3;
				else if (a4.equals("D")) af4 = 1;
				else if (a4.equals("F")) af4 = 0;
				break;
			case R.id.spinner15:
				String a5 = parent.getItemAtPosition(position).toString();

				if (a5.equals("0")) {
					aft5 = false;
				} else {
					totalHourses -= hu5;
				}

				if (a5.equals("A")) af5 = 4;
				else if (a5.equals("A-")) af5 = 3.7;
				else if (a5.equals("B+")) af5 = 3.3;
				else if (a5.equals("B")) af5 = 3;
				else if (a5.equals("B-")) af5 = 2.7;
				else if (a5.equals("C+")) af5 = 2.3;
				else if (a5.equals("C")) af5 = 2;
				else if (a5.equals("C-")) af5 = 1.7;
				else if (a5.equals("D+")) af5 = 1.3;
				else if (a5.equals("D")) af5 = 1;
				else if (a5.equals("F")) af5 = 0;
				break;
			case R.id.spinner18:
				String a6 = parent.getItemAtPosition(position).toString();

				if (a6.equals("0")) {
					aft6 = false;
				} else {
					totalHourses -= hu6;
				}

				if (a6.equals("A")) af6 = 4;
				else if (a6.equals("A-")) af6 = 3.7;
				else if (a6.equals("B+")) af6 = 3.3;
				else if (a6.equals("B")) af6 = 3;
				else if (a6.equals("B-")) af6 = 2.7;
				else if (a6.equals("C+")) af6 = 2.3;
				else if (a6.equals("C")) af6 = 2;
				else if (a6.equals("C-")) af6 = 1.7;
				else if (a6.equals("D+")) af6 = 1.3;
				else if (a6.equals("D")) af6 = 1;
				else if (a6.equals("F")) af6 = 0;
				break;
			case R.id.spinner21:
				String a7 = parent.getItemAtPosition(position).toString();

				if (a7.equals("0")) {
					aft7 = false;
				} else {
					totalHourses -= hu7;
				}

				if (a7.equals("A")) af7 = 4;
				else if (a7.equals("A-")) af7 = 3.7;
				else if (a7.equals("B+")) af7 = 3.3;
				else if (a7.equals("B")) af7 = 3;
				else if (a7.equals("B-")) af7 = 2.7;
				else if (a7.equals("C+")) af7 = 2.3;
				else if (a7.equals("C")) af7 = 2;
				else if (a7.equals("C-")) af7 = 1.7;
				else if (a7.equals("D+")) af7 = 1.3;
				else if (a7.equals("D")) af7 = 1;
				else if (a7.equals("F")) af7 = 0;
				break;
		}


	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:

				finish();
				return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}



}

