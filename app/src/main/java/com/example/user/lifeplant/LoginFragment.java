package com.example.user.lifeplant;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.lifeplant.Models.ResLoginModel;


public class LoginFragment extends Fragment {
   private EditText loginemail;
   private   EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         loginemail = view.findViewById(R.id.login_email);
         password = view.findViewById(R.id.login_password);
        Button login = view.findViewById(R.id.login_btn);
        Button signup = view.findViewById(R.id.signup_btn);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final FragmentManager fm = getFragmentManager();
//                final FragmentTransaction ft = fm.beginTransaction();
//                final ProductFragment productFragment = new ProductFragment();
//                productFragment.setTargetFragment(LoginFragment.this,0);
//                ft.add(R.id.main_container, productFragment, ProductFragment.class.getSimpleName());
//                ft.hide(LoginFragment.this);
//                ft.addToBackStack(ProductFragment.class.getSimpleName());
//                ft.commit();
                final String email = loginemail.getText().toString().trim();
                final String paswd = password.getText().toString().trim();
                new AsyncLogin().execute(email,paswd);
            }

        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();
                final SignupFragment signupFragment = new SignupFragment();
                signupFragment.setTargetFragment(LoginFragment.this,0);
                ft.add(R.id.main_container, signupFragment, SignupFragment.class.getSimpleName());
                ft.hide(LoginFragment.this);
                ft.addToBackStack(SignupFragment.class.getSimpleName());
                ft.commit();

            }
        });
    }
    private class AsyncLogin extends AsyncTask<String,Void,Void> {

        private WSLogin wsLogin;
        private ProgressDialog progressDialog;
        private ResLoginModel resLoginModel;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(getActivity(),"","Please wait");
        }

        @Override
        protected Void doInBackground(String... strings) {
            wsLogin = new WSLogin(getActivity());
            resLoginModel = wsLogin.executeService(strings[0],strings[1]);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(resLoginModel.getResponse() ==0){
                final FragmentManager fm = getFragmentManager();
                final FragmentTransaction ft = fm.beginTransaction();
                final ProductFragment productFragment = new ProductFragment();
                productFragment.setTargetFragment(LoginFragment.this,0);
                ft.add(R.id.main_container, productFragment, ProductFragment.class.getSimpleName());
                ft.hide(LoginFragment.this);
                ft.addToBackStack(ProductFragment.class.getSimpleName());
                ft.commit();
            }else{
                // Toast.makeText(MainActivity.this, resLoginModel.getMessage(), Toast.LENGTH_SHORT).show();

                loginemail.setError(resLoginModel.getMessage());
                password.requestFocus();
            }
            if(progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }


}