package org.controlefrota;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.controlefrota.conexao.ConexaoUtil;
import org.controlefrota.dao.AbstractFactory;
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
import javafx.stage.Modality;
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

	UsuariosDAO usuariosDao = AbstractFactory.get().usuariosDao();
	
	Usuarios usuario;
	
	@FXML
	void cancelar(ActionEvent event) {
		System.exit(0);
	}
	
	@FXML
	private void logar(ActionEvent event) throws IOException {
		try {
		
		Connection con = ConexaoUtil.getConn();
		String usua = tfusuario.getText();
		String sen = pfsenha.getText();
		String sql = "select usuario, senha from usuarios where usuario='"+usua+"'and senha='"+sen+"'";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (tfusuario.getText().equals("") || (pfsenha.getText().equals(""))) {
			JOptionPane.showMessageDialog(null, "Campos não podem ser nulos.");
		}
		if (rs.next()) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Principal.fxml"));
			try {
				BorderPane cursoView = (BorderPane) loader.load();
				bpPrincipal.setCenter(cursoView);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usário ou senha incorretos!");
			pfsenha.setText("");
		}
		} catch(SQLException e){
			e.printStackTrace();
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
