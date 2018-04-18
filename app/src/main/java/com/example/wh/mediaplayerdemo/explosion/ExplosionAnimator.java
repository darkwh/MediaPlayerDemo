package com.example.wh.mediaplayerdemo.explosion;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.LinearInterpolator;


/**
 * Created by Administrator on 2015/11/28 0028.
 */
public class ExplosionAnimator extends ValueAnimator {
    public static final int DEFAULT_DURATION = 2000;
    private Particle[] mParticles;
    private Paint mPaint;
    private View mContainer;
    private ParticleFactory mParticleFactory;

    public ExplosionAnimator(View view, Bitmap bitmap, Rect bound, ParticleFactory particleFactory) {
        mParticleFactory = particleFactory;
        mPaint = new Paint();
        mContainer = view;
        setFloatValues(0.0f, 1.0f);
//        setInterpolator(new DecelerateInterpolator());
        setInterpolator(new LinearInterpolator());
//        setInterpolator(new AccelerateDecelerateInterpolator());
        setDuration(DEFAULT_DURATION);
        mParticles = mParticleFactory.generateParticles(view.getContext(), bitmap, bound);
    }

    public void draw(Canvas canvas) {
        if (!isStarted()) { //动画结束时停止
            return;
        }
        //所有粒子运动
        for (Particle particle : mParticles) {
            particle.advance(canvas, mPaint, (Float) getAnimatedValue());
        }
        mContainer.invalidate();
    }

    @Override
    public void start() {
        super.start();
        mContainer.invalidate();
    }
}
