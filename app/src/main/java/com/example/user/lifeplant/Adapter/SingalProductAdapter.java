package com.example.user.lifeplant.Adapter;


        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.example.user.lifeplant.Models.ProductModel;
        import com.example.user.lifeplant.R;
        import com.example.user.lifeplant.SingalCategoryFragment;
        import com.example.user.lifeplant.SingalProductFragment;

        import java.util.ArrayList;

/**
 * Created by user on 03-11-2017.
 */

public class SingalProductAdapter extends  RecyclerView.Adapter<SingalProductAdapter.MyViewHolder> {
    private ArrayList<ProductModel> myModelArrayList1;
    private Context context;
    SingalCategoryFragment singalCategoryFragment;

    public SingalProductAdapter(Context context,final ArrayList<ProductModel> myModelArrayList ,SingalCategoryFragment singalCategoryFragment){
        this.myModelArrayList1 = myModelArrayList;
        this.context = context;
        this.singalCategoryFragment = singalCategoryFragment;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = ((Activity)parent.getContext())
                .getLayoutInflater().inflate(R.layout.row_product,parent,false);
        return new MyViewHolder(view);
    }

    @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
        final ProductModel myModel = myModelArrayList1.get(position);
        holder.tv.setText(myModel.getName());
//       holder.iv.setImageResource(myModel.getImage());
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                String productname = myModel.getName();
                String productimage = myModel.getImage();
                Bundle bundle = new Bundle();
                bundle.putInt("position",position);
                bundle.putString("productname",productname);
                bundle.putString("productimage",productimage);
                final FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                SingalProductFragment singalProductFragment =new SingalProductFragment();
                singalProductFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.main_container,singalProductFragment,SingalProductFragment.class.getSimpleName());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.hide(singalCategoryFragment);

                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myModelArrayList1.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        //        private RecyclerView recyclerView;
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.row_product_iv);
//            recyclerView = itemView.findViewById(R.id.row_category_rv);
            tv = itemView.findViewById(R.id.row_product_tv);



        }
    }
}

