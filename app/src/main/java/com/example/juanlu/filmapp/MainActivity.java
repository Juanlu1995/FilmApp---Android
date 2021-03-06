package com.example.juanlu.filmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.juanlu.filmapp.model.Film;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView mListViewFilms;
    ArrayList<Film> mListFilms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewFilms = findViewById(R.id.list_view_films);

        /*
         * Creamos el adaptador
         */
        final ArrayAdapter<Film> adapter = new ArrayAdapter<Film>(
                this,
                R.layout.list_item_film,
                R.id.text_view_film,
                mListFilms
        );
        /*
        Asigamos el adaptador a mLIstViewFilms
         */
        mListViewFilms.setAdapter(adapter);

        /*
        A cada elemento de la lista (adaptador) le asignamos un evento "click",
        por el cual cuando se pulse entraremos en una nueva ventana con información detallada del elemento
         */
        mListViewFilms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(
                        MainActivity.this,
                        DetailActivity.class);
                detailIntent.putExtra("film", mListFilms.get(position));
                startActivity(detailIntent);
            }
        });

        /*
        Cargamos la información a colocar en el adaptador de un api.
        Si falla, informamos en un log, si la operación sucede correctamente informamos y
        damos la información recibida en el adaptador.
         */
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://frozen-everglades-20727.herokuapp.com/api/films",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("MainActivity", "Algo falla");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("MainActivity", "OK-> " + responseString);
                        Gson gson = new GsonBuilder().create();
                        Film[] films = gson.fromJson(responseString, Film[].class);
                        adapter.clear();
                        for (Film film : films) {
                            adapter.add(film);
                        }
                    }
                });
    }
}
