package com.zlennon.admin.model;

import java.io.Serializable;

public class SysOperation implements Serializable {
    private String id;

    private String odesc;

    private String oname;

    private String oper;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOdesc() {
        return odesc;
    }

    public void setOdesc(String odesc) {
        this.odesc = odesc;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
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
        SysOperation other = (SysOperation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOdesc() == null ? other.getOdesc() == null : this.getOdesc().equals(other.getOdesc()))
            && (this.getOname() == null ? other.getOname() == null : this.getOname().equals(other.getOname()))
            && (this.getOper() == null ? other.getOper() == null : this.getOper().equals(other.getOper()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOdesc() == null) ? 0 : getOdesc().hashCode());
        result = prime * result + ((getOname() == null) ? 0 : getOname().hashCode());
        result = prime * result + ((getOper() == null) ? 0 : getOper().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", odesc=").append(odesc);
        sb.append(", oname=").append(oname);
        sb.append(", oper=").append(oper);
        sb.append("]");
        return sb.toString();
    }
}