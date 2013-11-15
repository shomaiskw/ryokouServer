package madeinkwd.ryokou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

public class Ranking extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);
         

        Button exit = (Button)findViewById(R.id.exitbutton);
		exit.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent exitintent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(exitintent);
			}
		
		});

	}
}
