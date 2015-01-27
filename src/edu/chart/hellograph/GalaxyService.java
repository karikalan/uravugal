
package edu.chart.hellograph;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.chart.demo.vo.CharDataVO;
import edu.chart.hellograph.repositories.WorldRepository;
import edu.chart.hellograph.domain.Relations;
import edu.chart.hellograph.domain.World;
import edu.chart.hellograph.dto.BaseClass;
import edu.chart.hellograph.dto.MapChunk;
import edu.chart.hellograph.dto.MapJSONFormatDTO;
import edu.chart.hellograph.dto.MapJsonDTO;
import edu.chart.hellograph.dto.RelationClientDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class GalaxyService {

	@Autowired
	private WorldRepository worldRepository;

	public long getNumberOfWorlds() {
		return worldRepository.count();
	}

	public World createWorld(String name, int moons) {
		System.out.println(" Creating World :" + name);
		return worldRepository.save(new World(name, moons));
	}

	public Iterable<World> getAllWorlds() {
		return worldRepository.findAll();
	}

	public World findWorldById(Long id) {
		return worldRepository.findOne(id);
	}

	// This is using the schema based index
	public World findWorldByName(String name) {
		return worldRepository.findBySchemaPropertyValue("label", name);
	}

	// This is using the legacy index
	public Iterable<World> findAllByNumberOfMoons(int numberOfMoons) {
		return worldRepository.findAllByPropertyValue("moons", numberOfMoons);
	}
	
	// This is using the schema based index
	public World findWorldByCreatedAt(Long createdAt) {
		return worldRepository.findBySchemaPropertyValue("createdAt", createdAt);
	}

	public Collection<World> makeSomeWorlds() {
		Collection<World> worlds = new ArrayList<World>();

		// Solar worlds
		/*worlds.add(createWorld("Mercury", 0));
		worlds.add(createWorld("Venus", 0));

		World earth = createWorld("Earth", 1);
		World mars = createWorld("Mars", 2);
		mars.addRocketRouteTo(earth);
		worldRepository.save(mars);
		worlds.add(earth);
		worlds.add(mars);

		worlds.add(createWorld("Jupiter", 63));*/
		/*
		 * worlds.add(createWorld("Saturn", 62));
		 * worlds.add(createWorld("Uranus", 27));
		 * worlds.add(createWorld("Neptune", 13));
		 */
		// Norse worlds
		/*
		 * worlds.add(createWorld("Alfheimr", 0));
		 * worlds.add(createWorld("Midgard", 1));
		 * worlds.add(createWorld("Muspellheim", 2));
		 * worlds.add(createWorld("Asgard", 63)); worlds.add(createWorld("Hel",
		 * 62));
		 */return worlds;
	}

	public World createWorld(World wor) {

		return worldRepository.save(wor);
	}

	public boolean cleanWorld() {
		long worlds = getNumberOfWorlds();
		for (long i = 0; i < worlds - 1; i++) {
			worldRepository.delete(i);
		}
		System.out.println("Clean world " + getNumberOfWorlds());
		return true;
	}

	public MapJSONFormatDTO makeWorldLive() {

		long worlds = getNumberOfWorlds();

		if (worlds == 0) {
			List<World> worldList = (List<World>) makeSomeWorlds();
			for (World wor : worldList)
				createWorld(wor);
		}
		worlds = getNumberOfWorlds();
		System.out.println(worlds);
		if(worlds > 1)
			System.out.println(findWorldById(worlds-1));
		MapJsonDTO jsonData = new MapJsonDTO();

		ArrayList<World> worldList = (ArrayList<World>) IteratorUtil.asCollection(getAllWorlds().iterator());
		long edgeCnt = 0;

		for (World world : worldList) {
			jsonData.getNodes().add(world);

			Set<World> reachableWorldSet = world.getReachableWorlds();
			if (null != reachableWorldSet) {
				ArrayList<World> reachableWorldList = (ArrayList<World>) IteratorUtil.asCollection(reachableWorldSet.iterator());
				for (World reachableWorld : reachableWorldList) {
					Relations relations = new Relations();
					relations.setFrom(world.getId());
					relations.setTo(reachableWorld.getId());
					relations.setLabel(World.REACHABLE_BY_ROCKET);
					relations.setId(edgeCnt++);
					jsonData.getEdges().add(relations);
				}

			}

		}

		System.out.println("Node length :" + jsonData.getNodes().size());
		System.out.println("Edge length :" + jsonData.getEdges().size());

		MapJSONFormatDTO dto = new MapJSONFormatDTO();
		String nodeStr = "";
		String edgeStr = "";
		try {
			nodeStr = buildJson(jsonData.getNodes());
			edgeStr = buildJson(jsonData.getEdges());

			System.out.println("Node :" + nodeStr);
			System.out.println("Edge Str:" + edgeStr);
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Exception @ MakeWorldLive :" + e);
		}
		dto.setJsonStrEdge(edgeStr);
		dto.setJsonStrNode(nodeStr);

		System.out.println("JSON DTO :" + nodeStr);
		return dto;

	}

	public String buildJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String value = "[]";
		try {
			value = mapper.writeValueAsString(object);
			System.out.println("JSON String:" + value);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println(" JsonGenerationException :" + e);

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println(" JsonMappingException :" + e);

		} catch (IOException e) {
			System.err.println(" IOException :" + e);
			// e.printStackTrace();
		}
		return value;
	}

	public void saveWorlds(String saveArray) throws JsonParseException, JsonMappingException, IOException {
		List<BaseClass> worldList = decodeNodeJSON(saveArray);
		System.out.println("Worlds to save :" + worldList);
		for(BaseClass worldSav : worldList){
			World world = new World(worldSav.getLabel(), worldSav.getMoons());
			world.setCreatedAt(worldSav.getId());
			World worldCreated =createWorld(world);
			System.out.println(world);
		}
	}

	ObjectMapper mapper = new ObjectMapper();
	
	public List<RelationClientDTO> decodeRelateJSON(String jsonData){
		List<RelationClientDTO> relationList = new ArrayList<RelationClientDTO>();
		try {
			relationList = mapper.readValue(jsonData, mapper.getTypeFactory().constructCollectionType(List.class, RelationClientDTO.class));
			System.out.println(relationList);

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
		return relationList;
	}
	
	public List<BaseClass> decodeNodeJSON(String jsonData) {
		// String jsonData =
		// "[{\"id\":\"23\",\"x\":-170.0017465437012,\"y\":-53.087326299312394,\"label\":\"new\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"},{\"id\":\"233\",\"x\":-92.00174654370119,\"y\":-79.0873262993124,\"label\":\"new2\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"}][{\"id\":\"2279a429-9c25-9aca-d813-4f5b8aba3c9a\",\"x\":-170.0017465437012,\"y\":-53.087326299312394,\"label\":\"new\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"},{\"id\":\"d3083eed-cda4-78af-7ca5-1f2bdf0ce03c\",\"x\":-92.00174654370119,\"y\":-79.0873262993124,\"label\":\"new2\",\"allowedToMoveX\":true,\"allowedToMoveY\":true,\"moons\":\"1\"}]";
		
		List<BaseClass> listOfWorld = new ArrayList<BaseClass>();
		try {
			listOfWorld = mapper.readValue(jsonData, mapper.getTypeFactory().constructCollectionType(List.class, BaseClass.class));
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
		return listOfWorld;
	}

	public void saveRelations(String relateSaveArray) {
		
		List<RelationClientDTO> relateList = decodeRelateJSON(relateSaveArray);
		World fromWorld = null;
		World toWorld = null;
		for(RelationClientDTO relation:relateList){
			fromWorld = findWorldById(relation.getFrom());
			if(null == fromWorld)
				fromWorld = findWorldByCreatedAt(relation.getFrom());
			toWorld = findWorldById(relation.getTo());
			if(null == toWorld)
				fromWorld = findWorldByCreatedAt(relation.getTo());
			fromWorld.addRocketRouteTo(toWorld);
			worldRepository.save(fromWorld);
			System.out.println(fromWorld.getReachableWorlds());
		}
		
	}

}
