package madeinkwd.ryokou;

import madeinkwd.ryokou.db.DBActivity;
import madeinkwd.ryokou.db.ServerDBHelper;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class Kousin extends Activity implements DBActivity,OnClickListener{
	 
	  EditText editText1;
      EditText editText3;
      EditText editText4;
      EditText editText5;
       
			 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.kousin);
	       
	    editText1 = (EditText)findViewById(R.id.editText1);
		editText5 = (EditText)findViewById(R.id.editText5);
		editText3 = (EditText)findViewById(R.id.editText3);
		editText4 = (EditText)findViewById(R.id.editText4);
			
			
	        
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
		kousin.setOnClickListener(this);
		
		Button exit = (Button)findViewById(R.id.exitbutton);
        exit.setOnClickListener(new OnClickListener(){
        	@Override
            public void onClick(View v) {
        		finish();
        		
        	}
                   
        });
	 }
        @Override
    	public void onClick(View v) {
    		// TODO 自動生成されたメソッド・スタブ
    		//JSONObject形の入れ物を作る
    		JSONObject json = new JSONObject();
    		try {
    			//json.put("member_id", editText01.getText());
    			json.put("member_nic", editText1.getText());
    			//json.put("member_birthday", (String)spinner0.getSelectedItem() + "/" + (String)spinner2.getSelectedItem() + "/" + (String)spinner3.getSelectedItem());
    			json.put("member_sex", "radioButton1");
    			json.put("member_address", editText3.getText());
    			json.put("job_id", "1");
    			json.put("member_mail", editText4.getText());
    			json.put("member_passwd", editText5.getText());
    		} catch (JSONException e2) {
    			e2.printStackTrace();
    		}
    		ServerDBHelper server = new ServerDBHelper(this);
    		server.addMember("Menber", json);
    		
    		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("更新完了しました。");
    		alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    				
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        	Intent intent = new Intent(getApplicationContext(),Mypage.class);
            				startActivity(intent);
                        }
                    });
    		alertDialogBuilder.setCancelable(true);
            AlertDialog alertDialog = alertDialogBuilder.create();
    		alertDialog.show();
		
		
	 }
		@Override
		public void callBack(String TAG, String str) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
		@Override
		public Context getContext() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
}
