package skylab.serverandclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by p_unit on 14-Mar-17.
 */
class ServerCreate {

    Runnable server;
    ObjectOutputStream write = null;
    ObjectInputStream read = null;

    public void create(String ip, final int port) throws IOException {

        server = new Runnable() {
            ServerSocket serverSocket = new ServerSocket(port);

            @Override
            public void run() {

                try {


                    Socket client = serverSocket.accept();


                    write = new ObjectOutputStream(client.getOutputStream());
                    read = new ObjectInputStream(client.getInputStream());
                    write.flush();
                    String a = read.readUTF();

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        };


    }


}
