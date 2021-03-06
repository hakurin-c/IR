package nl.tudelft.ir.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private String docsPath;
	private String indexPath;
	private boolean create;
	private boolean spellCheck;

	public void readProp() throws FileNotFoundException, IOException {
		Properties prop = new Properties();

		// load a properties file
		prop.load(new FileInputStream("config.properties"));

		// get the property value and print it out
		setDocsPath(prop.getProperty("docsPath"));
		setIndexPath(prop.getProperty("indexPath"));
		setCreate(Boolean.parseBoolean(prop.getProperty("update")));
		setSpellCheck(Boolean.parseBoolean(prop.getProperty("spell")));

	}

	public void writeProp(String docsPath, String indexPath, boolean create, boolean spell)
			throws FileNotFoundException, IOException {
		Properties prop = new Properties();

		// set the properties value
		prop.setProperty("docsPath", docsPath);
		prop.setProperty("indexPath", indexPath);
		prop.setProperty("update", Boolean.toString(create));
		prop.setProperty("spell", Boolean.toString(spell));


		// save properties to project root folder
		prop.store(new FileOutputStream("config.properties"), null);

	}

	public String getDocsPath() {
		return docsPath;
	}

	public void setDocsPath(String docsPath) {
		this.docsPath = docsPath;
	}

	public String getIndexPath() {
		return indexPath;
	}

	public void setIndexPath(String indexPath) {
		this.indexPath = indexPath;
	}

	public boolean isCreate() {
		return create;
	}

	public void setCreate(boolean create) {
		this.create = create;
	}

	public boolean isSpellCheck() {
		return spellCheck;
	}

	public void setSpellCheck(boolean spellCheck) {
		this.spellCheck = spellCheck;
	}

}
