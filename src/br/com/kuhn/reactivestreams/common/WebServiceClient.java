package br.com.kuhn.reactivestreams.common;

public class WebServiceClient {

	public void send(NotaFiscal nf) {
		try {
			System.out.println("Emitindo nota fiscal");
			Thread.sleep(5000);
			System.out.println("Nota fiscal emitida " + nf.toString());
			System.out.println("A thread: " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
