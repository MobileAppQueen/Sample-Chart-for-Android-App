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

import chartrelated.data.ChartData;
import chartrelated.data.ChartDataSet;
import chartrelated.data.PieData;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static ArrayList<PieData> generateDummyPieData() {
        ArrayList<PieData> pieDatas = new ArrayList<>();
        pieDatas.add(new PieData("50", "#FF5A5E", "#F7464A", "Green"));
        pieDatas.add(new PieData("50", "#FDB45C", "#FFC870", "Yellow"));
        pieDatas.add(new PieData("200", "#46BFBD", "#5AD3D1", "Yellow"));
        return pieDatas;
    }

    public static ChartData generateDummyChartData() {
        List<String> labels = new ArrayList<>();
        labels.add("Developing");
        labels.add("Other");
        labels.add("Learning");

        List<ChartDataSet> dataSets = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        data.add(3000D);
        data.add(3000D);
        data.add(2300D);

        dataSets.add(new ChartDataSet(
                "Data set 1",
                "rgba(220,220,220,0.2)",
                "rgba(220,220,220,1)",
                "rgba(220,220,220,1)",
                "#fff",
                "#fff",
                "rgba(220,220,220,1)", data));

        return new ChartData(labels, dataSets);
    }

}
