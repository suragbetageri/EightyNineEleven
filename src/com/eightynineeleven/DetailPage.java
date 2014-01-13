package com.eightynineeleven;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class DetailPage extends Activity {
	
	private ImageView mImageview;
	private TextView mQuote;
	private int mPosition;
	
	public static int ABOUTUS = 0;
	public static int LOOKBOOK = 1;
	public static int BLOG = 2;
	public static int CONTACT = 3;
	static int LOOKBOOK_LENGTH = 32;
	//public Typeface courier_new = Typeface.createFromAsset(getAssets(), "fonts/COUR.TTF");
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		Typeface courier_new = Typeface.createFromAsset(getAssets(), "fonts/COUR.TTF");
		Typeface courier_new_bold = Typeface.createFromAsset(getAssets(), "fonts/COURBD.TTF");
		Typeface brush_script = Typeface.createFromAsset(getAssets(), "fonts/BRUSHSCI.TTF");
		mPosition = i.getIntExtra("position", 0);
		
		if(mPosition == ABOUTUS){
			setContentView(R.layout.about_us);
			TextView tv = (TextView) findViewById(R.id.title);
			TextView tv1 = (TextView) findViewById(R.id.about);
			tv.setTypeface(courier_new_bold);
			tv1.setTypeface(courier_new);
		} else if(mPosition == LOOKBOOK){
			setContentView(R.layout.look_book);
			TextView tv2 = (TextView) findViewById(R.id.lookbook_title);
			tv2.setTypeface(courier_new_bold);
			TextView tv3 = (TextView) findViewById(R.id.models);
			tv3.setTypeface(courier_new);
			
			Gallery gallery = (Gallery) findViewById(R.id.gallery);
		    gallery.setAdapter(new ImageAdapter(this));

		    gallery.setOnItemClickListener(new OnItemClickListener() {
		        public void onItemClick(AdapterView parent, View v, int position, long id) {
		            Toast.makeText(DetailPage.this, position+1 + " of " + LOOKBOOK_LENGTH, Toast.LENGTH_SHORT).show();
		        }
		    });
		    
		    
		} else if(mPosition == BLOG){
			setContentView(R.layout.blog);
			TextView title_120811 = (TextView) findViewById(R.id.title_120811);
			TextView title_120411 = (TextView) findViewById(R.id.title_120411);
			TextView title_082711 = (TextView) findViewById(R.id.title_082711);
			TextView title_082311 = (TextView) findViewById(R.id.title_082311);
			TextView title_082011 = (TextView) findViewById(R.id.title_082011);
			TextView title_081011 = (TextView) findViewById(R.id.title_081011);
			title_120811.setTypeface(brush_script);
			title_120411.setTypeface(brush_script);
			title_082711.setTypeface(brush_script);
			title_082311.setTypeface(brush_script);
			title_082011.setTypeface(brush_script);
			title_081011.setTypeface(brush_script);
			
			TextView post_120811 = (TextView) findViewById(R.id.post_120811);
			TextView post_120411 = (TextView) findViewById(R.id.post_120411);
			TextView post2_120411 = (TextView) findViewById(R.id.post2_120411);
			TextView post_082711 = (TextView) findViewById(R.id.post_082711);
			TextView post2_082711 = (TextView) findViewById(R.id.post2_082711);
			TextView post3_082711 = (TextView) findViewById(R.id.post3_082711);
			TextView post4_082711 = (TextView) findViewById(R.id.post4_082711);
			TextView post_082311 = (TextView) findViewById(R.id.post_082311);
			post_120811.setTypeface(courier_new);
			post_120411.setTypeface(courier_new);
			post2_120411.setTypeface(courier_new);
			post_082711.setTypeface(courier_new);
			post2_082711.setTypeface(courier_new);
			post3_082711.setTypeface(courier_new);
			post4_082711.setTypeface(courier_new);
			post_082311.setTypeface(courier_new);
			
			
			
		} else if(mPosition == CONTACT){
			setContentView(R.layout.contact_us);
			TextView contact_title = (TextView) findViewById(R.id.contact_title);
			TextView email = (TextView) findViewById(R.id.email);
			TextView email1= (TextView) findViewById(R.id.email1);
			ImageView website1 = (ImageView) findViewById(R.id.website1);
			ImageView facebook1 = (ImageView) findViewById(R.id.facebook1);
			contact_title.setTypeface(courier_new_bold);
			email.setTypeface(courier_new_bold);
			email1.setTypeface(courier_new);
			
			website1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.addCategory(Intent.CATEGORY_BROWSABLE);
					intent.setData(Uri.parse("http://eightynine-eleven.blogspot.com/"));
					startActivity(intent);
				}
			});
			
			facebook1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.addCategory(Intent.CATEGORY_BROWSABLE);
					intent.setData(Uri.parse("https://www.facebook.com/eightynine.eleven"));
					startActivity(intent);
				}
			});
		}
	
	}	
	
	public class ImageAdapter extends BaseAdapter {
	    int mGalleryItemBackground;
	    private Context mContext;

	    private Integer[] mImageIds = {
	            //R.drawable.sample_0,
	            R.drawable.lookbook1,
	            R.drawable.lookbook2,
	            R.drawable.lookbook3,
	            R.drawable.lookbook4,
	            R.drawable.lookbook5,
	            R.drawable.lookbook6,
	            R.drawable.lookbook7,
	            R.drawable.lookbook8,
	            R.drawable.lookbook9,
	            R.drawable.lookbook10,
	            R.drawable.lookbook11,
	            R.drawable.lookbook12,
	            R.drawable.lookbook13,
	            R.drawable.lookbook14,
	            R.drawable.lookbook15,
	            R.drawable.lookbook16,
	            R.drawable.lookbook17,
	            R.drawable.lookbook18,
	            R.drawable.lookbook19,
	            R.drawable.lookbook20,
	            R.drawable.lookbook21,
	            R.drawable.lookbook22,
	            R.drawable.lookbook23,
	            R.drawable.lookbook24,
	            R.drawable.lookbook25,
	            R.drawable.lookbook26,
	            R.drawable.lookbook27,
	            R.drawable.lookbook28,
	            R.drawable.lookbook29,
	            R.drawable.lookbook30,
	            R.drawable.lookbook31,
	            R.drawable.lookbook32
	    };

	    public ImageAdapter(Context c) {
	        mContext = c;
	        TypedArray attr = mContext.obtainStyledAttributes(R.styleable.HelloGallery);
	        mGalleryItemBackground = attr.getResourceId(
	                R.styleable.HelloGallery_android_galleryItemBackground, 0);
	        attr.recycle();
	    }

	    public int getCount() {
	        return mImageIds.length;
	    }

	    public Object getItem(int position) {
	        return position;
	    }

	    public long getItemId(int position) {
	        return position;
	    }

	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView = new ImageView(mContext);

	        imageView.setImageResource(mImageIds[position]);
	        if(position == 9 || position == 16){
	        	imageView.setLayoutParams(new Gallery.LayoutParams(480, 360));
	        } else {
	        	imageView.setLayoutParams(new Gallery.LayoutParams(360, 480));
	        }
	        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
	        imageView.setBackgroundResource(mGalleryItemBackground);

	        return imageView;
	    }
	}
	
}