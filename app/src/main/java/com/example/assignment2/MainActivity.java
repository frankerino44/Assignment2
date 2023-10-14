package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.webkit.WebView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentManager fg;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fg = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fg.beginTransaction().replace(R.id.TickerListFragmentContainer, new TickerListFragment()).commit();
            fg.beginTransaction().replace(R.id.InfoWebFragmentContainer, new InfoWebFragment()).commit();
        }
    }
}