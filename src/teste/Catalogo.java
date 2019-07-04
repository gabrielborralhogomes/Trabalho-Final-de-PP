package teste;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Catalogo {
    ArrayList<Produto> ctlg;
    
    public Catalogo() throws FileNotFoundException{
        ctlg = new ArrayList<Produto>();
        try {
            Produto p;
            String n[] = new String[20], aux[] = null, e = null;
            String a[] = new String[2];
            String g[] = new String[2];
            int numb = 0, quant = 0, pos = 0, auxi = 1;
            Image image = null;
            double pr = 0;
            FileReader ler = new FileReader("armazem.txt");
            BufferedReader reader = new BufferedReader(ler);  
            String linha;
            int state = 0;
            while( (linha = reader.readLine()) != null ){
                switch (state) {
                    case 0:
                        numb = Integer.parseInt(linha);
                        state = 1;
                        break;
                    case 1:
                        if(!"$".equals(linha)){
                            n[pos] = linha;
                            pos++;
                        }else{
                            aux = new String[pos];
                            for(int i=0; i<pos; i++){
                                aux[i] = n[i];
                            }
                            pos=0;
                            state=2;
                        }   
                        break;
                    case 2:
                        a[0] = linha;
                        state = 3;
                        break;
                    case 3:
                        a[1] = linha;
                        state = 4;
                        break;
                    case 4:
                        g[0] = linha;
                        state = 5;
                        break;
                    case 5:
                        g[1] = linha;
                        state = 6;
                        break;
                    case 6:
                        quant = Integer.parseInt(linha);
                        state = 7;
                        break;
                    case 7:
                        e = linha;
                        state = 8;
                        break;
                    case 8:
                        pr = Double.parseDouble(linha);
                        if(auxi == 1){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 2){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 3){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 4){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 5){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 6){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 7){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 8){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 9){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 10){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 11){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 12){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 13){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 14){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 15){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 16){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 17){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 18){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 19){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 20){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 21){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 22){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 23){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }else if(auxi == 24){
                            image = new Image("produto"+auxi+".jpg");
                            auxi++;
                        }
                        
                        p = new Produto(numb, aux, a, g, quant, e, pr,image);                       
                        ctlg.add(p);
                        aux = null;
                        e = null;
                        n = new String[20];
                        a = new String[2];
                        g = new String[2];
                        state = 0;
                        break;
                }
            }
            ler.close();
            System.out.println("SUCESSO AO LER O ARQUIVO");
        }catch(IOException f) {
            System.out.println("\n\nERRO AO LER O ARQUIVO\n");
        }    
        
    }

    
    // PESQUISAR POR NOME, EDITORA OU AUTOR DE UM HQ
    protected ArrayList Pesquisar(String s){
        int tam = 1;
        String saux[];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                tam++;
            }
        }
        int auxtam = 0;
        saux = new String[tam];
        
        for(int i=0; i<tam; i++){
            saux[i] = "";
        }
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                saux[auxtam] += s.charAt(i);          
            }else{
                auxtam++;
            }
        }
        
        ArrayList<Produto> pesquisa = new ArrayList();
        Produto aux, verifp;
        int verificar = 0;
        
        for(int j=0; j<tam; j++){
           for(int i=0; i< ctlg.size(); i++){
                aux = ctlg.get(i);
                if(aux.getEditora().equalsIgnoreCase(saux[j])){
                    for(int k=0; k<pesquisa.size();k++){
                        verifp = pesquisa.get(k);
                        if(aux.getId() == verifp.getId()){
                            verificar = 1;
                        }
                    }
                    if(verificar == 0){
                        pesquisa.add(aux);
                        verificar = 0;
                    }else{
                        verificar = 0;
                    }           
                }else if(aux.getAutor()[0].equalsIgnoreCase(saux[j]) || aux.getAutor()[1].equalsIgnoreCase(saux[j])){
                    for(int k=0; k<pesquisa.size();k++){
                        verifp = (Produto)pesquisa.get(k);
                        if(aux.getId() == verifp.getId()){
                            verificar = 1;
                        }
                    }
                    if(verificar == 0){
                        pesquisa.add(aux);
                        verificar = 0;
                    }else{
                        verificar = 0;
                    } 
                }else{
                    for (String nome : aux.getNome()) {
                        if (nome.equalsIgnoreCase(saux[j])) {
                            for(int k=0; k<pesquisa.size();k++){
                                verifp = (Produto)pesquisa.get(k);
                                if(aux.getId() == verifp.getId()){
                                    verificar = 1;
                                }
                            }
                            if(verificar == 0){
                                pesquisa.add(aux);
                                verificar = 0;
                            }else{
                                verificar = 0;
                            } 
                            break;
                        }
                    }
                }           
            } 
        }
        
        return pesquisa;
    }
    
    // FILTRAR O CATALOGO DA LOJA POR UM GENERO
    protected ArrayList Filtrar (int genero){
        ArrayList filtro = new ArrayList();
        Produto aux;
        switch(genero){            
            case 1: // AÇÃO
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Acao".equals(aux.getGenero()[0]) || "Acao".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 2: // AVETURA
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Aventura".equals(aux.getGenero()[0]) || "Aventura".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 3: // TERROR
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Terror".equals(aux.getGenero()[0]) || "Terror".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 4: // SUSPENSE
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Suspense".equals(aux.getGenero()[0]) || "Suspense".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 5: // INFANTIL
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Infantil".equals(aux.getGenero()[0]) || "Infantil".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 6: // ROMANCE
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Romance".equals(aux.getGenero()[0]) || "Romance".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
            case 7: // FANTASIA
                for(int i=0; i< ctlg.size(); i++){
                    aux = ctlg.get(i);
                    if("Fantasia".equals(aux.getGenero()[0]) || "Fantasia".equals(aux.getGenero()[1])){
                        filtro.add(ctlg.get(i));
                    }
                }
                break;
        }
        return filtro;
    }
   
    // PRINTAR CATALOGO
    protected void printCatalogo(ArrayList al){
        Produto aux;
        for(int i=0; i < al.size(); i++){
            aux = (Produto)al.get(i);
            System.out.print("Nome: ");
            for (String nome : aux.getNome()) {
                System.out.print(nome + " ");
            }
            System.out.println("\nPreço: " + aux.getPreco());
            System.out.println("Numero do HQ: " + aux.getId());
            System.out.println("");
        }
    }   
    
    protected Produto get(int i){ 
        Produto aux = ctlg.get(i);      
        return aux;
    }
    
    protected boolean verficarEstoque(int id, int quant){
        for(int i=0; i<ctlg.size(); i++){
            if(id == ctlg.get(i).getId()){
                if(quant <= ctlg.get(i).getQuant()){
                    return true;
                }
            }
        }
        return false;
    }
    
    protected void retirarEstoque(int id, int quant){
        for(int i=0; i<ctlg.size(); i++){
            if(id == ctlg.get(i).getId()){
                ctlg.get(i).setQuantidade(quant);
            }
        }
    }
    
    protected Produto pegarID(int id){
        for(int i=0; i<ctlg.size(); i++){
            if(id == ctlg.get(i).getId()){
                return ctlg.get(i);
            }
        }
        return null;
    }
    
}