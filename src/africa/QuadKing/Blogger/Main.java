package africa.QuadKing.Blogger;

import africa.QuadKing.Blogger.controllers.UserController;
import africa.QuadKing.Blogger.dtos.requests.RegisterRequest;

import javax.swing.*;
@SpringBootApplication
public class Main {

    private static UserController userController = new UserController();
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp(){
        String message = """
                Hi, what's up?
                1 -> Register
                2 -> Find Users
                """;
        String input = input(message);
        switch (input.charAt(0)){
            case '1' -> register();

            case '2' -> findUser();

            default -> {
                display("Invalid input try again");
                startApp();
            }
        }
    }

    private static void register(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input(" Enter first Name"));
        request.setLastName(input(" Enter last Name"));
        request.setUserName(input(" Enter userName"));
        request.setPassword(input(" Enter password"));

        var result = userController.register(request);
        //4! = there are 24 ways this things inputs can enter but 23 are wrong
        display(result.toString());
        startApp();
    }

    public static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static void findUser(){
        String userInput = input("Enter User Id to search for ");
        display((String) userController.findUserById(Integer.parseInt(userInput)));
        startApp();
    }

    private static String input (String prompt){
        return JOptionPane.showInputDialog(prompt);
    }
}
