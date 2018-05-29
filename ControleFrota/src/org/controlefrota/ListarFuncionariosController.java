package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;

import org.controlefrota.dao.FuncionarioArquivo;
import org.controlefrota.dao.FuncionarioDAO;
import org.controlefrota.model.Funcionarios;
//import org.controlefrota.CadFuncionariosController;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

//OK Edit - Date

public class ListarFuncionariosController {

	@FXML
	private Button btnEditCad;

	@FXML
	private Button btnIncluir;

	@FXML
	private Button btnVoltar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btAtualizar;

	@FXML
	private TableColumn<Funcionarios, String> tbcCPF;

	@FXML
	private TableColumn<Funcionarios, String> tbcNome;

	@FXML
	private TableColumn<Funcionarios, String> tbcCargo;

	@FXML
	public TableView<Funcionarios> tblFuncionarios;

	// private CadFuncionariosController fncControl = new
	// CadFuncionariosController();

	// private boolean editando;

	private FuncionarioDAO funcionarioDao = new FuncionarioArquivo();

	private Funcionarios funcionario;

	public void initialize() {
		tbcCPF.setCellValueFactory(new PropertyValueFactory<>("func_cpf"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("func_nome"));
		tbcCargo.setCellValueFactory(new PropertyValueFactory<>("func_cargo"));
		tblFuncionarios.setItems(FXCollections.observableArrayList(funcionarioDao.listar()));
	}

	@FXML

	void incluir(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("CadFuncionarios.fxml"));

			ListarFuncionariosController cadastro = fxmlLoader.getController();
			cadastro.setGerenciadorController(this);
			
			Scene scene = new Scene(fxmlLoader.load());
			Stage stage = new Stage();
			stage.setTitle("Cadastrar Funcionarios");
			stage.setResizable(false);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setGerenciadorController(ListarFuncionariosController listarFuncionariosController) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	void editarCadastro(ActionEvent event) {
		if (tblFuncionarios.getSelectionModel().getSelectedItem() != null) {

			funcionario = tblFuncionarios.getSelectionModel().getSelectedItem();
			// fncControl.populaTela(funcionario);
			// PrincipalController.edit = true;
			// PrincipalController.nome=funcionario.getFunc_nome();

			v_Func_codigo = funcionario.getFunc_codigo();
			v_Func_agencia = funcionario.getFunc_agencia();
			v_Func_bairro = funcionario.getFunc_bairro();
			v_Func_banco = funcionario.getFunc_banco();
			v_Func_cargahoraria = funcionario.getFunc_cargahoraria();
			v_Func_cargo = funcionario.getFunc_cargo();
			v_Func_cep = funcionario.getFunc_cep();
			v_Func_conta = funcionario.getFunc_conta();
			v_Func_cpf = funcionario.getFunc_cpf();
			v_Func_ctps = funcionario.getFunc_ctps();
			v_Func_datacad = funcionario.getFunc_datacad().toString();
			v_Func_dtadmissao = funcionario.getFunc_dtadmissao();
			v_Func_dtnasc = funcionario.getFunc_dtnasc();
			v_Func_endereco = funcionario.getFunc_endnumero();
			v_Func_endnumero = funcionario.getFunc_endnumero();
			v_Func_muni_codigo = funcionario.getFunc_muni_codigo();
			v_Func_muni_uf = funcionario.getFunc_muni_uf();
			v_Func_nome = funcionario.getFunc_nome();
			v_Func_rg = funcionario.getFunc_rg();
			v_Func_salario = funcionario.getFunc_salario().toString();
			edit = true;
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("CadFuncionarios.fxml"));
				Scene scene = new Scene(fxmlLoader.load());
				Stage stage = new Stage();
				stage.setTitle("Cadastrar Funcionarios");
				stage.setResizable(false);
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void voltar(ActionEvent event) {
		btnVoltar.getScene().getWindow().hide();
	}

	public Button getBtAtualizar() {
		return btAtualizar;
	}

	@FXML
	void SelecionaFuncionario(MouseEvent event) {
		// void SelecionaFuncionario(MouseEvent event) {
		if (tblFuncionarios.getSelectionModel().getSelectedItem() != null) {
			funcionario = tblFuncionarios.getSelectionModel().getSelectedItem();
			// fncControl.populaTela(funcionario);
			// PrincipalController.edit = false;
			// PrincipalController.nome=funcionario.getFunc_nome();
			edit = false;
			tblFuncionarios.refresh();
		}
	}

	@FXML
	void excluir(ActionEvent event) {
		funcionarioDao.excluir(funcionario);
		tblFuncionarios.refresh();
	}

	@FXML
	void atualizar(ActionEvent event) {
		tblFuncionarios.setItems(FXCollections.observableArrayList(funcionarioDao.listar()));
	}
	
	/* Variáveis que serão utilizadas na próxima tela */
	public static boolean edit = false;
	public static Integer v_Func_codigo = 0;
	public static String v_Func_agencia = "";
	public static String v_Func_bairro = "";
	public static String v_Func_banco = "";
	public static String v_Func_cargahoraria = "";
	public static String v_Func_cargo = "";
	public static String v_Func_cep = "";
	public static String v_Func_conta = "";
	public static String v_Func_cpf = "";
	public static String v_Func_ctps = "";
	public static String v_Func_datacad = "";
	public static LocalDate v_Func_dtadmissao = LocalDate.MAX;
	public static String v_Func_dtnasc = "";
	public static String v_Func_endereco = "";
	public static String v_Func_endnumero = "";
	public static String v_Func_muni_codigo = "";
	public static String v_Func_muni_uf = "";
	public static String v_Func_nome = "";
	public static String v_Func_rg = "";
	public static String v_Func_salario = "";

}
