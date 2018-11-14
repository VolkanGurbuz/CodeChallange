package com.volkangurbuz.codechallenge;

import android.app.ProgressDialog;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.volkangurbuz.codechallenge.Adapter.TrendAdapter;
import com.volkangurbuz.codechallenge.Model.Trend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ProgressDialog pd;
    private RecyclerView recList;
    private TrendAdapter trendAdapter;
    private List<Trend> trendList;
    private SwipeRefreshLayout swipeRefreshLayout;
    private EditText filterET;
    private Button button;

    private int sumOfStars, sumOfWatchers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        pd.setMessage("Logging in, please wait to show the trends.");
        pd.show();

        filterET = findViewById(R.id.showJobsET);
        button = findViewById(R.id.filterBtn);


        swipeRefreshLayout = findViewById(R.id.swipeRefleshLayout);
        recList = findViewById(R.id.recView);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        getTrends();

        trendAdapter = new TrendAdapter(trendList);

        recList.setAdapter(trendAdapter);

        // trendList.clear();


    }


    private void getTrends(date d) {

        trendList = new ArrayList<>();
        final Gson gson = new Gson();
        String url = "https://github-trending-api.now.sh/repositories?since="+ d.toString();

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        swipeRefreshLayout.setRefreshing(false);
                        JsonArray jsonArray = new JsonParser().parse(response).getAsJsonArray();

                        Log.d("jsonsize", jsonArray.size()+"");

                        for (int i = 0; i < jsonArray.size(); i++) {

                            Trend trendModel = gson.fromJson(jsonArray.get(i), Trend.class);

                            sumOfStars += trendModel.getStars();
                            sumOfWatchers +=trendModel.getForks();
                            trendList.add(trendModel);

                           // for (Trend t: trendModel) {
                           //     Log.d("star", t.getStars()+"");
                           // }

                          //  trendList = Arrays.asList(trendModel);

                        }
                        trendAdapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("responseErr", error.getMessage());
                swipeRefreshLayout.setRefreshing(false);
                pd.dismiss();
            }
        }) {

        };
        requestQueue.add(stringRequest);

    }

    enum date{
        weekly,
        daily,
        montly

    }


}
