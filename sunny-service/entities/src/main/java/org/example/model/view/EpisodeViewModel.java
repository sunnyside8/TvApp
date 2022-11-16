package org.example.model.view;

public class EpisodeViewModel {

    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public EpisodeViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EpisodeViewModel setTitle(String title) {
        this.title = title;
        return this;
    }
}
