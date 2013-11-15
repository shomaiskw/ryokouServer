package madeinkwd.ryokou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Sintyaku extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newarrivals);
         
        Button button1=(Button)findViewById(R.id.exitbutton);
        button1.setOnClickListener(new OnClickListener(){
        	@Override
            public void onClick(View v) {
        		finish();
        		
        	}
                   
        });

	}
}
