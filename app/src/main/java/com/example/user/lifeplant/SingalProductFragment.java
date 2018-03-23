package com.example.user.lifeplant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.lifeplant.Adapter.CartAdapter;
import com.example.user.lifeplant.Models.CartModel;
import com.example.user.lifeplant.Models.ProductModel;

import java.util.ArrayList;


public class SingalProductFragment extends Fragment {
    private TextView textView;
    private Button addtocart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_singal_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cart_product_rv);
        textView = view.findViewById(R.id.product_name);
        textView.setText(getArguments().getString("productname"));
        final ArrayList<CartModel> cartModels = new ArrayList<>();
        addtocart = view.findViewById(R.id.add_to_cart);
        final Bundle bundle = new Bundle();
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productname= textView.getText().toString().trim();
                final CartModel cartModel = new CartModel(productname);
                cartModels.add(cartModel);
//
            }
        });



    }
}
