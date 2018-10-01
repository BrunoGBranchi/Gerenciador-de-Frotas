package org.controlefrota;

import java.io.IOException;

import javax.swing.JOptionPane;

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
import javafx.stage.Screen;
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
	
	UsuariosDAO usuariosDao = new UsuariosArquivo();
	
	Usuarios usuario;
	
	@FXML
	private void logar(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
    		if (tfusuario.getText().equals("") || (pfsenha.getText().equals(""))) 
    		   {
    			 JOptionPane.showMessageDialog(null, "Campos não podem ser nulos.");
    		   }
    		usuario = new Usuarios();
    		usuario.setusuario(tfusuario.getText());
    		usuario.setsenha(pfsenha.getText());
    		
    		if (usuariosDao.comparaigual(usuario)==1) {
    			Node node = (Node) event.getSource();
    			Stage stage = (Stage) node.getScene().getWindow();
    			Parent root = null;
    			try {
    				root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
    				
    			} catch (IOException e1) {
    				e1.printStackTrace();
    			}
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.centerOnScreen();
    			stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight()); 
    			stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
    			stage.setMaximized(true);
    			stage.show();

    		} 
    		else 
    			if (usuariosDao.comparaigual(usuario)==0) 
    			{
    			 JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
    			 pfsenha.setText("");
    			 pfsenha.requestFocus();
    			} 
    		else
    			if (usuariosDao.comparaigual(usuario)==2) 
    			{
    			 JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.\nO Sistema irá abrir a tela de cadastro.");
    			 pfsenha.setText("");
    		    	try {
    					FXMLLoader fxmlLoader = new FXMLLoader();
    					fxmlLoader.setLocation(getClass().getResource("CadUsuarios.fxml"));
    					Scene scene = new Scene(fxmlLoader.load());
    					Stage stage = new Stage();
    					stage.setTitle("Cadastro Usuarios");
    					stage.setResizable(false);
    					stage.setScene(scene);
    					stage.show();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			} 
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
