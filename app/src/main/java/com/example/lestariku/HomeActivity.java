package com.example.lestariku;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView tvTitle;
    private TextView btnLapor;
    private TextView tvLoginLink; // Tambahkan ini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvTitle = findViewById(R.id.tvTitle);
        btnLapor = findViewById(R.id.btnLapor);
        tvLoginLink = findViewById(R.id.tvLoginLink); // Inisialisasi

        // 1. Gradasi untuk "Bumi Lestari"
        String fullText = "Jelajahi Bumi Lestari";
        int start = fullText.indexOf("Bumi");
        int end = fullText.length();

        SpannableString spannable = new SpannableString(fullText);

        spannable.setSpan(
                new ForegroundColorSpan(Color.BLACK),
                0,
                start,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        spannable.setSpan(
                new GradientSpan(Color.parseColor("#43A047"), Color.parseColor("#26C6DA")),
                start,
                end,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );

        tvTitle.setText(spannable);

        // 2. Tombol Lapor warna hitam + underline
        btnLapor.setPaintFlags(btnLapor.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnLapor.setTextColor(Color.BLACK);

        // 3. Klik ke LaporanActivity
        btnLapor.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LaporanActivity.class);
            startActivity(intent);
        });

        // 4. Klik "Masuk / Daftar" → LoginActivity
        tvLoginLink.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}
