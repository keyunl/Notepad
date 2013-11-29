import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class TextEditor extends JFrame implements ActionListener{

	MenuBar menu = new MenuBar();
	Menu file,edit,format,help;
	MenuItem newOption,openOption,saveOption,saveAsOption,exitOption;	
	MenuItem copy,cut,paste,search,replace;
	MenuItem font,wordWrap;
	MenuItem about;

	JFrame textFrame = new JFrame();
	JPanel textPanel = new JPanel();	
	JTextField textArea = new JTextField();
	JTextArea text = new JTextArea(26,36);

	Font textAreaFont = new Font("Tahoma",Font.PLAIN,15);
	MenuItem Tahoma,Arial,Impact,Georgia;

	String command=" ";
	String string=" ";

	String  str1=" ", str2=" ", str3=" ", str4=" ",str5=" ", str6=" ", str7=" ", str8=" ", str9=" ";
	int length = 0;
	int lengthTwo = 0;
	int xx = 0;
	int xx2 = 0;
	
	
	public TextEditor(String str){

		super(str);

		textFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		textFrame.getContentPane().add(textPanel);
		textPanel=(JPanel)getContentPane();
		textPanel.setLayout(new FlowLayout());
		textPanel.setBackground(Color.WHITE);

		setMenuBar(menu);

		file=new Menu("File");
		edit=new Menu("Edit");
		format=new Menu("Format");
		help = new Menu("Help");

		// File Menu
		newOption = new MenuItem("New");		
		openOption = new MenuItem("Open");
		saveOption = new MenuItem("Save");
		saveAsOption = new MenuItem("Save As");
		exitOption = new MenuItem("Exit");
		// Edit Menu
		copy = new MenuItem("Copy");
		cut = new MenuItem("Cut");
		paste = new MenuItem("Paste");
		search = new MenuItem("Search");
		replace = new MenuItem("Replace");
		// Format Menu
		font = new MenuItem("Font");
		wordWrap = new MenuItem("Word Wrap");
		// HelpMenu
		about = new MenuItem("About"); 
		
		// Create File Menu
		file.add(newOption);		
		file.add(openOption);
		file.add(saveOption);
		file.add(saveAsOption);
		file.add(exitOption);
		menu.add(file);
		// Create Edit Menu
		edit.add(copy);
		edit.add(cut);
		edit.add(paste);
		edit.add(search);
		edit.add(replace);
		menu.add(edit);
		// Create Format Menu		
		format.add(font);
		format.add(wordWrap);
		menu.add(format);
		// Create Help Menu
		help.add(about);
		menu.add(help);
		// Add Action Listeners
		newOption.addActionListener(this);
		openOption.addActionListener(this);
		saveOption.addActionListener(this);
		saveAsOption.addActionListener(this);
		newOption.addActionListener(this);
		exitOption.addActionListener(this);
		copy.addActionListener(this);
		cut.addActionListener(this);
		paste.addActionListener(this);
		search.addActionListener(this);
		replace.addActionListener(this);
		font.addActionListener(this);
		wordWrap.addActionListener(this);
		help.addActionListener(this);
		
		// Create text Area		
				
		textPanel.add(text);
		textPanel.setFont(textAreaFont);
		textArea.setFont(textAreaFont);
		text.setFont(textAreaFont);

	}

	public static void main(String args[])
	{
		TextEditor notePad = new TextEditor("Notepad");
		notePad.setSize(500,500);
		notePad.setVisible(true);
		notePad.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void actionPerformed(ActionEvent actionEvent){

		command=(String)actionEvent.getActionCommand();

		///////NEW OPTION////////////////////////////////////

		if(command.equals("New")){

			dispose();
			TextEditor notePad = new TextEditor("Notepad");
			notePad.setSize(500,500);
			notePad.setVisible(true);

		}

		//////////////////////////////////////////////////////

		///////OPEN OPTION////////////////////////////////////

		try {
			if(command.equals("Open"))
			{

				str4=" ";
				FileDialog dialog=new FileDialog(this,"Open");
				dialog.setVisible(true);

				str1=dialog.getDirectory();
				str2=dialog.getFile();
				str3=str1+str2;
				File f=new File(str3);
				FileInputStream file1=new FileInputStream(f);
				length=(int)f.length();
				for(int j=0;j<length;j++)
				{
					char str5=(char)file1.read();
					str4=str4 + str5;

				}

				text.setText(str4);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////
		//////////////SAVE AS OPTION//////////////////////////
		try {
			if(command.equals("Save"))
			{
				FileDialog dialog1=new FileDialog(this,"Save",FileDialog.SAVE);
				dialog1.setVisible(true);

				str7=dialog1.getDirectory();
				str8=dialog1.getFile();
				str9=str7+str8;


				str6=text.getText();
				lengthTwo=str6.length();
				byte buf[]=str6.getBytes();

				File f1=new File(str9);
				FileOutputStream file=new FileOutputStream(f1);
				for(int k=0;k<lengthTwo;k++)
				{
					file.write(buf[k]);
				}
				file.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////
		//////////////SAVE AS OPTION//////////////////////////
		try {
			if(command.equals("Save As"))
			{
				FileDialog dialog1=new FileDialog(this,"Save As",FileDialog.SAVE);
				dialog1.setVisible(true);

				str7=dialog1.getDirectory();
				str8=dialog1.getFile();
				str9=str7+str8;


				str6=text.getText();
				lengthTwo=str6.length();
				byte buf[]=str6.getBytes();

				File f1=new File(str9);
				FileOutputStream file2=new FileOutputStream(f1);
				for(int k=0;k<lengthTwo;k++)
				{
					file2.write(buf[k]);
				}
				file2.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////
		//////////////EXIT OPTION/////////////////////////////

		if(command.equals("Exit"))
		{
			dispose();
		}

		//////////////////////////////////////////////////////
		//////////////COPY OPTION/////////////////////////////

		if(command.equals("Copy"))
		{
			string=text.getSelectedText();
		}

		//////////////////////////////////////////////////////
		//////////////CUT OPTION//////////////////////////////

//		string=text.getSelectedText();
//		xx=text.getText().indexOf(string);
//		text.replaceRange(" ",xx,xx+string.length());

		//////////////////////////////////////////////////////
		//////////////PASTE OPTION////////////////////////////

		if(command.equals("Paste"))
		{
			xx2=text.getCaretPosition();
			text.insert(string,xx2);
		}

		//////////////////////////////////////////////////////
		//////////////SEARCH OPTION////////////////////////////

		if(command.equals("Search"))
		{
			
			
			final JFrame searchFrame = new JFrame();
			searchFrame.setSize(300, 90);
			JPanel searchPanel = new JPanel(new BorderLayout());
			final JTextField searchText = new JTextField("");
			JButton searchButton = new JButton("Search");
			searchFrame.add(searchPanel);
			searchPanel.add(searchText,BorderLayout.CENTER);
			searchPanel.add(searchButton,BorderLayout.SOUTH);
			searchFrame.repaint();
			searchFrame.setVisible(true);
			final String textAreaString = text.getText();	
					
			searchButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					searchFrame.dispose();
					
					
					int startPosition = textAreaString.indexOf(searchText.getText());
					int endPosition = textAreaString.indexOf(searchText.getText()) + searchText.getText().length();
					
					try {
						DefaultHighlighter.DefaultHighlightPainter highlightPainter = 
						        new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
						    text.getHighlighter().addHighlight(startPosition, endPosition, 
						            highlightPainter);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, searchText.getText() + " Not Found");
					}										
				}
				
				
			});
			
	
		}

		//////////////////////////////////////////////////////
		//////////////REPLACE OPTION//////////////////////////

		if(command.equals("Replace"))
		{
			xx2=text.getCaretPosition();
			text.insert(string,xx2);
		}

		//////////////////////////////////////////////////////
		
		
		
		
		//////////////FONT OPTION/////////////////////////////

		if(command.equals("Replace"))
		{
			xx2=text.getCaretPosition();
			text.insert(string,xx2);
		}

		//////////////////////////////////////////////////////
		//////////////WORD WRAP OPTION////////////////////////

		if(command.equals("Word Wrap"))
		{
			textArea.setColumns(10);
	        
			text.setLineWrap(true); 
			text.setWrapStyleWord(true); 

			repaint();
			
		}

		//////////////////////////////////////////////////////
		//////////////ABOUT OPTION////////////////////////////

		if(command.equals("About"))
		{
			JOptionPane.showMessageDialog(null, "Notepad by Chris Maher \nCopyright 2013", "About", length);
		}

		//////////////////////////////////////////////////////
		
		////////////FONT DIALOG///////////////////////////////
		
		if(command.equals("Font"))
		{	
			
			
			
			String [] fonts = new String [4];
			fonts[0] = "Tahoma";
			fonts[1] = "Arial";
			fonts[2] = "Impact";
			fonts[3] = "Georgia";
			
						
			final JComboBox fontCombo = new JComboBox(fonts);
			JFrame fontFrame = new JFrame("Font");
			fontFrame.setSize(200, 75);
			JPanel fontPanel = new JPanel();
			final JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					System.out.println(fontCombo.getSelectedIndex());
					
					text.setSize(27,43);
					
					if(fontCombo.getSelectedIndex() == 0){
						textAreaFont = new Font("Tahoma",Font.PLAIN,15);	
					}
					else if(fontCombo.getSelectedIndex() == 1){
						textAreaFont = new Font("Arial",Font.PLAIN,15);	
					}
					else if(fontCombo.getSelectedIndex() == 2){
						textAreaFont = new Font("Impact",Font.PLAIN,15);	
					}
					else if(fontCombo.getSelectedIndex() == 3){
						textAreaFont = new Font("Georgia",Font.PLAIN,15);							
					}
					
					text.setFont(textAreaFont);
					
					repaint();
					
				}
			});
			fontPanel.add(fontCombo);
			fontPanel.add(okButton);
			fontFrame.add(fontPanel);
			fontFrame.setVisible(true);
			repaint();
						
		}
		

		//////////////////////////////////////////////////////
		
	}}
