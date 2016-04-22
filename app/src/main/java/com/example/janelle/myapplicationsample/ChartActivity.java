/*
 * Copyright (C) 2016 KevinLeighCrain
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.janelle.myapplicationsample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.webkit.WebView;

import com.google.gson.Gson;
import chartrelated.data.ChartData;
import chartrelated.data.PieData;
import chartrelated.core.Charts;

import java.util.List;

/**
 * Activity class that displays a chart using ChartJS library in a web view {@link WebView}
 *
 * <p>To use this class you will need to pass two intent extras, the chart type {@link ChartActivity#EXTRA_TYPE}
 * and chart data {@link ChartActivity#EXTRA_DATA} before starting activity.
 * </p>
 */
@SuppressLint("Registered")
public class ChartActivity extends AppCompatActivity {

    /**
     * The type of chart {@link Charts}.
     */
    public static final String EXTRA_TYPE = "com.kevinleighcrain.chartify.EXTRA_TYPE";

    /**
     * The data to be displayed on chart {@link ChartData}, {@link PieData}.
     *
     * <p>Pass either a list of parcelable {@link PieData} or a parcelable {@link ChartData}
     * </p>
     */
    public static final String EXTRA_DATA = "com.kevinleighcrain.chartify.EXTRA_DATA";

    private WebView mWebView;
    private String mType;
    private String mJson;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent() == null)
            throw new NullPointerException("Intent: null");

        if (!getIntent().hasExtra(EXTRA_TYPE)
                || TextUtils.isEmpty(getIntent().getStringExtra(EXTRA_TYPE)))
            throw new NullPointerException("Intent arg: " + EXTRA_TYPE);

        if (!getIntent().hasExtra(EXTRA_DATA))
            throw new NullPointerException("Intent arg: " + EXTRA_DATA);

        setContentView(R.layout.activity_chart);
        mWebView = (WebView) findViewById(R.id.chart_webview);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new ChartWebViewClient());
    }

    @Override
    protected void onStart() {
        super.onStart();

        mType = getIntent().getStringExtra(EXTRA_TYPE);

        switch (mType) {
            case Charts.PIE:
                mJson = serializeChartData(getIntent().getExtras().getParcelableArrayList(EXTRA_DATA));
                break;
            case Charts.LINE:
                mJson = serializeChartData(getIntent().getExtras().getParcelable(EXTRA_DATA));
                break;
            case Charts.RADAR:
                mJson = serializeChartData(getIntent().getExtras().getParcelable(EXTRA_DATA));
                break;
            case Charts.DOUGHNUT:
                mJson = serializeChartData(getIntent().getExtras().getParcelableArrayList(EXTRA_DATA));
                break;
            case Charts.POLAR_AREA:
                mJson = serializeChartData(getIntent().getExtras().getParcelableArrayList(EXTRA_DATA));
                break;
            case Charts.BAR:
                mJson = serializeChartData(getIntent().getExtras().getParcelable(EXTRA_DATA));
                break;
            default:
                String msg = String
                        .format("Intent arg %s: %s is not a valid chart type", EXTRA_TYPE, mType);
                throw new IllegalArgumentException(msg);
        }

        mWebView.loadUrl(getString(R.string.chartify_index_url));
    }

    private String serializeChartData(Object data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    private String serializeChartData(List<?> data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    private final class ChartWebViewClient extends android.webkit.WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            String js = getString(R.string.chartify_load_javascript, mType, mJson);
            mWebView.loadUrl(js);
        }

    }
}
