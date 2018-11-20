package org.controlefrota;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.ManutencaoDAO;
import org.controlefrota.dao.VeiculosDAO;
import org.controlefrota.model.Manutencao;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//OK - Edit

public class CadManutencaoController {

    @FXML
    private TextField tfTipo;

    @FXML
    private TextField tfMarca;

    @FXML
    private Button btnIncluir;

    @FXML
    private TextField tfAplica;

    @FXML
    private Button btnFechar;

    @FXML
    private TextField tfDesc;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnLimpar;
    
    @FXML
    private ComboBox<Veiculos> CbxVeiculo;

    @FXML
    private TextField tfValor;
    
    @FXML
    private TableColumn<Manutencao, Date> tbcDataCad;
    
    @FXML
    private TableColumn<Manutencao, Number> tbcCodigo;
    
    @FXML
    private TableColumn<Manutencao, String> tbcVeiculo;
    
    @FXML
    private TableColumn<Manutencao, String> tbcMarcaPeca;

    @FXML
    private TableColumn<Manutencao, String> tbcAplicacao;
    
    @FXML
    private TableColumn<Manutencao, String> tbcTipoPeca;
    
    @FXML
    private TableColumn<Manutencao, Number> tbcValor;
    
    @FXML
    private TableColumn<Manutencao, String> tbcDescricao;
    
    @FXML
    private TableView<Manutencao> tblManutencao;
    
    @FXML
    private DatePicker dtdata;
    
    private ManutencaoDAO manutencaoDao = AbstractFactory.get().manutencaoDao();
    
    private VeiculosDAO veiculosDao = AbstractFactory.get().veiculosDao();
    
    private boolean editando;
    
    private Manutencao manutencao;
    
    @FXML
    public void initialize() {	
    	tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    	tbcVeiculo.setCellValueFactory(new PropertyValueFactory<>("veiculo"));
    	tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    	tbcTipoPeca.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	tbcMarcaPeca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    	tbcAplicacao.setCellValueFactory(new PropertyValueFactory<>("aplicacao"));
    	tbcDataCad.setCellValueFactory(new PropertyValueFactory<>("datacad"));
    	
    	populaCombo();
    	novaManutencao();
    }
    
    private void populaCombo(){
		CbxVeiculo.getItems().clear();
		for(Veiculos veiculo: veiculosDao.listar()){
			CbxVeiculo.getItems().add(veiculo);
		}
	}
    
    @FXML
    void incluir(ActionEvent event) {
    	populaManutencao();
    	if (editando) {
    		manutencaoDao.alterar(manutencao);
    	} else {
    		manutencaoDao.inserir(manutencao);
    	}
    	novaManutencao();
    	tblManutencao.refresh();
    }

    @FXML
    void excluir(ActionEvent event) {
    	manutencaoDao.excluir(manutencao);
    	novaManutencao();
    }

    @FXML
    void limpar(ActionEvent event) {
    	novaManutencao();
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
    
    @FXML
    void selecionarManutencao(MouseEvent event) {
    	if(tblManutencao.getSelectionModel().getSelectedItem() !=null) {
    		manutencao = tblManutencao.getSelectionModel().getSelectedItem();
    		populaTela(manutencao);
    		editando = true;
    	}
    }
    
    public void populaManutencao() {
    	manutencao.setDescricao(tfDesc.getText());
    	manutencao.setTipo(tfTipo.getText());
    	manutencao.setMarca(tfMarca.getText());
    	manutencao.setAplicacao(tfAplica.getText());
    	manutencao.setValor(Double.valueOf(tfValor.getText()));
    	manutencao.setVeiculo(CbxVeiculo.getSelectionModel().getSelectedItem());
    	manutencao.setDatacad(java.sql.Date.valueOf(LocalDate.now()));
    	
    }
    
    public void populaTela(Manutencao manutencao) {
    	tfDesc.setText(manutencao.getDescricao());
    	tfTipo.setText(manutencao.getTipo());
    	tfMarca.setText(manutencao.getMarca());
    	tfAplica.setText(manutencao.getAplicacao());
    	tfValor.setText(String.valueOf(manutencao.getValor()));
    	CbxVeiculo.getSelectionModel().select(manutencao.getVeiculo());
    }
    
    public void novaManutencao() {
    	tfAplica.clear();
    	tfDesc.clear();
    	tfMarca.clear();
    	tfTipo.clear();
    	tfValor.clear();
    	CbxVeiculo.getSelectionModel().clearSelection();
    	manutencao = new Manutencao();
    	editando = false;
    	tblManutencao.setItems(FXCollections.observableArrayList(manutencaoDao.listar()));
    }
}
