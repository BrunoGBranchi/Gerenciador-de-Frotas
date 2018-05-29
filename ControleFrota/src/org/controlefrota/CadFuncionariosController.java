package org.controlefrota;


import java.time.LocalDate;

import org.controlefrota.dao.FuncionarioArquivo;
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
	
	private FuncionarioDAO funcionariosDao = new FuncionarioArquivo();

	//private PrincipalController edit = new PrincipalController(); 
	
//	ListarFuncionariosController ListaFunc = new ListarFuncionariosController();
	
//	private boolean editando;
	
	//private ListarFuncionariosController listfnc = new ListarFuncionariosController();
    
	public void initialize() { 
		cbxUF.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
				"PB", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO");
		if (ListarFuncionariosController.edit) {
           btnCadastrar.setText("Gravar"); 
		};
		funcionario = new Funcionarios();
        if (ListarFuncionariosController.edit) {
			tfAgencia.setText(ListarFuncionariosController.v_Func_agencia);
			tfBairro.setText(ListarFuncionariosController.v_Func_bairro);
			tfBanco.setText(ListarFuncionariosController.v_Func_banco);
			tfCargHoraria.setText(ListarFuncionariosController.v_Func_cargahoraria);
			tfCargo.setText(ListarFuncionariosController.v_Func_cargo);
			tfCEP.setText(ListarFuncionariosController.v_Func_cep);
			tfCBancaria.setText(ListarFuncionariosController.v_Func_conta);
			tfCPF.setText(ListarFuncionariosController.v_Func_cpf);
			tfCTPS.setText(ListarFuncionariosController.v_Func_ctps);
			dtpAdmissao.setValue((ListarFuncionariosController.v_Func_dtadmissao));
			tfDtNasc.setText(ListarFuncionariosController.v_Func_dtnasc);
			tfEndereco.setText(ListarFuncionariosController.v_Func_endereco);
			tfNumero.setText(ListarFuncionariosController.v_Func_endnumero.toString());
			tfCidade.setText(ListarFuncionariosController.v_Func_muni_codigo);
			cbxUF.getSelectionModel().select(ListarFuncionariosController.v_Func_muni_uf);
			tfNomeFunc.setText(ListarFuncionariosController.v_Func_nome);
			tfRG.setText(ListarFuncionariosController.v_Func_rg);
			tfSalario.setText(ListarFuncionariosController.v_Func_salario.toString());
			
			
			};
	} 

	public void populaFuncionario() {
		//novocodigo=funcionario.getnextFunc_codigo();
		//funcionario.setFunc_codigo(Integer.valueOf(novocodigo));
		funcionario.setFunc_codigo(123);
		funcionario.setFunc_agencia(tfAgencia.getText());
		funcionario.setFunc_bairro(tfBairro.getText());
		funcionario.setFunc_banco(tfBanco.getText());
		funcionario.setFunc_cargahoraria(tfCargHoraria.getText());
		funcionario.setFunc_cargo(tfCargo.getText());
		funcionario.setFunc_cep(tfCEP.getText());
		funcionario.setFunc_conta(tfCBancaria.getText());
		funcionario.setFunc_cpf(tfCPF.getText());
		funcionario.setFunc_ctps(tfCTPS.getText());
		funcionario.setFunc_datacad(LocalDate.now());
		funcionario.setFunc_dtadmissao(funcionario.getFunc_datacad());
		funcionario.setFunc_dtnasc(tfDtNasc.getText());
		funcionario.setFunc_endereco(tfEndereco.getText());
		funcionario.setFunc_endnumero(tfNumero.getText());
		funcionario.setFunc_muni_codigo(tfCidade.getText());
		funcionario.setFunc_muni_uf(cbxUF.getSelectionModel().getSelectedItem());
		funcionario.setFunc_nome(tfNomeFunc.getText());
		funcionario.setFunc_rg(tfRG.getText());
		funcionario.setFunc_salario(Double.valueOf(tfSalario.getText()));
		
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
		tfCPF.setText(funcionarios.getFunc_cpf());
		tfNomeFunc.setText(funcionarios.getFunc_nome());
		tfCargo.setText(funcionarios.getFunc_cargo());
		cbxUF.getSelectionModel().select(funcionarios.getFunc_muni_uf());
	}

}
