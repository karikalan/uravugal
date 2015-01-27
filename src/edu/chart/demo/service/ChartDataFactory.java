package edu.chart.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.chart.demo.Convertable;
import edu.chart.demo.dto.CircularChartDTO;
import edu.chart.demo.dto.LineChartDTO;

public class ChartDataFactory implements ChartDataConstants{
	
	public Convertable getData(String type,Map<String,ArrayList<Double>> dataCollection){
		Convertable chartData = null;
		System.out.println(type);
		if(type == LINEAR){
			chartData=  getLinearValue(dataCollection);
		}else if(type == CIRCULAR){
			chartData = getCircularValue(dataCollection);
		}
		return chartData;
	}

	private Convertable getCircularValue(Map<String, ArrayList<Double>> dataCollection) {
		System.out.println("Inside getCircularValue");
		
		CircularChartDTO chartData = new CircularChartDTO();
	
		Set<String> keysSet = dataCollection.keySet();
		Iterator<String> keyIte = keysSet.iterator();
		while(keyIte.hasNext()){
			String label = keyIte.next();
			CircularChartDTO.CircularDataSet data= chartData.createDataSet();
			data.setLabel(label);
			data.setValue(dataCollection.get(label).get(0));
			chartData.getDataSet().add(data);
		}
		
		return chartData;
	}

	private Convertable getLinearValue(Map<String, ArrayList<Double>> dataCollection) {
		System.out.println("Inside getLinearValue");
		
		LineChartDTO chartData = new LineChartDTO();
		Set<String> keysSet = dataCollection.keySet();
		chartData.setLabels(keysSet);
		Iterator<String> keyIte = keysSet.iterator();
		while(keyIte.hasNext()){
			List<Double> values = dataCollection.get(keyIte.next());
			LineChartDTO.DataSetDTO dataSet = chartData.createDataSetDTO();
			dataSet.setData(values);
			chartData.getDatasets().add(dataSet);
		}
		return chartData;
	}
	
	
}
