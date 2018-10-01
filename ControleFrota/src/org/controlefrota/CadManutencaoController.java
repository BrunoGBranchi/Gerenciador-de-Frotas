package org.controlefrota;

import java.time.LocalDate;
import java.util.Date;

import org.controlefrota.dao.ManutencaoArquivo;
import org.controlefrota.dao.ManutencaoDAO;
import org.controlefrota.model.Manutencao;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<Manutencao, Date> tbcDataCad;
    
    @FXML
    private TableColumn<Manutencao, String> tbcCodigo;
    
    @FXML
    private TableColumn<Manutencao, String> tbcMarcaPeca;

    @FXML
    private TableColumn<Manutencao, String> tbcAplicacao;
    
    @FXML
    private TableColumn<Manutencao, String> tbcTipoPeca;
    
    @FXML
    private TableColumn<Manutencao, String> tbcDescricao;
    
    @FXML
    private TableView<Manutencao> tblManutencao;

    
    ManutencaoDAO manutencaoDao = new ManutencaoArquivo();
    
    private boolean editando;
    
    private Manutencao manutencao;
    
    private Integer novocodigo;
    
    @FXML
    public void initialize() {	
    	tbcCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    	tbcTipoPeca.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	tbcMarcaPeca.setCellValueFactory(new PropertyValueFactory<>("marca"));
    	tbcAplicacao.setCellValueFactory(new PropertyValueFactory<>("aplicacao"));
    	tbcDataCad.setCellValueFactory(new PropertyValueFactory<>("datacad"));
    	novaManutencao();
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
    	btnFechar.getScene().getWindow().hide();
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
    	novocodigo = manutencao.getnextcodigo();
    	manutencao.setcodigo(Integer.valueOf(novocodigo));
    	manutencao.setdescricao(tfDesc.getText());
    	manutencao.settipo(tfTipo.getText());
    	manutencao.setmarca(tfMarca.getText());
    	manutencao.setaplicacao(tfAplica.getText());
    	manutencao.setdatacad(LocalDate.now());
    }
    
    public void populaTela(Manutencao manutencao) {
    	tfDesc.setText(manutencao.getdescricao());
    	tfTipo.setText(manutencao.gettipo());
    	tfMarca.setText(manutencao.getmarca());
    	tfAplica.setText(manutencao.getaplicacao());
    }
    
    public void novaManutencao() {
    	tfAplica.clear();
    	tfDesc.clear();
    	tfMarca.clear();
    	tfTipo.clear();
    	manutencao = new Manutencao();
    	editando = false;
    	tblManutencao.setItems(FXCollections.observableArrayList(manutencaoDao.listar()));
    }
}
