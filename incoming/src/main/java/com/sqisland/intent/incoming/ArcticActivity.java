package com.sqisland.intent.incoming;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ArcticActivity extends AppCompatActivity {
  private EditText latitudeView;
  private TextView messageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_arctic);

    latitudeView = (EditText) findViewById(R.id.latitude);
    messageView = (TextView) findViewById(R.id.message);

    View checkButton = findViewById(R.id.check_button);
    checkButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String text = latitudeView.getText().toString();
        check(text);
      }
    });
  }

  private void check(String text) {
    try {
      double latitude = Double.parseDouble(text);
      if (latitude < -90 || latitude > 90) {
        invalidLatitude();
      } else {
        messageView.setText(latitude > 65.8256 ?
            R.string.inside_arctic_circle : R.string.outside_arctic_circle);
      }
    } catch (NumberFormatException e) {
      invalidLatitude();
    }
  }

  private void invalidLatitude() {
    messageView.setText(R.string.invalid_latitude);
  }
}