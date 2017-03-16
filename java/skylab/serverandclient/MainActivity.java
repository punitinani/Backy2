package skylab.serverandclient;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    EditText ip, port;

    String IP;
    int PORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.button2);
        ip = (EditText) findViewById(R.id.editText);
        port = (EditText) findViewById(R.id.editText2);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Dreamservice.class);
                startService(i);
                //start.setEnabled(true);
                // stop.setEnabled(false);

                //IP = ip.getText().toString();

                //PORT = Integer.parseInt(port.getText().toString());

                //  new innerClass().execute();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                start.setEnabled(false);
//                stop.setEnabled(true);
//
//
//                ServerSocket serverSocket;
//                try {
//                    serverSocket = new ServerSocket(PORT);
//                    Socket client = serverSocket.accept();
//
//                    ObjectInputStream dis = new ObjectInputStream(client.getInputStream());
//                    ObjectOutputStream dos = new ObjectOutputStream(client.getOutputStream());
//
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }


            }
        });


    }


    class innerClass extends AsyncTask {


        @Override
        protected Object doInBackground(Object[] params) {

            ServerSocket serverSocket;
            try {
                serverSocket = new ServerSocket(PORT);
                Socket client = serverSocket.accept();


                ObjectInputStream dis = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream dos = new ObjectOutputStream(client.getOutputStream());


                dos.writeUTF("Hello");
                dos.flush();


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}
