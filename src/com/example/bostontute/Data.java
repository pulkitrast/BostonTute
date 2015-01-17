package com.example.bostontute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements View.OnClickListener {
	EditText etSend;
	TextView tvGot;
	Button bSAFR;
	Button bSA;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get);
		ini();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle ba = data.getExtras();
			String ans = ba.getString("answser");
			//tvGot.setText(ans);
			tvGot.setText(data.getExtras().getString("answer"));
		}
	}

	private void ini() {
		// TODO Auto-generated method stub
		bSAFR = (Button) findViewById(R.id.bSAFR);
		bSA = (Button) findViewById(R.id.bSA);
		tvGot = (TextView) findViewById(R.id.tvGot);
		etSend = (EditText) findViewById(R.id.etSend);
		bSA.setOnClickListener(this);
		bSAFR.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Bundle basket = new Bundle();
		basket.putString("ques", "hmm");
		switch (v.getId()) {
		case R.id.bSA:
			String bread = etSend.getText().toString();
			basket.putString("ques", bread);
			Intent a = new Intent(Data.this, OpenedClass.class);
			a.putExtras(basket);
			startActivity(a);
			break;
		case R.id.bSAFR:
			Intent i = new Intent(Data.this, OpenedClass.class);
			i.putExtras(basket);
			startActivityForResult(i, 0);
			break;

		}

	}

}
