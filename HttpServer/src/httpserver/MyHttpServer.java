/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jon
 */
public class MyHttpServer {

    /**
     * @param args the command line arguments
     */
    
    static AddressListModel database = new AddressListModel();
    
    public static void main(String[] args) {
        
        try (ServerSocket serverSocket = new ServerSocket(12346)) {
            System.out.println("Waiting for connection...");
            
            serverEventLoop(serverSocket);
            
        }catch(IOException e){
            System.out.println("exception occurred when creating socket.  terminating.");
        }
        
        
    }
    
    private static void serverEventLoop(ServerSocket serverSocket) throws IOException{
        
        while (true) {
            System.out.println("Event loop - waiting");
            
            Socket connectionSocket = serverSocket.accept();
            System.out.println("Incoming connection");
            
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        connectionSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(
                        connectionSocket.getOutputStream(), true)) {
                handleIncomingTcpConnection (br, out);
                out.close();
            }catch(IOException ex){
                System.out.println("Terminate");
            }
           
            connectionSocket.close();
            
        }
        
    }
    
    private static void handleIncomingTcpConnection(BufferedReader br, PrintWriter out) throws IOException{
        
        AddressController controller = new AddressController(database);
        
        while (true){
            
            String inputLine = br.readLine();
            //E.g. GET /address HTTP/1.1
            
            
            if(inputLine == null){
                break;
            }
            
            HttpRequest req = HttpRequest.fromString(inputLine);
            
            if(req != null){
                System.out.println(inputLine);
                View v = controller.respondToLocationRequest(req);
                
                //out.print(v.makeHTML());
                
                
                out.write("HTTP/1.1 200 OK\n");
                out.write("content-Type: text/html\n");
                out.write("\n");
                out.write(v.makeHTML());
                out.write("\n");
                break;
                
            }else{
                
                out.write("Error 404");
                
            }
            
        }
    }
    
    
    
}
