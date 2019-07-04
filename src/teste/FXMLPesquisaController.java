/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class FXMLPesquisaController implements Initializable {
    
    Catalogo mds;
    ArrayList<Produto> aux;
    int pgn = 1;
    int cont;
    
    @FXML
    private ImageView pngProduto1;
    @FXML
    private Label precoProduto1;
    @FXML
    private Label editoraProduto1;
    @FXML
    private Label autorProduto1;
    @FXML
    private Label nomeProduto1;
    @FXML
    private Button baddCP1;
    @FXML
    private Button baddCP2;
    @FXML
    private Button baddCP3;
    @FXML
    private Button baddCP4;
    @FXML
    private Button baddCP5;
    @FXML
    private Button baddCP6;
    @FXML
    private TextField barraDePesquisa;
    @FXML
    private Button bConfPesquisa;
    @FXML
    private ComboBox<Categorias> cbGenerop;
    private List<Categorias> categorias =  new ArrayList<>();
    private ObservableList<Categorias> obscat;
    @FXML
    private ImageView pngProduto2;
    @FXML
    private Label precoProduto2;
    @FXML
    private Label editoraProduto2;
    @FXML
    private Label autorProduto2;
    @FXML
    private Label nomeProduto2;
    @FXML
    private ImageView pngProduto3;
    @FXML
    private Label precoProduto3;
    @FXML
    private Label editoraProduto3;
    @FXML
    private Label autorProduto3;
    @FXML
    private Label nomeProduto3;
    @FXML
    private ImageView pngProduto4;
    @FXML
    private Label precoProduto4;
    @FXML
    private Label editoraProduto4;
    @FXML
    private Label autorProduto4;
    @FXML
    private Label nomeProduto4;
    @FXML
    private ImageView pngProduto5;
    @FXML
    private Label precoProduto5;
    @FXML
    private Label editoraProduto5;
    @FXML
    private Label autorProduto5;
    @FXML
    private Label nomeProduto5;
    @FXML
    private ImageView pngProduto6;
    @FXML
    private Label precoProduto6;
    @FXML
    private Label editoraProduto6;
    @FXML
    private Label autorProduto6;
    @FXML
    private Label nomeProduto6;
    
    @FXML
    protected void voltarParaMenu(ActionEvent event) {
        Teste.trocaTela("menu");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mds = new Catalogo();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLCatalogoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        baddCP1.setOpacity(0);
        baddCP2.setOpacity(0);
        baddCP3.setOpacity(0);
        baddCP4.setOpacity(0);
        baddCP5.setOpacity(0);
        baddCP6.setOpacity(0);
        
        inciarCategorias();
         
    } 

    @FXML
    protected void acaoPesquisarP(ActionEvent event) {
        pgn = 1;
        aux = new ArrayList<>(mds.Pesquisar(barraDePesquisa.getText()));
        cont = aux.size();
        int tam = aux.size();
        int i = 0;
        Produto auxp;
        String nomep, autorp, auxautorp[], prp;
        Image imgp;

        nomeProduto1.setText(null);
        pngProduto1.setImage(null);
        autorProduto1.setText(null);
        editoraProduto1.setText(null);
        precoProduto1.setText(null);
        baddCP1.setOpacity(0);
        
        nomeProduto2.setText(null);
        pngProduto2.setImage(null);
        autorProduto2.setText(null);
        editoraProduto2.setText(null);
        precoProduto2.setText(null);
        baddCP2.setOpacity(0);
        
        nomeProduto3.setText(null);
        pngProduto3.setImage(null);
        autorProduto3.setText(null);
        editoraProduto3.setText(null);
        precoProduto3.setText(null);
        baddCP3.setOpacity(0);
        
        nomeProduto4.setText(null);
        pngProduto4.setImage(null);
        autorProduto4.setText(null);
        editoraProduto4.setText(null);
        precoProduto4.setText(null);
        baddCP4.setOpacity(0);
        
        nomeProduto5.setText(null);
        pngProduto5.setImage(null);
        autorProduto5.setText(null);
        editoraProduto5.setText(null);
        precoProduto5.setText(null);
        baddCP5.setOpacity(0);
        
        nomeProduto6.setText(null);
        pngProduto6.setImage(null);
        autorProduto6.setText(null);
        editoraProduto6.setText(null);
        precoProduto6.setText(null);
        baddCP6.setOpacity(0);
        
        while(i != tam){
            if(i == 0){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto1.setText(nomep);
                
                pngProduto1.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto1.setText(autorp);
        
                editoraProduto1.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto1.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto1.setText("R$ " + prp);
                    baddCP1.setOpacity(100);
                }
                
            }else if(i == 1){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto2.setText(nomep); 
                
                pngProduto2.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto2.setText(autorp);
        
                editoraProduto2.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto2.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto2.setText("R$ " + prp);
                    baddCP2.setOpacity(100);
                }
                
            }else if(i == 2){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto3.setText(nomep); 
                
                pngProduto3.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto3.setText(autorp);
        
                editoraProduto3.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto3.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto3.setText("R$ " + prp);
                    baddCP3.setOpacity(100);
                }

            }else if(i == 3){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto4.setText(nomep); 
                
                pngProduto4.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto4.setText(autorp);
        
                editoraProduto4.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto4.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto4.setText("R$ " + prp);
                    baddCP4.setOpacity(100);
                }

            }else if(i == 4){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto5.setText(nomep); 
                
                pngProduto5.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto5.setText(autorp);
        
                editoraProduto5.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto5.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto5.setText("R$ " + prp);
                    baddCP5.setOpacity(100);
                }

            }else if(i == 5){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto6.setText(nomep); 
                
                pngProduto6.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto6.setText(autorp);
        
                editoraProduto6.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto6.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto6.setText("R$ " + prp);
                    baddCP6.setOpacity(100);
                }
            }
            i++;
        } 
    }

    @FXML
    protected void acaoFiltrarCategoria(ActionEvent event) {
        pgn = 1;
        Categorias fcat = cbGenerop.getSelectionModel().getSelectedItem();
        String fgenero = fcat.toString();
        int fgint = 0;
        switch (fgenero) {
            case "Ação":
                fgint = 1;
                break;
            case "Aventura":
                fgint = 2;
                break;
            case "Terror":
                fgint = 3;
                break;
            case "Suspense":
                fgint = 4;
                break;
            case "Infantil":
                fgint = 5;
                break;
            case "Romance":
                fgint = 6;
                break;
            case "Fantasia":
                fgint = 7;
                break;
            default:
                break;
        }
        
        aux = new ArrayList<>(mds.Filtrar(fgint));
        cont = aux.size();
        int tam = aux.size();
        int i = 0;
        Produto auxp;
        String nomep, autorp, auxautorp[], prp;
        Image imgp;

        nomeProduto1.setText(null);
        pngProduto1.setImage(null);
        autorProduto1.setText(null);
        editoraProduto1.setText(null);
        precoProduto1.setText(null);
        baddCP1.setOpacity(0);
        
        nomeProduto2.setText(null);
        pngProduto2.setImage(null);
        autorProduto2.setText(null);
        editoraProduto2.setText(null);
        precoProduto2.setText(null);
        baddCP2.setOpacity(0);
        
        nomeProduto3.setText(null);
        pngProduto3.setImage(null);
        autorProduto3.setText(null);
        editoraProduto3.setText(null);
        precoProduto3.setText(null);
        baddCP3.setOpacity(0);
        
        nomeProduto4.setText(null);
        pngProduto4.setImage(null);
        autorProduto4.setText(null);
        editoraProduto4.setText(null);
        precoProduto4.setText(null);
        baddCP4.setOpacity(0);
        
        nomeProduto5.setText(null);
        pngProduto5.setImage(null);
        autorProduto5.setText(null);
        editoraProduto5.setText(null);
        precoProduto5.setText(null);
        baddCP5.setOpacity(0);
        
        nomeProduto6.setText(null);
        pngProduto6.setImage(null);
        autorProduto6.setText(null);
        editoraProduto6.setText(null);
        precoProduto6.setText(null);
        baddCP6.setOpacity(0);
        
        while(i != tam){
            if(i == 0){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto1.setText(nomep);
                
                pngProduto1.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto1.setText(autorp);
        
                editoraProduto1.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto1.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto1.setText("R$ " + prp);
                    baddCP1.setOpacity(100);
                }
                
            }else if(i == 1){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto2.setText(nomep); 
                
                pngProduto2.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto2.setText(autorp);
        
                editoraProduto2.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto2.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto2.setText("R$ " + prp);
                    baddCP2.setOpacity(100);
                }
                
            }else if(i == 2){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto3.setText(nomep); 
                
                pngProduto3.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto3.setText(autorp);
        
                editoraProduto3.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto3.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto3.setText("R$ " + prp);
                    baddCP3.setOpacity(100);
                }

            }else if(i == 3){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto4.setText(nomep); 
                
                pngProduto4.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto4.setText(autorp);
        
                editoraProduto4.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto4.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto4.setText("R$ " + prp);
                    baddCP4.setOpacity(100);
                }

            }else if(i == 4){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto5.setText(nomep); 
                
                pngProduto5.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto5.setText(autorp);
        
                editoraProduto5.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto5.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto5.setText("R$ " + prp);
                    baddCP5.setOpacity(100);
                }

            }else if(i == 5){
                auxp = (Produto)aux.get(i);
                auxp.printProduto(auxp);
        
                nomep= new String();
                nomep = "";
                for (String nome : auxp.getNome()) {
                    nomep += nome;
                    nomep += " ";
                }
                nomeProduto6.setText(nomep); 
                
                pngProduto6.setImage(auxp.getImage());
        
                autorp = new String();
                autorp = "";
                auxautorp = new String[2];
                auxautorp = auxp.getAutor();
                autorp += auxautorp[0];
                autorp += ", ";
                autorp += auxautorp[1];
                autorProduto6.setText(autorp);
        
                editoraProduto6.setText(auxp.getEditora());
        
                if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto6.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto6.setText("R$ " + prp);
                    baddCP6.setOpacity(100);
                }
            }
            i++;
        } 
        
    }

    @FXML
    protected void avancarPagina(ActionEvent event) {  
        pgn++;
        if(pgn == 1){
            int tam = aux.size();
            int i = 0;
            Produto auxp;
            String nomep, autorp, auxautorp[], prp;
            Image imgp;

            nomeProduto1.setText(null);
            pngProduto1.setImage(null);
            autorProduto1.setText(null);
            editoraProduto1.setText(null);
            precoProduto1.setText(null);
            baddCP1.setOpacity(0);
        
            nomeProduto2.setText(null);
            pngProduto2.setImage(null);
            autorProduto2.setText(null);
            editoraProduto2.setText(null);
            precoProduto2.setText(null);
            baddCP2.setOpacity(0);
        
            nomeProduto3.setText(null);
            pngProduto3.setImage(null);
            autorProduto3.setText(null);
            editoraProduto3.setText(null);
            precoProduto3.setText(null);
            baddCP3.setOpacity(0);
        
            nomeProduto4.setText(null);
            pngProduto4.setImage(null);
            autorProduto4.setText(null);
            editoraProduto4.setText(null);
            precoProduto4.setText(null);
            baddCP4.setOpacity(0);
        
            nomeProduto5.setText(null);
            pngProduto5.setImage(null);
            autorProduto5.setText(null);
            editoraProduto5.setText(null);
            precoProduto5.setText(null);
            baddCP5.setOpacity(0);
        
            nomeProduto6.setText(null);
            pngProduto6.setImage(null);
            autorProduto6.setText(null);
            editoraProduto6.setText(null);
            precoProduto6.setText(null);
            baddCP6.setOpacity(0);
        
            while(i != tam){
                if(i == 0){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto1.setText(nomep);

                    pngProduto1.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto1.setText(autorp);

                    editoraProduto1.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 1){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto2.setText(nomep); 

                    pngProduto2.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto2.setText(autorp);

                    editoraProduto2.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                    precoProduto2.setText("ESGOTADO");
                }else{
                    prp = new String();
                    prp = String.format("%.2f", auxp.getPreco());
                    precoProduto2.setText("R$ " + prp);
                    baddCP2.setOpacity(100);
                }

                }else if(i == 2){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto3.setText(nomep); 

                    pngProduto3.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto3.setText(autorp);

                    editoraProduto3.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 3){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto4.setText(nomep); 

                    pngProduto4.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto4.setText(autorp);

                    editoraProduto4.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 4){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto5.setText(nomep); 

                    pngProduto5.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto5.setText(autorp);

                    editoraProduto5.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 5){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto6.setText(nomep); 

                    pngProduto6.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto6.setText(autorp);

                    editoraProduto6.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto6.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto6.setText("R$ " + prp);
                        baddCP6.setOpacity(100);
                    }
                }
                i++;
            } 
        }else if(pgn == 2 && cont >= 7){
            int tam = aux.size();
            int i = 6;
            Produto auxp;
            String nomep, autorp, auxautorp[], prp;
            Image imgp;

            nomeProduto1.setText(null);
            pngProduto1.setImage(null);
            autorProduto1.setText(null);
            editoraProduto1.setText(null);
            precoProduto1.setText(null);
            baddCP1.setOpacity(0);
        
            nomeProduto2.setText(null);
            pngProduto2.setImage(null);
            autorProduto2.setText(null);
            editoraProduto2.setText(null);
            precoProduto2.setText(null);
            baddCP2.setOpacity(0);
        
            nomeProduto3.setText(null);
            pngProduto3.setImage(null);
            autorProduto3.setText(null);
            editoraProduto3.setText(null);
            precoProduto3.setText(null);
            baddCP3.setOpacity(0);
        
            nomeProduto4.setText(null);
            pngProduto4.setImage(null);
            autorProduto4.setText(null);
            editoraProduto4.setText(null);
            precoProduto4.setText(null);
            baddCP4.setOpacity(0);
        
            nomeProduto5.setText(null);
            pngProduto5.setImage(null);
            autorProduto5.setText(null);
            editoraProduto5.setText(null);
            precoProduto5.setText(null);
            baddCP5.setOpacity(0);
        
            nomeProduto6.setText(null);
            pngProduto6.setImage(null);
            autorProduto6.setText(null);
            editoraProduto6.setText(null);
            precoProduto6.setText(null);
            baddCP6.setOpacity(0);
        
            while(i != tam){
                if(i == 6){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto1.setText(nomep);

                    pngProduto1.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto1.setText(autorp);

                    editoraProduto1.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 7){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto2.setText(nomep); 

                    pngProduto2.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto2.setText(autorp);

                    editoraProduto2.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 8){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto3.setText(nomep); 

                    pngProduto3.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto3.setText(autorp);

                    editoraProduto3.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 9){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto4.setText(nomep); 

                    pngProduto4.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto4.setText(autorp);

                    editoraProduto4.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 10){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto5.setText(nomep); 

                    pngProduto5.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto5.setText(autorp);

                    editoraProduto5.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 11){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto6.setText(nomep); 

                    pngProduto6.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto6.setText(autorp);

                    editoraProduto6.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto6.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto6.setText("R$ " + prp);
                        baddCP6.setOpacity(100);
                    }
                }
                i++;
            } 
        }else if(pgn == 3 && cont >= 13){
            int tam = aux.size();
            int i = 12;
            Produto auxp;
            String nomep, autorp, auxautorp[], prp;
            Image imgp;

            nomeProduto1.setText(null);
            pngProduto1.setImage(null);
            autorProduto1.setText(null);
            editoraProduto1.setText(null);
            precoProduto1.setText(null);
            baddCP1.setOpacity(0);
        
            nomeProduto2.setText(null);
            pngProduto2.setImage(null);
            autorProduto2.setText(null);
            editoraProduto2.setText(null);
            precoProduto2.setText(null);
            baddCP2.setOpacity(0);
        
            nomeProduto3.setText(null);
            pngProduto3.setImage(null);
            autorProduto3.setText(null);
            editoraProduto3.setText(null);
            precoProduto3.setText(null);
            baddCP3.setOpacity(0);
        
            nomeProduto4.setText(null);
            pngProduto4.setImage(null);
            autorProduto4.setText(null);
            editoraProduto4.setText(null);
            precoProduto4.setText(null);
            baddCP4.setOpacity(0);
        
            nomeProduto5.setText(null);
            pngProduto5.setImage(null);
            autorProduto5.setText(null);
            editoraProduto5.setText(null);
            precoProduto5.setText(null);
            baddCP5.setOpacity(0);
        
            nomeProduto6.setText(null);
            pngProduto6.setImage(null);
            autorProduto6.setText(null);
            editoraProduto6.setText(null);
            precoProduto6.setText(null);
            baddCP6.setOpacity(0);
        
            while(i != tam){
                if(i == 12){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto1.setText(nomep);

                    pngProduto1.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto1.setText(autorp);

                    editoraProduto1.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 13){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto2.setText(nomep); 

                    pngProduto2.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto2.setText(autorp);

                    editoraProduto2.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 14){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto3.setText(nomep); 

                    pngProduto3.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto3.setText(autorp);

                    editoraProduto3.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 15){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto4.setText(nomep); 

                    pngProduto4.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto4.setText(autorp);

                    editoraProduto4.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 16){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto5.setText(nomep); 

                    pngProduto5.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto5.setText(autorp);

                    editoraProduto5.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 17){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto6.setText(nomep); 

                    pngProduto6.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto6.setText(autorp);

                    editoraProduto6.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto6.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto6.setText("R$ " + prp);
                        baddCP6.setOpacity(100);
                    }
                }
                i++;
            } 
        }else if(pgn == 4 && cont >= 19){
            int tam = aux.size();
            int i = 18;
            Produto auxp;
            String nomep, autorp, auxautorp[], prp;
            Image imgp;

            nomeProduto1.setText(null);
            pngProduto1.setImage(null);
            autorProduto1.setText(null);
            editoraProduto1.setText(null);
            precoProduto1.setText(null);
            baddCP1.setOpacity(0);
        
            nomeProduto2.setText(null);
            pngProduto2.setImage(null);
            autorProduto2.setText(null);
            editoraProduto2.setText(null);
            precoProduto2.setText(null);
            baddCP2.setOpacity(0);
        
            nomeProduto3.setText(null);
            pngProduto3.setImage(null);
            autorProduto3.setText(null);
            editoraProduto3.setText(null);
            precoProduto3.setText(null);
            baddCP3.setOpacity(0);
        
            nomeProduto4.setText(null);
            pngProduto4.setImage(null);
            autorProduto4.setText(null);
            editoraProduto4.setText(null);
            precoProduto4.setText(null);
            baddCP4.setOpacity(0);
        
            nomeProduto5.setText(null);
            pngProduto5.setImage(null);
            autorProduto5.setText(null);
            editoraProduto5.setText(null);
            precoProduto5.setText(null);
            baddCP5.setOpacity(0);
        
            nomeProduto6.setText(null);
            pngProduto6.setImage(null);
            autorProduto6.setText(null);
            editoraProduto6.setText(null);
            precoProduto6.setText(null);
            baddCP6.setOpacity(0);
        
            while(i != tam){
                if(i == 18){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto1.setText(nomep);

                    pngProduto1.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto1.setText(autorp);

                    editoraProduto1.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 19){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto2.setText(nomep); 

                    pngProduto2.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto2.setText(autorp);

                    editoraProduto2.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 20){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto3.setText(nomep); 

                    pngProduto3.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto3.setText(autorp);

                    editoraProduto3.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 21){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto4.setText(nomep); 

                    pngProduto4.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto4.setText(autorp);

                    editoraProduto4.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 22){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto5.setText(nomep); 

                    pngProduto5.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto5.setText(autorp);

                    editoraProduto5.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 23){
                    auxp = (Produto)aux.get(i);
                    auxp.printProduto(auxp);

                    nomep= new String();
                    nomep = "";
                    for (String nome : auxp.getNome()) {
                        nomep += nome;
                        nomep += " ";
                    }
                    nomeProduto6.setText(nomep); 

                    pngProduto6.setImage(auxp.getImage());

                    autorp = new String();
                    autorp = "";
                    auxautorp = new String[2];
                    auxautorp = auxp.getAutor();
                    autorp += auxautorp[0];
                    autorp += ", ";
                    autorp += auxautorp[1];
                    autorProduto6.setText(autorp);

                    editoraProduto6.setText(auxp.getEditora());

                    if(FXMLCatalogoController.mds.get(i).getQuant() == 0){
                        precoProduto6.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto6.setText("R$ " + prp);
                        baddCP6.setOpacity(100);
                    }
                }
                i++;
            } 
        }else{
            pgn--;
        }
    }

    @FXML
    protected void voltarPagina(ActionEvent event) {
        pgn -= 2;
        
        if(pgn >=0){
            avancarPagina(event);
        }else{
            pgn += 2;
        }
        
    }
    
    private class Categorias{
        private String s;
        Categorias(String s){
            this.s = s; 
        }

        @Override
        public String toString() {
            return s;
        } 
    }
    
    private void inciarCategorias(){
        Categorias cgt = new Categorias("Nenhum");
        Categorias cgt1 = new Categorias("Ação");
        Categorias cgt2 = new Categorias("Aventura");
        Categorias cgt3 = new Categorias("Terror");
        Categorias cgt4 = new Categorias("Suspense");
        Categorias cgt5 = new Categorias("Infantil");
        Categorias cgt6 = new Categorias("Romance");
        Categorias cgt7 = new Categorias("Fantasia"); 
        
        categorias.add(cgt1);
        categorias.add(cgt2);
        categorias.add(cgt3);
        categorias.add(cgt4);
        categorias.add(cgt5);
        categorias.add(cgt6);
        categorias.add(cgt7);
        categorias.add(cgt);
        
        obscat = FXCollections.observableArrayList(categorias);
        
        cbGenerop.setItems(obscat);
    }
    
    @FXML
    protected void addCarrinhoP1(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(0).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(0).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(6).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(6).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(12).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(12).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(18).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(18).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }
    }

    @FXML
    protected void addCarrinhoP2(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(1).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(1).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(7).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(7).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(13).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(13).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(19).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(19).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }      
    }

    @FXML
    protected void addCarrinhoP3(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(2).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(2).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(8).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(8).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(14).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(14).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(20).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(20).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }
    }

    @FXML
    protected void addCarrinhoP4(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(3).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(3).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(9).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(9).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(15).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(15).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(21).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(21).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }
    }

    @FXML
    protected void addCarrinhoP5(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(4).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(4).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(10).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(10).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(16).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(16).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(22).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(22).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }
    }

    @FXML
    protected void addCarrinhoP6(ActionEvent event) {
        if(pgn == 1){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(5).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(5).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 2){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(11).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(11).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 3){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(17).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(17).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }else if(pgn == 4){
            if(baddCP1.getOpacity() != 0){
                System.out.println("Clicou");
                if(FXMLCatalogoController.mds.pegarID(aux.get(23).getId()).getQuant() > 0){
                    Teste.addCarrinho(aux.get(23).getId());
                }else{
                    System.out.println("NAO ADD NA CESTA");
                }
            }else{
                System.out.println("Clicou");
            }
        }
    }
    
}
