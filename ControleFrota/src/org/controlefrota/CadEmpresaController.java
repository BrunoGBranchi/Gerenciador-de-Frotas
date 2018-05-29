package org.controlefrota;

import org.controlefrota.dao.EmpresaArquivo;
import org.controlefrota.dao.EmpresaDAO;
import org.controlefrota.model.Empresa;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

//OK - Edit
public class CadEmpresaController {

	@FXML
	private AnchorPane apPrincipal;

	@FXML
	private Button btnCancel;

	@FXML
	private TextField tfFantasia;

	@FXML
	private TextField tfRazao;

	@FXML
	private TextField tfNum;

	@FXML
	private TextField tfCNPJ;

	@FXML
	private TextField tfCidade;

	@FXML
	private Button btnCad;

	@FXML
	private ComboBox<String> cbxUF;

	@FXML
	private TextField tfBairro;

	@FXML
	private TextField tfRua;

	@FXML
	private TextField tfCEP;

	@FXML
	private Button btnListar;

	@FXML
	private Button btnExcluir;

	@FXML
	private TableColumn<Empresa, String> tbcEndereco;

	@FXML
	private TableColumn<Empresa, String> tbcNumero;

	@FXML
	private TableColumn<Empresa, String> tbcCidade;

	@FXML
	private TableColumn<Empresa, String> tbcUF;

	@FXML
	private TableColumn<Empresa, String> tbcBairro;

	@FXML
	private TableColumn<Empresa, String> tbcCEP;

	@FXML
	private TableColumn<Empresa, Integer> tbcCodigo;

	@FXML
	private TableColumn<Empresa, String> tbcNomeFantasia;

	@FXML
	private TableColumn<Empresa, String> tbcRazao;

	@FXML
	private TableColumn<Empresa, String> tbcCNPJ;

	@FXML
	private TableView<Empresa> tblEmpresa;

	private EmpresaDAO empresaDao = new EmpresaArquivo();

	private Empresa empresa;

	private boolean editando;
	
	private Integer novocodigo;
	
	public void initialize() {
		
		cbxUF.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
				"PB", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO");
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("empr_codigo"));
		tbcCNPJ.setCellValueFactory(new PropertyValueFactory<>("empr_cnpj"));
		tbcRazao.setCellValueFactory(new PropertyValueFactory<>("empr_razaoSocial"));
		tbcNomeFantasia.setCellValueFactory(new PropertyValueFactory<>("empr_nomeFantasia"));
		tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("empr_endereco"));
		tbcBairro.setCellValueFactory(new PropertyValueFactory<>("empr_bairro"));
		tbcNumero.setCellValueFactory(new PropertyValueFactory<>("empr_numero"));
		tbcCEP.setCellValueFactory(new PropertyValueFactory<>("empr_cep"));
		tbcCidade.setCellValueFactory(new PropertyValueFactory<>("empr_muni_codigo"));
		tbcUF.setCellValueFactory(new PropertyValueFactory<>("empr_muni_uf"));
		
		novaEmpresa();

	}

	@FXML
	void cadastrar(ActionEvent event) {
		populaEmpresa();

		if (editando) {
			empresaDao.alterar(empresa);

		} else {
			empresaDao.inserir(empresa);
		}
		novaEmpresa();
		tblEmpresa.refresh();

	}

	@FXML
	void cancelar(ActionEvent event) {
		btnCancel.getScene().getWindow().hide();
	}

	@FXML
	void excluir(ActionEvent event) {
		empresaDao.excluir(empresa);
		novaEmpresa();
	}

	@FXML
	void selecionarEmpresa(MouseEvent event) {
		if (tblEmpresa.getSelectionModel().getSelectedItem() != null) {
			empresa = tblEmpresa.getSelectionModel().getSelectedItem();
			populaTela(empresa);
			editando = true;
			System.out.println("Selected");
		}
	}

	

	public void novaEmpresa() {
		tfRazao.clear();
		tfFantasia.clear();
		tfNum.clear();
		tfCNPJ.clear();
		tfCidade.clear();
		tfRua.clear();
		tfCEP.clear();
		tfBairro.clear();
		cbxUF.getSelectionModel().clearSelection();
		empresa = new Empresa();
		editando = false;
		cbxUF.getSelectionModel().clearSelection();
		tblEmpresa.setItems(FXCollections.observableArrayList(empresaDao.listar()));

	}

	public void populaEmpresa() {
		novocodigo=Empresa.getNextEmpr_codigo();
		empresa.setEmpr_codigo(Integer.valueOf(novocodigo));
		empresa.setEmpr_razaoSocial(tfRazao.getText());
		empresa.setEmpr_nomeFantasia(tfFantasia.getText());
		empresa.setEmpr_cnpj(tfCNPJ.getText());
		empresa.setEmpr_endereco(tfRua.getText());
		empresa.setEmpr_numero(tfNum.getText());
		empresa.setEmpr_bairro(tfBairro.getText());
		empresa.setEmpr_muni_codigo(tfCidade.getText());
		empresa.setEmpr_muni_uf(cbxUF.getSelectionModel().getSelectedItem().toString());
		empresa.setEmpr_cep(tfCEP.getText());
	}
	
	//private void populaCombo(){
		//for(Empresa empresa: empresaDao.listar()){
			//cbxUF.getItems().add(empresa.getEmpr_muni_uf());
		//}
	//}
	
	public void populaTela(Empresa empresa) {
		tfRazao.setText(empresa.getEmpr_razaoSocial());
		tfFantasia.setText(empresa.getEmpr_nomeFantasia());
		tfCNPJ.setText(empresa.getEmpr_cnpj());
		tfRua.setText(empresa.getEmpr_endereco());
		tfNum.setText(empresa.getEmpr_numero());
		tfBairro.setText(empresa.getEmpr_bairro());
		tfCidade.setText(empresa.getEmpr_muni_codigo());
		tfCEP.setText(empresa.getEmpr_cep());
		cbxUF.getSelectionModel().select(empresa.getEmpr_muni_uf());
		System.out.println("Popula");
	}
}
