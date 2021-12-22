package com.company;

public class Resume {

    private Long id;
    private String url;
    private String cloudinaryId;

    public Resume() {
    }

    public Resume(Long id, String url, String cloudinaryId) {
        this.id = id;
        this.url = url;
        this.cloudinaryId = cloudinaryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCloudinaryId() {
        return cloudinaryId;
    }

    public void setCloudinaryId(String cloudinaryId) {
        this.cloudinaryId = cloudinaryId;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", cloudinaryId='" + cloudinaryId + '\'' +
                '}';
    }

}
