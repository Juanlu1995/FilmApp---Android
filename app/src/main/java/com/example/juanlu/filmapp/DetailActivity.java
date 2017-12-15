package com.example.juanlu.filmapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanlu.filmapp.model.Film;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    TextView mTextViewFilmName;
    ImageView mImageViewFilmCover;
    TextView mTextViewFilmDate;
    TextView mTextViewFilmCategorys;
    Film film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        film = new Film();
        mTextViewFilmName = findViewById(R.id.film_name_text_view);
        mImageViewFilmCover = findViewById(R.id.cover_view_detail);
        mTextViewFilmDate = findViewById(R.id.date);
        mTextViewFilmCategorys = findViewById(R.id.categorys);



        Intent detailIntent = DetailActivity.this.getIntent();

        if (detailIntent.hasExtra("film")) {
            film = (Film) detailIntent.getSerializableExtra("film");

            Picasso.with(this).load(film.getCover()).into(mImageViewFilmCover);
            mTextViewFilmName.setText(film.getName());
            mTextViewFilmDate.setText(film.getDate());
            mTextViewFilmCategorys.setText(film.getCategory());
        }
    }
}
