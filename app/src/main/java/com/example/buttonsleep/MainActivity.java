package com.example.buttonsleep;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.buttonsleep.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    //login button on LoginActivity
    private Button loginButton;

    RadioButton rb1, rb2, rb3, rb4, rb5;

    boolean success = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        rb5 = (RadioButton) findViewById(R.id.rb5);


        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        rb5.setChecked(false);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //15 seconds
                setScreenTimeout(15000);

                if(success) {
                    rb1.setChecked(true);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);

                    Toast.makeText(MainActivity.this, "Screen off time set to 15 seconds", Toast.LENGTH_SHORT).show();
                    success = false;
                } else {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                }
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //30 seconds
                setScreenTimeout(30000);

                if(success) {
                    rb1.setChecked(false);
                    rb2.setChecked(true);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);

                    Toast.makeText(MainActivity.this, "Screen off time set to 30 seconds", Toast.LENGTH_SHORT).show();
                    success = false;
                }
                else {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                }
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //60 seconds or 1 min
                setScreenTimeout(60000);

                if(success) {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(true);
                    rb4.setChecked(false);
                    rb5.setChecked(false);

                    Toast.makeText(MainActivity.this, "Screen off time set to 1 minute", Toast.LENGTH_SHORT).show();
                    success = false;
                }
                else {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                }
            }
        });

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //10 mins
                setScreenTimeout(300000);
                if(success) {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(true);
                    rb5.setChecked(false);

                    Toast.makeText(MainActivity.this, "Screen off time set to 10 minutes", Toast.LENGTH_SHORT).show();
                    success = false;
                }
                else {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                }
            }
        });

        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //30 mins
                setScreenTimeout(1800000);

                if(success) {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(true);

                    Toast.makeText(MainActivity.this, "Screen off time set to 30 minutes", Toast.LENGTH_SHORT).show();
                    success = false;
                }
                else {
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    rb5.setChecked(false);
                }
            }
        });
    }

    private void setScreenTimeout(int milliseconds)
    {
        boolean Value= false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            Value = Settings.System.canWrite(getApplicationContext());
            if(Value)
            {
                Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, milliseconds);
                success = true;
            }
            else
            {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
                startActivity(intent);
            }
        } else {
            Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT, milliseconds);
            success = true;
        }

    }
}

