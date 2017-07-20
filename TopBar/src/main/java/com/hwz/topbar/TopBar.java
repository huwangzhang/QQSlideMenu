package com.hwz.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by huwang on 2017/6/2.
 */

public class TopBar extends RelativeLayout {
    private Context mContext;
    private Button mRightButton, mLeftButton;
    private TextView mTitleView;

    private int mLeftTextColor;
    private Drawable mLeftDrawable;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightDrawable;
    private String mRightText;

    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitleText;

    private LayoutParams mLeftParams, mRightParams, mTitleParams;


    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);

        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftDrawable = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = typedArray.getString(R.styleable.TopBar_leftText);

        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightDrawable = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = typedArray.getString(R.styleable.TopBar_rightText);

        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize, 0);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitleText = typedArray.getString(R.styleable.TopBar_title);

        typedArray.recycle();

        iniViews();

        setBackgroundColor(0x848484);
    }

    private void iniViews() {
        mLeftButton = new Button(mContext);
        mRightButton = new Button(mContext);
        mTitleView = new TextView(mContext);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackgroundDrawable(mLeftDrawable);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackgroundDrawable(mRightDrawable);
        mRightButton.setText(mRightText);

        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setText(mTitleText);
        mTitleView.setGravity(Gravity.CENTER);

        mLeftParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "返回键点击了!", Toast.LENGTH_SHORT).show();
                mTopBarClickListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext, "前进键点击了!", Toast.LENGTH_SHORT).show();
                mTopBarClickListener.rightClick();
            }
        });
    }


    private TopBarClickListener mTopBarClickListener;

    public void setTopBarClickListener(TopBarClickListener topBarClickListener) {
        this.mTopBarClickListener = topBarClickListener;
    }

    public interface TopBarClickListener{
        public void leftClick();
        public void rightClick();
    }

    public void setLeftIsVisible(boolean flag) {
        if (flag) {
            mLeftButton.setVisibility(View.VISIBLE);
        } else {
            mLeftButton.setVisibility(View.GONE);
        }
    }
}
