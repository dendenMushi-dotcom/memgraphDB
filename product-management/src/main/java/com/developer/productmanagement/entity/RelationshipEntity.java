package com.developer.productmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_memgraph_relationships")
public class RelationshipEntity {
    @Id
    @Column(name = "material_id")
    private String name;

    @Column(name = "bom_hierarchy_id")
    private String bomHierarchyId;

    @Column(name = "bom_hierarchy_nodeid")
    private String bomHierarchyNodeId;

    @Column(name = "valid_to")
    private String validTo;

    @Column(name = "valid_from")
    private String validFrom;

    @Column(name = "bom_hierarchy_nodeid_parent")
    private String getBomHierarchyNodeIdParent;

    @Column(name = "bom_hierarchy_nodeid_level")
    private String getBomHierarchyNodeIdLevel;

    @Column(name = "bom_id")
    private String bomId;

    @Column(name = "parent_material_id")
    private String parentMaterialId;

    @Column(name = "create_relation_script")
    private String creatRelationNode;

    @Column(name = "delete_relation_parent_script")
    private String deleteRelationParent;

    @Column(name = "delete_relation_child_script")
    private String deleteRelationChild;

    public RelationshipEntity(String name, String bomHierarchyId, String bomHierarchyNodeId, String validTo, String validFrom, String getBomHierarchyNodeIdParent, String getBomHierarchyNodeIdLevel, String bomId, String parentMaterialId, String creatRelationNode, String deleteRelationParent, String deleteRelationChild) {
        this.name = name;
        this.bomHierarchyId = bomHierarchyId;
        this.bomHierarchyNodeId = bomHierarchyNodeId;
        this.validTo = validTo;
        this.validFrom = validFrom;
        this.getBomHierarchyNodeIdParent = getBomHierarchyNodeIdParent;
        this.getBomHierarchyNodeIdLevel = getBomHierarchyNodeIdLevel;
        this.bomId = bomId;
        this.parentMaterialId = parentMaterialId;
        this.creatRelationNode = creatRelationNode;
        this.deleteRelationParent = deleteRelationParent;
        this.deleteRelationChild = deleteRelationChild;
    }

    public RelationshipEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBomHierarchyId() {
        return bomHierarchyId;
    }

    public void setBomHierarchyId(String bomHierarchyId) {
        this.bomHierarchyId = bomHierarchyId;
    }

    public String getBomHierarchyNodeId() {
        return bomHierarchyNodeId;
    }

    public void setBomHierarchyNodeId(String bomHierarchyNodeId) {
        this.bomHierarchyNodeId = bomHierarchyNodeId;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getGetBomHierarchyNodeIdParent() {
        return getBomHierarchyNodeIdParent;
    }

    public void setGetBomHierarchyNodeIdParent(String getBomHierarchyNodeIdParent) {
        this.getBomHierarchyNodeIdParent = getBomHierarchyNodeIdParent;
    }

    public String getGetBomHierarchyNodeIdLevel() {
        return getBomHierarchyNodeIdLevel;
    }

    public void setGetBomHierarchyNodeIdLevel(String getBomHierarchyNodeIdLevel) {
        this.getBomHierarchyNodeIdLevel = getBomHierarchyNodeIdLevel;
    }

    public String getBomId() {
        return bomId;
    }

    public void setBomId(String bomId) {
        this.bomId = bomId;
    }

    public String getParentMaterialId() {
        return parentMaterialId;
    }

    public void setParentMaterialId(String parentMaterialId) {
        this.parentMaterialId = parentMaterialId;
    }

    public String getCreatRelationNode() {
        return creatRelationNode;
    }

    public void setCreatRelationNode(String creatRelationNode) {
        this.creatRelationNode = creatRelationNode;
    }

    public String getDeleteRelationParent() {
        return deleteRelationParent;
    }

    public void setDeleteRelationParent(String deleteRelationParent) {
        this.deleteRelationParent = deleteRelationParent;
    }

    public String getDeleteRelationChild() {
        return deleteRelationChild;
    }

    public void setDeleteRelationChild(String deleteRelationChild) {
        this.deleteRelationChild = deleteRelationChild;
    }
}
