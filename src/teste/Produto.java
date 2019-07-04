package teste;

import javafx.scene.image.Image;

public class Produto {
    
    private int id;
    private String nome[];
    private String autor[];
    private String genero[];
    private int quantidade;
    private String editora;
    private double preco;
    private Image imagem;
    
    public Produto(int id, String nome[], String autor[], String genero[], int quantidade, String editora, double preco, Image imagem){
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.quantidade = quantidade;
        this.editora = editora;
        this.preco = preco;
        this.imagem = imagem;
    }    
    
    //MÉTODOS GETTER
    protected int getId(){
        return id;
    }
    
    protected String[] getNome(){
        return nome;
    }
    
    protected String[] getAutor(){
        return autor;
    }
    
    protected String[] getGenero(){
        return genero;
    }
    
    protected int getQuant(){
        return quantidade;
    }
    
    protected String getEditora(){
        return editora;
    }
    
    protected double getPreco(){
        return preco;
    }
    
    protected Image getImage(){
        return imagem;
    }
    
    //MÉTODOS SETTER
    protected void setQuantidade(int n){
        quantidade -= n;
    }

    protected void setPreco(double preco) {
        this.preco = preco;
    }  
    
    
    // PRINTAR Produto
    protected void printProduto(Produto p){
        System.out.print("\nNome: ");
        for (String nome1 : p.nome) {
            System.out.print(nome1 + " ");
        }
        System.out.println("\nAutor: " + p.autor[0] + ", " + p.autor[1]);
        System.out.println("Genero: " + p.genero[0] + ", " + p.genero[1]);
        System.out.println("Quantidade:" + p.quantidade);
        System.out.println("Editora: " + p.editora);
        System.out.println("Preco: " + p.preco);
    }
}