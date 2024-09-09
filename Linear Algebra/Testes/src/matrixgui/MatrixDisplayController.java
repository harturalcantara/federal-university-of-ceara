package matrixgui;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import matrixgui.model.AlertBox;
import matrixgui.model.Matrix;
import matrixgui.utils.MatrixUtils;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class that is responsible for displaying GUI and handling user events
 */
public class MatrixDisplayController implements Initializable {

    // constants
    private Insets PADDING_INSETS = new Insets(15, 0, 0, 0);
    private double SPACING_SETTING = 20D;
    private double MAX_WIDTH_TEXT_FIELD = 250D;
    private double MAX_WIDTH_BUTTON = 100D;
    private double MAX_HEIGHT_BUTTON = 40D;

    // data
    private Matrix matrixA;
    private Matrix matrixB;
    private Matrix matrixC;

    // UI
    // matrices calculations
    public VBox displayMatrixVbox;
    public HBox matrixAndMatrixHBox;
    private GridPane gridPaneA;
    private GridPane gridPaneB;
    private GridPane gridPaneC;

    // transfer
    private HBox hBoxTransferMatrix;
    private TextField firstMatrixTransferTextField;
    private TextField secondMatrixTransferTextField;
    private Button transferButton;

    // swap
    private HBox hBoxSwapMatrix;
    private TextField firstMatrixSwapTextField;
    private TextField secondMatrixSwapTextField;
    private Button swapButton;

    // transpose
    private HBox hBoxTransposeMatrix;
    private TextField transposeMatrixTextField;
    private Button transposeButton;

    // scalar
    private HBox hBoxScalarMatrix;
    private TextField firstMatrixScalarTextField;
    private TextField secondMatrixScalarTextField;
    private Button scalarButton;

    // biggest in line
    private HBox hBoxBiggestSumMatrix;
    private TextField firstMatrixBiggestSumTextField;
    private Label secondMatrixBiggestSumLabel;
    private Button biggestSumButton;

    // prompts for dimensions
    private Label labelMatrixA;
    private TextField textFieldNumberOfRowsMatrixA;
    private TextField textFieldNumberOfColumnsMatrixA;
    private Button buttonSetMatrixA;

    private Label labelMatrixB;
    private TextField textFieldNumberOfRowsMatrixB;
    private TextField textFieldNumberOfColumnsMatrixB;
    private Button buttonSetMatrixB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Matrix A
        matrixA = Matrix.randomWithReservedState(6, 6);
        MatrixUtils.saveMatrix(matrixA, "matrixA");
        gridPaneA = MatrixUtils.createGridPaneFromMatrix(matrixA);
        MatrixUtils.displayMatrixOnGridPane(gridPaneA, matrixA);
        matrixAndMatrixHBox.getChildren().add(gridPaneA);

