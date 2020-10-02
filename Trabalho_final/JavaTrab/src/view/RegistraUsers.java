package view;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.Pane;

import model.User;

public class RegistraUsers  implements Initializable{

@FXML
private TableView<User> TableView;

@FXML
private TableColumn<User, Integer> Idcollum;

@FXML
private TableColumn<User, String> UserCollum;

@FXML
private TableColumn<User, String> CpfCollum;

@FXML
private TableColumn<User, String> EmailCollum;

@FXML
private Pane Painel;

@FXML
private Button btnIncluir;

@FXML
private Button btnAlterar;

@FXML
private Button btnExcluir;

@FXML
private Button exitid;

@FXML
private TextField TxtName;

@FXML
private TextField TxtCpf;

@FXML
private TextField Txtemail;

@FXML
private TextField Txtid;

@FXML
private Button PesquisarId;

@FXML
private Label LabelId;

@FXML
private TextField PesquisaNome;

@FXML
void Exit(ActionEvent event) {
	new ShowAlert().mensagemAlert();
    System.exit(0); 
}

@FXML
void alterarCliente(ActionEvent event) {
alterarCliente();
}

@FXML
void excluirCliente(ActionEvent event) {
excluirCliente();
}

@FXML
void findById(ActionEvent event) {
	if(!pesquisaPorId()) {
		new ShowAlert().erroAlert();
	}  
}

@FXML
void incluirCliente(ActionEvent event) {
incluirCliente();
}
 
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	Painel.setVisible(true);
	listar();
	

} 
    private List<User> listaClientes = new ArrayList<User>();		
        
    
    public boolean pesquisaPorId() {
    ObservableList<User> lista = FXCollections.observableArrayList(listaClientes);
        for(User cliente: lista) {
        	if(cliente.getId().equals(Integer.parseInt(Txtid.getText()))) {
        		TxtName.setText(cliente.getNome());
        		TxtCpf.setText(cliente.getCpf());
        		Txtemail.setText(cliente.getEmail());
        		
        		TxtName.setDisable(false);
    			TxtCpf.setDisable(false);
    			Txtemail.setDisable(false);    			
        		return true;
        	}
        }  
         return false;
   }

    @FXML
    void findByName(ActionEvent event) {
    	ObservableList<User> lista = FXCollections.observableArrayList(listaClientes);
    	List<User> novaLista = new ArrayList<User>();
	        if(!PesquisaNome.getText().isEmpty() || !PesquisaNome.getText().equals("")) {
		        for(User cliente: lista) {
		        	if(cliente.getNome().contains(PesquisaNome.getText())) {
		        		System.out.println(cliente);
		        		novaLista.add(cliente);
		        	}
		        }
		 	   ObservableList<User> novaListaObs = FXCollections.observableArrayList(novaLista);
		 	  TableView.setItems(novaListaObs);
	        } else {
	        	listar();
	        }
	        PesquisaNome.clear();
    }
    
	
	public void incluirCliente() {
		if(validacaoCampos()) {
			if(listaClientes.size() != 0) {
				User cliente = listaClientes.get(listaClientes.size() -1);
				listaClientes.add(new User(cliente.getId() + 1, TxtCpf.getText(), Txtemail.getText(), TxtName.getText()));
			} else {
				listaClientes.add(new User(1, TxtCpf.getText(), Txtemail.getText(), TxtName.getText()));
			}
			new ShowAlert().sucessoAlert("Pet adicionado com sucesso!");
			limparCampos();
			listar();
		} else {
			
		}
	}
	
	public void alterarCliente() {
		if(validacaoCampos()) {
	        ObservableList<User> lista = FXCollections.observableArrayList(listaClientes);
	        for(User cliente: lista) {
	        	if(cliente.getId().equals(Integer.parseInt(Txtid.getText()))) {
	        		listaClientes.remove(cliente);
	        		listaClientes.add(new User(Integer.parseInt(Txtid.getText()), TxtCpf.getText(), Txtemail.getText(), TxtName.getText()));
	        	}
	        }
			new ShowAlert().sucessoAlert("Pet editado com sucesso!");
	    	limparCampos();	    	
	        listar();	        
		} else {
			
		}
	}
	
	public void excluirCliente() {
        ObservableList<User> lista = FXCollections.observableArrayList(listaClientes);
        if (new ShowAlert().confirmationAlert()) {
			for(User cliente: lista) {
				if(cliente.getId().equals(Integer.parseInt(Txtid.getText()))) {
					listaClientes.remove(cliente);
		        }
		    }		
		}      
    	limparCampos();    	
        listar();        
	}
		
	public void listar() {
		UserCollum.setCellValueFactory(new PropertyValueFactory<User, String>("Nome"));
		CpfCollum.setCellValueFactory(new PropertyValueFactory<User, String>("Cpf"));
		EmailCollum.setCellValueFactory(new PropertyValueFactory<User, String>("Email"));
		Idcollum.setCellValueFactory(new PropertyValueFactory<User, Integer>("Id"));		
		TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);	    
	    ObservableList<User> lista = FXCollections.observableArrayList(listaClientes);
	    TableView.setItems(lista);
	}
	
	public void limparCampos() {
		Txtid.setText("");
		TxtName.setText("");
		TxtCpf.setText("");
		Txtemail.setText("");
		TxtName.requestFocus();
	}
	
	public void camposVisiveis(String titulo,String botao, int tamanho, boolean visivel) {
		Txtid.setPrefWidth(tamanho);
		PesquisarId.setVisible(visivel);
		Painel.setVisible(true);
		TxtName.setDisable(visivel);
		TxtCpf.setDisable(visivel);
		Txtemail.setDisable(visivel);
	}
	
	public boolean validacaoCampos() {	
		if(Txtemail.getText().isEmpty() | TxtName.getText().isEmpty() | TxtCpf.getText().isEmpty()) {
			return false;
		}	
		return true;
	}
}
