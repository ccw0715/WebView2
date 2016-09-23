package com.qianfeng.webview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private WebView wv;

    private String html="<p>【性质】平</p> <p>【五味】辛</p> <p>【热量】900.00大卡(千焦)/100克 </p> <p>【功效】抑癌抗瘤</p> <p>【棕榈油是什么】 棕榈油是从油棕树上的棕果(Elaeis Guineensis)中榨取出来的，果肉压榨出的油称为棕榈油( Palm Oil)，而果仁压榨出的油称为棕榈仁油(Palm Kernel Oil)，两种油的成分大不相同。棕榈油主要含有棕榈酸(C 16)和油酸(C 18)两种最普通的脂肪酸，棕榈油的饱和程度约为50%;棕榈仁油主要含有月桂酸(C 12)，饱和程度达80...</p>";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = ((TextView) findViewById(R.id.tv));
        tv.setText(Html.fromHtml(html));

        wv = ((WebView) findViewById(R.id.webView));
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadData(getContent(),"text/html;charset=utf-8",null);


    }

    public String getContent() {
        StringBuffer sb=new StringBuffer();
        BufferedReader br;
        try {
            br=new BufferedReader(new InputStreamReader(getAssets().open("html.txt")));
            String str;
            while((str=br.readLine())!=null){
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}