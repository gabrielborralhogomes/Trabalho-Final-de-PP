package teste;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Cliente
 */
public class FXMLCatalogoController implements Initializable {
    
    static Catalogo mds;
    int pgn = 1;

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
    private Button ant;
    @FXML
    private Button prox;
    @FXML
    private Label pag;
    
    @FXML
    protected void voltarParaMenu(ActionEvent event) {
        System.out.println("You clicked me!");
        Teste.trocaTela("menu");
    }
    
    @FXML
    protected void avancarPagina(ActionEvent event) {
        ArrayList<Produto> aux;
        pgn++;
        if(pgn == 1){
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
        
            while(i != 6){
                if(i == 0){
                    auxp = mds.get(i);
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
                    
                    if(mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }
                }else if(i == 1){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 2){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 3){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 4){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 5){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
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
        }else if(pgn == 2){
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
        
            while(i != 12){
                if(i == 6){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 7){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 8){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 9){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 10){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 11){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
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
        }else if(pgn == 3){
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
        
            while(i != 18){
                if(i == 12){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 13){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 14){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 15){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 16){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 17){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
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
        }else if(pgn == 4){
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
        
            while(i != 24){
                if(i == 18){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto1.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto1.setText("R$ " + prp);
                        baddCP1.setOpacity(100);
                    }

                }else if(i == 19){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto2.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto2.setText("R$ " + prp);
                        baddCP2.setOpacity(100);
                    }

                }else if(i == 20){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto3.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto3.setText("R$ " + prp);
                        baddCP3.setOpacity(100);
                    }
                }else if(i == 21){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto4.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto4.setText("R$ " + prp);
                        baddCP4.setOpacity(100);
                    }
                }else if(i == 22){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
                        precoProduto5.setText("ESGOTADO");
                    }else{
                        prp = new String();
                        prp = String.format("%.2f", auxp.getPreco());
                        precoProduto5.setText("R$ " + prp);
                        baddCP5.setOpacity(100);
                    }
                }else if(i == 23){
                    auxp = (Produto)mds.get(i);
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

                    if(mds.get(i).getQuant() == 0){
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

   @FXML
    protected void addCarrinhoP1(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(0).getQuant() > 0){
                Teste.addCarrinho(mds.get(0).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(6).getQuant() > 0){
                Teste.addCarrinho(mds.get(6).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(12).getQuant() > 0){
                Teste.addCarrinho(mds.get(12).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(18).getQuant() > 0){
                Teste.addCarrinho(mds.get(18).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }
    }

    @FXML
    protected void addCarrinhoP2(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(1).getQuant() > 0){
                Teste.addCarrinho(mds.get(1).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(7).getQuant() > 0){
                Teste.addCarrinho(mds.get(7).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(13).getQuant() > 0){
                Teste.addCarrinho(mds.get(13).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(19).getQuant() > 0){
                Teste.addCarrinho(mds.get(19).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }      
    }

    @FXML
    protected void addCarrinhoP3(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(2).getQuant() > 0){
                Teste.addCarrinho(mds.get(2).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(8).getQuant() > 0){
                Teste.addCarrinho(mds.get(8).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(14).getQuant() > 0){
                Teste.addCarrinho(mds.get(14).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(20).getQuant() > 0){
                Teste.addCarrinho(mds.get(20).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }
    }

    @FXML
    protected void addCarrinhoP4(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(3).getQuant() > 0){
                Teste.addCarrinho(mds.get(3).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(9).getQuant() > 0){
                Teste.addCarrinho(mds.get(9).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(15).getQuant() > 0){
                Teste.addCarrinho(mds.get(15).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(21).getQuant() > 0){
                Teste.addCarrinho(mds.get(21).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           };
        }
    }

    @FXML
    protected void addCarrinhoP5(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(4).getQuant() > 0){
                Teste.addCarrinho(mds.get(4).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(10).getQuant() > 0){
                Teste.addCarrinho(mds.get(10).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(16).getQuant() > 0){
                Teste.addCarrinho(mds.get(16).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(22).getQuant() > 0){
                Teste.addCarrinho(mds.get(22).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }
    }

    @FXML
    protected void addCarrinhoP6(ActionEvent event) {
        if(pgn == 1){
            System.out.println("Clicou");
            if(mds.get(5).getQuant() > 0){
                Teste.addCarrinho(mds.get(5).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 2){
            System.out.println("Clicou");
            if(mds.get(11).getQuant() > 0){
                Teste.addCarrinho(mds.get(11).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 3){
            System.out.println("Clicou");
            if(mds.get(17).getQuant() > 0){
                Teste.addCarrinho(mds.get(17).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }else if(pgn == 4){
            System.out.println("Clicou");
            if(mds.get(23).getQuant() > 0){
                Teste.addCarrinho(mds.get(23).getId());
            }else{
                System.out.println("NAO ADD NA CESTA");
           }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mds = new Catalogo();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLCatalogoController.class.getName()).log(Level.SEVERE, null, ex);
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 1 //
        Produto p1 = mds.ctlg.get(0);
        
        p1.printProduto(p1);
        
        String nomeP1 = "";
        for (String nome : p1.getNome()) {
            nomeP1 += nome;
            nomeP1 += " ";
        }
        nomeProduto1.setText(nomeP1);
        
        pngProduto1.setImage(p1.getImage());
        
        String autorP1 = "";
        String auxautor1[] = p1.getAutor();
        autorP1 += auxautor1[0];
        autorP1 += ", ";
        autorP1 += auxautor1[1];
        autorProduto1.setText(autorP1);
        
        editoraProduto1.setText(p1.getEditora());
        
        String pr1 = String.format("%.2f", p1.getPreco());
        precoProduto1.setText("R$ " +pr1);
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 2 //
        Produto p2 = mds.ctlg.get(1);
        
        p2.printProduto(p2);
        
        String nomeP2 = "";
        
        for (String nome : p2.getNome()) {
            nomeP2 += nome;
            nomeP2 += " ";
        }
        nomeProduto2.setText(nomeP2);
        
        pngProduto2.setImage(p2.getImage());
        
        String autorP2 = "";
        String auxautor2[] = p2.getAutor();
        autorP2 += auxautor2[0];
        autorP2 += ", ";
        autorP2 += auxautor2[1];
        autorProduto2.setText(autorP2);
        
        editoraProduto2.setText(p2.getEditora());
        
        String pr2 = String.format("%.2f", p2.getPreco());
        precoProduto2.setText("R$ " +pr2);
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 3 //
        Produto p3 = mds.ctlg.get(2);
        
        p3.printProduto(p3);
        
        String nomeP3 = "";
        
        for (String nome : p3.getNome()) {
            nomeP3 += nome;
            nomeP3 += " ";
        }
        nomeProduto3.setText(nomeP3);
        
        pngProduto3.setImage(p3.getImage());
        
        String autorP3 = "";
        String auxautor3[] = p3.getAutor();
        autorP3 += auxautor3[0];
        autorP3 += ", ";
        autorP3 += auxautor3[1];
        autorProduto3.setText(autorP3);
        
        editoraProduto3.setText(p3.getEditora());
        
        String pr3 = String.format("%.2f", p3.getPreco());
        precoProduto3.setText("R$ " +pr3);
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 4 //
        Produto p4 = mds.ctlg.get(3);
        
        p4.printProduto(p4);
        
        String nomeP4 = "";
        
        for (String nome : p4.getNome()) {
            nomeP4 += nome;
            nomeP4 += " ";
        }
        nomeProduto4.setText(nomeP4);

        pngProduto4.setImage(p4.getImage());
        
        String autorP4 = "";
        String auxautor4[] = p4.getAutor();
        autorP4 += auxautor4[0];
        autorP4 += ", ";
        autorP4 += auxautor4[1];
        autorProduto4.setText(autorP4);
        
        editoraProduto4.setText(p4.getEditora());
        
        String pr4 = String.format("%.2f", p4.getPreco());
        precoProduto4.setText("R$ " +pr4);
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 5 //
        Produto p5 = mds.ctlg.get(4);
        
        p5.printProduto(p5);
        
        String nomeP5 = "";
        
        for (String nome : p5.getNome()) {
            nomeP5 += nome;
            nomeP5 += " ";
        }
        nomeProduto5.setText(nomeP5);
        
        pngProduto5.setImage(p5.getImage());
        
        String autorP5 = "";
        String auxautor5[] = p5.getAutor();
        autorP5 += auxautor5[0];
        autorP5 += ", ";
        autorP5 += auxautor5[1];
        autorProduto5.setText(autorP5);
        
        editoraProduto5.setText(p5.getEditora());
        
        String pr5 = String.format("%.2f", p5.getPreco());
        precoProduto5.setText("R$ " +pr5);
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // PRODUTO 6 //
        Produto p6 = mds.ctlg.get(5);
        
        p6.printProduto(p6);
        
        String nomeP6 = "";
        
        for (String nome : p6.getNome()) {
            nomeP6 += nome;
            nomeP6 += " ";
        }
        nomeProduto6.setText(nomeP6);
        
        pngProduto6.setImage(p6.getImage());
        
        String autorP6 = "";
        String auxautor6[] = p6.getAutor();
        autorP6 += auxautor6[0];
        autorP6 += ", ";
        autorP6 += auxautor6[1];   
        autorProduto6.setText(autorP6);
        
        editoraProduto6.setText(p6.getEditora());
        
        String pr6 = String.format("%.2f", p6.getPreco());
        precoProduto6.setText("R$ " +pr6); 
        
    } 
    
}
