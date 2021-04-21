package com.my.filloutform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputLayout birthdate_layout;
    AutoCompleteTextView gender_TV;
    EditText birth_date, fname, lname, mname, age, gender, course_year, address1, address2, city_province, mobile_number, telephone_number, email;
    Button submit;

    String FNAME, LNAME, MNAME, AGE, GENDER, COURSE_YEAR, ADDRESS, MOBILE, TELEPHONE, EMAIL, BIRTH;

    final String key1 = "FNAME";
    final String key2 = "LNAME";
    final String key3 = "MNAME";
    final String key4 = "AGE";
    final String key5 = "GENDER";
    final String key6 = "COURSE";
    final String key7 = "ADDRESS";
    final String key8 = "MOBILE";
    final String key9 = "TELEPHONE";
    final String key10 = "EMAIL";
    final String key11 = "BIRTH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        birthdate_layout = findViewById(R.id.birthdate_layout);
        birth_date = findViewById(R.id.birth_date);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        mname = findViewById(R.id.mname);
        age = findViewById(R.id.age);
        course_year = findViewById(R.id.course);
        address1 = findViewById(R.id.address1);
        address2 = findViewById(R.id.address2);
        city_province = findViewById(R.id.address3);
        mobile_number = findViewById(R.id.phone_number);
        telephone_number = findViewById(R.id.home_number);
        email = findViewById(R.id.email);

        //Dropdown
        gender_TV = findViewById(R.id.gender);

        if (savedInstanceState != null) {
            fname.setText(savedInstanceState.getString(key1,""));
            lname.setText(savedInstanceState.getString(key2,""));
            mname.setText(savedInstanceState.getString(key3,""));
            age.setText(savedInstanceState.getString(key4,""));
            gender_TV.setText(savedInstanceState.getString(key5,""));
            course_year.setText(savedInstanceState.getString(key6,""));
            address1.setText(savedInstanceState.getString("ADDRESS1",""));
            address2.setText(savedInstanceState.getString("ADDRESS2",""));
            city_province.setText(savedInstanceState.getString("CITY",""));
            mobile_number.setText(savedInstanceState.getString(key8,""));
            telephone_number.setText(savedInstanceState.getString(key9,""));
            email.setText(savedInstanceState.getString(key10,""));
            birth_date.setText(savedInstanceState.getString(key11,""));
        }

        Bundle b = getIntent().getExtras();
        if (b != null) {
            fname.setText(b.getString(key1,""));
            lname.setText(b.getString(key2,""));
            mname.setText(b.getString(key3,""));
            age.setText(b.getString(key4,""));
            gender_TV.setText(b.getString(key5,""));
            course_year.setText(b.getString(key6,""));
            address1.setText(b.getString("ADDRESS1",""));
            address2.setText(b.getString("ADDRESS2",""));
            city_province.setText(b.getString("CITY",""));
            mobile_number.setText(b.getString(key8,""));
            telephone_number.setText(b.getString(key9,""));
            email.setText(b.getString(key10,""));
            birth_date.setText(b.getString(key11,""));
        }
        //Button
        submit = findViewById(R.id.next_button);


        ArrayList <String> items = new ArrayList<String>();
                items.add("Male");
                items.add("Female");
                items.add("Prefer not to say");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.input_layout, items);

        gender_TV.setAdapter(adapter);
        //Events
        birthdate_layout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar myCalendar = Calendar.getInstance();


                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {

                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        String myFormat = "MM/dd/yy"; //In which you need put here
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                        birth_date.setText(sdf.format(myCalendar.getTime()));
                    }

                };
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Page2.class);
                Bundle b = new Bundle();

                String add1 = address1.getText().toString();
                String add2 = address2.getText().toString();
                String add3 = city_province.getText().toString();
                DateFormat df = new SimpleDateFormat("mm/dd/yyyy");


                //Strings
                FNAME = fname.getText().toString();
                LNAME = lname.getText().toString();
                MNAME = mname.getText().toString();
                AGE = age.getText().toString();
                GENDER = gender_TV.getText().toString();
                ADDRESS = add1 + ", " + add2 + ", " + add3;
                COURSE_YEAR = course_year.getText().toString();
                EMAIL = email.getText().toString();
                MOBILE = mobile_number.getText().toString();
                TELEPHONE = telephone_number.getText().toString();
                BIRTH = birth_date.getText().toString();

                b.putString(key1, FNAME);
                b.putString(key2, LNAME);
                b.putString(key3, MNAME);
                b.putString(key4, AGE);
                b.putString(key5, GENDER);
                b.putString(key6, COURSE_YEAR);
                b.putString(key7, ADDRESS);
                b.putString(key8, MOBILE);
                b.putString(key9, TELEPHONE);
                b.putString(key10, EMAIL);
                b.putString(key11, BIRTH);
                b.putString("ADDRESS1", add1);
                b.putString("ADDRESS2", add2);
                b.putString("CITY", add3);

                i.putExtras(b);
                startActivity(i);
                finish();


            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(key1, fname.getText().toString());
        outState.putString(key2, lname.getText().toString());
        outState.putString(key3, mname.getText().toString());
        outState.putString(key4, age.getText().toString());
        outState.putString(key5, gender_TV.getText().toString());
        outState.putString(key6, course_year.getText().toString());
        outState.putString("ADDRESS1", address1.getText().toString());
        outState.putString("ADDRESS2", address2.getText().toString());
        outState.putString("CITY", city_province.getText().toString());
        outState.putString(key8,mobile_number.getText().toString());
        outState.putString(key9,telephone_number.getText().toString());
        outState.putString(key10,email.getText().toString());
        outState.putString(key11,birth_date.getText().toString());
    }
}