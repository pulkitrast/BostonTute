package com.example.bostontute;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Camera extends Activity implements View.OnClickListener {
	ImageView iv;
	ImageButton ib;
	Button b;
	Intent i;
	int cameraData = 0;
	Bitmap bmp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photo);
		ini();
		b.setOnClickListener(this);
		ib.setOnClickListener(this);

	}

	private void ini() {
		// TODO Auto-generated method stub
		iv = (ImageView) findViewById(R.id.ivPreviewPic);
		ib = (ImageButton) findViewById(R.id.ibClick);
		b = (Button) findViewById(R.id.bsetBack);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibClick:
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, cameraData);
			break;
		case R.id.bsetBack:
			break;
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			Bundle extrs=data.getExtras();
			bmp=(Bitmap)extrs.get("data");
			iv.setImageBitmap(bmp);
		}

	}

}
