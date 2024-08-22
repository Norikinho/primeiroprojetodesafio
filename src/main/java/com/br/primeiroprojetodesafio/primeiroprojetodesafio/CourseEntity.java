package com.br.primeiroprojetodesafio.primeiroprojetodesafio;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CourseEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Length(min=6,max =30)
    private String name;

    @Length(min=6,max =30)
    private String category;

    @Length(min=6,max =30)
    private String active;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
}

