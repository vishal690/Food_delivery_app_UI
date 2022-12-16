package eu.tutorials.food_delivery_app.Domain;

public class CategaryDomain {
    private String title;
    private String pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public CategaryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }
}
