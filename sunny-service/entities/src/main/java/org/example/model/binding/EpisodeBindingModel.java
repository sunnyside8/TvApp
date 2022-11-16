package org.example.model.binding;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class EpisodeBindingModel {

    @NotBlank(message = "Please enter title")
    @Size(min = 1,max = 60,message = "Title must be between 1 and 60 symbols.")
    private String title;
    @NotBlank(message = "Please enter img url")
    private String imgUrl;
    @Range(min = 0,max = 50,message = "Seasons number can be between 0 and 50")
    @Positive(message = "Please enter a season number")
    private int season;
    @Range(min = 0,max = 150,message = "Episode number can be between 0 and 50")
    @Positive(message = "Please enter a episode positive number")
    private int episode;
    @NotBlank(message = "Please enter description")
    @Size(min = 5,max = 300,message = "Description must be between 5 and 300 symbols.")
    private String description;
    @PastOrPresent(message = "Please enter a date in the past")
    private LocalDate releaseDate;

    public String getTitle() {
        return title;
    }

    public EpisodeBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public EpisodeBindingModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public int getSeason() {
        return season;
    }

    public EpisodeBindingModel setSeason(int season) {
        this.season = season;
        return this;
    }

    public int getEpisode() {
        return episode;
    }

    public EpisodeBindingModel setEpisode(int episode) {
        this.episode = episode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public EpisodeBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public EpisodeBindingModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }
}
