import java.awt.Graphics;
import java.awt.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;


public class ComposedShape extends JPanel implements Shape{
  	private char mainShape;
  	private char smallShape;
  	private double areaOfShape;
  	private double perimeterLOfShape;

  	private ArrayList<PolygonDyn> vect = new ArrayList<PolygonDyn>();

	private int optimalFitOf_CirclesInRectangle(){

		double sq3 = Math.sqrt(3);
		int count=0;
		int size=100;
		double arrx[];
		arrx = new double[size];
		double arry[];
		arry = new double[size];

		double radius=smallC1.getRadius();
		double mainheight = mainR3.getheight();
		double mainwidth = mainR3.getwidth();


		int control1=(int)(mainheight/(2*radius)); //calculate how many circles fit along the height
		int control2=(int)(mainwidth/(2*radius)); //calculate how many circles fit side by side along the width
		        
		    for(int i=0; i< control1; i++){
		      for(int j=0; j < control2; j++){

		        smallC1.setPosition(radius+2*j*radius,radius+2*i*radius,0.0,0.0,0.0);
		        for(int k=0; k<size; k++){
		          arrx[k]= smallC1.getcoordx()+smallC1.getRadius()*Math.sin((Math.PI/50.0)*k);
		          arry[k]= smallC1.getcoordy()-smallC1.getRadius()*(Math.cos((Math.PI/50.0)*k));
		        }

				PolygonDyn poly= new PolygonDyn(smallC1);
		        poly.setpositionscir(arrx, arry, size,0.0,0.0,0.0,"green" );
		        vect.add(poly);

		        count++;
		        
		        }
		    }

		  return count;
	}


	private int optimalFitOf_RectanglesInRectangle(){

		int count=0;
		double width=smallR1.getwidth();
		double height=smallR1.getheight();
		double mainheight=mainR1.getheight();
		double mainwidth=mainR1.getwidth();

		int control=(int)(mainheight/height);//calculate how many rectangles fit along the height 
		int control1=(int)(mainwidth/width);//calculate how many rectangles fit side by side along the width
		int control2=(int)((mainwidth-control1*width)/height); //calculate how many rotated rectangles fit the remaining empty space

		    for(int i=0; i< control; i++){
		      for(int j=0; j < control1; j++){
		        smallR1.setPosition(j*width,i*height,width,height);
				PolygonDyn poly= new PolygonDyn(smallR1);
		        poly.setpositionsrec(smallR1.getcoordx(), smallR1.getcoordy(), smallR1.getcoordx()+smallR1.getwidth(), smallR1.getcoordy(), smallR1.getcoordx()+smallR1.getwidth(), smallR1.getcoordy()+smallR1.getheight(),smallR1.getcoordx(),smallR1.getcoordy()+smallR1.getheight(),0.0,0.0,0.0,"GREEN" );
		        vect.add(poly);
		        count++;
		        }
		    }

		      
		    if(mainwidth-control1*width>=height && mainheight>=width){ // check remaining empty space is large enough to fit rotated rectangles
		    control=(int)(mainheight/width);
		      for(int i=0; i< control; i++){
		        for(int j=0; j < control2; j++){

		        smallR1.setPosition(control1*width+j*height,i*width,height,width);
		        PolygonDyn poly= new PolygonDyn(smallR1);
		        poly.setpositionsrec(smallR1.getcoordx(), smallR1.getcoordy(), smallR1.getcoordx()+smallR1.getwidth(), smallR1.getcoordy(), smallR1.getcoordx()+smallR1.getwidth(), smallR1.getcoordy()+smallR1.getheight(),smallR1.getcoordx(),smallR1.getcoordy()+smallR1.getheight(),0.0,0.0,0.0,"GREEN" );
		        vect.add(poly);
		        count++;
		        }
		      }
		    }

		int control0=(int)(mainheight/width);//calculate how many rectangles fit along the height 
		int control3=(int)(mainwidth/height);//calculate how many rectangles fit side by side along the width
		int control4=(int)(mainwidth/width);//calculate how many rotated rectangles fit the remaining empty space

		 return count;

	}


