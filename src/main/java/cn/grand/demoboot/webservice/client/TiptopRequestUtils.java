package cn.grand.demoboot.webservice.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;



public class TiptopRequestUtils {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildReceivingRequest(String json, String plant){
		StringBuilder sb = new StringBuilder();
		
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		
		//String plant = headMap.get(plantKey).substring(0, 3);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		
		List<Map<String, String>> bodyList = JSON.parseObject(map.get("body").toString(), List.class);
		
		StringBuilder detailBuilder = new StringBuilder();
		detailBuilder.append("<Detail name=\"t001_file\">");
		for(Map<String, String> bodyMap : bodyList){
			detailBuilder.append("<Record>");
			for(Entry<String, String> entry: bodyMap.entrySet()){
				detailBuilder.append("<Field name=\"");
				detailBuilder.append(entry.getKey());
				detailBuilder.append("\" value=\"");
				detailBuilder.append(entry.getValue());
				detailBuilder.append("\"/>");
			}
			detailBuilder.append("</Record>");
		}
		detailBuilder.append("</Detail>");
		
		sb.append(masterBuilder);
		sb.append(detailBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	//委外退货单生成xml
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildRejectedRequest(String json, String plant){
		StringBuilder sb = new StringBuilder();
		
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		
		//String plant = headMap.get(plantKey).substring(0, 3);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		
		List<Map<String, String>> bodyList = JSON.parseObject(map.get("body").toString(), List.class);
		
		StringBuilder detailBuilder = new StringBuilder();
		detailBuilder.append("<Detail name=\"t001_file\">");
		for(Map<String, String> bodyMap : bodyList){
			detailBuilder.append("<Record>");
			for(Entry<String, String> entry: bodyMap.entrySet()){
				detailBuilder.append("<Field name=\"");
				detailBuilder.append(entry.getKey());
				detailBuilder.append("\" value=\"");
				detailBuilder.append(entry.getValue());
				detailBuilder.append("\"/>");
			}
			detailBuilder.append("</Record>");
		}
		detailBuilder.append("</Detail>");
		
		sb.append(masterBuilder);
		sb.append(detailBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryRNRequest(String boxnum,String plant){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("barcode");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(boxnum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryRN1Request(String boxnum,String plant){   //根据送货单获取收货单信息,送货单交接用
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("rva07");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(boxnum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildGroundingRequest(String json, String plant){
		StringBuilder sb = new StringBuilder();
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");

		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		
		List<Map<String, String>> bodyList1 = JSON.parseObject(map.get("body1").toString(), List.class);
		
		StringBuilder detailBuilder = new StringBuilder();
		detailBuilder.append("<Detail name=\"t003_file\">");
		for(Map<String, String> bodyMap : bodyList1){
			detailBuilder.append("<Record>");
			for(Entry<String, String> entry: bodyMap.entrySet()){
				detailBuilder.append("<Field name=\"");
				detailBuilder.append(entry.getKey());
				detailBuilder.append("\" value=\"");
				detailBuilder.append(entry.getValue());
				detailBuilder.append("\"/>");
			}
			detailBuilder.append("</Record>");
		}
		detailBuilder.append("</Detail>");
		sb.append(masterBuilder);
		sb.append(detailBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryPKboxRequest(String pkNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(pkNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("sfp01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(pkNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildUpdateAxmt620Request(String oga01,String user){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(oga01.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");		
		masterBuilder.append("oga01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(oga01);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("user");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(user);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		sb.append(masterBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildGetAsfi510Request(String sfp01)
	{
//              <Request>
//				<Access>
//				<Authentication user="tiptop" password="tiptop" />
//				<Connection application="APP" source="192.168.0.34" />
//				<Organization name="S31" />
//				<Locale language="zh_cn" />
//				</Access>
//				<RequestContent>
//				<Parameter>
//				<Record>
//				<Field name="sfp01" value="331-S312006180001"/>
//				</Record>
//				</Parameter>
//				</RequestContent>
//				</Request>
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
		sb.append("<Access>");
		sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
		sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
		sb.append("<Organization name=\"");
		sb.append("S31");
		sb.append("\" />");
		sb.append("<Locale language=\"zh_cn\" />");
		sb.append("</Access>");
		sb.append("<RequestContent>");
		sb.append("<Parameter/>");
		sb.append("<Document>");
		sb.append("<RecordSet id=\"1\">");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("sfp01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(sfp01);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		sb.append(masterBuilder);
		sb.append("</RecordSet>");
		sb.append("</Document>");
		sb.append("</RequestContent>");
		sb.append("</Request>");
		System.out.println(sb.toString());
		return sb.toString();
	}


	//调拨获取的拼接方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryAKboxRequest(String akNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(akNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("imm01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(akNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	//下阶报废单获取的拼接方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryBKboxRequest(String bkNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(bkNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("sfk01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(bkNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	//组合拆解单获取的拼接方法
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static String buildQueryCKboxRequest(String ckNum){
			StringBuilder sb = new StringBuilder();
			sb.append("<Request>");
	        sb.append("<Access>");
	        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
	        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
	        sb.append("<Organization name=\"");
//	        sb.append("S10180328");
	        sb.append(ckNum.substring(4,7));
	        sb.append("\" />");
	        sb.append("<Locale language=\"zh_cn\" />");
	        sb.append("</Access>");
	        sb.append("<RequestContent>");
	        sb.append("<Parameter>");
			StringBuilder masterBuilder = new StringBuilder();
			masterBuilder.append("<Record>");
			masterBuilder.append("<Field name=\"");
			masterBuilder.append("tse01");
			masterBuilder.append("\" value=\"");
			masterBuilder.append(ckNum);
			masterBuilder.append("\"/>");
			masterBuilder.append("</Record>");
			sb.append(masterBuilder);
			sb.append("</Parameter>");
	        sb.append("</RequestContent>");
	        sb.append("</Request>");	
	        System.out.println(sb.toString());
			return sb.toString();
		}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQuerySPKboxRequest(String pkNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(pkNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("ina01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(pkNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryWRboxRequest(String wrNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(wrNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("sfp01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(wrNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("sfpplant");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(wrNum.substring(4,7));
		//masterBuilder.append("S10180328");
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildCommonRequest(String json,String plant){
		StringBuilder sb = new StringBuilder();
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");

		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		sb.append(masterBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildPackingRequest(String number,String user, String plant){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		if(number.substring(0,2).equals("11")){
			masterBuilder.append("ina01");
		}else{
			masterBuilder.append("sfp01");
		}
		masterBuilder.append("\" value=\"");
		masterBuilder.append(number);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("user");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(user);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		sb.append(masterBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	//调拨过账方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildAllotRequest(String number,String user, String plant){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");		
		masterBuilder.append("imm01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(number);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("user");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(user);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		sb.append(masterBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}	
	//下阶报废单过账方法
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public static String buildDumpingRequest(String number,String user, String plant){
			StringBuilder sb = new StringBuilder();
			sb.append("<Request>");
	        sb.append("<Access>");
	        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
	        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
	        sb.append("<Organization name=\"");
	        //sb.append("S10180328");
	        sb.append(plant);
	        sb.append("\" />");
	        sb.append("<Locale language=\"zh_cn\" />");
	        sb.append("</Access>");
	        sb.append("<RequestContent>");
	        sb.append("<Parameter/>");
	        sb.append("<Document>");
	        sb.append("<RecordSet id=\"1\">");
			StringBuilder masterBuilder = new StringBuilder();
			masterBuilder.append("<Master name=\"Master\">");
			masterBuilder.append("<Record>");
			masterBuilder.append("<Field name=\"");		
			masterBuilder.append("sfk01");
			masterBuilder.append("\" value=\"");
			masterBuilder.append(number);
			masterBuilder.append("\"/>");
			masterBuilder.append("<Field name=\"");
			masterBuilder.append("user");
			masterBuilder.append("\" value=\"");
			masterBuilder.append(user);
			masterBuilder.append("\"/>");
			masterBuilder.append("</Record>");
			masterBuilder.append("</Master>");
			sb.append(masterBuilder);
	        sb.append("</RecordSet>");
	        sb.append("</Document>");
	        sb.append("</RequestContent>");
	        sb.append("</Request>");
	        System.out.println(sb.toString());
			return sb.toString();
		}	
		//组合拆解单过账方法
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public static String buildApartRequest(String number,String user, String plant){
					StringBuilder sb = new StringBuilder();
					sb.append("<Request>");
			        sb.append("<Access>");
			        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
			        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
			        sb.append("<Organization name=\"");
//			        sb.append("S10180328");
			        sb.append(plant);
			        sb.append("\" />");
			        sb.append("<Locale language=\"zh_cn\" />");
			        sb.append("</Access>");
			        sb.append("<RequestContent>");
			        sb.append("<Parameter/>");
			        sb.append("<Document>");
			        sb.append("<RecordSet id=\"1\">");
					StringBuilder masterBuilder = new StringBuilder();
					masterBuilder.append("<Master name=\"Master\">");
					masterBuilder.append("<Record>");
					masterBuilder.append("<Field name=\"");		
					masterBuilder.append("tse01");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(number);
					masterBuilder.append("\"/>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("user");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(user);
					masterBuilder.append("\"/>");
					masterBuilder.append("</Record>");
					masterBuilder.append("</Master>");
					sb.append(masterBuilder);
			        sb.append("</RecordSet>");
			        sb.append("</Document>");
			        sb.append("</RequestContent>");
			        sb.append("</Request>");
			        System.out.println(sb.toString());
					return sb.toString();
				}
				//仓退获取仓退单列表ERP接口(交接)
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public static String buildQueryWHRboxaRequest(String whNum){
					StringBuilder sb = new StringBuilder();
					sb.append("<Request>");
			        sb.append("<Access>");
			        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
			        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
			        sb.append("<Organization name=\"");
			        //sb.append("S10180328");
			        sb.append(whNum.substring(4,7));
			        sb.append("\" />");
			        sb.append("<Locale language=\"zh_cn\" />");
			        sb.append("</Access>");
			        sb.append("<RequestContent>");
			        sb.append("<Parameter>");
					StringBuilder masterBuilder = new StringBuilder();
					masterBuilder.append("<Record>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("rvv01");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(whNum);
					masterBuilder.append("\"/>");
//					masterBuilder.append("<Field name=\"");
//					masterBuilder.append("rvuplant");
//					masterBuilder.append("\" value=\"");
//					masterBuilder.append(whNum.substring(4,7));
//					//masterBuilder.append("S10180328");
//					masterBuilder.append("\"/>");
					masterBuilder.append("</Record>");
					sb.append(masterBuilder);
					sb.append("</Parameter>");
			        sb.append("</RequestContent>");
			        sb.append("</Request>");	
			        System.out.println(sb.toString());
					return sb.toString();
				}
				//仓退交接
				@SuppressWarnings({ "unchecked", "rawtypes" })
   public static String buildWRboxJoinRequest(String number,String user){
					StringBuilder sb = new StringBuilder();
					sb.append("<Request>");
			        sb.append("<Access>");
			        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
			        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
			        sb.append("<Organization name=\"");
			        //sb.append("S10180328");
			        sb.append(number.substring(4,7));
			        sb.append("\" />");
			        sb.append("<Locale language=\"zh_cn\" />");
			        sb.append("</Access>");
			        sb.append("<RequestContent>");
			        sb.append("<Parameter>");
					StringBuilder masterBuilder = new StringBuilder();
					masterBuilder.append("<Record>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("tc_imb01");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(number);
					masterBuilder.append("\"/>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("user");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(user);
					//masterBuilder.append("S10180328");
					masterBuilder.append("\"/>");
					masterBuilder.append("</Record>");
					sb.append(masterBuilder);
					sb.append("</Parameter>");
			        sb.append("</RequestContent>");
			        sb.append("</Request>");	
			        System.out.println(sb.toString());
					return sb.toString();
				}
				//送货交接
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public static String buildRNboxJoin1Request(String number,String user,String plant){
					StringBuilder sb = new StringBuilder();
					sb.append("<Request>");
			        sb.append("<Access>");
			        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
			        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
			        sb.append("<Organization name=\"");
			        //sb.append("S10180328");
			        sb.append(plant);
			        sb.append("\" />");
			        sb.append("<Locale language=\"zh_cn\" />");
			        sb.append("</Access>");
			        sb.append("<RequestContent>");
			        sb.append("<Parameter>");
					StringBuilder masterBuilder = new StringBuilder();
					masterBuilder.append("<Record>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("tc_imb01");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(number);
					masterBuilder.append("\"/>");
					masterBuilder.append("<Field name=\"");
					masterBuilder.append("user");
					masterBuilder.append("\" value=\"");
					masterBuilder.append(user);
					//masterBuilder.append("S10180328");
					masterBuilder.append("\"/>");
					masterBuilder.append("</Record>");
					sb.append(masterBuilder);
					sb.append("</Parameter>");
			        sb.append("</RequestContent>");
			        sb.append("</Request>");	
			        System.out.println(sb.toString());
					return sb.toString();
				}								
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildIQCRequest(String json,String plant){
		StringBuilder sb = new StringBuilder();
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		List<Map<String, String>> bodyList = JSON.parseObject(map.get("body").toString(), List.class);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(plant);
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		StringBuilder detailBuilder = new StringBuilder();
		detailBuilder.append("<Detail name=\"t001_file\">");
		for(Map<String, String> bodyMap : bodyList){
			detailBuilder.append("<Record>");
			for(Entry<String, String> entry: bodyMap.entrySet()){
				detailBuilder.append("<Field name=\"");
				detailBuilder.append(entry.getKey());
				detailBuilder.append("\" value=\"");
				detailBuilder.append(entry.getValue());
				detailBuilder.append("\"/>");
			}
			detailBuilder.append("</Record>");
		}
		detailBuilder.append("</Detail>");
		sb.append(masterBuilder);
		sb.append(detailBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	//仓退获取仓退单列表ERP接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryWHRboxRequest(String whNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        //sb.append("S10180328");
        sb.append(whNum.substring(4,7));
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("rvu01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(whNum);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("rvuplant");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(whNum.substring(4,7));
		//masterBuilder.append("S10180328");
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildImptAndEmptRequest(String tlf01, String plant,String Waddr,
			String start_tme,String end_time){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(tlf01);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf902");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(Waddr);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf06a");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(start_tme);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf06b");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(end_time);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildGetIqcItemRequest(String rvb01, String plant,String rvb02){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("qcs01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(rvb01);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("qcs02");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(rvb02);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildgoodsMoveRequest(String json, String plant){
		StringBuilder sb = new StringBuilder();
		Map map = JSON.parseObject(json, Map.class);
		Map<String, String> headMap = JSON.parseObject(map.get("head").toString(), Map.class);
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter/>");
        sb.append("<Document>");
        sb.append("<RecordSet id=\"1\">");

		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Master name=\"Master\">");
		masterBuilder.append("<Record>");
		for(Entry<String, String> entry: headMap.entrySet()){
			masterBuilder.append("<Field name=\"");
			masterBuilder.append(entry.getKey());
			masterBuilder.append("\" value=\"");
			masterBuilder.append(entry.getValue());
			masterBuilder.append("\"/>");
		}
		masterBuilder.append("</Record>");
		masterBuilder.append("</Master>");
		
		List<Map<String, String>> bodyList1 = JSON.parseObject(map.get("body1").toString(), List.class);
		
		StringBuilder detailBuilder = new StringBuilder();
		detailBuilder.append("<Detail name=\"t324_file\">");
		for(Map<String, String> bodyMap : bodyList1){
			detailBuilder.append("<Record>");
			for(Entry<String, String> entry: bodyMap.entrySet()){
				detailBuilder.append("<Field name=\"");
				detailBuilder.append(entry.getKey());
				detailBuilder.append("\" value=\"");
				detailBuilder.append(entry.getValue());
				detailBuilder.append("\"/>");
			}
			detailBuilder.append("</Record>");
		}
		detailBuilder.append("</Detail>");
		sb.append(masterBuilder);
		sb.append(detailBuilder);
        sb.append("</RecordSet>");
        sb.append("</Document>");
        sb.append("</RequestContent>");
        sb.append("</Request>");
        System.out.println(sb.toString());
		return sb.toString();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String buildQueryGoodAddrRequest(String rvb05,String plant,String tlf902){
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
        sb.append("<Access>");
        sb.append("<Authentication user=\"tiptop\" password=\"tiptop\" />");
        sb.append("<Connection application=\"APP\" source=\"192.168.0.34\" />");
        sb.append("<Organization name=\"");
        sb.append(plant);
        //sb.append("S10180328");
        sb.append("\" />");
        sb.append("<Locale language=\"zh_cn\" />");
        sb.append("</Access>");
        sb.append("<RequestContent>");
        sb.append("<Parameter>");
		StringBuilder masterBuilder = new StringBuilder();
		masterBuilder.append("<Record>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf01");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(rvb05);
		masterBuilder.append("\"/>");
		masterBuilder.append("<Field name=\"");
		masterBuilder.append("tlf902");
		masterBuilder.append("\" value=\"");
		masterBuilder.append(tlf902);
		masterBuilder.append("\"/>");
		masterBuilder.append("</Record>");
		sb.append(masterBuilder);
		sb.append("</Parameter>");
        sb.append("</RequestContent>");
        sb.append("</Request>");	
        System.out.println(sb.toString());
		return sb.toString();
	}
}
