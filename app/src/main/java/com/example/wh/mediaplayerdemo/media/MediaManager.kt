package com.example.wh.mediaplayerdemo.media

import android.media.AudioManager
import tv.danmaku.ijk.media.player.IMediaPlayer
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import tv.danmaku.ijk.media.player.IjkTimedText
import java.io.IOException

/**
 * @author DarkWH
 * @date 2018/3/13
 * @description
 */
object MediaManager : IMediaControl, IMediaPlayer.OnTimedTextListener, IMediaPlayer.OnInfoListener
        , IMediaPlayer.OnErrorListener, IMediaPlayer.OnVideoSizeChangedListener,
        IMediaPlayer.OnSeekCompleteListener, IMediaPlayer.OnBufferingUpdateListener,
        IMediaPlayer.OnCompletionListener, IMediaPlayer.OnPreparedListener {

    var ijkPlayer: IjkMediaPlayer? = null

    override fun start() {
        ijkPlayer?.start()
    }

    override fun prepare(path: String?) {
        ijkPlayer = IjkMediaPlayer()
        ijkPlayer?.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "overlay-format", IjkMediaPlayer.SDL_FCC_RV32.toLong())
        ijkPlayer?.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "framedrop", 1)
        ijkPlayer?.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, "skip_loop_filter", 48)

        ijkPlayer?.setOnPreparedListener(this)
        ijkPlayer?.setOnVideoSizeChangedListener(this)
        ijkPlayer?.setOnCompletionListener(this)
        ijkPlayer?.setOnErrorListener(this)
        ijkPlayer?.setOnInfoListener(this)
        ijkPlayer?.setOnBufferingUpdateListener(this)
        ijkPlayer?.setOnSeekCompleteListener(this)
        ijkPlayer?.setOnTimedTextListener(this)

        try {
            //TODO 设置数据源
//            ijkPlayer?.setDataSource("https://bj.bcebos.com/course-mct/media/riwenhanzi.mp4?authorization=bce-auth-v1%2Fde89d2e06dd7443a9e4422d5b3fb4eea%2F2018-03-09T09%3A07%3A24Z%2F6000%2F%2Fb41dc72621cc1458eff1a98ddc252aff8df5fe85128d22906c278e81833c2e61")
            ijkPlayer?.dataSource = path
            ijkPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            ijkPlayer?.setScreenOnWhilePlaying(true)
            ijkPlayer?.prepareAsync()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun pause() {
        ijkPlayer?.pause()
    }

    override fun isPlaying(): Boolean {
        return ijkPlayer?.isPlaying ?: false
    }

    override fun seekTo(time: Long) {
        ijkPlayer?.seekTo(time)
    }

    override fun release() {
        ijkPlayer?.release()
    }

    override fun getCurrentPosition(): Long {
        return ijkPlayer?.currentPosition ?: 0
    }

    override fun getDuration(): Long {
        return ijkPlayer?.duration ?: 0
    }

    override fun onTimedText(p0: IMediaPlayer?, p1: IjkTimedText?) {
    }

    override fun onInfo(p0: IMediaPlayer?, p1: Int, p2: Int): Boolean {
        return false
    }

    override fun onError(p0: IMediaPlayer?, p1: Int, p2: Int): Boolean {
        return false
    }

    override fun onVideoSizeChanged(p0: IMediaPlayer?, p1: Int, p2: Int, p3: Int, p4: Int) {
    }

    override fun onSeekComplete(p0: IMediaPlayer?) {
    }

    override fun onBufferingUpdate(p0: IMediaPlayer?, p1: Int) {
    }

    override fun onCompletion(p0: IMediaPlayer?) {
    }

    override fun onPrepared(p0: IMediaPlayer?) {
        //TODO 通过接口回调给UI层
    }
}
