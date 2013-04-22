package star.smsbroadcast;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class broadcast extends Activity {



   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SQLiteDatabase db = openOrCreateDatabase("private_msg", SQLiteDatabase.CREATE_IF_NECESSARY, null);
		String q = "create table if not exists private(id integer,phone_no varchar[20],msg varchar[255]);";
		db.execSQL(q);
		db.close();
		
		
		Toast.makeText(getApplicationContext(), "DB created : ",Toast.LENGTH_SHORT).show();
	  
	   
	}
	

}
