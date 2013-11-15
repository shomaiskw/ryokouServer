package madeinkwd.ryokou.db;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerDBHelper {
    final String SERVER_URL="http://172.20.17.58:3000";
    final String MEMBER_URL="/members";
    final String PLAN_URL="/plans";
    final String REVIEW_URL="/reviews";
    private DBActivity activity;
	
    public ServerDBHelper(DBActivity activity){
    	this.activity = activity;
    }
	
    //会員1人の情報を取得
	public void getMember(String TAG,String member_id){
		JSONObject json = new JSONObject();
		
		try {
			//会員IDをJSONに登録
			json.put("member_id", member_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL + "/get");
        post.execute(json.toString());        
	}	
	//会員1人の情報を追加
	public void addMember(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL + "/add");
        post.execute(json.toString());       
	}	
	//会員1人の情報を削除
	public void delMember(String TAG,String member_id){
		JSONObject json = new JSONObject();
		
		try {
			//会員IDをJSONに登録
			json.put("member_id", member_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL + "/del");
        post.execute(json.toString());       
	}	
	//会員1人の情報を更新
	public void upMember(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL + "/up");
        post.execute(json.toString());       
	}	
	//プラン1つの情報を取得
	public void getPlan(String TAG,String member_id,String plan_id){
		JSONObject json = new JSONObject();
		
		try {
			//会員IDをJSONに登録
			json.put("member_id", member_id);
			json.put("plan_id", plan_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + PLAN_URL + "/get");
        post.execute(json.toString());       
	}	
	//プラン1つの情報を追加
	public void addPlan(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + PLAN_URL + "/add");
        post.execute(json.toString());       
	}
	public void delPlan(String TAG,String member_id,String plan_id){	
		//プラン1つの情報を削除
		JSONObject json = new JSONObject();
		
		try {
			//会員IDをJSONに登録
			json.put("member_id", member_id);
			json.put("plan_id", plan_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + PLAN_URL + "/del");
        post.execute(json.toString());       
	}	
	//プラン1つの情報を更新
	public void upPlan(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + PLAN_URL + "/up");
        post.execute(json.toString());       
	}	
	//プランの一覧を取得
	public void getPlanList(String TAG,String text,String category_id){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + PLAN_URL);
		JSONObject json = new JSONObject();
		try {
			//会員IDをJSONに登録
			json.put("text", text);
			json.put("category_id", category_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
        post.execute(json.toString());       
	}	
	//レビュー1つの情報を追加
	public void addReview(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + REVIEW_URL + "/add");
        post.execute(json.toString());       
	}	
	//レビュー1つの情報を削除
	public void delReview(String TAG,String post_member_id,String member_id,String plan_id){	
		//プラン1つの情報を削除
		JSONObject json = new JSONObject();
		
		try {
			//会員IDをJSONに登録
			json.put("post_member_id", post_member_id);
			json.put("member_id", member_id);
			json.put("plan_id", plan_id);
		} catch (JSONException e2) {
			e2.printStackTrace();
		}
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + REVIEW_URL + "/del");
        post.execute(json.toString());       
	}	
	//レビュー1つの情報を更新
	public void upReview(String TAG,JSONObject json){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + REVIEW_URL + "/up");
        post.execute(json.toString());       
	}	
	//ランキング取得
	public void getRanking(String TAG){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL);
        post.execute("{}");       
	}	
	//おすすめ取得
	public void getRecommend(String TAG){
		HttpConnecter post = new HttpConnecter(TAG,activity,SERVER_URL + MEMBER_URL);
        post.execute("{}");       
	}
}