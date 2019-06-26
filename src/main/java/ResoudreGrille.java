/**
* Permet de resoudre une grille de sudoku .
*/
public final class ResoudreGrille {
  /**
   * Pour cacher le contructeur.
   */
  private ResoudreGrille() { }
  /**
   * Point d'entrée du programe.
   * @param args liste d'argument
   */
  public static void main(final String[] args) {
    GrilleImpl lagrille = new GrilleImpl();
    System.out.println("Grille de sudoku à résoudre!");
    lagrille.displayGrille();
    System.out.println("                        ");
    System.out.println("Grille de sudoku résolu!");
    long start = System.currentTimeMillis();
    lagrille.resoudre();
    long end = System.currentTimeMillis();
    lagrille.displayGrille();
  }
}
