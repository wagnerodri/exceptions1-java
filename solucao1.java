package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class solucao1 {

	/*
	 * quando voce ja tem um metodo main. E dentro dele voce uma chamada de metodo
	 * que lançar uma e sessao "ParseExcepition" ou voce deve tratar essa Date
	 * checkIn = sfd.parse(sc.next()); que seria o clainket ou simplesmente voce
	 * propaga essa e sessao colocando a palavra throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sfd.parse(sc.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sfd.parse(sc.next());

		/* para testa se a data do check-out nao e posterior ao check-in */
		if (!checkOut.after(checkIn)) {
			/* after testa se uma data e depois da outra */
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			/* caso contrario instanciei a minha reserva */
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sfd.parse(sc.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sfd.parse(sc.next());

				/* Agora o reservation.updateDates vai me retorna uma string e esse string que vai me dizer se aconteceu erro ou nao  */
				String error = reservation.updateDates(checkIn, checkOut);
				if(error  != null) {
					System.out.println("Error in reservation: " + error);
				}
				else {
				System.out.println("Reservation " + reservation);
			}

		}

		sc.close();

	}

}
