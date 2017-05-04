package com.sqisland.intent.incoming;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Uri uri = getIntent().getData();
    if (uri != null) {
      TextView uriView = (TextView) findViewById(R.id.uri);
      uriView.setText(uri.toString());
    }
  }

  public void checkArctic(View view) {
    Intent intent = new Intent(this, ArcticActivity.class);
    startActivity(intent);
  }

  public void countCharacters(View view) {
    Intent intent = new Intent(this, CountCharacterActivity.class);
    startActivity(intent);
  }

  public void convertTemperature(View view) {
    Intent intent = new Intent(this, CelsiusToFahrenheitActivity.class);
    startActivity(intent);
  }
}