package com.androidhub4you.multilevellistview;

import java.util.ArrayList;

import com.androidhub4you.multilevellistview.Product.SubCategory;
import com.androidhub4you.multilevellistview.Product.SubCategory.ItemList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * 
 * @author manish
 *
 */
public class MainActivity extends Activity {
	
	private ArrayList<Product>pProductArrayList;
	private ArrayList<SubCategory>pSubItemArrayList;
	private ArrayList<SubCategory>pSubItemArrayList2;
	private LinearLayout mLinearListView;
	boolean isFirstViewClick=false;
	boolean isSecondViewClick=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLinearListView = (LinearLayout) findViewById(R.id.linear_listview);
		
		/**
		 * 
		 */
		
		ArrayList<ItemList> mItemListArray=new ArrayList<ItemList>();
		mItemListArray.add(new ItemList("Red", "20"));
		mItemListArray.add(new ItemList("Blue", "50"));
		mItemListArray.add(new ItemList("Red", "20"));
		mItemListArray.add(new ItemList("Blue", "50"));
		
		ArrayList<ItemList> mItemListArray2=new ArrayList<ItemList>();
		mItemListArray2.add(new ItemList("Pant", "2000"));
		mItemListArray2.add(new ItemList("Shirt", "1000"));
		mItemListArray2.add(new ItemList("Pant", "2000"));
		mItemListArray2.add(new ItemList("Shirt", "1000"));
		mItemListArray2.add(new ItemList("Pant", "2000"));
		mItemListArray2.add(new ItemList("Shirt", "1000"));
		
		
		/**
		 * 
		 */
		pSubItemArrayList=new ArrayList<SubCategory>();
		pSubItemArrayList2=new ArrayList<SubCategory>();
		pSubItemArrayList.add(new SubCategory("Color", mItemListArray));
		pSubItemArrayList2.add(new SubCategory("Cloths", mItemListArray2));
		pSubItemArrayList.add(new SubCategory("Color", mItemListArray));
		pSubItemArrayList2.add(new SubCategory("Cloths", mItemListArray2));
		/**
		 * 
		 */
		
		pProductArrayList=new ArrayList<Product>();
		pProductArrayList.add(new Product("Emotions", pSubItemArrayList));
		pProductArrayList.add(new Product("Garments", pSubItemArrayList2));
		
		
		/***
		 * adding item into listview
		 */
		for (int i = 0; i < pProductArrayList.size(); i++) {
			
			LayoutInflater inflater = null;
			inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View mLinearView = inflater.inflate(R.layout.row_first, null);
			
			final TextView mProductName = (TextView) mLinearView.findViewById(R.id.textViewName);
			final RelativeLayout mLinearFirstArrow=(RelativeLayout)mLinearView.findViewById(R.id.linearFirst);
			final ImageView mImageArrowFirst=(ImageView)mLinearView.findViewById(R.id.imageFirstArrow);
			final LinearLayout mLinearScrollSecond=(LinearLayout)mLinearView.findViewById(R.id.linear_scroll);
			
			if(isFirstViewClick==false){
			mLinearScrollSecond.setVisibility(View.GONE);
			mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
			}
			else{
				mLinearScrollSecond.setVisibility(View.VISIBLE);
				mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
			}
			
			mLinearFirstArrow.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					
					if(isFirstViewClick==false){
						isFirstViewClick=true;
						mImageArrowFirst.setBackgroundResource(R.drawable.arw_down);
						mLinearScrollSecond.setVisibility(View.VISIBLE);
						
					}else{
						isFirstViewClick=false;
						mImageArrowFirst.setBackgroundResource(R.drawable.arw_lt);
						mLinearScrollSecond.setVisibility(View.GONE);	
					}
					return false;
				} 
			});
			
			
			final String name = pProductArrayList.get(i).getpName();
			mProductName.setText(name);
		    
			/**
			 * 
			 */
		    for (int j = 0; j < pProductArrayList.get(i).getmSubCategoryList().size(); j++) {
				
				LayoutInflater inflater2 = null;
				inflater2 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				View mLinearView2 = inflater2.inflate(R.layout.row_second, null);
		    
				TextView mSubItemName = (TextView) mLinearView2.findViewById(R.id.textViewTitle);
				final RelativeLayout mLinearSecondArrow=(RelativeLayout)mLinearView2.findViewById(R.id.linearSecond);
				final ImageView mImageArrowSecond=(ImageView)mLinearView2.findViewById(R.id.imageSecondArrow);
				final LinearLayout mLinearScrollThird=(LinearLayout)mLinearView2.findViewById(R.id.linear_scroll_third);
				
				if(isSecondViewClick==false){
					mLinearScrollThird.setVisibility(View.GONE);
					mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
					}
					else{
						mLinearScrollThird.setVisibility(View.VISIBLE);
						mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
					}
					
				mLinearSecondArrow.setOnTouchListener(new OnTouchListener() {
						
						@Override
						public boolean onTouch(View v, MotionEvent event) {
							
							if(isSecondViewClick==false){
								isSecondViewClick=true;
								mImageArrowSecond.setBackgroundResource(R.drawable.arw_down);
								mLinearScrollThird.setVisibility(View.VISIBLE);
								
							}else{
								isSecondViewClick=false;
								mImageArrowSecond.setBackgroundResource(R.drawable.arw_lt);
								mLinearScrollThird.setVisibility(View.GONE);	
							}
							return false;
						} 
					});
				
				
				final String catName = pProductArrayList.get(i).getmSubCategoryList().get(j).getpSubCatName();
				mSubItemName.setText(catName);
				/**
				 * 
				 */
				  for (int k = 0; k < pProductArrayList.get(i).getmSubCategoryList().get(j).getmItemListArray().size(); k++) {
						
						LayoutInflater inflater3 = null;
						inflater3 = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						View mLinearView3 = inflater3.inflate(R.layout.row_third, null);
				    
						TextView mItemName = (TextView) mLinearView3.findViewById(R.id.textViewItemName);
						TextView mItemPrice = (TextView) mLinearView3.findViewById(R.id.textViewItemPrice);
						final String itemName = pProductArrayList.get(i).getmSubCategoryList().get(j).getmItemListArray().get(k).getItemName();
						final String itemPrice = pProductArrayList.get(i).getmSubCategoryList().get(j).getmItemListArray().get(k).getItemPrice();
						mItemName.setText(itemName);
						mItemPrice.setText(itemPrice);
						
						mLinearScrollThird.addView(mLinearView3);
				  }
				
				mLinearScrollSecond.addView(mLinearView2);
		    
		    }
		    
		    mLinearListView.addView(mLinearView);
		}		
	}

}
