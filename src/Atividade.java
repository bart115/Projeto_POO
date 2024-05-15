package src;

import java.time.LocalDate;
import java.io.Serializable;


public class Atividade  implements Serializable{
    private String codigo;
    private int duracao;

    private int calorias_gastas;

    private Dificuldade dificuldade;

    public enum Dificuldade {
       HARD,
       NOT_CLASSIFIED
    }


    public Atividade(){
        this.codigo = "";
        this.duracao = 0;
        this.dificuldade = Dificuldade.NOT_CLASSIFIED;
        this.calorias_gastas = 0;
    }

    // Construtor com parâmetros
    public Atividade(String codigo, int duracao, Dificuldade dificuldade, int calorias_gastas) {
        this.codigo = codigo;
        this.duracao = duracao;
        this.dificuldade = dificuldade;
        this.calorias_gastas = calorias_gastas;
    }


    public Atividade(Atividade a){
        this.codigo = a.getCodigo();
        this.duracao = a.getDuracao();
        this.dificuldade = a.getDificuldade();
        this.calorias_gastas = a.getCalorias_gastas();
    }

    //getters e setters

    // Getter method for calorias_gastas
    public int getCalorias_gastas() {
        return calorias_gastas;
    }

    // Setter method for calorias_gastas
    public void setCalorias_gastas(int calorias_gastas) {
        this.calorias_gastas = calorias_gastas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Dificuldade getDificuldade(){
        return dificuldade;
    }

    public void setDificuldade(Dificuldade dificuldade){
        this.dificuldade = dificuldade;
    }

    @Override
    public Atividade clone(){
        return new Atividade(this);
    }



}




