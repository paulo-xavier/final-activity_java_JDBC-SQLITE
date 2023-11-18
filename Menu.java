import java.util.Scanner; 

public class Menu {

    public static void main(String args[]){
        new Menu().run(); 
    }

    public void run() {
        Scanner rl = new Scanner(System.in); 

        System.out.println("1 - Register user");
        System.out.println("2 - Send message");
        System.out.println("3 - Read message");
        System.out.println("4 - Leave");

        int op = rl.nextInt(); 

        switch (op) {
            case 1:
                System.out.println("Input a nickname: "); 
                rl.nextLine(); 
                String userNickname = rl.nextLine(); 

                User user1 = new User(userNickname);

                System.out.print("\033[H\033[2J");  
                System.out.flush();

                user1.registerUser(user1);
                run(); 
                break; 

            case 2:
                System.out.println("Sender: "); 
                rl.nextLine(); 
                String senderNickname = rl.nextLine(); 
                User sender = new User(senderNickname);

                System.out.println("Recipient: ");
                String recipientNickname = rl.nextLine(); 
                User recipient = new User(recipientNickname); 

                System.out.println("Message: "); 
                String message = rl.nextLine(); 

                Message newMessage = new Message(message, sender, recipient); 

                System.out.print("\033[H\033[2J");  
                System.out.flush();  

                newMessage.sendMessage(newMessage);
                run(); 
                break;

            case 3:
                System.out.println("Input the name of the person to verify: "); 
                rl.nextLine();
                String recipientOfTheMessage = rl.nextLine(); 

                User user = new User(recipientOfTheMessage); 

                System.out.print("\033[H\033[2J");  
                System.out.flush();

                user.readMessage(user); 
                
                run(); 
                break; 

            case 4:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            
                System.out.println("Connection closed!!"); 
                rl.close();
                break; 

            default:
                run(); 
                
        }

    }
    
}
