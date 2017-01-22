package com.artemklimenko;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Artem Klimenko on 21 Jan 2017.
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket socket = new ServerSocket(1201);
            Socket sock = socket.accept();
            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String inMessage = "";
            String outMessage = "";
            while(outMessage != "stop"){
                inMessage = in.readUTF();
                System.out.println(inMessage);
                outMessage = reader.readLine();
                out.writeUTF(outMessage);
                out.flush();

            }
            sock.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
