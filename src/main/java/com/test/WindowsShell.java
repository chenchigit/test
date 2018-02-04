package com.test;
import com.test.testzk;
/**
 * Created by wb-chenchi on 2017/12/13.
 */

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.PrintStream;
        import java.io.UnsupportedEncodingException;
        import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
        import java.util.regex.Pattern;

        import org.apache.commons.net.telnet.TelnetClient;

public class WindowsShell {
    private TelnetClient telnet = new TelnetClient("VT110");

    InputStream in;
    PrintStream out;

    String prompt = ">";

   // public WindowsShell(String ip, int port, String user, String password)
    public WindowsShell(String ip, int port) {
        try {
            telnet.connect(ip, port);
            in = telnet.getInputStream();
            out = new PrintStream(telnet.getOutputStream());
           // login(user, password);
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 登录
     *
     * @param user
     * @param password
     */
    public void login(String user, String password) {
        // read()Until("login:");
        readUntil("login:");
        write(user);
        readUntil("password:");
        write(password);
        readUntil(prompt + "");
    }

    /**
     * 读取分析结果
     *
     * @param pattern
     * @return
     */
    public String readUntil(String pattern) {
        try {
            char lastChar = pattern.charAt(pattern.length() - 1);
            StringBuffer sb = new StringBuffer();
            char ch = (char) in.read();

            while (true) {
                sb.append(ch);
                if (ch == lastChar) {
                    if (sb.toString().endsWith(pattern)) {
                        return sb.toString();
                    }
                }
                ch = (char) in.read();
//              System.out.print(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写操作
     *
     * @param value
     */
    public void write(String value) {
        try {
            out.println(value);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 向目标发送命令字符串
     *
     * @param command
     * @return
     */
    public String sendCommand(String command) {
        try {
            write(command);
            return readUntil(prompt + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接
     */
    public void disconnect() {
        try {
            telnet.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据服务名找到服务对应的ip和端口号
     * @param args
     * @throws UnsupportedEncodingException
     */




    public static void main(String[] args) throws UnsupportedEncodingException {
        //WindowsShell ws = new WindowsShell("172.16.101.130", 61992, "Administrator", "123");
        //WindowsShell ws = new WindowsShell("172.16.101.130", 61992);
        //172.16.101.48:41764
                //test3
        Map<String,String> map = new HashMap<String,String>();
        //test3的zookeeper地址172.16.101.47：1500
        map = new testzk().getipAndport("172.16.101.47", "1500", "com.dtdream.vanyar.gpcatalog.facade.IGpCatalogFacade");
        String ip =map.get("ip");
        int port = Integer.parseInt(map.get("port"));

        WindowsShell ws = new WindowsShell(ip, port);

        // 执行的命令
        String str = ws.sendCommand("invoke com.dtdream.vanyar.gpcatalog.facade.IGpCatalogFacade.getGpCatalogNodeEntityByCode(\"339900\",2017,\"A\")");
        str = new String(str.getBytes("ISO-8859-1"),"GBK");
        System.out.println(str);


        ws.disconnect();
    }

}
