package src.Limitations;

public class PlanDoesntExist extends Exception{
    public PlanDoesntExist(String message) //message é nome do plano
    {
        System.out.println("\nO Plano " + message + " não existe.\n");
    }
}
