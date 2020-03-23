package com.demo.incampus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class OTPJava extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //if the system api is below marshmallow, set status bar to default black
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_java);
        Log.i("Activity Info","INSIDE OTPJava ");
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        String PhoneNumber = telephonyManager.getLine1Number();
        Log.i("Phone Number:","PhoneNumber");
        //TextWatcher so that the focus automatically moves with the number entered.
        final StringBuilder sb = new StringBuilder();
        final EditText editTextOne = findViewById(R.id.editTextone);
        final EditText editTextTwo = findViewById(R.id.editTexttwo);

        editTextOne.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(sb.length()==0 && editTextOne.length()==1) {
                    sb.append(s);
                    editTextOne.clearFocus();

                    editTextTwo.requestFocus();
                    editTextTwo.setCursorVisible(true);

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void go_to_InfoJava_activity_function(View view)
    {
        Intent i=new Intent(this,InfoJava.class);
        startActivity(i);
    }
}
