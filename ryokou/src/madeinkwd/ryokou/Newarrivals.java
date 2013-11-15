package madeinkwd.ryokou;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import madeinkwd.ryokou.db.DBActivity;
import madeinkwd.ryokou.db.ServerDBHelper;


public class Newarrivals extends Activity implements DBActivity {

	protected static final int OPERATION = 0;
	protected static final String TAG = null;
	
	private ArrayList<HashMap<String, String>> data;
	private HashMap<String, String> map;
	private ListView listView;
	SimpleAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newarrivals);

		listView = (ListView)findViewById(R.id.listView1);

		// リストデータを詰め込む前にインスタンス生成
		data = new ArrayList<HashMap<String, String>>();

		adapter = new SimpleAdapter(this,
				data,
			R.layout.newarrivals_row,
			new String[]{"plan_name", "categories"},
			new int[]{R.id.plan_name, R.id.categories});
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                HashMap item = (HashMap) listView.getItemAtPosition(position);
                
                Toast.makeText(getApplicationContext(), item.get("plan_id").toString(), Toast.LENGTH_LONG).show();
            }
        });

		Button rankingu = (Button)findViewById(R.id.modorubutton);
		ServerDBHelper server = new ServerDBHelper(this);
		server.getPlanList("list","","");
			
		rankingu.setOnClickListener(new View.OnClickListener(){


			public void onClick(View v){
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
			}
		
		});
	}

	@Override
	public void callBack(String TAG, String str) {
		// TODO 自動生成されたメソッド・スタブ
		
		JSONArray json;
		try {
			json = new JSONArray(str);
			
			for(int i=0;i<json.length();i++){
				JSONObject plan = json.getJSONObject(i).getJSONObject("plan");
				
				// 一行の複数項目を HashMap で詰め込む
				map = new HashMap<String, String>();
				map.put("member_id",plan.getString("member_id"));
				map.put("plan_id",plan.getString("plan_id"));
				map.put("plan_name", "プラン名：" + plan.getString("plan_name"));
				
				JSONArray categories = plan.getJSONArray("plan_categories");
				String cate="カテゴリ：";
				for(int j=0;j<categories.length();j++){
					JSONObject categ = (JSONObject) categories.get(j);
					cate = cate + " " + categ.getString("category_id");
				}
				
				map.put("categories", cate);
				data.add(map);
				
				// ここまでをループで回して各行に詰め込む
				if(i>10) break;
			}
			adapter.notifyDataSetChanged();
		} catch (JSONException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

	}

	@Override
	public Context getContext() {
		// TODO 自動生成されたメソッド・スタブ
		return getApplicationContext();
	}
}