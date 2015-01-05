package com.example.bostontute;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {
	ToggleButton passTag;
	EditText input;
	TextView display;
	Button chkCmd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		ini();
		passTag.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (passTag.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT
							| InputType.TYPE_TEXT_VARIATION_PASSWORD);

				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}

			}

		});
		chkCmd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String check = input.getText().toString();
				if (check.contentEquals("left")) {
					display.setGravity(Gravity.LEFT);
				} else if (check.contentEquals("right")) {
					display.setGravity(Gravity.RIGHT);
				} else if (check.contentEquals("centre")) {
					display.setGravity(Gravity.CENTER);
				} else if (check.contentEquals("blue")) {
					display.setTextColor(Color.BLUE);
				} else if (check.contentEquals("WTF")) {
					Random crazy = new Random();
					display.setText("WTF!!!");
					display.setTextSize(crazy.nextInt(75));
					display.setTextColor(Color.rgb(crazy.nextInt(255),
							crazy.nextInt(255), crazy.nextInt(255)));
					switch (crazy.nextInt(3)) {
					case 0:
						display.setGravity(Gravity.CENTER);
						break;
					case 1:
						display.setGravity(Gravity.RIGHT);
						break;
					case 2:
						display.setGravity(Gravity.LEFT);
						break;
					}
				}

				else {
					display.setGravity(Gravity.CENTER);
					display.setText("INVALID!");
					display.setTextColor(Color.WHITE);
				}
			}
		});
	}

	private void ini() {
		// TODO Auto-generated method stub
		Button chkCmd = (Button) findViewById(R.id.bResults);
		passTag = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etcommands);
		display = (TextView) findViewById(R.id.tvResults);
	}
}
