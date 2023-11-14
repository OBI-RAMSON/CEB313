public class Emergency {
    private String reporterName;  // Name of the person reporting the emergency
    private String reporterPhone;  // Phone number of the person reporting the emergency
    private String location;  // Location details of the emergency
    private String reportTime;  // Time when the emergency was reported
    private String nature;  // Nature of the emergency (e.g., medical, fire, accident)
    private String responseType;  // Type of response required (e.g., ambulance, fire truck, police)
    private String responseStatus;  // Status of the emergency response (e.g., pending, in-progress, resolved)

    public Emergency(String reporterName, String reporterPhone, String location, String reportTime,
                     String nature, String responseType, String responseStatus) {
        this.reporterName = reporterName;
        this.reporterPhone = reporterPhone;
        this.location = location;
        this.reportTime = reportTime;
        this.nature = nature;
        this.responseType = responseType;
        this.responseStatus = responseStatus;
    }


}