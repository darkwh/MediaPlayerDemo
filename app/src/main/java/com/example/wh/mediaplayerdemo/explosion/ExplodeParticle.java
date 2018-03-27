package com.example.wh.mediaplayerdemo.explosion;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.IdRes;
import android.util.Log;

import java.util.Random;

import static com.example.wh.mediaplayerdemo.explosion.ExplosionAnimator.DEFAULT_DURATION;


/**
 * @author crazychen
 * @version 1.0
 * @date 2015/12/2
 */
public class ExplodeParticle extends Particle {

    /***
     * 图片资源的原Bitmap
     */
    private Bitmap sourceBitmap;
    /**
     * 旋转后的图片资源Bitmap
     */
    private Bitmap drawBitmap;
    /**
     * 爆炸元素的爆炸半径
     */
    private double radius;
    /**
     * 矢量速度正交分解后的x方向速度
     */
    private double velocityX;
    /**
     * 矢量速度正交分解后的y方向速度
     */
    private double velocityY;
    /**
     * 粒子爆炸角度
     */
    private double angle;
    /**
     * Bitmap缩放比例
     */
    private float scale = 0.5f;
    /**
     * 图片旋转角度
     */
    private float rotate = 0;

    /**
     * @param resId //资源文件ID
     * @param x     //x坐标
     * @param y     //y坐标
     */
    public ExplodeParticle(Context context, @IdRes int resId, float x, float y) {
        super(context, resId, x, y);
        cx = 600;
        cy = 600;
        sourceBitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        radius = new Random().nextInt(2500) + 4000;
        //TODO 此处待优化,使爆炸元素分布更均匀
        angle = new Random().nextInt(360);
        Log.d("wh", "radius is " + radius);
        velocityX = Double.valueOf((radius / DEFAULT_DURATION) * Math.cos(angle)).floatValue();
        velocityY = Double.valueOf(radius / DEFAULT_DURATION * Math.sin(angle)).floatValue();
    }


    @Override
    protected void draw(Canvas canvas, Paint paint) {
        if (drawBitmap != null) {
            canvas.drawBitmap(drawBitmap, cx, cy, paint);
        }
    }

    @Override
    protected void caculate(float factor) {
        cx += velocityX * radius / DEFAULT_DURATION * factor;
        cy += velocityY * radius / DEFAULT_DURATION * factor;
        if (factor < 0.1) {
            scale = (float) (0.2f + (factor / 0.1) * 1.1);
        } else {
            scale = (float) (1.3f * (1.1 - factor));
        }
        rotate = 360 * factor;
        // 定义矩阵对象
        Matrix matrix = new Matrix();
        // 缩放原图
        matrix.postScale(scale, scale, cx, cy);
        // 向左旋转45度，参数为正则向右旋转
        matrix.postRotate(rotate, cx, cy);
        drawBitmap = Bitmap.createBitmap(sourceBitmap, 0, 0, sourceBitmap.getWidth(),
                sourceBitmap.getHeight(), matrix, true);
    }
}