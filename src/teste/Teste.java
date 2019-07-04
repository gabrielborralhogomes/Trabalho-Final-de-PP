/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 *
 * @author Cliente
 */
public class Teste extends Application {
    
    static double valorTotalComprado; // NHR Q CLICA EM "REALIZAR COMPRA" DENTRO DO CARRINHO ELE IRA RECEBER O VALOR TOTAL DA COMPRA
     /////////////////////
    private static boolean log = false;
    private static String nome="null",senha="null";
    /////////////////////
    
    private static Stage stage;
    
    private static Scene sMenu;
    private static Scene sCatalogo;
    private static Scene sPesquisa;
    private static Scene sCesta;
    private static Scene sCestaVazia;
    private static Scene sCadastro;
    private static Scene sLogin;
    private static Scene sDelivery;
  
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        Parent fxmlCatalogo = FXMLLoader.load(getClass().getResource("FXMLCatalogo.fxml"));
        Parent fxmlPesquisa = FXMLLoader.load(getClass().getResource("FXMLPesquisa.fxml"));
        Parent fxmlCesta = FXMLLoader.load(getClass().getResource("FXMLCesta.fxml"));
        Parent fxmlCestaVazia = FXMLLoader.load(getClass().getResource("FXMLCestaVazia.fxml"));
        Parent Cadastro = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Parent Delivery = FXMLLoader.load(getClass().getResource("Delivery.fxml"));
        
        sMenu = new Scene(fxmlMenu);
        sCatalogo = new Scene(fxmlCatalogo);
        sPesquisa = new Scene(fxmlPesquisa);
        sCesta = new Scene(fxmlCesta);
        sCestaVazia = new Scene(fxmlCestaVazia);
        sCadastro = new Scene(Cadastro);
        sLogin = new Scene(Login);
        sDelivery = new Scene(Delivery);
        
        primaryStage.setScene(sMenu);
        stage.setWidth(950);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setTitle("Tribal HQs");
        primaryStage.show();      
    }
    
    public static void trocaTela(String s){
        switch(s){
            case "menu":
                stage.setScene(sMenu);
                break;
            case "catalogo":
                stage.setScene(sCatalogo);
                break;
            case "pesquisa":
                stage.setScene(sPesquisa);
                break;
            case "cesta":
                stage.setScene(sCesta);
                break;
            case "cestaVazia":
                stage.setScene(sCestaVazia);
                break;
             case "cadastro":
                stage.setScene(sCadastro);
                break;
            case "login":
                stage.setScene(sLogin);
                break;
            case "delivery":
                stage.setScene(sDelivery);
                break;
                
        }
    }
    
    // RECEBE O ID DO PRODUTO
    public static void addCarrinho(int id){
        int bota = 0; // bota = 0 significa q ele nao esta dentro da cesta, caso contrario bota = 1
        id--;
        ItemCesta ic = new ItemCesta(FXMLCatalogoController.mds.get(id));
        for(int i=0; i<FXMLCestaController.cesta.size();i++){
            if(FXMLCestaController.cesta.get(i).getId() == ic.getId()){
                bota = 1;
            }
        }
        if(bota == 0){
            FXMLCestaController.cesta.add(ic);
            System.out.println("Adicionado: " +id);
        }
        
        System.out.println("TAMANHO DESSA POHA: " + FXMLCestaController.cesta.size());
    }
    
     ///////////////////////
    public static boolean getLog(){
        return log;
    }
    
    public static void setLog(boolean x){
        log=x;
    }
    //////atual user//////////////
    public static void setNome(String s){
        nome=s;
    }
    public static String getNome(){
        return nome;
    }
    
    public static void setSenha(String s){
        senha=s;
    }
    
    public static String getSenha(){
        return senha;
    }
    
    public static void youIn(String nome,String senha){
        setNome(nome);
        setSenha(senha);
    }
    //////////////////////////////

    public static void main(String[] args){
        launch(args);  
    } 
}
