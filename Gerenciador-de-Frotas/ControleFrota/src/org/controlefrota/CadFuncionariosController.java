package org.controlefrota;


import java.time.LocalDate;

import org.controlefrota.dao.AbstractFactory;
import org.controlefrota.dao.FuncionarioDAO;
import org.controlefrota.model.Funcionarios;
import org.controlefrota.ListarFuncionariosController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


public class CadFuncionariosController {

	@FXML
	private TextField tfEndereco;

	@FXML
	private TextField tfCBancaria;

	@FXML
	private TextField tfNomeFunc;

	@FXML
	private TextField tfSalario;

	@FXML
	private Button btnCadastrar;

	@FXML
	private TextField tfCTPS;

	@FXML
	private TextField tfCargHoraria;

	@FXML
	private DatePicker dtpAdmissao;

	@FXML
	private ComboBox<String> cbxUF;

	@FXML
	private TextField tfCEP;

	@FXML
	private TextField tfNumero;

	@FXML
	private TextField tfAgencia;

	@FXML
	private TextField tfDtNasc;

	@FXML
	private TextField tfRG;

	@FXML
	private TextField tfCPF;

	@FXML
	private TextField tfCargo;

	@FXML
	private TextField tfCidade;

	@FXML
	private TextField tfBanco;

	@FXML
	private Button btnCancelar;

	@FXML
	private TextField tfBairro;

	@FXML
	private Button btnListar;

	private Funcionarios funcionario;
	
	private FuncionarioDAO funcionariosDao = AbstractFactory.get().funcionariosDao();

	//private PrincipalController edit = new PrincipalController(); 
	
	//ListarFuncionariosController listaFunc = new ListarFuncionariosController();
	
	//private boolean editando;
	
	//private ListarFuncionariosController listfnc = new ListarFuncionariosController();
    
	@FXML
	public void initialize() { 
		cbxUF.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
				"PB", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO");
		if (ListarFuncionariosController.edit) {
           btnCadastrar.setText("Gravar"); 
		};
		funcionario = new Funcionarios();
        if (ListarFuncionariosController.edit) {
			tfAgencia.setText(ListarFuncionariosController.agencia);
			tfBairro.setText(ListarFuncionariosController.bairro);
			tfBanco.setText(ListarFuncionariosController.banco);
			tfCargHoraria.setText(ListarFuncionariosController.cargahoraria);
			tfCargo.setText(ListarFuncionariosController.cargo);
			tfCEP.setText(ListarFuncionariosController.cep);
			tfCBancaria.setText(ListarFuncionariosController.conta);
			tfCPF.setText(ListarFuncionariosController.cpf);
			tfCTPS.setText(ListarFuncionariosController.ctps);
			dtpAdmissao.setValue((ListarFuncionariosController.dtadmissao));
			tfDtNasc.setText(ListarFuncionariosController.dtnasc);
			tfEndereco.setText(ListarFuncionariosController.endereco);
			tfNumero.setText(ListarFuncionariosController.endnumero);
			tfCidade.setText(ListarFuncionariosController.municipio);
			cbxUF.getSelectionModel().select(ListarFuncionariosController.uf);
			tfNomeFunc.setText(ListarFuncionariosController.nome);
			tfRG.setText(ListarFuncionariosController.rg);
			tfSalario.setText(ListarFuncionariosController.salario.toString());
			
			
			};
	} 
	@FXML
	public void populaFuncionario() {
		funcionario.setagencia(tfAgencia.getText());
		funcionario.setbairro(tfBairro.getText());
		funcionario.setbanco(tfBanco.getText());
		funcionario.setcargahoraria(tfCargHoraria.getText());
		funcionario.setcargo(tfCargo.getText());
		funcionario.setcep(tfCEP.getText());
		funcionario.setconta(tfCBancaria.getText());
		funcionario.setcpf(tfCPF.getText());
		funcionario.setctps(tfCTPS.getText());
		funcionario.setdatacad(LocalDate.now());
		funcionario.setdtadmissao(funcionario.getdatacad());
		funcionario.setdtnasc(tfDtNasc.getText());
		funcionario.setendereco(tfEndereco.getText());
		funcionario.setendnumero(tfNumero.getText());
		funcionario.setmunicipio(tfCidade.getText());
		funcionario.setuf(cbxUF.getSelectionModel().getSelectedItem());
		funcionario.setnome(tfNomeFunc.getText());
		funcionario.setrg(tfRG.getText());
		funcionario.setsalario(Double.valueOf(tfSalario.getText()));
		
		}

    @FXML
	void cadastrar(ActionEvent event) {
        populaFuncionario();
    	//if (PrincipalController.edit) {
        if (ListarFuncionariosController.edit) {
			funcionariosDao.alterar(funcionario);
		} else {
            funcionariosDao.inserir(funcionario);
		}
    	
    }

	@FXML
	void cancelar(ActionEvent event) {
		btnCancelar.getScene().getWindow().hide();
	}

	@FXML
	void listarFuncionarios(ActionEvent event) {
	}

	public void populaTela(Funcionarios funcionarios) {
		tfCPF.setText(funcionarios.getcpf());
		tfNomeFunc.setText(funcionarios.getnome());
		tfCargo.setText(funcionarios.getcargo());
		cbxUF.getSelectionModel().select(funcionarios.getuf());
	}

}
