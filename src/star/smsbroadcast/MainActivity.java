package star.smsbroadcast;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends BroadcastReceiver {

	
	public static int cnt=0;
	
	@Override
	public void onReceive(Context mc, Intent intent) {
		// TODO Auto-generated method stub
		 Bundle pudsBundle = intent.getExtras();
		
	     Object[] pdus =  (Object[]) pudsBundle.get("pdus");
	     SmsMessage messages =SmsMessage.createFromPdu((byte[]) pdus[0]);    
	     Log.i("hello",  messages.getMessageBody());
	    String st = messages.getDisplayMessageBody();
	    if(st.contains("hello"))
	    { //Toast.makeText(mc, "SMS Deleted : ",Toast.LENGTH_LONG).show();
	     
	     SQLiteDatabase db = mc.openOrCreateDatabase("private_msg", SQLiteDatabase.OPEN_READWRITE, null);
			ContentValues values =new ContentValues();
			values.put("id", cnt);
			values.put("phone_no", messages.getOriginatingAddress());
			values.put("msg", messages.getMessageBody());
			
			db.insert("private",null,values);
			db.close();
			Toast.makeText(mc, "SMS Added to DB :)  "+cnt,Toast.LENGTH_LONG).show();
			cnt++;
			abortBroadcast();}
	    else
	    Toast.makeText(mc, "Not detlel : ",Toast.LENGTH_LONG).show();
	    
	    
	    
	    
	}

	
}
