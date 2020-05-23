package com.rzproject.assosiate.projectsatu1.Activity.Insting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rzproject.assosiate.projectsatu1.Adapter.VideoAdapter;
import com.rzproject.assosiate.projectsatu1.Model.InstingItemModel;
import com.rzproject.assosiate.projectsatu1.Model.YouTubeVideos;
import com.rzproject.assosiate.projectsatu1.R;

import java.util.Vector;

public class InstingDetailActivity extends AppCompatActivity {

    private TextView tv_judul,tv_materi;
    private VideoView videoView;
    private InstingItemModel model;
    String url;

    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = "Informasi Penting";
        getSupportActionBar().setTitle(title);
        setContentView(R.layout.activity__detail_insting);

        tv_judul = findViewById(R.id.insting_detail_judul);
        tv_materi = findViewById(R.id.detail_materi);
        videoView = findViewById(R.id.insting_videoview);



        Intent intent = getIntent();
        if (intent != null) {
            model = intent.getParcelableExtra("insting_extra_key");
            tv_judul.setText(model.judul);
            tv_materi.setText(model.materi);
            url = "https://www.youtube.com/watch?v=_aVnQkdkGIE";

        }

        Uri uri = Uri.parse(url);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();



    }
}
