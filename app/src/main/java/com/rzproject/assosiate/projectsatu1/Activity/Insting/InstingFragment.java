package com.rzproject.assosiate.projectsatu1.Activity.Insting;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rzproject.assosiate.projectsatu1.Adapter.InstingAdapter;
import com.rzproject.assosiate.projectsatu1.ApiHelper.BaseApiService;
import com.rzproject.assosiate.projectsatu1.ApiHelper.UtilsApi;
import com.rzproject.assosiate.projectsatu1.Model.InstingData;
import com.rzproject.assosiate.projectsatu1.Model.InstingItemModel;
import com.rzproject.assosiate.projectsatu1.R;
import com.rzproject.assosiate.projectsatu1.SharedPreferences.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 */
public class InstingFragment extends Fragment {
    RecyclerView rvInsting;
    InstingAdapter adapter2;
    String accessToken;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    ProgressBar progressBar;

    public InstingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvInsting = view.findViewById(R.id.rv_list_insting);
        progressBar = view.findViewById(R.id.pb_insting);

        sharedPrefManager = new SharedPrefManager(getActivity());
        accessToken = sharedPrefManager.getSpToken();
        mApiService = UtilsApi.getAPIService();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isConnected())
        {
            ambildata();
        }else {
            Toast.makeText(getActivity(), "No Network connected", Toast.LENGTH_SHORT).show();
        }

    }

    public Boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public void ambildata(){

        mApiService.getInsting(accessToken).enqueue(new Callback<InstingData>() {
            @Override
            public void onResponse(Call<InstingData> call, Response<InstingData> response) {
                if (response.isSuccessful()) {
                    InstingData data = response.body();

                    List<InstingItemModel> proposal = data.data;
                    ArrayList<InstingItemModel> listInsting = new ArrayList<InstingItemModel>(proposal);

                    progressBar.setVisibility(View.INVISIBLE);
                    rvInsting.setVisibility(View.VISIBLE);

                    adapter2 = new InstingAdapter(getContext(),getFragmentManager());
                    adapter2.setListInsting(listInsting);
                    rvInsting.setLayoutManager(new LinearLayoutManager(getContext()));
                    rvInsting.setAdapter(adapter2);
                }
                else {
                    Toast.makeText(getActivity(), "Failed to get data", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.INVISIBLE);
                    rvInsting.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onFailure(Call<InstingData> call, Throwable t) {
                Toast.makeText(getActivity(), "connection error", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                rvInsting.setVisibility(View.VISIBLE);
            }
        });
    }
}
