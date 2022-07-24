package io;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Tmind
 * @Date 2021/11/5
 */
public class TCPTest {

    /**
     * 客户端
     */
    @Test
    public void client() throws IOException {
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        try (Socket socket = new Socket(inet, 8899); OutputStream os = socket.getOutputStream()) {
            os.write("你好".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server() throws IOException {


        ServerSocket serverSocket = new ServerSocket(8899);
    }

}
