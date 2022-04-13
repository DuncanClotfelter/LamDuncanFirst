import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int PORT = 4444;

    public static void main(String[] args) {

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

    /**
     * Instantiates an InputStreamReader and BufferedReader in order to read a single String from the given Socket.
     * Horribly inefficient.
     * @param toRead Socket to read from
     * @return The String read from this Socket
     * @throws IOException uh oh stinky
     */
    private static String readString(Socket toRead) throws IOException {
        return new String(toRead.getInputStream().readAllBytes());
    }
}
