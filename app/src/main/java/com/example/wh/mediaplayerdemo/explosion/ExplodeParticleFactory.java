package com.example.wh.mediaplayerdemo.explosion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.wh.mediaplayerdemo.R;

/**
 * Created by Administrator on 2015/11/29 0029.
 */
public class ExplodeParticleFactory extends ParticleFactory {
    private int imageCount = 1;

    public Particle[] generateParticles(Context context, Bitmap bitmap, Rect bound) {

        Particle[] particles = new Particle[imageCount];
        for (int i = 0; i < imageCount; i++) {
            int resId = 0;
            switch (i % 3) {
                case 0:
                    resId = R.drawable.ic_explode1;
                    break;
                case 1:
                    resId = R.drawable.ic_explode2;
                    break;
                case 2:
                    resId = R.drawable.ic_explode3;
                    break;
                default:
                    break;
            }
            particles[i] = generateParticle(context, resId);
        }
        return particles;
    }

    private Particle generateParticle(Context context, int resId) {
        return new ExplodeParticle(context, resId, 0, 0);
    }
}
