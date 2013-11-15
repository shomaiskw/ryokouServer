package madeinkwd.ryokou;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Plansakusei extends Activity {

	public static final int OPERATION = 0;
	public static final String TAG = null;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.plansakusei);
		
		final EditText editText1 = (EditText)findViewById(R.id.editText1);
		final EditText editText2 = (EditText)findViewById(R.id.editText2);
		final EditText editText3 = (EditText)findViewById(R.id.EditText01);
		final EditText editText4 = (EditText)findViewById(R.id.EditText02);
		final EditText editText5 = (EditText)findViewById(R.id.EditText03);
		final EditText editText6 = (EditText)findViewById(R.id.EditText04);
		final EditText editText7 = (EditText)findViewById(R.id.EditText05);
		final EditText editText8 = (EditText)findViewById(R.id.EditText06);
		
		Button syousai = (Button)findViewById(R.id.syousaibutton);
		syousai.setOnClickListener(new View.OnClickListener(){
			private int requestCode = OPERATION;
			
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),SyousaiActivity.class);
				
				//文字列の入力があればIntentにデータをセットする
				String atai1 = editText1.getText().toString();
				String atai2 = editText2.getText().toString();
				String atai3 = editText3.getText().toString();
				String atai4 = editText4.getText().toString();
				String atai5 = editText5.getText().toString();
				String atai6 = editText6.getText().toString();
				String atai7 = editText7.getText().toString();
				String atai8 = editText8.getText().toString();
				
					intent.putExtra("atai1", atai1);
					intent.putExtra("atai2", atai2);
					intent.putExtra("atai3", atai3);
					intent.putExtra("atai4", atai4);
					intent.putExtra("atai5", atai5);
					intent.putExtra("atai6", atai6);
					intent.putExtra("atai7", atai7);
					intent.putExtra("atai8", atai8);
					
					Log.i(TAG,"onClick() set atai:" + atai1);
					Log.i(TAG,"onClick() set atai:" + atai2);
					Log.i(TAG,"onClick() set atai:" + atai3);
					Log.i(TAG,"onClick() set atai:" + atai4);
					Log.i(TAG,"onClick() set atai:" + atai5);
					Log.i(TAG,"onClick() set atai:" + atai6);
					Log.i(TAG,"onClick() set atai:" + atai7);
					Log.i(TAG,"onClick() set atai:" + atai8);			
				
				startActivityForResult(intent,requestCode);
				
				finish();
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
