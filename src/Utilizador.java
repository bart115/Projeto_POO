package src;

import java.util.*;
import java.util.Set;
import java.io.Serializable;

public class Utilizador implements Serializable{
    private static int counter = 0;
    private String codigoUtilizador;
    private String nome;
    private String morada;
    private String email;
    private double frequenciaCardiacaMedia;
    private Tipo tipo;
    private Set<Atividade> atividades_completadas;

    public enum Tipo {
        AMADOR,
        PRATICANTE_OCASIONAL,
        PROFISSIONAL,
        NULL
    }
    // é realmente necessário este construtor?
    //fazer get das atividades completadas
    public Utilizador() {
        this.codigoUtilizador = "";
        this.nome = "";
        this.morada = "";
        this.email = "";
        this.frequenciaCardiacaMedia = 0;
        this.tipo = Tipo.PRATICANTE_OCASIONAL;
        this.atividades_completadas = new HashSet<>();

    }

    // Construtor
    public Utilizador (String codigoUtilizador, String nome, String morada, String email, Tipo tipo){
        this.counter++;
        this.codigoUtilizador = codigoUtilizador;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.tipo = tipo;
        this.frequenciaCardiacaMedia = 0;
        this.atividades_completadas = new HashSet<>();

    }
    public Utilizador(String codigoUtilizador, String nome, String morada, String email, double frequenciaCardiacaMedia
            , Tipo tipo, Set<Atividade> atividades_completadas) {
        this.counter++;
        this.codigoUtilizador = codigoUtilizador;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
        this.tipo = tipo;
        setAtividades_completadas(atividades_completadas);

    }

    public Utilizador(Utilizador u){
        this.counter = u.getCounter();
        this.codigoUtilizador = u.getCodigoUtilizador();
        this.nome = u.getNome();
        this.morada = u.getMorada();
        this.email = u.getEmail();
        this.frequenciaCardiacaMedia = u.getFrequenciaCardiacaMedia();
        this.tipo = u.getTipo();
        this.atividades_completadas = u.getAtividades_completadas();

    }

    // Getters e Setters


    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Utilizador.counter = counter;
    }

    public String getCodigoUtilizador() {
        return codigoUtilizador;
    }

    public void setCodigoUtilizador(String codigoUtilizador) {
        this.codigoUtilizador = codigoUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getFrequenciaCardiacaMedia() {
        return frequenciaCardiacaMedia;
    }

    public void setFrequenciaCardiacaMedia(double frequenciaCardiacaMedia) {
        this.frequenciaCardiacaMedia = frequenciaCardiacaMedia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    //ATIVIDADES LISTA
    public Set<Atividade> getAtividades_completadas() {
        Set<Atividade> novo = new HashSet<>(this.atividades_completadas);
        return novo;
    }

    public void setAtividades_completadas(Set<Atividade> atividades_completadas) {
        this.atividades_completadas = new HashSet<>();
        for (Atividade atividade : atividades_completadas) {
            this.atividades_completadas.add(atividade);
        }
    }

    /**
     * Metodo que imprime um utilizador e suas atividades no terminal
     * @return Utilizador
     * */
    public static void exibirUtilizador_completo(Utilizador utilizador) {
        System.out.println("Código do Utilizador: " + utilizador.getCodigoUtilizador());
        System.out.println("Nome: " + utilizador.getNome());
        System.out.println("Morada: " + utilizador.getMorada());
        System.out.println("Email: " + utilizador.getEmail());
        System.out.println("Frequência Cardíaca Média: " + utilizador.getFrequenciaCardiacaMedia());
        System.out.println("Tipo: \n" + utilizador.getTipo());
        System.out.println("\n====Atividades Completadas==== ");
        int contadorAtividades = 1;
        for (Atividade atividade : utilizador.getAtividades_completadas()) {
            System.out.println("  ->Atividade número " + contadorAtividades++);
            System.out.println("  Código: " + atividade.getCodigo());
            System.out.println("  Duração: " + atividade.getDuracao());
            System.out.println("  Dificuldade: " + atividade.getDificuldade());
            System.out.println("  Calorias Gastas: " + atividade.getCalorias_gastas());
        }
    }

    /**
     * Metodo que imprime a as atividades de um Utilizador
     * @return Utilizador
     * */
    public static void exibirAtividades_Utilizador(Utilizador utilizador) {
        System.out.println("\n====Atividades Completadas==== ");
        int contadorAtividades = 1;
        for (Atividade atividade : utilizador.getAtividades_completadas()) {
            System.out.println("  ->Atividade número " + contadorAtividades++);
            System.out.println("  Código: " + atividade.getCodigo());
            System.out.println("  Duração: " + atividade.getDuracao());
            System.out.println("  Dificuldade: " + atividade.getDificuldade());
            System.out.println("  Calorias Gastas: " + atividade.getCalorias_gastas());
        }
    }


    @Override
    public Utilizador clone(){
        return new Utilizador(this);
    }


    //aqui não possui as atividades completadas so mesmo o utilizadpr por enquanto
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código de Utilizador:: " + this.codigoUtilizador + "\n");
        sb.append("Nome de Utilizador:: " + this.nome + "\n");
        sb.append("Email:: " + this.email + "\n");
        sb.append("Morada:: " + this.morada + "\n");
        sb.append("Frequencia Cardiaca Media:: " + this.frequenciaCardiacaMedia + "\n");
        sb.append("Atividades Completadas:: [");
        int contadorAtividades = 1;
        for (Atividade atividade : this.atividades_completadas) {
            sb.append("  Atividade número " + contadorAtividades++);
            sb.append("  Código: " + atividade.getCodigo());
            sb.append("  Duração: " + atividade.getDuracao());
            sb.append("  Dificuldade: " + atividade.getDificuldade());
            sb.append("  Calorias Gastas: " + atividade.getCalorias_gastas());
        }
        sb.append("]\n");
        return sb.toString();
    }

    /**
     * Método que cria uma String para escrever o objeto Utilizador em ficheiro de texto.
     * @return String com todos os campos.
     */
    public String toprog(){
        return ("Utilizador:" + this.getCodigoUtilizador() + "," + this.getNome() + "," + this.getEmail() + "," + this.getMorada() + "," + this.getTipo() + "," + this.getFrequenciaCardiacaMedia());
    }

        //so escreve o utilizador podemos deposi dividir esta função em atividades completadas

}



