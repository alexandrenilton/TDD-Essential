import java.util.StringTokenizer;

public class CamelCaseConverter {

	public String converter(String nome) {
		
		if ( nome.contains(" ") ) {
			StringTokenizer st = new StringTokenizer(nome, " ");
			StringBuilder sb = new StringBuilder();
			
			int qtd = st.countTokens();
			int count = 1;
			
			while(st.hasMoreElements()) {
				sb.append( converterPalavraSimples (st.nextToken() ) );
				
				if (count < qtd) {
					sb.append(" ");
				}
				count++;
			}
			return sb.toString();
		} else {
			return converterPalavraSimples(nome);
		}
	}
	
	public String converterPalavraSimples(String palavra) {
		return palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();
	}

}
