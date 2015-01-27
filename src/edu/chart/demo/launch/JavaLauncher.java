package edu.chart.demo.launch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import edu.chart.demo.service.ChartDataConstants;
import edu.chart.demo.service.DemoService;
import edu.chart.hellograph.domain.World;
import edu.chart.hellograph.dto.BaseClass;
import edu.chart.hellograph.dto.PersonWrapper;

public class JavaLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JavaLauncher().decodeJSON();
	}
	
	public void execute(){
		DemoService service = new DemoService();
		Map dataCollection = createDataCollection();
		service.getJsonData(ChartDataConstants.LINEAR, dataCollection);
		service.getJsonData(ChartDataConstants.CIRCULAR, dataCollection);
		// service.buildJson(service.buildData());

	}

	public Map<String, ArrayList<Double>> createDataCollection() {
		Map<String, ArrayList<Double>> dataCollection = new HashMap<String, ArrayList<Double>>();

		ArrayList<Double> janValues = new ArrayList<Double>();
		janValues.add(Math.random());
		janValues.add(Math.random());

		ArrayList<Double> febValues = new ArrayList<Double>();
		febValues.add(Math.random());
		febValues.add(Math.random());

		dataCollection.put("January", janValues);
		dataCollection.put("February", febValues);
		
		return dataCollection;

	}
	
	public void decodeJSON(){
		String jsonData = "[{\"id\":\"23\",\"x\":-170.0017465437012,\"y\":-53.087326299312394,\"label\":\"new\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"},{\"id\":\"233\",\"x\":-92.00174654370119,\"y\":-79.0873262993124,\"label\":\"new2\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"}][{\"id\":\"2279a429-9c25-9aca-d813-4f5b8aba3c9a\",\"x\":-170.0017465437012,\"y\":-53.087326299312394,\"label\":\"new\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"},{\"id\":\"d3083eed-cda4-78af-7ca5-1f2bdf0ce03c\",\"x\":-92.00174654370119,\"y\":-79.0873262993124,\"label\":\"new2\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"}]";
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<BaseClass> listOfWorld = mapper.readValue(jsonData, mapper.getTypeFactory().constructCollectionType(List.class, BaseClass.class));
			System.out.println(listOfWorld);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
