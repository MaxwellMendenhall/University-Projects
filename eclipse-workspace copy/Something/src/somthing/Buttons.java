package somthing;
import java.awt.*;
import java.awt.event.*;

public class Buttons extends Frame implements ActionListener,ItemListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public Buttons()
{
//set the layout
setLayout(new BorderLayout(20,5));

//Add buttons
Button Red = new Button("Red");
Button Yellow = new Button("Yellow");
Button Cyan = new Button("Cyan");
Button Magenta = new Button("Magenta");
Choice colors = new Choice();
//Button White = new Button("White");

add(Red, BorderLayout.NORTH);
add(Yellow, BorderLayout.SOUTH);
add(Cyan, BorderLayout.EAST);
add(Magenta, BorderLayout.WEST);
add(colors, BorderLayout.CENTER);

//choice component colors
colors.add("Red");
colors.add("Yellow");
colors.add("Cyan");
colors.add("Magenta");

//ItemLister for choice component
Red.addItemListener(this);
Yellow.addItemListener(this);
Cyan.addItemListener(this);
Magenta.addItemListener(this);
colors.addItemListener(this);

//add the ActionListener to each menu item
Red.addActionListener(this);
Yellow.addActionListener(this);
Cyan.addActionListener(this);
Magenta.addActionListener(this);
//White.addActionListener(this);

//override the windowClosing event
addWindowListener(
new WindowAdapter()
{
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
}
);

}

//This method is triggered by the user clicking in the choice component area in the center and choicing a color
public void itemStateChanged(ItemEvent ie)
{
String arg = e.getActionCommand();
if (arg == "Red")
setBackground(Color.red);

if (arg == "Yellow")
setBackground(Color.yellow);

if (arg == "Cyan")
setBackground(Color.cyan);

if (arg == "Magenta")
setBackground(Color.magenta);

if (arg == "White")
setBackground(Color.white);
}

public static void main(String[] args)
{
// set frame properties
Buttons f = new Buttons();
f.setTitle("Border Application");
f.setBounds(200,200,300,300);
f.setVisible(true);

}

public void actionPerformed(ActionEvent e)
{
//test for button clicks
String arg = e.getActionCommand();
if (arg == "Red")
setBackground(Color.red);

if (arg == "Yellow")
setBackground(Color.yellow);

if (arg == "Cyan")
setBackground(Color.cyan);

if (arg == "Magenta")
setBackground(Color.magenta);

if (arg == "White")
setBackground(Color.white);
}

}