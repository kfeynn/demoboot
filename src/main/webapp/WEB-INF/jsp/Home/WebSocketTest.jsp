<%--
  Created by IntelliJ IDEA.
  User: yuanqiang.zheng
  Date: 2020/4/13
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/websocket/websocket.js"></script>--%>

    <script type="text/javascript">
        var websocket = null;
        //判断当前浏览器是否支持WebSocket
        if ('WebSocket' in window) {
            //连接websocket服务器 （带用户名，可为登录ID或“游客(不要后一节)”）
            websocket = new WebSocket("ws://localhost:8080/websocket/admin0");
            //连接成功建立的回调方法
            websocket.onopen = function (){
                websocket.send("客户端链接成功");
            }
            //接收到消息的回调方法
            websocket.onmessage = function (event) {
                //setMessageInnerHTML(event.data);
                //alert(event.data);  //弹出websocket发送回来的消息
                document.getElementById("msg").innerText = event.data ;
            }
            //连接发生错误的回调方法
            websocket.onerror = function () {
                alert("WebSocket连接发生错误");
            };
            //连接关闭的回调方法
            websocket.onclose = function () {
                alert("WebSocket连接关闭xx");
            }
            //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
            window.onbeforeunload = function () {
                closeWebSocket();
            }
        }
        else
        {
            alert('当前浏览器 Not support websocket')
        }

        //将消息显示在网页上
        function setMessageInnerHTML(innerHTML)
        {
            var bitcoin = eval("("+innerHTML+")");
            document.getElementById('price').innerHTML = bitcoin.price;
            document.getElementById('total').innerHTML = bitcoin.total;
        }
        //关闭WebSocket连接
        function closeWebSocket()
        {
            websocket.close();
        }
        function textSend()
        {
            websocket.send("发送消息1");
        }
    </script>

</head>
<body>

<input value="send Message to WebSocket" type="button"  onclick="textSend()">

<span id="msg"></span>

</body>
</html>
