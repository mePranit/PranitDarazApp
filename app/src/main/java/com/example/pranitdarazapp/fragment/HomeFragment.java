package com.example.pranitdarazapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.pranitdarazapp.Retrofit.API;
import com.example.pranitdarazapp.Retrofit.dbconnect;
import com.example.pranitdarazapp.R;
import com.example.pranitdarazapp.adapter.CollectionAdapter;
import com.example.pranitdarazapp.adapter.ProductAdapter;
import com.example.pranitdarazapp.modal.Collection;
import com.example.pranitdarazapp.modal.Products;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewCollection, recyclerViewProduct;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] slideImage= {R.drawable.slider1, R.drawable.slider2,R.drawable.slider3,
            R.drawable.slider4,R.drawable.slider5,R.drawable.slider6};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.colorWhite));
        recyclerViewCollection = view.findViewById(R.id.recyclerView_collection);
        recyclerViewProduct = view.findViewById(R.id.recyclerView_product);
        recyclerViewCollection.setNestedScrollingEnabled(false);
        recyclerViewProduct.setNestedScrollingEnabled(false);
        getProduct();
        getCollection();
        return view;
    }

    public void getCollection(){
        API retrofitApiInterface = dbconnect.getRetrofit().create(API.class);
      //  Call<List<Collection>> productModalCall = retrofitApiInterface.getCollection();
        Call<List<Collection>> productModalCall = retrofitApiInterface.getCollection();
         productModalCall.enqueue(new Callback<List<Collection>>() {
             @Override
             public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                 System.out.println("Collection list " + response.body());
                 CollectionAdapter recyclerviewAdapter = new CollectionAdapter(getActivity(),response.body());
                 LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(),
                         LinearLayoutManager.HORIZONTAL, false);
                 recyclerViewCollection.setLayoutManager(horizontalLayoutManager);
                 recyclerViewCollection.setHasFixedSize(true);
                 recyclerViewCollection.setAdapter(recyclerviewAdapter);
                 recyclerviewAdapter.notifyDataSetChanged();
             }

             @Override
             public void onFailure(Call<List<Collection>> call, Throwable t) {

             }
         });
    }

    // product json
    public void getProduct(){
        API retrofitApiInterface = dbconnect.getRetrofit().create(API.class);
        Call<List<Products>> productModalCall = retrofitApiInterface.getProduct();
        productModalCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                System.out.println("Product list " + response.body());
                ProductAdapter recyclerviewAdapter = new ProductAdapter(getActivity(),response.body());
                RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getContext(), 2);
                recyclerViewProduct.setLayoutManager(mlayoutManager);
                recyclerViewProduct.setHasFixedSize(true);
                recyclerViewProduct.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }
}