package com.example.gymtest.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gymtest.Activity.ProductDetails;
import com.example.gymtest.Fragments.Fragment_Home;
import com.example.gymtest.Interface.ItemClickListener;
import com.example.gymtest.Model.Products;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Context context;
    ArrayList<Products> Products;


    public ProductAdapter(Context context, ArrayList<Products> Products) {
        this.context = context;
        this.Products = Products;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_product, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Products products = Products.get(position);
        holder.txttensp.setText(products.getTensanpham());
        holder.txtgia.setText(products.getGia() + " $");
        Glide.with(context).load(Utils.linkimg + products.getImage()).into(holder.imgSanpham);



        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void OnClick(View view, int pos, boolean isLongClick) {
                if (!isLongClick){
                    //Click
                    Intent intent = new Intent(context, ProductDetails.class);
                    intent.putExtra("details", products);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Products.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtgia, txttensp;
        ImageView imgSanpham, imgAddcart;
        private ItemClickListener itemClickListener;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            txtgia = itemView.findViewById(R.id.textviewPrice);
            txttensp = itemView.findViewById(R.id.textviewProduct);
            imgSanpham = itemView.findViewById(R.id.imageviewProduct);
            imgAddcart = itemView.findViewById(R.id.imgAddcart);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.OnClick(view, getAdapterPosition(), false);
        }
    }
}
