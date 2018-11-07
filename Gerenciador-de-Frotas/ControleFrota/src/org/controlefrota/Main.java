package org.controlefrota;
	
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Gerenciador de Frotas - V1.1 Alpha");
			primaryStage.setMinWidth(450);
		    primaryStage.setMinHeight(300);
		    primaryStage.getIcons().clear();
		    Screen screen = Screen.getPrimary();
		    Rectangle2D bounds = screen.getVisualBounds();
		    primaryStage.setWidth(bounds.getWidth());
		    primaryStage.setHeight(bounds.getHeight());
		    primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.setProperty("tipoPersistencia", 
				TipoPersistencia.BANCO.name());
		if(args.length > 0){
			System.setProperty("tipoConexao", args[0]);
		}
		launch(args);
	}
	
	
}
