package src;

import src.Series_repeticoes;

import java.io.Serializable;

public class Series_repeticoes_peso extends Series_repeticoes implements Serializable
{
    private int peso;


    //consttrutor
    public Series_repeticoes_peso(int peso,int numero_repeticoes, int numero_de_series,  String codigo, int duracao, Dificuldade dificuldade, int calorias_gastas) {
        super(numero_repeticoes, numero_de_series, codigo,duracao,dificuldade,calorias_gastas); // vai buscar o contrutor da series repeticoes e cria a atividade
        this.peso = peso;
    }


    //Getter do peso
    public int getPeso() {
        return peso;
    }
    //Setter do peso
    public void setPeso(int peso){
        this.peso = peso;
    }

    /**
     * Método que cria uma String para escrever o objeto Atividaade em ficheiro de texto.
     * @return String com todos os campos.
     */
    public String toprog(){
        return ("Atividade Serie de repetições com peso: " + this.getCodigo() + " , Duração" + this.getDuracao() + " , " + this.getDificuldade() + " , Calorias gastas:" + this.getCalorias_gastas() + ", Numero de Series: " + this.getNumeroSeries() + ", Numero de repetições: " + this.getNumeroRepeticoes() + " , " + "Peso: " + this.getPeso());
    }

}