package com.cobanogluhasan.swipetoshowbuttonrecycler.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cobanogluhasan.swipetoshowbuttonrecycler.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView cart_item_name,cart_item_price;
    ImageView cart_item_img;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        cart_item_img = (ImageView) itemView.findViewById(R.id.card_image);
        cart_item_name = (TextView) itemView.findViewById(R.id.cart_item_name);
        cart_item_price=(TextView) itemView.findViewById(R.id.cart_item_price);


    }


}
