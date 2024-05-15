package src;

import java.time.DayOfWeek;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.io.Serializable;



public class Plano_de_Treino implements Serializable {
    private static int count=1;
    private int codigo;
    private String nome;
    private Set<Atividade> atividades;
    private Set<Utilizador> utilizadores; //flata isto

    private Date data;

    private int n_vezes;

    public Plano_de_Treino() {
        this.codigo = this.count++;
        this.nome = "";
        this.atividades = new HashSet<>();
        this.data = new Date(2000, Calendar.FEBRUARY, 20);
        this.n_vezes = 0;
    }

    public Plano_de_Treino(String nome,Set<Atividade> atividades,Date data, int n_vezes){
        this.nome = nome;
        this.data = data;
        setAtividades(atividades);
        this.n_vezes = n_vezes;
    }

    public Plano_de_Treino(Plano_de_Treino p){
        this.codigo = p.getCodigo();
        this.nome = p.getNome();
        this.data = p.getData();
        this.atividades = p.getAtividades();
        this.n_vezes = p.getN_vezes();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Plano_de_Treino.count = count;
    }


    private int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() { return data;}

    public void setData(Date data) {
        this.data = data;
    }


    public Set<Atividade> getAtividades() {
        Set<Atividade> novo = new HashSet<>(this.atividades);
        return novo;
    }

    public void setAtividades(Set<Atividade> atividades_completadas) {
        this.atividades = new HashSet<>();
        for (Atividade atividade : atividades) {
            this.atividades.add(atividade);
        }
    }

    public int getN_vezes() {return n_vezes;}

    public void setN_vezes() {
        this.n_vezes = n_vezes;
    }

    @Override
    public Plano_de_Treino clone(){
        return new Plano_de_Treino(this);
    }


    /* FAZER to prga parao plano de treino
    public String toprog(){
        return ("Plano de treino:" + this.getCodigo() + "," + this.getDuracao() + "," + this.getDificuldade());
    }
    */

    //Getters e setters
    //...
    //

    /* Mudar este código de modo a que adicione uma atividade a um plano de treino

    public void addArtEncomenda(Artigo c){
        double preco = this.preco_artigos;
        this.artigos.add(c);
        Transportadora aux = c.getTransp();

        if (this.contador.containsKey(aux)) {
            int contagem = this.contador.get(aux);
            this.contador.put(aux, contagem + 1);
        }
        else {
            this.contador.put(aux, 1);
        }

        preco += c.getPreco_curr();
        if(c.isNovo()){
            preco += 0.5;
        }
        else preco += 0.25;
        defDimensaoCaixa();
        setPrecoArtigos(preco);
        setPreco_transporte(calculaPrecoTransporte());
    }
    */

}
