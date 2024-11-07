package com.example.ratatouille.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ratatouille.R;
import com.example.ratatouille.databinding.ItemCategoryBinding;
import com.example.ratatouille.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category>categoryList = new ArrayList<>();
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }



    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
            Category category =categoryList.get(position);
            holder.onBind(category);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    private static ItemCategoryBinding binding;
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        public CategoryViewHolder(@NonNull ItemCategoryBinding itemView) {

            super(itemView.getRoot());
            binding = itemView;
        }

        public void onBind(Category category)
        {
            binding.tvName.setText(category.getName());
            Glide
                    .with(binding.getRoot().getContext())
                    .load(category.getImage())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(binding.imgBgCategory);
        }

    }
}
