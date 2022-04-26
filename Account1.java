import java.util.Scanner;

class Sender implements Runnable{
    Account acc;
    Thread t;
    Scanner sc;

    Sender(Account acc){
        this.acc = acc;
        t = new Thread(this, "Sender");
        sc = new Scanner(System.in);
    }

    public void run(){
        while(true){
            int amount = sc.nextLine();
            acc.deposit(amount);
        }
    }
}

class Receier implements Runnable(){
    Account acc;
    Thread t;
    Receier(Account acc){
        this.acc = acc;
        t = new Thread(this, "Receier");
    }

    public void run(){
        while(true){
            int i = acc.withdraw();
        }
    }
}

public class BakingTest() {
   public static void main(String[] args) {
       Account acc = new Account(8000);
       System.out.println("Initial balance: ");
       acc.display();
       Sender s = new Sender(acc);
       Receier r = new Receier(acc);

       s.t.start();
       r.t.start();

       System.out.println("Press Control-C to stop");
   }
}