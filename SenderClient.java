//SenderClient.java
import java.net.*;  
import java.io.*;  
import java.util.*;
class SenderClient{  
public static void main(String args[])throws Exception{  
	//Delete localhost and enter the server ip address
Socket s=new Socket("192.168.43.36",5679);
Socket t=new Socket("192.168.43.36",7890);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
 DataOutputStream dout2=new DataOutputStream(t.getOutputStream()); 
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="";  
String client_name = null;
Scanner sc = new Scanner(System.in);
client_name = sc.nextLine();
Random rand = new Random();
System.out.println("Now start sending your messages:");
while(!str.equals("stop")){  
str=br.readLine();  
int x = rand.nextInt(2);
System.out.println("server: "+x);
String[] split = str.split(";");
if(x==0){
dout.writeUTF(client_name+":"+str);  
dout.flush();  
dout2.writeUTF(";1");  
dout2.flush(); 
dout2.writeUTF(";2");  
dout2.flush();
}
if(x==1){
dout.writeUTF(";1");  
dout.flush();
dout.writeUTF(";2");  
dout.flush();
dout2.writeUTF(client_name+":"+str);  
dout2.flush();  
}
}  
  
dout.close();  
s.close();  
}}  
