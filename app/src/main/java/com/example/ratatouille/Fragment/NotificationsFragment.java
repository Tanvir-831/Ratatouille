package com.example.ratatouille.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.bumptech.glide.Glide;
import com.example.ratatouille.R;
import com.example.ratatouille.adapters.RecipeAdapter;
import com.example.ratatouille.databinding.FragmentNotificationsBinding;
import com.example.ratatouille.models.Recipe;
import com.example.ratatouille.models.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadProfile();
        loadUserRecipes();
    }

    private void loadUserRecipes() {
        // Set the layout manager and initialize adapter for the RecyclerView
        binding.rvProfile.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RecipeAdapter adapter = new RecipeAdapter();
        binding.rvProfile.setAdapter(adapter);


        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("recipe1", "One", "1", "1", "1", "recipe1", "1"));
        recipes.add(new Recipe("recipe2", "Two", "2", "2", "2", "recipe2", "2"));


        adapter.setRecipeList(recipes);
        adapter.notifyDataSetChanged();
    }

    private void loadProfile() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        reference.child("Users").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        User user = snapshot.getValue(User.class);
                        if (user != null) {
                            binding.tvUserName.setText(user.getName());
                            binding.tvEmail.setText(user.getEmail());
                            Glide
                                    .with(requireContext())
                                    .load(user.getImage())
                                    .centerCrop()
                                    .placeholder(R.mipmap.ic_launcher)
                                    .into(binding.imgProfile);

                            Glide
                                    .with(requireContext())
                                    .load(user.getCover())
                                    .centerCrop()
                                    .placeholder(R.drawable.bg_default_recipe)
                                    .into(binding.imgCover);
                        } else {
                            Log.e("NotificationsFragment", "onDataChange: User is null");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e("NotificationsFragment", "onCancelled: " + error.getMessage());
                    }
                });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
