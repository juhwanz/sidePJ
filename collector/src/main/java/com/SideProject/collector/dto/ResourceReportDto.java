package com.SideProject.collector.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // Lombok을 사용하여 getter, setter, toString, equals, hashCode 메서드를 자동으로 생성
public class ResourceReportDto {

    // Agent 식별자 (socket.gethostname())
    @NotBlank(message = "ID는 필수다.") // null, 공백 검사.
    private String id;

    @NotBlank(message = "TimeStamp는 필수다.")
    private String timestamp;

    @Min(value = 0, message = "CPU는 0이상이여야 한다.") // 범위 제한
    @Max(value = 100, message = "CPU는 100이하여야 한다.")
    private double cpu;

    @Min(value = 0, message = "Memory는 0이상이여야 한다.")
    @Max(value = 100, message = "Memory는 100이하여야 한다.")
    private double memory;

    @Min(value = 0, message = "Disk는 0이상이여야 한다.")
    @Max(value = 100, message = "Disk는 100이하여야 한다.")
    private double disk;
}

// java에서 직렬화/역직렬화할 때 필드명 소문자 기반 일반적.
