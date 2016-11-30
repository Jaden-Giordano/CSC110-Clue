package edu.neumont.teamgift.clue.front.gui;

import edu.neumont.teamgift.clue.front.MainManager;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GetNumPlayersGUI extends JFrame {

    public void launchNumbPlayers() {
        buildActionMenu();
		createActionButtons();
	}

	private void buildActionMenu() {
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 800);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setTitle("Make this window full screen to set Numebnr of Players!");
	}

	private void createActionButtons() {
		Font titleFont = new Font("Serif", Font.BOLD, 40);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 700));
		add(panel);
        panel.setLayout(new GridLayout(0, 1));
        JLabel title = new JLabel("How many people are playing?");
		title.setFont(titleFont);
		panel.add(title);
		JLabel organizationalSpace = new JLabel(" ");
		panel.add(organizationalSpace);
		ButtonGroup numPlayer = new ButtonGroup();
        List<JRadioButton> selections = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
			JRadioButton numPlayers = new JRadioButton("" + (i + 1));
			numPlayers.setFont(titleFont);
			numPlayer.add(numPlayers);
			panel.add(numPlayers);
            selections.add(numPlayers);
            //panel.add(organizationalSpace);
		}
		JButton save = new JButton("Save");
		save.setFont(titleFont);
		//save.setSize(300, 500);
		save.setVisible(true);

        JRadioButton[] arr = new JRadioButton[selections.size()];
        arr = selections.toArray(arr);
        save.addActionListener(new SaveButton(this, arr));
        panel.add(save);
    }

    private class SaveButton implements ActionListener {

        JFrame parent;

        JRadioButton[] selections;

        public SaveButton(JFrame parent, JRadioButton[] selections) {
            this.parent = parent;
            this.selections = selections;
        }

        @Override public void actionPerformed(ActionEvent e) {
            int number = 0;
            for (JRadioButton i : selections) {
                if (i.isSelected()) {
                    number = Integer.valueOf(i.getText());
                    break;
                }
            }

            ((MainManager) MainManager.getInstance()).createGameMaster(number);

            parent.dispose();
        }
    }

}
