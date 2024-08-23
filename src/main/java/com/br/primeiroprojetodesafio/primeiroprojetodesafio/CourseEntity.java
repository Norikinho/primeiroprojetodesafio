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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEntity;

    @NotBlank()
    @Length(min=1,max =30)
    private String name;
    
    @NotBlank
    @Length(min=1,max =30)
    private String category;

    @Length(min=1,max =30)
    private String active;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
}

