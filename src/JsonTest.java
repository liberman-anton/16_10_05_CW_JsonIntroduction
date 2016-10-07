import java.util.*;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
	private static final String TYPE = "_class";
	static ObjectMapper mapper = new ObjectMapper();

	public static void main(String[] args) throws Exception {
//		int ar[] = {1,0,10,20};
//		String json = mapper.writeValueAsString(ar);
//		System.out.println(json);
//		int ar1[][] = mapper.readValue("[[10,20,8],[30,7]]", int[][].class);
//		System.out.println(ar1.length + " " + (ar1[0][0] + ar1[1][0]));
		
//		X x = new X();
//		x.xarf = new float[]{2.4f,2.7f};
//		x.xs = "Hello";
//		x.xi = 10;
//		String json = mapper.writeValueAsString(x);
//		System.out.println(json);
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		X ar[] = {new X(10,new float[]{2.5f,6.7f,8f},"abc"),
				new X(2, new float[]{5}, "xs"),
				new Y(7, new float[]{4.3f,6f}, "xs", "ys", 5)};
		List<Map<String,Object>> listMaps = getListMaps(ar);
		String json = mapper.writeValueAsString(listMaps);
		System.out.println(json);
		
		List<Map<String,Object>> listMapsJson = mapper.readValue(json, List.class);
		X[] ar1 = getArrayX(listMapsJson);
//		X[] ar1 = mapper.readValue(json, X[].class);
		System.out.println(Arrays.deepToString(ar1));
	}

	private static X[] getArrayX(List<Map<String, Object>> listMapsJson) throws Exception {
		X[] res = new X[listMapsJson.size()];
		int ind = 0;
		for(Map<String,Object> mapJson : listMapsJson){
			res[ind++] = getX(mapJson);
		}
		return res;
	}

	private static X getX(Map<String, Object> mapJson) throws Exception {
		String json = mapper.writeValueAsString(mapJson);
		
		return (X) mapper.readValue(json, Class.forName((String) mapJson.get(TYPE)));
	}

	private static List<Map<String, Object>> getListMaps(X[] ar) throws Exception {
		List<Map<String,Object>> res = new ArrayList<>();
		for(X x : ar){
			res.add(getMap(x));
		}
		return res;
	}

	private static Map<String, Object> getMap(X x) throws Exception {
		String json = mapper.writeValueAsString(x);
		Map<String, Object> res = mapper.readValue(json, Map.class);
		res.put(TYPE, x.getClass().getName());
		return res;
	}

}
