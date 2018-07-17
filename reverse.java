/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/*server*/
import java.util.Scanner;
import java.io.*;
import java.net.*;

class TCPServer {
 public static void main(String args[]) throws Exception {
     
  System.out.println("please enter message at client");
  String clientSentence;
  String capitalizedSentence;
  ServerSocket welcomeSocket = new ServerSocket(6786);

  while (true) {
   Socket connectionSocket = welcomeSocket.accept();
   
InputStreamReader a= new InputStreamReader (connectionSocket.getInputStream());

BufferedReader inFromClient = new BufferedReader(a);
   
DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
  
 clientSentence = inFromClient.readLine();

   System.out.println("Received: " + clientSentence);
   capitalizedSentence = clientSentence.toLowerCase() + '\n';
   
   
   Scanner read = new Scanner(clientSentence);
        String str = read.nextLine();
        String reverse = "";
     for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }
     outToClient.writeBytes(reverse);
        
  }
 }
}

