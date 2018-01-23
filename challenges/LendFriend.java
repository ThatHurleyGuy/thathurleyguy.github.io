import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LendFriend {
    public static ArrayList<String> users = new ArrayList();
    public static ArrayList<Integer> balances = new ArrayList();

    public static void main(String [] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        for(String line : lines) {
            String [] command = line.split(" ");
            if(command[1].equals("joins"))
                join(command[0]);
            else if(command[1].equals("deposits"))
                deposit(command[0], command[2]);
            else if(command[1].equals("pays"))
                pay(command[0], command[2], command[3]);
            else if(command[1].equals("withdraws"))
                withdraw(command[0], command[2]);
        };

        printOutput();
    }

    public static void join(String name) {
        users.add(name);
        balances.add(0);
    }

    public static void deposit(String name, String amount) {
        int userId=-1;
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).equals(name)) {
                userId = i;
            }
        }
        if(userId != -1) {
            int balance = Integer.parseInt(amount.substring(1));
            balances.set(userId, balance);
        }
    }

    public static void pay(String payer, String payee, String amount) {
        int payerId=-1;
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).equals(payer)) {
                payerId = i;
            }
        }
        int payeeId=-1;
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).equals(payee)) {
                payeeId = i;
            }
        }

        if(payerId != -1 && payeeId != -1) {
            int payment = Integer.parseInt(amount.substring(1));
            int payerBalance = balances.get(payerId);
            if(payerBalance >= payment) {
                int payeeBalance = balances.get(payeeId);
                balances.set(payerId, payerBalance - payment);
                balances.set(payeeId, payeeBalance + payment);
            }
        }
    }

    public static void withdraw(String name, String amount) {
        int userId=-1;
        for(int i=0; i<users.size(); i++) {
            if(users.get(i).equals(name)) {
                userId = i;
            }
        }

        if(userId != -1) {
            int withdrawalAmount = Integer.parseInt(amount.substring(1));
            int userBalance = balances.get(userId);
            if(userBalance >= withdrawalAmount) {
                balances.set(userId, userBalance - withdrawalAmount);
            }
        }
    }

    public static void printOutput() {
        for(int i=0; i<users.size(); i++) {
            System.out.println(users.get(i) + " has $" + balances.get(i));
        }
    }
}

