import java.io.*;
import java.net.*;


public class TCPclient {
    public static void main(String[] args) throws Exception {
        String command;
        String modififedcommand;
		String hello;
		// Establish port
		int port = Integer.parseInt(args[1]);

		// Create client socket and connect to server
		// On local machine: "192.168.1.106"
		Socket clientSocket = new Socket(args[0], port);
        
		// Create input stream
			
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			
		// Create output stream that is attached to the socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		// Create input stream attached to socket
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		System.out.println("Connected");
		hello = inFromServer.readLine();
		System.out.println(hello);
		while(true) {
			command = inFromUser.readLine();

			// Send line to server
			outToServer.writeBytes(command + "\n");
			System.out.println("Sent to server: " + command);
			// Read line from server
			modififedcommand = inFromServer.readLine();

			//System.out.println(modififedcommand);
			if("Disconnected".equals(modififedcommand)) {
				System.out.println("exit");
				clientSocket.close();
				break;
			}
			// This if needs to be fixed
			else if("meme1.png".equals(modififedcommand)) {
				writeMeme("meme1.png", clientSocket);
			}
			else if("meme2.png".equals(modififedcommand)) {
				writeMeme("meme2.png", clientSocket);
			}
			else if("meme3.png".equals(modififedcommand)) {
				writeMeme("meme3.png", clientSocket);
			}
			else if("meme4.png".equals(modififedcommand)) {
				writeMeme("meme4.png", clientSocket);
			}
			else if("meme5.png".equals(modififedcommand)) {
				writeMeme("meme5.png", clientSocket);
			}
			else if("meme6.png".equals(modififedcommand)) {
				writeMeme("meme6.png", clientSocket);
			}
			else if("meme7.png".equals(modififedcommand)) {
				writeMeme("meme7.png", clientSocket);
			}
			else if("meme8.png".equals(modififedcommand)) {
				writeMeme("meme8.png", clientSocket);
			}
			else if("meme9.png".equals(modififedcommand)) {
				writeMeme("meme9.png", clientSocket);
			}
			else if("meme10.png".equals(modififedcommand)) {
				writeMeme("meme10.png", clientSocket);
			}
			else {
				System.out.println(modififedcommand);
			}

		}



    }
	static void writeMeme(String meme, Socket clientSocket) throws Exception{
		System.out.println("Receiving meme 1");
			// New part: Receive the file size from the server
			DataInputStream dataInFromServer = new DataInputStream(clientSocket.getInputStream());
			long fileSize = dataInFromServer.readLong(); // Read the file size first
			long bytesReceived = 0;
				
			// Prepare to receive the file
			FileOutputStream fileOut = new FileOutputStream("meme1.png");
			byte[] buffer = new byte[8192];
				
			while(bytesReceived < fileSize) {
				int count = dataInFromServer.read(buffer);
				if (count > 0) {
					fileOut.write(buffer, 0, count);
					bytesReceived += count;
				} else {
					// End of file data stream
					break;
				}
			}
			System.out.println("Finished receiving file");
			fileOut.close();
	}
}