/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author luisn
 */
public class DeliveryController implements Initializable {

    @FXML
    private Label deliveryFild;
    @FXML
    private Button pai;
    @FXML
    private Label concluir;
    @FXML
    private Button nao;
    @FXML
    private Rectangle ret;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    protected void voltar(ActionEvent event) {
        Teste.trocaTela("menu");
        deliveryFild.setText("");
        pai.setOpacity(100);
        concluir.setOpacity(100);      
        nao.setOpacity(100);
        ret.setOpacity(0);
    }

    @FXML
    protected void show(ActionEvent event) throws FileNotFoundException, IOException {
        if(pai.getOpacity()!=0){
            if(!"null".equals(Teste.getSenha()) && !"null".equals(Teste.getNome())){
                FileReader arq = new FileReader("users.txt");
                BufferedReader lerArq = new BufferedReader(arq);
                String linha =lerArq.readLine();
                String valor = String.format("%.2f", Teste.valorTotalComprado);
                while(linha!=null){
                    String nome = linha.split(";")[0];
                    String senha = linha.split(";")[1];
                    if(Teste.getNome().equalsIgnoreCase(nome) && Teste.getSenha().equalsIgnoreCase(senha)){
                       String rua,casa,bairro,cidade,estado;
                       rua = linha.split(";")[2];
                       casa = linha.split(";")[3];
                       bairro = linha.split(";")[4];
                       cidade = linha.split(";")[5];
                       estado = linha.split(";")[6];
                       ret.setOpacity(100);
                       deliveryFild.setText("Os produtos serão entregues para "+nome+" em:\nRua "+rua+" Casa "+casa+","+bairro+","+cidade+","+estado+".\nValor total: R$ "+valor );
                       pai.setOpacity(0);
                       concluir.setOpacity(0);
                       nao.setOpacity(0);
                        break;
                    }else{
                      linha =lerArq.readLine();
                    }

                }
            }else{
                System.out.println("foi n");
                deliveryFild.setText("Realize o login em uma conta para proceder.");
                System.out.println("erro");
                concluir.setOpacity(0);
                nao.setOpacity(0);
                pai.setOpacity(0);
                ret.setOpacity(100);
            }
        }else{
            System.out.println("jáfoi");
        }
    }
    
    
}

