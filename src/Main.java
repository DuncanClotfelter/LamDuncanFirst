import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    private static final int PORT = 4444;
    private static final String DuncanIP = "";
    public static void main(String[] args) throws IOException {

    }

    /**
     * Opens a new Server socket to allow Client connections
     * @param port to open
     * @throws IOException
     */
    private static Socket host(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        return server.accept();
    }

    /**
     * Connects to a Server socket
     * @param IP
     * @param port
     * @throws IOException
     * @return The Socket connection established
     */
    private static Socket connect(String IP, int port) throws IOException {
        return new Socket(IP, port);
    }

    private static void sendMessage(String message) throws IOException {
        byte[] byteArray = message.getBytes();
        OutputStream ops = connect(DuncanIP, PORT).getOutputStream();
        ops.write(byteArray);
        ops.flush();
        ops.close();
    }
}
