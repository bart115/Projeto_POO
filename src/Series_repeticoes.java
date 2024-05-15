package src;
import java.io.Serializable;
import src.Atividade;

public class Series_repeticoes extends Atividade {
    private int numero_repeticoes;
    private int numero_de_series;



    public Series_repeticoes(int numero_repeticoes, int numero_de_series, String codigo, int duracao, Dificuldade dificuldade, int calorias_gastas){
        super(codigo,duracao,dificuldade,calorias_gastas); //recebe as coisas da atividade  e usa o contrutor da mesma para criar a atividade
        this.numero_de_series = numero_de_series;
        this.numero_repeticoes = numero_repeticoes;

    }

        //Getter para numero de repeticoes
        public int getNumeroRepeticoes() {
            return numero_repeticoes;
        }
        // Setter para o número de repetições
        public void setNumeroRepeticoes(int numero_repeticoes) {
            this.numero_repeticoes = numero_repeticoes;
        }
        //Getter para o numero de series
        public int getNumeroSeries() {
            return numero_de_series;
        }
        // Setter para o número de series
        public void setNumeroSeries(int numero_de_series) {
            this.numero_de_series = numero_de_series;
        }

    public String toprog(){
        return ("Atividade Serie de repetições: " + this.getCodigo() + " , Duração" + this.getDuracao() + " , " + this.getDificuldade() + " , Calorias gastas:" + this.getCalorias_gastas() + ", Numero de Series: " + this.getNumeroSeries() + ", Numero de repetições: " + this.getNumeroRepeticoes());
    }

}

// abdominais, alongamentos, flexões)