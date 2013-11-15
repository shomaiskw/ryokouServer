package madeinkwd.ryokou;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;

 
public class Taikai extends Activity {
	
    private Activity activity;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taikai);
        activity = this;
        
        Button button1=(Button)findViewById(R.id.exitbutton);
        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

				//AlertDialog.Builder ab = new AlertDialog.Builder(getApplicationContext());
				AlertDialog.Builder ab = new AlertDialog.Builder(activity);
				
				
				ab.setTitle("ëﬁâÔèàóù");
				ab.setMessage("ëﬁâÔÇµÇ‹ÇµÇΩ");
				ab.setPositiveButton("OK", null);

				ab.show();

//                AlertDialog.show(Taikai.this, "ëﬁâÔèàóù", 
//                  "ëﬁâÔÇµÇ‹ÇµÇΩÅB", "ok", false);
            }
        });
         
        Button m_button=(Button)findViewById(R.id.m_button);
        m_button.setOnClickListener(new View.OnClickListener() {
             
            @Override
           public void onClick(View v) {
               // TODO Auto-generated method stub
              finish();
           }
        });
    }
}
    
        

           

            
            
    
    
