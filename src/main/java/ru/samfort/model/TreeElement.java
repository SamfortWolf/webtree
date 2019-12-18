package ru.samfort.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class TreeElement {
    @JsonProperty("id")
    private String id;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("text")
    private String text;
    @JsonProperty("children")
    private Boolean children;
    @JsonProperty("type")
    private String type;

    public TreeElement(String id, String parent, String text) {
        this.id = id;
        this.parent = parent;
        this.text = text;
    }

    public TreeElement(String id, String parent, String text, Boolean children) {
        this.id = id;
        this.parent = parent;
        this.text = text;
        this.children = children;
    }

    public TreeElement(String id, String parent, String text, Boolean children, String type) {
        this.id = id;
        this.parent = parent;
        this.text = text;
        this.children = children;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }
}
