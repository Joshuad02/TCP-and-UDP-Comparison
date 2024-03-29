import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UDPserver {
    public static void main(String[] args) throws Exception {
        DatagramPacket endPacket;
        ArrayList<Long> memeAccessTime = new ArrayList<>(); 


       // InetAddress servAddress = InetAddress.getByName("localhost");
        InetAddress servAddress = InetAddress.getByName(args[0]);
        
        int port = Integer.parseInt(args[1]);

        List randoms = generateRandomList();
        for(int i = 0; i < randoms.size(); i++) {
            if(randoms.get(i).equals(1)) {
                writeMeme("1", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(2)) {
                writeMeme("2", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(3)) {
                writeMeme("3", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(4)) {
                writeMeme("4", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(5)) {
                writeMeme("5", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(6)) {
                writeMeme("6", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(7)) {
                writeMeme("7", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(8)) {
                writeMeme("8", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(9)) {
                writeMeme("9", servAddress, port, memeAccessTime);
            }
            if(randoms.get(i).equals(10)) {
                writeMeme("10", servAddress, port, memeAccessTime);
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
    }
    public static void writeMeme(String memeNumber, InetAddress servAddress, int port, ArrayList<Long> memeAccessTime) throws Exception{
        // MEASUREMENT PROBE
        long start = System.currentTimeMillis();
        File file = new File("../memes/meme" + memeNumber + ".png");

        InputStream in = new FileInputStream(file);

        DatagramSocket newSocket = new DatagramSocket();

        byte[] number = memeNumber.getBytes();
        DatagramPacket endPacket = new DatagramPacket(number, number.length, servAddress, port);
        newSocket.send(endPacket);

        byte[] buffer = new byte[512];
        int bytesRead;
        while((bytesRead = in.read(buffer)) != -1) {
            DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
            newSocket.send(sendPacket);
        }
        // MEASUREMENT PROBE
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        memeAccessTime.add(elapsedTime);
        byte[] endData = "END LOOP".getBytes();
        endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
        newSocket.send(endPacket);
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
