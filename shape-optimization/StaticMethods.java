import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;



public class StaticMethods{

	public static void drawAll(Shape[] shparr){

		for(Shape indshp: shparr){
		
			if(indshp instanceof Rectangle){
				JFrame app= new JFrame();
				Rectangle rec=(Rectangle)indshp;
				app.add(rec);
				app.setVisible( true ); 
			}
			else if(indshp instanceof Triangle){
				JFrame app= new JFrame();
				Triangle tri=(Triangle)indshp;
				app.add(tri);
				app.setVisible( true ); 
			}
			else if(indshp instanceof Circle){
				JFrame app= new JFrame();
				Circle cir=(Circle)indshp;
				app.add(cir);
				app.setVisible( true ); 

			}
			else if(indshp instanceof ComposedShape){
				JFrame app= new JFrame();
				ComposedShape comp=(ComposedShape)indshp;
				app.add(comp);
				app.setVisible( true ); 

			}

		}
	}

	public static Shape[] convertAll(Shape[] shparr){

		Shape[] newshape= new Shape[shparr.length];
		for(int i=0; i<shparr.length; i++) {
			for (Shape indshp : shparr) {
				if (indshp instanceof Rectangle) {
					Rectangle rec = (Rectangle) indshp;
					PolygonDyn polrec = new PolygonDyn(rec);
					newshape[i] = (Shape)(polrec);
				}
				else if (indshp instanceof Triangle) {
					Triangle tri = (Triangle) indshp;
					PolygonDyn poltri =new PolygonDyn(tri);
					newshape[i] = (Shape)(poltri);
				} 
				else if (indshp instanceof Circle) {
					Circle cir = (Circle) indshp;
					PolygonDyn polcir = new PolygonDyn(cir);
					newshape[i] = (Shape)(polcir);
				}
				
			}
		}
		return  newshape;
	}

	public static void sortShapes(Shape[] shparr){

		ArrayList<Shape> temp = new ArrayList<Shape>();
		int count=0;
	  	for(Shape index : shparr )
			System.out.printf("areas of shapes: %f \n",index.area());

		for(int i=0; i<shparr.length; i++){
			for(int j=0; j<shparr.length; j++){
				if(shparr[i].area()<shparr[j].area()){
					temp.add(shparr[i]);
					shparr[i]=shparr[j];
					shparr[j]=temp.get(count);
					count++;
				}

			}
		}
	}
}
