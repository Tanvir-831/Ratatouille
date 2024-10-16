package com.example.ratatouille;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ratatouille.databinding.ActivitySplashBinding;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    private int splashScreenTime = 3000;
    private int timeInterval = 100;
    private int progress = 0;

    private Runnable runnable;
    private Handler handler;

    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.progressBar.setMax(splashScreenTime);
        binding.progressBar.setProgress(progress);
        handler = new Handler(Looper.getMainLooper());
        runnable = new Runnable() {
            @Override
            public void run() {
                if (progress < splashScreenTime) {
                    progress += timeInterval;
                    binding.progressBar.setProgress(progress);
                    handler.postDelayed(this, timeInterval);
                } else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
            }
        };
        handler.post(runnable);
    }
}
