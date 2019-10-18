import java.awt.Graphics;

public abstract class Polygon implements Shape{

	public class Point2D{

		private double _x;
		private double _y;
		private double _angle;
		private double _rotatex;
		private double _rotatey;
		private String color;
	
		public Point2D(){}
		public Point2D(double x, double y){
			_x=x;
			_y=y;
		}
		public Point2D(double x, double y, double angle, double rotatex, double rotatey, String col){
			_x=x;
			_y=y;
			_angle=angle;
			_rotatex=rotatex;
			_rotatey=rotatey;
			color=col;
		}
		public void setxy(double x, double y){ 
			_x = x; 
			_y = y;
		}
		
		public double getx(){ return _x; }
		public double gety(){ return _y; }
		public double getangle(){ return _angle; }
		public double getrotatex(){ return _rotatex; }
		public double getrotatey(){ return _rotatey; }
		public String getcolor(){return color;}
		
		
	}
}