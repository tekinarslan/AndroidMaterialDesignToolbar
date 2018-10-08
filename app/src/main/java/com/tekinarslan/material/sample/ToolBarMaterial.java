package com.tekinarslan.material.sample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class ToolbarMaterial extends AppCompactActivity
    {
       
       public void onCreate(Bundle bundle)
         {
            super.onCreate(bundle);
            setContentView(R.layout.ToolbarMaterial);
            
            mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(mTopToolbar);
         }
         
         
         
         
         
             public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
         
         
         public void Item1(View view)
             {
               Button button1 =findViewById(R.id.button1);
               button1.setOnClickListener(new OnClickListener()
                     {
                         public void onClick(View view)
                              {
                                 
                                   Toast.makeText(this,"Hey you Have done this!!",Toast.LENGTH_LONG).show();
                              }
                      });
               }
               
               
               
           public void Item1(View view)
             {
               Button button2=findViewById(R.id.button2);
               button2.setOnClickListener(new OnClickListener()
                     {
                         public void onClick(View view)
                              {
                                 
                                   Toast.makeText(this,"Hey you Have done this!!",Toast.LENGTH_LONG).show();
                                   
                                   Intent intent=new Intent(this,YourNewActivity.class);
                                   startActivity(intent);
                                   finish();
                              }
                      });
               }
               
               
       
       
       
       
     }
