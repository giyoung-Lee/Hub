import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        while(true) {
            int M = scan.nextInt();
            int F = scan.nextInt();

            if(M == 0 && F == 0) {
                break;
            }

            System.out.println(M+F);
        }
    }
}