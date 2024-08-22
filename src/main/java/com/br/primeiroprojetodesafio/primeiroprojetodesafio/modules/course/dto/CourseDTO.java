package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private String active;
    private String name;
    private String category;
    private UUID id;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}

