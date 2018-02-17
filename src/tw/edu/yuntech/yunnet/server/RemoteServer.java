package tw.edu.yuntech.yunnet.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RemoteServer {

    private String address;
    private int port = 0;
    private Socket socket = null;
    private BufferedReader br = null;
    private BufferedWriter bw = null;

    public RemoteServer(String address, int port) {
        this.address = address;
        this.port = port;
        try {
            this.socket = new Socket(this.address, this.port);
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
        }
    }

    public void send(String msg) {
        try {
            bw.write(msg);
            bw.flush();
        } catch (Exception e) {
        }
    }

    public String recv() {
        try {
            return br.readLine();
        } catch (Exception e) {  }
        return null;
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {  }
    }
}
