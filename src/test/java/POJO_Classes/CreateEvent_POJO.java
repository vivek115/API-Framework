package POJO_Classes;

public class CreateEvent_POJO {
    private String title;
    private String subtitle;
    private String details;
    private String eventStartTime;
    private String eventEndTime;
    private String location;
    private Boolean requireAttendeeApproval;
    private Boolean isModerated;
    private Boolean isPostingOpen;
    private Boolean isPublic;
    public String getTitle() {
        return title;
    }
    public CreateEvent_POJO setTitle(String title) {

        this.title = title;
        return this;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public CreateEvent_POJO setSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }
    public String getDetails() {
        return details;
    }
    public CreateEvent_POJO setDetails(String details) {
        this.details = details;
        return this;
    }
    public String getEventStartTime() {
        return eventStartTime;
    }
    public CreateEvent_POJO setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
        return this;
    }
    public String getEventEndTime() {
        return eventEndTime;
    }
    public CreateEvent_POJO setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
        return this;
    }
    public String getLocation() {
        return location;
    }
    public CreateEvent_POJO setLocation(String location) {

        this.location = location;
        return this;
    }
    public Boolean getRequireAttendeeApproval() {
        return requireAttendeeApproval;
    }
    public CreateEvent_POJO setRequireAttendeeApproval(Boolean requireAttendeeApproval) {
        this.requireAttendeeApproval = requireAttendeeApproval;
        return this;
    }
    public Boolean getIsModerated() {
        return isModerated;
    }
    public CreateEvent_POJO setIsModerated(Boolean isModerated) {
        this.isModerated = isModerated;
        return this;
    }
    public Boolean getIsPostingOpen() {
        return isPostingOpen;
    }
    public CreateEvent_POJO setIsPostingOpen(Boolean isPostingOpen) {
        this.isPostingOpen = isPostingOpen;
        return this;
    }
    public Boolean getIsPublic() {
        return isPublic;
    }
    public CreateEvent_POJO setIsPublic(Boolean isPublic) {

        this.isPublic = isPublic;
        return this;
    }

}
