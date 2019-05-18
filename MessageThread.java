//MessageThread.java
import java.net.*;  
import java.io.*;
public class MessageThread extends Thread {
    protected Socket socket;

    public MessageThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    public void run() {
        try{
        DataInputStream din=new DataInputStream(socket.getInputStream());  
    DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="";  
while(!str.equals("stop")){ 
str=din.readUTF();  
String[] split = str.split(";");
int out_index = Integer.parseInt(split[1])-1;
if(str!=";1" && str!=";2"){
System.out.println(str);  
System.out.println(split[1]);
}
//str2=br.readLine();  
DataOutputStream rdout = new DataOutputStream(((Socket)MultiStageServer.reciever_sockets[out_index]).getOutputStream());
rdout.writeUTF(str);  
rdout.flush(); 
}
socket.close();
}catch(Exception e){
    System.out.println(e);
}
    }
}