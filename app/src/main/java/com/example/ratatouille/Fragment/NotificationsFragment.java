package com.example.ratatouille.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.ratatouille.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {


    binding = FragmentNotificationsBinding.inflate(inflater, container, false);
    View root = binding.getRoot();


        return root;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}