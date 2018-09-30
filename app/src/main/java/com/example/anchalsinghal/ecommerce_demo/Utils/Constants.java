package com.example.anchalsinghal.ecommerce_demo.Utils;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;

public class Constants {
    
    
   public static void getAnimation(final RecyclerView recyclerView)
    {
        recyclerView.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {

                    @Override
                    public boolean onPreDraw() {
                        recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);

                        for (int i = 0; i < recyclerView.getChildCount(); i++) {
                            View v = recyclerView.getChildAt(i);
                            v.setAlpha(0.0f);
                            v.animate().alpha(1.0f)
                                    .setDuration(300)
                                    .setStartDelay(i * 50)
                                    .start();
                        }

                        return true;
                    }
                });
    }
    
    
}
