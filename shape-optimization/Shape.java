import java.awt.Graphics;
//<interface>
public interface Shape extends Comparable<Shape>{
	double area();
	double perimeter();
	void draw(Graphics g); //called from the paintComponent method of a JPanel
	Shape increment();
	Shape decrement();
	
}