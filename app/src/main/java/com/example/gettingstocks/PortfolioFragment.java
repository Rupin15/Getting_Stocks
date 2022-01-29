package com.example.gettingstocks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PortfolioFragment extends Fragment {
    private static final String URL_DATA="https://sheet.best/api/sheets/ea642c13-0997-4d46-ae92-e8bd387a3179";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Stocks> stocks;
      public PortfolioFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_portfolio, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.RV_stocks_owned);
        stocks=new ArrayList<>();

        loadRecyclerView();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        adapter=new Adapter(this,stocks);
//        recyclerView.setAdapter(adapter);
        return view;

    }
    private  void refresh(int milli){
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                loadRecyclerView();
            }
        };
        Handler handler= new Handler();
        handler.postDelayed(runnable,milli);
    }
    private void loadRecyclerView() {

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, URL_DATA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                stocks.clear();
                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject stockObject=response.getJSONObject(i);
                        Stocks stock=new Stocks();
                        stock.setPrice(stockObject.getString("Prize".toString()));
                        stock.setSecurityCode(stockObject.getString("Security".toString()));
                        stock.setIssuerName(stockObject.getString("Issuer".toString()));
                        Log.e("Check",stockObject.getString("Prize".toString()));
                        stocks.add(stock);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter=new Adapter(getContext(),stocks);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Error listener", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
        refresh(2000);
    }
}