package com.example.ratatouille.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ratatouille.adapters.CategoryAdapter;
import com.example.ratatouille.databinding.FragmentDashboardBinding;
import com.example.ratatouille.models.Category;

import java.util.ArrayList;
import java.util.List;
//import com.example.ratatouille.ui.dashboard.DashboardViewModel;

public class DashboardFragment extends Fragment {

private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    View root = binding.getRoot();


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadCategories();
    }

    private void loadCategories() {
        binding.rvCategories.setAdapter(new CategoryAdapter());
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("1", "Breakfast",""));
        categories.add(new Category("2", "Lunch", ""));
        categories.add(new Category("3", "Dinner" ,""));
        CategoryAdapter adapter = (CategoryAdapter) binding.rvCategories.getAdapter();
        if (adapter != null) {
            adapter.setCategoryList(categories);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}