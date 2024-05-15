package src.Limitations;

public class AtividadeDoesntExist extends Exception{
    public AtividadeDoesntExist(String message) //mesage é nome da atividade / codigo
    {
        System.out.println("\nA Atividade " + message + " não existe.\n");
    }
}
