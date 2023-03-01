package com.developer.productmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_memgraph_components_1")
public class ComponentEntity {

    @Id
    @Column(name = "sdp_matnr")
    private String name;

    @Column(name = "create_node_script")
    private String createNode;

    @Column(name = "delete_node_script")
    private String deleteNode;

    public ComponentEntity(){
    }

    public ComponentEntity(String name, String createNode, String deleteNode) {
        this.name = name;
        this.createNode = createNode;
        this.deleteNode = deleteNode;
    }

    public String getSdpMatnr() {
        return name;
    }

    public void setSdpMatnr(String name) {
        this.name = name;
    }

    public String getCreateNode() {
        return createNode;
    }

    public void setCreateNode(String createNode) {
        this.createNode = createNode;
    }

    public String getDeleteNode() {
        return deleteNode;
    }

    public void setDeleteNode(String deleteNode) {
        this.deleteNode = deleteNode;
    }

}
