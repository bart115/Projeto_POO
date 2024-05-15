package src;
import java.io.Serializable;

public class Distancia extends Atividade implements Serializable
{
    private int distancia_percorrida;


    public Distancia(int distancia_percorrida, String codigo, int duracao, Dificuldade dificuldade, int calorias_gastas)
    {
        super (codigo,duracao,dificuldade,calorias_gastas);
        this.distancia_percorrida = distancia_percorrida;
    }
    // Getter para a distância percorrida
    public int getDistanciaPercorrida() {
        return distancia_percorrida;
    }

    // Setter para a distância percorrida
    public void setDistanciaPercorrida(int distancia_percorrida) {
        this.distancia_percorrida = distancia_percorrida;
    }

    public String toprog(){
        return ("Atividade Distancia: " + this.getCodigo() + " , Duração" + this.getDuracao() + " , " + this.getDificuldade() + " , Calorias gastas:" + this.getCalorias_gastas() + ", Distancia: " + this.getDistanciaPercorrida());
    }
}
//remo, corrida na pista de atle=smo, pa=nagem