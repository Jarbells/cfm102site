// src/main/java/com/culturafm/site/entities/ProgramImage.java

package com.culturafm.site.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_program_image")
public class ProgramImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @JsonIgnore // Evita loops infinitos ao converter para JSON
    @ManyToOne // MUITAS imagens para UM programa
    @JoinColumn(name = "program_id") // Chave estrangeira na tabela tb_program_image
    private Program program;

    public ProgramImage() {
    }

    public ProgramImage(Long id, String imageUrl, Program program) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.program = program;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    // HashCode e Equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProgramImage other = (ProgramImage) obj;
        return Objects.equals(id, other.id);
    }
}