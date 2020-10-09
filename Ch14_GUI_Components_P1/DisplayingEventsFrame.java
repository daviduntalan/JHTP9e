package Ch14_GUI_Components_P1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class DisplayingEventsFrame extends JFrame {

    private JPanel contentPanel;
    private JPanel statusPanel;

    private JButton actionListenerButton;
    private JCheckBox bold, italic;
    private JTextArea eventInfo;
    private JList listItem;

    private JLabel eventTaken;

    public DisplayingEventsFrame() throws HeadlessException {
        super("Displaying Events");
        contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        eventInfo = new JTextArea(12, 48);
        eventInfo.setLineWrap(true);

        JLabel actionListener = new JLabel("ActionListener: ");
        actionListenerButton = new JButton("OKay");
        actionListenerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventInfo.setText(e.toString());
                eventTaken.setText("actionPerformed: " + e.getActionCommand());
            }
        });

        JLabel itemListener = new JLabel("ItemListener: ");
        bold = new JCheckBox("Bold");
        italic = new JCheckBox("Italic");
        CheckBoxHandler checkBoxHandler = new CheckBoxHandler();
        bold.addItemListener(checkBoxHandler);
        italic.addItemListener(checkBoxHandler);

        JLabel listSelectionListener = new JLabel("ListSelectionListener: ");
        String[] regions = new String[]{"North", "East", "South", "West", "North-East", "South-East", "South-West", "North-West"};
        listItem = new JList(regions);
        listItem.setVisibleRowCount(4);
        listItem.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                eventInfo.setText(e.toString());
                int index = listItem.getSelectedIndex();
                eventTaken.setText("valueChanged: " + regions[index]);
            }
        });

        JLabel mouseListener = new JLabel("MouseListener & MouseMotionListener: ");
        MouseHandler mouseHandler = new MouseHandler();
        contentPanel.addMouseListener(mouseHandler);
        contentPanel.addMouseMotionListener(mouseHandler);

        JLabel keyListener = new JLabel("KeyListener: ");
        JTextField inputField = new JTextField("Type something here", 20);
        inputField.addKeyListener(new KeyHandler());

        eventTaken = new JLabel("Status:");

        contentPanel.add(actionListener);
        contentPanel.add(actionListenerButton);
        contentPanel.add(itemListener);
        contentPanel.add(bold);
        contentPanel.add(italic);
        contentPanel.add(listSelectionListener);
        contentPanel.add(new JScrollPane(listItem));
        contentPanel.add(mouseListener);
        contentPanel.add(keyListener);
        contentPanel.add(inputField);
        contentPanel.add(new JScrollPane(eventInfo));

        statusPanel.add(eventTaken);

        add(contentPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    } // end of constructor

    private class KeyHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            eventInfo.setText(e.toString());
            eventTaken.setText("keyTyped: " + e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            eventTaken.setText("keyPressed: " + e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {
            eventTaken.setText("keyReleased: ("
                    + e.getKeyChar() + ") "
                    + e.getExtendedKeyCode());
        }
    }

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            eventInfo.setText(e.toString());
            eventTaken.setText("mouseClicked: " + e.getX() + ", " + e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            eventTaken.setText("mousePressed");
            contentPanel.setBackground(Color.PINK);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            eventTaken.setText("mouseReleased");
            contentPanel.setBackground(Color.GRAY);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            eventTaken.setText("mouseEntered");
            contentPanel.setBackground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            eventTaken.setText("mouseExited");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            eventTaken.setText("mouseDragged");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            eventTaken.setText("mouseMoved");
            contentPanel.setBackground(Color.WHITE);
        }
    }

    private class CheckBoxHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            eventInfo.setText(e.toString());
            String result = "itemStateChanged: ";
            if (e.getSource() == italic) {
                result += "Italic has been selected";
                if (italic.isSelected()) {
                    result += " and checked";
                } else {
                    result += " and unchecked";
                }
            } else if (e.getSource() == bold) {
                result += "Bold has been selected";
                if (bold.isSelected()) {
                    result += " and checked";
                } else {
                    result += " and unchecked";
                }
            }
            eventTaken.setText(result);
        }
    }
}
