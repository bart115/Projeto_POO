package src.Limitations;

public class PlanAlreadyExists extends Exception{
    public PlanAlreadyExists (String message)
    {
        System.out.println("\nO Plano " + message + " já existe.\n");
    }
}
