package com.example.wh.mediaplayerdemo.explosion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.IdRes;

/**
 * Created by azz on 15/11/19.
 * 爆破粒子
 */
public abstract class Particle {
    protected float cx;
    protected float cy;
    protected int resId;
    protected Context mContext;


    /**
     * @param resId //资源文件ID
     * @param x     //x坐标
     * @param y     //y坐标
     */
    public Particle(Context context, @IdRes int resId, float x, float y) {
        this.resId = resId;
        mContext = context;
        cx = x;
        cy = y;
    }

    protected abstract void draw(Canvas canvas, Paint paint);

    protected abstract void caculate(float factor);

    public void advance(Canvas canvas, Paint paint, float factor) {
        caculate(factor);
        draw(canvas, paint);
    }
}
