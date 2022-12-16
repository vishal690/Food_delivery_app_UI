package eu.tutorials.food_delivery_app.Adoptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import eu.tutorials.food_delivery_app.Domain.FoodDomain;
import eu.tutorials.food_delivery_app.R;


public class PopularAdeptor extends RecyclerView.Adapter<PopularAdeptor.ViewHolder> {

    ArrayList<FoodDomain> popularFood;
    public PopularAdeptor(ArrayList<FoodDomain> popularFood){
        this.popularFood = popularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdeptor.ViewHolder holder, int position) {
        holder.title.setText(popularFood.get(position).getTitle());
        holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));


        int drawableresourceId = holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableresourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return  popularFood.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NotNull  View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}

