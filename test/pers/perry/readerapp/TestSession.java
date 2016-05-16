package pers.perry.readerapp;

import org.junit.Test;

import pers.perry.readerapp.util.DBHelper;

public class TestSession {

	public TestSession() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testGetCurrentSession() {
		DBHelper.getCurrentSession();
	}

}
