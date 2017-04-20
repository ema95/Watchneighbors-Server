package utilities;

public class Log {
    private int logId;
    private User user;
    private String logDescription;
    private Report report;

    public Log(int logId, User user, Report report, String logDescription) {
        this.logId = logId;
        this.user = user;
        this.report = report;
        this.logDescription = logDescription;
    }

    public int getLogId() {
        return logId;
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
}
