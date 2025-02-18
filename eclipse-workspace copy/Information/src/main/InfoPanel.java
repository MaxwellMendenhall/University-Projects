package main;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoPanel extends JPanel implements ItemListener
{
//stuff for the future, is to try make it into an array
	//also to add more segments that talk about other stuff in java
	//also add swing components instead of just AWT
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Choice choice = new Choice();
	JTextArea textArea = new JTextArea(5,83);
	
	//JButton Button1 = new JButton("Testing");
	
	//public boolean b=false;
	
	public InfoPanel()
	{
		//this.setBackground(Color.black);
		
		choice.addItemListener(this);
		choice.setBounds(0,0,60,60);
		choice.add("Button");
		choice.add("Canvas");
		choice.add("Check Box");
		choice.add("Check Box Menu Item");
		choice.add("Choice");
		choice.add("File Dialog");
		choice.add("Label");
		choice.add("List");
		choice.add("Menu");
		choice.add("Menu Bar");
		choice.add("Scroll Bar");
		choice.add("Text Area");
		choice.add("Text Field");
		
		textArea.setLineWrap(true);

		this.add(choice);
		this.add(textArea);
		//this.add(Button1);
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		//Your code to do something - ie
        if(e.getSource() == choice) 
        {
            if(choice.getSelectedItem().equals("Button")) 
            {
                System.out.println("1 is selected in Choice selector c");
                
                textArea.setText("Testing");
                // or to launch a class
                //new YourClassYouWantToLauch();
            }
            if(choice.getSelectedItem().equals("Canvas"))
            {
            	System.out.println("Java fx");

            	textArea.setText("textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");textArea.setText(\"Testing\");");
            }
            if(choice.getSelectedItem().equals("Check Box"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Check Box Menu Item"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Choice"))
            {
            	
            }
            if(choice.getSelectedItem().equals("File Dialog"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Label"))
            {
            	
            }
            if(choice.getSelectedItem().equals("List"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Menu"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Menu Bar"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Scroll Bar"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Text Area"))
            {
            	
            }
            if(choice.getSelectedItem().equals("Text Field"))
            {
            	
            }
        }
		
	}

}

