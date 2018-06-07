/**This is the biggest shit
 * 
 */
import numbers.*;
import mathExceptions.ExDivisionPorCero;

public class Fraccion
{
    private Real numerador;
    private Real denominador;
    private boolean esFraccion;

    private boolean irracional;

    public Fraccion(Real num, Real den) throws ExDivisionPorCero {
        if (den.getNumero() == 0) {
            throw new ExDivisionPorCero();
        } else {
            numerador = num;
            denominador = den;
            simplificar();
        }
    }

    public void simplificar() {
        if (numerador.esIrracional() && !numerador.esTranscendental()) {
            if (denominador.esIrracional() || denominador.esTranscendental()) {
                int indice = ((Irracional)numerador).getIndice();
                
            } else {
                
            }
        }
        if (!(numerador.type() == "I" && denominador.type() == "I")) {
            //Numerador y denominador son fraccionarios.
            //Utilizaremos la representación de enteros y naturales como n/1
            if (numerador instanceof Fraccionario) {
                numerador = (Fraccionario)numerador;
            } else {
                numerador = numerador.convertToQ();
            }
            if (denominador instanceof Fraccionario) {
                denominador = (Fraccionario)denominador;
            } else {
                denominador = denominador.convertToQ();
            }
            
            int num = ((Fraccionario)numerador).getNumerador() * ((Fraccionario)denominador).getDenominador();
            int den = ((Fraccionario)numerador).getDenominador() * ((Fraccionario)denominador).getNumerador();
            int mcd = Fraccionario.mcd(num, den);
            num /= mcd;
            den /= mcd;
            numerador = new Entero(num);
            denominador = new Entero(den);
            esFraccion = (den == 1);
        }
    }

    public boolean esFraccion() { return esFraccion; }
    
    /** Precondicion: esFraccion() == true */
    public Real devolverNumero() { return numerador; }
}
