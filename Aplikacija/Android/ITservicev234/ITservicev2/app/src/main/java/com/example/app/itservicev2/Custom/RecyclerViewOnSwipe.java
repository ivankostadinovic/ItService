package com.example.app.itservicev2.Custom;


import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerViewOnSwipe implements RecyclerView.OnItemTouchListener {



    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private OnTouchActionListener mOnTouchActionListener;
    private GestureDetectorCompat mGestureDetector;

    public static interface OnTouchActionListener {
        public void onLeftSwipe(View view, int position);
        public void onRightSwipe(View view, int position);
        public void onClick(View view, int position);
    }

    public RecyclerViewOnSwipe(Context context, final RecyclerView recyclerView,
                           OnTouchActionListener onTouchActionListener){

        mOnTouchActionListener = onTouchActionListener;
        mGestureDetector = new GestureDetectorCompat(context,new GestureDetector.SimpleOnGestureListener(){


            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2,
                                   float velocityX, float velocityY) {

                try {
                    //Koji item u recyclu je swipovan
                    View child = recyclerView.findChildViewUnder(e1.getX(), e1.getY());
                    //ako nije na itemu nego na recyclu onda se postavlja on kao view
                    int childPosition;
                    if(child==null) {
                        child = recyclerView;
                        childPosition=0;
                    }
                    else
                        childPosition = recyclerView.getChildPosition(child);

                    // right to left swipe
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                            if (diffX > 0) {
                                if (mOnTouchActionListener != null )
                                    mOnTouchActionListener.onRightSwipe(child, childPosition);
                            } else {
                                if (mOnTouchActionListener != null )
                                    mOnTouchActionListener.onLeftSwipe(child, childPosition);
                            }
                        }
                    }

                } catch (Exception e) {

                }

                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        mGestureDetector.onTouchEvent(e);
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}