	private int optimalFitOf_TrianglesInRectangle(){

		int count=0;
		double sq3 = Math.sqrt(3);

		double edge= smallT1.getEdge();
		double mainwidth= mainR2.getwidth();
		double mainheight= mainR2.getheight();


		int control=(int)(mainwidth/edge); //calculate how many triangles fit side by side along the width
		int control1=(int)(mainheight/((edge/2.0)*sq3)); //calculate how many triangles fit along the height 


		    // straight triangles
		    for(int j=0; j<control1; j++){
		      for (int i=0; i<control; i++){

		          smallT1.setPosition(edge/2.0+(i*edge),j*(edge/2.0)*sq3,0+(i*edge),(edge/2.0)*sq3+j*(edge/2.0)*sq3,edge+(i*edge),(edge/2.0)*sq3+j*(edge/2.0)*sq3,0.0,0.0,0.0);
				  PolygonDyn poly= new PolygonDyn(smallT1);		          
		          poly.setpositionstri(smallT1.getX1(),smallT1.getX2(),smallT1.getY1(),smallT1.getY2(),smallT1.getZ1(),smallT1.getZ2(),0.0,0.0,0.0,"GREEN");
		          vect.add(poly);
		          count++;  
		      }
		    }
		            
		            
		    if((mainwidth-(edge/2.0)) < control*edge) control=control-1 ;  //checks whether the inverted triangles should need to be less than straight triangles
		            
		         
		        // inverted triangles
		        for(int j=0; j<control1; j++){
		          for(int i=0; i<control; i++){

		            smallT1.setPosition(edge/2.0+(i*edge),j*(edge/2.0)*sq3,edge+(i*edge),(edge/2.0)*sq3+j*(edge/2.0)*sq3,0+(i*edge)+3*edge/2.0,(edge/2.0)*sq3+j*(edge/2.0)*sq3-edge/2.0*sq3,0.0,0.0,0.0);
		            
		            PolygonDyn poly= new PolygonDyn(smallT1);
		            poly.setpositionstri(smallT1.getX1(),smallT1.getX2(),smallT1.getY1(),smallT1.getY2(),smallT1.getZ1(),smallT1.getZ2(),smallT1.getAngle(),smallT1.getRotateX(),smallT1.getRotateY(),"GREEN");
		            vect.add(poly);
		          	count++;  

		          }
		        }

		return count;

	}
 	private Circle smallC3;

