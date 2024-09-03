package com.spring.jarek;

import com.spring.jarek.abs.Circle;
import com.spring.jarek.abs.Shape;
import com.spring.jarek.abs.Square;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableScheduling
public class JarekApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarekApplication.class, args);
	}
}