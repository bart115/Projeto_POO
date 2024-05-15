package src;
import java.io.Serializable;

public class Distancia_Altimetria extends Distancia implements Serializable{
    private int altura;


    public Distancia_Altimetria(int altura, int distancia,String codigo, int duracao, Dificuldade dificuldade, int calorias_gastas) {
        super(distancia,codigo,duracao,dificuldade,calorias_gastas);
        this.altura = altura;
    }

    // Getter para a distância percorrida
    public int getAltura() {
        return altura;
    }

    // Setter para a distância percorrida
    public void setAltura(int altura) {
            this.altura = altura;
    }

    public String toprog(){
        return ("Atividade Distancia: " + this.getCodigo() + " , Duração" + this.getDuracao() + " , " + this.getDificuldade() + " , Calorias gastas:" + this.getCalorias_gastas() + ", Distancia: " + this.getDistanciaPercorrida() + ", Altura: " + this.getAltura());
    }
}


// corrida na estrada, trail no monte, bicicleta de
//estrada e bicicleta de montanha)