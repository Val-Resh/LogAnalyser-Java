import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> choices = new ArrayList<>();
    private static ArrayList<Integer> daysOfMonths = new ArrayList<>();

    public static void Menu() {
        System.out.println("------------------------------------------------------------");
        System.out.println("What would you like to do?" +
                "\n 1. Access all server logs." +
                "\n 2. Number of unique IPs(users)." +
                "\n 3. Check visits on day. " +
                "\n 4. Check visits per IP(users)." +
                "\n 5. IP (user) with most visits." +
                "\n 6. Check date with most visits." +
                "\n 7. Exit.");
        System.out.println("------------------------------------------------------------");
    }

    public static void request(int choice) {
        for (int i = 1; i <= 7; i++) {
            choices.add(i);
        }
        for (int k = 1; k <= 31; k++) {
            daysOfMonths.add(k);
        }

        if (!choices.contains(choice)) {
            System.out.println("Please pick a valid option.");
        }
        switch (choice) {
            case 1:
                LogAnalyser.printAll();
                break;
            case 2:
                LogAnalyser.countUniqueIPs();
                break;
            case 3:
                Scanner user = new Scanner(System.in);
                System.out.println("Which month you like to check?\n" +
                        "Pick either September (type Sep) or March (type Mar)");
                String option = user.nextLine();

                while (!option.equals("Sep") && !option.equals("Mar")) {
                    System.out.println("Please enter a valid option.");
                    String newOption = user.nextLine();
                    option = newOption;
                }
                System.out.println("Pick a day (1 to 31): ");
                int day = user.nextInt();
                while (!daysOfMonths.contains(day)){
                    System.out.println("Please enter a valid day.");
                    int newDay = user.nextInt();
                    day = newDay;
                }
                String date = option + " " + day;
                LogAnalyser.uniqueIPVisitsOnDay(date);
                break;
            case 4:
                System.out.println(LogAnalyser.countVisitsPerIP());
                break;
            case 5:
                LogAnalyser.ipWithMostVisits(LogAnalyser.counts);
                break;
            case 6:
                LogAnalyser.dayWithMostVisits();
                break;
            case 7:
                break;
        }
    }


        public static void main (String[] args){
            LogAnalyser.readFile("logs/weblog1_log");
            LogAnalyser.readFile("logs/weblog2_log");
            LogAnalyser.getCounts();
            Scanner user = new Scanner(System.in);
            Menu();
            int choice = user.nextInt();
            request(choice);
            while (choice != 7){
                Menu();
                int newChoice = user.nextInt();
                choice = newChoice;
                request(choice);
            }

        }
    }

