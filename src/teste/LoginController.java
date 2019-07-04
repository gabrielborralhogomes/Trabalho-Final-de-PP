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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import javafx.scene.control.PasswordField;


/**
 * FXML Controller class
 *
 * @author luisn
 */
public class LoginController implements Initializable {

    @FXML
    private TextField nameFild;
    @FXML
    private PasswordField senhaFild;
    @FXML
    private Label msg;
    
    private int ja=0;
   

    /**
     * Initializes the controller class.
     * @param event
     */
    
    
    @FXML
    protected void voltar(ActionEvent event) {
         Teste.trocaTela("menu");
         nameFild.setText("");
         senhaFild.setText("");
         msg.setText("");
         ja=0;
    }

    @FXML
    protected void Entrar(ActionEvent event) throws FileNotFoundException, IOException {
        if(ja==0){
            String senha = senhaFild.getText();
            String name = nameFild.getText();
            FileReader arq = new FileReader("users.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha =lerArq.readLine();
            while(linha!=null){
                String cnome = linha.split(";")[0];
                String csenha = linha.split(";")[1];
                if(name.equalsIgnoreCase(cnome) && senha.equalsIgnoreCase(csenha)){
                    msg.setText("Login realizado com sucesso.");
                    Teste.youIn(cnome,csenha);
                    System.out.println("loguei");
                    ja=1;
                    break;
                }else{
                  linha =lerArq.readLine();
                }

            }
            if(linha==null){
                msg.setText("Nome de usuário ou senha incorretos.");
                System.out.println("n loguei");
            }
        }else{
            msg.setText("Esta conta já está logada!");  
            System.out.println("Já logado");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
