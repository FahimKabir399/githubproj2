import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CADtoUSDConverter {
    public static void main(String[] args) {
        new CADtoUSDConverter(); // Creating an instance of the CADtoUSDConverter class to run the application
    }

    private static final double EXCHANGE_RATE = 0.73; // Defining a constant for the exchange rate

    // GUI components
    private JFrame frame; // Declaring a JFrame object for the main window
    private JLabel cadLabel, usdLabel, resultLabel; // Declaring JLabel objects for displaying text
    private JTextField cadTextField; // Declaring a JTextField object for user input
    private JButton convertButton; // Declaring a JButton object for the convert action


    // Exchange rate from CAD to USD
    public CADtoUSDConverter() {
        // Frame setup
        frame = new JFrame("CAD to USD Converter"); // Initializing the JFrame with a title
        frame.setSize(400, 300); // Setting the size of the frame
        frame.setLayout(new FlowLayout()); // Puts components in a row
        frame.getContentPane().setBackground(Color.ORANGE); // Setting the background color of the frame to orange
        frame.setResizable(false); // Making the frame non-resizable
        frame.setLocationRelativeTo(null); // Centering the frame on the screen

        // Set icon
        ImageIcon image = new ImageIcon("money.png");
        frame.setIconImage(image.getImage()); // Setting the icon of the frame to the loaded image

        // Create labels
        cadLabel = new JLabel("Amount in CAD:"); // Initializing the JLabel for CAD amount
        usdLabel = new JLabel("Equivalent in USD:"); // Initializing the JLabel for USD equivalent
        resultLabel = new JLabel(""); //  displaying the result

        // Create text field
        cadTextField = new JTextField(10); // Initializing the JTextField for user input with a column size of 10

        // Create button
        convertButton = new JButton("Convert"); // Initializing the JButton with the text "Convert"

        // Add components to the frame
        frame.add(cadLabel); // Adding the CAD label to the frame
        frame.add(cadTextField); // Adding the text field to the frame
        frame.add(convertButton); // Adding the convert button to the frame
        frame.add(usdLabel); // Adding the USD label to the frame
        frame.add(resultLabel); // Adding the result label to the frame


        // Event listeners
        convertButton.addActionListener(new ActionListener() { // Adding an ActionListener to the convert button
            public void actionPerformed(ActionEvent e) { // Defining the action to be performed on button click
                convertCurrency(); // Calling the method to convert currency
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting the default close operation to exit the application
        frame.setVisible(true); // Making the frame visible
    }

    // Method to convert CAD to USD
    private void convertCurrency() {
        try {
            // Get input value from text field
            double cadAmount = Double.parseDouble(cadTextField.getText()); // Parsing the input value as a double

            // Convert CAD to USD
            double usdAmount = cadAmount * EXCHANGE_RATE; // Calculating the equivalent USD amount

            // Display the result
            resultLabel.setText(String.format("%.2f", usdAmount)); // Formatting and displaying the result
        } catch (NumberFormatException ex) {
            // Handle invalid input
            resultLabel.setText("Invalid input. Please enter a valid number."); // Displaying an error message for invalid input
        }
    }


}
