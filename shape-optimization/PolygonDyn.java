import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;

public class PolygonDyn extends Polygon{
	protected Point2D arrP[] = new Point2D[200];
	protected int count;
	private double areas;
	private double perimeters;

	public PolygonDyn(){ count=0; }
	public PolygonDyn(Triangle tri){
		areas=tri.getAreaOfShape();
		perimeters=tri.getPerimeterOfShape();
		count=3;
		tri= new Triangle(tri.getEdge());
		Point2D first = new Point2D(tri.getX1(),tri.getX2());
		Point2D second = new Point2D(tri.getY1(),tri.getY2());
		Point2D third = new Point2D(tri.getZ1(),tri.getZ2());

		arrP[0]=first;
		arrP[1]=second;
		arrP[2]=third;
	}
	
	public PolygonDyn(Rectangle rec){ 
		areas=rec.getAreaOfShape();
		perimeters=rec.getPerimeterOfShape();
		count =4;
		rec = new Rectangle(rec.getwidth(),rec.getheight());
		Point2D first = new Point2D(0,0);
		Point2D second = new Point2D(rec.getwidth(),0);
		Point2D third = new Point2D(0,rec.getheight());
		Point2D fourth = new Point2D(rec.getwidth(),rec.getheight());

		arrP[0]=first;
		arrP[1]=second;
		arrP[2]=third;
		arrP[3]=fourth;
	}

	public PolygonDyn(Circle cir){
		areas=cir.getAreaOfShape();
		perimeters=cir.getPerimeterOfShape();
		count= 100;
		
		for(int i=0; i<100; i++){

			Point2D elem = new Point2D( cir.getRadius()+cir.getRadius()*Math.sin((Math.PI/50.0)*i), cir.getRadius()-cir.getRadius()*(Math.cos((Math.PI/50.0)*i)));
			arrP[i]=elem;
		
		}
	}

	public Point2D[] getArr(){ return arrP;}
	public int getcount(){return count;}
	public void setList(Point2D[] _arrP){arrP = _arrP;}
    public void setcount(int _count){count = _count;}

    public void setpositionstri(double x1, double y1, double x2, double y2, double x3, double y3, double angle, double x, double y, String col){
		count=3;
		Point2D first = new Point2D(x1,y1,angle,x,y,"green");
		Point2D second = new Point2D(x2,y2);
		Point2D third = new Point2D(x3,y3);

		arrP[0]=first;
		arrP[1]=second;
		arrP[2]=third;

	}


	public void setpositionsrec(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double angle, double x, double y, String col){
		count=4;
		Point2D first = new Point2D(x1,y1,angle,x,y,"green");
		Point2D second = new Point2D(x2,y2);
		Point2D third = new Point2D(x3,y3);
		Point2D fourth = new Point2D(x4,y4);

		arrP[0]=first;
		arrP[1]=second;
		arrP[2]=third;
		arrP[3]=fourth;

	}

	public void setpositionscir(double arrx[], double arry[], int size,double angle, double x, double y,String col){
		count=100;
		arrP[0]= new Point2D( arrx[0], arry[0],angle,x,y,"green" );

		for(int i=1; i<100; i++){
		
			arrP[i]= new Point2D( arrx[i], arry[i] );
		
		}
	
	}

	public Shape increment(){

		Shape _shp= new PolygonDyn();
		if(count==3){
			Shape shp = new Triangle();
			shp.increment();
			return shp;
		}
		else if(count==4){
			Shape shp = new Rectangle();
			shp.increment();
			return shp;
		}
		else if(count==100){
			Shape shp = new Circle();
			shp.increment();
			return shp;
		}
		else return _shp;
	}
	
	public Shape decrement(){

		Shape _shp= new PolygonDyn();
		if(count==3){
			Shape shp = new Triangle();
			shp.decrement();
			return shp;
		}
		else if(count==4){
			Shape shp = new Rectangle();
			shp.decrement();
			return shp;
		}
		else if(count==100){
			Shape shp = new Circle();
			shp.decrement();
			return shp;
		}
		else return _shp;
	}

    public void draw(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		int xpoints[];
		xpoints= new int[100];
		int ypoints[];
		ypoints= new int[100];
		
		  if(count==100){
		  	for(int i=0; i<100; i++){
		  		
		  		xpoints[i] = (int)(arrP[i].getx());
		  		ypoints[i] = (int)(arrP[i].gety());
		  	}
		  		g2d.fillPolygon( xpoints,ypoints,100 );
		  	for(int i=1; i<100; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrP[i-1].getx()), (int)(arrP[i-1].gety()),
		  				   (int)(arrP[i].getx()), (int)(arrP[i].gety()));
		  	}
		  	g2d.drawLine((int)(arrP[99].getx()), (int)(arrP[99].gety()),
		  				   (int)(arrP[0].getx()), (int)(arrP[0].gety()));

  	
		  }
		  
		  
		  else if(count==3){
		  		g2d.fillPolygon(new int[] {(int)(arrP[0].getx()), (int)(arrP[1].getx()), (int)(arrP[2].getx())}, 
					  		  new int[] {(int)(arrP[0].gety()), (int)(arrP[1].gety()), (int)(arrP[2].gety())}, 3);
				
		  	for(int i=1; i<3; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrP[i-1].getx()), (int)(arrP[i-1].gety()),
		  				   (int)(arrP[i].getx()), (int)(arrP[i].gety()));
		  		
		  	}
		  	g2d.drawLine((int)(arrP[2].getx()), (int)(arrP[2].gety()), (int)(arrP[0].getx()), (int)(arrP[0].gety()));
		  
		  }

		  else if(count==4){
		  	for(int i=0; i<4; i++){
		 
		  		g2d.fillPolygon(new int[] {(int)(arrP[0].getx()), (int)(arrP[1].getx()), (int)(arrP[2].getx()), (int)(arrP[3].getx())}, 
					  		  new int[] {(int)(arrP[0].gety()), (int)(arrP[1].gety()), (int)(arrP[2].gety()), (int)(arrP[3].gety())}, 4);
		  		
		  	}
		  	for(int i=1; i<4; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrP[i-1].getx()), (int)(arrP[i-1].gety()),
		  				   (int)(arrP[i].getx()), (int)(arrP[i].gety()));
		  		
		  	}
		  	g2d.drawLine((int)(arrP[3].getx()), (int)(arrP[3].gety()),
		  			   (int)(arrP[0].getx()), (int)(arrP[0].gety()));

		  }


	}


	public double area(){
  		
  		return areas;
  	}

  	public double perimeter(){
  		return perimeters;
  	}


	public int compareTo(Shape sh) {
		 sh = new PolygonDyn();

		if(this.area() > sh.area()) return 1; 
	    if(this.area() < sh.area()) return -1;
	    else                   return 0;
        
    }

}