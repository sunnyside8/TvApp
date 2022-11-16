package org.example.model.entity;


import lombok.*;

import java.time.LocalDate;


public class EpisodeEntity {
    private String id;
    private String title;
    private LocalDate releaseDate;
    private String imgUrl;
    private int season;
    private int episode;
    private String description;
    private boolean approved;

  public String getId() {
    return id;
  }

  public EpisodeEntity setId(String id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public EpisodeEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public int getSeason() {
    return season;
  }

  public EpisodeEntity setSeason(int season) {
    this.season = season;
    return this;
  }

  public int getEpisode() {
    return episode;
  }

  public EpisodeEntity setEpisode(int episode) {
    this.episode = episode;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public EpisodeEntity setDescription(String description) {
    this.description = description;
    return this;
  }

  public boolean isApproved() {
    return approved;
  }

  public EpisodeEntity setApproved(boolean approved) {
    this.approved = approved;
    return this;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public EpisodeEntity setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
    return this;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public EpisodeEntity setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }
}
