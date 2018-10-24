package com.zlennon.admin.model;

import java.io.Serializable;
import java.util.Date;

public class PageView implements Serializable {
    private String id;

    private String viewIp;

    private Date viewDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewIp() {
        return viewIp;
    }

    public void setViewIp(String viewIp) {
        this.viewIp = viewIp;
    }

    public Date getViewDate() {
        return viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PageView other = (PageView) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getViewIp() == null ? other.getViewIp() == null : this.getViewIp().equals(other.getViewIp()))
            && (this.getViewDate() == null ? other.getViewDate() == null : this.getViewDate().equals(other.getViewDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getViewIp() == null) ? 0 : getViewIp().hashCode());
        result = prime * result + ((getViewDate() == null) ? 0 : getViewDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", viewIp=").append(viewIp);
        sb.append(", viewDate=").append(viewDate);
        sb.append("]");
        return sb.toString();
    }
}