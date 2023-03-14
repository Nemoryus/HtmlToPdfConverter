import com.ironsoftware.ironpdf.exception.IronPdfNativeException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *
 * Created by Nemoryus 14.3.2023
 *
 */

public class Gui extends JFrame{
    private JTextField textFieldWebPage;
    private JButton convertButtonUrl;
    private JTextField textFieldStorageLocation;
    private JPanel mainPanel;
    private JLabel webPageJLabel;
    private JLabel headerJLabel;
    private JLabel storageLocationJLabel;
    private JTabbedPane tabbedPane1;


    public Gui() throws HeadlessException {
        setContentPane(mainPanel);
        setTitle("Convertor");
        setSize(500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Convertor convertor = new Convertor();


        /**
         * Button listener, ktorý volá metódu .convertFromUrlToPdf() s príslušnými Text Field-ami.
         */
        convertButtonUrl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String webPageName = Gui.this.textFieldWebPage.getText();
                String storageLocation = Gui.this.textFieldStorageLocation.getText();
                Boolean isCorrectConvert = true;

                try {
                    convertor.convertFromUrlToPdf(webPageName,storageLocation);
                } catch (IronPdfNativeException ironPdfNativeException) {
                    isCorrectConvert = false;
                    JOptionPane.showMessageDialog(mainPanel, "Zadali ste zlú adresu webovej stránky: "+webPageName);
                } catch (IOException ex) {
                    isCorrectConvert = false;
                    JOptionPane.showMessageDialog(mainPanel, "Zadali ste zlú adresu alebo názov pre uloženie súboru: "+storageLocation+".pdf");
                }

                if (isCorrectConvert)  JOptionPane.showMessageDialog(mainPanel, "Pdf je uložené na adrese: "+storageLocation+".pdf");
            }
        });

    }
}
