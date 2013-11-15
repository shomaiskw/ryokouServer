package madeinkwd.ryokou;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	protected static final int OPERATION = 0;
	protected static final String TAG = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top);
		
		Button rankingu = (Button)findViewById(R.id.rankingubutton);
		rankingu.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent ranintent = new Intent(getApplicationContext(),Ranking.class);
				startActivity(ranintent);
			}
		
		});
		
		Button sintyaku = (Button)findViewById(R.id.sintyakubutton);
		sintyaku.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),Newarrivals.class);
				startActivity(intent);
			}
		
		});
		
		Button mypage = (Button)findViewById(R.id.mypagebutton);
		mypage.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent myintent = new Intent(getApplicationContext(),Mypage.class);
				startActivity(myintent);
			}
		
		});
		
	
		Button kensaku = (Button)findViewById(R.id.kensakubutton);
		kensaku.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),Kensaku.class);
				startActivity(intent);
			}
		
		});
		
	}
	/* aaa */


	
//bitbucket.org/sishikawa/madeinkwd
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
}
