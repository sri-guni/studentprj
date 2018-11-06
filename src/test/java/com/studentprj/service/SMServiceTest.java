package com.studentprj.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SMServiceTest {

	@Autowired( required=true ) SMService service;
	
	@Before
	public void setUp() throws Exception {
		service.saveEntry("1,James,james@gmail.com,111-111-1111,101,Java Essentials,3800,3600,11-05-2018");
		service.saveEntry("2,Jones,jones@gmail.com,222-111-1111,101,Java Essentials,3800,3200,11-09-2018");
	}

	@Test
	public void a_testListCourses() {
		assertEquals(1,service.listCourses().size());
	}

	@Test
	public void b_testListStudents() {
		assertEquals(2,service.listStudents().size());
	}

	@Test(expected = NumberFormatException.class)
	public void c_testTxnFail() {
		service.saveEntry("3,Sam,sam@gmail.com,333-111-1111,101,Java Essentials,3800,3N00,11-09-2018");
	}
	
	@Test
	public void d_postTxnFailChk() {
		assertEquals(2,service.listStudents().size());
	}

}
