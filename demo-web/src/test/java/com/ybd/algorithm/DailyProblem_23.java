package com.ybd.algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhongying.demo.util.JacksonUtil;

/**
 *
You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
For example, given the following board:
[[f, f, f, f],
[t, t, f, t],
[f, f, f, f],
[f, f, f, f]]
and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.
*/
public class DailyProblem_23 {


    @Test
    public void test1() {
    	char[][] chars = new char[][]{
    			{'f', 'f', 'f', 'f'},
    			{'t', 't', 'f', 't'},
    			{'f', 'f', 'f', 'f'},
    			{'f', 'f', 'f', 'f'}
    			};
    	Point startPoint  =  new Point(3,0);
    	Point endPoint = new Point(0,0);
    	int maxSteps = 1000;
    	List<Point> stepPoints = new ArrayList<>();
    	stepPoints.add(startPoint);

		for (int i = 0 ; i < maxSteps ; i++) {
			List<Point> points = getNextPoints(startPoint,chars);
			Point newPoint = getMinDistancePoint(points,endPoint,stepPoints);
			startPoint = newPoint;
			if (startPoint.getX() == endPoint.getX() && startPoint.getY() == endPoint.getY()) {
				System.out.println(i + 1 + " steps");
				System.out.println("步骤：" + JacksonUtil.bean2Json(stepPoints));
				break;
			}
			if (i == maxSteps - 1) {
				System.out.println("no found way");
			}
		}
    }
    
    private List<Point> getNextPoints(Point p,char[][] chars) {
    	List<Point> points = new ArrayList<>();
    	int x,y;
    	//上
    	x = p.x - 1;
    	y = p.y;
    	isCorrectPoint(chars, x, y,points);
    	//下
    	x = p.x + 1;
    	y = p.y;
    	isCorrectPoint(chars, x, y,points);
    	//左
    	x = p.x;
    	y = p.y - 1;
    	isCorrectPoint(chars, x, y,points);
    	//右
    	x = p.x;
    	y = p.y + 1;
    	isCorrectPoint(chars, x, y,points);
    	return points;
    } 
    
    private List<Point> isCorrectPoint(char[][] chars,int x, int y,List<Point> points) {
    	Point p = new Point(x,y);
    	if (p.x >= 0 && p.x < chars.length && p.y >= 0 && p.y <chars[0].length) {
    		if (chars[x][y] == 'f') {
    			points.add(p);
    		}
    	}
    	return points;
    }


	/**
	 * 距离p点最近的一个点
	 * @param points
	 * @param p
	 * @return
	 */
	private Point getMinDistancePoint(List<Point> points,Point p,List<Point> stepPoints) {
    	Point px = null;
    	double distance = Double.MAX_VALUE;
		for (int i = 0;i < points.size();i++) {
			double d = Math.sqrt(Math.pow(points.get(i).getX() - p.getX(),2) + Math.pow(points.get(i).getY() - p.getY(),2));
			if (isPointInSteps(stepPoints, points.get(i))) {
				continue;
			}
			if (d <= distance) {
				px = points.get(i);
				distance = d;
				stepPoints.add(px);
			}
		}
		return px;
	}
	
	private boolean isPointInSteps(List<Point> stepPoints,Point p) {
		for (int i = 0; i < stepPoints.size(); i++) {
			if (p.getX() == stepPoints.get(i).getX() && p.getY() == stepPoints.get(i).getY()) {
				return true;
			}
		}
		return false;
	}
}
