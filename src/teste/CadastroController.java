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
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.scene.control.PasswordField;



/**
 *
 * @author luisn
 */
public class CadastroController implements Initializable {
    
    @FXML
    private TextField nomeFild;
    @FXML
    private TextField ruaFild;
    @FXML
    private TextField casaFild;
    @FXML
    private TextField bairroFild;
    @FXML
    private TextField cidadeFild;
    @FXML
    private TextField estadoFild;
    @FXML
    private Label msg;
    @FXML
    private PasswordField senhaFild;
    @FXML
    private Button finish;
    
    private int ja=0;
    
    
    @FXML
    protected void finalizar(ActionEvent event) throws IOException {
        if(ja==0){
            String nome ,senha,rua,casa,bairro,cidade,estado;
            FileWriter arq = new FileWriter("users.txt",true);
            PrintWriter gravarArq = new PrintWriter(arq);

            nome =nomeFild.getText();
            senha=senhaFild.getText();
            rua=ruaFild.getText();
            casa=casaFild.getText();
            bairro=bairroFild.getText();
            cidade=cidadeFild.getText();
            estado=estadoFild.getText();
            System.out.println(nome);
            if( !"".equals(nomeFild.getText()) && !"".equals(senhaFild.getText()) && 
                !"".equals(ruaFild.getText()) && !"".equals(casaFild.getText()) && 
                !"".equals(bairroFild.getText()) && !"".equals(cidadeFild.getText()) && 
                !"".equals(estadoFild.getText()) ){
                
                    gravarArq.println(nome+";"+senha+";"+rua+";"+casa+";"+bairro+";"+cidade+";"+estado);
                    gravarArq.close();
                    msg.setText("Cadastro concluído com sucesso.");
                    System.out.println("cadastrado.");
                    ja=1;
            }else{
                msg.setText("por favor preencha todos os campos");
                System.out.println("falta coisa");
            }
        }else{
            msg.setText("Já cadastrado");
            System.out.println("Ja cadastrado");
        }
    } 
    
    @FXML
    protected void voltar(ActionEvent event) {
        Teste.trocaTela("menu");
        nomeFild.setText("");
        senhaFild.setText("");
        ruaFild.setText("");
        casaFild.setText("");
        bairroFild.setText("");
        cidadeFild.setText("");
        estadoFild.setText("");
        msg.setText("");
        ja=0;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    //
    }    

   
    
}
