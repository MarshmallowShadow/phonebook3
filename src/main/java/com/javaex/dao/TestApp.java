package com.javaex.dao;

import com.javaex.vo.*;
import java.util.*;

public class TestApp {
	public static void main(String[] args) {
		PhoneDao pDao = new PhoneDao();
		
		List<PersonVo> pList = pDao.personSelect();
		
		System.out.println(pList);
	}
}
