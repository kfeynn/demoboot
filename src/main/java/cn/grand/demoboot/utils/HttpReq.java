package cn.grand.demoboot.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class HttpReq
{
//    /*     * 读取流中的数据
//     * */
//    public static byte[] read(InputStream inStream) throws Exception {
//        ByteArrayOutputStream outStream=new ByteArrayOutputStream();
//        byte[] buffer=new byte[1024];
//        int len=0;
//        while((len=inStream.read(buffer))!=-1){
//            outStream.write(buffer,0,len);
//        }
//        inStream.close();
//        return outStream.toByteArray();
//    }

    public static String toPostdata(List<BasicNameValuePair> parameters, String uri)
    {
        String str = "获取失败";
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(30 * 1000) // socket套接字超时，毫秒。 10*1000 设置久一点
                .setConnectionRequestTimeout(30 * 1000) //使用连接池来管理连接时，从连接池获取连接的超时时间，毫秒。
                .setConnectTimeout(30 * 1000) // 连接建立超时，毫秒。
                .build();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(config)                //加载参数
                .build();
        HttpPost httpPost = new HttpPost(uri);

        UrlEncodedFormEntity params;
        try
        {
            params = new UrlEncodedFormEntity(parameters, "UTF-8");
            httpPost.setEntity(params);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost); // 执行请求
            if (httpResponse.getStatusLine().getStatusCode() == 200)
            {
                //请求成功
                HttpEntity entity = httpResponse.getEntity();
                str = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (UnsupportedEncodingException e)
        {
            System.out.println("传递参数错误");
            e.printStackTrace();
        } catch (ClientProtocolException e)
        {
            System.out.println("请求协议错误");
            e.printStackTrace();
        } catch (IOException e)
        {
            System.out.println("Connect failed");
            e.printStackTrace();
        }
        return str;
    }

    public static String toPostdata(String uri)
    {
        String str = "获取失败";
        //初始化
        //HttpClient client=new DefaultHttpClient();  //过时
        HttpClient client = HttpClientBuilder.create().build();//获取DefaultHttpClient请求
        //HttpPath.GetGamesPath() : 网络请求路径
        HttpPost httpPost = new HttpPost(uri);
        //设置参数
        try
        {
            //执行请求
            HttpResponse response = client.execute(httpPost);
            //取得返回值
            if (response.getStatusLine().getStatusCode() == 200)
            {
                //请求成功
                HttpEntity entity = response.getEntity();
                str = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            str = toPostdata(uri);
        }
        return str;
    }

}
