package com.rzproject.assosiate.projectsatu1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KonggaActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnChatpetugas;
    public Button btnChatsesama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kongga);
        String title = "Konsultasi Keluarga";
        getSupportActionBar().setTitle(title);

        btnChatpetugas = (Button) findViewById(R.id.buttonChatPuskesmas);
        btnChatpetugas.setOnClickListener(this);

        btnChatsesama = (Button) findViewById(R.id.buttonChatSesama);
        btnChatsesama.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonChatPuskesmas:
                ChatpetugasButtonClicked();
                break;
            case R.id.buttonChatSesama:
                ChatsesamaButtonClicked();
                break;

        }
    }
    private void ChatpetugasButtonClicked() {
        Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
        String url = "https://chat.whatsapp.com";
        intentWhatsapp.setData(Uri.parse(url));
        intentWhatsapp.setPackage("com.whatsapp");
        startActivity(intentWhatsapp);

    }
    private void ChatsesamaButtonClicked() {
        Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
        String url = "https://chat.whatsapp.com";
        intentWhatsapp.setData(Uri.parse(url));
        intentWhatsapp.setPackage("com.whatsapp");
        startActivity(intentWhatsapp);

    }
}
