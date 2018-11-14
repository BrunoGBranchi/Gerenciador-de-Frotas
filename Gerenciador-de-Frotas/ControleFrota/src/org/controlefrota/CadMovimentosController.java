package org.controlefrota;

import java.io.IOException;
import java.util.Date;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.MovimentosDAO;
import org.controlefrota.model.Movimentos;
import org.controlefrota.model.Veiculos;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

//OK Edit

public class CadMovimentosController {

    @FXML
    private TextField tfObservacao;

    @FXML
    private TableColumn<Movimentos, Date> tbcDtMovimento;

    @FXML
    private TextField tfKmVeiculo;

    @FXML
    private TableColumn<Movimentos, Integer> tbcQuantidade;

    @FXML
    private TableColumn<Movimentos, Integer> tbcCodManutencao;

    @FXML
    private Button btnFechar;

    @FXML
    private TextField tfCodVeiculo;

    @FXML
    private TableColumn<Movimentos, String> tbcValor;
    
    @FXML
    private TableColumn<Movimentos, String> tbcObservacao;

    @FXML
    private TableView<Movimentos> tblMovimentos;

    @FXML
    private TextField tfNumNota;

    @FXML
    private DatePicker dtEmissaoNota;

    @FXML
    private TableColumn<Movimentos, Integer> tbcCodigo;

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
    private TableColumn<Movimentos, Integer> tbcKmVeiculo;

    @FXML
    private Button btnLimpar;

    @FXML
    private TableColumn<Movimentos, Integer> tbcNumNota;

    @FXML
    private TableColumn<Movimentos, Integer> tbcCodVeiculo;

    @FXML
    private TextField tfQuantidade;
    
    private MovimentosDAO movimentosDao = AbstractFactory.get().movimentosDao();
    
    private Movimentos movimento;
    
    public void initialize() {
        btnExcluir.isDisable();
		//cbxCategoria.getItems().addAll("Passeio", "Convencional", "Executivo", "Leito", "Semi-Leito", "Urbano"); 
		tbcNumNota.setCellValueFactory(new PropertyValueFactory<>("numeronota"));
		tbcDtEmissao.setCellValueFactory(new PropertyValueFactory<>("dataemissnota"));
		tbcDtMovimento.setCellValueFactory(new PropertyValueFactory<>("datamvto"));
		tbcCodVeiculo.setCellValueFactory(new PropertyValueFactory<>("veic_codigo"));
		tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tbcKmVeiculo.setCellValueFactory(new PropertyValueFactory<>("veickm"));
		tbcQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tbcValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tbcCodManutencao.setCellValueFactory(new PropertyValueFactory<>("codmanutencao"));
		novoMovimento();
	}
    
    @FXML
    void incluir(ActionEvent event) {
    	populaMovimento();
		movimentosDao.inserir(movimento);
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
    void selecionaMovimento(ActionEvent event) {

    }
    
    void novoMovimento() {
		tfCodManutencao.clear();
		tfCodVeiculo.clear();
		tfKmVeiculo.clear();
		tfNumNota.clear();
		tfObservacao.clear();
		tfQuantidade.clear();
		tfValor.clear();
		movimento = new Movimentos();
		tblMovimentos.setItems(FXCollections.observableArrayList(movimentosDao.listar()));
	}
    
    void populaMovimento() {
    	movimento.setcodmanutencao(Integer.valueOf(tfCodManutencao.getText()));
    	movimento.setdataemissnota(dtEmissaoNota.getValue());
    	movimento.setdatamvto(dtMovimento.getValue());
    	movimento.setnumeronota(Integer.valueOf(tfNumNota.getText()));
    	movimento.setobservacao(tfObservacao.getText());
    	movimento.setquantidade(Double.valueOf(tfQuantidade.getText()));
    	movimento.setvalor(tfValor.getText());
    }
    void populaTela(Movimentos movimento) {
    	tfCodManutencao.setText(movimento.getcodmanutencao().toString());
    	tfCodVeiculo.setText(movimento.getveic_codigo().toString());
    	tfKmVeiculo.setText(movimento.getveickm().toString());
    	tfNumNota.setText(movimento.getnumeronota().toString());
    	tfObservacao.setText(movimento.getobservacao());
    	tfQuantidade.setText(movimento.getquantidade().toString());
    	tfValor.setText(movimento.getvalor());    	
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
}