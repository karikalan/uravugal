package edu.chart.demo.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random; 

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.chart.demo.launch.JavaLauncher;
import edu.chart.demo.service.ChartDataConstants;
import edu.chart.demo.service.DemoService;
import edu.chart.demo.vo.CharDataVO;
import edu.chart.demo.vo.DataSetVO;
import edu.chart.hellograph.GalaxyService;
import edu.chart.hellograph.domain.World;
import edu.chart.hellograph.dto.MapChunk;
import edu.chart.hellograph.dto.MapJSONFormatDTO;
import edu.chart.hellograph.dto.PersonWrapper;
import edu.chart.hellograph.dto.TestS;

@Controller
public class CustomerController {

	DemoService service = new DemoService();

	@Autowired
	GalaxyService galaxyService;

	@RequestMapping("/customer/single.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("");
		String value = "Karthikeyan @@@@";
		System.out.println(galaxyService + " cleanworld");

		/*
		 * String[] worldString = galaxyService.makeWorldLive();//cleanWorld();
		 * ModelAndView model = new ModelAndView("Homepage", "msg",
		 * worldString[0]); String jsonStrNode=worldString[0]; World world = new
		 * World();
		 * 
		 * model.addObject("jsonStrNode",jsonStrNode);
		 * model.addObject("jsonStrEdge", worldString[1]);
		 * System.out.println("Node :"+ model.getModel().get("jsonStrNode"));
		 * System.out.println("Edge :"+ model.getModel().get("jsonStr-edge"));
		 */

		MapJSONFormatDTO dto = galaxyService.makeWorldLive();
		ModelAndView model = new ModelAndView("Homepage", "msg", value);
		model.addObject("jsonData", dto);

		return model;

	}

	public void getChartDataAsMap(Map<String, ArrayList<Double>> dataCollection) {
		ArrayList<String> jsonData = new ArrayList<String>();
		HashMap<String, ArrayList<String>> chartDataCollection = new HashMap<String, ArrayList<String>>();
		chartDataCollection.put("EMP", jsonData);

		dataCollection = (new JavaLauncher()).createDataCollection();
		jsonData = new ArrayList<String>();
		jsonData.add("Student Details");
		jsonData.add(service.getJsonData(ChartDataConstants.LINEAR, dataCollection));
		jsonData.add(service.getJsonData(ChartDataConstants.CIRCULAR, dataCollection));

		chartDataCollection.put("STUD", jsonData);

		// JSONPObject jsonObj = new JSONPObject(chartDataCollection);
		JSONPObject jsonObj = new JSONPObject("", new Object());

		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("javascript");
		engine.put("chartDataJSON", jsonObj.toString());

	}

	@RequestMapping("/customer/multiple.htm")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map dataCollection = (new JavaLauncher()).createDataCollection();

		ArrayList<String> indexArray = new ArrayList<String>();
		ArrayList<String> titleArray = new ArrayList<String>();
		ArrayList<String> jsonLinear = new ArrayList<String>();
		ArrayList<String> jsonCircular = new ArrayList<String>();

		indexArray.add("EMP");
		indexArray.add("STUD");

		titleArray.add("Employee Details");
		titleArray.add("Student Details");

		jsonLinear.add(service.getJsonData(ChartDataConstants.LINEAR, dataCollection));
		jsonCircular.add(service.getJsonData(ChartDataConstants.CIRCULAR, dataCollection));

		dataCollection = (new JavaLauncher()).createDataCollection();
		jsonLinear.add(service.getJsonData(ChartDataConstants.LINEAR, dataCollection));
		jsonCircular.add(service.getJsonData(ChartDataConstants.CIRCULAR, dataCollection));

		ModelAndView modal = new ModelAndView("Dashboard", "indexes", indexArray);
		modal.addObject("indexArray", indexArray);

		modal.addObject("titleArray", titleArray);
		modal.addObject("jsonLinear", jsonLinear);
		modal.addObject("jsonCircular", jsonCircular);

		return modal;

	}

	@RequestMapping("/customer/update.htm")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView("CustomerPage", "msg", "update() method");

	}

	@RequestMapping("/customer/list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" Hello hoe are you");
		System.out.println(request.getAttributeNames());
		return new ModelAndView("CustomerPage", "msg", "list() method");

	}

	@RequestMapping("/customer/saveChanges.htm")
	public String controllerMethod(@ModelAttribute(value = "myData") MapChunk myData) throws Exception {
		System.out.println("myData :" + myData);
		return "Homepage";

	}

	@RequestMapping("/customer/saveChange.htm")
	public @ResponseBody
	World saveWorld(@RequestBody final World chunck) {
		System.out.println("Chunk :" + chunck);
		return new World("Hi", 2);
	}

	/*
	 * @RequestMapping(value = "/AddUser.htm", method = RequestMethod.POST)
	 * public ModelAndView saveNew(@ModelAttribute(value = "myData") MapChunk
	 * myData) throws Exception {
	 * 
	 * return null; }
	 */

	@RequestMapping(value = "/customer/savepersonjson.htm", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public Object saveWorlds(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String saveArray = request.getParameter("nodeDetails");
		String relateSaveArray = request.getParameter("edgeDetails");
		System.out.println("Relate "+ relateSaveArray);
		try {
			galaxyService.saveWorlds(saveArray);
			galaxyService.saveRelations(relateSaveArray);
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
		System.out.println(saveArray);

		MapJSONFormatDTO dto = galaxyService.makeWorldLive();
		//ModelAndView model = new ModelAndView("Homepage", "msg", "hello");
		//model.addObject("jsonData", dto);

		return dto;

	}
}