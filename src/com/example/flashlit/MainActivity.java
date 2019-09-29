package com.example.flashlit;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
private Camera cameraobj;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button onBtn = (Button)findViewById(R.id.button1);
		Button offBtn = (Button)findViewById(R.id.button2);
		cameraobj = Camera.open();
		onBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	Camera.Parameters cameraparams= cameraobj.getParameters();
	cameraparams.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
	cameraobj.setParameters(cameraparams);
	cameraobj.startPreview();
			}
		});
		offBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cameraobj.startPreview();
				cameraobj.release();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
