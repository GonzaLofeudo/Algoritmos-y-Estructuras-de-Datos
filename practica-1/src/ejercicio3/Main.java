package ejercicio3;

public class Main {

	public static void main(String[] args) {
		Estudiante[] vE = new Estudiante[2];
		Profesor[] vP = new Profesor[3];
		
		Estudiante e1 = new Estudiante("Gonzalo","Lofeudo","glofeudo@gmail.com",200,"137 N°1643");
		Estudiante e2 = new Estudiante("Mateo","Leyes","mleyes@gmail.com",201,"56 N°1509");
		
		Profesor p1 = new Profesor("Javier","Lofeudo","jlofeudo@gmail.com",1,"Facultad de Periodismo");
		Profesor p2 = new Profesor("Luciana","Mastrángelo","lmastra@gmail.com",3,"Facultad de Periodismo");
		Profesor p3 = new Profesor("Salvador","Bogani","sboga@gmail.com",10,"Facultad de Medicina");
		
		vE[0] = e1;
		vE[1] = e2;
		vP[0] = p1;
		vP[1] = p2;
		vP[2] = p3;
		
		for (int i = 0; i < 2; i++)
			System.out.println(vE[i].tusDatos());
		
		for (int i = 0; i < 3; i++)
			System.out.println(vP[i].tusDatos());
	}
}
