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

/**
 * Data class for populating a list of data points on a chart. {@link ChartActivity#EXTRA_DATA}.
 *
 * <p>This class is only applicable for the following chart types {@link Charts#PIE},
 * {@link Charts#DOUGHNUT}, {@link Charts#POLAR_AREA}.
 * </p>
 *
 * @author KevinLeighCrain
 */
public class PieData implements Parcelable {

    private final String value;
    private final String color;
    private final String highlight;
    private final String label;

    /**
     * @param value     the data point
     * @param color     the fill color
     * @param highlight the fill color when pressed
     * @param label     the name of the data point
     */
    public PieData(String value, String color, String highlight, String label) {
        this.value = value;
        this.color = color;
        this.highlight = highlight;
        this.label = label;
    }

    private PieData(Parcel in) {
        value = in.readString();
        color = in.readString();
        highlight = in.readString();
        label = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(value);
        dest.writeString(color);
        dest.writeString(highlight);
        dest.writeString(label);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PieData> CREATOR = new Creator<PieData>() {
        @Override
        public PieData createFromParcel(Parcel in) {
            return new PieData(in);
        }

        @Override
        public PieData[] newArray(int size) {
            return new PieData[size];
        }
    };
}
