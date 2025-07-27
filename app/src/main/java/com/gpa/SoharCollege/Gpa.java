package com.gpa.SoharCollege;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Gpa extends AppCompatActivity implements OnItemSelectedListener {
	
	double dg1,dg2,dg3,dg4,dg5,dg6,dg7,dg8,dg9,dg10;
	int hu1,hu2,hu3,hu4,hu5,hu6,hu7,hu8,hu9,hu10,hsum;
	double first,second,third,forth,fivee,sixth,sevnth,eigth,nine,ten;
	double sum;
	double gpa;
	double credits;
	double points;

	int course;

	TextView txt1, txt2, txt3, txt4, txt5;
	Button btn1, btn2;
	GeneralFunctions gn=new GeneralFunctions();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gpa_calculator);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
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
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		if(Locale.getDefault().getLanguage() == "ar"){
			gn.setLocale("ar",getApplicationContext());
			gn.SetFontTypeFace(txt1, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt2, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt3, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt4, "face2", getApplicationContext());
			gn.SetFontTypeFace(txt5, "face2", getApplicationContext());
			gn.SetFontTypeFace(btn1, "face2", getApplicationContext());
			gn.SetFontTypeFace(btn2, "face2", getApplicationContext());
			getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

		}
		else{
			gn.SetFontTypeFace(txt1, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt2, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt3, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt4, "face3", getApplicationContext());
			gn.SetFontTypeFace(txt5, "face3", getApplicationContext());
			gn.SetFontTypeFace(btn1, "face3", getApplicationContext());
			gn.SetFontTypeFace(btn2, "face3", getApplicationContext());
			getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
		}

		Bundle bundle = getIntent().getExtras();
		final String courses = bundle.getString("Courses");
		course = Integer.parseInt(courses);
		Toast.makeText(getApplicationContext(),getResources().getString(R.string.num_course)+" " +courses,Toast.LENGTH_LONG).show();
		Spinner degree1=(Spinner)findViewById(R.id.spinner1);
		Spinner hours1=(Spinner)findViewById(R.id.spinner2);
		Spinner degree2=(Spinner)findViewById(R.id.spinner3);
		Spinner hours2=(Spinner)findViewById(R.id.spinner4);
		Spinner degree3=(Spinner)findViewById(R.id.spinner5);
		Spinner hours3=(Spinner)findViewById(R.id.spinner6);
		Spinner degree4=(Spinner)findViewById(R.id.spinner7);
		Spinner hours4=(Spinner)findViewById(R.id.spinner8);
		Spinner degree5=(Spinner)findViewById(R.id.spinner9);
		Spinner hours5=(Spinner)findViewById(R.id.spinner10);
		Spinner degree6=(Spinner)findViewById(R.id.spinner11);
		Spinner hours6=(Spinner)findViewById(R.id.spinner12);
		Spinner degree7=(Spinner)findViewById(R.id.spinner13);
		Spinner hours7=(Spinner)findViewById(R.id.spinner14);
		Spinner degree8=(Spinner)findViewById(R.id.spinner15);
		Spinner hours8=(Spinner)findViewById(R.id.spinner16);
		Spinner degree9=(Spinner)findViewById(R.id.spinner17);
		Spinner hours9=(Spinner)findViewById(R.id.spinner18);
		Spinner degree10=(Spinner)findViewById(R.id.spinner19);
		Spinner hours10=(Spinner)findViewById(R.id.spinner20);


		
		degree1.setOnItemSelectedListener(this);
		degree2.setOnItemSelectedListener(this);
		degree3.setOnItemSelectedListener(this);
		degree4.setOnItemSelectedListener(this);
		degree5.setOnItemSelectedListener(this);
		degree6.setOnItemSelectedListener(this);
		degree7.setOnItemSelectedListener(this);
		degree8.setOnItemSelectedListener(this);
		degree9.setOnItemSelectedListener(this);
		degree10.setOnItemSelectedListener(this);

		hours1.setOnItemSelectedListener(this);
		hours2.setOnItemSelectedListener(this);
		hours3.setOnItemSelectedListener(this);
		hours4.setOnItemSelectedListener(this);
		hours5.setOnItemSelectedListener(this);
		hours6.setOnItemSelectedListener(this);
		hours7.setOnItemSelectedListener(this);
		hours8.setOnItemSelectedListener(this);
		hours9.setOnItemSelectedListener(this);
		hours10.setOnItemSelectedListener(this);

		// spinner drop down hours
		List<String> hours=new ArrayList<String>();
		hours.add("1");
		hours.add("2");
        hours.add("3");
        hours.add("4");
		hours.add("5");
		hours.add("6");

		//creating adapter for spinner
		ArrayAdapter<String> hoursAdapter=new ArrayAdapter<String>(this, 
		android.R.layout.simple_spinner_item,hours);
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
		hours8.setAdapter(hoursAdapter);
		hours9.setAdapter(hoursAdapter);
		hours10.setAdapter(hoursAdapter);
		//Spinner Drop down degrees
        List<String> degree = new ArrayList<String>();
        degree.add("A");
        degree.add("A-");
        degree.add("B+");
        degree.add("B");
        degree.add("B-");
        degree.add("C+");
        degree.add("C");
        degree.add("C-");
        degree.add("D+");
        degree.add("D");
        degree.add("F");
        // Creating adapter for spinner
        ArrayAdapter<String> degreeAdapter = new ArrayAdapter<String>
        (this, android.R.layout.simple_spinner_item, degree);
       // Drop down layout style - list view with radio button
        degreeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       // attaching data adapter to spinner
       degree1.setAdapter(degreeAdapter);
       degree2.setAdapter(degreeAdapter);
       degree3.setAdapter(degreeAdapter);
       degree4.setAdapter(degreeAdapter);
       degree5.setAdapter(degreeAdapter);
       degree6.setAdapter(degreeAdapter);
	   degree7.setAdapter(degreeAdapter);
	   degree8.setAdapter(degreeAdapter);
	   degree9.setAdapter(degreeAdapter);
	   degree10.setAdapter(degreeAdapter);

		switch (course) {
			case 1:
				degree2.setVisibility(View.GONE);
				hours2.setVisibility(View.GONE);
				degree3.setVisibility(View.GONE);
				hours3.setVisibility(View.GONE);
				degree4.setVisibility(View.GONE);
				hours4.setVisibility(View.GONE);
				degree5.setVisibility(View.GONE);
				hours5.setVisibility(View.GONE);
				degree6.setVisibility(View.GONE);
				hours6.setVisibility(View.GONE);
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;

			case 2:

				degree3.setVisibility(View.GONE);
				hours3.setVisibility(View.GONE);
				degree4.setVisibility(View.GONE);
				hours4.setVisibility(View.GONE);
				degree5.setVisibility(View.GONE);
				hours5.setVisibility(View.GONE);
				degree6.setVisibility(View.GONE);
				hours6.setVisibility(View.GONE);
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 3:

				degree4.setVisibility(View.GONE);
				hours4.setVisibility(View.GONE);
				degree5.setVisibility(View.GONE);
				hours5.setVisibility(View.GONE);
				degree6.setVisibility(View.GONE);
				hours6.setVisibility(View.GONE);
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 4:

				degree5.setVisibility(View.GONE);
				hours5.setVisibility(View.GONE);
				degree6.setVisibility(View.GONE);
				hours6.setVisibility(View.GONE);
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 5:

				degree6.setVisibility(View.GONE);
				hours6.setVisibility(View.GONE);
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 6:
				degree7.setVisibility(View.GONE);
				hours7.setVisibility(View.GONE);
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 7:
				degree8.setVisibility(View.GONE);
				hours8.setVisibility(View.GONE);
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
				break;
			case 8:
				degree9.setVisibility(View.GONE);
				hours9.setVisibility(View.GONE);
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
			case 9:
				degree10.setVisibility(View.GONE);
				hours10.setVisibility(View.GONE);
			case 10:
				break;
			default:
				Toast.makeText(getApplicationContext(),"There is error, try again!",Toast.LENGTH_LONG).show();
				break;


		}

		final DecimalFormatSymbols decimalSymbol = new DecimalFormatSymbols(Locale.US);
		DecimalFormat d = new DecimalFormat();
		d.setDecimalFormatSymbols(decimalSymbol);
	   btn1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				gpa = gn.SemesterGpa(sum / hsum);
				d.setMaximumFractionDigits(2);
				AlertDialog semester_gpa = new AlertDialog.Builder(Gpa.this).create();
				semester_gpa.setTitle(R.string.semester_gpa);
				String msg = getResources().getString(R.string.your_semester_gpa) +" "+ d.format(gpa)
						+ "\n" + getResources().getString(R.string.total_hours)+" "+ + hsum;
				semester_gpa.setMessage(msg);
				semester_gpa.setButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {

					@Override
					public void onClick(final DialogInterface ok, final int which) {
						ok.cancel();
					}
				});
				semester_gpa.show();




			}
		});
	   btn2.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {

                try {
                    EditText totalHours = (EditText) findViewById(R.id.editText1);
                    EditText totalGpa = (EditText) findViewById(R.id.editText2);
                    String totalGpaint = totalGpa.getText().toString();
                    double totalG = Double.parseDouble(totalGpaint);
                    String totalHoursint = totalHours.getText().toString();
                    double totalH = Double.parseDouble(totalHoursint);
                    if (totalG <= 4.0) {
                        //Multiply general gpa with general hours
                        points = totalG * totalH;
                        points += sum;
                        credits = totalH + hsum;
                        double genralNewGpa = gn.round2d(points / credits);

                        String msg = "";


                            if (genralNewGpa >= 3.50) msg = getResources().getString(R.string.excellent);
                            else if (genralNewGpa >= 3.00 && genralNewGpa <= 3.49) msg = getResources().getString(R.string.very_good);
                            else if (genralNewGpa >= 2.50 && genralNewGpa <= 2.99) msg = getResources().getString(R.string.good);
                            else if (genralNewGpa >= 2.00 && genralNewGpa <= 2.49) msg = getResources().getString(R.string.acceptable);
                            else if (genralNewGpa >= 1.00 && genralNewGpa <= 1.99)
                                msg = getResources().getString(R.string.under_observation);
                            else if (genralNewGpa >= 0.00 && genralNewGpa <= 0.99)
                                msg = getResources().getString(R.string.under_observation);

                            AlertDialog totgpa = new AlertDialog.Builder(Gpa.this).create();
                            totgpa.setTitle(R.string.general_gpa);
                            d.setMaximumFractionDigits(2);
                            int cr = (int) (credits);
                            totgpa.setMessage(getResources().getString(R.string.point_average) + d.format(genralNewGpa) + msg + getResources().getString(R.string.token_hours) + cr);
                            totgpa.setButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(final DialogInterface ok, final int which) {
                                    ok.cancel();
                                }
                            });
                            totgpa.show();

                    }
                    else {
                        Toast.makeText(getBaseContext(), "Gpa error!", Toast.LENGTH_SHORT).show();
                    }

                }catch(Exception e){
                    Toast.makeText(getBaseContext(),getResources().getString(R.string.fill_blanks), Toast.LENGTH_LONG).show();
                }
   		}
   	});
   }
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		
		switch(parent.getId()){
		case R.id.spinner1:
			String d1=parent.getItemAtPosition(position).toString();
			
			if(d1.equals("A"))dg1=4;
			else if(d1.equals("A-"))dg1=3.7;
			else if(d1.equals("B+"))dg1=3.3;
			else if(d1.equals("B"))dg1=3;
			else if(d1.equals("B-"))dg1=2.7;
			else if(d1.equals("C+"))dg1=2.3;
			else if(d1.equals("C"))dg1=2;
			else if(d1.equals("C-"))dg1=1.7;
			else if(d1.equals("D+"))dg1=1.3;
			else if(d1.equals("D"))dg1=1;
			else if(d1.equals("F"))dg1=0;
			break;
		case R.id.spinner3:
			String d2=parent.getItemAtPosition(position).toString();
			
			if(d2.equals("A"))dg2=4;
			else if(d2.equals("A-"))dg2=3.7;
			else if(d2.equals("B+"))dg2=3.3;
			else if(d2.equals("B"))dg2=3;
			else if(d2.equals("B-"))dg2=2.7;
			else if(d2.equals("C+"))dg2=2.3;
			else if(d2.equals("C"))dg2=2;
			else if(d2.equals("C-"))dg2=1.7;
			else if(d2.equals("D+"))dg2=1.3;
			else if(d2.equals("D"))dg2=1;
			else if(d2.equals("F"))dg2=0;
			break;
		
		case R.id.spinner2:
			String h1=parent.getItemAtPosition(position).toString();

            if(h1.equals("1"))hu1=1;
			else if(h1.equals("2"))hu1=2;
			else if(h1.equals("3"))hu1=3;
            else if(h1.equals("4"))hu1=4;
			else if(h1.equals("5"))hu1=5;
			else if(h1.equals("6"))hu1=6;
			break;
		case R.id.spinner4:
			String h2=parent.getItemAtPosition(position).toString();

            if(h2.equals("1"))hu2=1;
			else if(h2.equals("2"))hu2=2;
			else if(h2.equals("3"))hu2=3;
            else if(h2.equals("4"))hu2=4;
			else if(h2.equals("5"))hu2=5;
			else if(h2.equals("6"))hu2=6;
			break;
			
		case R.id.spinner5:
         String d3=parent.getItemAtPosition(position).toString();
			
			if(d3.equals("A"))dg3=4;
			else if(d3.equals("A-"))dg3=3.7;
			else if(d3.equals("B+"))dg3=3.3;
			else if(d3.equals("B"))dg3=3;
			else if(d3.equals("B-"))dg3=2.7;
			else if(d3.equals("C+"))dg3=2.3;
			else if(d3.equals("C"))dg3=2;
			else if(d3.equals("C-"))dg3=1.7;
			else if(d3.equals("D+"))dg3=1.3;
			else if(d3.equals("D"))dg3=1;
			else if(d3.equals("F"))dg3=0;
			break;
			
		case R.id.spinner6:
         String h3=parent.getItemAtPosition(position).toString();

            if(h3.equals("1"))hu3=1;
			else if(h3.equals("2"))hu3=2;
			else if(h3.equals("3"))hu3=3;
            else if(h3.equals("4"))hu3=4;
			else if(h3.equals("5"))hu3=5;
			else if(h3.equals("6"))hu3=6;
			break;
		case R.id.spinner7:
			 String d4=parent.getItemAtPosition(position).toString();
				
				if(d4.equals("A"))dg4=4;
				else if(d4.equals("A-"))dg4=3.7;
				else if(d4.equals("B+"))dg4=3.3;
				else if(d4.equals("B"))dg4=3;
				else if(d4.equals("B-"))dg4=2.7;
				else if(d4.equals("C+"))dg4=2.3;
				else if(d4.equals("C"))dg4=2;
				else if(d4.equals("C-"))dg4=1.7;
				else if(d4.equals("D+"))dg4=1.3;
				else if(d4.equals("D"))dg4=1;
				else if(d4.equals("F"))dg4=0;
				break;
		case R.id.spinner8:
            String h4=parent.getItemAtPosition(position).toString();

            if(h4.equals("1"))hu4=1;
			else if(h4.equals("2"))hu4=2;
			else if(h4.equals("3"))hu4=3;
            else if(h4.equals("4"))hu4=4;
			else if(h4.equals("5"))hu4=5;
			else if(h4.equals("6"))hu4=6;
			break;
		case R.id.spinner9:
			String d5=parent.getItemAtPosition(position).toString();
			
			if(d5.equals("A"))dg5=4;
			else if(d5.equals("A-"))dg5=3.7;
			else if(d5.equals("B+"))dg5=3.3;
			else if(d5.equals("B"))dg5=3;
			else if(d5.equals("B-"))dg5=2.7;
			else if(d5.equals("C+"))dg5=2.3;
			else if(d5.equals("C"))dg5=2;
			else if(d5.equals("C-"))dg5=1.7;
			else if(d5.equals("D+"))dg5=1.3;
			else if(d5.equals("D"))dg5=1;
			else if(d5.equals("F"))dg5=0;
			break;
		case R.id.spinner10:
            String h5=parent.getItemAtPosition(position).toString();

            if(h5.equals("1"))hu5=1;
			else if(h5.equals("2"))hu5=2;
			else if(h5.equals("3"))hu5=3;
            else if(h5.equals("4"))hu5=4;
			else if(h5.equals("5"))hu5=5;
			else if(h5.equals("6"))hu5=6;
			break;
		case R.id.spinner11:
         String d6=parent.getItemAtPosition(position).toString();
 			
			if(d6.equals("A"))dg6=4;
			else if(d6.equals("A-"))dg6=3.7;
			else if(d6.equals("B+"))dg6=3.3;
			else if(d6.equals("B"))dg6=3;
			else if(d6.equals("B-"))dg6=2.7;
			else if(d6.equals("C+"))dg6=2.3;
			else if(d6.equals("C"))dg6=2;
			else if(d6.equals("C-"))dg6=1.7;
			else if(d6.equals("D+"))dg6=1.3;
			else if(d6.equals("D"))dg6=1;
			else if(d6.equals("F"))dg6=0;
			break;
		case R.id.spinner12:
            String h6=parent.getItemAtPosition(position).toString();

            if(h6.equals("1"))hu6=1;
			else if(h6.equals("2"))hu6=2;
			else if(h6.equals("3"))hu6=3;
            else if(h6.equals("4"))hu6=4;
			else if(h6.equals("5"))hu6=5;
			else if(h6.equals("6"))hu6=6;
			break;
		case R.id.spinner13:
          String d7=parent.getItemAtPosition(position).toString();
 			
			if(d7.equals("A"))dg7=4;
			else if(d7.equals("A-"))dg7=3.7;
			else if(d7.equals("B+"))dg7=3.3;
			else if(d7.equals("B"))dg7=3;
			else if(d7.equals("B-"))dg7=2.7;
			else if(d7.equals("C+"))dg7=2.3;
			else if(d7.equals("C"))dg7=2;
			else if(d7.equals("C-"))dg7=1.7;
			else if(d7.equals("D+"))dg7=1.3;
			else if(d7.equals("D"))dg7=1;
			else if(d7.equals("F"))dg7=0;
			break;
		case R.id.spinner14:
            String h7=parent.getItemAtPosition(position).toString();
			
			if(h7.equals("1"))hu7=1;
			else if(h7.equals("2"))hu7=2;
			else if(h7.equals("3"))hu7=3;
			else if(h7.equals("4"))hu7=4;
			else if(h7.equals("5"))hu7=5;
			else if(h7.equals("6"))hu7=6;
			break;

			case R.id.spinner15:
				String d8=parent.getItemAtPosition(position).toString();

				if(d8.equals("A"))dg8=4;
				else if(d8.equals("A-"))dg8=3.7;
				else if(d8.equals("B+"))dg8=3.3;
				else if(d8.equals("B"))dg8=3;
				else if(d8.equals("B-"))dg8=2.7;
				else if(d8.equals("C+"))dg8=2.3;
				else if(d8.equals("C"))dg8=2;
				else if(d8.equals("C-"))dg8=1.7;
				else if(d8.equals("D+"))dg8=1.3;
				else if(d8.equals("D"))dg8=1;
				else if(d8.equals("F"))dg8=0;
				break;
			case R.id.spinner16:
				String h8=parent.getItemAtPosition(position).toString();

				if(h8.equals("1"))hu8=1;
				else if(h8.equals("2"))hu8=2;
				else if(h8.equals("3"))hu8=3;
				else if(h8.equals("4"))hu8=4;
				else if(h8.equals("5"))hu8=5;
				else if(h8.equals("6"))hu8=6;
				break;

			case R.id.spinner17:
				String d9=parent.getItemAtPosition(position).toString();

				if(d9.equals("A"))dg9=4;
				else if(d9.equals("A-"))dg9=3.7;
				else if(d9.equals("B+"))dg9=3.3;
				else if(d9.equals("B"))dg9=3;
				else if(d9.equals("B-"))dg9=2.7;
				else if(d9.equals("C+"))dg9=2.3;
				else if(d9.equals("C"))dg9=2;
				else if(d9.equals("C-"))dg9=1.7;
				else if(d9.equals("D+"))dg9=1.3;
				else if(d9.equals("D"))dg9=1;
				else if(d9.equals("F"))dg9=0;
				break;
			case R.id.spinner18:
				String h9=parent.getItemAtPosition(position).toString();

				if(h9.equals("1"))hu9=1;
				else if(h9.equals("2"))hu9=2;
				else if(h9.equals("3"))hu9=3;
				else if(h9.equals("4"))hu9=4;
				else if(h9.equals("5"))hu9=5;
				else if(h9.equals("6"))hu9=6;
				break;
			case R.id.spinner19:
				String d10=parent.getItemAtPosition(position).toString();

				if(d10.equals("A"))dg10=4;
				else if(d10.equals("A-"))dg10=3.7;
				else if(d10.equals("B+"))dg10=3.3;
				else if(d10.equals("B"))dg10=3;
				else if(d10.equals("B-"))dg10=2.7;
				else if(d10.equals("C+"))dg10=2.3;
				else if(d10.equals("C"))dg10=2;
				else if(d10.equals("C-"))dg10=1.7;
				else if(d10.equals("D+"))dg10=1.3;
				else if(d10.equals("D"))dg10=1;
				else if(d10.equals("F"))dg10=0;
				break;
			case R.id.spinner20:
				String h10=parent.getItemAtPosition(position).toString();

				if(h10.equals("1"))hu10=1;
				else if(h10.equals("2"))hu10=2;
				else if(h10.equals("3"))hu10=3;
				else if(h10.equals("4"))hu10=4;
				else if(h10.equals("5"))hu10=5;
				else if(h10.equals("6"))hu10=6;
				break;

			default:
				Toast.makeText(getBaseContext(),"Nothing selected", Toast.LENGTH_LONG).show();
				break;
		}
		if(course ==1) {
			first = dg1 * hu1;
			hsum = hu1;
			sum = first;
		}
		if(course ==2){
			first = dg1 * hu1;
			second=dg2*hu2;
			hsum = hu1+hu2;
			sum = first+second;
		}
		if(course == 3){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;

			hsum = hu1+hu2+hu3;
			sum = first+second+third;
		}
		if(course == 4){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;

			hsum = hu1+hu2+hu3+hu4;
			sum = first+second+third+forth;
		}
		if(course == 5){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;

			hsum = hu1+hu2+hu3+hu4+hu5;
			sum = first+second+third+forth+fivee;
		}
		if(course == 6){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;
			sixth=dg6*hu6;
			hsum = hu1+hu2+hu3+hu4+hu5+hu6;
			sum = first+second+third+forth+fivee+sixth;
		}
		if(course == 7){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;
			sixth=dg6*hu6;
			sevnth=dg7*hu7;
			hsum=hu1+hu2+hu3+hu4+hu5+hu6+hu7;
			sum=first+second+third+forth+fivee+sixth+sevnth;
		}
		if(course == 8){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;
			sixth=dg6*hu6;
			sevnth=dg7*hu7;
			eigth=dg8*hu8;
			hsum=hu1+hu2+hu3+hu4+hu5+hu6+hu7+hu8;
			sum=first+second+third+forth+fivee+sixth+sevnth+eigth;
		}
		if(course == 9){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;
			sixth=dg6*hu6;
			sevnth=dg7*hu7;
			eigth=dg8*hu8;
			nine=dg9*hu9;
			hsum=hu1+hu2+hu3+hu4+hu5+hu6+hu7+hu8+hu9;
			sum=first+second+third+forth+fivee+sixth+sevnth+eigth+nine;
		}
		if(course == 10){
			first = dg1 * hu1;
			second=dg2*hu2;
			third=dg3*hu3;
			forth=dg4*hu4;
			fivee=dg5*hu5;
			sixth=dg6*hu6;
			sevnth=dg7*hu7;
			eigth=dg8*hu8;
			nine=dg9*hu9;
			ten=dg10*hu10;
			hsum=hu1+hu2+hu3+hu4+hu5+hu6+hu7+hu8+hu9+hu10;
			sum=first+second+third+forth+fivee+sixth+sevnth+eigth+nine+ten;
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
