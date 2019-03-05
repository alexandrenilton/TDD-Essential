import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {
	
	private CamelCaseConverter camelCaseConverter;
	
	@Before
	public void setup() {
		camelCaseConverter = new CamelCaseConverter();
	}
	
	@Test
	public void deveCriarObjetoCamelCaseConverter() throws Exception {
		CamelCaseConverter camelCase = new CamelCaseConverter();
	}
	
	@Test
	public void deveConverterNomeSimples() throws Exception {
		assertEquals("Alexandre", camelCaseConverter.converter("alexandre"));
		assertEquals("Patricia", camelCaseConverter.converter("patricia"));
		assertEquals("Alexandre", camelCaseConverter.converter("AlExAnDrE"));
	}
	
	@Test
	public void deveConverterNomeSimplesMisturadoMaiusculoEmMinunsculo() throws Exception {
		assertEquals("Lionel", camelCaseConverter.converter("liOnEl"));
	}
	
	@Test
	public void deveConverteNomeComposto() throws Exception {
		assertEquals("Alexandre Nilton Six Matos Belem", camelCaseConverter.converter("AleXandre NILton SiX MaToS BeLem"));
	}
	
	@Test
	public void deveConverteNomeComposto2() throws Exception {
		assertEquals("O'rielly Pub Brasilia Center", camelCaseConverter.converter("O'rielly pub brAsiliA cEnTER"));
	}
}
