package task02;

import java.io.*; 
import java.net.*;
import java.util.LinkedList;
import java.util.List; 

public class Server {
    public int port;
    public String url; 
    public Socket sock;

    public static void main(String[] args) throws IOException {

        int port = 80; 
        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for connection on port 80 ");
        server.setSoTimeout(15*1000);
        Socket sock = server.accept();
        System.out.println("Connected! ");

        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        String request = "1234abcd 97,35,82,2,45";
            oos.writeUTF(request);
            oos.flush();

        String response = ois.readUTF(); 
        List<String> responseList = new LinkedList<>(); 
        while(response != null) {
            responseList.add(response); 
            break;
        } 
        
        String requestID = "1234abcd"; 
        String nameAsNric = "Gay Horng Tze James"; 
        String email = "jamesgayht@gmail.com"; 
        float average = 52.2f;
        if(responseList.contains(requestID)) 
            if(responseList.contains(nameAsNric))
                if(responseList.contains(email))
                    if (responseList.contains(average)) {
                        oos.writeBoolean(true);
                        oos.flush();
                    } else {
                        oos.writeBoolean(false);
                        oos.flush();
                    }
        is.close();
        ois.close();
        os.close();
        oos.close();
        sock.close();
        server.close();
    }
}