package com.hy.demo.algorithm.daily.problem;


import java.util.Arrays;
import java.util.List;

/**
 *
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), 
find the minimum number of rooms required.
For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
*/
public class DailyProblem_21 {


    public void test1() {
    	List<Point> list = Arrays.asList(new Point(30,75),new Point(0,50),
                new Point(0,40),
                new Point(60,150),new Point(0,20));
    	System.out.println("roomCnt = " + getRooms(list));
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

    private int getRooms(List<Point> list) {
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
        return roomCnt;
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
