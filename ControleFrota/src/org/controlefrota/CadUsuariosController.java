package org.controlefrota;

import java.time.LocalDate;

import org.controlefrota.dao.UsuariosArquivo;
import org.controlefrota.dao.UsuariosDAO;
import org.controlefrota.model.Usuarios;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

//OK - Edit

public class CadUsuariosController {

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
    
    private UsuariosDAO usuariosDao = new UsuariosArquivo();
    
    private Usuarios usuario;
    
    private boolean editando;
    
    private Integer novocodigo;
    
	public void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("usua_codigo"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("usua_nome"));
		tbcUsuario.setCellValueFactory(new PropertyValueFactory<>("usua_usuario"));
		tbcDatacad.setCellValueFactory(new PropertyValueFactory<>("usua_datacad"));
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
    	btnCancelar.getScene().getWindow().hide();
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
    
    public void populaUsuario() {
    	novocodigo=Usuarios.getNextUsua_codigo();
		usuario.setUsua_codigo(Integer.valueOf(novocodigo));
		usuario.setUsua_nome(tfNome.getText());
		usuario.setUsua_usuario(tfUsuario.getText());
		usuario.setUsua_senha(pfSenha.getText());
		usuario.setUsua_datacad(LocalDate.now());
    }
    
    public void populaTela(Usuarios usuario) {
		tfNome.setText(usuario.getUsua_nome());
		tfUsuario.setText(usuario.getUsua_usuario());
		pfSenha.setText(usuario.getUsua_senha());
		pfSenhaConf.setText(usuario.getUsua_senha());
	}
}
