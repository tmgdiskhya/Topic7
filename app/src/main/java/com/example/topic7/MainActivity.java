package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.topic7.R;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddWord;
    EditText etWord, etMeaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddWord =findViewById(R.id.btnAddWord);
        etWord= findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);

        btnAddWord.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Save();
    }
    private void Save(){
        try {

                PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE|MODE_APPEND));
                printStream.println(etWord.getText().toString() + "->" + etMeaning.getText().toString());
                Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
            }
            catch (IOException e){
                Log.d("Dictonaty app", "Error:" + e.toString());
                e.printStackTrace();
            }
        }
}
