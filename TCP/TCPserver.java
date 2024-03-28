import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class TCPserver {
    public static void main(String[] args) throws Exception {
        String command;
        String modififedSentence;

        // Establish port
        int port = Integer.parseInt(args[0]);

        // Create socket at port
        ServerSocket servSocket = new ServerSocket(port);        
        
        while(true) {
            Socket connectionSocket = servSocket.accept();
            String clientIP = connectionSocket.getRemoteSocketAddress().toString();
            System.out.println("Client accepted with IP: " + clientIP.substring(1));

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            // Create output stream attached to the socket
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            outToClient.writeBytes("Hello!\n");
            while((command = inFromClient.readLine()) != null) {
                System.out.println("COMMAND: " + command);
                if("bye".equals(command)) {
                    outToClient.writeBytes("Disconnected\n");
                    System.out.println("Disconnected");
                    //TimeUnit.SECONDS.sleep(1);
                    break;
                }
                else if("Meme 1".equals(command)) {
                    command = "meme1.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 2".equals(command)) {
                    command = "meme2.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 3".equals(command)) {
                    command = "meme3.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 4".equals(command)) {
                    command = "meme4.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 5".equals(command)) {
                    command = "meme5.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 6".equals(command)) {
                    command = "meme6.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 7".equals(command)) {
                    command = "meme7.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 8".equals(command)) {
                    command = "meme8.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 9".equals(command)) {
                    command = "meme9.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else if("Meme 10".equals(command)) {
                    command = "meme10.png";
                    writeMeme(command, outToClient, connectionSocket);
                }
                else {
                    // Desired modifications to sentence
                    modififedSentence = "\"" + command + "\"" + " is an invalid input, try again\n";
                    outToClient.writeBytes(modififedSentence);
                }

            }
            outToClient.close();
            inFromClient.close();

        }
    }
    static void writeMeme(String command, DataOutputStream outToClient, Socket connectionSocket) throws Exception{
        System.out.println("Client requested: " + command + ", returning meme");
        outToClient.writeBytes("meme1.png\n");
        TimeUnit.SECONDS.sleep(1);
    
        File file = new File("../memes/meme1.png");
        long length = file.length();
        outToClient.writeLong(length);
        byte[] bytes = new byte[8192];
        InputStream in = new FileInputStream(file);
        OutputStream out = connectionSocket.getOutputStream();
                    
        int count;
        while((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        in.close();
    }
};