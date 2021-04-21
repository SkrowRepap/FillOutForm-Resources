package com.my.filloutform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Confirm extends AppCompatActivity {

    TextView birth_date, name, age, gender, course_year, address, mobile_number, telephone_number, email;
    TextView height, weight, history, guardian_name, guardian_relationship, guardian_address, guardian_contact;
    Button confirm, back;

    String FNAME, LNAME, MNAME, AGE, GENDER, COURSE_YEAR, ADDRESS, MOBILE, TELEPHONE, EMAIL, BIRTH;
    String HEIGHT, WEIGHT, HISTORY, GUARDIAN_NAME, GUARDIAN_RELATIONSHIP, GUARDIAN_ADDRESS, GUARDIAN_CONTACT;

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
    final String key12 = "HEIGHT";
    final String key13 = "WEIGHT";
    final String key14 = "HISTORY";
    final String key15 = "GUARDIAN_NAME";
    final String key16 = "GUARDIAN_RELATIONSHIP";
    final String key17 = "GUARDIAN_ADDRESS";
    final String key18 = "GUARDIAN_CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Bundle mainActivityBundle = getIntent().getBundleExtra("MAIN_ACTIVITY_BUNDLE");
        Bundle secondActivityBundle = getIntent().getBundleExtra("PAGE2_ACTIVITY_BUNDLE");

        //TEXT VIEWS
        name = findViewById(R.id.nameTV);
        course_year = findViewById(R.id.courseTV);
        gender = findViewById(R.id.genderTV);
        age = findViewById(R.id.ageTV);
        birth_date = findViewById(R.id.birthTV);
        address = findViewById(R.id.addressTV);
        mobile_number = findViewById(R.id.contactTV);
        telephone_number = findViewById(R.id.telephoneTV);
        email = findViewById(R.id.emailTV);
        height = findViewById(R.id.heightTV);
        weight = findViewById(R.id.weightTV);
        history = findViewById(R.id.historyTV);
        guardian_name = findViewById(R.id.guardian_nameTV);
        guardian_relationship = findViewById(R.id.guardian_relationshipTV);
        guardian_address = findViewById(R.id.guardian_addressTV);
        guardian_contact = findViewById(R.id.guardian_contactTV);

        //Button
        confirm = findViewById(R.id.confirm_button);
        back = findViewById(R.id.back2_button);

        //GETTING STRINGS
        FNAME = mainActivityBundle.getString(key1, "");
        LNAME = mainActivityBundle.getString(key2, "");
        MNAME = mainActivityBundle.getString(key3, "Lauron");
        AGE = mainActivityBundle.getString(key4, "");
        GENDER = mainActivityBundle.getString(key5, "");
        COURSE_YEAR = mainActivityBundle.getString(key6, "");
        ADDRESS = mainActivityBundle.getString(key7, "");
        MOBILE = mainActivityBundle.getString(key8, "");
        TELEPHONE = mainActivityBundle.getString(key9, "");
        EMAIL = mainActivityBundle.getString(key10, "");
        BIRTH = mainActivityBundle.getString(key11, "");
        HEIGHT = secondActivityBundle.getString(key12, "");
        WEIGHT = secondActivityBundle.getString(key13, "");
        HISTORY = secondActivityBundle.getString(key14, "");
        GUARDIAN_NAME = secondActivityBundle.getString(key15, "");
        GUARDIAN_RELATIONSHIP = secondActivityBundle.getString(key16, "");
        GUARDIAN_ADDRESS = secondActivityBundle.getString(key17, "");
        GUARDIAN_CONTACT = secondActivityBundle.getString(key18, "");

        //Displaying data
        name.setText(LNAME + ", " + FNAME + ", " + MNAME.charAt(0) + ".");
        course_year.setText("Course and year: " + COURSE_YEAR);
        gender.setText("Gender: " + GENDER);
        age.setText("Age: " + AGE);
        birth_date.setText("Birth date: " + BIRTH);
        address.setText("Address: " + ADDRESS);
        email.setText("Email: " + EMAIL);
        mobile_number.setText("Contact No: " + MOBILE);
        telephone_number.setText("Telephone No: " + TELEPHONE);
        height.setText("Height: " + HEIGHT);
        weight.setText("Weight: " + WEIGHT);
        history.setText("Medical history: " + HISTORY);
        guardian_name.setText("Guardian name: " + GUARDIAN_NAME);
        guardian_relationship.setText("Relationship to guardian: " + GUARDIAN_RELATIONSHIP);
        guardian_address.setText("Guardian address: " + GUARDIAN_ADDRESS);
        guardian_contact.setText("Guardian contact No: " + GUARDIAN_CONTACT);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Finish.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Page2.class);
                i.putExtras(secondActivityBundle);
                startActivity(i);
                finish();
            }
        });


    }
}