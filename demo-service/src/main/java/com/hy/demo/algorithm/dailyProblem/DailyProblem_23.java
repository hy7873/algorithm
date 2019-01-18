package com.hy.demo.algorithm.dailyProblem;


import java.awt.*;
import java.util.*;
import java.util.List;

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


    public void test1() {
    	char[][] board = new char[][]{
    			{'f', 'f', 'f', 'f'},
    			{'t', 't', 'f', 't'},
    			{'f', 'f', 'f', 'f'},
    			{'f', 'f', 'f', 'f'}
    			};
    	Point startPoint  =  new Point(3,0);
    	Point endPoint = new Point(0,0);
    	int i = shortestPath(board,startPoint,endPoint);
		System.out.println(i);
		/*[java.awt.Point[x=2,y=0], java.awt.Point[x=2,y=1], java.awt.Point[x=2,y=2],
		java.awt.Point[x=3,y=3], java.awt.Point[x=1,y=2], java.awt.Point[x=0,y=2],
		java.awt.Point[x=0,y=1], java.awt.Point[x=3,y=0], java.awt.Point[x=3,y=1],
		java.awt.Point[x=3,y=2], java.awt.Point[x=2,y=3], java.awt.Point[x=0,y=3]]*/
		//System.out.println(getNextPoints(startPoint,board));

	}
    
    private List<Point> getNextPoints(Point p, char[][] chars, Point start) {
    	List<Point> points = new ArrayList<>();
    	int x,y;
    	//上
    	x = p.x - 1;
    	y = p.y;
    	Point p1 = new Point(x,y);
    	isCorrectPoint(chars,p1,points);
    	//下
    	x = p.x + 1;
    	y = p.y;
		Point p2 = new Point(x,y);
    	isCorrectPoint(chars,p2,points);
    	//左
    	x = p.x;
    	y = p.y - 1;
		Point p3 = new Point(x,y);
    	isCorrectPoint(chars,p3,points);
    	//右
    	x = p.x;
    	y = p.y + 1;
		Point p4 = new Point(x,y);
    	isCorrectPoint(chars,p4,points);

		int h = Math.abs(points.get(0).y - start.y);
		for (Iterator<Point> iterator = points.iterator();iterator.hasNext();) {
			if (Math.abs(iterator.next().y - start.y) < h) {
				iterator.remove();
			}
		}
		System.out.println("now : " + p + "  ----  next:" + points);
		return points;
    } 
    
    private List<Point> isCorrectPoint(char[][] chars,Point p,List<Point> points) {
    	if (p.x >= 0 && p.x < chars.length && p.y >= 0 && p.y <chars[0].length) {
    		if (chars[p.x][p.y] == 'f') {
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


	private int shortestPath(char[][] board,Point start,Point end) {
		Set<Point> seen = new HashSet<>();
		Deque<Point> deque = new ArrayDeque<>(Arrays.asList(start));

		Iterator<Point> iterator = deque.iterator();
		int count = 0;
		while (iterator.hasNext()) {
			count++;
			System.out.println(deque);
			Point coords = deque.pollFirst();
			if (coords.equals(end)) {
				return count;
			}
			seen.add(coords);
			List<Point> points = getNextPoints(coords,board,start);


			for (Point pointItem : points) {
				if (!seen.contains(pointItem)) {
					deque.addFirst(pointItem);
				}

			}

			//System.out.println(seen);
		}
		return 0;
	}



	public void test2() {
		System.out.println(new Point(0,1000).hashCode());
		Set<Point> seen = new HashSet<>(Arrays.asList(new Point(0,1),new Point(0,1000)));
		System.out.println(seen.contains(new Point(0,1000)));
		System.out.println(new Point(0,1000).hashCode());
	}


}
