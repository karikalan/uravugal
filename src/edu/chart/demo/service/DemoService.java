package edu.chart.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import edu.chart.demo.Convertable;
import edu.chart.demo.dto.CircularChartDTO;
import edu.chart.demo.dto.LineChartDTO;
import edu.chart.demo.vo.CharDataVO;
import edu.chart.demo.vo.DataSetVO;

public class DemoService {

	public String buildJson(CharDataVO data) {
		ObjectMapper mapper = new ObjectMapper();
		String value = "[]";
		try {
			value = mapper.writeValueAsString(data);
			System.out.println("JSON String:" + value);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public String getJsonData(String type, Map<String, ArrayList<Double>> dataCollection) {
		ChartDataFactory factory = new ChartDataFactory();
		ObjectMapper mapper = new ObjectMapper();
		String value = "[]";
		try {
			Convertable chartData = factory.getData(type, dataCollection);
			if(type == ChartDataConstants.LINEAR)
				value = mapper.writeValueAsString(chartData);
			if(type == ChartDataConstants.CIRCULAR)
				value = mapper.writeValueAsString(((CircularChartDTO) chartData).getDataSet());
			System.out.println("JSON String:" + value);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public CharDataVO buildData() {
		CharDataVO data = new CharDataVO();

		ArrayList<String> labels = new ArrayList<String>();
		labels.add("January");
		labels.add("Feburary");
		labels.add("March");
		labels.add("April");
		labels.add("May");
		labels.add("June");
		labels.add("July");
		labels.add("August");
		labels.add("September");
		labels.add("October");

		data.setLabels(labels);

		DataSetVO set1 = new DataSetVO();
		DataSetVO set2 = new DataSetVO();

		int[] values1 = new int[labels.size()];
		int[] values2 = new int[labels.size()];

		set1.setData(values1);
		set2.setData(values2);
		set2.setFillColor("rgba(151,187,205,0.5)");
		set2.setStrokeColor("rgba(151,187,205,0.8)");
		set2.setPointHighlightFill("rgba(151,187,205,0.75)");
		set2.setPointHighlightStroke("rgba(151,187,205,1)");

		for (int i = 0; i < values1.length; i++) {
			values1[i] = (int) new Random().nextInt(150);
			values2[i] = (int) new Random().nextInt(80);
		}

		data.getDatasets().add(set1);
		data.getDatasets().add(set2);

		System.out.println(" Java toString() :" + data);
		return data;
	}
}