        // Buttons
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 0, 0, 0));
        vBox.setSpacing(SPACING_SETTING);
        Button buttonAddition = MatrixUtils.getButton("     +      ");
        Button buttonSubtraction = MatrixUtils.getButton("      -      ");
        Button buttonMultiplication = MatrixUtils.getButton("       *       ");
        vBox.getChildren().addAll(buttonAddition, buttonSubtraction, buttonMultiplication);
        matrixAndMatrixHBox.getChildren().add(vBox);

        //Matrix B
        matrixB = Matrix.randomWithReservedState(6, 6);
        MatrixUtils.saveMatrix(matrixA, "matrixB");
        gridPaneB = MatrixUtils.createGridPaneFromMatrix(matrixB);
        MatrixUtils.displayMatrixOnGridPane(gridPaneB, matrixB);
        matrixAndMatrixHBox.getChildren().add(gridPaneB);

        // Equals Label
        Label label = new Label();
        label.setText("=");
        label.setPadding(PADDING_INSETS);
        matrixAndMatrixHBox.getChildren().add(label);

        // Matrix C
        showResultMatrix(matrixA.plus(matrixB));

        // transfer options
        createTransferItems();
        setListenersTransferOptions();

        // swap
        createSwapItems();
        setListenersSwapOptions();

        // transpose
        createTransposeItems();
        setListenersTransposeOptions();

        // scalar multiplication
        createScalarItems();
        setListenersScalar();

        // biggest in line
        createBiggestSumItems();
        setListenersBiggestSum();

        // prompts for dimensions
        setPromptForMatrixA();
        setPromptForMatrixB();
        setListenersFirstRow(buttonAddition, buttonSubtraction, buttonMultiplication);
        setListenersButtonSetMatrixA(buttonSetMatrixA, textFieldNumberOfRowsMatrixA, textFieldNumberOfColumnsMatrixA);
        setListenersButtonSetMatrixB(buttonSetMatrixB, textFieldNumberOfRowsMatrixB, textFieldNumberOfColumnsMatrixB);
    }

    /**
     * Creates GUI for transferring matrices option
     */
    private void createTransferItems() {
        // transfer matrix
        hBoxTransferMatrix = new HBox();
        hBoxTransferMatrix.setPadding(PADDING_INSETS);
        hBoxTransferMatrix.setSpacing(SPACING_SETTING);

        firstMatrixTransferTextField = new TextField();
        firstMatrixTransferTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        firstMatrixTransferTextField.setPromptText("Number of the matrix");

        transferButton = new Button();
        transferButton.setMaxWidth(MAX_WIDTH_BUTTON);
        transferButton.setMaxHeight(MAX_HEIGHT_BUTTON);
        transferButton.setText("Transfer to");

        secondMatrixTransferTextField = new TextField();
        secondMatrixTransferTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        secondMatrixTransferTextField.setPromptText("Position of the matrix");

        hBoxTransferMatrix.getChildren().addAll(firstMatrixTransferTextField, transferButton, secondMatrixTransferTextField);
        displayMatrixVbox.getChildren().addAll(hBoxTransferMatrix);
    }

    /**
     * Sets listeners for transferring matrices option
     */
    private void setListenersTransferOptions() {
        transferButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer matrixOption = null;
                Integer transferOption = null;

                // handle incorrect input
                try {
                    matrixOption = Integer.parseInt(firstMatrixTransferTextField.getText().trim());
                    transferOption = Integer.parseInt(secondMatrixTransferTextField.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers between 1 and 3");
                }

                // handle user's event
                if (matrixOption != null && transferOption != null) {
                    if ((matrixOption >= 1 && matrixOption <= 3 && (transferOption >= 1 && transferOption <= 3))) {
                        Matrix matrix = null;
                        matrixA = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA);
                        matrixB = MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB);
                        matrixC = MatrixUtils.createNewMatrixFromGridPane(matrixC, gridPaneC);

                        switch (matrixOption) {
                            case 1:
                                matrix = matrixA;
                                matrixA = matrix;
                                break;
                            case 2:
                                matrix = matrixB;
                                matrixB = matrix;
                                break;
                            case 3:
                                matrix = matrixC;
                                matrixC = matrix;
                                break;
                        }

                        switch (transferOption) {
                            case 1:
                                matrixA = matrix;
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneA);
                                gridPaneA = MatrixUtils.createGridPaneFromMatrix(matrix);
                                matrixAndMatrixHBox.getChildren().add(0, gridPaneA);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneA, matrix);
                                break;
                            case 2:
                                matrixB = matrix;
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneB);
                                gridPaneB = MatrixUtils.createGridPaneFromMatrix(matrix);
                                matrixAndMatrixHBox.getChildren().add(2, gridPaneB);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneB, matrix);
                                break;
                            case 3:
                                matrixC = matrix;
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneC);
                                gridPaneC = MatrixUtils.createGridPaneFromMatrix(matrix);
                                matrixAndMatrixHBox.getChildren().add(4, gridPaneC);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneC, matrix);
                                break;
                        }
                    } else {
                        AlertBox.display("Error", "The numbers should be from 1 to 3");
                    }
                }
            }
        });
    }

    /**
     * Creates GUI for swapping matrices option
     */
    private void createSwapItems() {
        hBoxSwapMatrix = new HBox();
        hBoxSwapMatrix.setPadding(PADDING_INSETS);
        hBoxSwapMatrix.setSpacing(SPACING_SETTING);

        firstMatrixSwapTextField = new TextField();
        firstMatrixSwapTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        firstMatrixSwapTextField.setPromptText("Number of the matrix");

        swapButton = new Button();
        swapButton.setMaxWidth(MAX_WIDTH_BUTTON);
        swapButton.setMaxHeight(MAX_HEIGHT_BUTTON);
        swapButton.setText("Swap with");

        secondMatrixSwapTextField = new TextField();
        secondMatrixSwapTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        secondMatrixSwapTextField.setPromptText("Number of the matrix");

        hBoxSwapMatrix.getChildren().addAll(firstMatrixSwapTextField, swapButton, secondMatrixSwapTextField);
        displayMatrixVbox.getChildren().addAll(hBoxSwapMatrix);
    }

    /**
     * Sets listeners for swapping matrices option
     */
    private void setListenersSwapOptions() {
        swapButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer swapOptionFirst = null;
                Integer swapOptionSecond = null;

                // handle incorrect input
                try {
                    swapOptionFirst = Integer.parseInt(firstMatrixSwapTextField.getText().trim());
                    swapOptionSecond = Integer.parseInt(secondMatrixSwapTextField.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers between 1 and 3");
                }
                // handle user's event
                if (swapOptionFirst != null && swapOptionSecond != null) {
                    if ((swapOptionFirst >= 1 && swapOptionFirst <= 3 && (swapOptionSecond >= 1 && swapOptionSecond <= 3))) {
                        matrixA = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA);
                        matrixB = MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB);
                        matrixC = MatrixUtils.createNewMatrixFromGridPane(matrixC, gridPaneC);

                        Matrix helpMatrix = null;
                        if ((swapOptionFirst == 1 && swapOptionSecond == 2) || swapOptionFirst == 2 && swapOptionSecond == 1) {
                            helpMatrix = matrixA;
                            matrixA = matrixB;
                            matrixB = helpMatrix;
                        }

                        if ((swapOptionFirst == 2 && swapOptionSecond == 3) || swapOptionFirst == 3 && swapOptionSecond == 2) {
                            helpMatrix = matrixB;
                            matrixB = matrixC;
                            matrixC = helpMatrix;
                        }

                        if ((swapOptionFirst == 1 && swapOptionSecond == 3) || swapOptionFirst == 3 && swapOptionSecond == 1) {
                            helpMatrix = matrixA;
                            matrixA = matrixC;
                            matrixC = helpMatrix;
                        }

                        displayEverything();

                    } else {
                        AlertBox.display("Error", "The numbers should be from 1 to 3. Also you can't swap matrix with itself");
                    }
                }

            }
        });
    }

    /**
     * Displays all matrices
     */
    private void displayEverything() {
        matrixAndMatrixHBox.getChildren().removeAll(gridPaneA);
        gridPaneA = MatrixUtils.createGridPaneFromMatrix(matrixA);
        matrixAndMatrixHBox.getChildren().add(0, gridPaneA);
        MatrixUtils.displayMatrixOnGridPane(gridPaneA, matrixA);

        matrixAndMatrixHBox.getChildren().removeAll(gridPaneB);
        gridPaneB = MatrixUtils.createGridPaneFromMatrix(matrixB);
        matrixAndMatrixHBox.getChildren().add(2, gridPaneB);
        MatrixUtils.displayMatrixOnGridPane(gridPaneB, matrixB);

        matrixAndMatrixHBox.getChildren().removeAll(gridPaneC);
        gridPaneC = MatrixUtils.createGridPaneFromMatrix(matrixC);
        matrixAndMatrixHBox.getChildren().add(4, gridPaneC);
        MatrixUtils.displayMatrixOnGridPane(gridPaneC, matrixC);
    }

    /**
     * Creates GUI for transposing matrices option
     */
    private void createTransposeItems() {
        hBoxTransposeMatrix = new HBox();
        hBoxTransposeMatrix.setPadding(PADDING_INSETS);
        hBoxTransposeMatrix.setSpacing(SPACING_SETTING);

        transposeMatrixTextField = new TextField();
        transposeMatrixTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        transposeMatrixTextField.setPromptText("Number of the matrix");

        transposeButton = new Button();
        transposeButton.setMaxWidth(MAX_WIDTH_BUTTON);
        transposeButton.setMaxHeight(MAX_HEIGHT_BUTTON);
        transposeButton.setText("Transpose");

        hBoxTransposeMatrix.getChildren().addAll(transposeMatrixTextField, transposeButton);
        displayMatrixVbox.getChildren().addAll(hBoxTransposeMatrix);
    }

    /**
     * Sets listeners for transposing matrices option
     */
    private void setListenersTransposeOptions() {
        transposeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer transposeOption = null;

                // handle incorrect input
                try {
                    transposeOption = Integer.parseInt(transposeMatrixTextField.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers between 1 and 3");
                }

                // handle user's event
                if (transposeOption != null) {
                    if ((transposeOption >= 1 && transposeOption <= 3)) {
                        Matrix matrix = null;
                        matrixA = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA);
                        matrixB = MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB);
                        matrixC = MatrixUtils.createNewMatrixFromGridPane(matrixC, gridPaneC);
                        switch (transposeOption) {
                            case 1:
                                matrix = matrixA.transpose();
                                matrixA = matrix;
                                break;
                            case 2:
                                matrix = matrixB.transpose();
                                matrixB = matrix;
                                break;
                            case 3:
                                matrix = matrixC.transpose();
                                matrixC = matrix;
                                break;
                        }

                        switch (transposeOption) {
                            case 1:
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneA);
                                gridPaneA = MatrixUtils.createGridPaneFromMatrix(matrixA);
                                matrixAndMatrixHBox.getChildren().add(0, gridPaneA);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneA, matrixA);
                                break;
                            case 2:
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneB);
                                gridPaneB = MatrixUtils.createGridPaneFromMatrix(matrixB);
                                matrixAndMatrixHBox.getChildren().add(2, gridPaneB);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneB, matrixB);
                                break;
                            case 3:
                                matrixAndMatrixHBox.getChildren().removeAll(gridPaneC);
                                gridPaneC = MatrixUtils.createGridPaneFromMatrix(matrixC);
                                matrixAndMatrixHBox.getChildren().add(4, gridPaneC);
                                MatrixUtils.displayMatrixOnGridPane(gridPaneC, matrixC);
                                break;
                        }
                    } else {
                        AlertBox.display("Error", "The numbers should be from 1 to 3");
                    }
                }
            }
        });
    }

    /**
     * Creates GUI for multiplication by scalar option
     */
    private void createScalarItems() {
        hBoxScalarMatrix = new HBox();
        hBoxScalarMatrix.setPadding(PADDING_INSETS);
        hBoxScalarMatrix.setSpacing(SPACING_SETTING);

        firstMatrixScalarTextField = new TextField();
        firstMatrixScalarTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        firstMatrixScalarTextField.setPromptText("Number of the matrix");

        scalarButton = new Button();
        scalarButton.setMaxWidth(MAX_WIDTH_BUTTON);
        scalarButton.setMaxHeight(MAX_HEIGHT_BUTTON);
        scalarButton.setText("Multiply by");

        secondMatrixScalarTextField = new TextField();
        secondMatrixScalarTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        secondMatrixScalarTextField.setPromptText("Number to multiply by");

        hBoxScalarMatrix.getChildren().addAll(firstMatrixScalarTextField, scalarButton, secondMatrixScalarTextField);
        displayMatrixVbox.getChildren().addAll(hBoxScalarMatrix);
    }

    /**
     * Sets listeners for multiplication by scalar option
     */
    private void setListenersScalar() {
        scalarButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer scalarOptionFirst = null;
                Double scalar = null;

                // handle incorrect input
                try {
                    scalarOptionFirst = Integer.parseInt(firstMatrixScalarTextField.getText().trim());
                    scalar = Double.parseDouble(secondMatrixScalarTextField.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers between 1 and 3");
                }
                // handle user's event
                if (scalarOptionFirst != null) {
                    if ((scalarOptionFirst >= 1 && scalarOptionFirst <= 3)) {
                        matrixA = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA);
                        matrixB = MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB);
                        matrixC = MatrixUtils.createNewMatrixFromGridPane(matrixC, gridPaneC);

                        switch (scalarOptionFirst) {
                            case 1:
                                matrixB = new Matrix(1, 1);
                                matrixB.data[0][0] = scalar;
                                matrixC = matrixA.timesNumber(scalar);
                                break;
                            case 2:
                                matrixA = matrixB;
                                matrixC = matrixB.timesNumber(scalar);
                                matrixB = new Matrix(1, 1);
                                matrixB.data[0][0] = scalar;
                                break;
                            case 3:
                                matrixA = matrixC;
                                matrixC = matrixC.timesNumber(scalar);
                                matrixB = new Matrix(1, 1);
                                matrixB.data[0][0] = scalar;
                                break;

                        }
                        displayEverything();
                    } else {
                        AlertBox.display("Error", "The numbers should be from 1 to 3");
                    }
                }
            }
        });
    }

    /**
     * Creates GUI for biggest sum in each line option
     */
    private void createBiggestSumItems() {
        hBoxBiggestSumMatrix = new HBox();
        hBoxBiggestSumMatrix.setPadding(PADDING_INSETS);
        hBoxBiggestSumMatrix.setSpacing(SPACING_SETTING);

        firstMatrixBiggestSumTextField = new TextField();
        firstMatrixBiggestSumTextField.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        firstMatrixBiggestSumTextField.setPromptText("Number of the matrix");

        biggestSumButton = new Button();
        biggestSumButton.setMaxWidth(150);
        biggestSumButton.setMaxHeight(MAX_HEIGHT_BUTTON);
        biggestSumButton.setText("Biggest line's sum");

        secondMatrixBiggestSumLabel = new Label();
        secondMatrixBiggestSumLabel.setMaxWidth(MAX_WIDTH_TEXT_FIELD);

        hBoxBiggestSumMatrix.getChildren().addAll(firstMatrixBiggestSumTextField, biggestSumButton, secondMatrixBiggestSumLabel);
        displayMatrixVbox.getChildren().addAll(hBoxBiggestSumMatrix);
    }

    /**
     * Sets listeners for biggest sum in each line option
     */
    private void setListenersBiggestSum() {
        biggestSumButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer scalarOptionFirst = null;
                Double scalar = null;

                // handle incorrect input
                try {
                    scalarOptionFirst = Integer.parseInt(firstMatrixBiggestSumTextField.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers between 1 and 3");
                }
                // handle user's event
                if (scalarOptionFirst != null) {
                    if ((scalarOptionFirst >= 1 && scalarOptionFirst <= 3)) {
                        matrixA = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA);
                        matrixB = MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB);
                        matrixC = MatrixUtils.createNewMatrixFromGridPane(matrixC, gridPaneC);
                        Double sum = 0D;
                        switch (scalarOptionFirst) {
                            case 1:
                                sum = Matrix.biggestInline(matrixA);
                                break;
                            case 2:
                                sum = Matrix.biggestInline(matrixB);
                                break;
                            case 3:
                                sum = Matrix.biggestInline(matrixC);
                                break;
                        }
                        secondMatrixBiggestSumLabel.setText(String.valueOf(sum));
                    } else {
                        AlertBox.display("Error", "The numbers should be from 1 to 3");
                    }
                }

            }
        });
    }

    /**  Sets listeners to let users type the dimensions of the first Matrix
     *
     * @param buttonSetMatrix           Button to be clicked on
     * @param textFieldNumberOfRows     TextField for user's input
     * @param textFieldNumberOfColumns  TextField for user's input
     */
    private void setListenersButtonSetMatrixA(Button buttonSetMatrix,
                                              TextField textFieldNumberOfRows,
                                              TextField textFieldNumberOfColumns) {

        buttonSetMatrix.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Integer rows = null;
                Integer columns = null;

                // handle incorrect input
                try {
                    rows = Integer.parseInt(textFieldNumberOfRows.getText().trim());
                    columns = Integer.parseInt(textFieldNumberOfColumns.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers");
                }

                if (rows != null && columns != null) {
                    if ((rows > 1 && rows < 10) && (columns > 1 && columns < 10)) {
                        matrixAndMatrixHBox.getChildren().removeAll(gridPaneA);
                        matrixA = new Matrix(rows, columns);
                        MatrixUtils.saveMatrix(matrixA, "matrixA");
                        gridPaneA = MatrixUtils.createGridPaneFromMatrix(matrixA);
                        matrixAndMatrixHBox.getChildren().add(0, gridPaneA);
                        MatrixUtils.displayMatrixOnGridPane(gridPaneA, matrixA);
                    } else {
                        AlertBox.display("Error", "The numbers should be from 2 to 6");
                    }
                }
            }
        });
    }

    /**  Sets listeners to let users type the dimensions of the second Matrix
     *
     * @param buttonSetMatrix           Button to be clicked on
     * @param textFieldNumberOfRows     TextField for user's input
     * @param textFieldNumberOfColumns  TextField for user's input
     */
    private void setListenersButtonSetMatrixB(Button buttonSetMatrix,
                                              TextField textFieldNumberOfRows,
                                              TextField textFieldNumberOfColumns) {

        // set listeners
        buttonSetMatrix.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // handle text input
                Integer rows = null;
                Integer columns = null;

                // handle float numbers
                try {
                    rows = Integer.parseInt(textFieldNumberOfRows.getText().trim());
                    columns = Integer.parseInt(textFieldNumberOfColumns.getText().trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    AlertBox.display("Error", "Please use whole numbers");
                }

                if (rows != null && columns != null) {
                    if ((rows > 1 && rows < 7) && (columns > 1 && columns < 7)) {
                        matrixAndMatrixHBox.getChildren().removeAll(gridPaneB);
                        matrixB = new Matrix(rows, columns);
                        MatrixUtils.saveMatrix(matrixB, "matrixB");
                        gridPaneB = MatrixUtils.createGridPaneFromMatrix(matrixB);
                        matrixAndMatrixHBox.getChildren().add(2, gridPaneB);
                        MatrixUtils.displayMatrixOnGridPane(gridPaneB, matrixB);
                    } else {
                        AlertBox.display("Error", "The numbers should be from 2 to 6");
                    }
                }

            }
        });
    }

    /**
     * Creates GUI for prompt for user's choice of rows and columns for the first Matrix
     */
    private void setPromptForMatrixA() {
        labelMatrixA = new Label();
        labelMatrixA.setText("Please enter the number of rows and columns for the first matrix");
        displayMatrixVbox.getChildren().add(labelMatrixA);

        textFieldNumberOfRowsMatrixA = new TextField();
        textFieldNumberOfRowsMatrixA.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        textFieldNumberOfRowsMatrixA.setPromptText("Number of rows for the first matrix");
        displayMatrixVbox.getChildren().add(textFieldNumberOfRowsMatrixA);

        textFieldNumberOfColumnsMatrixA = new TextField();
        textFieldNumberOfColumnsMatrixA.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        textFieldNumberOfColumnsMatrixA.setPromptText("Number of columns for the first matrix");
        displayMatrixVbox.getChildren().addAll(textFieldNumberOfColumnsMatrixA);

        buttonSetMatrixA = new Button();
        buttonSetMatrixA.setMaxWidth(MAX_WIDTH_BUTTON);
        buttonSetMatrixA.setMaxHeight(MAX_HEIGHT_BUTTON);
        buttonSetMatrixA.setText("Set");
        displayMatrixVbox.getChildren().add(buttonSetMatrixA);
    }
    /**
     * Creates GUI for prompt for user's choice of rows and columns for the second Matrix
     */
    private void setPromptForMatrixB() {
        labelMatrixB = new Label();
        labelMatrixB.setText("Please enter the number of rows and columns for the second matrix");
        displayMatrixVbox.getChildren().add(labelMatrixB);

        textFieldNumberOfRowsMatrixB = new TextField();
        textFieldNumberOfRowsMatrixB.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        textFieldNumberOfRowsMatrixB.setPromptText("Number of rows for the second matrix");
        displayMatrixVbox.getChildren().add(textFieldNumberOfRowsMatrixB);

        textFieldNumberOfColumnsMatrixB = new TextField();
        textFieldNumberOfColumnsMatrixB.setMaxWidth(MAX_WIDTH_TEXT_FIELD);
        textFieldNumberOfColumnsMatrixB.setPromptText("Number of columns for the second matrix");
        displayMatrixVbox.getChildren().add(textFieldNumberOfColumnsMatrixB);

        buttonSetMatrixB = new Button();
        buttonSetMatrixB.setMaxWidth(MAX_WIDTH_BUTTON);
        buttonSetMatrixB.setMaxHeight(MAX_HEIGHT_BUTTON);
        buttonSetMatrixB.setText("Set");
        displayMatrixVbox.getChildren().add(buttonSetMatrixB);
    }

    /**
     * Sets listeners for mathematical operations with 2 matrices: addition, subtraction, multiplication
     * @param buttonAddition       Button for addition operation
     * @param buttonSubtraction    Button for subtraction operation
     * @param buttonMultiplication Button for multiplication operation
     */
    private void setListenersFirstRow(Button buttonAddition, Button buttonSubtraction, Button buttonMultiplication) {
        buttonAddition.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Matrix result = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA).plus(MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB));
                showResultMatrix(result);
            }
        });

        buttonSubtraction.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Matrix result = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA).minus(MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB));
                showResultMatrix(result);
            }
        });

        buttonMultiplication.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Matrix result = MatrixUtils.createNewMatrixFromGridPane(matrixA, gridPaneA).times(MatrixUtils.createNewMatrixFromGridPane(matrixB, gridPaneB));
                showResultMatrix(result);
            }
        });
    }

    /**
     * Displays the resulted matrix of the operations
     * @param matrix    Matrix to display as the result matrix
     */
    private void showResultMatrix(Matrix matrix) {
        // Matrix C
        matrixC = matrix;
        matrixAndMatrixHBox.getChildren().removeAll(gridPaneC);
        MatrixUtils.saveMatrix(matrixC, "matrixC");
        gridPaneC = MatrixUtils.createGridPaneFromMatrix(matrix);
        MatrixUtils.displayMatrixOnGridPane(gridPaneC, matrix);
        matrixAndMatrixHBox.getChildren().add(gridPaneC);
    }

}
