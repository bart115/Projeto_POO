package src;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Collection;

import src.Limitations.*;


public class Controler {

    private View view; //parte interativa com o utilizador
    private Aplication aplication;
    private String current_user;
    private boolean run; //quando o programa esta a andar ou nao
    private boolean logged; //se o utilizador ta loged in ou nao
    private LocalDateTime data;

    public Controler() {
        this.view = new View();
        this.aplication = new Aplication();
        this.run = true;
        this.logged = false;
        this.data = LocalDateTime.now();
    }

    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.loadFileMenu(); //estou a ver isto agora

        do {
            if (!controler.logged)
                controler.logIn(); //usar o da view
            //se ele já estiver logado
            if (controler.logged)
                controler.displayMenu();

        } while (controler.run);

    }

    /**
     * Método que inicia o programa através de um script(data default) ou de um ficheiro de objetos.
     */
    public void loadFileMenu() {
        boolean flag = true;
        while (flag) {
            int opt = this.view.ficheiro_or_default(); // 2 carregar de um ficheiro, 1 dados defaults
            switch (opt) {
                case 1: //dados defaults
                    try {
                        this.aplication = Default_creator.Default_data();
                    } catch (UserDoesntExist udexist) {
                        udexist.getMessage();
                    } catch (AtividadeDoesntExist adexist) {
                        adexist.getMessage();
                    } catch (PlanDoesntExist pdexist) {
                        pdexist.getMessage();
                    }
                    flag = false;
                    break;
               case 2:
                   try{
                        loadFromObjectFile(); //faz load de um

                    } catch (FileNotFoundException fne){
                        fne.getMessage();
                    } catch (IOException io){
                        io.getMessage();
                    } catch (ClassNotFoundException cnfe){
                        cnfe.getMessage();
                    }
                   flag = false;
                    break;
            }
        }
    }


    public void logIn() {
        int op1 = this.view.logInMenu();
        switch (op1) {
            case 0:
                this.run = false; //se ele escolher sair sai do programa
                return;
            case 1: {
                String cod_utilizador;
                boolean flag = true;
                while (flag) {
                    cod_utilizador = this.view.logIn(); //pedir o username
                    if (this.aplication.userExists(cod_utilizador)) { // se o utilizador já existir
                        try {
                            current_user = this.aplication.getUserEspecifico(cod_utilizador).getCodigoUtilizador(); //ir buscar o codigo do user à app se ele exitir
                        } catch (UserDoesntExist e) {
                            e.getMessage();
                        }
                        this.logged = true;
                        flag = false;
                    } else {
                        criaUtilizador();
                        this.logged = true;
                        flag = false;
                    }
                }
                break;
            }
        }
    }



    /**
     * Método responsável pela execução das componentes do menu.
     */
    public void displayMenu() {
        try {
            int op2 = Integer.parseInt(this.view.menu());
            switch (op2) {
                case 0:
                    this.logged = false;
                    return;
                case 1:
                    System.out.println("=======================");
                    create_atividade();
                    System.out.println("Atividade Criada");
                    return;
                case 2:
                    criaUtilizador();
                    return;
                case 3:
                    System.out.println("3 - Criar Plano de Treino");
                    return;
                case 4:
                    escreverficheiroObjetos();
                    return;
                case 5:
                    displaymenu_estatisticas();
                    return;
                case 6:
                    LocalDate data = view.avancaData();
                    this.aplication.adicionaData(data);
                    return;
                case 7:
                    System.out.println("7 Escreve ficheiro de txt");
                    return;
                default:
                    System.out.println("Opção inválida");
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro no load de ficheiros!");
        }
    }

    public void displaymenu_estatisticas(){
            int op = this.view.menuEstatisticas();
            //fazer switch com as opções das estatisticas
    }
        /**
         * Método responsável pela criação de um utilizador.
         */
        public void criaUtilizador () {
            String cod_utilizador;
            boolean flag = true;
            while (flag) {
                cod_utilizador = this.view.logIn(); //pedir o username
                if (this.aplication.userExists(cod_utilizador)) { // se o utilizador já existir
                    try {
                        current_user = this.aplication.getUserEspecifico(cod_utilizador).getCodigoUtilizador(); //ir buscar o codigo do user à app se ele exitir
                    } catch (UserDoesntExist e) {
                        e.getMessage();
                    }
                    System.out.println("Utilizador com esse código já existe! \n");
                    flag = true;
                } else {
                    this.logged = true;
                    flag = false;

                    String[] tokens = view.criar_conta();
                    Utilizador.Tipo tipo = view.criar_conta_tipo();

                    Utilizador utilizador = new Utilizador(tokens[0],tokens[1],tokens[2],tokens[3],tipo);
                    current_user = tokens[0];
                    this.aplication.adicionaUtilizador(utilizador);
                }
            }
        }

    /**
     * Método responsável por dar load de um estado do nosso programa guardado num ficheiro de objetos.
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadFromObjectFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream("estado.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.aplication = (Aplication) ois.readObject();
        Utilizador.setCounter(ois.read()); //para meter aqui quantos utilizadores existem sq fazer isto para as atividades também
        ois.close();
    }

    /**
     * Método responsável por escrever o estado do nosso programa num ficheiro de objetos.
     * @throws IOException
     */
    public void escreverficheiroObjetos() throws IOException{
        FileOutputStream fos = new FileOutputStream("estado.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.aplication);
        oos.write(Plano_de_Treino.getCount());
        oos.flush();
        oos.close();
    }

    public void create_atividade() {
        int tipo = view.tipoAtividadeCriada();
        switch (tipo) {
            case 0:
                view.menu();
                return;
            case 1:
                create_atividade_distancia();
                return;
            case 2:
                create_atividade_distancia_altimetria();
                return;
            case 3:
                create_atividade_serieR();
                return;
            case 4:
                create_atividade_serieR_peso();
                return;
            default:
                System.out.println("Opção inválida");
                return;
        }
    }


    public void create_atividade_distancia(){
            String[] atividadedefault = view.atividade_default();
            int duracao = Integer.parseInt(atividadedefault[1]);
            int calorias_gastas = Integer.parseInt(atividadedefault[2]);
            int distancia = view.distancia();
            Atividade.Dificuldade tipo = view.dificuldade_atividade();

        Distancia distancia1 = new Distancia(distancia,atividadedefault[0],duracao,tipo,calorias_gastas);
        this.aplication.adicionaAtividade(distancia1);

    }

    public void create_atividade_distancia_altimetria(){
        String[] atividadedefault = view.atividade_default();
        int duracao = Integer.parseInt(atividadedefault[1]);
        int calorias_gastas = Integer.parseInt(atividadedefault[2]);
        int distancia = view.distancia();
        int altura = view.altura();
        Atividade.Dificuldade tipo = view.dificuldade_atividade();

        Distancia_Altimetria distancia_altimetria = new Distancia_Altimetria(altura,distancia,atividadedefault[0],duracao,tipo,calorias_gastas);
        this.aplication.adicionaAtividade(distancia_altimetria);

    }


    public void create_atividade_serieR_peso(){
        String[] atividadedefault = view.atividade_default();
        int duracao = Integer.parseInt(atividadedefault[1]);
        int calorias_gastas = Integer.parseInt(atividadedefault[2]);
        int peso = view.peso_atividade();
        Atividade.Dificuldade tipo = view.dificuldade_atividade();
        int[] rep_ser = view.numero_rep_numero_serie();
        Series_repeticoes_peso seriesRepeticoes_peso = new Series_repeticoes_peso(peso,rep_ser[0],rep_ser[1],atividadedefault[0],duracao,tipo,calorias_gastas);
        this.aplication.adicionaAtividade(seriesRepeticoes_peso);
    }

    public void create_atividade_serieR(){
        String[] atividadedefault = view.atividade_default();
        int duracao = Integer.parseInt(atividadedefault[1]);
        int calorias_gastas = Integer.parseInt(atividadedefault[2]);
        Atividade.Dificuldade tipo = view.dificuldade_atividade();
        int[] rep_ser = view.numero_rep_numero_serie();
        Series_repeticoes seriesRepeticoes = new Series_repeticoes(rep_ser[0],rep_ser[1],atividadedefault[0],duracao,tipo,calorias_gastas);
        this.aplication.adicionaAtividade(seriesRepeticoes);
    }
    //tenho de colocar na cena da aplication
    /**
     * Método responsável por escrever o estado do nosso programa para um ficheiro de texto
     * de forma a tornar fácil a visualização e debug.
     * @throws IOException
     */
    /* PASSAR PARA TXT falta na aplication
    public void writeToprog() throws IOException {
        String name = "./src/prog.txt";

        File file = new File(name);
        FileOutputStream fos = new FileOutputStream(file);
        try (PrintWriter pw = new PrintWriter(fos)) {

            List<String> lista;

           lista = this.aplication.toprog(); //este faz a de todos os logs ou seja atividade, utilizadores e planos de treino

            for (String s : lista) {
                pw.println(s);
            }

        }
        fos.close();
    }
    */
}
