public class Sportello implements Runnable {
    private ListaClienti listaClienti;
    private final int minTempoServizio = 2000;
    private final int maxTempoServizio = 8000;

    public Sportello(ListaClienti listaClienti) {
        this.listaClienti = listaClienti;
    }

    public void run() {
        try{
            while(!Thread.interrupted()) {
                Integer clienteServito = listaClienti.rimuoviCliente();

                System.out.println("Chiamato cliente numero \t " + clienteServito);

                int tempoServizio = (int) (Math.random() * (maxTempoServizio - minTempoServizio + 1) + minTempoServizio);

                Thread.sleep(tempoServizio);

                System.out.println("Servito cliente numero \t " + clienteServito);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Sportello chiuso");
        }
    }
}
