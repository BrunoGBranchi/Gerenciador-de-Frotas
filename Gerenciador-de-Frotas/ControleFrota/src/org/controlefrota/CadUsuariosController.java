package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.UsuariosDAO;
import org.controlefrota.model.Usuarios;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//OK - Edit

public class CadUsuariosController {
	
	@FXML
    private TextField tfCodigo;
	
    @FXML
    private PasswordField pfSenha;

    @FXML
    private PasswordField pfSenhaConf;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnCancelar;

    @FXML
    private TextField tfUsuario;

    @FXML
    private TextField tfNome;
    
    @FXML
    private Button btnExcluir;
    
    @FXML
    private TableColumn<Usuarios, String> tbcUsuario;
    
    @FXML
    private TableColumn<Usuarios, String> tbcNome;
    
    @FXML
    private TableColumn<Usuarios, Integer> tbcCodigo;
    
    @FXML
    private TableColumn<Usuarios, String> tbcDatacad;
    
    @FXML
    private TableColumn<Usuarios, String> tbcSenha;

    @FXML
    private TableView<Usuarios> tblUsuarios;
    
    private UsuariosDAO usuariosDao = AbstractFactory.get().usuariosDao();
    
    private Usuarios usuario;
    
    private boolean editando;
    
    @FXML
	public void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		tbcSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
		tbcDatacad.setCellValueFactory(new PropertyValueFactory<>("datacad"));
		tblUsuarios.setItems(FXCollections.observableArrayList(usuariosDao.listar()));
		novoUsuario();
	}

    @FXML
    void cadastrar(ActionEvent event) {
    	populaUsuario();
		
		if (editando) {
			usuariosDao.alterar(usuario);
			
		} else {
			usuariosDao.inserir(usuario);
		}
		novoUsuario();
		tblUsuarios.refresh();
    }

    @FXML
    void cancelar(ActionEvent event) {
    	Stage stage = new Stage();  
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gerenciador de Frotas - V1.1 Alpha");
            stage.show();
            stage.setMaximized(true);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            stage = (Stage) btnCancelar.getScene().getWindow();
            stage.close(); //fecha a pagina atual antes de sair
        }
    }
    
    @FXML
    void excluir(ActionEvent event) {
    	usuariosDao.excluir(usuario);
    	novoUsuario();
    }
    
    @FXML
	void selecionaUsuario(MouseEvent event) {
		if (tblUsuarios.getSelectionModel().getSelectedItem() != null) {
			usuario = tblUsuarios.getSelectionModel().getSelectedItem();
			populaTela(usuario);
			editando = true;
			
		}
	}
    
    public void novoUsuario() {
    	tfUsuario.clear();
		tfNome.clear();
		pfSenha.clear();
		pfSenhaConf.clear();
		usuario = new Usuarios();
		editando = false;
		tblUsuarios.setItems(FXCollections.observableArrayList(usuariosDao.listar()));
    }
    
    @FXML
    public void populaUsuario() {
		usuario.setnome(tfNome.getText());
		usuario.setusuario(tfUsuario.getText());
		usuario.setsenha(pfSenha.getText());
		usuario.setdatacad(java.sql.Date.valueOf(LocalDate.now()));
    }
    
    
    public void populaTela(Usuarios usuario) {
		tfNome.setText(usuario.getnome());
		tfUsuario.setText(usuario.getusuario());
		pfSenha.setText(usuario.getsenha());
		pfSenhaConf.setText(usuario.getsenha());
	}
}
