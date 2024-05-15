package src.Limitations;

public class UserDoesntExist extends Exception {
    public UserDoesntExist(String message)
    {
        System.out.println("\nO utilizador " + message + " não existe.\n");
    }
}