/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Gerenciadores.GerenciadorCliente;
import Telas.TelaInicial;
import java.io.IOException;

/**
 *
 * @author SloooCk
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        TelaInicial form = new TelaInicial();
        form.setLocationRelativeTo(form);
        form.setVisible(true);
    }
    
}
