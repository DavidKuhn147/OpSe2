package reader;

import java.io.FileNotFoundException;

public class ConcreteCSVReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return new ConcreteCSVReaderProduct();
	}
	
}
