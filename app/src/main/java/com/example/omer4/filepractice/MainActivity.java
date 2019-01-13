package com.example.omer4.filepractice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et;
    TextView tv;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et2);
        tv=findViewById(R.id.tv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("credits");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "This app was created by Omer Eikly", Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }

    public void Write(View view) {
        String str = et.getText().toString();
        FileOutputStream fo = null;
        try {
            fo = openFileOutput("FilePrac.txt", Context.MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(osw);
            try {
                bw.write(str);
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Read(View view) {
        try {
            InputStream is = openFileInput("FilePrac.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buffer = new StringBuffer();
            while((str = br.readLine())!=null){
                buffer.append(str + "\n");
            }
            is.close();
            tv.setText(buffer);
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Data wasn't read successfully", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(this, "Data wasn't read successfully", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
    }

