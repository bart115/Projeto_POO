package src;

import src.Limitations.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import javax.crypto.spec.PSource;
import java.time.Duration;
import java.io.File;

public class Aplication implements Serializable {


    private Map<String,Atividade> atividades;
    private Map<String, Utilizador> utilizadores;
    private Map<String, Plano_de_Treino> planos_de_treino;

    private LocalDate data;


    public Aplication(){
        this.atividades = new HashMap<>();
        this.utilizadores = new HashMap<>();
        this.planos_de_treino = new HashMap<>();
        this.data = LocalDate.now();
    }

    public Map<String, Atividade> getAtividades() {
        Map<String,Atividade> novo = new HashMap<>();

        for(Map.Entry<String, Atividade> c : this.atividades.entrySet()){
            String aux = c.getKey();
            Atividade use = c.getValue().clone(); //getValue vai buscar 
            novo.put(aux,use);
        }
        return novo;
    }

    public void setAtividades(Map<String, Atividade> atividades) {
        this.atividades = new HashMap<String,Atividade>();
        for(Map.Entry<String, Atividade> c : atividades.entrySet()){
            String aux = c.getKey();
            Atividade use = c.getValue().clone();
            this.atividades.put(aux,use);
        }
    }

    public Map<String, Utilizador> getUtilizadores() {
        Map<String,Utilizador> novo = new HashMap<>();

        for(Map.Entry<String, Utilizador> c : this.utilizadores.entrySet()){
            String aux = c.getKey();
            Utilizador use = c.getValue().clone();
            novo.put(aux,use);
        }
        return novo;
    }

    public void setUtilizadores(Map<String, Utilizador> utilizadores) {
        this.utilizadores = new HashMap<String,Utilizador>();
        for(Map.Entry<String, Utilizador> c : utilizadores.entrySet()){
            String aux = c.getKey();
            Utilizador use = c.getValue().clone();
            this.utilizadores.put(aux,use);
        }
    }

    public Map<String, Plano_de_Treino> getPlanos_de_treino() {
        Map<String,Plano_de_Treino> novo = new HashMap<>();

        for(Map.Entry<String, Plano_de_Treino> c : this.planos_de_treino.entrySet()){
            String aux = c.getKey();
            Plano_de_Treino use = c.getValue().clone();
            novo.put(aux,use);
        }
        return novo;
    }

    public void setPlanos_de_treino(Map<String, Plano_de_Treino> utilizadores) {
        this.planos_de_treino = new HashMap<String,Plano_de_Treino>();
        for(Map.Entry<String, Plano_de_Treino> c : utilizadores.entrySet()){
            String aux = c.getKey();
            Plano_de_Treino use = c.getValue().clone();
            this.planos_de_treino.put(aux,use);
        }
    }

    public LocalDate getData(){
        return this.data;
    }

    public void setData(LocalDate data){
        this.data = data;
    }
    /**
     * Método que adiciona um utilizador à coleção dos utilizadores.
     * @param u
     */
    public void adicionaUtilizador(Utilizador u){
        this.utilizadores.put(u.getCodigoUtilizador(), u.clone());
    } //coloca o utilizador no email correspondido a ele

    /**
     * Método que adiciona uma ativiade à coleção das atividades.
     * @param a
     */

    public void adicionaAtividade(Atividade a){
        this.atividades.put(a.getCodigo(), a.clone());
    } //coloca o utilizador no email correspondido a ele

    public void adicionaPlanoDeTreino(Plano_de_Treino p){
        this.planos_de_treino.put(p.getNome(), p.clone());
    } //coloca o utilizador no email correspondido a ele

    public void adicionaData(LocalDate data) {
        this.data = data;
    }

        /**
         * Para ver se o utilizador existe
         */
    public boolean userExists(String codigo_utilizador){
        return this.utilizadores.containsKey(codigo_utilizador);

    }

    /**
     * Método que devolve o utilizador associado a um email se existir.
     * @param codigoutilizador
     * @return Utilizador associado ao email
     * @throws UserDoesntExist
     */
    public Utilizador getUserEspecifico(String codigoutilizador) throws UserDoesntExist{
        if(!this.utilizadores.containsKey(codigoutilizador))
            throw new UserDoesntExist(codigoutilizador);
        else {
            return this.utilizadores.get(codigoutilizador).clone();
        }
    }

}