	private int optimalFitOf_TrianglesInCircle(){

		int count=0;
		double sq3 = Math.sqrt(3);
		double edge=smallT3.getEdge();
		double mainradius=mainC2.getRadius();
		int control0=(int)(mainradius/edge); //calculate how many triangles fit along the mainradius 
		/*these two for drawing a larger square than the main container shape (circle) */
		int mainwidth=(int)(mainradius*3); 
		int mainheight=(int)(mainradius*3);
		/*these two for calculate of fill the inside of this square with triangles */
		int control=(int)(mainwidth/edge);
		int control1=(int)(mainheight/((edge)*sq3));

		  
		    for(int j=0; j<control1; j++){
		        for (int i=0; i<control; i++){
		    
		            // these instructions controls that whether corners of the inverted triangles provide the circle equation ' (x-a)^2+(y-b)^2=r^2 '
		            // and prepare to draw the triangle that provide the equation
		            if( Math.pow((i*edge-mainradius),2) + Math.pow(((edge/2.0)*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2) &&
		              Math.pow((edge+i*edge-mainradius),2) + Math.pow(((edge/2.0)*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2) &&
		              Math.pow((edge/2.0+i*edge-mainradius),2) + Math.pow((edge*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2) ){
		              
		              smallT3.setPosition(i*edge, (edge/2.0)*sq3+edge*sq3*j, edge+i*edge, (edge/2.0)*sq3+edge*sq3*j, (edge/2.0)+i*edge, edge*sq3+edge*sq3*j,0.0,0.0,0.0 ); 
		              PolygonDyn poly= new PolygonDyn(smallT3);
		              poly.setpositionstri(smallT3.getX1(),smallT3.getX2(),smallT3.getY1(),smallT3.getY2(),smallT3.getZ1(),smallT3.getZ2(),0.0,0.0,0.0,"GREEN");
		              vect.add(poly);  
		              count++;        
		            }
		        }
		    }  
		        
		    for( int j=0; j<control1; j++){
		        for (int i=0; i<control; i++){
		            
		            // these instructions controls that whether corners of the uninverted triangles provide the circle equation ' (x-a)^2+(y-b)^2=r^2 '
		            // and prepare to draw the triangle that provide the equation
		            if( Math.pow((edge/2.0+(i*edge)-mainradius),2) + Math.pow((j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) &&
		              Math.pow((i*edge-mainradius),2) + Math.pow(((edge/2.0)*sq3+j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) &&
		              Math.pow(( edge+(i*edge)-mainradius),2) + Math.pow(((edge/2.0)*sq3+j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) ){
		          
		              smallT3.setPosition(edge/2.0+(i*edge), j*edge*sq3, (i*edge), (edge/2.0)*sq3+j*edge*sq3, edge+(i*edge), (edge/2.0)*sq3+j*edge*sq3,0.0,0.0,0.0 );
		              PolygonDyn poly= new PolygonDyn(smallT3);
		              poly.setpositionstri(smallT3.getX1(),smallT3.getX2(),smallT3.getY1(),smallT3.getY2(),smallT3.getZ1(),smallT3.getZ2(),0.0,0.0,0.0,"GREEN");
		              vect.add(poly);  
		              count++; 
		            }
		       
		        }
		    }
		      
		         
		    for( int j=0; j<control1; j++){
		        for (int i=0; i<control; i++){
		              
		            // these instructions controls that whether corners of the inverted rotated triangles provide the circle equation ' (x-a)^2+(y-b)^2=r^2 '
		            // and prepare to draw the triangle that provide the equation
		            if( Math.pow((edge/2.0+edge+i*edge-mainradius),2) + Math.pow(((edge/2.0)*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2) &&
		                Math.pow((edge/2.0+edge+i*edge-mainradius),2) + Math.pow((edge*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2) &&
		                Math.pow((edge/2.0+i*edge-mainradius),2) + Math.pow((edge*sq3+edge*sq3*j-mainradius),2) <= Math.pow(mainradius,2)  ){

		                smallT3.setPosition(edge+i*edge, (edge/2.0)*sq3+edge*sq3*j, i*edge+(3*edge/2.0), (edge/2.0)*sq3+edge*sq3*j+(edge/2.0)*sq3, (edge/2.0)+i*edge, edge*sq3+edge*sq3*j, 0.0,0.0,0.0  );
		                PolygonDyn poly= new PolygonDyn(smallT3);
		                poly.setpositionstri(smallT3.getX1(),smallT3.getX2(),smallT3.getY1(),smallT3.getY2(),smallT3.getZ1(),smallT3.getZ2(),smallT3.getAngle(),smallT3.getRotateX(),smallT3.getRotateY(),"GREEN");
		                vect.add(poly);
		                count++;
		            }
		        }
		    }
		   
		   
		    for( int j=0; j<control1; j++){
		        for (int i=0; i<control; i++){       
		            
		              // these instructions controls that whether corners of the uninverted triangles provide the circle equation ' (x-a)^2+(y-b)^2=r^2 '
		              // and prepare to draw the triangle that provide the equation
		            if( Math.pow((edge+(i*edge)-mainradius),2) + Math.pow((j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) &&
		                Math.pow((edge+(i*edge)-mainradius),2) + Math.pow((edge/2.0*sq3+j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) &&
		                Math.pow((edge+(i*edge)-mainradius),2) + Math.pow((edge/2.0*sq3+j*edge*sq3-mainradius),2) <= Math.pow(mainradius,2) ){

		                smallT3.setPosition(edge/2.0+(i*edge), j*edge*sq3, edge+(i*edge), (edge/2.0)*sq3+j*edge*sq3,(i*edge)+3*edge/2.0, (edge/2.0)*sq3+j*edge*sq3-edge/2.0*sq3,0.0,0.0,0.0 );
		       			
		                PolygonDyn poly= new PolygonDyn(smallT3);
		                poly.setpositionstri(smallT3.getX1(),smallT3.getX2(),smallT3.getY1(),smallT3.getY2(),smallT3.getZ1(),smallT3.getZ2(),smallT3.getAngle(),smallT3.getRotateX(),smallT3.getRotateY(),"GREEN");
		                vect.add(poly);
		                count++;
		                     
		            }
		        }
		    }

		  return count;

	}

	private Circle smallC2;
 

	private int optimalFitOf_CirclesInCircle(){

		int count=0;
		int size=100;
		double arrx[];
		arrx = new double[size];
		double arry[];
		arry = new double[size];

		double radius=smallC3.getRadius();
		double mainradius=mainC3.getRadius();
		double a ; // helper for calculating the value of angle
		double angle; //this's a variable to assign the rotation value of circle

		int control; //this's a variable to assign the number of how many times circle will rotate
		int control1=(int)(mainradius/(2*radius)); //calculate how many circles fit along the maiinradius 

		    if((int)(2*mainradius)%(int)(2*radius)==0){
		      smallC3.setPosition(mainradius, control1*2.0*radius+radius, 0.0,0.0,0.0 );
		      for(int i=0; i<size; i++){
		          arrx[i]= smallC3.getcoordx()+smallC3.getRadius()*Math.sin((Math.PI/50.0)*i);
		          arry[i]= smallC3.getcoordy()-smallC3.getRadius()*(Math.cos((Math.PI/50.0)*i));
		        }
				PolygonDyn poly= new PolygonDyn(smallC3);
		        poly.setpositionscir(arrx, arry, size,0.0,0.0,0.0,"GREEN" );
		        vect.add(poly);
		        count++;
		      
		    }

		    for(int j=0; j<control1; j++){
		  
		    //calculate angle between the center directions of two circles next to each other
		    a =1.0-2.0*((double)(radius)*(double)(radius))/(((double)(mainradius)-(double)(radius+radius*j*2))*((double)(mainradius)-(double)(radius+radius*j*2)));  
		    angle = Math.acos(a) * 180.0 / 3.14;

		    control=(int)(360.0/angle);
		 
		    
		    for(int i=0; i<control; i++){

		        smallC3.setPosition(mainradius, radius+radius*2.0*j, i*angle, mainradius, mainradius ) ;
		        for(int k=0; k<size; k++){
		          arrx[k]= smallC3.getcoordx()+smallC3.getRadius()*Math.sin((Math.PI/50.0)*k);
		          arry[k]= smallC3.getcoordy()-smallC3.getRadius()*(Math.cos((Math.PI/50.0)*k));
		        }
				PolygonDyn poly= new PolygonDyn(smallC3);
		        poly.setpositionscir(arrx, arry, size, i*angle,mainradius,mainradius,"GREEN" );
		        vect.add(poly);
		        count++;
		  		
		      }       
		    }

		return count;
	}

	private Circle smallC1;

	private int optimalFitOf_RectanglesInCircle(){

		int count=0;
		double width= smallR3.getwidth();
		double height=smallR3.getheight();
		double mainradius= mainC1.getRadius();


		if(width>height){ // if width longer than height swap them
		    
		  double temp=width;
		  width=height;
		  height=temp;

		}

		/*these for 'mainradius-mainradius/sqrt(2) >= height'  situation*/
		double mainwidth0= mainradius*2;
		double mainheight0= mainradius*2;

		int control0=(int)(mainheight0/height);//calculate how many rectangles fit along the height 
		int control1=(int)(mainwidth0/width);//calculate how many rectangles fit side by side along the width
		int control2=(int)((mainwidth0-control1*width)/height); //calculate how many rotated rectangles fit the remaining empty space


		/*these for 'mainradius-mainradius/sqrt(2) < height' situation*/
		double mainwidth= mainradius*Math.sqrt(2);
		double mainheight= mainradius*Math.sqrt(2);

		int control3;
		int control4=(int)(mainheight/height);//calculate how many rectangles fit along the height 
		int control5=(int)(mainwidth/width);//calculate how many rectangles fit side by side along the width
		int control6=(int)((2*mainradius/Math.sqrt(2)-control4*+height )/width); //calculate how many rotated rectangles fit the remaining empty space


		    if(mainradius-mainradius/Math.sqrt(2) >= height){
		   
		      for(int i=0; i< control0; i++){
		        for(int j=0; j < control1; j++){
		      
		          //checks whether the corners of the rectangles provide the circle equation ' (x-a)^2+(y-b)^2=r^2 '
		          if((Math.pow((j*width-mainradius),2) + Math.pow((i*height-mainradius),2) <= Math.pow(mainradius,2)) && 
		          (Math.pow((j*width+width-mainradius),2) + Math.pow((i*height-mainradius),2) <= Math.pow(mainradius,2))  &&
		          (Math.pow((j*width+width-mainradius),2) + Math.pow((i*height+height-mainradius),2) <= Math.pow(mainradius,2)) && 
		          (Math.pow((j*width-mainradius),2) + Math.pow((i*height+height-mainradius),2) <= Math.pow(mainradius,2)) ){

		          smallR3.setPosition(j*width,i*height,width,height);  
		          PolygonDyn poly= new PolygonDyn(smallR3);
		          poly.setpositionsrec(smallR3.getcoordx(),smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy()+smallR3.getheight() ,smallR3.getcoordx(), smallR3.getcoordy()+smallR3.getheight(), 0.0,0.0,0.0,"GREEN");
		          vect.add(poly);
		          count++;
		              
		        
		          }            
		        }  
		      }
		    }

		    else if(mainradius-mainradius/Math.sqrt(2) < height){

		      
		      for(int i=0; i< control4; i++){
		        for(int j=0; j < control5; j++){

		          smallR3.setPosition(j*width+mainradius-mainradius/Math.sqrt(2),i*height+mainradius-mainradius/Math.sqrt(2),width,height);
		          PolygonDyn poly= new PolygonDyn(smallR3);
		          poly.setpositionsrec(smallR3.getcoordx(),smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy()+smallR3.getheight() ,smallR3.getcoordx(), smallR3.getcoordy()+smallR3.getheight(), 0.0,0.0,0.0,"GREEN");
		          vect.add(poly);
		          count++;
		          }
		      }
		      
		      if(mainwidth-control4*height>=width){ // check remaining empty space is large enough to fit rotated rectangles


		        for(int i=0; i<control6; i++){
		          for(int j=0; j<control4; j++){

		            smallR3.setPosition(j*height+(mainradius-mainradius/Math.sqrt(2)), i*width+mainradius-mainradius/Math.sqrt(2)+control4*height, height, width);
					PolygonDyn poly= new PolygonDyn(smallR3);
		            
		            poly.setpositionsrec(smallR3.getcoordx(),smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy(), smallR3.getcoordx()+smallR3.getwidth(), smallR3.getcoordy()+smallR3.getheight() ,smallR3.getcoordx(), smallR3.getcoordy()+smallR3.getheight(), 0.0,0.0,0.0,"GREEN");
		            vect.add(poly);
		            count++;
		          }
		        }    
		      }
		    }
		    
		    return count;
	}

	private Circle mainC3;
  	

	private int optimalFitOf_RectanglesInTriangle(){

		int count=0;
		double sq3 = Math.sqrt(3);

		double width=smallR2.getwidth();
		double height=smallR2.getheight();
		double mainedge=mainT1.getEdge();

		int control1=(int)(Math.ceil((mainedge/2.0*sq3-width)/height));  //calculate how many rectangles fit along an edge 
		int control2=(int)((mainedge-height/sq3)/width);   //calculate how many triangles fit side by side along the base edge 

		    for(int j=0; j<control1 ; j++){
		      for(int i=0; i<control2 ; i++){   
		    
		        //checks whether the corners of the rectangles provide the equation of triangles right edge
		        // and prepare to draw the rectangles that provide the equation
		        if( (height/sq3+i*width+j*height/sq3+width)*sq3 - (((mainedge/2.0)*sq3-height)-height*j) <= (mainedge*sq3)/2.0 ){
		                
		          smallR2.setPosition( height/sq3 +i*width +j*height/sq3, ((mainedge/2.0)*sq3-height)-height*j, width, height );
				  PolygonDyn poly= new PolygonDyn(smallR2);
		          poly.setpositionsrec(smallR2.getcoordx(),smallR2.getcoordy(), smallR2.getcoordx()+smallR2.getwidth(), smallR2.getcoordy(), smallR2.getcoordx()+smallR2.getwidth(), smallR2.getcoordy()+smallR2.getheight() ,smallR2.getcoordx(), smallR2.getcoordy()+smallR2.getheight(), 0.0,0.0,0.0,"GREEN");
		          vect.add(poly);
		          count++;
		  
		        }
		      }        
		    }
		
		return count;
	}

	private Circle mainC2;
  	
	private int optimalFitOf_TrianglesInTriangle(){

		double sq3 = Math.sqrt(3);
		int count=0;

		double edge= smallT2.getEdge();
		double mainedge= mainT2.getEdge();

		int control=(int)(mainedge/edge); //calculate how many triangles fit side by side along an edge 
		 
		    for(int i=0; i<control; i++){
		      for(int j=i; j>=0; j--){      

		      //unrotated triangles 
		          smallT2.setPosition(mainedge/2.0-i*(edge/2.0)+edge*j, i*(edge/2.0)*sq3, (mainedge/2.0-edge/2.0)-i*edge/2.0+edge*j, (edge/2.0)*sq3+i*(edge/2.0)*sq3, (mainedge/2.0+edge/2.0)-i*edge/2.0 +edge*j, (edge/2.0)*sq3 + i*(edge/2.0)*sq3 ,0.0,0.0,0.0 );
				  PolygonDyn poly= new PolygonDyn(smallT2);		          
		          poly.setpositionstri(smallT2.getX1(),smallT2.getX2(),smallT2.getY1(),smallT2.getY2(),smallT2.getZ1(),smallT2.getZ2(),0.0,0.0,0.0,"GREEN");
		          vect.add(poly);
		          count++;

		      }
		    }

		    for(int i=0; i<control-1; i++){
		      for(int j=i; j>=0; j--){    

		      //rotated triangles     
		 		  smallT2.setPosition((mainedge/2.0-edge/2.0)-i*edge/2.0+edge*j, (edge/2.0)*sq3+i*(edge/2.0)*sq3, (mainedge/2.0+edge/2.0)-i*edge/2.0 +edge*j, (edge/2.0)*sq3 + i*(edge/2.0)*sq3 ,mainedge/2.0-i*(edge/2.0)+edge*j, i*(edge/2.0)*sq3+edge*sq3 ,0.0,0.0,0.0 );
		          
		          PolygonDyn poly= new PolygonDyn(smallT2);		          
		          poly.setpositionstri(smallT2.getX1(),smallT2.getX2(),smallT2.getY1(),smallT2.getY2(),smallT2.getZ1(),smallT2.getZ2(),smallT2.getAngle(),smallT2.getRotateX(),smallT2.getRotateY(),"GREEN");
		          vect.add(poly);
		          count++;

		      }
		    }
		
		return count;
	}

	private Circle mainC1;
  	
	private int optimalFitOf_CirclesInTriangle(){
		int count=0;
		double sq3 = Math.sqrt(3);

		int size=100;
		double arrx[];
		arrx = new double[size];
		double arry[];
		arry = new double[size];


		double radius=smallC2.getRadius();
		double mainedge=mainT3.getEdge();

		int control= (int)(mainedge/(2*radius)-sq3+1); //calculate how many circles fit side by side along an edge 

		    for (int i=0; i<control+1; i++){
		      for(int j=0; j<control-i; j++){

		        if(radius<= (mainedge/6)*sq3){ //to prevent the circle from overflowing from triangle 
		        smallC2.setPosition(mainedge/2 -(i-j)*radius, 2*radius +(i+j)*radius*sq3, 0.0,0.0,0.0 );

		        for(int k=0; k<size; k++){
		          arrx[k]= smallC2.getcoordx()+smallC2.getRadius()*Math.sin((Math.PI/50.0)*k);
		          arry[k]= smallC2.getcoordy()-smallC2.getRadius()*(Math.cos((Math.PI/50.0)*k));
		        }
				PolygonDyn poly= new PolygonDyn(smallC2);

		        poly.setpositionscir(arrx, arry, size,0.0,0.0,0.0,"GREEN" );
		        vect.add(poly);
		          count++;

		        
		        }
		      }
		    }
		return count;
	}

	public void setrec(Rectangle _rec){
		rec=_rec;
	} 
	public void settri(Triangle _tri){
		tri=_tri;

	} 
	public void setcir(Circle _cir){
		cir=_cir;

	} 

	private Rectangle mainR1;
  	private Rectangle mainR2;
  	private Rectangle mainR3;

  	private Rectangle rec=new Rectangle();
  	private Triangle tri=new Triangle();
  	private Circle cir=new Circle();
	


  	public void paintComponent( Graphics g ){
		//call paintComponent to ensure the panel displays xorrenctly
		super.paintComponent( g );
		Graphics2D g2d = (Graphics2D)g;
		g2d.getStroke();
		draw(g2d);

	}

  	public void draw(Graphics g){
  		
		if(mainShape=='R' || mainShape=='r'){
			g.setColor(Color.RED);
			rec.draw(g);
		}
		else if(mainShape=='T' || mainShape=='t'){
			g.setColor(Color.RED);
			tri.draw(g);
		}
		else if(mainShape=='C' || mainShape=='c'){
			g.setColor(Color.RED);
			cir.draw(g);
		}

		for(int i=0; i<vect.size(); i++){
			g.setColor(Color.GREEN);
  			(vect.get(i)).draw(g);
		  		
  		}
  	
	}


	public ComposedShape(Rectangle _mainR1, Rectangle _smallR1,char _main,char _small){
		areaOfShape=_mainR1.getAreaOfShape();
		perimeterLOfShape= _mainR1.getPerimeterOfShape();
		mainR1=_mainR1;
		smallR1=_smallR1;
		mainShape=_main;
		smallShape=_small;
	}
  	public ComposedShape(Rectangle _mainR2, Triangle _smallT1, char _main, char _small){
  		areaOfShape=_mainR2.getAreaOfShape();
		perimeterLOfShape= _mainR2.getPerimeterOfShape();
  		mainR2=_mainR2;
		smallT1=_smallT1;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Rectangle _mainR3, Circle _smallC1, char _main, char _small){
  		areaOfShape=_mainR3.getAreaOfShape();
		perimeterLOfShape= _mainR3.getPerimeterOfShape();
  		mainR3=_mainR3;
		smallC1=_smallC1;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Triangle _mainT1, Rectangle _smallR2, char _main, char _small){
  		areaOfShape=_mainT1.getAreaOfShape();
		perimeterLOfShape= _mainT1.getPerimeterOfShape();
  		mainT1=_mainT1;
		smallR2=_smallR2;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Triangle _mainT2, Triangle _smallT2, char _main, char _small){
  		areaOfShape=_mainT2.getAreaOfShape();
		perimeterLOfShape= _mainT2.getPerimeterOfShape();
  		mainT2=_mainT2;
		smallT2=_smallT2;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Triangle _mainT3, Circle _smallC2, char _main, char _small){
  		areaOfShape=_mainT3.getAreaOfShape();
		perimeterLOfShape= _mainT3.getPerimeterOfShape();
  		mainT3=_mainT3;
		smallC2=_smallC2;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Circle _mainC1, Rectangle _smallR3, char _main, char _small){
  		areaOfShape=_mainC1.getAreaOfShape();
		perimeterLOfShape= _mainC1.getPerimeterOfShape();
  		mainC1=_mainC1;
		smallR3=_smallR3;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Circle _mainC2, Triangle _smallT3, char _main, char _small){
  		areaOfShape=_mainC2.getAreaOfShape();
		perimeterLOfShape= _mainC2.getPerimeterOfShape();
  		mainC2=_mainC2;
		smallT3=_smallT3;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(Circle _mainC3, Circle _smallC3, char _main, char _small){
  		areaOfShape=_mainC3.getAreaOfShape();
		perimeterLOfShape= _mainC3.getPerimeterOfShape();
  		mainC3=_mainC3;
		smallC3=_smallC3;
		mainShape=_main;
		smallShape=_small;
  	}
  	public ComposedShape(){}


  	private Rectangle smallR1;
  	public double remainingEmptyArea(Rectangle _R, Rectangle _Rs, int totalSmallShapes){
  		double width= _Rs.getWidth();
		double height= _Rs.getHeight();
		double mainWidth = _R.getWidth();
		double mainHeight= _R.getHeight();
		double emptyArea = mainWidth*mainHeight - totalSmallShapes*width*height;
		System.out.printf("\n The empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Rectangle smallR2;
  	public double remainingEmptyArea(Rectangle _R, Triangle _T, int totalSmallShapes){

		double edge= _T.getEdge();
		double mainWidth = _R.getWidth();
		double mainHeight= _R.getHeight();
		double emptyArea = mainWidth*mainHeight - totalSmallShapes*Math.pow(edge,2)*Math.sqrt(3)/4.0;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Rectangle smallR3;
  	public double remainingEmptyArea(Rectangle _R, Circle _C, int totalSmallShapes){
  		double radius= _C.getRadius();
		double mainWidth = _R.getWidth();
		double mainHeight= _R.getHeight();
		double emptyArea = mainWidth*mainHeight - totalSmallShapes*Math.pow(radius,2)*Math.PI;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Triangle mainT1;
 	public double remainingEmptyArea(Triangle _T, Rectangle _R, int totalSmallShapes){

		double mainedge= _T.getEdge();
		double width= _R.getWidth();
		double height= _R.getHeight();
		double emptyArea = Math.pow(mainedge,2)*Math.sqrt(3)/4.0 - totalSmallShapes*width*height;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
 	}
  	private Triangle mainT2;
  	public double remainingEmptyArea(Triangle _T, Triangle _Ts, int totalSmallShapes){

	  	double mainedge= _T.getEdge();
	  	double edge= _Ts.getEdge();
	  	double emptyArea = Math.pow(mainedge,2)*Math.sqrt(3)/4.0 - totalSmallShapes*Math.pow(edge,2)*Math.sqrt(3)/4.0;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Triangle mainT3;
  	public double remainingEmptyArea(Triangle _T, Circle _C, int totalSmallShapes){

  		double mainedge= _T.getEdge();
  		double radius= _C.getRadius();
  		double emptyArea = Math.pow(mainedge,2)*Math.sqrt(3)/4.0 - totalSmallShapes*Math.pow(radius,2)*Math.PI;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Triangle smallT3;
  	public double remainingEmptyArea(Circle _C, Rectangle _R, int totalSmallShapes){
  	    double mainradius= _C.getRadius();
		double width= _R.getWidth();
		double height= _R.getHeight();
		double emptyArea = Math.pow(mainradius,2)*Math.PI - totalSmallShapes*width*height;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Triangle smallT1;
  	public double remainingEmptyArea(Circle _C, Triangle _T, int totalSmallShapes){
  		double mainradius= _C.getRadius();
  		double edge= _T.getEdge();
  		double emptyArea = Math.pow(mainradius,2)*Math.PI - totalSmallShapes*Math.pow(edge,2)*Math.sqrt(3)/4.0;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}
  	private Triangle smallT2;
  	public double remainingEmptyArea(Circle _C, Circle _Cs, int totalSmallShapes){
  		double mainradius= _C.getRadius();
  		double radius= _Cs.getRadius();
  		double emptyArea = Math.pow(mainradius,2)*Math.PI - totalSmallShapes*Math.pow(radius,2)*Math.PI;
		System.out.printf("\nThe empty area (red) in container is: %s. \n",emptyArea);
		return emptyArea;
  	}


  	public void inputmain(){
  		System.out.println("enter main: \n");
  		Scanner input = new Scanner(System.in);
	    mainShape=input.next().charAt(0);
  	}
  	public void inputsmall(){
  		System.out.println("enter small: \n");
  		Scanner input = new Scanner(System.in);
	    smallShape=input.next().charAt(0);
  	}

  	public char getmain() {return mainShape;}
  	public char getsmall() {return smallShape;}

  	public void setinputs(char main, char small){
  		mainShape=main;
    	smallShape=small;
  	}

  	public double area(){	
		
		return areaOfShape;	
	}
	public double perimeter(){	
		
		return perimeterLOfShape;	

	}  	

	public int compareTo(Shape sh) {
		 sh = new ComposedShape();

		if(this.area() > sh.area()) return 1; 
	    if(this.area() < sh.area()) return -1;
	    else                   return 0;
        
    }

	public Shape increment(){

		Shape _shp= new ComposedShape();
		if(mainShape=='t' || mainShape=='T'){
			Shape shp = new Triangle();
			shp.increment();
			return shp;
		}
		else if(mainShape=='r' || mainShape=='R'){
			Shape shp = new Rectangle();
			shp.increment();
			return shp;
		}
		else if(mainShape=='C' || mainShape=='C'){
			Shape shp = new Circle();
			shp.increment();
			return shp;
		}
		else return _shp;
	}
	
	public Shape decrement(){

		Shape _shp= new ComposedShape();
		if(mainShape=='t' || mainShape=='T'){
			Shape shp = new Triangle();
			shp.decrement();
			return shp;
		}
		else if(mainShape=='r' || mainShape=='R'){
			Shape shp = new Rectangle();
			shp.decrement();
			return shp;
		}
		else if(mainShape=='C' || mainShape=='C'){
			Shape shp = new Circle();
			shp.decrement();
			return shp;
		}
		else return _shp;
	}

	public int optimalFit(){
		    
		  int number1=0;
		  int number2=0;
		  if ((mainShape=='R' || mainShape=='r') && (smallShape=='R' || smallShape=='r')){

		    number1=optimalFitOf_RectanglesInRectangle();

		    return number1;
		  }
		  else if ((mainShape=='R' || mainShape=='r') && (smallShape=='C' || smallShape=='c')) {
		    
		    number1=optimalFitOf_CirclesInRectangle();
		    return number1;
		  }
		  else if ((mainShape=='R' || mainShape=='r') && (smallShape=='T' || smallShape=='t')){
		  
		    number1=optimalFitOf_TrianglesInRectangle();
		    return number1;
		  }
		  else if ((mainShape=='T' || mainShape=='t') && (smallShape=='R' || smallShape=='r')){

		    number1=optimalFitOf_RectanglesInTriangle();
		    return number1;
		  }
		  else if ((mainShape=='T' || mainShape=='t') && (smallShape=='C' || smallShape=='c')){
		    
		    number1=optimalFitOf_CirclesInTriangle();
		    return number1;
		  }
		  else if ((mainShape=='T' || mainShape=='t') && (smallShape=='T' || smallShape=='t')){
		    
		    number1=optimalFitOf_TrianglesInTriangle();
		    return number1;
		  }
		  else if ((mainShape=='C' || mainShape=='c') && (smallShape=='R' || smallShape=='r')){
		    
		    number1=optimalFitOf_RectanglesInCircle();
		    return number1;
		  }
		  else if ((mainShape=='C' || mainShape=='c') && (smallShape=='C' || smallShape=='c')){
		    number1=optimalFitOf_CirclesInCircle();
		    return number1;
		  }
		  else if ((mainShape=='C' || mainShape=='c') && (smallShape=='T' || smallShape=='t')){

		    number1=optimalFitOf_TrianglesInCircle();
		    return number1;
		  }
		return 0;
		}

 }