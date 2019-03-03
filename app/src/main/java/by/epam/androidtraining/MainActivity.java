package by.epam.androidtraining;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        WebView authorizationView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authorizationView = findViewById(R.id.authorizationView);
        authorizationView.getSettings().setJavaScriptEnabled(true);
        authorizationView.setWebViewClient(new MyWebViewClient());
        authorizationView.loadUrl("https://oauth.vk.com/authorize");// https://m.vk.com/
    }

    private class MyWebViewClient extends WebViewClient {
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());

            return true;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }
}
