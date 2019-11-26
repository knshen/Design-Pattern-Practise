package reponse.chain;

public interface IHandler {
	void setNextHandler(IHandler handler);
	
	void handle();
}
