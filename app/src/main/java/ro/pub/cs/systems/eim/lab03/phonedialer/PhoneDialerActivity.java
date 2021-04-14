package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {
    private static final int NUMBER_LENGTH = 20;
    private char[] phoneNumber = new char[NUMBER_LENGTH];
    private int idx = 0;
    EditText numberEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            phoneNumber[i] = ' ';
        }
        setContentView(R.layout.activity_phone_dialer);
        numberEditText = findViewById(R.id.numberEditText);

        Button oneButton = findViewById(R.id.oneButton);
        Button twoButton = findViewById(R.id.twoButton);
        Button threeButton = findViewById(R.id.threeButton);
        Button fourButton = findViewById(R.id.fourButton);
        Button fiveButton = findViewById(R.id.fiveButton);
        Button sixButton = findViewById(R.id.sixButton);
        Button sevenButton = findViewById(R.id.sevenButton);
        Button eightButton = findViewById(R.id.eightButton);
        Button nineButton = findViewById(R.id.nineButton);
        Button zeroButton = findViewById(R.id.zeroButton);
        Button diezButton = findViewById(R.id.diezButton);
        Button starButton = findViewById(R.id.starButton);
        ImageButton removeButton = findViewById(R.id.removeButton);
        ImageButton callButton = findViewById(R.id.callButton);
        ImageButton hangUpButton = findViewById(R.id.hangupButton);

        oneButton.setOnClickListener(new ButtonClick());
        twoButton.setOnClickListener(new ButtonClick());
        threeButton.setOnClickListener(new ButtonClick());
        fourButton.setOnClickListener(new ButtonClick());
        fiveButton.setOnClickListener(new ButtonClick());
        sixButton.setOnClickListener(new ButtonClick());
        sevenButton.setOnClickListener(new ButtonClick());
        eightButton.setOnClickListener(new ButtonClick());
        nineButton.setOnClickListener(new ButtonClick());
        zeroButton.setOnClickListener(new ButtonClick());
        diezButton.setOnClickListener(new ButtonClick());
        starButton.setOnClickListener(new ButtonClick());
        removeButton.setOnClickListener(new ButtonClick());
        callButton.setOnClickListener(new ButtonClick());
        hangUpButton.setOnClickListener(new ButtonClick());
    }

    class ButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() != R.id.callButton && view.getId() != R.id.hangupButton && view.getId() != R.id.removeButton) {
                if (view.getId() == R.id.oneButton) {
                    phoneNumber[idx] = '1';
                } else if (view.getId() == R.id.twoButton) {
                    phoneNumber[idx] = '2';
                } else if (view.getId() == R.id.threeButton) {
                    phoneNumber[idx] = '3';
                } else if (view.getId() == R.id.fourButton) {
                    phoneNumber[idx] = '4';
                } else if (view.getId() == R.id.fiveButton) {
                    phoneNumber[idx] = '5';
                } else if (view.getId() == R.id.sixButton) {
                    phoneNumber[idx] = '6';
                } else if (view.getId() == R.id.sevenButton) {
                    phoneNumber[idx] = '7';
                } else if (view.getId() == R.id.eightButton) {
                    phoneNumber[idx] = '8';
                } else if (view.getId() == R.id.nineButton) {
                    phoneNumber[idx] = '9';
                } else if (view.getId() == R.id.zeroButton) {
                    phoneNumber[idx] = '0';
                } else if (view.getId() == R.id.diezButton) {
                    phoneNumber[idx] = '#';
                } else if (view.getId() == R.id.starButton) {
                    phoneNumber[idx] = '*';
                }
                idx++;
            } else {
                if (view.getId() == R.id.removeButton) {
                    if (idx != 0) {
                        idx -= 1;
                        phoneNumber[idx] = ' ';
                    }
                } else if (view.getId() == R.id.callButton) {
                    if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                PhoneDialerActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
//                                Constants.PERMISSION_REQUEST_CALL_PHONE);
                                1);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + numberEditText.getText().toString()));
                        startActivity(intent);
                    }
                } else if (view.getId() == R.id.hangupButton) {
                    finish();
                }
            }
            System.out.println(phoneNumber);
            numberEditText.setText(new String(phoneNumber));
        }
    }
}