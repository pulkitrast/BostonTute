import com.example.bostontute.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Act extends Activity {
	Button sub, add;
	int counter;
	TextView disp;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		add = (Button) findViewById(R.id.butadd);
		sub = (Button) findViewById(R.id.butsub);
		disp = (TextView) findViewById(R.id.txdisp);
		counter = 0;

		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter++;
				disp.setText("Your result=" + counter);

			}
		});

		sub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				counter--;
				disp.setText("Your result=" + counter);

			}
		});
	}

}
