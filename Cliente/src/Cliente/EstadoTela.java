/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

/**
 *
 * @author SlooCk
 */
public enum EstadoTela {
    PERMITIDO(1,"PERMITIDO"),NÃO_PERMITIDO(2,"NÃO_PERMITIDO");
    int valor;
    String resposta;

    private EstadoTela(int valor, String resposta) {
        this.resposta= resposta;
        this.valor = valor;
                
    }
    public String getResposta()
    {
        return resposta;
    }
    public int getValor()
    {
        return valor;
    }
    
}
