/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciadores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author SloooCk
 */
public class GerenciadorCliente {
    //private static GerenciadorCliente gerenciadorCliente;
    private Socket clienteTeste;
    public GerenciadorCliente(){}
    
    public void conectaNoServidor() throws IOException
    {
        int porta = 11111;
        clienteTeste = new Socket("127.0.0.1", porta);
        System.out.println("Conectado com servidor");
    }
    
    public void comunica(String msg) throws IOException{
     
        OutputStream out = clienteTeste.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(msg);
        //ouveServidor();
    }
    public String ouveServidor() throws IOException
    {
        InputStream in = clienteTeste.getInputStream();
        DataInputStream d = new DataInputStream(in);
        String a = d.readUTF();
        System.out.println("Mensagen do servidor\n");
        System.out.println(a);
        return a;
    }
}
