package traductor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;

/**
 *
 * @author Diego Casignia
 */

public class ImageFrame extends JFrame {
    private JLabel label;
    private JButton backButton;

    public ImageFrame(TraduccionObj traduccionObj) {
        setTitle("Imagen");
        setSize(512, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        backButton = new JButton("Regresar");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        JPanel contentPane = new JPanel(new BorderLayout());
        label = new JLabel();
        contentPane.add(label, BorderLayout.CENTER);
        contentPane.add(backButton, BorderLayout.SOUTH);
        setContentPane(contentPane);

        try {
            //URL url = new URL(traduccionObj.getUrlImagen());
            URL url = new URL(traduccionObj.getUrlImagen());
            Image image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

