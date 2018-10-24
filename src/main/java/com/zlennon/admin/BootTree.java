package com.zlennon.admin;


import java.io.Serializable;
import java.util.List;

/**
 * Created by op.43027 on 2017/5/31 0031.
 */
public class BootTree implements Serializable{
    private String id;//节点id
    private String parentId;//父节点pId I必须大写
    private String text;//节点名称
    private String open = "false";//是否展开树节点，默认不展开
    private boolean expanded= true;
    private List<BootTree> nodes;
    private boolean isChild;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<BootTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<BootTree> nodes) {
        this.nodes = nodes;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
