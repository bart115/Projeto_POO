package src;

import src.Limitations.UserDoesntExist;
import src.Limitations.AtividadeDoesntExist;
import src.Limitations.PlanDoesntExist;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Default_creator {
    //colocar aqui criação de utilizadores já existentes e atividades
    //chamar as funções que fizer aqui no Controler
    /**
     * Método que funciona como script para criar à priori utilizadores, atividades e planos de treino como ponto de partida do programa.
     * @return Default users and activities set
     */
    public static Aplication Default_data() throws UserDoesntExist, AtividadeDoesntExist, PlanDoesntExist {
        Aplication aplication = new Aplication();
        //Atividades defaults

        Atividade atividade1 = new Atividade("Flexoes", 60, Atividade.Dificuldade.HARD, 200);
        Atividade atividade2 = new Atividade("Abdominais", 45, Atividade.Dificuldade.NOT_CLASSIFIED, 150);
        Atividade atividade3 = new Atividade("Pullups", 30, Atividade.Dificuldade.HARD, 100);
        Atividade atividade4 = new Atividade("Burpes", 70, Atividade.Dificuldade.HARD, 250);
        Atividade atividade5 = new Atividade("Sit ups", 55, Atividade.Dificuldade.HARD, 180);

        Series_repeticoes atividade_serie_repeticoes = new Series_repeticoes(10,10,"Sit ups", 55, Atividade.Dificuldade.HARD, 180);
        aplication.adicionaAtividade(atividade1);
        aplication.adicionaAtividade(atividade2);
        aplication.adicionaAtividade(atividade3);
        aplication.adicionaAtividade(atividade4);
        aplication.adicionaAtividade(atividade5);

        //UTILIZADOR

        // Criando um conjunto de atividades para um utilizador
        Set<Atividade> atividadesUtilizador1 = new HashSet<>();
        atividadesUtilizador1.add(atividade1);
        atividadesUtilizador1.add(atividade2);

        // Criando um conjunto de atividades para um utilizador
        Set<Atividade> atividadesUtilizador2 = new HashSet<>();
        atividadesUtilizador2.add(atividade3);
        atividadesUtilizador2.add(atividade4);
        atividadesUtilizador2.add(atividade5);

        // Criando um conjunto de atividades para um utilizador
        Set<Atividade> atividadesUtilizador3 = new HashSet<>();
        atividadesUtilizador3.add(atividade3);
        atividadesUtilizador3.add(atividade2);
        atividadesUtilizador3.add(atividade1);

        Utilizador utilizador1 = new Utilizador("1", "João", "Rua A", "joao@email.com",70, Utilizador.Tipo.PRATICANTE_OCASIONAL, atividadesUtilizador1);
        Utilizador utilizador2 = new Utilizador("2", "Luis", "Rua B", "luis@email.com",10, Utilizador.Tipo.PRATICANTE_OCASIONAL, atividadesUtilizador2);
        Utilizador utilizador3 = new Utilizador("3", "Jacinto", "Rua C", "jacin@email.com",2, Utilizador.Tipo.PRATICANTE_OCASIONAL, atividadesUtilizador3);

        aplication.adicionaUtilizador(utilizador1);
        aplication.adicionaUtilizador(utilizador2);
        aplication.adicionaUtilizador(utilizador3);
        //
        //PLANOS TREINO

        Set<Atividade> atividadesplanotreino1 = new HashSet<>();
        atividadesplanotreino1.add(atividade3);
        atividadesplanotreino1.add(atividade4);
        atividadesplanotreino1.add(atividade5);
        atividadesplanotreino1.add(atividade1);



        Set<Atividade> atividadesplanotreino2 = new HashSet<>();
        atividadesplanotreino2.add(atividade1);
        atividadesplanotreino2.add(atividade2);
        atividadesplanotreino2.add(atividade3);
        atividadesplanotreino2.add(atividade4);
        atividadesplanotreino2.add(atividade5);


        Date data_plano_treino1 = new Date(2000, Calendar.FEBRUARY, 20);
        Date data_plano_treino2 = new Date(2024, Calendar.MARCH, 10);


        Plano_de_Treino planotreino1 = new Plano_de_Treino("Projeto verao",atividadesplanotreino1,data_plano_treino1,2);
        Plano_de_Treino planotreino2 = new Plano_de_Treino("Projeto março",atividadesplanotreino2,data_plano_treino2,1);

        aplication.adicionaPlanoDeTreino(planotreino2);
        aplication.adicionaPlanoDeTreino(planotreino1);

        return aplication;
    }




}
