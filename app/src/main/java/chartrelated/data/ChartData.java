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

package chartrelated.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.janelle.myapplicationsample.ChartActivity;
import chartrelated.core.Charts;

import java.util.List;

/**
 * Data class for populating multiple data sets on a chart. {@link ChartActivity#EXTRA_DATA}.
 *
 * <p>This class is only applicable for the following chart types {@link Charts#LINE},
 * {@link Charts#BAR}, {@link Charts#RADAR}.
 * </p>
 *
 * @author KevinLeighCrain
 */
public class ChartData implements Parcelable {

    private final List<String> labels;
    private final List<ChartDataSet> datasets;

    /**
     * @param labels the labels for the x-axis of a chart
     * @param datasets the data sets to be drawn on the chart
     */
    public ChartData(List<String> labels, List<ChartDataSet> datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }

    private ChartData(Parcel in) {
        labels = in.createStringArrayList();
        datasets = in.createTypedArrayList(ChartDataSet.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(labels);
        dest.writeTypedList(datasets);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChartData> CREATOR = new Creator<ChartData>() {
        @Override
        public ChartData createFromParcel(Parcel in) {
            return new ChartData(in);
        }

        @Override
        public ChartData[] newArray(int size) {
            return new ChartData[size];
        }
    };
}

