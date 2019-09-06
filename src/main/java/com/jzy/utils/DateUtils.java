package com.jzy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	// date ����  Calendar ����
	public static int getAge(Calendar birth) {
		//��ǰ���ڵ����
		Calendar now = formateDateToCalendar(new Date());
		int j = now.get(Calendar.YEAR);
		//�������
		int i = birth.get(Calendar.YEAR);
		return j - i;
	}
	
	public static int getAge(Date birth) {
		//��ǰ�����
		Calendar now = formateDateToCalendar(new Date());
		int j = now.get(Calendar.YEAR);
		//�������
		Calendar calendar = formateDateToCalendar(birth);
		int i = calendar.get(Calendar.YEAR);
		return j - i;
	}
	public static int getAge(String birth) {
		//��ǰ�����
		Calendar now = formateDateToCalendar(new Date());
		int j = now.get(Calendar.YEAR);
		//�������
		Date date = formateStringToDate(birth);
		Calendar calendar = formateDateToCalendar(date);
		int i = calendar.get(Calendar.YEAR);
		return j - i;
	}
	
	public static Calendar formateDateToCalendar(Date date) {
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		return instance;
	}
	
	public static Date formateStringToDate(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static Date formateStringToDateAll(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			date = dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static int getFutureDays(String future) {
		
		Date date = new Date();
		long time = date.getTime();
		
		Date formateStringToDate = formateStringToDate(future);
		long time2 = formateStringToDate.getTime();
		
		long dt = time2 - time ;
		
		int day = (int) (dt/1000/60/60/24);
		return day;
	}
	/**
	 * �жϸ��������Ƿ��ǵ���
	 * @param str
	 * @return
	 */
	public static boolean isToday(String str) {
		/*
		 * ��ȡ���ڵ��� �� ��
		 * Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.get(Calendar.YEAR);
		instance.get(Calendar.MONTH);
		instance.get(Calendar.DAY_OF_MONTH);*/
		
		int futureDays = getFutureDays(str);
		if(futureDays==0) {
			return true;
		}
		return false;
	}
	/**
	 * �жϵ�ǰ�����������Ƿ��ڱ���֮��
	 * @return
	 */
	public static boolean isDayInWeek(String date) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		Date stringToDate = formateStringToDate(date);
		Calendar dateToCalendar = formateDateToCalendar(stringToDate);
		int year1 = dateToCalendar.get(Calendar.YEAR);
		int month1 = dateToCalendar.get(Calendar.MONTH);
		int dayOfWeek1 = dateToCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		if(year==year1&&month==month1&&dayOfWeek==dayOfWeek1) {
			return true;
		}
		return false;
	}
	
	/***
	 * ����ʱ����󣬳�ʼ�����������1��1��0ʱ0��0��0����
	 */
	public static void  setInitDate(String str) {
		Date stringToDate = formateStringToDate(str);
		Calendar dateToCalendar = formateDateToCalendar(stringToDate);
		dateToCalendar.set(Calendar.MONTH, 1);
		dateToCalendar.set(Calendar.DAY_OF_YEAR, 1);
		dateToCalendar.set(Calendar.HOUR, 0);
		dateToCalendar.set(Calendar.MINUTE, 0);
		dateToCalendar.set(Calendar.SECOND, 0);
		dateToCalendar.set(Calendar.MILLISECOND, 0);
		
		System.out.println(dateToCalendar.getTime());
		
	}

}
