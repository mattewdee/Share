package com.example.share;
//Autore: Digilio Mattia 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.widget.Toast;

public class Share {
	public static final String TYPE_TEXT = "text/plain";
	public static final String TYPE_IMAGE_PNG = "image/png";
	public static final String TYPE_AUDIO_MP3 = "audio/mpeg3";

	
	

	public static void share(Activity a, List<Attach> att) {
		share(a, null, null, null, null, att);
	}

	public static void share(Activity a, String subj) {
		share(a, subj, null, null, null, null);
	}

	public static void share(Activity a, String subj, List<Attach> att) {
		share(a, subj, null, null, null, att);
	}

	public static void share(Activity a, String subj, String text) {
		share(a, subj, text, null, null, null);
	}

	public static void share(Activity a, String subj, String text, List<Attach> att) {
		share(a, subj, text, null, null, att);
	}

	public static void share(Activity a, String subj, String text, Address add) {
		share(a, subj, text, add, null, null);
	}

	public static void share(Activity a, String subj, String text, String date) {
		share(a, subj, text, null, date, null);
	}

	public static void share(Activity a, String subj, String text, Address add,
			String date) {
		share(a, subj, text, add, date, null);
	}

	public static void share(Activity a, String subj, String text, Address add,
			String date, List<Attach> att) {
		
		Intent i;
		
		if(att.size()>1){
		
				i = new Intent(Intent.ACTION_SEND_MULTIPLE);
		}else{
				i  = new Intent(Intent.ACTION_SEND);
		}
		
		
		if (subj == null && text == null && add == null && date == null
				&& att != null) { // att
			
			if(!MainActivity.sametype(att)){ // se non sono tutti formati uguali
				
				throw new IllegalArgumentException("Argomenti di formato differenti");
				
			}	
			
			i.setType(att.get(0).mimeType); 

			ArrayList<Uri> files = new ArrayList<Uri>();

			for(int x=0; x<att.size();x++) {
				String filepath=att.get(x).filePath;
				Uri uri = Uri.parse(filepath);
				files.add(uri);
			}

			i.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
		}
		if (subj != null && text == null && add == null && date == null
				&& att == null) { // subj
			String doc = subj;
			i.setType(TYPE_TEXT);
			i.putExtra(Intent.EXTRA_SUBJECT, doc);
		}
		if (subj != null && text != null && add == null && date == null
				&& att == null) { // subj text
			String doc = text;
			i.setType(TYPE_TEXT);
			i.putExtra(Intent.EXTRA_TEXT, doc);
		}
		if (subj != null && text != null && add == null && date == null
				&& att != null) { // subj text att
			String doc = text;
			
			if(!MainActivity.sametype(att)){ // se non sono tutti formati uguali
				
		throw new IllegalArgumentException("Argomenti di formato differenti");
				
			}	
			i.putExtra(Intent.EXTRA_SUBJECT, subj);
			i.putExtra(Intent.EXTRA_TEXT, doc);
			i.setType(att.get(0).mimeType); 

			ArrayList<Uri> files = new ArrayList<Uri>();

			for(int x=0; x<att.size();x++) {
				String filepath=att.get(x).filePath;
				Uri uri = Uri.parse(filepath);
				files.add(uri);
			}

			i.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
			
		}
		if (subj != null && text != null && add != null && date == null
				&& att == null) { // subj text add
			String doc = subj + "\n" + text + "\n" + add;
			i.setType(TYPE_TEXT);
			i.putExtra(Intent.EXTRA_SUBJECT, subj);
			i.putExtra(Intent.EXTRA_TEXT, doc);
		}
		if (subj != null && text != null && add != null && date != null
				&& att == null) { // subj text add date
			String doc = text + "\n" + add + "\n" + date;
			i.setType(TYPE_TEXT);
			i.putExtra(Intent.EXTRA_SUBJECT, subj);
			i.putExtra(Intent.EXTRA_TEXT, doc);
		}
		if (subj != null && text != null && add != null && date != null
				&& att != null) { // subj text add date att
			String doc = text + "\n" + add + "\n" + date;
			
			
		
			
			if(!MainActivity.sametype(att)){ // se non sono tutti formati uguali
				
				throw new IllegalArgumentException("Argomenti di formato differenti");
			}	
			
			i.setType(att.get(0).mimeType); 

			ArrayList<Uri> files = new ArrayList<Uri>();

			for(int x=0; x<att.size();x++) {
				String filepath=att.get(x).filePath;
				Uri uri = Uri.parse(filepath);
				files.add(uri);
			}
			i.putExtra(Intent.EXTRA_SUBJECT, subj);
			i.putExtra(Intent.EXTRA_TEXT, doc);
			i.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
		}
		if (subj != null && text == null && add == null && date == null
				&& att != null) { // subj att
			
			
			if(!MainActivity.sametype(att)){ // se non sono tutti formati uguali
				
				throw new IllegalArgumentException("Argomenti di formato differenti");
			}	
			
			i.setType(att.get(0).mimeType); 

			ArrayList<Uri> files = new ArrayList<Uri>();

			for(int x=0; x<att.size();x++) {
				String filepath=att.get(x).filePath;
				Uri uri = Uri.parse(filepath);
				files.add(uri);
			}
			
			i.putExtra(Intent.EXTRA_SUBJECT, subj);
			i.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
		}
		a.startActivity(Intent.createChooser(i, a.getString(R.string.app_name)));
	}
}