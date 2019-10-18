import javax.swing.JFrame;
import java.awt.EventQueue;
import java.util.ArrayList;

public class Test{

	public static void main(String args[]){


		Circle smallC=new Circle();
		ComposedShape comp1 = new ComposedShape(); ComposedShape comp2 = new ComposedShape();
		Rectangle smallR= new Rectangle();
		ComposedShape comp3 = new ComposedShape(); ComposedShape comp4 = new ComposedShape();
		Triangle mainT=new Triangle();
		ComposedShape comp5 = new ComposedShape(); ComposedShape comp6 = new ComposedShape();
		Triangle smallT=new Triangle();
		ComposedShape comp7 = new ComposedShape(); ComposedShape comp8 = new ComposedShape();
		Circle mainC=new Circle();
		ComposedShape comp9 = new ComposedShape(); ComposedShape comp = new ComposedShape();
		Rectangle mainR= new Rectangle();

		ArrayList<ComposedShape> comparr =new ArrayList<>();

		int count=0;
		int i;
		  char mainarr[]={'c', 'r', 'r', 't', 't', 't', 'c', 'c', 'r'};
		  char smallarr[]={'c', 't', 'c', 'r', 't', 'c', 'r', 't', 'r'};

		  //there are 9 different file for every shapes 
		  String files[]= {"Cir_In_Cir", "Tri_In_Rec", "Cir_In_Rec",
							"Rec_In_Tri", "Tri_In_Tri", "Cir_In_Tri",
							"Rec_In_Cir", "Tri_In_Cir", "Rec_In_Rec"};

		/*döngüyü birer birer deneyince tüm şekiller düzgün çalışırken
		*döngüye alınca bazı şekiller eksik çıkıyor sebebini çözemedim*/

		for(i=0; i<9; ++i){
			char m=mainarr[i];
		    char s=smallarr[i];
		    System.out.println();
		    System.out.printf("calculating: %c's in %c \n",s,m);
		 
		  comp.setinputs(m,s);
  		  //comp.inputmain(); //->in comment because this is testing file by default values
		  if(comp.getmain()=='t' || comp.getmain()=='T'){
		    try {
		        mainT.setTriangle(200,0,0,346.41,400,346.41,400);
		      }
		      catch (Exception exception) {
		      	System.out.print("Out of Range error: \n");
		      } 
		      System.out.printf("the defined edge of the main container triangle is %d  \n",400);
		      
		      //comp.inputsmall(); //->on comment because this is testing file by default values
		      if(comp.getsmall()=='r' || comp.getsmall()=='R'){
		        try {
		         smallR.setRectangle(0,0,40,20);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{

		        System.out.printf("the defined width of the small Rectangle is %d; ",40);
		        System.out.printf("and the defined height of the small rectangles is %d  \n",20);
		      		        
		          comp1= new ComposedShape(mainT,smallR,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallR=new Rectangle(0,0,smallR.getwidth(),smallR.getheight());//explicit calling the constructor
		          PolygonDyn poly= new PolygonDyn(mainT);
		          comp1.settri(mainT);
		          count=comp1.optimalFit();

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp1 );  // add the panel to the frame
					application.setSize( (int)(mainT.getEdge()),(int)(mainT.getEdge()) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp1);

				comp1.remainingEmptyArea(mainT,smallR,count);
				}
		          
		      }
		      else if(comp.getsmall()=='t' || comp.getsmall()=='T'){
		        try {
		          smallT.setTriangle(11,0,0,19.05,22,19.05,22);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{
		        System.out.printf("the defined edge of the small triangles is  %d; ",11);
		          comp2=new ComposedShape(mainT,smallT,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallT=new Triangle(smallT.getEdge());
		          PolygonDyn poly=new PolygonDyn(mainT);
		          comp2.settri(mainT);
		          count=comp2.optimalFit();

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp2 );  // add the panel to the frame
					application.setSize( (int)(mainT.getEdge()),(int)(mainT.getEdge())  );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp2);

				comp2.remainingEmptyArea(mainT,smallT,count);
				}
		      }
		      else if(comp.getsmall()=='c' || comp.getsmall()=='C'){
		        try {
		          smallC.setCircle(40,40,40);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{
		        System.out.printf("the defined radius of the small circles is  %d; ",40);

		          comp3=new ComposedShape(mainT,smallC,comp.getmain(),comp.getsmall()); //explicit calling the constructor
		          smallC=new Circle(smallC.getRadius(), smallC.getRadius(), smallC.getRadius());//explicit calling the constructor
		          PolygonDyn poly=new PolygonDyn(mainT);
		          comp3.settri(mainT);
		          count=comp3.optimalFit();
		          
		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp3 );  // add the panel to the frame
					application.setSize( (int)(mainT.getEdge()),(int)(mainT.getEdge()) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp3);

				comp3.remainingEmptyArea(mainT,smallC,count);
				}
	
		      }
		    }


		    else if(comp.getmain()=='r' || comp.getmain()=='R'){

		       try {
		        mainR.setRectangle(0,0,410,506);
		         
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }

		      System.out.printf("the defined width of the main container rectangle is %d; ",410);
		      System.out.printf(" and the defined height of the main container rectangle is %d  \n",506);

		      //comp.inputsmall(); //->on comment because this is testing file by default values
		      if(comp.getsmall()=='c' || comp.getsmall()=='C'){
		        try {
		          smallC.setCircle(40,40,40);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{
		        
		        System.out.printf(" the defined radius of the small circles is %d  \n",40);


		          comp4=new ComposedShape(mainR,smallC,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallC=new Circle(smallC.getRadius(),smallC.getRadius(),smallC.getRadius());//explicit calling the constructor
		          PolygonDyn poly=new PolygonDyn(mainR);
		          comp4.setrec(mainR);
				  count=comp4.optimalFit(); //there are two different pattern

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp4 );  // add the panel to the frame
					application.setSize( (int)(mainR.getwidth()),(int)(mainR.getheight()) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp4);
				
				comp4.remainingEmptyArea(mainR,smallC,count);
				}
	
		          	
		      }

		      else if(comp.getsmall()=='r' || comp.getsmall()=='R'){
		        smallR.setRectangle(0,0,40,20);
		        System.out.printf(" the defined width of the small rectangles is %d  \n",40);
		        System.out.printf(" and the defined height of the small rectangles is %d  \n",20);

		          
		          comp5=new ComposedShape(mainR,smallR,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallR=new Rectangle(0,0,smallR.getwidth(),smallR.getheight());//explicit calling the constructor
		          PolygonDyn poly=new PolygonDyn(mainR);
		          comp5.setrec(mainR);
		          count=comp5.optimalFit(); //there are two different pattern

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp5 );  // add the panel to the frame
					application.setSize( (int)(mainR.getwidth()),(int)(mainR.getheight())  );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

				  comparr.add(comp5);
				
				comp5.remainingEmptyArea(mainR,smallR,count);
		      }

		      else if(comp.getsmall()=='t' || comp.getsmall()=='T'){

		        try {
		          smallT.setTriangle(10,0,0,17.32,20,17.32,20);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{
		        System.out.printf(" the defined edge of the small triangles is %d  \n",20);

		          comp6=new ComposedShape(mainR,smallT,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallR=new Rectangle(0,0,smallR.getwidth(),smallR.getheight());//explicit calling the constructor
		          PolygonDyn poly= new PolygonDyn(mainR);
		          comp6.setrec(mainR);
		          count=comp6.optimalFit();

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp6 );  // add the panel to the frame
					application.setSize( (int)(mainR.getwidth()),(int)(mainR.getheight())  );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp6);

				comp6.remainingEmptyArea(mainR,smallT,count);
				}
		      }      
		    }


		    else if(comp.getmain()=='c' || comp.getmain()=='C'){
		        try {
		          mainC.setCircle(200,200,200);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		      System.out.printf("the defined radius of the main container circle is  %d  \n",200);
		      //comp.inputsmall(); //->on comment because this is testing file by default values
		      if(comp.getsmall()=='t' || comp.getsmall()=='T'){

		        try {
		          smallT.setTriangle(10,0,0,17.32,20,17.32,20);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{

		        System.out.printf("the defined edge of the small triangles is %d  \n",20);
		 
		          comp7=new ComposedShape(mainC,smallT,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallT=new Triangle(smallT.getEdge());
		          PolygonDyn poly= new PolygonDyn(mainC);
		          comp7.setcir(mainC);
		          count=comp7.optimalFit(); //there are two differen pattern

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp7 );  // add the panel to the frame
					application.setSize( (int)(mainC.getRadius()*2),(int)(mainC.getRadius()*2) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp7);

				comp7.remainingEmptyArea(mainC,smallT,count);
				}

		      }

		      else if(comp.getsmall()=='c' || comp.getsmall()=='C'){
		        try {
		          smallC.setCircle(40,40,40);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{
		        System.out.printf("the defined radius of the small circles is %d  \n",40);
		        
		          comp8=new ComposedShape(mainC,smallC,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallC=new Circle(smallC.getRadius(), smallC.getRadius(), smallC.getRadius());//explicit calling the constructor
		          PolygonDyn poly=new PolygonDyn(mainC);
		          comp8.setcir(mainC);
		          count=comp8.optimalFit();

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp8 );  // add the panel to the frame
					application.setSize( (int)(mainC.getRadius()*2),(int)(mainC.getRadius()*2) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp8);


				comp8.remainingEmptyArea(mainC,smallC,count);
				}
	
		      }

		      else if(comp.getsmall()=='r' || comp.getsmall()=='R'){

		        try {
		          smallR.setRectangle(0,0,35,20);
		        }
		        catch (Exception exception) {
		          System.out.print("Out of Range error: \n");
		        }
		        finally{

		        System.out.printf("the defined width of the small rectangles is %d ",35);
		        System.out.printf("and the defined height of the small rectangles is  %d ",20);
        
		          comp9=new ComposedShape(mainC,smallR,comp.getmain(),comp.getsmall());//explicit calling the constructor
		          smallR=new Rectangle(0,0,smallR.getwidth(),smallR.getheight());//explicit calling the constructor
		          PolygonDyn poly=new PolygonDyn(mainC);
		          comp9.setcir(mainC);
		          count=comp9.optimalFit();

		            JFrame application = new JFrame(files[i]);
					//set the frame to exit when it is closed 
					application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					application.add( comp9 );  // add the panel to the frame
					application.setSize( (int)(mainC.getRadius()*2),(int)(mainC.getRadius()*2) );  // set the size of the frame  
					application.setVisible( true );  // make the frame visible

					comparr.add(comp9);

				comp9.remainingEmptyArea(mainC,smallR,count);
				}

		      }
			}
	  	}

		    mainapp window = new mainapp();
			window.setmainapp(comparr);
			window.frame.setSize(1000, 575);
			window.frame.setVisible(true);

	  System.out.println("\n ----------static methods--------");

	  Shape[] test = new Shape[]{smallR,smallC,smallT,mainT,mainR,mainC};

	  StaticMethods.sortShapes(test);
	  for(Shape index : test ){
	  	System.out.printf("sorted areas of shapes: %.2f \n", index.area());
	  }
	  for(Shape index : test ){
	  	System.out.printf("Type : %s \n",index.getClass().getSimpleName());
	  }
	  
	  test=StaticMethods.convertAll(test);
	  for(Shape index : test ){
	  	System.out.printf("Type : %s \n",index.getClass().getSimpleName());
	  }

	  StaticMethods.drawAll(test);
	}		           
}



