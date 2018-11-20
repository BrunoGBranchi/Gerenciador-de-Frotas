package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.ManutencaoDAO;
import org.controlefrota.dao.MovimentosDAO;
import org.controlefrota.dao.VeiculosDAO;
import org.controlefrota.model.Manutencao;
import org.controlefrota.model.Movimentos;
import org.controlefrota.model.Veiculos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.controlefrota.conexao.ConexaoUtil;

//OK Edit

public class CadMovimentosController {

	@FXML
	private TextField tfObservacao;

	@FXML
	private TableColumn<Movimentos, Date> tbcDtMovimento;

	@FXML
	private TextField tfKmVeiculo;

	@FXML
	private TableColumn<Manutencao, Number> tbcCodManutencao;

	@FXML
	private Button btnFechar;

	@FXML
	private TextField tfCodVeiculo;

	@FXML
	private TableColumn<Movimentos, Number> tbcValor;

	@FXML
	private TableColumn<Movimentos, String> tbcObservacao;

	@FXML
	private TableView<Movimentos> tblMovimentos;

	@FXML
	private TextField tfNumNota;

	@FXML
	private DatePicker dtEmissaoNota;

	@FXML
	private TableColumn<Movimentos, Number> tbcCodigo;

	@FXML
	private TextField tfCodManutencao;

	@FXML
	private Button btnIncluir;

	@FXML
	private TextField tfValor;

	@FXML
	private TableColumn<Movimentos, Date> tbcDtEmissao;

	@FXML
	private DatePicker dtMovimento;

	@FXML
	private Button btnExcluir;

	@FXML
	private TableColumn<Movimentos, Number> tbcKmVeiculo;

	@FXML
	private Button btnLimpar;

	@FXML
	private TableColumn<Movimentos, Number> tbcNumNota;

	@FXML
	private TableColumn<Veiculos, Number> tbcCodVeiculo;
	
	@FXML
    private ComboBox<Manutencao> CbxManutencao;

    @FXML
    private ComboBox<Veiculos> CbxVeiculo;
    
    @FXML
    private Button btnRelatorio;


	private MovimentosDAO movimentosDao = AbstractFactory.get().movimentosDao();

	private VeiculosDAO veiculosDao = AbstractFactory.get().veiculosDao();
	
	private ManutencaoDAO manutencaoDao = AbstractFactory.get().manutencaoDao();
		
	private Movimentos movimento;
	
	private boolean editando;
	
	@FXML
	public void initialize() {
		btnExcluir.isDisable();
		tbcNumNota.setCellValueFactory(new PropertyValueFactory<>("numeronota"));
		tbcDtEmissao.setCellValueFactory(new PropertyValueFactory<>("dataemissnota"));
		tbcDtMovimento.setCellValueFactory(new PropertyValueFactory<>("datamvto"));
		tbcCodVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcKmVeiculo.setCellValueFactory(new PropertyValueFactory<>("veickm"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcObservacao.setCellValueFactory(new PropertyValueFactory<>("observacao"));
		tbcCodManutencao.setCellValueFactory(new PropertyValueFactory<>("manutencao"));
		novoMovimento();
		populaCombo();
	}

	@FXML
	void incluir(ActionEvent event) {
		populaMovimento();
    	if (editando) {
    		movimentosDao.alterar(movimento);
    	} else {
    		movimentosDao.inserir(movimento);
    	}
    	novoMovimento();
    	tblMovimentos.refresh();
	}

	@FXML
	void excluir(ActionEvent event) {
		movimentosDao.excluir(movimento);
		novoMovimento();
	}

	@FXML
	void limpar(ActionEvent event) {
		novoMovimento();
	}
	
	@FXML
    void relatorio(ActionEvent event) {
		try {
			JasperPrint jasperPrint = JasperFillManager
					 .fillReport(
							 "relatorios/MovimentosRelatorio.jasper",
							 null,
							 ConexaoUtil.getConn());
			JasperViewer.viewReport(jasperPrint);
		} catch (JRException e) {
			e.printStackTrace();
		}
    }
	
	@FXML
	void selecionaMovimento(ActionEvent event) {
		if (tblMovimentos.getSelectionModel().getSelectedItem() != null) {
			movimento = tblMovimentos.getSelectionModel().getSelectedItem();
			populaTela(movimento);
			editando = true;
		}
	}

	void novoMovimento() {
		CbxManutencao.getSelectionModel().clearSelection();
		CbxVeiculo.getSelectionModel().clearSelection();
		tfKmVeiculo.clear();
		tfNumNota.clear();
		tfObservacao.clear();
		tfValor.clear();
		movimento = new Movimentos();
		editando = false;
		tblMovimentos.setItems(FXCollections.observableArrayList(movimentosDao.listar()));
	}
	
	void populaCombo() {
		CbxVeiculo.getItems().clear();
		for(Veiculos veiculo: veiculosDao.listar()){
			CbxVeiculo.getItems().add(veiculo);
		}
		
		CbxManutencao.getItems().clear();
		for(Manutencao manutencao: manutencaoDao.listar()){
			CbxManutencao.getItems().add(manutencao);
		}
	}
	
	void populaMovimento() {
		movimento.setVeiculo(CbxVeiculo.getSelectionModel().getSelectedItem());
		movimento.setManutencao(CbxManutencao.getSelectionModel().getSelectedItem());
		movimento.setDataemissnota(java.sql.Date.valueOf(LocalDate.now()));
		movimento.setDatamvto(java.sql.Date.valueOf(LocalDate.now()));
		movimento.setNumeronota(Integer.valueOf(tfNumNota.getText()));
		movimento.setObservacao(tfObservacao.getText());
		movimento.setVeickm(Integer.valueOf(tfKmVeiculo.getText()));
		movimento.setValor(Double.valueOf(tfValor.getText()));
	}

	void populaTela(Movimentos movimento) {
		CbxVeiculo.getSelectionModel().select(movimento.getVeiculo());
		CbxManutencao.getSelectionModel().select(movimento.getManutencao());
		tfKmVeiculo.setText(movimento.getVeickm().toString());
		tfNumNota.setText(movimento.getNumeronota().toString());
		tfObservacao.setText(movimento.getObservacao());
		tfValor.setText(String.valueOf(movimento.getValor()));
	}

	@FXML
	void fechar(ActionEvent event) {
		Stage stage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Gerenciador de Frotas - V1.1 Alpha");
			stage.show();
			stage.setMaximized(true);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			stage = (Stage) btnFechar.getScene().getWindow();
			stage.close(); // fecha a pagina atual antes de sair
		}
	}
}