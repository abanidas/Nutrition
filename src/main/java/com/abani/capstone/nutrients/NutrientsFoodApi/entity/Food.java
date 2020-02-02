package com.abani.capstone.nutrients.NutrientsFoodApi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "foods")
    private Set<Nutrients> nutrients = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "nutrient_quantities", joinColumns = {@JoinColumn(name = "food")})
    @Column(name = "quantity")
    @MapKeyJoinColumn(name = "nutrient_id")
    private Map<Long, String> quantityOfNutrients = new HashMap<>();

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "wiki_url")
    private String wikiUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Nutrients> getNutrients() {
        return nutrients;
    }

    public void setNutrients(Set<Nutrients> nutrients) {
        this.nutrients = nutrients;
    }

    public Map<Long, String> getQuantityOfNutrients() {
        return quantityOfNutrients;
    }

    public void setQuantityOfNutrients(Map<Long, String> quantityOfNutrients) {
        this.quantityOfNutrients = quantityOfNutrients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWikiUrl() {
        return wikiUrl;
    }

    public void setWikiUrl(String wikiUrl) {
        this.wikiUrl = wikiUrl;
    }
}
