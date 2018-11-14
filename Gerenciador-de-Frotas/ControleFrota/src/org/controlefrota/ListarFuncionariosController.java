package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.FuncionarioDAO;
import org.controlefrota.model.Funcionarios;
import org.controlefrota.CadFuncionariosController;

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
	private TableColumn<Funcionarios, Number> tbcCodigo;
	
	@FXML
	public TableView<Funcionarios> tblFuncionarios;

	 //private CadFuncionariosController fncControl = new
	 //CadFuncionariosController();

	private boolean editando;

	private FuncionarioDAO funcionarioDao = AbstractFactory.get().funcionariosDao();

	private Funcionarios funcionario;
	
	@FXML
	public void initialize() {
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tbcCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		tblFuncionarios.setItems(FXCollections.observableArrayList(funcionarioDao.listar()));
		funcionario = new Funcionarios();
	}

	@FXML
	void incluir(ActionEvent event) {
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

	@FXML
	void editarCadastro(ActionEvent event) {
		if (tblFuncionarios.getSelectionModel().getSelectedItem() != null) {

			funcionario = tblFuncionarios.getSelectionModel().getSelectedItem();
			//fncControl.populaTela(funcionario);
			//PrincipalController.edit = true;
			//PrincipalController.nome = funcionario.getnome();

			codigo = funcionario.getCodigo();
			agencia = funcionario.getAgencia();
			bairro = funcionario.getBairro();
			banco = funcionario.getBanco();
			cargahoraria = funcionario.getCargahoraria();
			cargo = funcionario.getCargo();
			cep = funcionario.getCep();
			conta = funcionario.getConta();
			cpf = funcionario.getCpf();
			ctps = funcionario.getCtps();
			//datacad = funcionario.getdatacad().toString();
			dtadmissao = funcionario.getDtadmissao();
			dtnasc = funcionario.getDtnasc();
			endereco = funcionario.getEndereco();
			endnumero = funcionario.getEndnumero();
			municipio = funcionario.getMunicipio();
			uf = funcionario.getUf();
			nome = funcionario.getNome();
			rg = funcionario.getRg();
			salario = funcionario.getSalario().toString();
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
			//fncControl.populaTela(funcionario);
			//PrincipalController.edit = false;
			//PrincipalController.nome=funcionario.getnome();
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
	public static Integer codigo = 0;
	public static String agencia = "";
	public static String bairro = "";
	public static String banco = "";
	public static String cargahoraria = "";
	public static String cargo = "";
	public static String cep = "";
	public static String conta = "";
	public static String cpf = "";
	public static String ctps = "";
	public static String datacad = "";
	public static LocalDate dtadmissao = LocalDate.MAX;
	public static String dtnasc = "";
	public static String endereco = "";
	public static String endnumero = "";
	public static String municipio = "";
	public static String uf = "";
	public static String nome = "";
	public static String rg = "";
	public static String salario = "";

}
