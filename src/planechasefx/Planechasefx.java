package planechasefx;

import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import javax.swing.*;

public class Planechasefx {
    

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            
                JFrame frame = new JFrame("Planechase Program");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1600, 1100);
                frame.setVisible(true);
                
                //Set a header image
                JLabel imageLabel = new JLabel();
                ImageIcon imageIcon = new ImageIcon("assets/Planechase_logo.jpg");
                Image scaledImage = imageIcon.getImage().getScaledInstance(900, 200, java.awt.Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(scaledImage);
                imageLabel.setIcon(imageIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                imageLabel.setVerticalAlignment(SwingConstants.CENTER);
                imageLabel.setPreferredSize(new Dimension(3000, 200));
                imageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                imageLabel.setOpaque(true);
                imageLabel.setBackground(Color.ORANGE);
                frame.getContentPane().add(imageLabel, BorderLayout.NORTH);
                
                
                // Create a panel for the checkboxes
                JPanel anthPanel = new JPanel();
                anthPanel.setBackground(Color.RED);
                anthPanel.setLayout(new GridLayout(0, 1, 1, 1)); // 1 columns, variable rows
                
                JPanel docWhoPanel = new JPanel();
                docWhoPanel.setBackground(Color.CYAN);
                docWhoPanel.setLayout(new GridLayout(0, 1, 1, 1)); // 1 columns, variable rows
                
                JPanel othPanel = new JPanel();
                othPanel.setBackground(Color.YELLOW);
                othPanel.setLayout(new GridLayout(0, 1, 1, 1)); // 1 columns, variable rows
                
                JPanel phenPanel = new JPanel();
                phenPanel.setBackground(Color.GREEN);
                phenPanel.setLayout(new GridLayout(0, 1, 1, 1)); // 1 columns, variable rows
                
                

                // Add headings for each column
                JLabel anthLabel = new JLabel("Anthology", SwingConstants.CENTER);
                JLabel docWhoLabel = new JLabel("Doctor Who", SwingConstants.CENTER);
                JLabel othLabel = new JLabel("Other", SwingConstants.CENTER);
                JLabel phenLabel = new JLabel("Phenomenon", SwingConstants.CENTER);
                
                anthPanel.add(anthLabel);
                docWhoPanel.add(docWhoLabel);
                othPanel.add(othLabel);
                phenPanel.add(phenLabel);
                
                // Add checkboxes under each column
                // Read checkboxes from separate text files for each column
            try {
                Path anthologyPath = Paths.get("assets/anthology_planes.txt");// File contents from
                    // https://scryfall.com/search?as=grid&order=name&q=type%3Aplane+%28game%3Apaper%29+set%3Aopca
                Path doctorWhoPath = Paths.get("assets/doctor_who_planes.txt"); // File contents from
                    // https://scryfall.com/search?as=grid&order=name&q=type%3Aplane+%28game%3Apaper%29+set%3Awho
                Path otherPath = Paths.get("assets/other_planes.txt"); // File contents from 
                    // https://scryfall.com/search?q=type%3Aplane+%28game%3Apaper%29+-%28set%3Awho+OR+set%3Aopca+OR+set%3Aopc2+OR+set%3Aohop+OR+set%3Amoc+OR+set%3Adci+OR+set%3Aphop%29&unique=cards&as=grid&order=name
                Path phenomenonPath = Paths.get("assets/phenomenons.txt"); // File contents from 
                    // https://scryfall.com/search?as=grid&order=name&q=type%3Aphenomenon+%28game%3Apaper%29
                
                java.util.List<String> anthologyLines = Files.readAllLines(anthologyPath);
                java.util.List<String> doctorWhoLines = Files.readAllLines(doctorWhoPath);
                java.util.List<String> otherLines = Files.readAllLines(otherPath);
                java.util.List<String> phenomenonLines = Files.readAllLines(phenomenonPath);
                
                // Add checkboxes for Anthology column
                for (String label : anthologyLines) {
                    JCheckBox checkBox = new JCheckBox(label.trim());
                    anthPanel.add(checkBox);
                }
                
                // Add checkboxes for Doctor Who column
                for (String label : doctorWhoLines) {
                    JCheckBox checkBox = new JCheckBox(label.trim());
                    docWhoPanel.add(checkBox);
                }
                
                // Add checkboxes for Other column
                for (String label : otherLines) {
                    JCheckBox checkBox = new JCheckBox(label.trim());
                    othPanel.add(checkBox);
                }

                // Add checkboxes for Phenomenon column
                for (String label : phenomenonLines) {
                    JCheckBox checkBox = new JCheckBox(label.trim());
                    phenPanel.add(checkBox);
                }
                
                JPanel panel = new JPanel(new GridLayout(1,4)); // 1 row, 4 columns
                // Add the checkbox panel to the frame
                // Make the checkbox panel scrollable
                JScrollPane anthScrollPane = new JScrollPane(anthPanel);
                anthScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                anthScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                anthScrollPane.setBounds(0,200,350,800); // Set bounds size for the scroll pane
                panel.add(anthScrollPane); //add anthology scroll pane to the frame

                JScrollPane docWhoScrollPane = new JScrollPane(docWhoPanel);
                docWhoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                docWhoScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                docWhoScrollPane.setBounds(400,200,350,800); // Set bounds size for the scroll pane
                panel.add(docWhoScrollPane); //add doctor who scroll pane to the frame

                JScrollPane othScrollPane = new JScrollPane(othPanel);
                othScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                othScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                othScrollPane.setBounds(800,200,350,800); // Set bounds size for the scroll pane
                panel.add(othScrollPane); //add other scroll pane to the frame

                JScrollPane phenScrollPane = new JScrollPane(phenPanel);
                phenScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                phenScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                phenScrollPane.setBounds(1200,200,350,800); // Set bounds size for the scroll pane
                panel.add(phenScrollPane); //add phenomenon scroll pane to the frame
                
                frame.add(panel); //add the panel to the frame
                
                // Add Buttons to the East side of the frame
                GridLayout buttonLayout = new GridLayout(0,1,1,1); // 1 column, variable rows
                JPanel buttonPanel = new JPanel(buttonLayout);
                buttonPanel.setPreferredSize(new Dimension(150, 800)); // Set preferred size for the button panel

                //Create buttons
                JButton allAnthologyButton = new JButton("All Anthology");
                JButton allDoctorWhoButton = new JButton("All Doctor Who");
                JButton allOtherButton = new JButton("All Other");
                JButton allPhenomenonButton = new JButton("All Phenomenon");
                JButton randomizeAllButton = new JButton("Randomize All");
                JButton resetAllButton = new JButton("Reset All");
                JButton startWithSelectedButton = new JButton("Start With Selected");
                // Add buttons to the button panel
                buttonPanel.add(allAnthologyButton);
                buttonPanel.add(allDoctorWhoButton);
                buttonPanel.add(allOtherButton);
                buttonPanel.add(allPhenomenonButton);
                buttonPanel.add(randomizeAllButton);
                buttonPanel.add(resetAllButton);
                buttonPanel.add(startWithSelectedButton);
                
                // Add button panel to the frame
                frame.add(buttonPanel, BorderLayout.EAST);
                buttonPanel.setBackground(Color.LIGHT_GRAY);

                // Add action listeners to the buttons
                allAnthologyButton.addActionListener( _ -> {
                    // Select all checkboxes in the anthology panel
                    for (Component comp : anthPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(true);
                        }
                    }
                });
                allDoctorWhoButton.addActionListener(_ -> {
                    // Select all checkboxes in the doctor who panel
                    for (Component comp : docWhoPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(true);
                        }
                    }
                });
                allOtherButton.addActionListener(_ -> {
                    // Select all checkboxes in the other panel
                    for (Component comp : othPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox)  {
                            jCheckBox.setSelected(true);
                        }
                    }
                });
                allPhenomenonButton.addActionListener(_ -> {
                    // Select all checkboxes in the phenomenon panel
                    for (Component comp : phenPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(true);
                        }
                    }
                });
                randomizeAllButton.addActionListener(_ -> {
                    // Randomly select checkboxes in all panels
                    for (Component comp : anthPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(Math.random() < 0.5);
                        }
                    }
                    for (Component comp : docWhoPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(Math.random() < 0.5);
                        }
                    }
                    for (Component comp : othPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(Math.random() < 0.5);
                        }
                    }
                    for (Component comp : phenPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(Math.random() < 0.5);
                        }
                    }
                });
                resetAllButton.addActionListener(_ -> {
                    for (Component comp : anthPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(false);
                        }
                    }
                    for (Component comp : docWhoPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(false);
                        }
                    }
                    for (Component comp : othPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(false);
                        }
                    }
                    for (Component comp : phenPanel.getComponents()) {
                        if (comp instanceof JCheckBox jCheckBox) {
                            jCheckBox.setSelected(false);
                        }
                    }
                });
                startWithSelectedButton.addActionListener(_ -> {
                    // Get selected checkboxes from each panel
                    StringBuilder selectedPlanes = new StringBuilder("Selected Planes:\n");
                    for (Component comp : anthPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            selectedPlanes.append(((JCheckBox) comp).getText()).append("\n");
                        }
                    }
                    for (Component comp : docWhoPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            selectedPlanes.append(((JCheckBox) comp).getText()).append("\n");
                        }
                    }
                    for (Component comp : othPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            selectedPlanes.append(((JCheckBox) comp).getText()).append("\n");
                        }
                    }
                    for (Component comp : phenPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            selectedPlanes.append(((JCheckBox) comp).getText()).append("\n");
                        }
                    }
                    
                    // Show the selected planes in a dialog
                    JOptionPane.showMessageDialog(frame, selectedPlanes.toString(), "Selected Planes", JOptionPane.INFORMATION_MESSAGE);

                    // Change to a game page
                    JFrame gameFrame = new JFrame("Planechase Game");

                    // Create a DefaultListModel to hold the planes
                    DefaultListModel<String> planesListModel = new DefaultListModel<>();
                    for (Component comp : anthPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            planesListModel.addElement(((JCheckBox) comp).getText());
                        }
                    }
                    for (Component comp : docWhoPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            planesListModel.addElement(((JCheckBox) comp).getText());
                        }
                    }
                    for (Component comp : othPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            planesListModel.addElement(((JCheckBox) comp).getText());
                        }
                    }
                    for (Component comp : phenPanel.getComponents()) {
                        if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                            planesListModel.addElement(((JCheckBox) comp).getText());
                        }
                    }
                    gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    gameFrame.setSize(1600, 1100);
                    gameFrame.setVisible(true);

                    // Create a panel to hold the game components
                    JPanel gamePanel = new JPanel(new BorderLayout());

                    // Display the planes that have already been drawn in a list
                    DefaultListModel<String> drawnPlanesListModel = new DefaultListModel<>();
                    JList<String> drawnPlanesList = new JList<>(drawnPlanesListModel);
                    drawnPlanesList.setFont(new Font("Arial", Font.PLAIN, 16));
                    JScrollPane drawnPlanesScrollPane = new JScrollPane(drawnPlanesList);
                    drawnPlanesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                    drawnPlanesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    gamePanel.add(drawnPlanesScrollPane, BorderLayout.EAST); // Add the drawn planes list to the left side

                    // Create a draw button
                    JButton drawButton = new JButton("Draw Plane");
                    drawButton.setFont(new Font("Arial", Font.BOLD, 16));
                    gamePanel.add(drawButton, BorderLayout.WEST);
                    
                    final int MAX_IMAGES = 6;

                    // Create a panel to hold up to 3 drawn plane images
                    JPanel drawnImagesPanel = new JPanel(new GridLayout(2, 3, 1, 1));
                    drawnImagesPanel.setPreferredSize(new Dimension(1200, 600));
                    drawnImagesPanel.setBounds(200, 0, 1200, 300);
                    gamePanel.add(drawnImagesPanel, BorderLayout.CENTER);

                     // Keep track of the drawn plane images
                    java.util.List<JLabel> drawnImageLabels = new java.util.ArrayList<>();
                    for (int i = 0; i < MAX_IMAGES; i++) {
                        JLabel emptyLabel = new JLabel();
                        emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
                        emptyLabel.setVerticalAlignment(SwingConstants.CENTER);
                        emptyLabel.setPreferredSize(new Dimension(400, 300));
                        emptyLabel.setText("");
                        drawnImagesPanel.add(emptyLabel);
                        drawnImageLabels.add(emptyLabel);
                    }

                    for(JLabel label : drawnImageLabels) {
                        if (label.getIcon() == null) {
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    }
                    

                    // Add action listener to the draw button
                    drawButton.addActionListener(_ -> {
                        int imageTracker = 0;
                        for(JLabel label : drawnImageLabels) {
                                if (label.getIcon() != null) {
                                    imageTracker = imageTracker + 1;
                                }
                            }
                        if(imageTracker >= MAX_IMAGES) {
                            JOptionPane.showMessageDialog(gameFrame, "Maximum of " + MAX_IMAGES + " images displayed at a time!", "Limit Reached", JOptionPane.WARNING_MESSAGE);
                        } else {
                        if (!planesListModel.isEmpty()) {
                            

                            int randomIndex = (int) (Math.random() * planesListModel.size());
                            String drawnPlane = planesListModel.get(randomIndex);
                            drawnPlanesListModel.addElement(drawnPlane); // Add the drawn plane to the drawn list
                            //JOptionPane.showMessageDialog(gameFrame, "Drawn Plane: " + drawnPlane, "Plane Drawn", JOptionPane.INFORMATION_MESSAGE);
                            // Display the image of the drawn plane
                            JLabel planeImageLabel = new JLabel();
                            ImageIcon planeImageIcon = new ImageIcon("assets/planes/" + drawnPlane.toLowerCase() + ".jpg"); // Assuming images are stored in "assets/planes" with names matching the plane names
                            Image scaledPlaneImage = planeImageIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
                            planeImageIcon = new ImageIcon(scaledPlaneImage);
                            planeImageLabel.setIcon(planeImageIcon);
                            planeImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                            planeImageLabel.setVerticalAlignment(SwingConstants.CENTER);
                            
                            

                             // Show the image in a dialog
                            JOptionPane.showMessageDialog(gameFrame, planeImageLabel, "Drawn Plane Image", JOptionPane.PLAIN_MESSAGE);
                            

                            

                            // Add the drawn plane image to an empty pane
                            for (JLabel label : drawnImageLabels) {
                                if (label.getIcon() == null) {
                                    label.setIcon(planeImageIcon);
                                    label.setText(drawnPlane); // Set the text to the plane name
                                    break;
                                }
                            }

                            
                            
                            
                            planesListModel.remove(randomIndex); // Remove the drawn plane from the available list
                        } else {
                            JOptionPane.showMessageDialog(gameFrame, "No more planes to draw!", "Game Over", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    });

                    // add a button panel to the bottom of the game frame
                    JPanel rButtonPanel = new JPanel(new GridLayout(2, 3, 1, 1)); // 2 rows, 3 columns
                    gamePanel.add(rButtonPanel, BorderLayout.SOUTH);
                    JButton removeImageButton1 = new JButton("Remove Image 1");
                    JButton removeImageButton2 = new JButton("Remove Image 2");
                    JButton removeImageButton3 = new JButton("Remove Image 3");
                    JButton removeImageButton4 = new JButton("Remove Image 4");
                    JButton removeImageButton5 = new JButton("Remove Image 5");
                    JButton removeImageButton6 = new JButton("Remove Image 6");
                    
                    JButton returnToAvailableButton1 = new JButton("Return Image 1 to Available");
                    JButton returnToAvailableButton2 = new JButton("Return Image 2 to Available");
                    JButton returnToAvailableButton3 = new JButton("Return Image 3 to Available");
                    JButton returnToAvailableButton4 = new JButton("Return Image 4 to Available");
                    JButton returnToAvailableButton5 = new JButton("Return Image 5 to Available");
                    JButton returnToAvailableButton6 = new JButton("Return Image 6 to Available");
                    
                    rButtonPanel.add(removeImageButton1);
                    rButtonPanel.add(removeImageButton2);
                    rButtonPanel.add(removeImageButton3);
                    rButtonPanel.add(removeImageButton4);
                    rButtonPanel.add(removeImageButton5);
                    rButtonPanel.add(removeImageButton6);
                    // add functionality to buttons to remove the image

                    removeImageButton1.addActionListener(_ -> {
                        if (!drawnImageLabels.isEmpty()) {
                            JLabel label = drawnImageLabels.get(0);
                            label.setIcon(null);
                            label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });
                    removeImageButton2.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 1) {
                            JLabel label = drawnImageLabels.get(1);
                            label.setIcon(null);
                             label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });
                    removeImageButton3.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 2) {
                            JLabel label = drawnImageLabels.get(2);
                            label.setIcon(null);
                             label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });
                    removeImageButton4.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 3) {
                            JLabel label = drawnImageLabels.get(3);
                            label.setIcon(null);
                             label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });
                    removeImageButton5.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 4) {
                            JLabel label = drawnImageLabels.get(4);
                            label.setIcon(null);
                             label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });
                    removeImageButton6.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 5) {
                            JLabel label = drawnImageLabels.get(5);
                            label.setIcon(null);
                             label.setText(""); // Clear the text
                            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                    });

                    // Add return to available buttons
                    rButtonPanel.add(returnToAvailableButton1);
                    rButtonPanel.add(returnToAvailableButton2);
                    rButtonPanel.add(returnToAvailableButton3);
                    rButtonPanel.add(returnToAvailableButton4);
                    rButtonPanel.add(returnToAvailableButton5);
                    rButtonPanel.add(returnToAvailableButton6);

                    //add functionality to buttons to return the card to the available list
                    returnToAvailableButton1.addActionListener(_ -> {
                        if (!drawnImageLabels.isEmpty()) {
                            JLabel label = drawnImageLabels.get(0);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    returnToAvailableButton2.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 1) {
                            JLabel label = drawnImageLabels.get(1);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    returnToAvailableButton3.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 2) {
                            JLabel label = drawnImageLabels.get(2);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    returnToAvailableButton4.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 3) {
                            JLabel label = drawnImageLabels.get(3);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    returnToAvailableButton5.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 4) {
                            JLabel label = drawnImageLabels.get(4);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    returnToAvailableButton6.addActionListener(_ -> {
                        if (drawnImageLabels.size() > 5) {
                            JLabel label = drawnImageLabels.get(5);
                            if (label.getIcon() != null) {
                                planesListModel.addElement(label.getText()); // Add the plane back to the available list
                                drawnPlanesListModel.removeElement(label.getText()); // Remove from drawn list
                                label.setIcon(null);
                                label.setText(""); // Clear the text
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            }
                        }
                    });
                    
                    // Add the game panel to the game frame
                    gameFrame.add(gamePanel, BorderLayout.CENTER);
                });


            } catch (IOException ex) {
            }
            
            
        });
    }
}
