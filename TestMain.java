package com.makemytrip.test;

import java.util.Calendar;
import java.util.Date;

import javax.swing.text.DateFormatter;

import com.makemytrip.action.homePageAction;

public class TestMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String date="2-Jul-2018";
		homePageAction.selectDepartDate(date);
		
		String str="9,043";
		 str = str.replaceAll(",", "");
		System.out.println(Integer.parseInt(str));
	}

}
