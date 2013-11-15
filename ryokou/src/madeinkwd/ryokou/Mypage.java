package madeinkwd.ryokou;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
 
public class Mypage extends Activity{
   
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
         
        Button button1 = (Button)findViewById(R.id.taikaibutton);
        button1.setOnClickListener(new OnClickListener(){
         @Override
           public void onClick(View v) {
               Intent taiintent = new Intent(Mypage.this, Taikai.class);
               startActivity(taiintent);
          }
        });
        
        Button button2 = (Button)findViewById(R.id.myplanbutton);
        button2.setOnClickListener(new OnClickListener(){
         @Override
           public void onClick(View v) {
               Intent planintent = new Intent(Mypage.this, Myplanitiran.class);
               startActivity(planintent);
          }
        });
        
        Button button3 = (Button)findViewById(R.id.plansakuseibutton);
        button3.setOnClickListener(new OnClickListener(){
         @Override
           public void onClick(View v) {
               Intent sakuseiintent = new Intent(Mypage.this, Plansakusei.class);
               startActivity(sakuseiintent);
          }
        });
        
        Button button4 = (Button)findViewById(R.id.kousinbutton);
        button4.setOnClickListener(new OnClickListener(){
         @Override
           public void onClick(View v) {
               Intent kousinintent = new Intent(Mypage.this, Kousin.class);
               startActivity(kousinintent);
          }
        });
    }
}
