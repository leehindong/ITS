package info.androidhive.navigationdrawer.other.bean;

/**
 * Created by apple on 2016/11/14.
 */

public class BusinessTripBean {
    private String startingDate;
    private String startingTime;
    private String startingPoint;
    private String endingDate;
    private String endingTime;
    private String destination;
    private String trafficMethod;
    private String approveResult;


    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrafficMethod(String trafficMethod) {
        this.trafficMethod = trafficMethod;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getStartingTime() {

        return startingTime;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public String getDestination() {
        return destination;
    }

    public String getTrafficMethod() {
        return trafficMethod;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public String getStartingDate() {
        return startingDate;

    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public BusinessTripBean(String startingDate, String startingTime, String startingPoint, String endingDate, String endingTime, String destination, String trafficMethod, String approveResult) {
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.startingPoint = startingPoint;
        this.endingDate = endingDate;
        this.endingTime = endingTime;
        this.destination = destination;
        this.trafficMethod = trafficMethod;
        this.approveResult = approveResult;
    }
}
