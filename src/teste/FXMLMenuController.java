/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author Cliente
 */
public class FXMLMenuController implements Initializable {

    
    @FXML
    private Button bCatalogo;

    @FXML
    private Button bPesquisar;
    
    @FXML
    private Button bCesta;
    @FXML
    private Button bEntrega;
    @FXML
    private Button inOut;
    @FXML
    private Button reg;
    @FXML
    private ImageView prin;
    @FXML
    private ImageView gen1;
    @FXML
    private ImageView gen2;
    @FXML
    private ImageView gen3;
    @FXML
    private ImageView div;
    @FXML
    private ImageView ship;
    
    
    @FXML
    protected void botaoCatalogo(ActionEvent event) {
        System.out.println("You clicked me!");
        Teste.trocaTela("catalogo");
    }
    
    @FXML
    protected void botaoPesquisar(ActionEvent event) {
        System.out.println("You clicked me!");
        Teste.trocaTela("pesquisa");
    }
    
    @FXML
    protected void botaoCesta(ActionEvent event) {
        System.out.println("You clicked me!");
        if (FXMLCestaController.cesta.size() == 0){
            Teste.trocaTela("cestaVazia");
        }else{
            Teste.trocaTela("cesta"); 
        }
    }
    
    @FXML
    protected void botaoEntrega(ActionEvent event) {
        System.out.println("You clicked me!");
        Teste.trocaTela("delivery");
    }
    
      @FXML
    protected void login(ActionEvent event) {
        if(Teste.getLog()){
            System.out.println("deslogar");
            inOut.setText("Login");
            Teste.setLog(false);
            Teste.youIn("null","null");
            reg.setOpacity(100);
        }else{
            System.out.println("logar");
            inOut.setText("Out");
            Teste.setLog(true);
            Teste.trocaTela("login"); 
            reg.setOpacity(0);
        } 
    }
    
     @FXML
    protected void regist(ActionEvent event) {
        Teste.trocaTela("cadastro");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        prin.setImage(new Image ("imgs_menu/ComicBooks.jpg"));
        gen1.setImage(new Image ("produto6.jpg"));
        gen2.setImage(new Image ("produto11.jpg"));
        gen3.setImage(new Image ("produto9.jpg"));
        div.setImage(new Image ("imgs_menu/comics.jpg"));
        ship.setImage(new Image ("imgs_menu/shipping.png"));
    }    
    
}
