package tribal;

public class Entrega {
    
    //private CestaCompras pedido;
    private String nomeCliente;
    private double valor;
    private int casa,senha;
    private String rua,bairro,cidade,estado;
    
    public Entrega(String nomeCliente,String rua,int casa,String bairro,String cidade,String estado,int senha){
       // this.pedido = pedido;
        this.nomeCliente = nomeCliente;
        this.valor= 0.0;
        this.rua = rua;
        this.casa = casa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.senha = senha;
    }

 
    
    /*protected void show(){
        pedido.printCesta();
    }*/
    
    protected int getSenha(){
        return senha;
    }
    
    protected String getNome(){
        return nomeCliente;
    }
    
    @Override
    public String toString(){
        return "\nOs produtos do carrinho serão entregues para " + nomeCliente + " no endereço: \nRua " + rua +", casa "+ casa +
                ", bairro "+ bairro + ", em "+ cidade + " - "+ estado + "\nValor total: R$"+ valor;
    }
}