package com.example.wh.mediaplayerdemo.media

/**
 * @author DarkWH
 * @date 2018/3/13
 * @description
 */
interface IMediaControl {

    fun start()

    fun prepare(path: String?)

    fun pause()

    fun isPlaying(): Boolean

    fun seekTo(time: Long)

    fun release()

    fun getCurrentPosition(): Long

    fun getDuration(): Long
}