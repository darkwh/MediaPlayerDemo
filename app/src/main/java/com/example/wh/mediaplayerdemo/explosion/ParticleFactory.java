package com.example.wh.mediaplayerdemo.explosion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;


/**
 * Created by Administrator on 2015/11/29 0029.
 */
public abstract class ParticleFactory {
    public abstract Particle[] generateParticles(Context context, Bitmap bitmap, Rect bound);
}
