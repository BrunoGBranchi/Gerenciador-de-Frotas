package org.controlefrota;

import java.util.Date;

import org.controlefrota.model.Movimentos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    @FXML
    void incluir(ActionEvent event) {
    	
    }

    @FXML
    void excluir(ActionEvent event) {
    	
    }

    @FXML
    void limpar(ActionEvent event) {
    	
    }
    
    @FXML
    void selecionaMovimento(ActionEvent event) {

    }

    
    @FXML
    void fechar(ActionEvent event) {
    	btnFechar.getScene().getWindow().hide();
    }
}