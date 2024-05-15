package src;

import java.time.LocalDate;
import java.util.*;
import java.util.spi.LocaleServiceProvider;

public class View {
    private Aplication aplication;




    public View(){
        this.aplication = new Aplication();

    }
    /**
     * Opção de carregar um ficheiro (2) ou utilizar dados defaults(1)
     * @return opção escolhida.
     */
    //TESTADO
    public int ficheiro_or_default() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique como pretende iniciar a aplicação:");
        System.out.println("1. Nova");
        System.out.println("2. Carregar de um Ficheiro de objetos");


        int option;
        do{
            option = sc.nextInt();
            if(option != 1 && option !=2)
                System.out.println("Introduza um inteiro com o valor 1 ou 2.");
        } while(option != 1 && option != 2);

        return option;
    }
    //testado
    /**
     * HUB simples
     * @return decisão do user */
    public int logInMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========");
        System.out.println("1. Login/Sign-in");
        System.out.println("0. Terminar Programa");

        int option = 0;
        do{
            option = sc.nextInt();
            if(option != 1 && option != 0) //devo puder retirar este if
                System.out.println("Introduza o valor 0 ou 1.");
        } while(option != 1 && option != 0);

        return option;
    }

    /**
     * Recolhe o email do utilizador no LOGIN
     * @return email.
     */
    //TESTADO
    public String logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==Utilizador==");
        System.out.println("Insira o código de utilizador:");

        return sc.next(); //recebemos o codigo de utilizador
    }

    /**
     * Recolha de informação dos campos de um utilizador criação de conta
     * @return array de strings com os campos.
     */
    //TESTADO
    public String[] criar_conta() {
        Scanner sc = new Scanner(System.in);
        String[] utilizadorInput = new String[4];
        System.out.println("Vamos criar uma nova conta!");
        System.out.println("Informação sobre a sua nova conta!");

        utilizadorInput[0] = logIn();

        if(this.aplication.userExists(utilizadorInput[0])){
                System.out.println("Codigo de utilizador já exitente\n");
                System.out.println("Escreva outro código de utilizador");
                utilizadorInput[0] = sc.nextLine();
        }
        else {

            System.out.print("Insira o seu nome: "); // nome fica no 1
            utilizadorInput[1] = sc.nextLine();

            System.out.print("Insira a sua morada: "); //morada fica no 2
            utilizadorInput[2] = sc.nextLine();

            System.out.print("Insira o seu email: "); //email fica no 3
            utilizadorInput[3] = sc.nextLine();

        }
        return utilizadorInput;
    }

    /**
     * Receber o tipo do user do log in
     */
   public Utilizador.Tipo criar_conta_tipo(){
       Scanner sc = new Scanner(System.in);

       System.out.print("Insira o seu tipo: \n");
       System.out.print("1 - Amador\n" +
                        "2 - Praticante Ocasional\n" +
                        "3 - Profissional\n");
       int i;
       Utilizador.Tipo tipo = Utilizador.Tipo.AMADOR;
       do{
           i = sc.nextInt();
           if (i == 1){
               tipo = Utilizador.Tipo.AMADOR;
           }else if(i == 2){
               tipo = Utilizador.Tipo.PRATICANTE_OCASIONAL;
           }else if(i == 3) {
               tipo = Utilizador.Tipo.PROFISSIONAL;
           }else if(i < 1 || i > 3){
               System.out.println("Introduza um valor igual a  1, 2, 3");
           }
       } while(i < 1 || i > 3);
       return tipo;
   }


    /**
     * Menu principal criar nova atividade criar plano de treino etc..
     * @return opção escolhida.
     */
    // TENHO DE FAZER MENU DE ESCOLHA
    public String menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====Fitness HUB=====");
        System.out.println("1 - Criar Atividade");
        System.out.println("2 - Criar Utilizador");
        System.out.println("3 - Criar Plano de Treino");
        System.out.println("4 - Guardar num ficheiro de objetos" );
        System.out.println("5 - Calcular Estatísticas" );
        System.out.println("6 - Mudar Data");
        System.out.println("7 - Escreve ficheiro de txt");
        System.out.println("0 - Terminar Sessão");
        System.out.println("Indique a opcao: ");


        return sc.nextLine();
    }
    /**
     * Menu de Estatisticas
     * @estatistica a ser realizada(opção do user)
     * */
       public int menuEstatisticas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a estatística que pretende calcular?");
        System.out.println("1 - Qual é o utilizador que mais calorias dispendeu num período ou desde sempre");
        System.out.println("2 - Qual o utilizador que mais actividades realizou num período ou desde sempre");
        System.out.println("3 - Qual o tipo de actividade mais realizada");
        System.out.println("4 - Quantos kms é que um utilizdor realizou num período ou desde sempre");
        System.out.println("5 - Quantos metros de altimetria é que um utilizar totalizou num período ou desde sempre");
        System.out.println("6 - Qual o plano de treino mais exigente em função do dispêndio de calorias proposto");
        System.out.println("7 - Qual o plano de treino mais exigente em função do dispêndio de calorias proposto");
        System.out.println("8 - Listar as actividades de um utilizador");
        System.out.println("0 - Voltar ao Menu Inicial");

        int opt;
        do{
            opt = sc.nextInt();
            if(opt < 0 || opt > 5)
                System.out.println("Introduza um valor igual a 0, 1, 2, 3, 4, 5, 6, 7 ou 8");
        } while(opt < 0 || opt > 8);

        return opt;
    }


    /**
     * Recolha de informação sobre a atividade que vai ser criada
     * @return opção escolhida.
     */
    public int tipoAtividadeCriada() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que tipo de Atividade queres criar?");
        System.out.println("1. Distancia");
        System.out.println("2. Distancia e Alimetria");
        System.out.println("3. Series de repeticoes");
        System.out.println("4. Series de repeticoes com peso");
        System.out.println("0 - Voltar ao Menu Inicial");

        int option = 0;
        do{
            option = sc.nextInt();
            if(option < 0 || option > 4)
                System.out.println("Introduza o valor 0, 1, 2, 3 ou 4");
        } while(option < 0 || option > 4);

        return option;
    }
    /**
     * Vai buscar o local de onde vai ser realizada a atidade
     */
    public int altura(){
        Scanner sc = new Scanner(System.in);
        int altura;
        System.out.println("Qual a altura percorrida:");
        altura = sc.nextInt();
            return altura;
    }

    /**
     * Vai buscar a distancia percorrida na atividade
     */
    public int distancia(){
        Scanner sc = new Scanner(System.in);
        int distancia;
        System.out.println("Qual a distancia que será percorrida(km):");
        distancia = sc.nextInt();
        return distancia;
    }

    /**
     * Vai buscar o numero de series e o numero de repeticoes
     */
    public int[] numero_rep_numero_serie(){
        Scanner sc = new Scanner(System.in);
        int[] opt = new int[2];
        System.out.println("Quantas series vão ser realizadas:");
        opt[0] = sc.nextInt();
        System.out.println("Número de repetições em cada serie:");
        opt[1] = sc.nextInt();
        return opt;
    }
    /**
     * O que vai buscar o default para criar uma atividade assim posso usar para todos em geral
     */
    /**
     * vai buscar o peso
     */
    public int peso_atividade(){
        Scanner sc = new Scanner(System.in);
        int peso;
        System.out.println("Qual o Peso usado(kg):");
        peso = sc.nextInt();
        return peso;
    }
    /**
     * Método que recebe da super class Atividade
     */
    //
    //Atividade("Flexoes", 60, Atividade.Dificuldade.HARD, 200)
    public String[] atividade_default(){
        Scanner sc = new Scanner(System.in);
        String[] opt = new String[3];
        System.out.println("Vamos criar uma nova atividade!!");
        System.out.println("Qual o nome da atividade:");
        opt[0] = sc.nextLine();
        System.out.println("Qual a duração da atividade(minutos):");
        opt[1] = sc.nextLine();
        System.out.println("Quantas calorias pretende queimar(kcal):");
        opt[2] = sc.nextLine();
        return opt;
    }

    /**
     * Metodo que pergunta ao user o tipo de atividade
     * @return
     */
    public Atividade.Dificuldade dificuldade_atividade(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Esta atividade é do tipo HARD?\n" +
                "1 - Sim\n" +
                "2 - Não");
        int i;
        Atividade.Dificuldade tipo = Atividade.Dificuldade.NOT_CLASSIFIED;
        do{
            i = sc.nextInt();
            if (i == 1){
                tipo = Atividade.Dificuldade.HARD;
            }else if(i < 1 || i > 3){
                System.out.println("Introduza um valor igual a  1, 2, 3");
            }
        } while(i < 1 || i > 3);

        return tipo;
    }




    /**
     * Método que avança para uma data escolhida pelo user
     * @return Data que o user escolheu
     */
    //TESTATO
    public LocalDate avancaData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique para que data pretente avançar, utilize o formato (aaaa-mm-dd)");


        return LocalDate.parse(leLocalDate());
    }

    //Lê a data no formato xxxx/xx/xx
    //TESTADO só serve para ustilizar sempre o mesmo formato de data
    public String leLocalDate(){
        Scanner sc = new Scanner(System.in);
        String ret;
        boolean flag = true;
        do{
            ret = sc.nextLine();
            try{
                LocalDate test = LocalDate.parse(ret); // se der algum erro a fazer isto ele pede denovo
                flag = false;
            } catch (Exception e){
                System.out.println("Introduza o formato correto");
            }
        } while(flag);
        return ret;
    }
    /**
     * Recolhe um intervalo de tempo(array tem 2)
     * @return array com os dois LocalDates correspondentes ao intervalo de tempo.
     */
    //TESTADO
    public LocalDate[] intervaloTempo() {
        LocalDate datas[] = new LocalDate[2];

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduza a data inicial: (yyyy-mm-dd)");
            datas[0] = LocalDate.parse(leLocalDate()); //quando uso o parse ele recebe a string do localdate ec coloca a num formato "local date"
            System.out.println("Introduza a data final: (yyyy-mm-dd)");
            datas[1] = LocalDate.parse(leLocalDate());

            if (datas[0].isAfter(datas[1]))
                System.out.println("Por favor introduza uma data inicial inferior ou igual à data superior.");
        } while (datas[0].isAfter(datas[1]));

        return datas;
    }


}
