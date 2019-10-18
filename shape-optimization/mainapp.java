import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.accessibility.AccessibleComponent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mainapp {

	public AccessibleComponent application;
	public JFrame frame;
	public int kosul=0;
	public int kosul1=0;

	public mainapp() {

	}

	public void setmainapp(ArrayList<ComposedShape> comp){
		initialize(comp);
	}


	private void initialize(ArrayList<ComposedShape> comp) {

		//Create a frame to contain all other GUI elements
		frame = new JFrame();
		frame.setBounds(25, 25, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Create a panel for drawing shapes, you can think this as canvas
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 10, 500, 500);
		frame.getContentPane().add(panel); // panel reference copied
		//Label above combo box, just immutable plain text
		JLabel containerShapeLabel = new JLabel("Container shape");
		containerShapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerShapeLabel.setBounds(528, 120, 150, 15);
		frame.getContentPane().add(containerShapeLabel);

		//Label above combo box, just immutable plain text
		JLabel lblInnerShape = new JLabel("Inner shape");
		lblInnerShape.setHorizontalAlignment(SwingConstants.CENTER);
		lblInnerShape.setBounds(725, 120, 150, 15);
		frame.getContentPane().add(lblInnerShape);

		JLabel message = new JLabel("Before drawing please first clear..");
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(580, 250, 300, 15);
		frame.getContentPane().add(message);




		// Combo box for selecting inner shape
		JComboBox<String> cbInnerShape = new JComboBox<String>();
		cbInnerShape.setSelectedIndex(-1);
		cbInnerShape.setMaximumRowCount(3);
		cbInnerShape.setBounds(750, 150, 100, 20);
		cbInnerShape.addItem("Rectangle");
		cbInnerShape.addItem("Triangle");
		cbInnerShape.addItem("Circle");
		frame.getContentPane().add(cbInnerShape); // reference copied
		// Combo box for selecting container shape
		JComboBox<String> cbContainerShape = new JComboBox<String>();

		cbContainerShape.setSelectedIndex(-1);
		cbContainerShape.setMaximumRowCount(3);
		cbContainerShape.setBounds(550, 150, 100, 20);
		cbContainerShape.addItem("Rectangle"); // Choice 1
		cbContainerShape.addItem("Triangle");  // Choice 2
		cbContainerShape.addItem("Circle");    // Choice 3
		frame.getContentPane().add(cbContainerShape);  // reference copied

		// A button that will clear our panel (canvas) when clicked
		// This can be done using callback function mouseClicked
		// The GUI engine will execute mouseClicked function when
		// the user clicks our clear button.
		JButton btnClear = new JButton("Clear");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Clear panel by filling Black :)
				// The Graphics reference is used to draw shapes.
				// When we call panel.getGraphics(), we reach the brush and palette
				// to design our paint that will be painted on the panel(canvas). 
				// After we design our paint,
				// we need to call the paintComponents method, which will
				// ACTUALLY paint the panel with the design that we made.
				Graphics g = panel.getGraphics(); // get brush
				g.setColor(Color.BLACK); // from now on, use white color
				g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
				panel.paintComponents(g); // the panel will change when THIS function is executed
			}
		});

		btnClear.setBounds(665, 350, 75, 23);
		frame.getContentPane().add(btnClear); // button reference copied
		
		// A button that will draw our shapes to panel (canvas) when clicked
		// This can be done using callback function mouseClicked (same as above)
		JButton btnDraw = new JButton("Draw");


		btnDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Print currently selected items of combo boxes

				System.out.println(cbContainerShape.getSelectedItem());
				System.out.println(cbInnerShape.getSelectedItem());
				Graphics g = panel.getGraphics();


				btnDraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if((cbContainerShape.getSelectedItem() == "Circle") && (cbInnerShape.getSelectedItem()=="Circle")){
							comp.get(0).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Rectangle") && (cbInnerShape.getSelectedItem()=="Triangle")){
							comp.get(1).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Rectangle") && (cbInnerShape.getSelectedItem()=="Circle")){
							comp.get(2).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Triangle") && (cbInnerShape.getSelectedItem()=="Rectangle")){
							comp.get(3).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Triangle") && (cbInnerShape.getSelectedItem()=="Triangle")){
							comp.get(4).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Triangle") && (cbInnerShape.getSelectedItem()=="Circle")){
							comp.get(5).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Circle") && (cbInnerShape.getSelectedItem()=="Rectangle")){
							comp.get(6).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Circle") && (cbInnerShape.getSelectedItem()=="Triangle")){
							comp.get(7).draw(g);
						}
						else if((cbContainerShape.getSelectedItem() == "Rectangle") && (cbInnerShape.getSelectedItem()=="Rectangle")){
							comp.get(8).draw(g);
						}
					}
				});

				//if(cbContainerShape.getSelectedItem()=="Triangle"  && cbInnerShape.getSelectedItem()=="Rectangle") {

				//}

			}
		});
		btnDraw.setBounds(665, 300, 75, 23);
		frame.getContentPane().add(btnDraw); // button reference copied
		
	}
}


/*


 					cbContainerShape.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if(e.getStateChange() == ItemEvent.SELECTED) {
								String item = (String)e.getItem();
								if(item.equals("Triangle"))
									kosul=3;
								else if(item.equals("Rectangle"))
									kosul=4;
								else if(item.equals("Circle"))
									kosul=100;
							}
						}
					});
					cbInnerShape.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if(e.getStateChange() == ItemEvent.SELECTED) {
								String item = (String)e.getItem();
								if(item.equals("Triangle"))
									kosul1=3;
								else if(item.equals("Rectangle"))
									kosul1=4;
								else if(item.equals("Circle"))
									kosul1=100;
							}
						}
					});

					*/
