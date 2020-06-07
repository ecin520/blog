package com.pytap.blog.model.domain;

import java.io.Serializable;

public class Article implements Serializable {
    private Long id;

    private Long creater;

    private String title;

    private String generalize;

    private String time;

    private String showImage;

    private Integer recommend;

    private Long likes;

    private Long views;

    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeneralize() {
        return generalize;
    }

    public void setGeneralize(String generalize) {
        this.generalize = generalize;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShowImage() {
        return showImage;
    }

    public void setShowImage(String showImage) {
        this.showImage = showImage;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creater=").append(creater);
        sb.append(", title=").append(title);
        sb.append(", generalize=").append(generalize);
        sb.append(", time=").append(time);
        sb.append(", showImage=").append(showImage);
        sb.append(", recommend=").append(recommend);
        sb.append(", likes=").append(likes);
        sb.append(", views=").append(views);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}