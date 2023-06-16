package com.example.gymtest.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gymtest.Interface.ImageClickListenner;
import com.example.gymtest.Model.Cart;
import com.example.gymtest.Model.EventBus.MoneyTotalEvent;
import com.example.gymtest.R;
import com.example.gymtest.Utils.Utils;

import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        holder.itemNameProduct.setText(cart.getNameProduct());
        holder.itemAmount.setText(cart.getAmount()+" ");
        Glide.with(context).load(Utils.linkimg + cart.getImageProduct()).into(holder.itemImgProduct);


        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        holder.itemPriceProduct.setText(cart.getPriceProduct() + "$");

        holder.setImageClickListenner(new ImageClickListenner() {
            @Override
            public void onImageClick(View view, int pos, int index) {
                Log.d("TAG", "onImageclick: "+pos +" ..."+index);
                if (index == 1){

                        int newAmount = cartList.get(pos).getAmount() + 1;
                        cartList.get(pos).setAmount(newAmount);

                        holder.itemAmount.setText(cartList.get(pos).getAmount()+" ");
                        long gia = cartList.get(pos).getPriceProduct() * cartList.get(pos).getAmount();
//                      holder.itemPriceProduct.setText(decimalFormat.format(gia) + "$");
                        EventBus.getDefault().postSticky(new MoneyTotalEvent());


                }else if (index == 2){
                    if (cartList.get(pos).getAmount() > 1){
                        int newAmount = cartList.get(pos).getAmount() - 1;
                        cartList.get(pos).setAmount(newAmount);

                        holder.itemAmount.setText(cartList.get(pos).getAmount()+" ");
                        long gia = cartList.get(pos).getPriceProduct() * cartList.get(pos).getAmount();
//                holder.itemPriceProduct.setText(decimalFormat.format(gia) + "$");
                        EventBus.getDefault().postSticky(new MoneyTotalEvent());
                    }else if (cartList.get(pos).getAmount() == 1){
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                        builder.setTitle("Notification");
                        builder.setMessage("Do you want to remove the product from the cart?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Utils.arrayCart.remove(pos);
                                notifyDataSetChanged();

                                EventBus.getDefault().postSticky(new MoneyTotalEvent());
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();


                    }
                   
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView itemImgProduct, btnAdd, btnSubtraction;
        TextView itemNameProduct, itemPriceProduct, itemAmount;
        ImageClickListenner imageClickListenner;


        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            itemImgProduct = itemView.findViewById(R.id.item_cart_imgProduct);
            itemNameProduct = itemView.findViewById(R.id.item_cart_nameProduct);
            itemPriceProduct = itemView.findViewById(R.id.item_cart_price);
            itemAmount = itemView.findViewById(R.id.item_cart_amount);
            btnAdd = itemView.findViewById(R.id.item_cart_add);
            btnSubtraction = itemView.findViewById(R.id.item_cart_subtraction);

            //event click
            btnAdd.setOnClickListener(this);
            btnSubtraction.setOnClickListener(this);


        }

        public void setImageClickListenner(ImageClickListenner imageClickListenner) {
            this.imageClickListenner = imageClickListenner;
        }

        @Override
        public void onClick(View v) {
            if (v == btnAdd){
                imageClickListenner.onImageClick(v, getAdapterPosition(), 1);
                //1 cong
            }else if (v == btnSubtraction){
                imageClickListenner.onImageClick(v, getAdapterPosition(), 2);
                //2 tru
            }

        }
    }
}
