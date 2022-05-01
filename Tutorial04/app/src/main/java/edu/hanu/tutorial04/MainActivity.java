package edu.hanu.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get ref - findViewById
        ImageButton play_button = findViewById(R.id.playButton);
        TextView link_input = (TextView) findViewById(R.id.link_input);
        //handle the click event



        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_in = link_input.getText().toString();
                //start player
                Intent intent = new Intent(getApplicationContext(), PlayerActivity.class);
                intent.putExtra("LINK", str_in);
                startActivity(intent);
            }
        });
            //get link
    }
}