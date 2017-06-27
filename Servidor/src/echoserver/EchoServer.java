/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echoserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SloooCk
 */
public class EchoServer {

    private Socket socket;

    private EchoServer(Socket socket) {
        this.socket = socket;
    }
    /**
     * @param args the command line arguments
     */
    private ArrayList<Socket> listaCliente = new ArrayList();

    public static void main(String[] args) throws IOException, InterruptedException {

        //TelaServidor k = new TelaServidor();
        int PORTA = 11111;
        int pontosCliente1 = 0;
        int pontosCliente2 = 0;
        ServerSocket socket = new ServerSocket(PORTA);
        String querJogar = "Sim";

        do {
            System.out.println("Socket criado");
            Socket cliente = socket.accept();
            InputStream in = cliente.getInputStream();
            DataInputStream d = new DataInputStream(in);
            OutputStream out = cliente.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("AGUARDE CONEXÃO DE OUTRO CLIENTE");

            Socket cliente2 = socket.accept();
            InputStream in2 = cliente2.getInputStream();
            DataInputStream d2 = new DataInputStream(in2);
            OutputStream out2 = cliente2.getOutputStream();
            DataOutputStream dos2 = new DataOutputStream(out2);
            String presClient1, presClient2;
            dos.writeUTF("CONECTADO");
            dos2.writeUTF("CONECTADO");

            presClient1 = d.readUTF();
            presClient2 = d2.readUTF();
            System.out.println(presClient1);
            System.out.println(presClient2);
            dos2.writeUTF(presClient1);
            dos.writeUTF(presClient2);

            while (true) {
                System.out.println("aguardando cliente ...");
                String a = d.readUTF();
                System.out.println("Escolha Cliente 1: " + a);

                String b = d2.readUTF();
                System.out.println("Escolha Cliente 2: " + b);

                String resposta = regras(a, b);
                if (resposta.equals("CLIENTE1"))
                {
                    dos.writeUTF("VENCEU");
                    dos2.writeUTF("PERDEU");
                    pontosCliente1++;
                }
                else if (resposta.equals("CLIENTE2"))
                {
                    pontosCliente2++;
                    dos.writeUTF("PERDEU");
                    dos2.writeUTF("VENCEU");
                }
                else if (resposta.equals("EMPATE"))
                {
                    dos.writeUTF("EMPATE");
                    dos2.writeUTF("EMPATE");
                }
                if (pontosCliente1 == 3 || pontosCliente2 == 3)
                {
                    break;
                }
            }
            String a = d.readUTF();
            String b = d2.readUTF();
            if(a.equals("Não")&&b.equals("Não"))
            {
                querJogar = "Não";
            }
            pontosCliente1 =0;
            pontosCliente2 =0;
        } while (querJogar.equals("Sim"));
        socket.close();
    }

    private static String regras(String cliente1, String cliente2) {
        String resposta = "";

        switch (cliente1) {
            case "PEDRA":
                switch (cliente2) {
                    case "PEDRA":
                        resposta = "EMPATE";
                        break;
                    case "PAPEL":
                        resposta = "CLIENTE2";
                        break;
                    case "TESOURA":
                        resposta = "CLIENTE1";
                        break;
                }
                break;
            case "PAPEL":
                switch (cliente2) {
                    case "PEDRA":
                        resposta = "CLIENTE1";
                        break;
                    case "PAPEL":
                        resposta = "EMPATE";
                        break;
                    case "TESOURA":
                        resposta = "CLIENTE2";
                        break;
                }
                break;
            case "TESOURA":
                switch (cliente2) {
                    case "PEDRA":
                        resposta = "CLIENTE2";
                        break;
                    case "PAPEL":
                        resposta = "CLIENTE1";
                        break;
                    case "TESOURA":
                        resposta = "EMPATE";
                        break;
                }
                break;
        }
        System.out.println(resposta);
        return resposta;
    }
}
