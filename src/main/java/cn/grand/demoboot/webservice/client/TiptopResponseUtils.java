package cn.grand.demoboot.webservice.client;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;

public class TiptopResponseUtils {

	public static Document createDocument(String xml) throws DocumentException {
		ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());
		SAXReader reader = new SAXReader();
		reader.setEncoding("GB2312");
		return reader.read(in);
	}
	
	public static String getStatusElementAttr(Document document, String attr) {
		
		Element e = (Element) document.selectSingleNode("//Status");
		
		if (e != null) return e.attributeValue(attr);  
        else return null;
	}
	
	public static String getValue(Document document, int recordId){
		Element recordList = (Element) document.selectSingleNode("//RecordSet[@id='" + recordId + "']");
		List<Map> mapList = new ArrayList<>();	
		while(recordList != null){
			Map<String, String> map = new HashMap();
			Iterator<Element> itList = recordList.elementIterator();
				Element record = recordList.element("Master").element("Record");
				Iterator<Element> it = record.elementIterator();
				while(it.hasNext()) {
					Element field = it.next();
					map.put(field.attributeValue("name"), field.attributeValue("value"));
				}
				mapList.add(map);
			recordList = (Element) document.selectSingleNode("//RecordSet[@id='" + (++recordId) + "']");
			
		}
			System.out.println(JSON.toJSON(mapList));
			return JSON.toJSONString(mapList);
	}
}
