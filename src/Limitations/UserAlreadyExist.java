package src.Limitations;

public class UserAlreadyExist extends Exception {
    public UserAlreadyExist(String message)
    {
        System.out.println("\nO utilizador " + message + " já existe.\n");
    }
}