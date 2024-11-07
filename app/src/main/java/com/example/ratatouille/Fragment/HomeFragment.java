package com.example.ratatouille.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ratatouille.adapters.RecipeAdapter;
import com.example.ratatouille.databinding.FragmentHomeBinding;
import com.example.ratatouille.models.Recipe;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

private FragmentHomeBinding binding;
List<Recipe> favouriteRecipes;
List<Recipe> popularRecipes;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

    binding = FragmentHomeBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadFavouriteRecipes();
        loadPopularRecipes();
    }

    private void loadPopularRecipes() {
        binding.rvPopulars.setAdapter(new RecipeAdapter());
        List<Recipe> popularRecipes;
        popularRecipes = new ArrayList<>();
        popularRecipes.add(new Recipe("recipe1", "recipe1", "1", "1", "1", "recipe1", "1"));
        popularRecipes.add(new Recipe("recipe2", "recipe2", "2", "2", "2", "recipe2", "2"));
        popularRecipes.add(new Recipe("3", "3", "3", "3", "3", "3", "3"));
        popularRecipes.add(new Recipe("4", "4", "4", "4", "4", "4", "4"));
        binding.rvPopulars.setAdapter(new RecipeAdapter());
        RecipeAdapter adapter = (RecipeAdapter) binding.rvPopulars.getAdapter();
        if (adapter != null) {
            adapter.setRecipeList(popularRecipes);
            adapter.notifyDataSetChanged();
        }
    }

    private void loadFavouriteRecipes() {
        binding.rvPopulars.setAdapter(new RecipeAdapter());
        favouriteRecipes = new ArrayList<>();
        favouriteRecipes.add(new Recipe("recipe1","recipe1","1","1","1","recipe1","1"));
        favouriteRecipes.add(new Recipe("recipe2","recipe2","2","2","2","recipe2","2"));
        favouriteRecipes.add(new Recipe("3","3","3","3","3","3","3"));
        favouriteRecipes.add(new Recipe("4","4","4","4","4","4","4"));
        binding.rvFavouriteMeal.setAdapter(new RecipeAdapter());
        RecipeAdapter adapter = (RecipeAdapter) binding.rvFavouriteMeal.getAdapter();
        if (adapter != null) {
            adapter.setRecipeList(favouriteRecipes);
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}