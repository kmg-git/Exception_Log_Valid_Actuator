package com.example.exception_log_valid_actuator.HealthIndicator;

import com.example.exception_log_valid_actuator.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.stereotype.Component;

@Slf4j
@Component("student")
@RequiredArgsConstructor
public class StudentHealthIndicator implements HealthIndicator {

    private final StudentRepository studentRepository;


    @Override
    public @Nullable Health health() {
        try {
            int count = studentRepository.count();

            return Health.up()
                    .withDetail("studentCount", count)
                    .withDetail("storage", "in-memory")
                    .build();

        } catch (Exception e) {
            log.error("학생 저장소 상태를 확인하지 못했습니다", e);
            return Health.down()
                    .withDetail("reason", "학생 저장소에 접근할 수 없습니다")
                    .build();
        }
    }
}
