package task02;

import java.io.*; 
import java.net.*; 
import java.util.*;

public class Client {
    
    public static void main(String[] args) throws IOException {

        String address = "task02.chuklee.com"; 
        int port = 80; 
        String ip = "68.183.239.26"; 
        ArrayList<Integer> numbersList = new ArrayList<>(); 
        float divisor; 
        float average; 
        int sum = 0;
        
        String requestId;


        Socket sock = new Socket(ip, port);
        System.out.printf("Connected to %s at port %d\n", address, port);

        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        String request = ois.readUTF(); 
        if(request != null) {
        String[] requestList = request.split(" "); 
        requestId = requestList[0];       
        String requestInt = requestList[1];       
        String[] intList = requestInt.split(",");
            for(int i=0; i<intList.length; i++) {
                numbersList.add(Integer.parseInt(intList[i])); 
                sum += numbersList.get(i); 
            }
            divisor = intList.length; 
            average = sum / divisor; 
            
            System.out.println(average);
            oos.writeUTF(requestId);
            oos.flush();

            oos.writeUTF("Gay Horng Tze James");
            oos.flush();

            oos.writeUTF("jamesgayht@gmail.com");
            oos.flush();

            oos.writeFloat(average);
            oos.flush();
        }

        boolean response = ois.readBoolean();
        if (response == true) {
            is.close();
            ois.close();
            os.close();
            ois.close();
            System.out.println("SUCCESS");
            sock.close();
        } else {
            String error = ois.readUTF(); 
            System.err.append(error); 
        }
    }


}
