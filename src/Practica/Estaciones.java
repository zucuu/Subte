package Practica;

public class Estaciones {
	public static void main(String[] args) {
	
	String []Estaciones = {"Las Heras", "Santa Fe", "Cordoba", "Corrientes", "Once", "Venezuela", "Humberto", "Inclan", "Caseros", "Patricios", "Hospitales"};
	String EstacionActual = null;
	String EstacionDestino = null;
	String RtaIngreso = null;
	int IndiceActual = -1, IndiceDestino = -1;
	
	ObjetoRobot obj = new ObjetoRobot();
	
	while (obj.PedirNuevamente){
		System.out.println("Ingrese la estación en la que se encuentra:");
		EstacionActual = obj.LeerTexto();
		
		obj.PedirNuevamente = true;
		for (int i = 0; i < Estaciones.length; i++){
			if (EstacionActual.equalsIgnoreCase(Estaciones[i])){
				obj.PedirNuevamente = false;
				IndiceActual = i;
			}				
		}
		if (obj.PedirNuevamente) {
			System.out.println("La estación no existe.");
		}
	}
	obj.PedirNuevamente = true;
	
	while (obj.PedirNuevamente){
		System.out.println("Ingrese la estación a la que se dirige:");
		EstacionDestino = obj.LeerTexto();
		
		obj.PedirNuevamente = true;		
		if (EstacionDestino.equalsIgnoreCase(EstacionActual)){
			System.out.println("Ya se encuentra en esa estación. Por favor ingrese otra.");
		}
		else 
		{
			for (int i = 0; i < Estaciones.length; i++){
				if (EstacionDestino.equalsIgnoreCase(Estaciones[i])){
					obj.PedirNuevamente = false;
					IndiceDestino = i;
				}				
			}
			if (obj.PedirNuevamente) {
				System.out.println("La estación no existe.");
			}
		}		
	}
	
	do {
		System.out.println("El subte ha llegado a la estación " + Estaciones[IndiceActual] + "." );
		System.out.println("El subte abrió sus puertas. ¿Desea ingresar? Si/No");
		RtaIngreso = obj.LeerTexto();
		if (!RtaIngreso.equalsIgnoreCase("si") && !RtaIngreso.equalsIgnoreCase("no"))
		{
			System.out.println("La respuesta ingresada es incorrecta.");
		}
		System.out.println("El subte cerró sus puerta.");
	}while (RtaIngreso.equalsIgnoreCase("si") == false);	
	
	if (IndiceActual < IndiceDestino){
		for (int i = (IndiceActual+1); i <= IndiceDestino; i++){
			System.out.println("Usted está en la estación " + Estaciones[i] + ".");
		}
	}
	else {
		for (int i = (IndiceActual-1); i >= IndiceDestino; i--){
			System.out.println("Usted está en la estación " + Estaciones[i] + ".");
		}
	}
	
	System.out.println( "¡¡Gracias por viajar con Codo a Codo!!");
		
	}
}