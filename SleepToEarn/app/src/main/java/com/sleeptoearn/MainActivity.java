package com.sleeptoearn;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.github.mikephil.charting.*;
import com.google.android.material.button.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private LinearLayout container;
	private LinearLayout linear1;
	private LinearLayout linear7;
	private LinearLayout linear4;
	private ImageView imageview1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private ImageView imageview3;
	private LinearLayout linear3;
	private TextView textview2;
	private TextView textview1;
	private RecyclerView recyclerview1;
	private MaterialButton materialbutton1;
	
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		container = findViewById(R.id.container);
		linear1 = findViewById(R.id.linear1);
		linear7 = findViewById(R.id.linear7);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		recyclerview1 = findViewById(R.id.recyclerview1);
		materialbutton1 = findViewById(R.id.materialbutton1);
	}
	
	private void initializeLogic() {
		intent.setClass(getApplicationContext(), Screen2Activity.class);
		startActivity(intent);
		finish();
	}
	
}