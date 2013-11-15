package madeinkwd.ryokou;

import java.util.ArrayList;
import java.util.HashMap;

import madeinkwd.ryokou.db.DBActivity;
import madeinkwd.ryokou.db.ServerDBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DBActivitySample extends Activity implements DBActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbactivity);

		//サーバー接続の手助けをしてくれるクラスをインスタンス化
		ServerDBHelper server = new ServerDBHelper(this);
		
		//識別タグ（文字列形）とポストするJSONを引数に実行
		server.getMember("member","555");


	}
	@Override
	public void callBack(String TAG,String result) {
		// サーバー接続の実行結果の処理をここに書く
		// resultはサーバから帰ってきたデータ
		Log.d("callBack",result);
		
		TextView text =(TextView)findViewById(R.id.textView1);
		
		try {
			JSONObject json = new JSONObject(result);
			JSONObject member = (JSONObject)json.get("member");
			
			String member_id = member.getString("member_id");
			String member_nic = member.getString("member_nic");
			String member_birthday = member.getString("member_birthday");
			String member_sex = member.getString("member_sex");
			String member_address = member.getString("member_address");
			String job_id = member.getString("job_id");
			String member_mail = member.getString("member_mail");
			String member_passwd = member.getString("member_passwd");
			
			text.setText("member_id:" + member_id + "\n" + 
					"member_nic:" + member_nic + "\n" + 
					"member_birthday:" + member_birthday + "\n" + 
					"member_sex:" + member_sex + "\n" + 
					"member_address:" + member_address + "\n" + 
					"job_id:" + job_id + "\n" + 
					"member_mail:" + member_mail + "\n" + 
					"member_passwd:" + member_passwd + "\n");
			
			
		} catch (JSONException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public Context getContext() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}



}