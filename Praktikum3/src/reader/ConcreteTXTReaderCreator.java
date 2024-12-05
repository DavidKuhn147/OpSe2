package reader;

import java.io.FileNotFoundException;

public class ConcreteTXTReaderCreator extends ReaderCreator{

	@Override
	public ReaderProduct factoryMethod() throws FileNotFoundException {
		// TODO Auto-generated method stub
		return new ConcreteTXTReaderProduct();
	}

}
