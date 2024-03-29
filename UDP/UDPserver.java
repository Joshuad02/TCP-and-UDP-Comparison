import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UDPserver {
    public static void main(String[] args) throws Exception {
        DatagramPacket endPacket;


        InetAddress servAddress = InetAddress.getByName("localhost");
        // InetAddress servAddress = InetAddress.getByName(args[0]);

        int port = Integer.parseInt(args[0]);

        List randoms = generateRandomList();
        for(int i = 0; i < randoms.size(); i++) {
            if(randoms.get(i).equals(1)) {
                File file = new File("../memes/meme1.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();

                byte[] number = "1".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);
        
                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(2)) {
                File file = new File("../memes/meme2.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "2".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(3)) {
                File file = new File("../memes/meme3.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "3".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(4)) {
                File file = new File("../memes/meme4.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "4".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(5)) {
                File file = new File("../memes/meme5.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "5".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(6)) {
                File file = new File("../memes/meme6.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "6".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(7)) {
                File file = new File("../memes/meme7.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "7".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(8)) {
                File file = new File("../memes/meme8.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "8".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(9)) {
                File file = new File("../memes/meme9.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "9".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
            if(randoms.get(i).equals(10)) {
                File file = new File("../memes/meme10.png");

                InputStream in = new FileInputStream(file);
        
                DatagramSocket newSocket = new DatagramSocket();
                
                byte[] number = "10".getBytes();
                endPacket = new DatagramPacket(number, number.length, servAddress, port);
                newSocket.send(endPacket);

                // byte[] receiveData = new byte[8092];
                // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                // newSocket.receive(receivePacket);
                // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
                // System.out.println("TEMP: " + temp);
        
                byte[] buffer = new byte[512];
                int bytesRead;
                while((bytesRead = in.read(buffer)) != -1) {
                    DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
                    newSocket.send(sendPacket);
                }
                
                byte[] endData = "END LOOP".getBytes();
                endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
                newSocket.send(endPacket);
            }
        }
        // DatagramSocket newSocket = new DatagramSocket();
        // byte[] endProg = "-1".getBytes();
        // endPacket = new DatagramPacket(endProg, endProg.length, servAddress, port);
        // newSocket.send(endPacket);
        
        
        

        // File file = new File("../memes/meme1.png");

        // InputStream in = new FileInputStream(file);

        // DatagramSocket newSocket = new DatagramSocket();

        // byte[] receiveData = new byte[8092];
        // DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // newSocket.receive(receivePacket);
        // String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
        // System.out.println("TEMP: " + temp);

        // byte[] buffer = new byte[512];
        // int bytesRead;
        // while((bytesRead = in.read(buffer)) != -1) {
        //     DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, servAddress, port);
        //     newSocket.send(sendPacket);
        // }
        
        // byte[] endData = "END LOOP".getBytes();
        // endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
        // newSocket.send(endPacket);

        // newSocket.close();
        // in.close();
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
