package uk.co.androidalliance.edgeeffectoverride;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;

import com.viewpagerindicator.TabPageIndicator;

public class EdgeEffectTabPageIndicator extends TabPageIndicator {
	public EdgeEffectTabPageIndicator(Context context) {
		this(context, null);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public EdgeEffectTabPageIndicator(Context context, AttributeSet attrs) {
		super(new ContextWrapperEdgeEffect(context), attrs);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			init(context, attrs, android.R.attr.horizontalScrollViewStyle);
		} else {
			init(context, attrs, 0);
		}
	}


	private void init(Context context, AttributeSet attrs, int defStyle){
		int color = context.getResources().getColor(R.color.default_edgeeffect_color);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EdgeEffectView, defStyle, 0);

		setEdgeEffectColor(color = a.getColor(R.styleable.EdgeEffectView_edgeeffect_color, color));

		a.recycle();
	}

	public void setEdgeEffectColor(int edgeEffectColor){
		((ContextWrapperEdgeEffect) getContext()).setEdgeEffectColor(edgeEffectColor);
	}
}
