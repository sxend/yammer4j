package yammer4j.opengraph;


public class Object {

    private String url;
    private String type;
    private String title;
    private String image;
    private String description;

    public String getUrl() {
        return this.url;
    }

    public String getType() {
        return this.type;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setType(ObjectType type) {
        this.type = type == null ? null : type.getType();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static enum ObjectType {
        PAGE("page"),
        PLACE("place"),
        PERSON("person"),
        DEPARTMENT("department"),
        TEAM("team"),
        PROJECT("project"),
        FOLDER("folder"),
        DOCUMENT("document"),
        IMAGE("image"),
        AUDIO("audio"),
        VIDEO("video"),
        COMPANY("company");
        private String type;

        private ObjectType(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }
    }
}
