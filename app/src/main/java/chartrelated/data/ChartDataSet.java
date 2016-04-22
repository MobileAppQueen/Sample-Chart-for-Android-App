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

import java.util.ArrayList;
import java.util.List;

/**
 * Data class to populate a single data set on a chart {@link ChartActivity}.
 *
 * <p>Data class is used in correlation with {@link ChartData} and should never be used alone to
 * populate a chart using {@link ChartActivity#EXTRA_DATA}.
 * </p>
 *
 * @author KevinLeighCrain
 */
public class ChartDataSet implements Parcelable {

    private final String label;
    private final String fillColor;
    private final String strokeColor;
    private final String pointColor;
    private final String pointStrokeColor;
    private final String pointHighlightFill;
    private final String pointHighlightStroke;
    private final List<Double> data;
    private final int count;

    /**
     * @param label                the label for the data set
     * @param fillColor            the fill colour of the data points
     * @param strokeColor          the border color of the data points
     * @param pointColor           the colour of the data point
     * @param pointStrokeColor     the border colour of the data point
     * @param pointHighlightFill   the colour of the data point when pressed
     * @param pointHighlightStroke the border colour of the data point when pressed
     * @param data                 the data points
     */
    public ChartDataSet(String label,
                        String fillColor,
                        String strokeColor,
                        String pointColor,
                        String pointStrokeColor,
                        String pointHighlightFill,
                        String pointHighlightStroke,
                        List<Double> data) {
        this.label = label;
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.pointColor = pointColor;
        this.pointStrokeColor = pointStrokeColor;
        this.pointHighlightFill = pointHighlightFill;
        this.pointHighlightStroke = pointHighlightStroke;
        this.data = data;
        this.count = data.size();
    }

    private ChartDataSet(Parcel in) {
        label = in.readString();
        fillColor = in.readString();
        strokeColor = in.readString();
        pointColor = in.readString();
        pointStrokeColor = in.readString();
        pointHighlightFill = in.readString();
        pointHighlightStroke = in.readString();
        count = in.readInt();

        data = new ArrayList<>();
        int counter = count;
        while (counter-- > 0) {
            data.add(in.readDouble());
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeString(fillColor);
        dest.writeString(strokeColor);
        dest.writeString(pointColor);
        dest.writeString(pointStrokeColor);
        dest.writeString(pointHighlightFill);
        dest.writeString(pointHighlightStroke);
        dest.writeInt(count);
        for (Double d : data) {
            dest.writeDouble(d);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ChartDataSet> CREATOR = new Creator<ChartDataSet>() {
        @Override
        public ChartDataSet createFromParcel(Parcel in) {
            return new ChartDataSet(in);
        }

        @Override
        public ChartDataSet[] newArray(int size) {
            return new ChartDataSet[size];
        }
    };
}
