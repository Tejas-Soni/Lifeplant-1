package com.example.user.lifeplant;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lifeplant.Adapter.CategoryAdapter;
import com.example.user.lifeplant.Models.CategoryModel;
import com.example.user.lifeplant.Models.ProductModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {


    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);





    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.category_product_rv);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        final ArrayList<CategoryModel> categoryList = new ArrayList<>();
        final ArrayList<ProductModel> productList = new ArrayList<>();
        for (int i = 0 ; i < 50 ; i++){
            for (int j = 0; j < 100; j++) {
                final ProductModel productModel = new ProductModel(j, "M1", "Product" + j);
                productList.add(productModel);
            }

            final CategoryModel categoryModel = new CategoryModel("Category" + i, productList);
            categoryList.add(categoryModel);

        }

        final CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(),
                categoryList,ProductFragment.this);
        recyclerView.setAdapter(categoryAdapter);
    }
}















