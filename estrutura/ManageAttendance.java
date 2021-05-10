package estrutura;

public class ManageAttendance {
	
	private Client[] newer;
	private Client[] older;
	private int endNewer;
	private int endOlder;

	public ManageAttendance(int size) {
		newer = new Client[size];
		older = new Client[size];
		endNewer = 0;
		endOlder = 0;
	}
	
	public boolean isEmpty() {
		if (endNewer == 0 && endOlder == 0)
			return true;
		return false;
	}
	
	public int numClients() {
		return endNewer + endOlder;
	}
	
	public int numEldelyClients() {
		return endOlder;
	}
	
	public void addClient(Client cli) {
		// Se sua idade for maior que 60 anos adicione na fila preferencial.
		if (cli.getAge() >= 60) {
			if (endOlder == older.length) {
				System.out.println("A fila de idoso está cheia!");
				return;
			}
			older[endOlder] = cli;
			endOlder++;
		}
		else {
			if (endNewer == newer.length) {
				System.out.println("A fila está cheia!");
				return;
			}
			newer[endNewer] = cli;
			endNewer++;
		}
	}
	
	public Client showNext() {
		if(!isEmpty()) {
			// Se possuir idosos na fila pegue o idoso.
			if(endOlder > 0)
				return older[0];
			
			return newer[0];
		}
		return null;
	}
	
	public Client getNext() {
		if(!isEmpty()) {
			
			// Se possuir idosos na fila pegue o idoso.
			if(endOlder > 0) {
				Client aux = older[0];
				for(int i=0; i<endOlder-1;i++) {
					this.older[i] = this.older[i+1];
				}
				this.endOlder--;
				return aux;
			}
			
			else {
				Client aux = newer[0];
				for(int i=0; i<endNewer-1;i++) {
					this.newer[i] = this.newer[i+1];
				}
				this.endNewer--;
				return aux;
			}
			
		}
		return null;
	}
	
	public String showQueues() {
		String clients = "idoso:";
		
		if(endOlder == 0)
			clients = clients + "vazio";
		for(int i=0; i<endOlder;i++) {
			clients = clients + older[i].getName() + ":" + older[i].getAge() + "-";
		}
		
		clients = clients + "; normal: ";
		
		if(endNewer == 0)
			clients = clients + "vazio";
		for(int i=0;i<endNewer;i++) {
			clients = clients + newer[i].getName() + ":" + newer[i].getAge() + "-";
		}
		
		return clients;
	}
	
}
