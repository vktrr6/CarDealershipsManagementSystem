public class TestDrive {

    private int id;
    private String clientName;
    private Car car;
    private Dealership dealership;
    private String date;
    private String startTime;
    private String endTime;

    public TestDrive(int id, String clientName, Car car, Dealership dealership, String date, String startTime, String endTime) {
        this.id = id;
        this.clientName = clientName;
        this.car = car;
        this.dealership = dealership;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}