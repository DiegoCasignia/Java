package traductor;

/**
 *
 * @author Diego Casignia
 */
public class TraduccionObj {
    private String textoOriginal;
    private String textoTraducido;
    private String idiomaOrigen;
    private String idiomaDestino;
    private String urlImagen;

    public TraduccionObj(String textoOriginal, String textoTraducido, String idiomaOrigen, String idiomaDestino, String urlImagen) {
        this.textoOriginal = textoOriginal;
        this.textoTraducido = textoTraducido;
        this.idiomaOrigen = idiomaOrigen;
        this.idiomaDestino = idiomaDestino;
        this.urlImagen = urlImagen;
    }
    
    public TraduccionObj() {
        textoOriginal = "";
        textoTraducido = "";
        idiomaOrigen = "";
        idiomaDestino = "";
        urlImagen = "";
    }

    public String getTextoOriginal() {
        return textoOriginal;
    }

    public void setTextoOriginal(String textoOriginal) {
        this.textoOriginal = textoOriginal;
    }

    public String getTextoTraducido() {
        return textoTraducido;
    }

    public void setTextoTraducido(String textoTraducido) {
        this.textoTraducido = textoTraducido;
    }

    public String getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public void setIdiomaOrigen(String idiomaOrigen) {
        this.idiomaOrigen = idiomaOrigen;
    }

    public String getIdiomaDestino() {
        return idiomaDestino;
    }

    public void setIdiomaDestino(String idiomaDestino) {
        this.idiomaDestino = idiomaDestino;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
