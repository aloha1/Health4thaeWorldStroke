
package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rachelgrau.rachel.health4theworldstroke.Database.DBhelperpass;
import com.rachelgrau.rachel.health4theworldstroke.R;

public class password_gateway extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_gateway);
    }
    public void onClick(View v){
        EditText userInput=(EditText)findViewById(R.id.pass);
        checkPass(userInput.getText().toString());
    }
    public void checkPass(String password)
    {
        TextView textView=(TextView)findViewById(R.id.textView);
        if(password.equals("stroke")){
            Intent intent=new Intent(this,survey.class);
            textView.setVisibility(View.INVISIBLE);
            startActivity(intent);
        }
        else{
            Vibrator v = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(400);
            textView.setTextSize(20);
            textView.setVisibility(View.VISIBLE);
            textView.setText(R.string.error_pass);
        }
    }
    }

