package population;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Charts extends JFrame{
	
	public Charts(WorldBankEntry data) {
		XYSeriesCollection dataset = createDataset(data);
		JFreeChart ch = ChartFactory.createXYLineChart(data.getCountry(), "Years", "Population", 
				dataset, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(ch);
		ch.removeLegend();
		chartPanel.setPreferredSize(new Dimension(500, 300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(chartPanel);
		setVisible(true);
		pack();
	}
	
	private XYSeriesCollection createDataset(WorldBankEntry data) {
		XYSeriesCollection chartData = new XYSeriesCollection();
		XYSeries series = new XYSeries("Population");
		ArrayList<Long> popLst = data.getPopulation();
		int i=0;
		for (Long k : popLst) {
			int year = 1960 + i;
			i++;
			series.add(year, k);
		}
		chartData.addSeries(series);
		return chartData;
	}
}
