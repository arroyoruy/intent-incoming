package com.sqisland.intent.incoming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CelsiusToFahrenheitActivity extends AppCompatActivity {
  private static final String EXTRA_CELSIUS = "Celsius";

  private EditText celsuisView;
  private TextView messageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_celsius_to_fahrenheit);

    celsuisView = (EditText) findViewById(R.id.celcius);
    messageView = (TextView) findViewById(R.id.message);

    View convertButton = findViewById(R.id.convert_button);
    convertButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String text = celsuisView.getText().toString();
        try {
          float fahrenheit = Float.parseFloat(text);
          convert(fahrenheit);
        } catch (NumberFormatException e) {
          messageView.setText(R.string.invalid_temperature);
        }
      }
    });

    if (getIntent().hasExtra(EXTRA_CELSIUS)) {
      float celsius = getIntent().getFloatExtra(EXTRA_CELSIUS, 0);
      celsuisView.setText(String.valueOf(celsius));
      convert(celsius);
    }
  }

  private void convert(float celsius) {
    float fahrenheit = celsius * 1.8f + 32;
    messageView.setText(getString(R.string.fahrenheit, fahrenheit));
  }
}