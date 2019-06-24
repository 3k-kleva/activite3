/**
 * Implementation d'une grille .
 */
public class GrilleImpl implements Grille {
  /** Déclaration de constante. */
  private static final int NEUF = 9;
 /**
  * Caractere de case vide.
  */
 public static final char EMPTY = '@';
 /**
  * Caractere possible a mettre dans la grille.
  * pour une grille 9x9 : 1..9
  * pour une grille 16x16: 0..9-a..f
  */
  private static final char[] POSSIBLE = new char[]
  {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
  /** Tableau de caracteres à deux dimension .*/
  private static final char[][] GRILLE_A_RESOUDRE = new char[][] {
    {'@', '@', '@', '@', '3', '@', '@', '6', '2'},
    {'@', '@', '@', '@', '7', '2', '@', '@', '1'},
    {'2', '@', '@', '6', '@', '@', '8', '@', '@'},
    {'@', '@', '@', '4', '5', '6', '3', '8', '7'},
    {'6', '7', '4', '@', '@', '@', '2', '@', '@'},
    {'5', '8', '@', '1', '@', '7', '6', '@', '4'},
    {'@', '@', '6', '@', '@', '1', '@', '@', '3'},
    {'4', '@', '@', '3', '8', '@', '@', '@', '@'},
    {'7', '3', '@', '@', '6', '@', '@', '@', '@'}
    };
  /** Déclaration d'un exemple de grille. */
  private char[][] grille;
  /**
   * Constructeur Grille .
   */
  public GrilleImpl() {
    this.grille = new char[NEUF][NEUF];
    for (int i = 0; i < NEUF; i++) {
      for (int j = 0; j < NEUF; j++) {
        this.grille[i][j] = GRILLE_A_RESOUDRE[i][j];
      }
    }
  }
  /**
   * Constructeur Grille avec argument .
   * @param tab est une grille
   */
  public GrilleImpl(final char[][] tab) {
    this.grille = new char[NEUF][NEUF];
    for (int i = 0; i < NEUF; i++) {
      for (int j = 0; j < NEUF; j++) {
        this.grille[i][j] = tab[i][j];
      }
    }
  }
  /**
   * Accesseur de grille.
   * @param x est entier
   * @param y est un entier
   * @return retourne la grile
   */
  public final char getGrille(final int x, final int y) {
    return grille[x][y];
  }
  /**
   * Mutateur de grille.
   * @param x est entier
   * @param y est un entier
   * @param nouvGrille est un caractere
   */
  public final void setGrille(final int x, final int y, final char nouvGrille) {
    grille[x][y] = nouvGrille;
  }
  /**
   * @return largeur/hauteur de la grille 9 ou 16 .
   */
  public final int getDimension() {
    return grille.length;
  }
  /**
   * Test la presence de la valeur dans le tableau.
   * @param value       valeur à rechercher dans le tableau
   * @return vrai si la valeur est presente sinon faux
   */
  public final boolean checkCaractere(final char value) {
    for (int x = 0; x < NEUF; x++) {
      if (this.POSSIBLE[x] == value) {
        return true;
      }
    }
    return false;
  }
  /**
   * Test la presence de la valeur dans la colonne.
   * @param y       position y dans la grille
   * @param value       valeur à rechercher dans la grille
   * @return vrai si la valeur est presente sinon faux
   */
  public final boolean checkColumn(final int y, final char value) {
    for (int x = 0; x < NEUF; x++) {
      if (this.grille[x][y] == value) {
        return true;
      }
    }
    return false;
  }
  /**
   * Test la presence de la valeur sur la ligne.
   * @param x       position x dans la grille
   * @param value       valeur à rechercher dans la grille
   * @return vrai si la valeur est presente sinon faux
   */
  public final boolean checkLine(final int x, final char value) {
    for (int y = 0; y < NEUF; y++) {
      if (this.grille[x][y] == value) {
        return true;
      }
    }
    return false;
  }
  /**
   * Test la presence de la valeur dans le carré.
   * @param x       position x dans la grille
   * @param y       position y dans la grille
   * @param value       valeur à rechercher dans la grille
   * @return vrai si la valeur est presente sinon faux
   */
  public final boolean
  checkSquare(final int x, final int y, final char value) {
    int dimenssion = grille.length;
    int leftpoint = 0;
    int toppoint = 0;
    final int q = 3;
    final int dim = 9;
    if (dimenssion == dim) {
      leftpoint = q * (y / q);
      toppoint = q * (x / q);
    }
    for (int c = leftpoint; c < leftpoint + q; c++) {
      for (int l = toppoint; l < toppoint + q; l++) {
        if (grille[l][c] == value) {
          return true;
        }
      }
    }
    return false;
  }
 /**
  * Affecte une valeur dans la grille.
  * @param x       position x dans la grille
  * @param y       position y dans la grille
  * @param value
  *            valeur a mettre dans la case
  * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
  * @throws IllegalArgumentException si la valeur est interdite aux vues des
  *        autres valeurs de la grille
  * @throws IllegalArgumentException si value n'est pas un caractere autorise
  *        ('1',...,'9')
  */
  public final void setValue(final int x, final int y, final char value) {
    //int dimenssion = grille.length;
    //boolean cont = false;
    //cont = Arrays.toString(POSSIBLE).contains(Character.toString(value));
    if (checkCaractere(value)) {
    //verification
    if ((x >= NEUF) || (x < 0)) {
        throw new IllegalArgumentException("x est hors bornes (0-8)");
    } else if ((y >= NEUF) || (y < 0)) {
          throw new IllegalArgumentException("y est hors bornes (0-8)");
        } else if ((!checkColumn(y, value)) && (!checkLine(x, value))
            && (!checkSquare(x, y, value)) && !(grille[x][y] == EMPTY)) {
            throw new IllegalArgumentException("la valeur est interdite "
                     + "aux vues des autres valeurs de la grille");
            } else {
              grille[x][y] = value;
            }
    } else {
        throw new IllegalArgumentException("La value n'est"
                               + " pas un caractere autorise");
      }
  }
 /**
  * Recupere une valeur de la grille.
  * @param x      position x dans la grille
  * @param y      position y dans la grille
  * @return valeur dans la case x,y
  * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
  */
  public final char getValue(final int x, final int y) {
    if ((x >= NEUF) || (x < 0)) {
       throw new IllegalArgumentException("x est hors bornes (0-8)");
    } else if ((y >= NEUF) || (y < 0)) {
          throw new IllegalArgumentException("y est hors bornes (0-8)");
        }
    return grille[x][y];
  }
  /**
   * Test si une grille est terminee.
   * @return true si la grille est complete
   */
   public final boolean complete() {
     for (int i = 0; i < NEUF; i++) {
        for (int j = 0; j < NEUF; j++) {
          if (grille[i][j] == EMPTY) {
            return false;
          }
        }
     }
     return true;
   }
 /**
  * Test si une valeur est possible dans la grille par rapport a ce qu'elle .
  * contient deja
  * @param x     position x dans la grille
  * @param y     position y dans la grille
  * @param value a mettre dans la case
  * @throws IllegalArgumentException si x ou y sont hors bornes (0-8)
  * @throws IllegalArgumentException si value n'est pas un caractere autorise
  *        ('1',...,'9',..)
  * @return true si c'est une valeur possible
  */
  public final boolean possible(final int x, final int y, final char value) {
    //boolean cont = false;
    //cont = Arrays.toString(POSSIBLE).contains(Character.toString(value));
    if (checkCaractere(value)) {
      //verification
      if ((x >= NEUF) || (x < 0)) {
        throw new IllegalArgumentException("x est hors bornes (0-8)");
      }
      if ((y >= NEUF) || (y < 0)) {
          throw new IllegalArgumentException("y est hors bornes (0-8)");
      }
      return ((!checkColumn(y, value)) && (!checkLine(x, value))
                  && (!checkSquare(x, y, value)));
    } else {
        throw new IllegalArgumentException("La value n'est pas "
        + "un caractere autorise");
      }
  }
  /**
  * La méthode affiche la grille .
  */
  public final void displayGrille() {
    for (int l = 0; l < NEUF; l++) {
      for (int c = 0; c < NEUF; c++) {
        System.out.print(grille[l][c] + " ");
      }
      System.out.println("                  ");
    }
  }
  /** La fonction resoud la grille.
   * @return true si la grille est résolue
   */
  public final boolean resoudre() {
    for (int l = 0; l < NEUF; l++) {
      for (int c = 0; c < NEUF; c++) {
        if (this.grille[l][c] == EMPTY) {
            // On parcours les valeurs possibles
            for (int v = 0; v < NEUF; v++) {
              // Si la valeur est possible on l'essai
              if (possible(l, c, POSSIBLE[v])) {
                //this.setValue(l, c, POSSIBLE[v]);
                this.grille[l][c] = POSSIBLE[v];
                if (resoudre()) {
                  return true;
                } else {
                   this.grille[l][c] = EMPTY;
                }
            }
            }
            return false;
        }
      }
    }
    return true;
  }
}
