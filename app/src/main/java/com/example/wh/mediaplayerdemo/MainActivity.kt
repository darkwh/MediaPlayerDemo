package com.example.wh.mediaplayerdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.wh.mediaplayerdemo.explosion.ExplodeParticleFactory
import com.example.wh.mediaplayerdemo.explosion.ExplosionField
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    var holder: SurfaceHolder? = null
//    var mediaPlayer: MediaPlayer? = null
//
//    var a : VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val explosionField = ExplosionField(this, ExplodeParticleFactory())
        explosionField.addListener(btn)
//        mediaPlayer = MediaPlayer()
//
//        try {
//            mediaPlayer?.setDataSource(this, Uri.parse("https://bj.bcebos.com/course-mct/media/riwenhanzi.mp4?authorization=bce-auth-v1%2Fde89d2e06dd7443a9e4422d5b3fb4eea%2F2018-03-09T09%3A07%3A24Z%2F6000%2F%2Fb41dc72621cc1458eff1a98ddc252aff8df5fe85128d22906c278e81833c2e61"))
//            holder = surfaceView.holder
//            holder?.addCallback(object : SurfaceHolder.Callback {
//
//                override fun surfaceCreated(holder: SurfaceHolder?) {
//                    mediaPlayer?.setDisplay(holder)
//                }
//
//                override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
//                }
//
//                override fun surfaceDestroyed(holder: SurfaceHolder?) {
//                }
//
//            })
//            mediaPlayer?.prepare()
//            mediaPlayer?.setOnPreparedListener({
//                mediaPlayer?.start()
//                mediaPlayer?.isLooping = true
//            })
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
    }
}
