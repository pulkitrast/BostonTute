package com.example.bostontute;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	Intent openAct;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slash);
		mp=MediaPlayer.create(Splash.this, R.raw.k);
		mp.start();
		Thread timer =new Thread(){
			public void run(){
				try{
					sleep(5000);
									}
				catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					openAct =new Intent("com.example.bostontute.MENU");
					startActivity(openAct);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mp.release();
		finish();
	}

}
