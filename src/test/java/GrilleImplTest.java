import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
public class GrilleImplTest{ 
  static final char M = '.';
  GrilleImpl grid = new GrilleImpl();
  @Test
  public void GetDimensionTest() {
    assertEquals(9, grid.getDimension());	
  }
  
  @Test
  public void setValueTest() {
    grid.setValue(2, 2, '9');
  } 
  /** Déclaration de l'exception. */
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  /** Test de la methode division cas ou b vaut 0. */
  @Test
  public void setValueTest2() { 
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("x est hors bornes (0-8)");
	grid.setValue(9, 3, '7');
  }
 
  @Test
  public void setValueTest3() { 
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("y est hors bornes (0-8)");
	grid.setValue(3, 9, '7');
  }
 
  @Test
  public void setValueTest4() { 
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("value n'est pas un caractere autorise");
	grid.setValue(3, 3, '-');
  } 
 
  @Test
  public void setValueTest5() { 
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("la valeur est interdite aux vues des autres valeurs de la grille");
	grid.setValue(0, 8, '9');
  }  

  @Test
  public void getValueTest() {  
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("x est hors bornes (0-8)");
	grid.getValue(9, 3);
  } 
  @Test
  public void getValueTest1() {  
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("y est hors bornes (0-8)");
	grid.getValue(3, 9);
  } 
  /**  
  @Test
  public void getValueTest3() {  
    assertArrayEquals('6', grid.getValue(0, 7));	
  } */
  
  @Test
  public void possibleTest1() {  
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("x est hors bornes (0-8)");
	grid.possible(9, 3, '8');
  } 
  @Test
  public void possibleTest2() {  
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("y est hors bornes (0-8)");
	grid.possible(3, 9, '8');
  } 
  @Test
  public void possibleTest3() {  
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("La value n'est pas un caractere autorise");
	grid.possible(3, 9, 'z');
  }
  
  @Test
  public void possibleTest4() {  
    assertTrue(grid.possible(2, 2, '7'));
  } 
  @Test
  public void possibleTest5() {
    assertFalse(grid.possible(2, 2, '4'));
  }
  
  @Test
  public void checkColumnTest() {  
    assertTrue(grid.checkColumn(2, '6'));
  }
  @Test
  public void checkColumnTest1() {  
    assertFalse(grid.checkColumn(2, '7'));
  } 
  
  @Test
  public void checkLineTest() {  
    assertTrue(grid.checkLine(2, '6'));
  }
/**  @Test
  public void checkLineTest2() {  
	//assertFalse(GrilleImpl.checkLine(2, '6'));
	boolean bool = GrilleImpl.checkLine(2, '7');
	assertFalse(bool);
  } 
  */
  @Test
  public void checkSquareTest() {  
    assertTrue(grid.checkSquare(2, 2, '2'));
  }
  @Test
  public void checkSquareTest1() {  
    assertFalse(grid.checkSquare(2, 2, '7'));
  } 
  
  @Test
  public void completeTest() {  
    char[][] grilleComplete = new char[][]{
    {'9', '4', '1', '5', '3', '8', '7', '6', '2'},
    {'3', '6', '8', '9', '7', '2', '4', '5', '1'},
    {'2', '5', '7', '6', '1', '4', '8', '3', '9'},
    
    {'1', '2', '9', '4', '5', '6', '3', '8', '7'},
    {'6', '7', '4', '8', '9', '3', '2', '1', '5'},
    {'5', '8', '3', '1', '2', '7', '6', '9', '4'},
    
    {'8', '9', '6', '7', '4', '1', '5', '2', '3'},
    {'4', '1', '2', '3', '8', '5', '9', '7', '6'},
    {'7', '3', '5', '2', '6', '9', '1', '4', '8'}
	};
	GrilleImpl grid = new GrilleImpl(grilleComplete);
    assertTrue(grid.complete());	
  }
  
}
