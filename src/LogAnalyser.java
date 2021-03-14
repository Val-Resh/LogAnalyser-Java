import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LogAnalyser {
    private static ArrayList<LogEntry> records = new ArrayList<>();
    private static ArrayList<String> uniqueIPs = new ArrayList<>();
    public static HashMap<String, Integer> counts = new HashMap<>();

    public static void readFile(String filename) {
        try {
            //initialise file and scanner.
            File weblog = new File(filename);
            Scanner read = new Scanner(weblog);
            //iterate over all lines and adds them to records.
            while (read.hasNextLine()) {
                String newLine = read.nextLine();
                //adding weblogs to the arraylist.
                records.add(WebLogParser.parseEntry(newLine));
            }
            read.close();
        }
        //catch the error if occurs.
        catch (FileNotFoundException e) {
            System.out.println("An error occurred:");
            e.printStackTrace();
        }
    }

    //print all logs.
    public static void printAll() {
        for (LogEntry x : records) {
            System.out.println(x);
        }
    }

    //counting the unique IPs.
    public static void countUniqueIPs() {
        //iterate each in records
        for (LogEntry x : records) {
            //get the IP address
            String ipAddress = x.getIpAddress();
            //if IP address not already in arraylist, add it.
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }
        for (String x : uniqueIPs){
            System.out.println(x);
        }
        System.out.println("Total of unique IPs: " + uniqueIPs.size());
    }

    //the format for date must be "MMM DD" eg. Mar 15 or Sep 14.
    //This is because that's the format used for the logs provided.
    public static void uniqueIPVisitsOnDay(String date) {
        ArrayList<String> visitDayIP = new ArrayList<>();
        //iterate through each
        for (LogEntry x : records) {
            //current day gets updated with each iteration.
            String currentDay = x.getAccessTime().toString();
            //add the IP address if it matches date and it isn't already there.
            if (currentDay.contains(date)) {
                if (!visitDayIP.contains(x.getIpAddress())) {
                    visitDayIP.add(x.getIpAddress());
                }
            }
        }
        //print if none found.
        if (visitDayIP.size() < 1) {
            System.out.println("No IPs found for " + date + ".");
        }
        //print all the IP visit on day.
        for (String x : visitDayIP) {
            System.out.println(x);
        }
    }

    //method to run with countVisitsPerIP
    public static void getCounts() {
        for (LogEntry x : records) {
            //initialise the ip address
            String ipAddress = x.getIpAddress();
            //checking whether the ipAddress is already in HashMap.
            if (!counts.containsKey(ipAddress)) {
                //if ipAddress not in HashMap adding it with count 1.
                counts.put(ipAddress, 1);
            } else {
                //if ipAddress already in hashmap I'm adding +1 to the count.
                counts.put(ipAddress, counts.get(ipAddress) + 1);
            }
        }
    }

    //how many times each IP visited website.
    public static HashMap<String, Integer> countVisitsPerIP() {
        return counts;
    }

    //check the ip addresses with most visits on website.
    public static void ipWithMostVisits(HashMap<String, Integer> counts) {
        //get the max value from the counts.
        int maxValue = (Collections.max(counts.values()));
        //iterate through Hashmaps.
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                //prints the keys with max value.
                System.out.println(entry.getKey());
            }
        }
    }

    //which day has the most visits.
    public static void dayWithMostVisits() {
        //creating a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        //iterating through logs
        for (LogEntry x : records) {
            //initialise day
            String dayX = x.getAccessTime().toString();
            //if the map doesn't have dayX then iterate again with an arraylist that is
            //replaced with each iteration.
            if (!map.containsKey(dayX)) {
                ArrayList<String> ipAddresses = new ArrayList<>();
                for (LogEntry y : records) {
                    //initialise dayY for each log and compare it to dayX.
                    String dayY = y.getAccessTime().toString();
                    if (dayX.equals(dayY)) {
                        //add the ip addresses to the list for that day.
                        ipAddresses.add(y.getIpAddress());
                    }
                    //adding the size of the lists to the hashmap for each day
                    map.put(dayX, ipAddresses.size());
                }
            }
        }
        //finding the day with the most visits and printing it out.
        ipWithMostVisits(map);
    }
}

