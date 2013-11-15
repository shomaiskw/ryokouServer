package madeinkwd.ryokou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ReviewDetail extends Activity {    
	/** Called when the activity is first created. */
	// リストビューに表示する配列データ   
	Activity activity;
	@Override    
	public void onCreate(Bundle savedInstanceState) {        
		super.onCreate(savedInstanceState);        
		setContentView(R.layout.review_detail);         
		activity = this;
     
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// アイテムを追加します        
		adapter.add("red");       
		adapter.add("green");        
		adapter.add("blue");       
		Spinner spinner = (Spinner) findViewById(R.id.spinner0);  
		// アダプターを設定します       
		spinner.setAdapter(adapter);       
		// スピナーのアイテムが選択された時に呼び出されるコールバックリスナーを登録します        
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {           
			@Override           
			public void onItemSelected(AdapterView<?> parent, View view,                    
					int position, long id) {                
				Spinner spinner = (Spinner) parent;                
				// 選択されたアイテムを取得します                
				String item = (String) spinner.getSelectedItem();                
				Toast.makeText(ReviewDetail.this, item, Toast.LENGTH_LONG).show();            
				}           
			@Override            
			public void onNothingSelected(AdapterView<?> arg0) { 
				
			}        
			});    
		}	
			
		
		
	}
