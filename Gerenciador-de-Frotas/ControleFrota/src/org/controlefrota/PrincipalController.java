package org.controlefrota;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrincipalController {

	@FXML
	private BorderPane bpPrincipal;

	@FXML
	private Menu mnCad;

	@FXML
	private MenuItem mnimpresa;

	@FXML
	private MenuItem mniveiculos;

	@FXML
	private MenuItem mniFuncionarios;

	@FXML
	private MenuItem mniManutencao;

	@FXML
	private MenuItem mniMovimentos;

	@FXML
	private MenuItem mniUsuarios;

	@FXML
	private Menu mnFechar;

	@FXML
	void fechar(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void menuManutencao(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadManutencao.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuEmpresa(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadEmpresa.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}	

	@FXML
	void menuFuncionarios(ActionEvent event) {	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("ListarFuncionarios.fxml"));
		try {
			ListarFuncionariosController.edit=false;
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@FXML
	void menuMovimentos(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadMovimentos.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}

	@FXML
	void menuUsuarios(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadUsuarios.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}

	@FXML
	void menuVeiculos(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CadVeiculos.fxml"));
		try {
			AnchorPane cursoView = (AnchorPane) loader.load();
			bpPrincipal.setCenter(cursoView);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	}

	@FXML
	void mncad(ActionEvent event) {

	}
	
//	public static boolean edit=false;
//	public static String nome = "";

}
