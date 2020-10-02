package view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;



public class ShowAlert {

		public void mensagemAlert() {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Logout");
			alert.setHeaderText(null);
			alert.setContentText("O sistema ser� encerrado!");
			alert.showAndWait();
		}
		
		public void validacaoAlert() {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Aten��o");
			alert.setHeaderText(null);
			alert.setContentText("Preencha todos os campos!");
			alert.showAndWait();
		}
		
		public boolean confirmationAlert() {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Excluir");
			alert.setHeaderText("Confirma��o de Exclus�o");
			alert.setContentText("Voc� tem certeza que deseja excluir:");
			
			Optional<ButtonType> result = alert.showAndWait();
			ButtonType button = result.orElse(ButtonType.CANCEL);

			if (button == ButtonType.OK) {
			    return true;
			} 
			
			return false;
		}
		
		
		public void erroAlert() {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText(null);
			alert.setContentText("Pet n�o encontrado");
			alert.showAndWait();
		}
		
		public void sucessoAlert(String message) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso");
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
		}

	}

	
	
	
