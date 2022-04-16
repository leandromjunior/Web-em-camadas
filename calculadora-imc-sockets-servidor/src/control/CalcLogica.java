package control;

public class CalcLogica {
	
	public String separa_val(String param) throws Exception{
		String[] parts = param.split(" ");
		Float peso = Float.parseFloat(parts[0]);
		Float altura = Float.parseFloat(parts[1]);
		Float valor = peso / (altura * altura);
		
		return this.resultado(valor);
	}

	public String resultado(float v) {
		String frase = null;
		
		if(v < 18.5) {
			frase = "Você está ABAIXO DO PESO";
		}
		else if(v >= 18.5 && v <= 24.9) {
			frase = "PESO NORMAL";
		}
		else if(v >=25 && v <= 29.9){
			frase = "Você está com SOBREPESO";
		}
		else if(v >=30 && v <=34.9) {
			frase = "OBESIDADE CLASSE I";
		}
		else if(v >=35 && v <= 39.9) {
			frase = "OBESIDADE CLASSE II";
		}
		else {
			frase = "OBESIDADE CLASSE III";
		}
		
		return frase;
		
	}
}
