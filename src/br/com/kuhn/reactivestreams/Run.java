package br.com.kuhn.reactivestreams;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

import br.com.kuhn.reactivestreams.common.NotaFiscal;
import br.com.kuhn.reactivestreams.common.WebServiceClient;
import br.com.kuhn.reactivestreams.custom.NotaFiscalSubscriber;

public class Run {

	static NotaFiscal n1 = new NotaFiscal("Jardel", 39.99, LocalDate.now());
	static NotaFiscal n2 = new NotaFiscal("Anakin", 29.99, LocalDate.now());
	static NotaFiscal n3 = new NotaFiscal("Ragnar", 19.99, LocalDate.now());

	public static void main(String[] args) {
		send();
		customSubscriber();
	}

	private static void customSubscriber() {
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();

		publisher.subscribe(subscriber);
		publisher.submit(n1);
		publisher.submit(n2);
		publisher.submit(n3);

		System.out.println("Notas serão enviadas por e-mail");

		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();

		publisher.close();
	}

	private static void send() {
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>();
		
		WebServiceClient wsClient = new WebServiceClient();
		publisher.consume(wsClient::send);
		publisher.submit(n1);
		publisher.submit(n2);
		publisher.submit(n3);
		
		System.out.println("Notas serão enviadas por e-mail");
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}

}
