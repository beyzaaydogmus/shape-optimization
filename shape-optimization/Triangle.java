import java.util.Scanner;
import java.awt.*;
import javax.swing.JPanel;



public class Triangle extends JPanel implements Shape{
  	private double areaOfShape;
  	private double perimeterLOfShape;
  	private double edge;
  	private double angle; //rotate degree
  	private double rotateX;
  	private double rotateY;
  	private double crdX1;
  	private double crdX2;
  	private double crdY1;
  	private double crdY2;
  	private double crdZ1;
  	private double crdZ2;

	public Triangle(double x1Value, double x2Value,double y1Value,double y2Value,double z1Value,double z2Value,double _edge){
		crdX1=x1Value;
		crdX2=x2Value;
		crdY1=y1Value;
		crdY2=y2Value;
		crdZ1=z1Value;
		crdZ2=z2Value;
		edge=_edge;

  	}
  	public Triangle(double _edge){
  		crdX1=_edge/2;
		crdX2=0;
		crdY1=0;
		crdY2=_edge/2;
		crdZ1=_edge;
		crdZ2=(_edge/2)*Math.sqrt(3);
		edge=_edge;

  	}
  	public Triangle(){
  		edge=0;
  	}

  	public void inpEdge(){
  		System.out.println("enter edge: \n");
  		Scanner input = new Scanner(System.in);
	    edge=input.nextDouble();
	   
	}

	public void paintComponent( Graphics g ){
		//call paintComponent to ensure the panel displays xorrenctly
		super.paintComponent( g );
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.RED);
		draw(g2d);
	}
	public void draw(Graphics g){

		g.fillPolygon(new int[] {(int)(crdX1), (int)(crdY1), (int)(crdZ1)}, 
					  new int[] {(int)(crdX2), (int)(crdY2), (int)(crdZ2)}, 3);
	}

  	public double getEdge() {return edge;}
    public double getX1() {return crdX1;}
    public double getX2() {return crdX2;}
    public double getY1() {return crdY1;}
    public double getY2() {return crdY2;}
    public double getZ1() {return crdZ1;}
    public double getZ2() {return crdZ2;}
    public double getAngle() {return angle;}
    public double getRotateX() {return rotateX;}
    public double getRotateY() {return rotateY;}
    public double getAreaOfShape() {return areaOfShape;}
  	public double getPerimeterOfShape() {return perimeterLOfShape;}

    public double area(){
  		areaOfShape=edge*edge*Math.sqrt(3)/4.0;
  		double are =edge*edge*Math.sqrt(3)/4.0;
  		return are;
  	}

  	public double perimeter(){
  		perimeterLOfShape=3*edge;
  		
  		return 3*edge;
  	}

  	public void setTriangle(double x1, double x2, double y1, double y2, double z1, double z2, double e){
 		if(x1<0 || x2<0 || y1<0 || y2<0 || z1<0 || z2<0 || e<0 )	
 			throw new IllegalArgumentException();
  
		crdX1=x1;
		crdX2=x2;
		crdY1=y1;
		crdY2=y2;
		crdZ1=z1;
		crdZ2=z2;
		edge=e;
  	}
	public void setPosition(double newX1, double newX2, double newY1, double newY2, double newZ1, double newZ2, double _angle, double newX, double newY){
		if(newX1<0 || newX2<0 || newY1<0 || newY2<0 || newZ1<0 || newZ2<0 || _angle<0 || newX<0 || newY<0)
  			throw new IllegalArgumentException();
  
		crdX1=newX1;
		crdX2=newX2;
		crdY1=newY1;
		crdY2=newY2;
		crdZ1=newZ1;
		crdZ2=newZ2;
		angle=_angle;
		rotateX=newX;
		rotateY=newY;

	}
    
  	
	public Shape increment(){
		crdX1++;
		crdX2++;
		crdY1++;
		crdY2++;
		crdZ1++;
		crdZ2++;
		Shape shp = new Triangle(crdX1,crdY2,crdY1,crdY2,crdZ1,crdZ2,edge);
		return shp;
	}

	public Shape decrement(){
		crdX1--;
		crdX2--;
		crdY1--;
		crdY2--;
		crdZ1--;
		crdZ2--;
		Shape shp = new  Triangle(crdX1,crdY2,crdY1,crdY2,crdZ1,crdZ2,edge);
		return shp;
	}

	public int compareTo(Shape sh) {
		sh = new Triangle(edge);

		if(this.area() > sh.area()) return 1; 
	    if(this.area() < sh.area()) return -1;
	    else return 0;
       
    }


}