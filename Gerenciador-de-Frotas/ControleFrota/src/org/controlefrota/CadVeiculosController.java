package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.VeiculosDAO;
import org.controlefrota.model.Veiculos;

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
import javafx.stage.Stage;

public class CadVeiculosController {
	
	@FXML
	private TableView<Veiculos> tblVeiculos;
	
	@FXML
	private TableColumn<Veiculos, String> tbcMarca;

	@FXML
	private TableColumn<Veiculos, String> tbcCategoria;

	@FXML
	private TableColumn<Veiculos, String> tbcModelo;

	@FXML
	private TableColumn<Veiculos, String> tbcChassi;

	@FXML
	private TableColumn<Veiculos, Integer> tbcRenavam;

	@FXML
	private TableColumn<Veiculos, String> tbcMotor;

	@FXML
	private TableColumn<Veiculos, Integer> tbcCodigo;

	@FXML
	private TableColumn<Veiculos, Date> tbcData;

	@FXML
	private TableColumn<Veiculos, String> tbcPlaca;

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
	private Button btnLimpar;

	//private Calendar datacad = Calendar.getInstance();
	
	//SimpleDateFormat formatar = new SimpleDateFormat("dd-MM-yyyy");
	
	String categoria;
	
	private VeiculosDAO VeiculosDao = AbstractFactory.get().veiculosDao();

	private Veiculos veiculo;
	
	@FXML
	public void initialize() {
        btnExcluir.isDisable();
		cbxCategoria.getItems().addAll("Passeio", "Convencional", "Executivo", "Leito", "Semi-Leito", "Urbano"); 
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
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
	void fechar(ActionEvent event) {
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
            stage = (Stage) btnFechar.getScene().getWindow();
            stage.close(); //fecha a pagina atual antes de sair
        }
	}
	
	public void populaBox() {
		
	}
	
	@FXML
	public void populaVeiculo() {
		veiculo.setMarca(tfMarca.getText());
		veiculo.setModelo(tfModelo.getText());
		veiculo.setChassi(tfChassi.getText());
		veiculo.setMotor(tfMotor.getText());
		veiculo.setPlaca(tfPlaca.getText());
		veiculo.setCategoria(cbxCategoria.getSelectionModel().getSelectedItem());
		veiculo.setRenavam(Integer.valueOf(tfRenavam.getText()));
		veiculo.setDatacad(java.sql.Date.valueOf(LocalDate.now()));
		
		}

	
	public void populaTela(Veiculos veiculo) {
		tfModelo.setText(veiculo.getModelo());
		tfMarca.setText(veiculo.getMarca());
		tfChassi.setText(veiculo.getChassi());
		tfMotor.setText(veiculo.getMotor());
		tfPlaca.setText(veiculo.getPlaca());
		tfRenavam.setText(veiculo.getRenavam().toString());
		cbxCategoria.getSelectionModel().select(veiculo.getCategoria());;
	}

	void novoVeiculo() {
		tfMarca.clear();
		tfChassi.clear();
		tfModelo.clear();
		tfMotor.clear();
		tfPlaca.clear();
		tfRenavam.clear();
		veiculo = new Veiculos();
		cbxCategoria.getSelectionModel().clearSelection();
		tblVeiculos.setItems(FXCollections.observableArrayList(VeiculosDao.listar()));
	}
}