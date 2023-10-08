package com.sleeptoearn;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class SleepGoalDialogFragmentActivity extends DialogFragment {
	
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	
	private CardView cardview1;
	private LinearLayout linear1;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private LinearLayout linear4;
	private TextView textview3;
	private LinearLayout min_minutes;
	private LinearLayout linear7;
	private LinearLayout max_minutes;
	private TextView textview4;
	private TextView textview5;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.sleep_goal_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		 // Get the dialog's window attributes
		    Window window = getDialog().getWindow();
		    if (window != null) {
			        WindowManager.LayoutParams params = window.getAttributes();
			
			        // Set the desired width and height for the dialog
			        params.width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext()) - 8; // Set your desired width
			        params.height = 215; // Set your desired height
			        window.setAttributes(params);
		}
		cardview1 = _view.findViewById(R.id.cardview1);
		linear1 = _view.findViewById(R.id.linear1);
		textview1 = _view.findViewById(R.id.textview1);
		linear2 = _view.findViewById(R.id.linear2);
		linear3 = _view.findViewById(R.id.linear3);
		linear5 = _view.findViewById(R.id.linear5);
		imageview1 = _view.findViewById(R.id.imageview1);
		textview2 = _view.findViewById(R.id.textview2);
		linear4 = _view.findViewById(R.id.linear4);
		textview3 = _view.findViewById(R.id.textview3);
		min_minutes = _view.findViewById(R.id.min_minutes);
		linear7 = _view.findViewById(R.id.linear7);
		max_minutes = _view.findViewById(R.id.max_minutes);
		textview4 = _view.findViewById(R.id.textview4);
		textview5 = _view.findViewById(R.id.textview5);
		
		min_minutes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Dismiss or close this DialogFragment
				_dismiss_DialogFragment();
				//Open another DialogFragment
				_open_another_DialogFrag();
			}
		});
		
		max_minutes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Dismiss or close this DialogFragment
				_dismiss_DialogFragment();
				//Open another DialogFragment
				_open_another_DialogFrag();
			}
		});
	}
	
	private void initializeLogic() {
		if (getDialog() != null) { 
			int width = ViewGroup.LayoutParams.MATCH_PARENT;
			int height = ViewGroup.LayoutParams.MATCH_PARENT; 
			 getDialog().getWindow().setLayout(width, height);
			getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
		
		RippleUtils.setRippleEffect(min_minutes, rippleColor);
		RippleUtils.setRippleEffect(max_minutes, rippleColor);
		cardview1.setCardBackgroundColor(0xFF2E3A4A);
	}
	
	public void _dismiss_DialogFragment() {
		//Code to dismiss this DialogFragment
		dismiss();
	}
	
	
	public void _open_another_DialogFrag() {
		   // Create an instance of your DialogFragment
		SetTimeDialogFragmentActivity dialogFragment = new SetTimeDialogFragmentActivity();
		
		        // Get the FragmentManager
		        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
		
		        // Show the DialogFragment
		        dialogFragment.show(fragmentManager, "SetTimeDialogFragment");
		    
	}
	
}
