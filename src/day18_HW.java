import java.util.InputMismatchException;
import java.util.Scanner;

public class day18_HW {
    public static void main(String[] args) throws InterruptedException {
//        ask user for input data
//        make sure that input is number
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter John's daily: ");
        int johnDaily = scanner.nextInt();
        System.out.println("Enter Adam's daily: ");
        int adamDaily = scanner.nextInt();
        System.out.println("Enter Difference: ");
        int difference = scanner.nextInt();
// check if input is positive number
        if(adamDaily<0 || johnDaily<0 || difference<0){
            System.out.println("Positive numbers only");
        } else {
//            call the method
            System.out.println("minimum number of days for Adam to have solved more tasks/problems than John:" + countDays(johnDaily, adamDaily, difference));
        }
        } catch (InputMismatchException e) {
            System.out.println("Number only");
        }
    }

//    Checking if Adam can surpass John
//    If he can, how many days
    public static int countDays(int johnDaily, int adamDaily, int difference) {
//        check if Adam can solve more task than John to surpass him
        if (adamDaily < johnDaily) {
            System.out.println("Adam cannot surpass John");
            return -1;
        }

//        counting days required for Adam to surpass John
        int johnSolved = johnDaily + difference;
        int adamSolved = adamDaily;
        int days = 1;

        if (johnSolved > adamSolved) {
            do {
                days++;
                johnSolved = johnSolved + johnDaily;
                adamSolved = adamSolved + adamDaily;
            } while (johnSolved >= adamSolved);
        } else return 1;
        return days;
    }
}
