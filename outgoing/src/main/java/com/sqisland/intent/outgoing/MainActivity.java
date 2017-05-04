package com.sqisland.intent.outgoing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void checkArctic(View view) {
    Uri uri = Uri.parse("geo:22.276556,114.160573");
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
    startActivity(intent);
  }

  public void countCharacters(View view) {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/*");
    intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_to_share));
    startActivity(intent);
  }

  public void convertTemperature(View view) {
    Intent intent = new Intent("com.sqisland.intent.incoming.CELSIUS_TO_FAHRENHEIT");
    intent.putExtra("Celsius", 100f);
    startActivity(intent);
  }
}