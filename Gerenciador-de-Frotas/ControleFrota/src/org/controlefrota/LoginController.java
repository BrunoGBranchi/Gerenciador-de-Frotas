package org.controlefrota;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.UsuariosArquivo;
import org.controlefrota.dao.UsuariosDAO;
import org.controlefrota.model.Usuarios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private BorderPane bpPrincipal;
	
	@FXML
    private Button btncadastrar;
	
	@FXML
	private Label lblUsuario;

	@FXML
	private TextField tfusuario;
	
	@FXML
	private Label lblSenha;

	@FXML
	private PasswordField pfsenha;

	@FXML
	private Button btnlogin;

	@FXML
	private Button btncancel;

	@FXML
	void cancelar(ActionEvent event) {
		System.exit(0);
	}
	
	UsuariosDAO usuariosDao = AbstractFactory.get().usuariosDao();
	
	Usuarios usuario;
	
	@FXML
	private void logar(KeyEvent event) {
		if (tfusuario.getText().equals("") || (pfsenha.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Campos não podem ser nulos.");
		}
		if (tfusuario.getText().equals(rs.getString("Login"))
				&& (pfsenha.getText().equals(rs.getString("Senha")))) {
			Node node = (Node) event.getSource();
			Stage stage = (Stage) node.getScene().getWindow();
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("../view/principal.fxml"));
				root.getStylesheets().add("/css/style.css");

			} catch (IOException ex) {
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else {
			JOptionPane.showMessageDialog(null, "Usário ou senha incorretos!");
			pfsenha.setText("");
		}
		}    	

	@FXML
    protected void initialize() {
    	tfusuario.setOnKeyPressed(k ->
    	{
    		final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
    		if (ENTER.match(k)) {
    			pfsenha.requestFocus();
    		}
    	});		
    	pfsenha.setOnKeyPressed(k ->
    	{
    		final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
    		if (ENTER.match(k)) {
    			btnlogin.requestFocus();
    		}
    	});		
    }
	
}
