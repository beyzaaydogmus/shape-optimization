# shape-optimization
a java gui program that will optimize some 2D shapes display calculated 2D graphics.


**Interface Shape defines at least the following method.**
- area that returns the area of the shape
- perimeter that returns the perimeter
- Functions increment and decrement for incrementing and decrementing the shapepositions by 1.0.
- This interface implements the Comparable interface to compare shapes with respect to their areas.
- Draw takes a Graphics object as parameter and draws the shape. This method will be called from the paintComponent method of a JPanel object.


Class Rectangle, Triangle, Circle and ComposedShape all implement the Shape interface. They behave like the classes in HW3. Class ComposedShape keeps an array of Shape references for the shape elements.
Polygon is an abstract class that implements. 
PolygonVect and PolygonDyn are two concrete classes that derive from Polygon class. 
One of them uses Collection class ArrayList vectors to keep the 2D points, the other uses Java arrays to keep the 2D points.
We also define the following static methods in a separate class
- Method drawAll takes an array of Shape references and draws all shapes to an JPanel
- Method convertAll takes an array of Shape references, converts all shapes to Polygons and returns a new array with the new shapes.
- Method sortShapes takes an array of Shapes and increasingly sorts them with respect to their areas.
