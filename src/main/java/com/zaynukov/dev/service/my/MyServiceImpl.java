package com.zaynukov.dev.service.my;

import com.zaynukov.dev.annotation.Profiling;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Profiling
public class MyServiceImpl implements MyService {
    private final Random random = new Random();

    @Override
    public void sayAnything() {
        long time = random.nextInt(90) * 10;
        try {
            Thread.sleep(time);
        } catch (InterruptedException ignored) {
        }
    }
}
