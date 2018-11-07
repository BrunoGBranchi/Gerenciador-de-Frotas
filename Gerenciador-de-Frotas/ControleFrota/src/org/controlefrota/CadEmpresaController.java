package org.controlefrota;

import java.io.IOException;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.EmpresaDAO;
import org.controlefrota.model.Empresa;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	
	private EmpresaDAO empresaDao = AbstractFactory.get().empresaDao();
	
	@FXML
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
		tbcCidade.setCellValueFactory(new PropertyValueFactory<>("municipio"));
		tbcUF.setCellValueFactory(new PropertyValueFactory<>("uf"));
		
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
            stage = (Stage) btnCancel.getScene().getWindow();
            stage.close(); //fecha a pagina atual antes de sair
        }
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
		empresa.setRazaoSocial(tfRazao.getText());
		empresa.setNomeFantasia(tfFantasia.getText());
		empresa.setCnpj(tfCNPJ.getText());
		empresa.setEndereco(tfRua.getText());
		empresa.setNumero(tfNum.getText());
		empresa.setBairro(tfBairro.getText());
		empresa.setMunicipio(tfCidade.getText());
		empresa.setCep(tfCEP.getText());
		empresa.setUf(cbxUF.getSelectionModel().getSelectedItem().toString());
	}
	
	private void populaCombo(){
		for(Empresa empresa: empresaDao.listar()){
			cbxUF.getItems().add(empresa.getUf());
		}
	}
	
	public void populaTela(Empresa empresa) {
		tfRazao.setText(empresa.getRazaoSocial());
		tfFantasia.setText(empresa.getNomeFantasia());
		tfCNPJ.setText(empresa.getCnpj());
		tfRua.setText(empresa.getEndereco());
		tfNum.setText(empresa.getNumero());
		tfBairro.setText(empresa.getBairro());
		tfCidade.setText(empresa.getMunicipio());
		tfCEP.setText(empresa.getCep());
		cbxUF.getSelectionModel().select(empresa.getUf());
		System.out.println("Popula");
	}
}
