package madeinkwd.ryokou.db;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.app.ProgressDialog;

public class HttpConnecter extends AsyncTask<String, Integer, String> {
	
	DBActivity activity;
	String URL;
	String TAG;
	ProgressDialog waitDialog;
	
	public HttpConnecter(String TAG ,DBActivity activity,String URL) {
		super();
		this.activity = activity;
		this.URL = URL;
		this.TAG = TAG;
		// TODO 自動生成されたコンストラクター・スタブ
	}

    @Override
	protected void onPostExecute(String result) {
		Log.d("HttpConnecter","onPostExecute");
		// TODO 自動生成されたメソッド・スタブ
		super.onPostExecute(result);
		waitDialog.dismiss();
		activity.callBack(TAG,result);


			// TODO 自動生成された catch ブロック

	}

	@Override
	protected void onPreExecute() {
		// TODO 自動生成されたメソッド・スタブ
		super.onPreExecute();
		Log.d(TAG, "onPreExecute");
		Activity a = (Activity)activity;
		 // プログレスダイアログの設定
		waitDialog = new ProgressDialog(a);
	    // プログレスダイアログのメッセージを設定します
	    waitDialog.setMessage("ネットワーク接続中...");
	    // 円スタイル（くるくる回るタイプ）に設定します
	    waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	    // プログレスダイアログを表示
	    waitDialog.show();
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO 自動生成されたメソッド・スタブ
		super.onProgressUpdate(values);
	}

	protected String doInBackground(String... params) {
		Log.d("HttpConnecter","doInBackground");
		
		
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost(URL);
        
        String result = null;
        
        StringEntity body;
		try {
			body = new StringEntity(params[0]);
			post.addHeader("Content-type", "application/json");
			post.setEntity(body);
		} catch (UnsupportedEncodingException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		HttpResponse response;
		try {
			response = httpClient.execute(post);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			response.getEntity().writeTo(byteArrayOutputStream);
			
			//-----[サーバーからの応答を取得]
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
			{
				result = byteArrayOutputStream.toString();
			}
			else
			{
				//エラー処理
			}

		} catch (ClientProtocolException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;

    }

}