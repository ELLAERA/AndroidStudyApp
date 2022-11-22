package com.example.androidstudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androidstudyapp.retrofit.NaturalGasData;
import com.example.androidstudyapp.retrofit.RetrofitAPI;
import com.example.androidstudyapp.retrofit.RetrofitClient;
import com.example.androidstudyapp.retrofit.RetrofitDTO;

import java.net.URLEncoder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    private MutableLiveData<ArrayList<NaturalGasData>> naturalGasData;
    private RetrofitAPI retrofitAPI;
    private final static String SECRET_KEY = "U6df4O9ZIKHKW9B5JEkqbriTxRjyZ8Yk8mSmAh4XB9gwl318yRQ2z/bDCdGaSVhprEQpzzk5hOBu+ldezHCQnw==";


    public MutableLiveData<ArrayList<NaturalGasData>> getNaturalGasData() {
        if (naturalGasData == null) {
            naturalGasData = new MutableLiveData<>();
            loadData();
        }
        return naturalGasData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        getNaturalGasData();
    }


    private void loadData() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        if (retrofitClient != null) {
            retrofitAPI = RetrofitClient.getRetrofitAPI();
            retrofitAPI.getNaturalGasData(1, 10, SECRET_KEY).enqueue(new Callback<RetrofitDTO>() {
                @Override
                public void onResponse(Call<RetrofitDTO> call, Response<RetrofitDTO> response ) {

                    RetrofitDTO dto = response.body();
                    NaturalGasData[] ngData = dto != null
                            ? dto.getNaturalGasData()
                            : new NaturalGasData[0];

                    ArrayList<NaturalGasData> insertData = new ArrayList<>();

                    for (int i = 0; i < ngData.length; i++) {
                        String year = ngData[i].getYear();
                        String max_stock = ngData[i].getMax_stock();
                        String min_stock = ngData[i].getMin_stock();
                        String stock = ngData[i].getStock();
                        String stock_rate = ngData[i].getStock_rate();

                        insertData.add(new NaturalGasData(
                                year,
                                min_stock,
                                max_stock,
                                stock,
                                stock_rate
                        ));
                    }
                    naturalGasData.setValue(insertData);
                    Log.d("loadData()", "서버통신 성공: ");

                    TextView tv = (TextView) findViewById(R.id.textView);
                    tv.setText(naturalGasData.getValue().toString());
                }

                @Override
                public void onFailure(Call<RetrofitDTO> call, Throwable t) {
                    Log.d("loadData()", "서버통신 실패 : " + t.getCause());
                    t.printStackTrace();

                }
            });
        }
    }

}