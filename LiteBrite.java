/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS151.HW3;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author narayan
 */
public class LiteBrite extends Application implements EventHandler<ActionEvent> {
    public ColorPicker wantedColor;
    @Override
    public void start(final Stage stage) throws Exception {
        int rows = 40;
        int columns = 40;

        
        stage.setTitle("LiteBrite");

        GridPane grid = new GridPane();								//new gridPane
        wantedColor = new ColorPicker();							//new color picker
        VBox vb = new VBox();										//new vertical box
        vb.getChildren().addAll(wantedColor, grid);					//adds colorpicker and gridpane to vertical box
        
        grid.getStyleClass().add("game-grid");						//adds the grid properties 

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(10);	//adds column constraints to the grid
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(10);			//adds row constraints to the grid
            grid.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Pane pane = new Pane();								//a pane for each point in the grid		
                pane.setOnMouseReleased(e -> {						//if mouse is released over the pane
                	pane.getChildren().clear();						//clears children in pane and adds a new pane and color
                	 pane.getChildren().add(Anims.getAtoms(wantedColor.getValue()));
                	 
                	 //This code directly changes the existing background of the selected pane                	 
//                	 Paint fill = wantedColor.getValue();
//                     BackgroundFill backgroundFill = new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY);
//                     Background newBackground = new Background(backgroundFill);
//                     pane.setBackground(newBackground);                    
                     
                });
                pane.getStyleClass().add("game-grid-cell");			//adds the pane properties
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                grid.add(pane, i, j);
            }
        }


        
       
      
        
        Scene scene = new Scene(vb, (columns * 10)+20,vb.getHeight() - 20);	//creates a new scene with all fx elements added in it
        scene.getStylesheets().add(LiteBrite.class.getResource("game.css").toExternalForm());	//gets the scene properties
        stage.setScene(scene);										//sets the screen of the program
        stage.show();												//show the stage
    }

    
    public static class Anims {

        public static Node getAtoms(final Color color) {			//creates a node that is added to the pane
            
            Node newNode = new Rectangle(10,10,color);
            return newNode;
        }
    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
    
}
