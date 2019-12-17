package com.client;
import com.bean.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class UsersClient {
    private Socket socket;
    private Users us;
    private InputStream in;
    private OutputStream out;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private Scanner input=new Scanner(System.in);
    public void sendUsers(){
        try {
            while(true){
                socket=new Socket("172.16.0.172",8899);
                out=socket.getOutputStream();//获取输出流对象
                us=new Users();
                System.out.println("请输入账号:");
                us.setUname(input.next());

                System.out.println("请输入密码:");
                us.setPasswd(input.next());

                //将us对象发送到服务器
                objectOutputStream=new ObjectOutputStream(out);//使用输出流构建对象输出流
                objectOutputStream.writeObject(us);
                objectOutputStream.flush();

                //接受服务器返回的响应
                in=socket.getInputStream();
                int code=in.read();
                if(code==1){
                    System.out.println("登陆成功！");
                    return;
                }else{
                    System.out.println("登录失败！");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
