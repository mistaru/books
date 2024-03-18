package com.example.demo;

import com.example.demo.rest.Calculator;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyFirstProjectApplicationTests {


	private final Calculator calculator;

	public MyFirstProjectApplicationTests(Calculator calculator) {
		this.calculator = calculator;
	}

	@Test
	public void testAddition() {
		int num1 = 5;
		int num2 = 10;
		int expectedSum = num1 + num2;
		int actualSum = calculator.add(num1, num2);
		assertEquals(expectedSum, actualSum, "Сумма чисел неправильная");
	}

}
