package com.zhanwei.java.test10;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static void main(String[] args) throws Exception {
		String json = "";
		json = json.replaceAll("序号","id").replaceAll("公司名称", "name").replaceAll("公司注册地址", "address").replaceAll("税务编码", "code").replaceAll("操作", "action").replaceAll("\"", "\\\"");
		System.out.println(json);
		JavaType javaType = getCollectionType(ArrayList.class, CompanyDTO.class);
		List<CompanyDTO> lst = (List<CompanyDTO>) MAPPER.readValue(json, javaType);
		for(CompanyDTO m : lst){
			System.out.println(m.toString());
		}
	}

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}
