# Log Analyser in Java.
## This program allows the user to obtain information from a server log. 
The main menu includes the following options:
 1. Access all server logs.
 1. Number of unique IPs(users).
 1. Check visits on day. 
 1. Check visits per IP(users).
 1. IP (user) with most visits.
 1. Check date with most visits.
 1. Exit.
 
 ## Access all server logs.
 Prints out all the logs with the following information:
 1. IP address of the device.
 1. Date and time of access.
 1. The device request code.
 1. The status code the server returned back.
 1. Size of the return in bytes.
 
 Here's an example of a log: <br>
 *66.249.88.19 Wed Sep 30 14:53:21 BST 2015 GET /tutorial/fa/dfa2mindfa/images/finishedexpansions HTTP/1.1 200 9217*
 
 ## Number of unique IPs (users).
 This prints out each unique IP address, in other words non-repetitive, and provides a total number at the end. 
 
 ## Check visits on day.
 This checks who's visited the website on a set date that you can choose. It returns the IP addresses of the visitors on that date.
 It's **important** to note that you should use the format MMM DD (eg. Mar 30). The server log provided is for the months of September and March but do not contain
 every single day of the month. If you try to get days for Jan it will ask you put a valid option. I'd recommend checking the Sep 30 or Mar 15 to try it out.
 
 ## Check visits per IP (users).
 Shows the amount of visits for each IP device. 
 
 ## IP (user) with most visits.
 This shows the IP(user) that has visited the website the most out of all logs.
 
 ## Check date with most visits.
 This provides the date that had the most amount of visitors. 
 
 ## Exit.
 Choose once you wish to exit the program. 
