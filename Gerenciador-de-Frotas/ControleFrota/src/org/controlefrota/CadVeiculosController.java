package org.controlefrota;

import java.util.Date;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.VeiculosDAO;
import org.controlefrota.model.t_Veiculos;

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

public class CadVeiculosController {

	@FXML
	private TableColumn<t_Veiculos, String> tbcMarca;

	@FXML
	private TableColumn<t_Veiculos, String> tbcCategoria;

	@FXML
	private TableColumn<t_Veiculos, String> tbcModelo;

	@FXML
	private TableColumn<t_Veiculos, String> tbcChassi;

	@FXML
	private TableColumn<t_Veiculos, String> tbcRenavam;

	@FXML
	private TableColumn<t_Veiculos, String> tbcMotor;

	@FXML
	private TableColumn<t_Veiculos, String> tbcCodigo;

	@FXML
	private TableColumn<t_Veiculos, Date> tbcData;

	@FXML
	private TableColumn<t_Veiculos, String> tbcPlaca;

	@FXML
	private TextField tfMarca;

	@FXML
	private TextField tfPlaca;

	@FXML
	private TextField tfChassi;

	@FXML
	private TextField tfRenavam;

	@FXML
	private ComboBox<String> cbxCategoria;

	@FXML
	private TextField tfModelo;

	@FXML
	private TextField tfMotor;

	@FXML
	private Button btnIncluir;

	@FXML
	private Button btnFechar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Button btnRelatorio;

	@FXML
	private Button btnLimpar;

	@FXML
	private TableView<t_Veiculos> tblVeiculos;

	//private Calendar datacad = Calendar.getInstance();
	
	//SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy");
	
	String categoria;
	
	private VeiculosDAO VeiculosDao = AbstractFactory.get().veiculosDao();

	private t_Veiculos veiculo;
	
	public void initialize() {
        btnExcluir.isDisable();
		cbxCategoria.getItems().addAll("Passeio", "Convencional", "Executivo", "Leito", "Semi-Leito", "Urbano"); 
		tbcMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		tbcModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		tbcPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
		tbcMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
		tbcChassi.setCellValueFactory(new PropertyValueFactory<>("chassi"));
		tbcRenavam.setCellValueFactory(new PropertyValueFactory<>("renavam"));
		tbcCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		tbcData.setCellValueFactory(new PropertyValueFactory<>("datacad"));
		novoVeiculo();
	}
		
	@FXML
	void incluir(ActionEvent event) {
		populaVeiculo();
		VeiculosDao.inserir(veiculo);
		novoVeiculo();
		tblVeiculos.refresh();
	}

	@FXML
	void alterar(ActionEvent event) {
		populaVeiculo();
		VeiculosDao.alterar(veiculo);
		novoVeiculo();
		tblVeiculos.refresh();
	}

	@FXML
	void selecionaVeiculo(MouseEvent event) {
		if (tblVeiculos.getSelectionModel().getSelectedItem() != null) {
			veiculo = tblVeiculos.getSelectionModel().getSelectedItem();
			populaTela(veiculo);
		}
	}


	@FXML
	void excluir(ActionEvent event) {
		VeiculosDao.excluir(veiculo);
		novoVeiculo();
	}

	@FXML
	void limpar(ActionEvent event) {
		novoVeiculo();
	}

	@FXML
	void relatorio(ActionEvent event) {

	}

	@FXML
	void fechar(ActionEvent event) {
		btnFechar.getScene().getWindow().hide();
	}
	
	public void populaBox() {
		
	}
	
	public void populaVeiculo() {
		veiculo.setmarca(tfMarca.getText());
		veiculo.setmodelo(tfModelo.getText());
		veiculo.setchassi(tfChassi.getText());
		veiculo.setmotor(tfMotor.getText());
		veiculo.setplaca(tfPlaca.getText());
		veiculo.setcategoria(cbxCategoria.getSelectionModel().getSelectedItem());
		veiculo.setrenavam(Integer.valueOf(tfRenavam.getText()));
//		veiculo.setdatacad(LocalDate.now());
		
		}

	
	public void populaTela(t_Veiculos veiculo) {
		tfModelo.setText(veiculo.getmodelo());
		tfMarca.setText(veiculo.getmarca());
		tfChassi.setText(veiculo.getchassi());
		tfMotor.setText(veiculo.getmotor());
		tfPlaca.setText(veiculo.getplaca());
		tfRenavam.setText(veiculo.getrenavam().toString());
		cbxCategoria.getSelectionModel().select(veiculo.getcategoria());;
	}

	void novoVeiculo() {
		tfMarca.clear();
		tfChassi.clear();
		tfModelo.clear();
		tfMotor.clear();
		tfPlaca.clear();
		tfRenavam.clear();
		veiculo = new t_Veiculos();
		cbxCategoria.getSelectionModel().clearSelection();
		tblVeiculos.setItems(FXCollections.observableArrayList(VeiculosDao.listar()));
	}
}