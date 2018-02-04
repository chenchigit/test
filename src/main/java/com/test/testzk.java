package com.test;

/**
 * Created by wb-chenchi on 2018/1/18.
 */
import com.test.WindowsShell;




import org.I0Itec.zkclient.ZkClient;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuzs on 2017/3/31.
 */
public class testzk {
    /**
     * 根据dubbo服务名找到服务对应的ip和端口号
     *
     * @param String zkip,String zkport,String servername
     * @throws UnsupportedEncodingException
     */
    //com.dtdream.vanyar.gpcatalog.facade.IGpCatalogFacade
    public  Map<String, String> getipAndport(String zkip, String zkport, String servername) {
        Map<String, String> map = new HashMap<String, String>();

        String str = "";
        String ip = "";
        String port = "";
        List<String> list = new ArrayList<String>();
        ZkClient zkClient = new ZkClient(zkip + ":" + zkport, 5000);
        //System.out.println("zk地址："+zkip+":"+zkport);
        list = zkClient.getChildren("/dubbo/" + servername + "/providers");
        //System.out.println("服务名："+"/dubbo/"+servername+"/providers");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {

            str = (String) it.next();
            System.out.println("返回provider信息：" + str);
            break;
        }


        //根据返回值，正则表达式获取ip
        Pattern pattern_ip = Pattern.compile("%2F(.*?)%3A");
        Matcher matcher_ip = pattern_ip.matcher(str);
        while (matcher_ip.find()) {
            ip = matcher_ip.group().replaceAll("%2F", "").replaceAll("%3A", "");
            break;
        }
        System.out.println("服务的ip：" + ip);

        //根据返回值，正则表达式获取port
        Pattern pattern_port = Pattern.compile("%3A(.*?)%2F");
        Matcher matcher_port = pattern_port.matcher(str);
        while (matcher_port.find(20)) {
            port = matcher_port.group().replaceAll("%2F", "").replaceAll("%3A", "");
            break;
        }
        System.out.println("服务的port：" + port);
        //return port;
        map.put("ip", ip);
        map.put("port", port);
        return map;

    }

}





//    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<String,String>();
//        map = getipAndport("172.16.101.47", "1500", "com.dtdream.vanyar.gpcatalog.facade.IGpCatalogFacade");
//        System.out.println("IP:"+map.get("ip")+"PORT:"+map.get("port"));
//
//        }
//    }