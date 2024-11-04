package chatsockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable {

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.mensaje = mensaje;
        this.puerto = puerto;
    }

    @Override
    public void run() {
        final String HOST = "192.168.10.40";

        DataOutputStream out;
        

        try {
            Socket sc;
            sc = new Socket(HOST, puerto);
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF(mensaje);

            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
