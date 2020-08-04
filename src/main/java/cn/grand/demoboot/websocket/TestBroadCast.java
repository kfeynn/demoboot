package cn.grand.demoboot.websocket;

import java.util.Map;
import java.util.Random;

public class TestBroadCast  implements Runnable
{


    public  void startup(){
        new Thread(this).start();
    }
    public void run()      {
        int bitPrice = 100000;
        while(true)
        {
            //每隔1-6秒就产生一个新价格
            int duration = 1000 + new Random().nextInt(5000);
            try
            {
                Thread.sleep(duration);
            } catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //新价格围绕100000左右50%波动
            float random = 1 + (float) (Math.random() - 0.5);
            int newPrice = (int) (bitPrice * random);

            //查看的人越多，价格越高
            try
            {
                //广播出去
                WebSocketServer.sendMsgToAll("群发消息:" + String.valueOf(newPrice));

            }
            catch (Exception ex)
            {

            }
        }
    }

}
