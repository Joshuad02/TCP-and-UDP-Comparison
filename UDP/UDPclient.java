import java.net.*;
import java.io.*;

public class UDPclient {
    public static void main(String[] args) throws Exception {
        InetAddress servAddress = InetAddress.getByName("localhost");
        // InetAddress servAddress = InetAddress.getByName(args[0]);

        String command;
        
        int port = Integer.parseInt(args[0]);

        DatagramSocket newSocket = new DatagramSocket(port);
        int count = 10;
        while(count != 0) {
            byte[] number = new byte[512];
            DatagramPacket numberPacket = new DatagramPacket(number, number.length);
            newSocket.receive(numberPacket);
            String num = new String(numberPacket.getData(), 0, numberPacket.getLength());
            System.out.println("COUNT: " + count);
            readMeme(num, newSocket);
            count -= 1;
        }
        

        // TESTING NOW
        // byte[] endData = "END LOOP".getBytes();
        // DatagramPacket endPacket = new DatagramPacket(endData, endData.length, servAddress, port);
        // newSocket.send(endPacket);

       // BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        // while(true) {
            // command = inFromUser.readLine();
            // byte[] message = command.getBytes();
            // DatagramPacket endPacket = new DatagramPacket(message, message.length, servAddress, port);
            // newSocket.send(endPacket);
			// System.out.println("Sent to server: " + command);

        // }


        // Reading a file
        // ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
        // while(true) {
        //     byte[] receiveData = new byte[512];
        //     DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //     newSocket.receive(receivePacket);
        //     String temp = new String(receivePacket.getData(), 0, receivePacket.getLength());
        //     //System.out.println("TEMP: " + temp);
        //     if(temp.equals("END LOOP")) {
        //         break;
        //     }
        //     byteArrayStream.write(receivePacket.getData(), 0, receivePacket.getLength());
        // }
        // // Prepare to receive the file
		// FileOutputStream fileOut = new FileOutputStream("meme1.png");
		// //byte[] buffer = new byte[8192];
        // fileOut.write(byteArrayStream.toByteArray());
        // fileOut.close();
        // System.out.println("Received meme");


        //newSocket.close();
    }
    static void readMeme(String meme, DatagramSocket newSocket) throws Exception{
        ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
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
        // Prepare to receive the file
		FileOutputStream fileOut = new FileOutputStream("meme" + meme + ".png");
		//byte[] buffer = new byte[8192];
        fileOut.write(byteArrayStream.toByteArray());
        fileOut.close();
        System.out.println("Received meme " + meme);
    }
}
