import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        ArrayList<Long> roundTripTimes = new ArrayList<>();
        ArrayList<Long> setupTime = new ArrayList<>();

        
        for(int i = 0; i < 10; i++) {
            // MEASUREMENT PROBE
            Long start = System.currentTimeMillis();
            InetAddress servAddress = InetAddress.getByName(args[0]);
            //InetAddress servAddress = InetAddress.getByName("localhost");

            // MEASUREMENT PROBE
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            setupTime.add(elapsed);
        }
        
        String command;
        
        int port = Integer.parseInt(args[1]);

        DatagramSocket newSocket = new DatagramSocket(port);
        int count = 10;
        while(count != 0) {
            byte[] number = new byte[512];
            DatagramPacket numberPacket = new DatagramPacket(number, number.length);
            newSocket.receive(numberPacket);
            String num = new String(numberPacket.getData(), 0, numberPacket.getLength());
            System.out.println("");
            readMeme(num, newSocket, roundTripTimes);
            count -= 1;
        }

        double minR = Collections.min(roundTripTimes);
        double meanR = 0;
        for(int i = 0; i < roundTripTimes.size(); i++) {
            meanR += roundTripTimes.get(i);
        }
        meanR = meanR / roundTripTimes.size();
        double stddevR = 0;
        double maxR = Collections.max(roundTripTimes);
        for(int i = 0; i < roundTripTimes.size(); i++) {
            stddevR += Math.pow(roundTripTimes.get(i) - meanR, 2);
        }
        stddevR = Math.sqrt(stddevR / roundTripTimes.size());
        System.out.println(" ");
        System.out.println("Round trip time statistics");
        System.out.println("Min: " + minR);
        System.out.println("Mean: " + meanR);
        System.out.println("Max: " + maxR);
        System.out.println("Stddev: " + stddevR);

        double minD = Collections.min(setupTime);
        double meanD = 0;
        for(int i = 0; i < setupTime.size(); i++) {
            meanD += setupTime.get(i);
        }
        meanD = meanD / setupTime.size();
        double stddevD = 0;
        double maxD = Collections.max(setupTime);
        for(int i = 0; i < setupTime.size(); i++) {
            stddevD += Math.pow(setupTime.get(i) - meanD, 2);
        }
        stddevD = Math.sqrt(stddevD / setupTime.size());
        
        System.out.println(" ");
        System.out.println("DNS look up time statistics");
        System.out.println("Min: " + minD);
        System.out.println("Mean: " + meanD);
        System.out.println("Max: " + maxD);
        System.out.println("Stddev: " + stddevD);


    }
    static void readMeme(String meme, DatagramSocket newSocket, ArrayList<Long> roundTripTimes) throws Exception{
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        // MEASUREMENT PROBE
        long start = System.currentTimeMillis();
        while(true) {
            byte[] receiveData = new byte[512];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            newSocket.receive(receivePacket);
            String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
            //System.out.println("TEMP: " + temp);
            if(temp.equals("END LOOP")) {
                break;
            }
            byteArrayStream.write(receivePacket.getData(), 0, receivePacket.getLength());
        }
        // MEASUREMENT PROBE
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        roundTripTimes.add(elapsed);
        // Prepare to receive the file
		FileOutputStream fileOut = new FileOutputStream("meme" + meme + ".png");
		//byte[] buffer = new byte[8192];
        fileOut.write(byteArrayStream.toByteArray());
        fileOut.close();
        System.out.println("Received meme " + meme);
    }
}
