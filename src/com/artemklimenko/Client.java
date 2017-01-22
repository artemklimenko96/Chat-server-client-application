package com.artemklimenko;

import java.io.*;
import java.net.Socket;

/**
 * Created by Artem Klimenko on 22 Jan 2017.
 */
public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 6666);


            DataInputStream ins = new DataInputStream(socket.getInputStream());
            DataOutputStream outs = new DataOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String inMessages = null;

            while(true){
                inMessages = reader.readLine();
                outs.writeUTF(inMessages);
                outs.flush();
                inMessages = ins.readUTF();
                System.out.println(inMessages);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
