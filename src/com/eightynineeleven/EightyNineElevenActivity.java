package com.eightynineeleven;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class EightyNineElevenActivity extends Activity {
    /** Called when the activity is first created. */
	
	static int LIST_LENGTH = 4;
	public static int ABOUTUS = 0;
	public static int LOOKBOOK = 1;
	public static int BLOG = 2;
	public static int CONTACT = 3;
	
	
	public class EightyNineElevenAdapter extends BaseAdapter {
    	
		public int getCount() {
			return LIST_LENGTH;
		}
		
		public Object getItem(int position) {
			return position;
		}
		 
		public long getItemId(int position) {
			return position;
		}
		 
		public View getView(int position, View convertView, ViewGroup parent) {
			//ImageView thumbnail;
			TextView title;
		 
		    if(convertView == null) {
				convertView = mInflator.inflate(R.layout.list_item_layout, parent, false);
			}
		 
		    Typeface courier_new = Typeface.createFromAsset(getAssets(), "fonts/COUR.TTF");
			title = (TextView) convertView.findViewById(R.list.text);
			title.setTypeface(courier_new);
			//title.setText(mDataSource.getmQuotePool().get(position));
			if(position == ABOUTUS){
				title.setText("About Us");
			} else if(position == LOOKBOOK){
				title.setText("Fall 2011 Look Book");
			} else if(position == BLOG){
				title.setText("Our Blog");
			} else if(position == CONTACT){
				title.setText("Contact Us");
			}
			//title.setTextColor(Color.BLACK);
			//title.setTypeface(Typeface.SERIF);
			return convertView;
		}
        
        private Context mContext;
        private LayoutInflater mInflator;
        //private DataSource mDataSource;
         
        public EightyNineElevenAdapter(Context c) {
                mContext = c;
                mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //mDataSource = new DataSource();
        }

    }
	
	private ListView mListView;
	private int currentView = -1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mListView = (ListView) findViewById(R.id.table_of_contents);
        mListView.setAdapter(new EightyNineElevenAdapter(this));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				currentView = arg2;
				Intent i = new Intent(EightyNineElevenActivity.this, DetailPage.class);
				i.putExtra("position", arg2);
        		startActivity(i);
			}
        });
    }
    
}