package nl.tudelft.ir.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is responsible with configuring the project.  
 * @author mcadariu
 *
 */

public class Config {
	
	/*
	 * This is a reference to the string that signifies the documents 
	 * path.
	 */
	private String docsPath;
	
	/*
	 *This is the path to the index.
	 */
	private String indexPath;
	private boolean create;

	public void readProp() throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();

		//load a properties file
		prop.load(new FileInputStream("/tmp/config.properties"));

		//get the property value and print it out
		setDocsPath(prop.getProperty("docsPath"));
		setIndexPath(prop.getProperty("indexPath"));
		setCreate(Boolean.parseBoolean(prop.getProperty("update")));


	}

	public void writeProp(String docsPath, String indexPath, boolean create) throws FileNotFoundException, IOException
	{
		Properties prop = new Properties();


		//set the properties value
		prop.setProperty("docsPath", docsPath);
		prop.setProperty("indexPath", indexPath);
		prop.setProperty("update", Boolean.toString(create));

		//save properties to project root folder
		prop.store(new FileOutputStream("/tmp/config.properties"), null);


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

}