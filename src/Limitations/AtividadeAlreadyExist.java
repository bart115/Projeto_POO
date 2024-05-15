package src.Limitations;

public class AtividadeAlreadyExist extends Exception{
    public AtividadeAlreadyExist(String message)
    {
        System.out.println("\nA atividade " + message + " já existe.\n");
    }
}
