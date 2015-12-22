package net.antra.log4j;
import org.apache.log4j.*;

public class TestLog4j {
	private static final Logger LOGGER = Logger.getLogger(TestLog4j.class);
	public static void main(String[] args) {
		go();
	}
	private static void go(){
		LOGGER.debug("Inside go method");
		LOGGER.error("Here is an error!");
		LOGGER.debug("Exit go method");
		LOGGER.info("TEst");
	}
}
