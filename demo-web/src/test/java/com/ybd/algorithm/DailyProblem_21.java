package com.ybd.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 *
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), 
find the minimum number of rooms required.
For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/
public class DailyProblem_21 {


    @Test
    public void test1() {
    	Point point1 = new Point(30,75);
    	Point point2 = new Point(0,50);
    	Point point3 = new Point(60,150);
        Point point4 = new Point(0,20);
    	List<Point> list = new ArrayList<>();
    	list.add(point1);list.add(point2);list.add(point3);list.add(point4);
		int roomCnt = 1;
		Point p1,p2;
    	for (int i = 1; i < list.size(); i++) {
    	    boolean needNewRoom = true;
    		p2 = list.get(i);
			for (int j = i - 1; j >= 0;j--) {
				p1 = list.get(j);
				if (!isMatchCrack(p1,p2)) {
					needNewRoom = false;
				}
			}
			if (needNewRoom) {
			    roomCnt++;
            }
		}
    	System.out.println("roomCnt = " + roomCnt);
    }
    
    class Point {
    	
    	private int x;
    	
    	private int y;
    	
    	Point(int x,int y) {
    		this.x = x;
    		this.y = y;
    	}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x +"," + y + ")";
		}
    	
    }

    private boolean isMatchCrack(Point p1,Point p2) {
    	boolean b = false;
		if (p2.getY() > p1.getX() && p2.getY() <= p1.getY()) {
			b = true;
		}
		if (p2.getX() >= p1.getX() && p2.getY() <= p1.getY()) {
			b = true;
		}
		if (p2.getX() < p1.getY() && p2.getY() > p1.getY()) {
			b = true;
		}
    	return b;
	}

}
