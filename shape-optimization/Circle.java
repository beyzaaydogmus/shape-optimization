import java.util.Scanner;
import java.awt.*;
import javax.swing.JPanel;


public class Circle extends JPanel implements Shape{
	private double areaOfShape;
  	private double perimeterLOfShape;
  	private double angle; //rotate degree
  	private double rotateX; //rotate point
  	private double rotateY; //rotate point
  	private double radius;
  	private double crdX;
  	private double crdY;

  	public Circle(double xValue, double yValue, double _radius){
  		crdX=xValue;
  		crdY=yValue;
  		_radius=radius;
  	}
  	public Circle(double xValue, double yValue){
  		crdX=xValue;
  		crdY=yValue;
  	}
  	public Circle(double _radius){
  		radius=_radius;

  	}
    public Circle(){
      radius=0;
    }
  	public void inpRadius(){
  		System.out.println("enter radius: \n");
  		Scanner input = new Scanner(System.in);
	    radius=input.nextInt();
  	}
  	public void paintComponent( Graphics g ){
		//call paintComponent to ensure the panel displays xorrenctly
		super.paintComponent( g );
    Graphics2D g2d = (Graphics2D)g;
    g2d.setColor(Color.RED);
		draw(g2d);
	  }

  	public void draw(Graphics g){

  		g.fillOval((int)(crdX-radius), (int)(crdY-radius), (int)(2*radius), (int)(2*radius));
  	
    }

  	public double getRadius() {return radius;}
  	public double getcoordx() {return crdX;}
  	public double getcoordy() {return crdY;}
  	public double getAngle() {return angle;}
  	public double getRotateX() {return rotateX;}
  	public double getRotateY() {return rotateY;}
    public double getAreaOfShape() {return areaOfShape;}
    public double getPerimeterOfShape() {return perimeterLOfShape;}

  	public void setCircle(double x, double y, double r){
  		if(x<0 || y<0 || r<0 )	
 			throw new IllegalArgumentException();
   
  		crdX=x;
  		crdY=y;
  		radius=r;
  	}
  	public void setPosition(double newX, double newY, double _angle, double _rotateX, double _rotateY){
  		if(newX<0 || newY<0 || _angle<0 || _rotateX<0 || _rotateY<0)
  			throw new IllegalArgumentException();

  		crdX=newX;
  		crdY=newY;
  		angle=_angle;
  		rotateX=_rotateX;
  		rotateY=_rotateY;


  	} 

  	public double area(){

  		double theArea= 3.14*(radius*radius);
		areaOfShape=theArea;
		return theArea;
  	}
  	public double perimeter(){
  		double thePerimeter= 2*3.14*radius;
  		perimeterLOfShape=thePerimeter;
  		return thePerimeter;
  	}

	public Shape increment(){
		  crdY++;
  		crdX++;
  		Shape shp = new Circle(crdX,crdY);
  		return shp;
	}
	public Shape decrement(){
		  crdY--;
  		crdX--;
  		Shape shp = new Circle(crdX,crdY);
  		return shp;

	}
  public int compareTo(Shape sh) {
    sh = new Circle(crdX,crdY);

      if(this.area() > sh.area()) return 1; 
      if(this.area() < sh.area()) return -1;
      else                   return 0;
       
    }

}