/**
 * Copyright 2011 - 2014 Xeiam LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.SwingWrapper;
import com.xeiam.xchart.demo.charts.ExampleChart;

/**
 * Missing Point in Series
 * <p>
 * Demonstrates the following:
 * <ul>
 * <li>Number categories
 * <li>Positive values
 * <li>Multiple series
 * <li>Missing point in series
 * <li>Manually setting y-axis min and max values
 */
public class Staafdiagram implements ExampleChart {

    public static void main(String[] args) {

        ExampleChart exampleChart;
        exampleChart = new Staafdiagram();
        Chart chart = exampleChart.getChart();
        new SwingWrapper(chart).displayChart();
    }

    @Override
    public Chart getChart() {

        // Create Chart
        Chart chart = new ChartBuilder().chartType(ChartType.Bar).width(800).height(600).title("XFactor vs. Age").xAxisTitle("Age").yAxisTitle("XFactor").build();
        chart.addSeries("Vossen", new double[] { 100, 200, 300, 400, 500 }, new double[] { 50, 10, 20, 40, 35 });
        chart.addSeries("Konijnen", new double[] { 100, 200, 300, 400, 500 }, new double[] { 40, 30, 20, 8, 60 });
        chart.addSeries("Pinguins", new double[] { 100, 200, 300, 400, 500 }, new double[] { 40, 30, 20, 10, 60 });
        chart.addSeries("Hunters", new double[] { 100, 200, 300, 400, 500 }, new double[] { 40, 30, 20, 40, 60 });

        chart.getStyleManager().setYAxisMin(5);
        chart.getStyleManager().setYAxisMax(70);

        return chart;
    }
}
