package madeinkwd.ryokou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Kousin extends Activity {
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.kousin);

	        final EditText editText1 = (EditText)findViewById(R.id.editText1);
			final EditText editText5 = (EditText)findViewById(R.id.editText5);
			final EditText editText3 = (EditText)findViewById(R.id.editText3);
			final EditText editText4 = (EditText)findViewById(R.id.editText4);
			
			
	        
			Button reset = (Button)findViewById(R.id.resetbutton);
			reset.setOnClickListener(new View.OnClickListener(){

				public void onClick(View v){
					editText1.setText("");
					editText5.setText("");
					editText3.setText("");
					editText4.setText("");
				}
			});
		
		Button kousin = (Button)findViewById(R.id.kousinbutton);
		kousin.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),Kousin.class);
				startActivity(intent);
			}
		
		});
		
		Button exit = (Button)findViewById(R.id.exitbutton);
        exit.setOnClickListener(new OnClickListener(){
        	@Override
            public void onClick(View v) {
        		finish();
        		
        	}
                   
        });
		
		
	 }
}
