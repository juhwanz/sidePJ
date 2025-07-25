package com.SideProject.collector.controller;


import com.SideProject.collector.dto.ResourceReportDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON API응답 컨트롤러
@RequestMapping("/api/resource")
public class ResourceController {

    @PostMapping("/report") //post 요청 수신 핸들러
    public ResponseEntity<String> receiveReport(
            @RequestBody //json -> dto 변환
            @Valid //dto의 유효성 검사
            ResourceReportDto reportDto
    ){
        System.out.println("수신된 시스템 자원 정보 : " + reportDto);
        return ResponseEntity.ok("수신 완료");
    }

}

// agent -> /api/resource/report -> String이 자동으로 DTO 바인딩 -> 유효성 검사 통과 시 -> 로그 출력 및 200 OK 반환
// actuator? 서버 모니터링 도구.
// /actuator/health -> 서버 상태 확인, /actuator/info -> 서버 정보 확인, /actuator/metrics -> 서버 메트릭스 확인