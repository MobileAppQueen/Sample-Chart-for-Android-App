package com.example.janelle.myapplicationsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import chartrelated.core.Charts;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        findViewById(R.id.demo_button_pie_chart).setOnClickListener(this);
        findViewById(R.id.demo_button_line_chart).setOnClickListener(this);
        findViewById(R.id.demo_button_radar_chart).setOnClickListener(this);
        findViewById(R.id.demo_button_doughnut_chart).setOnClickListener(this);
        findViewById(R.id.demo_button_polar_area_chart).setOnClickListener(this);
        findViewById(R.id.demo_button_bar_chart).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.demo_button_pie_chart:
                startActivityForPieChart();
                break;
            case R.id.demo_button_line_chart:
                startActivityForLineChart();
                break;
            case R.id.demo_button_radar_chart:
                startActivityForRadarChart();
                break;
            case R.id.demo_button_doughnut_chart:
                startActivityForDoughnutChart();
                break;
            case R.id.demo_button_polar_area_chart:
                startActivityForPolarAreaChart();
                break;
            case R.id.demo_button_bar_chart:
                startActivityForBarChart();
                break;
            default:
                throw new RuntimeException("Demo not yet implemented");
        }
    }

    private void startActivityForPieChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.PIE);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyPieData());
        startActivity(i);
    }

    private void startActivityForLineChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.LINE);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyChartData());
        startActivity(i);
    }

    private void startActivityForRadarChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.RADAR);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyChartData());
        startActivity(i);
    }

    private void startActivityForDoughnutChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.DOUGHNUT);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyPieData());
        startActivity(i);
    }

    private void startActivityForPolarAreaChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.POLAR_AREA);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyPieData());
        startActivity(i);
    }

    private void startActivityForBarChart() {
        Intent i = new Intent(this, ChartActivity.class);
        i.putExtra(ChartActivity.EXTRA_TYPE, Charts.BAR);
        i.putExtra(ChartActivity.EXTRA_DATA, DummyData.generateDummyChartData());
        startActivity(i);
    }

}
