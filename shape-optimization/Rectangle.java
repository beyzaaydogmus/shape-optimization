import java.util.Scanner;
import java.awt.*;
import javax.swing.JPanel;



public class Rectangle extends JPanel implements Shape{
	private double areaOfShape;
  	private double perimeterLOfShape;
  	private double width;
  	private double height;
  	private double crdX;
  	private double crdY;

	public Rectangle(double xValue, double yValue, double _width, double _height){
		crdX=xValue;
		crdY=yValue;
		width=_width;
		height=_height;
	}
  	public Rectangle(double _width, double _height){

		width=_width;
		height=_height;
  	}
  	public Rectangle(){
  		width=0;
  		height=0;
  	}
	public void inpDimensions(){
		System.out.println("enter width: \n");
  		Scanner input = new Scanner(System.in);
	    width=input.nextInt();
	    System.out.println("enter height: \n");
	    height=input.nextInt();
	}

	public void paintComponent( Graphics g ){
		//call paintComponent to ensure the panel displays xorrenctly
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent( g );
		g2d.setColor(Color.RED);
		draw(g2d);
	}
	public void draw(Graphics g){
		g.fillRect((int)crdX, (int)crdY, (int)width, (int)height);
	}

  	public double getheight() {return height;}
  	public double getwidth() {return width;}
  	public double getcoordx() {return crdX;}
  	public double getcoordy() {return crdY;}

  	public double area(){	
		areaOfShape = width*height;
		return getAreaOfShape();	
	}
	public double perimeter(){	
		perimeterLOfShape = 2*(width+height);
		return getPerimeterOfShape();	

	}  	

	public void setRectangle(double x, double y, double w, double h){
		if(x<0 || y<0 || w<0 || h<0)	
 			throw new IllegalArgumentException();

		crdX=x;
		crdY=y;
		width=w;
		height=h;
	}
  	public void setPosition(double newX, double newY, double newwidth, double newheight){
  		if(newX<0 || newY<0 || newwidth<0 || newheight<0)	
 			throw new IllegalArgumentException();

  		crdX=newX;
		crdY=newY;
		height=newheight;
		width=newwidth;
  	}

	
  	public double getAreaOfShape() {return areaOfShape;}
  	public double getPerimeterOfShape() {return perimeterLOfShape;}


	public Shape increment(){
		crdY++;
		crdX++;
		Shape shp = new Rectangle(crdX,crdY);
		return shp;
	}
	public Shape decrement(){
		crdY--;
		crdX--;
		Shape shp = new Rectangle(crdX,crdY);
		return shp;
	}

	public int compareTo(Shape sh) {
		sh = new Rectangle(crdX,crdY);

		if(this.area() > sh.area()) return 1; 
	    if(this.area() < sh.area()) return -1;
	    else                   return 0;
       
    }

	

}