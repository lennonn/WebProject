package com.zlennon.admin;

import java.io.Serializable;

/**
 * Created by op.43027 on 2017/5/31 0031.
 */
public class BootstrapTree implements Serializable{
    private String id;//节点id
    private String pId;//父节点pId I必须大写
    private String name;//节点名称
    private String open = "false";//是否展开树节点，默认不展开
    //bootstrap tree 使用
    private String isChild="false";
    private String nodes;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
    public String getIsChild() {
        return isChild;
    }

    public void setIsChild(String isChild) {
        this.isChild = isChild;
    }

    public String getNodes() {
        return nodes;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }
}
