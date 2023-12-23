package com.app.gpsphonelocator_new.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import kotlin.jvm.internal.Intrinsics;


public final class MyViewPagerAdapter extends PagerAdapter {
    private int[] listArr;

    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return view == obj;
    }

    public MyViewPagerAdapter(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "listArr");
        this.listArr = iArr;
    }

    public final int[] getListArr() {
        return this.listArr;
    }

    public final void setListArr(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.listArr = iArr;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.listArr[i], viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(container.context).…ition], container, false)");
        viewGroup.addView(inflate);
        return inflate;
    }

    public int getCount() {
        return this.listArr.length;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Intrinsics.checkNotNullParameter(obj, "object");
        viewGroup.removeView((View) obj);
    }
}
