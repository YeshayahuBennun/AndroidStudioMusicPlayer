package com.ybennun.musicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(private var musicList: MutableList<Music>,private var itemClicked: ItemClicked) :  RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MusicViewHolder {
        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false
        val view =
            inflater.inflate(R.layout.music_items, viewGroup, shouldAttachToParentImmediately)

        return MusicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = musicList[position]
        holder.bindMusic(item)
    }

    inner class MusicViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private lateinit var music: Music
        private var artistName: TextView = view.findViewById(R.id.artist_text_view)
        private var songName: TextView = view.findViewById(R.id.song_text_view)

        init {

            view.setOnClickListener(this)
        }

        fun bindMusic(music: Music) {
            this.music = music

            artistName.text = music.artistName
            songName.text = music.songName
        }

        override fun onClick(v: View?) {
            itemClicked.itemClicked(adapterPosition)
        }
    }
}