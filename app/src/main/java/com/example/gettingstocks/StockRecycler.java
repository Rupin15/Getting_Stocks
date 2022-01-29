package com.example.gettingstocks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StockRecycler extends AppCompatActivity {
    private static final String URL_DATA="https://sheetdb.io/api/v1/p4s3llq942luu";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Stocks> stocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_stock_recycler);}}
//        recyclerView=findViewById(R.id.recycler_view);
//        stocks=new ArrayList<>();
//
//        loadRecyclerView();
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        adapter=new Adapter(this,stocks);
//        recyclerView.setAdapter(adapter);

    //}
//   private  void refresh(int milli){
//        Runnable runnable =new Runnable() {
//            @Override
//            public void run() {
//                loadRecyclerView();
//            }
//        };
//       Handler handler= new Handler();
//       handler.postDelayed(runnable,milli);
//   }
//    private void loadRecyclerView() {
//
//        RequestQueue requestQueue=Volley.newRequestQueue(this);
//        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, URL_DATA, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                stocks.clear();
//                  for(int i=0;i<response.length();i++){
//                      try {
//                          JSONObject stockObject=response.getJSONObject(i);
//                          Stocks stock=new Stocks();
//                          stock.setPrice(stockObject.getString("Prize".toString()));
//                          stock.setSecurityCode(stockObject.getString("Security".toString()));
//                          stock.setIssuerName(stockObject.getString("Issuer".toString()));
//                          Log.e("Check",stockObject.getString("Prize".toString()));
//                          stocks.add(stock);
//                      } catch (JSONException e) {
//                          e.printStackTrace();
//                      }
//
//                  }
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                adapter=new Adapter(getApplicationContext(),stocks);
//                recyclerView.setAdapter(adapter);
//                adapter.notifyDataSetChanged();
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(StockRecycler.this, "Error listener", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//       requestQueue.add(jsonArrayRequest);
//       refresh(2000);
//    }
//}