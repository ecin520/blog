package com.pytap.blog.model.domain;

import java.io.Serializable;

public class Views implements Serializable {
    private Long id;

    private Long allViews;

    private Long dayViews;

    private Long visNum;

    private Long ipNum;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAllViews() {
        return allViews;
    }

    public void setAllViews(Long allViews) {
        this.allViews = allViews;
    }

    public Long getDayViews() {
        return dayViews;
    }

    public void setDayViews(Long dayViews) {
        this.dayViews = dayViews;
    }

    public Long getVisNum() {
        return visNum;
    }

    public void setVisNum(Long visNum) {
        this.visNum = visNum;
    }

    public Long getIpNum() {
        return ipNum;
    }

    public void setIpNum(Long ipNum) {
        this.ipNum = ipNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", allViews=").append(allViews);
        sb.append(", dayViews=").append(dayViews);
        sb.append(", visNum=").append(visNum);
        sb.append(", ipNum=").append(ipNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}