package com.example.share;
// Autore: Digilio Mattia 


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	int dim=10;
	private List<Attach> att=new ArrayList<Attach>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Attach []att=new Attach[dim];
		
		List<String> type= new ArrayList<String>();
		String subType= "image/*";//{"image/*","image/*","image/*"};
		type.add(subType);
		type.add(subType);
		type.add(subType);
		
		List<String> filePath= new ArrayList<String>();//{ "file:///sdcard/dcim/camera/Matt.jpg","file:///sdcard/dcim/camera/Matt.jpg","file:///sdcard/dcim/camera/Matt.jpg"};
		String subFilePath="file:///sdcard/dcim/camera/Matt.jpg";
		filePath.add(subFilePath);
		filePath.add(subFilePath);
		filePath.add(subFilePath);
		
		
		configura(type,filePath);
		String subj="Info corso";
		String text="ciao a tutti ";
		
	Button sharing =  (Button) findViewById(R.id.share);
	
	sharing.setOnClickListener(new OnClickListener() {
		
		
		@Override
		public void onClick(View arg0) {
			String subj="Info corso";
			String text="ciao a tutti ";
			Share.share(MainActivity.this ,subj,text,att);
			
		}
		
	});
	
	}
	
	public void configura(List<String> type, List<String> filePath){
		for(int i=0;i<type.size();i++){
		
			Attach test = new Attach();
			test.setMimeType(type.get(i));
			test.setFilePath(filePath.get(i));
			att.add(test);
		}
	}
	
	public static boolean sametype(List<Attach> att){
		boolean x=true;
		for(int i=0; i<att.size()-1;i++){ // x non uscire dalla memoria
			if(!(att.get(i).mimeType.equals( att.get(i).mimeType))) {
				x=false;
				break;
			}
		}
		return x;
	}
	
	
	
	
	
	
	
}