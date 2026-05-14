package com.example.maintenancerequestsystemreal_timemobileapp;

public class HelperClassRequest {
    private String issueTitle;
    private String location;
    private String description;
    private String imageUrl;

    public HelperClassRequest() {
        // Empty constructor for firebase
    }


    public HelperClassRequest(String issueTitle, String location, String description, String imageUrl) {
        this.issueTitle = issueTitle;
        this.location = location;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIssueImage() {
        return imageUrl;
    }

    public void setIssueImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
