package teste;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author Hannah
 */
public class FXMLCestaController implements Initializable { 
    
    static CestaCompras cesta = new CestaCompras();
    int pgn = 1, numb_pgn; 
    
    @FXML
    private ImageView ItemCesta1;
    @FXML
    private ImageView ItemCesta2;
    @FXML
    private ImageView ItemCesta3;
    @FXML
    private Label nome1;
    @FXML
    private Label autor1;
    @FXML
    private Label nome2;
    @FXML
    private Label autor2;
    @FXML
    private Label nome3;
    @FXML
    private Label autor3;
    @FXML
    private Label preco1;
    @FXML
    private Label preco2;
    @FXML
    private Label preco3;
    @FXML
    private TextField qtd1;
    @FXML
    private TextField qtd2;
    @FXML
    private TextField qtd3;
    @FXML
    private Button ant;
    @FXML
    private Button prox;
    @FXML
    private Label pag;
    @FXML
    private Label editora1;
    @FXML
    private Label editora2;
    @FXML
    private Label editora3;
    @FXML
    private Label totalPreco;
    @FXML
    private Button ok1;
    @FXML
    private Button ok2;
    @FXML
    private Button ok3;
    @FXML
    private Button remove1;
    @FXML
    private Button remove2;
    @FXML
    private Button remove3;

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        // CU--
        qtd1.setOpacity(0);
        ok1.setOpacity(0);
        remove1.setOpacity(0);
        
        qtd2.setOpacity(0);
        ok2.setOpacity(0);
        remove2.setOpacity(0);
        
