package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileCourseResponseDTO {
    private String active;
    private String name;
    private String category;
}
