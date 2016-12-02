package com.example.serviceTest;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.MockApplication;
import com.example.service.UnitService;
import com.example.service.UnitServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockApplication.class)
public class UnitServiceTest {
	
	@Autowired
	UnitServiceImpl unitServiceImpl;
	
	@Test
	public void Calc1(){
		assertThat(unitServiceImpl.Calc(1, 2), is(0));
	}
	
	@Test
	public void Calc2(){
		assertThat(unitServiceImpl.Calc(5, 7), is(12));
	}
}
