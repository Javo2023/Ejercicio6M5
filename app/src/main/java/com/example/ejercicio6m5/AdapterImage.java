package com.example.ejercicio6m5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ejercicio6m5.databinding.ItemLayoutBinding;

import java.util.List;


public class AdapterImage extends RecyclerView.Adapter<AdapterImage.MyViewHolder> {
    private ItemLayoutBinding binding;

    @NonNull
    private Context context;

    public AdapterImage() {
        this.binding = binding;
    }

    public AdapterImage.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context  = parent.getContext();
        ItemLayoutBinding binding = ItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterImage.MyViewHolder holder, int position) {
        holder.bind( data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutBinding binding;

        public MyViewHolder(ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Item data) {
            Glide.with(context)
                    .load(data.getImagen())
                    .into(binding.imageView);
            binding.textView.setText(data.getTitulo());
            binding.cardData.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putString("titulo", data.getTitulo());
                bundle.putString("imagen", data.getImagen());
                Navigation.findNavController(binding.getRoot()).navigate(R.id.action_imageFragment_to_detailFragment,bundle);
            });
        }
    }
    private List<Item> data;
    public void setData(List<Item> data){this.data = data;
    }
}
