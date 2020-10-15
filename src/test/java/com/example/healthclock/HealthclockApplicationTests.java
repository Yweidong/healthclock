package com.example.healthclock;

import com.example.healthclock.utils.TimeTransformationUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthclockApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        long l = TimeTransformationUtils.DateToTimestmp("2020-10-15");
        System.out.println(l);

    }
    @Test
    void test1() {
        System.out.println(TimeTransformationUtils.TomorrowDate());
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(TimeTransformationUtils.SysCurrTime());

    }

    @Test
    void test2() {
        long l = TimeTransformationUtils.SpecTimeToTimestmp(TimeTransformationUtils.SysCurrTime(),"2:30:00");
        System.out.println(l);

    }


}
