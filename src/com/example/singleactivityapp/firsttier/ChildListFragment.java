package com.example.singleactivityapp.firsttier;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.singleactivityapp.ListFragmentAsChild;
import com.example.singleactivityapp.R;

public class ChildListFragment extends FirstTierFragment {
	private static final String TAG = "Child List Fragment";
	
	@Override
	public String getTagText() {
		return TAG;
	}

	@Override
	public boolean onBackPressed() {
		return false;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return createPersistentView(inflater, container, savedInstanceState, R.layout.child_list_fragment);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		if(!hasInitializedRootView) {
			hasInitializedRootView = true;
			
			// Initialize UI.
			FragmentTransaction ft = getChildFragmentManager().beginTransaction();
			ListFragmentAsChild listFragmentAsChild = new ListFragmentAsChild();
			ft.add(R.id.child_list_fragment_frame, listFragmentAsChild, listFragmentAsChild.TAG);
			ft.commit();
		}
	}
}
