package cn.grand.demoboot.webservice.client;

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
//import org.tempuri.TestService;
//import org.tempuri.TestServiceSoap;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class tiptoptest
{

    public static void main11(String[] args) throws Exception
    {
        //下载cxf ->bin->命令 wsdl2java 生成代码 - > 也可以可打包成jar引用

//       TestServiceSoap serviceSoap = new TestService().getTestServiceSoap();
//       int i  = serviceSoap.add(5,9);
//       System.out.println(i);

//
//        String xml = TiptopRequestUtils.buildGetAsfi510Request("331-S322006230003");

        //ERP webservice wsdl格式似乎不合适cxf框架。用axis
//        TIPTOPServiceGateWayPortType service = new TIPTOPServiceGateWay().getTIPTOPServiceGateWayPortType();
//        GetAsfi510RequestGetAsfi510Request request  = new GetAsfi510RequestGetAsfi510Request();
//        request.setRequest(xml);
//        GetAsfi510ResponseGetAsfi510Response result = service.getAsfi510(request);
//        System.out.println(result);


    }
}
