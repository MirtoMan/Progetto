package it.unical.kindled.reader;



import java.util.List;

public class BookReader {
    private List<String> pagine;
    private int pagina_corrente=0;



    public void apri_libro (String text){
        pagine=Paginazione.split(text);
        pagina_corrente=0;
    }


    public void Pag_succ(){
        if (pagine == null)
            throw new IllegalStateException("Libro non aperto");

        if (pagina_corrente >= pagine.size() - 1)
            throw new IndexOutOfBoundsException("Sei già all'ultima pagina");

        pagina_corrente++;
    }

    public void Pag_prec(){
        if (pagine == null)
            throw new IllegalStateException("Libro non aperto");

        if (pagina_corrente == 0)
            throw new IndexOutOfBoundsException("Siammo gia alla prima pagina");

        pagina_corrente--;
    }

    public void Vai_a(int pagina){
        if (pagine == null)
            throw new IllegalStateException("Libro non aperto");
        if(pagina<0 || pagina>=pagine.size()-1)
            throw new IndexOutOfBoundsException("La pagina non esiste");
        pagina_corrente = pagina;
    }

    public int getPag(){
        return pagina_corrente;
    }

    public String getPaginaCorrente() {

        if (pagine == null)
            throw new IllegalStateException("Libro non aperto");

        if (pagine.isEmpty())
            throw new IllegalStateException("Libro vuoto");

        return pagine.get(pagina_corrente);
    }




}
