import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class TCPserver {
    public static void main(String[] args) throws Exception {
        String command;
        String modififedSentence;
        ArrayList<Long> memeAccessTime = new ArrayList<>();

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
                    TimeUnit.SECONDS.sleep(1);
                    break;
                }
                else if("Meme 1".equals(command)) {
                    command = "meme1.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 2".equals(command)) {
                    command = "meme2.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 3".equals(command)) {
                    command = "meme3.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 4".equals(command)) {
                    command = "meme4.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 5".equals(command)) {
                    command = "meme5.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 6".equals(command)) {
                    command = "meme6.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 7".equals(command)) {
                    command = "meme7.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 8".equals(command)) {
                    command = "meme8.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 9".equals(command)) {
                    command = "meme9.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else if("Meme 10".equals(command)) {
                    command = "meme10.png";
                    writeMeme(command, outToClient, connectionSocket, memeAccessTime);
                }
                else {
                    // Desired modifications to sentence
                    modififedSentence = "\"" + command + "\"" + " is an invalid input, try again\n";
                    outToClient.writeBytes(modififedSentence);
                }

            }
            double min = Collections.min(memeAccessTime);
            double mean = 0;
            for(int i = 0; i < memeAccessTime.size(); i++) {
                mean += memeAccessTime.get(i);
            }
            mean = mean / memeAccessTime.size();
            double stddev = 0;
            double max = Collections.max(memeAccessTime);
            for(int i = 0; i < memeAccessTime.size(); i++) {
                stddev += Math.pow(memeAccessTime.get(i) - mean, 2);
            }
            stddev = Math.sqrt(stddev / memeAccessTime.size());

            System.out.println("Meme access time in server statistics");
            System.out.println("Min: " + min);
            System.out.println("Mean: " + mean);
            System.out.println("Max: " + max);
            System.out.println("Stddev: " + stddev);

            outToClient.close();
            inFromClient.close();
        }

    }
    public static void writeMeme(String command, DataOutputStream outToClient, Socket connectionSocket, ArrayList<Long> memeAccessTime) throws Exception{
        long start = System.currentTimeMillis();
        System.out.println("Client requested: " + command + ", returning meme");
        outToClient.writeBytes(command + "\n");
        TimeUnit.SECONDS.sleep(1);
    
        File file = new File("../memes/" + command);
        long length = file.length();
        outToClient.writeLong(length);
        byte[] bytes = new byte[8192];
        InputStream in = new FileInputStream(file);
        OutputStream out = connectionSocket.getOutputStream();
                    
        int count;
        while((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        memeAccessTime.add(elapsedTime);
        in.close();
    }
};