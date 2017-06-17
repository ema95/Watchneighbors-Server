package models;

/**
 * Class used to manipulate a Log object
 */
public class Log {
    private User user;
    private String logDescription;
    private Report report;
    private String timestamp;

    public Log(User user, Report report, String logDescription) {
        this.user = user;
        this.report = report;
        this.logDescription = logDescription;
    }

    public User getUser() {
        return user;
    }

    public Report getReport() {
        return report;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
