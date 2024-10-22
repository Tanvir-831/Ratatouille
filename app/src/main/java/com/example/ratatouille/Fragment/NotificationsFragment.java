package com.example.ratatouille.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.ratatouille.adapters.RecipeAdapter;
import com.example.ratatouille.databinding.FragmentNotificationsBinding;
import com.example.ratatouille.models.Recipe;
import com.example.ratatouille.models.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


    binding = FragmentNotificationsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadProfile();
        loadUserRecipes();
    }

    private void loadUserRecipes() {
        binding.rvProfile.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rvProfile.setAdapter(new RecipeAdapter());
        List<Recipe> recipes = new ArrayList<>();
        recipes = new ArrayList<>();
        recipes.add(new Recipe("recipe1", "One", "1", "1", "1", "1", "1"));
        recipes.add(new Recipe("recipe2", "Two", "2", "2", "2", "2", "2"));
        recipes.add(new Recipe("3", "Three", "3", "3", "3", "3", "3"));
        binding.rvProfile.setAdapter(new RecipeAdapter());
        RecipeAdapter adapter = (RecipeAdapter) binding.rvProfile.getAdapter();
        if (adapter != null) {
            adapter.setRecipeList(recipes);
            adapter.notifyDataSetChanged();
        }
    }

    private void loadProfile() {
        User user = new User();
        user.setName("Saon");
        user.setEmail("saon.stu2019@juniv.edu");
        binding.tvUserName.setText(user.getName());
        binding.tvEmail.setText(user.getEmail());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}