//package com.example.share;
//// Autore: Digilio Mattia 
//
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.Intent;
//import android.view.Menu;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//
//
//public class MainActivity extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		final Attach att=new Attach();
//		String type="image/*";
//		String filePath= "file:///sdcard/dcim/camera/Matt.jpg";
//		configura(att,type,filePath);
//		String subj="Info corso";
//		String text="ciao a tutti ";
//		
//	Button sharing =  (Button) findViewById(R.id.share);
//	
//	sharing.setOnClickListener(new OnClickListener() {
//		
//		
//		@Override
//		public void onClick(View arg0) {
//			String subj="Info corso";
//			String text="ciao a tutti ";
//			Share.share(MainActivity.this ,subj,text, att);
//			
//		}
//		
//	});
//	
//	}
//	
//	public void configura(Attach att, String type, String filePath){
//		att.mimeType=type;
//		att.filePath=filePath;
//	
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////share
//
//
//package com.example.share;
////Autore: Digilio Mattia 
//import android.app.Activity;
//import android.content.Intent;
//import android.location.Address;
//import android.net.Uri;
//
//public class Share {
//	public static final String TYPE_TEXT = "text/plain";
//	public static final String TYPE_IMAGE_PNG = "image/png";
//	public static final String TYPE_AUDIO_MP3 = "audio/mpeg3";
//	public static String InternalSD = "file:///sdcard/dcim/camera/"; // path to catch media on internal memory
//	public static String miniSD = "file:///sdcard/"; // path to catch media on external memory
//
//	public static void share(Activity a, Attach att) {
//		share(a, null, null, null, null, att);
//	}
//
//	public static void share(Activity a, String subj) {
//		share(a, subj, null, null, null, null);
//	}
//
//	public static void share(Activity a, String subj, Attach att) {
//		share(a, subj, null, null, null, att);
//	}
//
//	public static void share(Activity a, String subj, String text) {
//		share(a, subj, text, null, null, null);
//	}
//
//	public static void share(Activity a, String subj, String text, Attach att) {
//		share(a, subj, text, null, null, att);
//	}
//
//	public static void share(Activity a, String subj, String text, Address add) {
//		share(a, subj, text, add, null, null);
//	}
//
//	public static void share(Activity a, String subj, String text, String date) {
//		share(a, subj, text, null, date, null);
//	}
//
//	public static void share(Activity a, String subj, String text, Address add,
//			String date) {
//		share(a, subj, text, add, date, null);
//	}
//
//	public static void share(Activity a, String subj, String text, Address add,
//			String date, Attach att) {
//		Intent i = new Intent(Intent.ACTION_SEND);
//		if (subj == null && text == null && add == null && date == null
//				&& att != null) { // att
//			i.setType(att.mimeType);
//			String filePath =att.filePath;
//			Uri uri = Uri.parse(filePath);
//			i.putExtra(Intent.EXTRA_STREAM, uri);
//		}
//		if (subj != null && text == null && add == null && date == null
//				&& att == null) { // subj
//			String doc = subj;
//			i.setType(TYPE_TEXT);
//			i.putExtra(Intent.EXTRA_SUBJECT, doc);
//		}
//		if (subj != null && text != null && add == null && date == null
//				&& att == null) { // subj text
//			String doc = text;
//			i.setType(TYPE_TEXT);
//			i.putExtra(Intent.EXTRA_TEXT, doc);
//		}
//		if (subj != null && text != null && add == null && date == null
//				&& att != null) { // subj text att
//			String doc = text;
//			i.setType(att.mimeType);
//			String filePath =att.filePath;
//			Uri uri = Uri.parse(filePath);
//			i.putExtra(Intent.EXTRA_SUBJECT, subj);
//			i.putExtra(Intent.EXTRA_TEXT, doc);
//			i.putExtra(Intent.EXTRA_STREAM, uri);
//		}
//		if (subj != null && text != null && add != null && date == null
//				&& att == null) { // subj text add
//			String doc = subj + "\n" + text + "\n" + add;
//			i.setType(TYPE_TEXT);
//			i.putExtra(Intent.EXTRA_SUBJECT, subj);
//			i.putExtra(Intent.EXTRA_TEXT, doc);
//		}
//		if (subj != null && text != null && add != null && date != null
//				&& att == null) { // subj text add date
//			String doc = text + "\n" + add + "\n" + date;
//			i.setType(TYPE_TEXT);
//			i.putExtra(Intent.EXTRA_SUBJECT, subj);
//			i.putExtra(Intent.EXTRA_TEXT, doc);
//		}
//		if (subj != null && text != null && add != null && date != null
//				&& att != null) { // subj text add date att
//			String doc = text + "\n" + add + "\n" + date;
//			i.setType(att.mimeType);
//			String filePath =att.filePath;
//			Uri uri = Uri.parse(filePath);
//			i.putExtra(Intent.EXTRA_SUBJECT, subj);
//			i.putExtra(Intent.EXTRA_TEXT, doc);
//			i.putExtra(Intent.EXTRA_STREAM, uri);
//		}
//		if (subj != null && text == null && add == null && date == null
//				&& att != null) { // subj att
//			i.setType(att.mimeType);
//			String filePath =att.filePath;
//			Uri uri = Uri.parse(filePath);
//			i.putExtra(Intent.EXTRA_SUBJECT, subj);
//			i.putExtra(Intent.EXTRA_STREAM, uri);
//		}
//		a.startActivity(Intent.createChooser(i, a.getString(R.string.app_name)));
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////attach
//
//package com.example.share;
////Autore: Digilio Mattia 
//import android.R.string;
//
//public class Attach {
//
//	String filePath;
//	String mimeType; // video/* or image/*
//	
//	
//
//public String getmimeType(){
//		
//		return mimeType;
//	}
//public String getFilePath(){
//	
//	return filePath;
//}
//
//
//}
//
