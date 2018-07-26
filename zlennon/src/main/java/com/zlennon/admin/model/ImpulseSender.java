package com.zlennon.admin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ImpulseSender implements Serializable {
    private String sequenceName;

    private Date updateDate;

    private String cycleType;

    private BigDecimal currentValue;

    private BigDecimal currentFmtValue;

    private String sequenceRule;

    private BigDecimal sequenceLen;

    private String remark;

    private String usableStatus;

    private Date createTime;

    private String createIp;

    private String createUserId;

    private String createUserName;

    private Date modifyTime;

    private String modifyIp;

    private String modifyUserId;

    private String modifyUserName;

    private Date deleteTime;

    private String deleteIp;

    private String deleteFlag;

    private String deleteUserId;

    private String deleteUserName;

    private String orderCode;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private static final long serialVersionUID = 1L;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }

    public BigDecimal getCurrentFmtValue() {
        return currentFmtValue;
    }

    public void setCurrentFmtValue(BigDecimal currentFmtValue) {
        this.currentFmtValue = currentFmtValue;
    }

    public String getSequenceRule() {
        return sequenceRule;
    }

    public void setSequenceRule(String sequenceRule) {
        this.sequenceRule = sequenceRule;
    }

    public BigDecimal getSequenceLen() {
        return sequenceLen;
    }

    public void setSequenceLen(BigDecimal sequenceLen) {
        this.sequenceLen = sequenceLen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsableStatus() {
        return usableStatus;
    }

    public void setUsableStatus(String usableStatus) {
        this.usableStatus = usableStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyIp() {
        return modifyIp;
    }

    public void setModifyIp(String modifyIp) {
        this.modifyIp = modifyIp;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDeleteIp() {
        return deleteIp;
    }

    public void setDeleteIp(String deleteIp) {
        this.deleteIp = deleteIp;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteUserId() {
        return deleteUserId;
    }

    public void setDeleteUserId(String deleteUserId) {
        this.deleteUserId = deleteUserId;
    }

    public String getDeleteUserName() {
        return deleteUserName;
    }

    public void setDeleteUserName(String deleteUserName) {
        this.deleteUserName = deleteUserName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
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
        ImpulseSender other = (ImpulseSender) that;
        return (this.getSequenceName() == null ? other.getSequenceName() == null : this.getSequenceName().equals(other.getSequenceName()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getCycleType() == null ? other.getCycleType() == null : this.getCycleType().equals(other.getCycleType()))
            && (this.getCurrentValue() == null ? other.getCurrentValue() == null : this.getCurrentValue().equals(other.getCurrentValue()))
            && (this.getCurrentFmtValue() == null ? other.getCurrentFmtValue() == null : this.getCurrentFmtValue().equals(other.getCurrentFmtValue()))
            && (this.getSequenceRule() == null ? other.getSequenceRule() == null : this.getSequenceRule().equals(other.getSequenceRule()))
            && (this.getSequenceLen() == null ? other.getSequenceLen() == null : this.getSequenceLen().equals(other.getSequenceLen()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUsableStatus() == null ? other.getUsableStatus() == null : this.getUsableStatus().equals(other.getUsableStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateIp() == null ? other.getCreateIp() == null : this.getCreateIp().equals(other.getCreateIp()))
            && (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
            && (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getModifyIp() == null ? other.getModifyIp() == null : this.getModifyIp().equals(other.getModifyIp()))
            && (this.getModifyUserId() == null ? other.getModifyUserId() == null : this.getModifyUserId().equals(other.getModifyUserId()))
            && (this.getModifyUserName() == null ? other.getModifyUserName() == null : this.getModifyUserName().equals(other.getModifyUserName()))
            && (this.getDeleteTime() == null ? other.getDeleteTime() == null : this.getDeleteTime().equals(other.getDeleteTime()))
            && (this.getDeleteIp() == null ? other.getDeleteIp() == null : this.getDeleteIp().equals(other.getDeleteIp()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()))
            && (this.getDeleteUserId() == null ? other.getDeleteUserId() == null : this.getDeleteUserId().equals(other.getDeleteUserId()))
            && (this.getDeleteUserName() == null ? other.getDeleteUserName() == null : this.getDeleteUserName().equals(other.getDeleteUserName()))
            && (this.getOrderCode() == null ? other.getOrderCode() == null : this.getOrderCode().equals(other.getOrderCode()))
            && (this.getAttribute1() == null ? other.getAttribute1() == null : this.getAttribute1().equals(other.getAttribute1()))
            && (this.getAttribute2() == null ? other.getAttribute2() == null : this.getAttribute2().equals(other.getAttribute2()))
            && (this.getAttribute3() == null ? other.getAttribute3() == null : this.getAttribute3().equals(other.getAttribute3()))
            && (this.getAttribute4() == null ? other.getAttribute4() == null : this.getAttribute4().equals(other.getAttribute4()))
            && (this.getAttribute5() == null ? other.getAttribute5() == null : this.getAttribute5().equals(other.getAttribute5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSequenceName() == null) ? 0 : getSequenceName().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getCycleType() == null) ? 0 : getCycleType().hashCode());
        result = prime * result + ((getCurrentValue() == null) ? 0 : getCurrentValue().hashCode());
        result = prime * result + ((getCurrentFmtValue() == null) ? 0 : getCurrentFmtValue().hashCode());
        result = prime * result + ((getSequenceRule() == null) ? 0 : getSequenceRule().hashCode());
        result = prime * result + ((getSequenceLen() == null) ? 0 : getSequenceLen().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUsableStatus() == null) ? 0 : getUsableStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateIp() == null) ? 0 : getCreateIp().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getModifyIp() == null) ? 0 : getModifyIp().hashCode());
        result = prime * result + ((getModifyUserId() == null) ? 0 : getModifyUserId().hashCode());
        result = prime * result + ((getModifyUserName() == null) ? 0 : getModifyUserName().hashCode());
        result = prime * result + ((getDeleteTime() == null) ? 0 : getDeleteTime().hashCode());
        result = prime * result + ((getDeleteIp() == null) ? 0 : getDeleteIp().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        result = prime * result + ((getDeleteUserId() == null) ? 0 : getDeleteUserId().hashCode());
        result = prime * result + ((getDeleteUserName() == null) ? 0 : getDeleteUserName().hashCode());
        result = prime * result + ((getOrderCode() == null) ? 0 : getOrderCode().hashCode());
        result = prime * result + ((getAttribute1() == null) ? 0 : getAttribute1().hashCode());
        result = prime * result + ((getAttribute2() == null) ? 0 : getAttribute2().hashCode());
        result = prime * result + ((getAttribute3() == null) ? 0 : getAttribute3().hashCode());
        result = prime * result + ((getAttribute4() == null) ? 0 : getAttribute4().hashCode());
        result = prime * result + ((getAttribute5() == null) ? 0 : getAttribute5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sequenceName=").append(sequenceName);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", cycleType=").append(cycleType);
        sb.append(", currentValue=").append(currentValue);
        sb.append(", currentFmtValue=").append(currentFmtValue);
        sb.append(", sequenceRule=").append(sequenceRule);
        sb.append(", sequenceLen=").append(sequenceLen);
        sb.append(", remark=").append(remark);
        sb.append(", usableStatus=").append(usableStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", createIp=").append(createIp);
        sb.append(", createUserId=").append(createUserId);
        sb.append(", createUserName=").append(createUserName);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", modifyIp=").append(modifyIp);
        sb.append(", modifyUserId=").append(modifyUserId);
        sb.append(", modifyUserName=").append(modifyUserName);
        sb.append(", deleteTime=").append(deleteTime);
        sb.append(", deleteIp=").append(deleteIp);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", deleteUserId=").append(deleteUserId);
        sb.append(", deleteUserName=").append(deleteUserName);
        sb.append(", orderCode=").append(orderCode);
        sb.append(", attribute1=").append(attribute1);
        sb.append(", attribute2=").append(attribute2);
        sb.append(", attribute3=").append(attribute3);
        sb.append(", attribute4=").append(attribute4);
        sb.append(", attribute5=").append(attribute5);
        sb.append("]");
        return sb.toString();
    }
}