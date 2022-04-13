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
     * @throws IOException System unable to open socket
     */
    private static Socket host(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        return server.accept();
    }

    /**
     * Connects to a Server socket
     * @param IP Internet Protocol Address
     * @param port Port Number
     * @throws IOException Host is unavailable/client unable to open socket
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

    /**
     * Reads all bytes from the given Socket's InputStream and returns the results in form of a new String object
     * @param toRead Socket to read from
     * @return The String read from this Socket
     * @throws IOException uh oh stinky
     */
    private static String readString(Socket toRead) throws IOException {
        return new String(toRead.getInputStream().readAllBytes());
    }
}
