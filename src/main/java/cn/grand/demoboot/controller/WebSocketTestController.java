package cn.grand.demoboot.controller;

import cn.grand.demoboot.websocket.WebSocketServer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Home")
public class WebSocketTestController
{
    @RequestMapping("/WebSocketTest")

    //public void pushToWeb(String message,   String toUserId, Model model) throws Exception {
    public String pushToWeb(@RequestParam(value = "message", required = false, defaultValue = "") String message,
                          @RequestParam(value = "toUserId", required = false, defaultValue = "") String toUserId,
                         Model model) throws Exception
    {
        //WebSocketServer.sendInfo(message,toUserId);

//        WebSocketServer server = new WebSocketServer();
//        server.sendMessage("群发消息");
        return "Home/WebSocketTest";
    }

    @RequestMapping("/WebSocketTest2")

    //public void pushToWeb(String message,   String toUserId, Model model) throws Exception {
    public String WebSocketTest2(@RequestParam(value = "message", required = false, defaultValue = "") String message,
                            @RequestParam(value = "toUserId", required = false, defaultValue = "") String toUserId,
                            Model model) throws Exception
    {
        //WebSocketServer.sendInfo(message,toUserId);

//        WebSocketServer server = new WebSocketServer();
//        server.sendMessage("群发消息");
        return "Home/WebSocketTest2";
    }

}
