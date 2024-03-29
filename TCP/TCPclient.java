import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class TCPclient {
    public static void main(String[] args) throws Exception {
        String command;
        String modififedcommand;
		String hello;
		ArrayList<Long> roundTripTimes = new ArrayList<>();
		ArrayList<Long> setupTime = new ArrayList<>();
		// Establish port
		// MEASUREMENT PROBE
		Long start = System.currentTimeMillis();
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
		// MEASUREMENT PROBE
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		setupTime.add(elapsed);

		List randoms = generateRandomList();
		int i = 0;
		System.out.println("Connected");
		hello = inFromServer.readLine();
		System.out.println(hello);
		while(i < randoms.size()) {
			command = "";
			if(randoms.get(i).equals(1)) {
                command = "Meme 1";
            }
            if(randoms.get(i).equals(2)) {
                command = "Meme 2";
            }
            if(randoms.get(i).equals(3)) {
                command = "Meme 3";
            }
            if(randoms.get(i).equals(4)) {
                command = "Meme 4";
            }
            if(randoms.get(i).equals(5)) {
                command = "Meme 5";
            }
            if(randoms.get(i).equals(6)) {
                command = "Meme 6";
            }
            if(randoms.get(i).equals(7)) {
                command = "Meme 7";
            }
            if(randoms.get(i).equals(8)) {
                command = "Meme 8";
            }
            if(randoms.get(i).equals(9)) {
                command = "Meme 9";
            }
            if(randoms.get(i).equals(10)) {
                command = "Meme 10";
            }
			// command = inFromUser.readLine();

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
				writeMeme("meme1.png", clientSocket, roundTripTimes);
			}
			else if("meme2.png".equals(modififedcommand)) {
				writeMeme("meme2.png", clientSocket, roundTripTimes);
			}
			else if("meme3.png".equals(modififedcommand)) {
				writeMeme("meme3.png", clientSocket, roundTripTimes);
			}
			else if("meme4.png".equals(modififedcommand)) {
				writeMeme("meme4.png", clientSocket, roundTripTimes);
			}
			else if("meme5.png".equals(modififedcommand)) {
				writeMeme("meme5.png", clientSocket, roundTripTimes);
			}
			else if("meme6.png".equals(modififedcommand)) {
				writeMeme("meme6.png", clientSocket, roundTripTimes);
			}
			else if("meme7.png".equals(modififedcommand)) {
				writeMeme("meme7.png", clientSocket, roundTripTimes);
			}
			else if("meme8.png".equals(modififedcommand)) {
				writeMeme("meme8.png", clientSocket, roundTripTimes);
			}
			else if("meme9.png".equals(modififedcommand)) {
				writeMeme("meme9.png", clientSocket, roundTripTimes);
			}
			else if("meme10.png".equals(modififedcommand)) {
				writeMeme("meme10.png", clientSocket, roundTripTimes);
			}
			else {
				System.out.println(modififedcommand);
			}
			i += 1;
		}
		double minD = Collections.min(setupTime);
		double meanD = 0;
		for(int j = 0; j < setupTime.size(); j++) {
			meanD += setupTime.get(j);
		}
		meanD = meanD / setupTime.size();
		double stddevD = 0;
		double maxD = Collections.max(setupTime);
		for(int j = 0; j < setupTime.size(); j++) {
			stddevD += Math.pow(setupTime.get(j) - meanD, 2);
		}
		stddevD = Math.sqrt(stddevD / setupTime.size());


		System.out.println(" ");
		System.out.println("DNS look up time statistics");
		System.out.println("Min: " + minD);
		System.out.println("Mean: " + meanD);
		System.out.println("Max: " + maxD);
		System.out.println("Stddev: " + stddevD);
		command = "bye";
		outToServer.writeBytes(command + "\n");

    }
	static void writeMeme(String meme, Socket clientSocket, ArrayList<Long> roundTripTimes) throws Exception{
		// MEASUREMENT PROBE
		long start = System.currentTimeMillis();
		System.out.println("Receiving " + meme);
			// New part: Receive the file size from the server
			DataInputStream dataInFromServer = new DataInputStream(clientSocket.getInputStream());
			long fileSize = dataInFromServer.readLong(); // Read the file size first
			long bytesReceived = 0;
				
			// Prepare to receive the file
			FileOutputStream fileOut = new FileOutputStream(meme);
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
		// MEASUREMENT PROBE
		long end = System.currentTimeMillis();
		long elapsed = end - start;
		roundTripTimes.add(elapsed);
	}
	public static List<Integer> generateRandomList() {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers, new Random());
		return numbers;
	}
}