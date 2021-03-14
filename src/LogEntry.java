import java.util.Date;

public class LogEntry {
    private String ipAddress; //ip address of the device.
    private Date accessTime;  //date and time of access.
    private String request; //the devices request.
    private int statusCode; //status code the server returns back.
    private int bytesReturned; //size of object returned in bytes.

    //access methods
    public String getIpAddress() {
        return ipAddress;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public String getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public int getBytesReturned() {
        return bytesReturned;
    }

    //constructor
    public LogEntry(String ip, Date time, String req, int status, int bytes) {
        ipAddress = ip;
        accessTime = time;
        request = req;
        statusCode = status;
        bytesReturned = bytes;
    }

    //print the log entries.
    public String toString(){
        return ipAddress + " " + accessTime + " " + request + " " +
                statusCode + " " + bytesReturned;
    }
}

