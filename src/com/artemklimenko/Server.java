package com.artemklimenko;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Artem Klimenko on 21 Jan 2017.
 */
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket socket = new ServerSocket(6666);
            System.out.println("Waiting for a client...");
            Socket sock = socket.accept();
            System.out.println("Got a client :");


            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());



            String outMessage = null;
            int i = 0;
            while(true){
                outMessage = in.readUTF();
                System.out.println(outMessage);
                out.writeUTF(outMessage + " messageNo: " + i++);
                out.flush();

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
