package soacc;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class SoA_CC extends JFrame {
	/**
	 * @author Tim-Lukas Schnell (c)2009
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String VERSION = "1.3";

	JLabel copyright = new JLabel("(c)by Nitemare 2009");

	String temp = "";

	// static JFrame frame;
	JButton apply = new JButton("Anwenden");
	JButton runSoA = new JButton("SoA ausführen");
	JLabel chlbl = new JLabel("Nichts ausgewählt");
	ArrayList<String> typen = new ArrayList<String>();
	boolean clicked = false;
	DefaultListModel<String> data = new DefaultListModel<String>();
	JList<String> list = new JList<String>(data);
	ListAction la;
	String path = "\\ArtLib\\Resources\\Players";
	int index = 0;
	JScrollPane lPane = new JScrollPane(list);

	PoxCreator poxc = new PoxCreator(this);

	public SoA_CC() {
		super("Siege of Avalon - CharChanger " + VERSION);
		setLayout(null);
		setBounds(400, 400, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		arrayInJList();
		lPane.setBounds(2, 2, 180, 200);
		lPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		list.setVisibleRowCount(10);
		la = new ListAction(list, displayAction);
		chlbl.setBounds(185, 100, 180, 50);
		this.add(chlbl);
		this.add(lPane);
		copyright.setBounds(250, 180, 180, 25);
		this.add(copyright);
		apply.setBounds(250, 20, 130, 25);
		apply.addActionListener(eventHandler);
		apply.setActionCommand("anwenden");
		this.add(apply);
		runSoA.setBounds(250, 60, 130, 25);
		runSoA.addActionListener(eventHandler);
		runSoA.setActionCommand("soa");
		this.add(runSoA);
	}

	Action displayAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JList list = (JList) e.getSource();
			chlbl.setText("<html><p>" + list.getSelectedValue().toString() + " ausgewählt</p></html>");
			temp = list.getSelectedValue().toString();
			index = list.getSelectedIndex();
			clicked = true;
		}
	};

	private ActionListener eventHandler = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent evt) {
			final String cmd = evt.getActionCommand();
			if (cmd.equals("anwenden") && (clicked == true)) {
				poxc.create(index);
			}
			if (cmd.equals("anwenden") && (chlbl.getText().equals("Nichts ausgewählt"))) {
				JOptionPane.showMessageDialog(null, "Es wurde nichts ausgewählt", "Fehler",
						JOptionPane.OK_CANCEL_OPTION);
			}
			if (cmd.equals("soa")) {
				try {
					Runtime.getRuntime().exec("DTMain1.exe");
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "DTMain1.exe nicht gefunden", "Fehler",
							JOptionPane.OK_CANCEL_OPTION);
				}
			}
			;
		}
	};

	public int getIndex() {
		return index;
	}

	public void arrayInJList() {
		String[] typen = { "Blaue Elitewache", "Rote Elitewache", "Gelbe Elitewache", "Grüne Elitewache",
				"Purpurne Elitewache", "Orange Elitewache", "Mithras", "Lich", "Bones", "Standard Maennlich",
				"Grüne Blutrose", "Naga 1", "Naga 2", "Elf", "Doomfrost/Spektralwächter", "Käfer", "Lurker", "Spinne",
				"Felsgolem", "Echsenmensch", "Merscwog", "Feuerelementargeist", "Eisgolem", "Lavagolem",
				"Mittlere Lavakrabbe", "Gelber Echsenmensch", "Brauner Echsenmensch", "Roter Echsenmensch",
				"Astralwächterin", "Schwarzer Hase", "Blauer Echsenmensch", "Brauner Hase", "Clydesdale (Pferd)",
				"ClydesSadd2 (Pferd)", "ClydesSadd4 (Pferd)", "ClydesSadd5 (Pferd)", "ClydesSadd6 (Pferd)",
				"Lurker (hell)", "Lurker (silverback)", "Canis dirus (Wolf)", "Hund 1", "Hund 2", "Traumwandler 1",
				"Traumwandler 2", "Traumwandler 3", "Weiblicher Geist", "Rote Blutrose", "Blonde Blutrose",
				"4. Blutrose", "5. Blutrose", "Weiblicher Zombie", "Grauer Hase", "Große Lavakrabbe",
				"Kleine Lavakrabbe", "Ritter 1", "Ritter 3", "Ritter 4", "Ritter 5", "Ratte", "Dunkler Felsgolem",
				"Schneewolf", "Einhorn", "König Vortigerm", "Kriegshund 1", "Kriegshund 2", "Kriegshund 4", "Geist",
				"Magierwolf (Wolf 1)", "Wolf 2", "Standard Frau 1", "Standard Frau 2", "Oger", "Schattenoger", "Yeti" };

		for (String typ : typen) {
			data.addElement(typ);
		}
	}

	public String getSelectedListValue() {
		return list.getSelectedValue().toString();
	}

	public static void main(String args[]) {
		new SoA_CC();
	}

}
