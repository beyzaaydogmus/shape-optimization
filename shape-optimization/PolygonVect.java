import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PolygonVect extends Polygon{
	protected ArrayList<Point2D> arrL = new ArrayList<Point2D>();
	protected int count;
	private double areas;
	private double perimeters;

	public PolygonVect(){ count=0; }
	public PolygonVect(Triangle tri){
		areas=tri.getAreaOfShape();
		perimeters=tri.getPerimeterOfShape();
		count=3;
		tri= new Triangle(tri.getEdge());
		Point2D first = new Point2D(tri.getX1(),tri.getX2());
		Point2D second = new Point2D(tri.getY1(),tri.getY2());
		Point2D third = new Point2D(tri.getZ1(),tri.getZ2());

		arrL.add(first);
		arrL.add(second);
		arrL.add(third);
	}
	
	public PolygonVect(Rectangle rec){ 
		areas=rec.getAreaOfShape();
		perimeters=rec.getPerimeterOfShape();
		count =4;
		rec = new Rectangle(rec.getwidth(),rec.getheight());
		Point2D first = new Point2D(0,0);
		Point2D second = new Point2D(rec.getwidth(),0);
		Point2D third = new Point2D(0,rec.getheight());
		Point2D fourth = new Point2D(rec.getwidth(),rec.getheight());

		arrL.add(first);
		arrL.add(second);
		arrL.add(third);
		arrL.add(fourth);
	}

	public PolygonVect(Circle cir){
		areas=cir.getAreaOfShape();
		perimeters=cir.getPerimeterOfShape();
		count= 100;
		for(int i=0; i<100; i++){

			Point2D elem = new Point2D( cir.getRadius()+cir.getRadius()*Math.sin((Math.PI/50.0)*i), cir.getRadius()-cir.getRadius()*(Math.cos((Math.PI/50.0)*i)));
			arrL.add(elem);
		
		}
	}

	public ArrayList<Point2D> getlist(){ return arrL;}
	public int getcount(){return count;}
	public void setList(ArrayList<Point2D> _arrL){arrL = _arrL;}
    public void setcount(int _count){count = _count;}

    public void setpositionstri(int x1, int y1, int x2, int y2, int x3, int y3, int angle, int x, int y, String col){
		Point2D first = new Point2D(x1,y1,angle,x,y,"green");
		Point2D second = new Point2D(x2,y2);
		Point2D third = new Point2D(x3,y3);

		arrL.add(first);
		arrL.add(second);
		arrL.add(third);
	}


	public void setpositionsrec(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int angle, int x, int y, String col){
		Point2D first = new Point2D(x1,y1,angle,x,y,"green");
		Point2D second = new Point2D(x2,y2);
		Point2D third = new Point2D(x3,y3);
		Point2D fourth = new Point2D(x4,y4);

		arrL.add(first);
		arrL.add(second);
		arrL.add(fourth);
		arrL.add(third);
	}

	public void setpositionscir(double arrx[], double arry[], int size,double angle, double x, double y,String col){

		for(int i=0; i<100; i++){

			Point2D elem = new Point2D(arrx[i], arry[i]);
			arrL.add(elem);
		
		}
	}
	public Shape increment(){

		Shape _shp= new PolygonVect();
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

		Shape _shp= new PolygonVect();
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
		  		
		  		xpoints[i] = (int)(arrL.get(i).getx());
		  		ypoints[i] = (int)(arrL.get(i).gety());
		  	}
		  		g2d.fillPolygon( xpoints,ypoints,100 );
		  	for(int i=1; i<100; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrL.get(i-1).getx()), (int)(arrL.get(i-1).gety()),
		  				   (int)(arrL.get(i).getx()), (int)(arrL.get(i).gety()));
		  	}
		  	g2d.drawLine((int)(arrL.get(99).getx()), (int)(arrL.get(99).gety()),
		  				   (int)(arrL.get(0).getx()), (int)(arrL.get(0).gety()));

  	
		  }
		  
		  
		  else if(count==3){
		  		g2d.fillPolygon(new int[] {(int)(arrL.get(0).getx()), (int)(arrL.get(1).getx()), (int)(arrL.get(2).getx())}, 
					  		  new int[] {(int)(arrL.get(0).gety()), (int)(arrL.get(1).gety()), (int)(arrL.get(2).gety())}, 3);
				
		  	for(int i=1; i<3; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrL.get(i-1).getx()), (int)(arrL.get(i-1).gety()),
		  				   (int)(arrL.get(i).getx()), (int)(arrL.get(i).gety()));
		  		
		  	}
		  	g2d.drawLine((int)(arrL.get(2).getx()), (int)(arrL.get(2).gety()), (int)(arrL.get(0).getx()), (int)(arrL.get(0).gety()));
		  
		  }

		  else if(count==4){
		  	for(int i=0; i<4; i++){
		 
		  		g2d.fillPolygon(new int[] {(int)(arrL.get(0).getx()), (int)(arrL.get(1).getx()), (int)(arrL.get(2).getx()), (int)(arrL.get(3).getx())}, 
					  		  new int[] {(int)(arrL.get(0).gety()), (int)(arrL.get(1).gety()), (int)(arrL.get(2).gety()), (int)(arrL.get(3).gety())}, 4);
		  		
		  	}
		  	for(int i=1; i<4; i++){
		  		
				g2d.setColor(Color.BLACK);
		  		g2d.drawLine((int)(arrL.get(i-1).getx()), (int)(arrL.get(i-1).gety()),
		  				   (int)(arrL.get(i).getx()), (int)(arrL.get(i).gety()));
		  		
		  	}
		  	g2d.drawLine((int)(arrL.get(3).getx()), (int)(arrL.get(3).gety()),
		  			   (int)(arrL.get(0).getx()), (int)(arrL.get(0).gety()));

		  }

	}

	public double area(){
  		
  		return areas;
  	}

  	public double perimeter(){

  		return perimeters;
  	}
            

	public int compareTo(Shape sh) {
		 sh = new PolygonVect();

		if(this.area() > sh.area()) return 1; 
	    if(this.area() < sh.area()) return -1;
	    else                   return 0;
        
    }

}