package com.itcrusaders.myalc40;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ALCPage extends AppCompatActivity {

    WebView alcpage_webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcpage);

        alcpage_webView=findViewById(R.id.wbv_alcpagewebview);
        alcpage_webView.getSettings().setLoadsImagesAutomatically(true);
        alcpage_webView.getSettings().setJavaScriptEnabled(true);
        alcpage_webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        alcpage_webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder= new AlertDialog.Builder(ALCPage.this);
                //super.onReceivedSslError(view, handler, error);
                String message = "SSL Certificate Error!";
                switch(error.getPrimaryError()){
                    case SslError.SSL_UNTRUSTED:
                        message = "The certificate authority is not trusted.";
                        break;

                    case SslError.SSL_EXPIRED:
                        message ="The certificate has expired.";
                        break;

                    case SslError.SSL_IDMISMATCH:
                        message="The certificate host mismatched.";
                        break;

                    case SslError.SSL_NOTYETVALID:
                        message ="The certificate is not yet valid.";
                        break;
                }
                message+= "Do you want to continue anyway?";
                builder.setTitle("SSL Certificate Error");
                builder.setMessage(message);
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        alcpage_webView.loadUrl("http://andela.com/alc/");
    }

    //onReceivedSsl
    //@Override
    public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError sslError){

    }
}