        qtd3.setOpacity(0);
        ok3.setOpacity(0);
        remove3.setOpacity(0);
    }   

    @FXML
    protected void aoMenuC(ActionEvent event) {
        System.out.println("You clicked me!");
        Teste.trocaTela("menu");
    }

    @FXML
    protected void pagAnt(ActionEvent event) {
        System.out.println("Pagina: "+ pgn + ", Tamanho: " + cesta.size());
        if(pgn != 1){
            pgn--;
            mostraItens(event);
        }
    }

    @FXML
    protected void pagProx(ActionEvent event) {
        System.out.println("Pagina: "+ pgn + ", Tamanho: " +cesta.size());
        if(pgn != 8 && pgn < numb_pgn){
            pgn++;
            mostraItens(event);
        }
    }
    
    @FXML
    protected void realizarCompra(ActionEvent event) {
        mostraItens(event);
        for(int i=0; i<cesta.size(); i++){
            FXMLCatalogoController.mds.retirarEstoque(cesta.get(i).getId(), cesta.get(i).getQtdPedida());
        }
        Teste.valorTotalComprado = cesta.calcTotal();
        cesta = new CestaCompras();
        mostraItens(event);
        Teste.trocaTela("delivery");
    }
    
    protected void valorTotalDaCompra(){
        String pt;
        pt = new String();
        //pt = String.valueOf(cesta.calcTotal());
        pt = String.format("%.2f",cesta.calcTotal());
        totalPreco.setText("Total: R$ " + pt);
    }

    @FXML
    protected void mostraItens(ActionEvent event) {
        
        valorTotalDaCompra();
        
        if(cesta.size() < 4){
            numb_pgn = 1;
        }else if(cesta.size() < 7){
            numb_pgn = 2;
        }else if(cesta.size() < 10){
            numb_pgn = 3;
        }else if(cesta.size() < 13){
            numb_pgn = 4;
        }else if(cesta.size() < 16){
            numb_pgn = 5;
        }else if(cesta.size() < 19){
            numb_pgn = 6;
        }else if(cesta.size() < 22){
            numb_pgn = 7;
        }else{
            numb_pgn = 8;
        }
        
        ItemCesta1.setImage(null);
        nome1.setText(null);
        autor1.setText(null);
        editora1.setText(null);
        preco1.setText(null);
        qtd1.setOpacity(0);
        ok1.setOpacity(0);
        remove1.setOpacity(0);
        
        ItemCesta2.setImage(null);
        nome2.setText(null);
        autor2.setText(null);
        editora2.setText(null);
        preco2.setText(null);
        qtd2.setOpacity(0);
        ok2.setOpacity(0);
        remove2.setOpacity(0);
        
        ItemCesta3.setImage(null);
        nome3.setText(null);
        autor3.setText(null);
        editora3.setText(null);
        preco3.setText(null);
        qtd3.setOpacity(0);
        ok3.setOpacity(0);
        remove3.setOpacity(0);
        
        int i = 0;
        String nome,autor,preco, quant;
        if(pgn == 1){
            System.out.println(i);
            System.out.println(cesta.size());
            while(i != cesta.size()){
                if(i == 0){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    System.out.println(nome);
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 1){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 2){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 2){
            i = 3;
            while(i != cesta.size()){
                if(i == 3){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 4){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 5){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 3){
            i = 6;
            while(i != cesta.size()){
                if(i == 6){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 7){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 8){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 4){
            i = 9;
            while(i != cesta.size()){
                if(i == 9){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 10){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 11){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 5){
            i = 12;
            while(i != cesta.size()){
                if(i == 12){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 13){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 14){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 6){
            i = 15;
            while(i != cesta.size()){
                if(i == 15){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 16){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 17){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 7){
            i = 18;
            while(i != cesta.size()){
                if(i == 18){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 19){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 20){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }else if(pgn == 8){
            i = 21;
            while(i != cesta.size()){
                if(i == 21){
                    ItemCesta1.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome1.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor1.setText(autor);
                    
                    editora1.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco1.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd1.setText(quant);
                    qtd1.setOpacity(100);
                    ok1.setOpacity(100);
                    
                    remove1.setOpacity(100);
                }else if(i == 22){
                    ItemCesta2.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome2.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor2.setText(autor);
                    
                    editora2.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco2.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd2.setText(quant);
                    qtd2.setOpacity(100);
                    ok2.setOpacity(100);
                    
                    remove2.setOpacity(100);
                }else if(i == 23){
                    ItemCesta3.setImage(cesta.get(i).getImagem());
                
                    nome = new String();
                    nome = "";
                    for (String n : cesta.get(i).getNome()) {
                        nome += n;
                        nome += " ";
                    }
                    nome3.setText(nome);
                
                    autor = new String();
                    autor = "";
                    autor += cesta.get(i).getAutor()[0];
                    autor += ", ";
                    autor += cesta.get(i).getAutor()[1];
                    autor3.setText(autor);
                    
                    editora3.setText(cesta.get(i).getEditora());
                
                    preco = new String();
                    preco = String.valueOf(cesta.get(i).getPreco());
                    preco3.setText("R$ " + preco);
                    
                    quant = new String();
                    quant = String.valueOf(cesta.get(i).getQtdPedida());
                    qtd3.setText(quant);
                    qtd3.setOpacity(100);
                    ok3.setOpacity(100);
                    
                    remove3.setOpacity(100);
                }
                i++;
            }
        }
    }
    
   @FXML
    protected void mudarQunat1(ActionEvent event){      
        if(pgn == 1){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(0).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(0).setQtdPedida(Integer.parseInt(qtd1.getText()));
            }
        }else if(pgn == 2){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(3).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(3).setQtdPedida(Integer.parseInt(qtd1.getText()));
            }           
        }else if(pgn == 3){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(6).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(6).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }else if(pgn == 4){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(9).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(9).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }else if(pgn == 5){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(12).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(12).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }else if(pgn == 6){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(15).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(15).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }else if(pgn == 7){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(18).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(18).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }else if(pgn == 8){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(21).getId(), Integer.parseInt(qtd1.getText()))){
                cesta.get(21).setQtdPedida(Integer.parseInt(qtd1.getText()));
            } 
        }
        valorTotalDaCompra();
        mostraItens(event);
    }
    
    @FXML
    protected void mudarQunat2(ActionEvent event){
        if(pgn == 1){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(1).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(1).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 2){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(4).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(4).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 3){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(7).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(7).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 4){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(10).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(10).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 5){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(13).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(13).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 6){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(16).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(16).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 7){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(19).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(19).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }else if(pgn == 8){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(22).getId(), Integer.parseInt(qtd2.getText()))){
                cesta.get(22).setQtdPedida(Integer.parseInt(qtd2.getText()));
            }
        }
        valorTotalDaCompra();
        mostraItens(event);
    }
    
    @FXML
    protected void mudarQunat3(ActionEvent event){
        if(pgn == 1){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(2).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(2).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 2){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(5).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(5).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 3){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(8).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(8).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 4){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(11).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(11).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 5){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(14).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(14).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 6){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(17).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(17).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 7){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(20).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(20).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }else if(pgn == 8){
            if(FXMLCatalogoController.mds.verficarEstoque(cesta.get(23).getId(), Integer.parseInt(qtd3.getText()))){
                cesta.get(23).setQtdPedida(Integer.parseInt(qtd3.getText()));
            }
        }
        valorTotalDaCompra();
        mostraItens(event);
    }
    
     @FXML
    protected void removerItem1(ActionEvent event){
        if(pgn == 1){
            cesta.remover(cesta.get(0));
        }else if(pgn == 2){
            cesta.remover(cesta.get(3));
        }else if(pgn == 3){
            cesta.remover(cesta.get(6));
        }else if(pgn == 4){
            cesta.remover(cesta.get(9));
        }else if(pgn == 5){
            cesta.remover(cesta.get(12));
        }else if(pgn == 6){
            cesta.remover(cesta.get(15));
        }else if(pgn == 7){
            cesta.remover(cesta.get(18));
        }else if(pgn == 8){
            cesta.remover(cesta.get(21));
        }
        
        mostraItens(event);
    }
    
    @FXML
    protected void removerItem2(ActionEvent event){
        if(pgn == 1){
            cesta.remover(cesta.get(1));
        }else if(pgn == 2){
            cesta.remover(cesta.get(4));
        }else if(pgn == 3){
            cesta.remover(cesta.get(7));
        }else if(pgn == 4){
            cesta.remover(cesta.get(10));
        }else if(pgn == 5){
            cesta.remover(cesta.get(13));
        }else if(pgn == 6){
            cesta.remover(cesta.get(16));
        }else if(pgn == 7){
            cesta.remover(cesta.get(19));
        }else if(pgn == 8){
            cesta.remover(cesta.get(22));
        }
        
        mostraItens(event);
    }
    
    @FXML
    protected void removerItem3(ActionEvent event){
        if(pgn == 1){
            cesta.remover(cesta.get(2));
        }else if(pgn == 2){
            cesta.remover(cesta.get(5));
        }else if(pgn == 3){
            cesta.remover(cesta.get(8));
        }else if(pgn == 4){
            cesta.remover(cesta.get(11));
        }else if(pgn == 5){
            cesta.remover(cesta.get(14));
        }else if(pgn == 6){
            cesta.remover(cesta.get(17));
        }else if(pgn == 7){
            cesta.remover(cesta.get(20));
        }else if(pgn == 8){
            cesta.remover(cesta.get(23));
        }
        
        mostraItens(event);
    }
}