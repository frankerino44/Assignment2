package com.example.assignment2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.webkit.WebView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InfoWebFragment extends Fragment {

    WebView webView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info_web, container, false);
        webView = view.findViewById(R.id.InfoWebView);
        String defaultUrl = "https://seekingalpha.com";
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(defaultUrl);
        webView.getSettings().setJavaScriptEnabled(true);
        return view;
    }

    public void loadWebsiteForTicker(String ticker) {
        String tickerUrl = "https://seekingalpha.com/symbol/" + ticker;
        webView.loadUrl(tickerUrl);
    }
}