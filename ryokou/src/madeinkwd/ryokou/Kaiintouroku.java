package madeinkwd.ryokou;

import org.json.JSONException;
import org.json.JSONObject;

import madeinkwd.ryokou.db.DBActivity;
import madeinkwd.ryokou.db.ServerDBHelper;
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

public class Kaiintouroku extends Activity implements DBActivity,OnClickListener{
    EditText editText1;
    EditText editText01;
    EditText editText02;
    EditText editText03;
    EditText editText04;
    Spinner spinner0;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaiintouroku);
        
    	
		
          
        editText1 = (EditText)findViewById(R.id.editText1);
        editText01 = (EditText)findViewById(R.id.editText01);
        editText02 = (EditText)findViewById(R.id.editText02);
        editText03 = (EditText)findViewById(R.id.editText03);
        editText04 = (EditText)findViewById(R.id.editText04);
        spinner0 = (Spinner)findViewById(R.id.spinner0);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        
        //String spinner0st = ;
       
        
        String spinner4st = (String)spinner4.getSelectedItem();
        String spinner5st = (String)spinner5.getSelectedItem();
        Button kakunin = (Button)findViewById(R.id.button1);
		kakunin.setOnClickListener(this);
		Button reset = (Button)findViewById(R.id.button2);
		reset.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v){
				editText1.setText("");
				editText01.setText("");
				editText02.setText("");
				editText03.setText("");
				editText04.setText("");
			}
		});


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


	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		//JSONObject形の入れ物を作る
		JSONObject json = new JSONObject();
		try {
			json.put("member_id", editText01.getText());
			json.put("member_nic", editText1.getText());
			json.put("member_birthday", (String)spinner0.getSelectedItem() + "/" + (String)spinner2.getSelectedItem() + "/" + (String)spinner3.getSelectedItem());
			json.put("member_sex", "radioButton1");
			json.put("member_address", editText02.getText());
			json.put("job_id", "1");
			json.put("member_mail", editText03.getText());
			json.put("member_passwd", editText04.getText());
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		ServerDBHelper server = new ServerDBHelper(this);
		server.addMember("Menber", json);
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("登録完了しました。");
		alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        				startActivity(intent);
                    }
                });
		alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
		
		
	}
}		
		
