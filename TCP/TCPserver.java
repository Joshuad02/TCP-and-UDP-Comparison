import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
                else if("go".equals(command)){
                    command = "Go";
                    writeMemes(command, outToClient, connectionSocket);
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

    public static List<Integer> generateRandomList() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers, new Random());
        return numbers;
    }

    static void writeMemes(String command, DataOutputStream outToClient, Socket connectionSocket) throws Exception{
        System.out.println("Client requested: " + command + ", returning meme");
        List<Integer> numbers = generateRandomList();
        for (int i = 0; i < 10; i++) {
            System.out.println("Sending File");
            int curr = numbers.get(i);
            outToClient.writeBytes("meme" + curr + ".png\n");
            TimeUnit.SECONDS.sleep(1);

            File file = new File("../memes/meme" + curr + ".png");
            long length = file.length();
            outToClient.writeLong(length);
            byte[] bytes = new byte[8192];
            InputStream in = new FileInputStream(file);
            OutputStream out = connectionSocket.getOutputStream();

            int count;
            while((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }

        }

    }
};