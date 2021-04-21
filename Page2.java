package com.my.filloutform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Page2 extends AppCompatActivity {

    EditText height, weight, history, guardian_name, guardian_relationship, guardian_address, guardian_contact;
    Button submit, back;

    String HEIGHT, WEIGHT, HISTORY, GUARDIAN_NAME, GUARDIAN_RELATIONSHIP, GUARDIAN_ADDRESS, GUARDIAN_CONTACT;

    final String key1 = "HEIGHT";
    final String key2 = "WEIGHT";
    final String key3 = "HISTORY";
    final String key4 = "GUARDIAN_NAME";
    final String key5 = "GUARDIAN_RELATIONSHIP";
    final String key6 = "GUARDIAN_ADDRESS";
    final String key7 = "GUARDIAN_CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Bundle mainActivityBundle = getIntent().getExtras();

        //Views
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        history = findViewById(R.id.medical_history);
        guardian_name = findViewById(R.id.guardian_name);
        guardian_relationship = findViewById(R.id.relationship_guardian);
        guardian_address = findViewById(R.id.guardian_address);
        guardian_contact = findViewById(R.id.guardian_contact);

        //Button
        submit = findViewById(R.id.submit_button);
        back = findViewById(R.id.back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtras(mainActivityBundle);
                startActivity(i);
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Confirm.class);
                Bundle mainBundle = new Bundle();
                Bundle b = new Bundle();


                //Strings
                HEIGHT = height.getText().toString();
                WEIGHT = weight.getText().toString();
                HISTORY = history.getText().toString();
                GUARDIAN_NAME = guardian_name.getText().toString();
                GUARDIAN_RELATIONSHIP = guardian_relationship.getText().toString();
                GUARDIAN_ADDRESS = guardian_address.getText().toString();
                GUARDIAN_CONTACT = guardian_contact.getText().toString();

                b.putString(key1, HEIGHT);
                b.putString(key2, WEIGHT);
                b.putString(key3, HISTORY);
                b.putString(key4, GUARDIAN_NAME);
                b.putString(key5, GUARDIAN_RELATIONSHIP);
                b.putString(key6, GUARDIAN_ADDRESS);
                b.putString(key7, GUARDIAN_CONTACT);


                mainBundle.putBundle("MAIN_ACTIVITY_BUNDLE", mainActivityBundle);
                mainBundle.putBundle("PAGE2_ACTIVITY_BUNDLE", b);
                i.putExtras(mainBundle);
                startActivity(i);
                finish();
            }
        });

        Bundle b = getIntent().getExtras();
        if (b != null) {
            height.setText(b.getString(key1,""));
            weight.setText(b.getString(key2,""));
            history.setText(b.getString(key3,""));
            guardian_name.setText(b.getString(key4,""));
            guardian_relationship.setText(b.getString(key5,""));
            guardian_address.setText(b.getString(key6,""));
            guardian_contact.setText(b.getString(key7,""));

        }
    }
}