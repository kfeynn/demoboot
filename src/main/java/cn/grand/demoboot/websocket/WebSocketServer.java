package cn.grand.demoboot.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//websocket 地址
@ServerEndpoint("/websocket/{userId}")
@Component
public class WebSocketServer
{
    //static Log log=LogFactory.get(WebSocketServer.class);
    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    // 保存所有的用户session
    //private static final ArrayList<Session> users = new ArrayList<Session>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String userId="";

    /**
     * 连接建立成功调用的方法 RequestParam \ PathParam
     *public void onOpen(Session session,@PathParam("userId") String userId) {
    */
    @OnOpen
    public void onOpen(Session session,@PathParam("userId") String userId)
    {
        if (userId == null || "".equals(userId))
        {
            userId = "游客";
        }
        this.session = session;
        this.userId = userId;
        if (webSocketMap.containsKey(userId))
        {
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
            //加入set中
        } else
        {
            //加入set中
            webSocketMap.put(userId, this);
            //在线数加1
            addOnlineCount();
        }
        System.out.println("用户连接:"+userId+",当前在线人数为:" + getOnlineCount() + ":"+ this.userId);
        //log.info("用户连接:"+userId+",当前在线人数为:" + getOnlineCount());
//        try {
//            sendMessage("连接成功");
//        } catch (IOException e) {
//            //log.error("用户:"+userId+",网络异常!!!!!!");
//        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose()
    {
        if (webSocketMap.containsKey(userId))
        {
            webSocketMap.remove(userId);
            //从set中删除
            subOnlineCount();
        }
        //log.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * public void onMessage(String message, Session session)
     * */

    @OnMessage
    public void onMessage(String message, Session session)
    {
        //log.info("用户消息:"+userId+",报文:"+message);
        //
        System.out.println(userId); //自动可以获最近连接用户id信息
        //可以群发消息
        //消息保存到数据库、redis
        if (!"".equals(message))
        {
            try
            {
                //region 原代码（作废）
//                //解析发送的报文（报文尽量统一格式）
//                JSONObject jsonObject = JSON.parseObject(message);
//                //追加发送人(防止串改)
//                jsonObject.put("fromUserId",this.userId);
//                String toUserId=jsonObject.getString("toUserId");
//                //传送给对应toUserId用户的websocket
//                if(!"".equals(toUserId)&&webSocketMap.containsKey(toUserId)){
//                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
//                }else{
//                    //log.error("请求的userId:"+toUserId+"不在该服务器上");
//                    //否则不在这个服务器上，发送到mysql或者redis
//                }
                //endregion
                //群发测试
                //sendMsgToAll("群发消息");
                //单发消息测试
                sendMsgToUser(userId, userId + "单发消息给自己");

                //测试不间断群发
//                TestBroadCast cast = new TestBroadCast();
//                cast.run();

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error)
    {
        //log.error("用户错误:"+this.userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException
    {
        this.session.getBasicRemote().sendText(message);
    }

     /**
     * 实现群发(所有用户)
     */
    public static void sendMsgToAll(String message) throws Exception
    {
        for(Map.Entry<String, WebSocketServer> user: webSocketMap.entrySet())
        {
            user.getValue().sendMessage("群发：" + message);
        }
    }

    /**
     * 发送自定义消息
     * */
    public static void sendMsgToUser( String userId,String message) throws IOException
    {
        //log.info("发送消息到:"+userId+"，报文:"+message);
        if (!"".equals(userId) && webSocketMap.containsKey(userId))
        {
            webSocketMap.get(userId).sendMessage(message);
        }
    }

    public static synchronized int getOnlineCount()
    {
        return onlineCount;
    }

    public static synchronized void addOnlineCount()
    {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount()
    {
        WebSocketServer.onlineCount--;
    }
}
