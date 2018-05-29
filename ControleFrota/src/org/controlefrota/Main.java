package org.controlefrota;
	
import java.io.IOException;

import org.controlefrota.dao.EmpresaArquivo;
import org.controlefrota.dao.EmpresaDAO;
import org.controlefrota.dao.FuncionarioArquivo;
import org.controlefrota.dao.FuncionarioDAO;
import org.controlefrota.dao.ManutencaoArquivo;
import org.controlefrota.dao.ManutencaoDAO;
import org.controlefrota.dao.MovimentosArquivo;
import org.controlefrota.dao.MovimentosDAO;
import org.controlefrota.dao.UsuariosArquivo;
import org.controlefrota.dao.UsuariosDAO;
import org.controlefrota.dao.VeiculosArquivo;
import org.controlefrota.dao.VeiculosDAO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
    EmpresaDAO empresas = new EmpresaArquivo();
    FuncionarioDAO funcionarios = new FuncionarioArquivo();
    ManutencaoDAO manutencao = new ManutencaoArquivo();
    MovimentosDAO movimentos = new MovimentosArquivo();
    UsuariosDAO usuarios = new UsuariosArquivo();
    VeiculosDAO veiculos = new VeiculosArquivo();
    
	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			empresas.tabelas(null);
			funcionarios.tabelas(null);
			manutencao.tabelas(null);
			movimentos.tabelas(null);
			usuarios.tabelas(null);
			veiculos.tabelas(null);
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Gerenciador de Frotas - V1.0 Beta");
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
		launch(args);
	}
	
	
}
