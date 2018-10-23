package org.controlefrota;

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

	private Empresa empresa;

	private boolean editando;
	
	private Integer novocodigo;
	
	public void initialize() {
		
		cbxUF.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
				"PB", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO");
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		tbcRazao.setCellValueFactory(new PropertyValueFactory<>("razaoSocial"));
		tbcNomeFantasia.setCellValueFactory(new PropertyValueFactory<>("nomeFantasia"));
		tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		tbcBairro.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		tbcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		tbcCEP.setCellValueFactory(new PropertyValueFactory<>("cep"));
		tbcCidade.setCellValueFactory(new PropertyValueFactory<>("muni_codigo"));
		tbcUF.setCellValueFactory(new PropertyValueFactory<>("muni_uf"));
		
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
		novocodigo=Empresa.getNextcodigo();
		empresa.setcodigo(Integer.valueOf(novocodigo));
		empresa.setrazaoSocial(tfRazao.getText());
		empresa.setnomeFantasia(tfFantasia.getText());
		empresa.setcnpj(tfCNPJ.getText());
		empresa.setendereco(tfRua.getText());
		empresa.setnumero(tfNum.getText());
		empresa.setbairro(tfBairro.getText());
		empresa.setmuni_codigo(tfCidade.getText());
		empresa.setmuni_uf(cbxUF.getSelectionModel().getSelectedItem().toString());
		empresa.setcep(tfCEP.getText());
	}
	
	//private void populaCombo(){
		//for(Empresa empresa: empresaDao.listar()){
			//cbxUF.getItems().add(empresa.getmuni_uf());
		//}
	//}
	
	public void populaTela(Empresa empresa) {
		tfRazao.setText(empresa.getrazaoSocial());
		tfFantasia.setText(empresa.getnomeFantasia());
		tfCNPJ.setText(empresa.getcnpj());
		tfRua.setText(empresa.getendereco());
		tfNum.setText(empresa.getnumero());
		tfBairro.setText(empresa.getbairro());
		tfCidade.setText(empresa.getmuni_codigo());
		tfCEP.setText(empresa.getcep());
		cbxUF.getSelectionModel().select(empresa.getmuni_uf());
		System.out.println("Popula");
	}
}
