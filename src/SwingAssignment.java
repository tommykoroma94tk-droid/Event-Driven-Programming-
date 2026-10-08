import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SwingAssignment extends JFrame {

    // Required variables by assignment
    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    // Additional UI Components
    private JLabel nameLabel;
    private JLabel descLabel;
    private JLabel iconLabel;
    private JPanel innerPanel;
    
    private JButton changeTextBtn;
    private JButton changeBgBtn;
    private JButton resetBtn;

    // Colors extracted from design
    private final Color NAVY_BLUE = new Color(17, 42, 70);
    private final Color TEAL = new Color(18, 130, 119);
    private final Color ORANGE = new Color(249, 168, 38);
    private final Color LIGHT_BG = new Color(240, 244, 248);
    private final Color TEXT_GRAY = new Color(107, 114, 128);

    // Initial state
    private final String INITIAL_TEXT = "Java Swing Assignment";

    public SwingAssignment() {
        // Satisfy the 'frame' variable requirement
        this.frame = this;

        // Configure JFrame
        frame.setTitle("Java Swing Assignment");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen
        frame.getContentPane().setBackground(LIGHT_BG);
        frame.setLayout(new GridBagLayout()); // To center the inner panel

        // Main content panel (satisfies 'panel' requirement)
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(50, 60, 50, 60));
        
        // Load Application Icon
        ImageIcon appIcon = null;
        File iconFile = new File("resources/app_logo.png");
        if (iconFile.exists()) {
            appIcon = new ImageIcon(iconFile.getAbsolutePath());
            frame.setIconImage(appIcon.getImage());
        } else {
            System.err.println("Note: Application icon 'resources/app_logo.png' not found.");
        }

        // Icon Label
        iconLabel = new JLabel();
        if (appIcon != null) {
            iconLabel.setIcon(appIcon);
        } else {
            // Fallback if icon is missing
            iconLabel.setText("[ </> ]");
            iconLabel.setFont(new Font("Arial", Font.BOLD, 48));
            iconLabel.setForeground(NAVY_BLUE);
        }
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Main Title (satisfies 'label' requirement)
        label = new JLabel(INITIAL_TEXT);
        label.setFont(new Font("Arial", Font.BOLD, 36));
        label.setForeground(NAVY_BLUE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Student Name Label
        nameLabel = new JLabel("Joseph Tommy Koroma");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(TEAL);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Orange divider (simulated with a JPanel)
        JPanel divider = new JPanel();
        divider.setBackground(ORANGE);
        divider.setMaximumSize(new Dimension(60, 4));
        divider.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description Label
        String descHtml = "<html><div style='text-align: center; width: 350px;'>" +
                "An interactive Java Swing application demonstrating<br>fundamental GUI components and user interaction." +
                "</div></html>";
        descLabel = new JLabel(descHtml);
        descLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descLabel.setForeground(TEXT_GRAY);
        descLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons Panel Setup
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setLayout(new BoxLayout(buttonsContainer, BoxLayout.Y_AXIS));
        buttonsContainer.setOpaque(false);
        buttonsContainer.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change Text Button (Full width in its container)
        changeTextBtn = new JButton("Change Text");
        styleButton(changeTextBtn, NAVY_BLUE, Color.WHITE, true);
        changeTextBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeTextBtn.setMaximumSize(new Dimension(400, 45));

        // Bottom row for Change Background and Reset
        JPanel bottomButtons = new JPanel();
        bottomButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        bottomButtons.setOpaque(false);

        changeBgBtn = new JButton("Change Background");
        styleButton(changeBgBtn, TEAL, Color.WHITE, true);
        changeBgBtn.setPreferredSize(new Dimension(190, 45));

        resetBtn = new JButton("Reset");
        styleButton(resetBtn, Color.WHITE, NAVY_BLUE, false);
        resetBtn.setPreferredSize(new Dimension(190, 45));

        bottomButtons.add(changeBgBtn);
        bottomButtons.add(resetBtn);

        buttonsContainer.add(changeTextBtn);
        buttonsContainer.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonsContainer.add(bottomButtons);

        // Add components to the panel
        panel.add(iconLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(nameLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(divider);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(descLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(buttonsContainer);

        // Add panel to frame
        frame.add(panel);

        // Event Listeners
        changeTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Welcome to Java Swing!");
            }
        });

        changeBgBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(new Color(230, 255, 250)); // Light teal background
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(INITIAL_TEXT);
                panel.setBackground(Color.WHITE);
            }
        });
    }

    private void styleButton(JButton btn, Color bg, Color fg, boolean fill) {
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setForeground(fg);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        if (fill) {
            btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        } else {
            btn.setBorder(new LineBorder(NAVY_BLUE, 1));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingAssignment app = new SwingAssignment();
                app.setVisible(true);
            }
        });
    }
}
