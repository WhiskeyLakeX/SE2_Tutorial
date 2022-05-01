package edu.hanu.languagepreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView lang_opt = (TextView) findViewById(R.id.lang_opt);
        //get language pref
        sharedPreferences =
                this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                String language_opt = sharedPreferences.getString("language", null);
        //if not exist
        if (language_opt == null) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_baseline_language_24)
                    .setMessage("Please choose a language")
                    .setPositiveButton("Vietnamese", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //save language pref
                            sharedPreferences.edit().putString("language", "Vietnamese").apply();
                            //update txtview
                            lang_opt.setText("Vietnamese");
                        }
                    })
                    .setNegativeButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            sharedPreferences.edit().putString("language", "English").apply();
                            //update txtview
                            lang_opt.setText("English");
                        }
                    }).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView lang_opt = findViewById(R.id.lang_opt);
        switch (item.getItemId()) {
            case R.id.lang_vi_menu_opt:
                sharedPreferences.edit().putString("language", "Vietnamese").apply();
                //update txtview
                lang_opt.setText("Vietnamese");
                break;

            case R.id.lang_eng_menu_opt:
                sharedPreferences.edit().putString("language", "English").apply();
                //update txtview
                lang_opt.setText("English");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}