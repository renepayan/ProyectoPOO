public class Notificador extends Thread {

	private String nombre;
	private String mensaje;
	private long initialTime;

	// Constructor, getter & setter
	public Notificador(String nombre, String mensaje, long initialTime){
		this.nombre=nombre;
		this.mensaje=mensaje;
		this.initialTime= initialTime;
	}

	@Override
	public void run() {
	
		for(int i = 1;i<=100;i++){
			System.out.println(mensaje+ " "+i+ "%");
			this.esperarXsegundos(1);
		}
		
	}

	public void setMensaje(String mensaje){
		this.mensaje=mensaje;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 20);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
