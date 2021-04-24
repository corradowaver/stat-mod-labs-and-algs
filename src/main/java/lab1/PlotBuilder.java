package lab1;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import javax.swing.JFrame;
import java.io.IOException;
import java.util.List;

import static org.knowm.xchart.BitmapEncoder.BitmapFormat.PNG;
import static org.knowm.xchart.CategorySeries.CategorySeriesRenderStyle.*;

public class PlotBuilder extends JFrame {

  CategoryChart chart;

  public PlotBuilder() {
    chart = new CategoryChartBuilder()
        .xAxisTitle("X")
        .yAxisTitle("Y")
        .title("Category chart")
        .build();
  }

  public PlotBuilder addStickData(String seriesName, List<Double> xData, List<Double> yData) {
    chart.addSeries(seriesName, xData, yData).setChartCategorySeriesRenderStyle(Stick);
    return this;
  }

  public PlotBuilder addBarData(String seriesName, List<Double> xData, List<Double> yData) {
    chart.addSeries(seriesName, xData, yData).setChartCategorySeriesRenderStyle(Bar);
    return this;
  }

  public PlotBuilder addLineData(String seriesName, List<Double> xData, List<Double> yData) {
    chart.addSeries(seriesName, xData, yData).setChartCategorySeriesRenderStyle(Line);
    return this;
  }

  public void build() throws IOException {
    new SwingWrapper(chart).displayChart();
    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", PNG);
  }

}
