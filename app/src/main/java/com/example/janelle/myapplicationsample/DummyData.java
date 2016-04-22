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
        pieDatas.add(new PieData("50", "#FF0000", "#FF3300", "Mental"));
        pieDatas.add(new PieData("70", "#EEEE00", "#EEEE70", "Physical"));
        pieDatas.add(new PieData("60", "#D6D6D6", "#FF99FF", "Spirtual"));
        pieDatas.add(new PieData("80", "#F2F2F2", "#003300", "Emotional"));
        return pieDatas;
    }

    public static ChartData generateDummyChartData() {
        List<String> labels = new ArrayList<>();
        labels.add("Physical");
        labels.add("Mental");
        labels.add("Emotional");
        labels.add("Spiritual");

        List<ChartDataSet> dataSets = new ArrayList<>();
        List<Double> data = new ArrayList<>();

        data.add(50D);
        data.add(70D);
        data.add(60D);
        data.add(80D);

        dataSets.add(new ChartDataSet(
                "Data set 1",
                "rgba(220,220,220,0.2)",
                "rgba(220,220,220,1)",
                "rgba(10,50,245,1)",
                "#fff",
                "#fff",
                "rgba(220,220,220,1)", data));

        return new ChartData(labels, dataSets);
    }

}
