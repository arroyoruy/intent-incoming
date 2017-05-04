package com.sqisland.intent.incoming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CountCharacterActivity extends AppCompatActivity {
  private EditText textView;
  private TextView messageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_count_character);

    textView = (EditText) findViewById(R.id.text);
    messageView = (TextView) findViewById(R.id.message);

    View countButton = findViewById(R.id.count_button);
    countButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        CharSequence text = textView.getText();
        count(text);
      }
    });

    CharSequence text = getIntent().getCharSequenceExtra(Intent.EXTRA_TEXT);
    if (text != null) {
      textView.setText(text);
      count(text);
    }
  }

  private void count(CharSequence text) {
    messageView.setText(String.valueOf(text.length()));
  }
}