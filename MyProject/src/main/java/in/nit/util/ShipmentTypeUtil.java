package in.nit.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {

	public void generatePie(String path,List<Object[]> data) {
		//create DataSet
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] a :data) {
			//key-shipMode value-count
			dataset.setValue(a[0].toString(), Double.valueOf(a[1].toString()));
		}
		
		//create JFreeChart using ChartFactory
		JFreeChart chart = ChartFactory.createPieChart("ShipmentTypeModes", dataset, true, true, false);
		
		//save as JPEG using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(
					new File(path + "/resources/images/shipmentspie.jpg"),
					chart,400,400);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> data) {
		
		//create DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] a : data) {
			//val-index on y-axis & key-index on x-axis
			dataset.setValue(Double.valueOf(a[1].toString()),
					a[0].toString(), "");
		}
		//create JFreeChart using ChartFactory
		JFreeChart chart = ChartFactory.createBarChart(
				"ShipmentTypeModes",
				"Modes", 
				"COUNT",
				dataset);
		
		//save as Image using ChartUtil
		try {
			ChartUtils.saveChartAsJPEG(
					new File(path + "/resources/images/shipmentsbar.jpg"),
					chart,
					400, 400);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
