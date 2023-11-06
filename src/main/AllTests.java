package main;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ InicializarTest.class, VerificarMediaTest.class, CriarAlunoTest.class})
public class AllTests {

}
