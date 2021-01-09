/**
 *
 */
package fil.coo.IO;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

import fil.coo.file.FileChecker;
import fil.coo.file.FileEvent;
import fil.coo.plugin.Plugin;

/**
 * @author Celine
 * Create a graphical view
 */
public class Graphical implements View{

	private FileChecker fileChecker;
	private JMenu menu;
	private TextArea text;

	/**
	 * Constructor for Graphical
	 * @param fileChecker a FileChecker
	 */
	public Graphical(FileChecker fileChecker) {
		this.fileChecker = fileChecker;
		createGraphical();
	}


	/**
	 * Create the graphical view
	 */
	private void createGraphical() {
		JFrame f = new JFrame("Editor");
		f.setLocation(100, 300);
		f.setPreferredSize(new Dimension(300,300));

		text = new TextArea(30,30);
		text.setText("Hello, what's up ?");
		JScrollPane jScrollPane = new JScrollPane(text);

		//jScrollPane.add(text);

		JMenuBar menuBar = new JMenuBar();

		f.add(jScrollPane,BorderLayout.CENTER);
		JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
		f.setJMenuBar(menuBar);
		this.menu = menu;
		f.pack();
		f.setVisible(true);

	}

	/**
	 * Starts the fileChecker
	 */
	public void start() {
		fileChecker.start();
	}


	/**
	 * Add a new item
	 */
	@Override
	public void actionWhenAdded(FileEvent event) {
		JMenuItem item = new JMenuItem();
		item.setText(event.getFileName().substring(0, event.getFileName().length()-6));
		//item.setEnabled(true);
		/*Action declanchee lorsqu'on clique sur l'item*/
		final FileEvent fe = event;
		java.awt.event.ActionListener action = new java.awt.event.ActionListener() {
			   public void actionPerformed(java.awt.event.ActionEvent e) {
				   try {
					String fileName= fe.getFileName();
					Class<?> c = Class.forName("fil.coo.plugin."+fileName.substring(0, fileName.length()-6));
					Constructor<?> cons = c.getConstructor();
					Plugin plugin = (Plugin) cons.newInstance();
					String string = text.getText();
					text.setText(plugin.transform(string));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}


			   }
			};
	item.addActionListener(action);

		menu.add(item);
	}


	/**
	 * Delete an item
	 */
	@Override
	public void actionWhenRemoved(FileEvent event) {
		int nbItems = this.menu.getItemCount();
		for (int i=0; i<nbItems; i++) {
			if (this.menu.getItem(i).getText().equals(event.getFileName())) {
				menu.remove(this.menu.getItem(i));
			}
		}
	}
}