package ru.samfort.model;

import javax.persistence.*;

@Entity
@Table(name = "elements")
public class TreeElement {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = 100000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "parent")
    private String parent;
    @Column(name = "text")
    private String text;
    @Column(name = "children")
    private Boolean children;
    @Column(name = "type")
    private String type;

    public TreeElement(String parent, String text, String type, Boolean children) {
        this.parent = parent;
        this.text = text;
        this.type = type;
        this.children = children;
    }

    public TreeElement(Integer id, String parent, String text, Boolean children) {
        this.id = id;
        this.parent = parent;
        this.text = text;
        this.children = children;
    }

    public TreeElement(Integer id, String parent, String text, Boolean children, String type) {
        this.id = id;
        this.parent = parent;
        this.text = text;
        this.children = children;
        this.type = type;
    }

    public TreeElement() {

    }

    public Integer getId() {
        return id;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getChildren() {
        return children;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
