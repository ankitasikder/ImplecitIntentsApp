package com.example.implecitintents;
/*Created by Ankita Sikder
email: ankita.sikder14@gmail.com*/
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button openUrl;
    EditText inputUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openUrl=(Button)findViewById(R.id.openUrlButton);
        inputUrl=(EditText)findViewById(R.id.inputUrl);
        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid(inputUrl.getText().toString())){
                    Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(inputUrl.getText().toString()));
                    //uniform resource identifier...uri
                    startActivity(implicit);

                }
                else{
                    Log.d("boom",""+inputUrl.getText().toString());
                    Toast.makeText(getApplicationContext(),"URL IS NOT VALID",Toast.LENGTH_LONG).show();
                }}

        });
    }
    public static boolean isValid(String url)
    {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        }

        // If there was an Exception
        // while creating URL object
        catch (Exception e) {
            return false;
        }
    }



}
