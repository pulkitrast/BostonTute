package com.example.bostontute;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {
	TextView ques, test;
	Button returnData;
	String setData;
	RadioGroup selectionList;
	String gotbread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		ini();
		Bundle gotBasket = getIntent().getExtras();
		gotbread = gotBasket.getString("ques");
		ques.setText(gotbread);
	}

	private void ini() {
		// TODO Auto-generated method stub
		ques = (TextView) findViewById(R.id.tvQues);
		test = (TextView) findViewById(R.id.tvGot1);
		returnData = (Button) findViewById(R.id.bReturn);
		returnData.setOnClickListener(this);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i= new Intent();
		Bundle returnValue=new Bundle();
		returnValue.putString("answer", setData);
		i.putExtras(returnValue);
		setResult(RESULT_OK,i);
		finish();
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.radio0:
			setData = "yes";
			break;
		case R.id.radio1:
			setData = "YES";
			break;
		case R.id.radio2:
			setData = "IDK but YES!";
			break;
		}
		test.setText(setData);
	}

}
