package com.cognizant.orm_learn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles; // Import for ActiveProfiles

@SpringBootTest
@ActiveProfiles("test") // Add this line if you have a test profile
class OrmLearnApplicationTests {

    @Test
    void contextLoads() {
        // This test simply checks if the Spring application context loads successfully.
        // If the context fails to load, this test will fail.
    }

}